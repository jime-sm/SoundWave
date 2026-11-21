package com.mycompany.soundwave.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InicializadorDB {

    public static void iniciar() throws SQLException, IOException {
        Connection con = ConexionDB.getInstancia().getConexion();
        crearTablas(con);
        if (estaVacia(con, "cancion")) {
            cargarCSV(con);
        }
    }

    private static void crearTablas(Connection con) throws SQLException, IOException {
        try (InputStream in = InicializadorDB.class.getResourceAsStream("/schema.sql")) {
            if (in == null) {
                throw new IOException("No se encontró schema.sql en src/main/resources");
            }
            String sql = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            try (Statement st = con.createStatement()) {
                for (String s : sql.split(";")) {
                    if (!s.trim().isEmpty()) {
                        st.execute(s);
                    }
                }
            }
        }
    }

    private static boolean estaVacia(Connection con, String tabla) throws SQLException {
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM " + tabla)) {
            return rs.next() && rs.getInt(1) == 0;
        }
    }

    private static void cargarCSV(Connection con) throws SQLException, IOException {
        InputStream in = InicializadorDB.class.getResourceAsStream("/data.csv");
        if (in == null) {
            throw new IOException("No se encontró data.csv en src/main/resources");
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            String primera = br.readLine();
            if (primera == null) {
                throw new IOException("El archivo data.csv está vacío");
            }
            if (primera.startsWith("\uFEFF")) {
                primera = primera.substring(1);
            }
            List<String> cab = parsear(primera);
            int iTitulo = cab.indexOf("song_title");
            int iArtista = cab.indexOf("artist");
            int iDuracion = cab.indexOf("duration_ms");
            if (iTitulo < 0 || iArtista < 0 || iDuracion < 0) {
                throw new IOException("El CSV debe tener las columnas song_title, artist y duration_ms");
            }
            int maxIdx = Math.max(iTitulo, Math.max(iArtista, iDuracion));

            con.setAutoCommit(false);
            try (PreparedStatement psA = con.prepareStatement(
                         "INSERT OR IGNORE INTO artista(nombre) VALUES (?)");
                 PreparedStatement psC = con.prepareStatement(
                         "INSERT OR IGNORE INTO cancion(titulo, artista_id, duracion_seg) "
                         + "VALUES (?, (SELECT id FROM artista WHERE nombre = ?), ?)")) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.isBlank()) {
                        continue;
                    }
                    List<String> c = parsear(linea);
                    if (c.size() <= maxIdx) {
                        continue;
                    }
                    try {
                        String titulo = c.get(iTitulo).trim();
                        String artista = c.get(iArtista).trim();
                        if (titulo.isEmpty() || artista.isEmpty()) {
                            continue;
                        }
                        int segundos = Integer.parseInt(c.get(iDuracion).trim()) / 1000;
                        psA.setString(1, artista);
                        psA.executeUpdate();
                        psC.setString(1, titulo);
                        psC.setString(2, artista);
                        psC.setInt(3, segundos);
                        psC.executeUpdate();
                    } catch (NumberFormatException e) {
                        // fila con numeros invalidos: se omite
                    }
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }

    private static List<String> parsear(String linea) {
        List<String> r = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean comillas = false;
        for (int i = 0; i < linea.length(); i++) {
            char ch = linea.charAt(i);
            if (ch == '"') {
                if (comillas && i + 1 < linea.length() && linea.charAt(i + 1) == '"') {
                    sb.append('"');
                    i++;
                } else {
                    comillas = !comillas;
                }
            } else if (ch == ',' && !comillas) {
                r.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(ch);
            }
        }
        r.add(sb.toString());
        return r;
    }
}
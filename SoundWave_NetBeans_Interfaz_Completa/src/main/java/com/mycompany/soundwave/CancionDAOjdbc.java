package com.mycompany.soundwave;



import com.mycompany.soundwave.db.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CancionDAOjdbc implements CancionDAO {

    @Override
    public List<Canciones> buscar(String texto) throws SQLException {
        String sql = "SELECT c.titulo, a.nombre, c.duracion_seg / 60.0, c.reproducciones "
                + "FROM cancion c JOIN artista a ON a.id = c.artista_id "
                + "WHERE c.titulo LIKE ? OR a.nombre LIKE ? ORDER BY c.titulo LIMIT 1000";
        List<Canciones> lista = new ArrayList<>();
        Connection con = ConexionDB.getInstancia().getConexion();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            String patron = "%" + texto + "%";
            ps.setString(1, patron);
            ps.setString(2, patron);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Canciones(rs.getString(1), rs.getString(2),
                            rs.getDouble(3), rs.getInt(4)));
                }
            }
        }
        return lista;
    }

    @Override
    public void registrarReproduccion(String titulo, String artista) throws SQLException {
        String sql = "UPDATE cancion SET reproducciones = reproducciones + 1 "
                + "WHERE titulo = ? AND artista_id = (SELECT id FROM artista WHERE nombre = ?)";
        Connection con = ConexionDB.getInstancia().getConexion();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, titulo);
            ps.setString(2, artista);
            ps.executeUpdate();
        }
    }
}

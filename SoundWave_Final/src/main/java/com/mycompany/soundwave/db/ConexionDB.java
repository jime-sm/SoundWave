package com.mycompany.soundwave.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static ConexionDB instancia;
    private final Connection conexion;

    private ConexionDB() throws SQLException {
        conexion = DriverManager.getConnection("jdbc:sqlite:soundwave.db");
    }

    public static synchronized ConexionDB getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}

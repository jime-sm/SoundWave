package com.mycompany.soundwave;


import java.sql.SQLException;
import java.util.List;

public interface CancionDAO {
    List<Canciones> buscar(String texto) throws SQLException;
    void registrarReproduccion(String titulo, String artista) throws SQLException;
}
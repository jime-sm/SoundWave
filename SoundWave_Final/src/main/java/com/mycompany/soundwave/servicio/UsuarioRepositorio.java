package com.mycompany.soundwave.servicio;
import com.mycompany.soundwave.Usuario;
import java.sql.SQLException;
import java.util.List;
/** DIP: el servicio depende de este contrato, no de JDBC. */
public interface UsuarioRepositorio {
 void registrar(Usuario usuario,String clave) throws SQLException;
 Usuario autenticar(String correo,String clave) throws SQLException;
 List<Usuario> listar() throws SQLException;
}

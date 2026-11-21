package com.mycompany.soundwave.servicio;
import com.mycompany.soundwave.Usuario;
import com.mycompany.soundwave.patrones.UsuarioFactory;
import java.sql.*;
import java.util.*;
/** Persistencia JDBC: consultas parametrizadas y recursos cerrados. */
public final class SqliteUsuarioRepositorio implements UsuarioRepositorio {
 private Connection conectar() throws SQLException {return DriverManager.getConnection("jdbc:sqlite:soundwave.db");}
 @Override public void registrar(Usuario u,String clave) throws SQLException {
  try(Connection c=conectar();PreparedStatement p=c.prepareStatement("INSERT INTO usuario(nombre,correo,contrasena,premium) VALUES(?,?,?,?)")){
   p.setString(1,u.getNombreUsuario());p.setString(2,u.getCorreo());p.setString(3,clave);p.setInt(4,u.obtenerTipoPlan().equals("Premium")?1:0);p.executeUpdate();
  }
 }
 @Override public Usuario autenticar(String correo,String clave) throws SQLException {
  try(Connection c=conectar();PreparedStatement p=c.prepareStatement("SELECT nombre,correo,premium FROM usuario WHERE lower(correo)=lower(?) AND contrasena=?")){
   p.setString(1,correo);p.setString(2,clave);
   try(ResultSet r=p.executeQuery()){return r.next()?UsuarioFactory.crear(r.getString(1),r.getString(2),r.getInt(3)==1):null;}
  }
 }
 @Override public List<Usuario> listar() throws SQLException {
  List<Usuario> usuarios=new ArrayList<>();
  try(Connection c=conectar();Statement st=c.createStatement();ResultSet r=st.executeQuery("SELECT nombre,correo,premium FROM usuario ORDER BY id DESC")){
   while(r.next())usuarios.add(UsuarioFactory.crear(r.getString(1),r.getString(2),r.getInt(3)==1));
  }return usuarios;
 }
}

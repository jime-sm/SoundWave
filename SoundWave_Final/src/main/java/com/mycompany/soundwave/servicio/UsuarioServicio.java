package com.mycompany.soundwave.servicio;
import com.mycompany.soundwave.Usuario;
import com.mycompany.soundwave.patrones.UsuarioFactory;
import java.sql.SQLException;
import java.util.List;
/** SRP: reglas de cuentas separadas de la ventana y de SQL. */
public final class UsuarioServicio {
 private final UsuarioRepositorio repositorio;
 public UsuarioServicio(UsuarioRepositorio repositorio){this.repositorio=repositorio;}
 public Usuario registrar(String nombre,String correo,String clave,boolean premium) throws RegistroException,SQLException {
  if(nombre==null||nombre.trim().length()<2)throw new RegistroException("El nombre debe tener al menos 2 caracteres.");
  if(correo==null||!correo.trim().matches("^[^\s@]+@[^\s@]+\\.[^\s@]+$"))throw new RegistroException("Escribe un correo electrónico válido.");
  if(clave==null||clave.length()<6)throw new RegistroException("La contraseña debe tener al menos 6 caracteres.");
  Usuario u=UsuarioFactory.crear(nombre,correo,premium);repositorio.registrar(u,clave);return u;
 }
 public Usuario ingresar(String correo,String clave) throws RegistroException,SQLException {
  if(correo==null||correo.isBlank()||clave==null||clave.isBlank())throw new RegistroException("Completa correo y contraseña.");
  Usuario u=repositorio.autenticar(correo.trim(),clave);
  if(u==null)throw new RegistroException("Correo o contraseña incorrectos.");return u;
 }
 public List<Usuario> listar() throws SQLException {return repositorio.listar();}
}

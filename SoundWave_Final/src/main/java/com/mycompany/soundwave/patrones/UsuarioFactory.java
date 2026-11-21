package com.mycompany.soundwave.patrones;
import com.mycompany.soundwave.*;
/** Factory Method sencillo: construye el subtipo según el plan. */
public final class UsuarioFactory {
 private UsuarioFactory(){}
 public static Usuario crear(String nombre,String correo,boolean premium){
  return premium?new UsuarioPremium(nombre,correo):new UsuarioGratuito(nombre,correo);
 }
}

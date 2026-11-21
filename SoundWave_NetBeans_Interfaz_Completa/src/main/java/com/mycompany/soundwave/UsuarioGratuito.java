package com.mycompany.soundwave;
public final class UsuarioGratuito extends Usuario {
 public UsuarioGratuito(String nombre,String correo){super(nombre,correo);}
 @Override public String obtenerTipoPlan(){return "Gratuito";}
 @Override public String beneficios(){return "Escucha con anuncios";}
}

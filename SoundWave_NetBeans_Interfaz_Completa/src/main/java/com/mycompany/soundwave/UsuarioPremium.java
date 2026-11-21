package com.mycompany.soundwave;
public final class UsuarioPremium extends Usuario {
 public UsuarioPremium(String nombre,String correo){super(nombre,correo);}
 @Override public String obtenerTipoPlan(){return "Premium";}
 @Override public String beneficios(){return "Escucha sin anuncios";}
}

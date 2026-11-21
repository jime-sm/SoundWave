package com.mycompany.soundwave;
/** Abstracción de una cuenta musical. */
public abstract class Usuario implements PlanMusical {
 private final String nombreUsuario, correo;
 protected Usuario(String nombre,String correo){
  if(nombre==null||nombre.isBlank()||correo==null||!correo.matches("^[^\s@]+@[^\s@]+\\.[^\s@]+$")) throw new IllegalArgumentException("Nombre o correo inválido");
  this.nombreUsuario=nombre.trim();this.correo=correo.trim().toLowerCase();
 }
 public final String getNombreUsuario(){return nombreUsuario;}
 public final String getCorreo(){return correo;}
 public abstract String obtenerTipoPlan();
 @Override public abstract String beneficios();
 public String mostrarPerfil(){return nombreUsuario+" · "+obtenerTipoPlan()+" · "+beneficios();}
}

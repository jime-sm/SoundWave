/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soundwave;

/**
 *
 * @author USUARIO
 */
public class Usuario {
    private String nombreUsuario;
    private String correo;
    private boolean cuentaPremium;

    public Usuario(String nombreUsuario, String correo, boolean cuentaPremium) {
        this.nombreUsuario = nombreUsuario;
        setCorreo(correo);
        this.cuentaPremium = cuentaPremium;
    }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) {
        if (correo != null && correo.contains("@")) {
            this.correo = correo;
        }
    }

    public boolean isCuentaPremium() { return cuentaPremium; }
    public void setCuentaPremium(boolean cuentaPremium) { this.cuentaPremium = cuentaPremium; }

    public void mostrarPerfil() {
        String tipoPlan = cuentaPremium ? "Premium" : "Gratuito";
        System.out.println("Usuario: " + nombreUsuario + " | Correo: " + correo + " | Plan: " + tipoPlan);
    }
}

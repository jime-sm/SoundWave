package com.mycompany.soundwave;

public class Usuario {

    private String nombreUsuario;
    private String correo;
    private String contrasena;
    private boolean cuentaPremium;

    // Constructor
    public Usuario(String nombreUsuario, String correo, String contrasena, boolean cuentaPremium) {
        this.nombreUsuario = nombreUsuario;
        setCorreo(correo);
        this.contrasena = contrasena;
        this.cuentaPremium = cuentaPremium;
    }

    // Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo != null && correo.contains("@")) {
            this.correo = correo;
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isCuentaPremium() {
        return cuentaPremium;
    }

    public void setCuentaPremium(boolean cuentaPremium) {
        this.cuentaPremium = cuentaPremium;
    }

    // Método para verificar el inicio de sesión
    public boolean iniciarSesion(String correoIngresado, String contrasenaIngresada) {
        return correo.equals(correoIngresado)
                && contrasena.equals(contrasenaIngresada);
    }

    // Mostrar información del usuario
    public void mostrarPerfil() {
        String tipoPlan = cuentaPremium ? "Premium" : "Gratuito";

        System.out.println("Usuario: " + nombreUsuario
                + " | Correo: " + correo
                + " | Plan: " + tipoPlan);
    }
}
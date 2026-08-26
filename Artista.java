/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soundwave;

/**
 *
 * @author USUARIO
 */
public class Artista {
    private String nombre;
    private String generoMusical;
    private int oyentesMensuales;
    
public Artista(String nombre, String generoMusical, int oyentesMensuales) {
        this.nombre = nombre;
        this.generoMusical = generoMusical;
        setOyentesMensuales(oyentesMensuales);   
    
}
public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getGeneroMusical() { return generoMusical; }
    public void setGeneroMusical(String generoMusical) { this.generoMusical = generoMusical; }

    public int getOyentesMensuales() { return oyentesMensuales; }
    public void setOyentesMensuales(int oyentesMensuales) {
        if (oyentesMensuales >= 0) {
            this.oyentesMensuales = oyentesMensuales;
        }
    }

    public void mostrarInfoArtista() {
        System.out.println("Artista: " + nombre + " | Género: " + generoMusical + " | Oyentes mensuales: " + oyentesMensuales);
    }
}

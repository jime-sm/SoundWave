/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soundwave;

/**
 *
 * @author karen
 */
public class Canciones {
    
private String nombre;
    private String artista;
    private double duracion;
    private int reproducciones;

    public Canciones(String nombre, String artista, double duracion, int reproducciones) {
        this.nombre = nombre;
        this.artista = artista;
        setDuracion(duracion);
        setReproducciones(reproducciones);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }

    public double getDuracion() { return duracion; }
    public void setDuracion(double duracion) {
        if (duracion > 0) {
            this.duracion = duracion;
        }
    }

    public int getReproducciones() { return reproducciones; }
    public void setReproducciones(int reproducciones) {
        if (reproducciones >= 0) {
            this.reproducciones = reproducciones;
        }
    }

    public void reproducirCancion() {
        this.reproducciones++;
        System.out.println(" Reproduciendo: " + nombre + " - " + artista + " (Total reproducciones: " + reproducciones + ")");
    }    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soundwave;

/**
 *
 * @author USUARIO
 */
public class Album {
    private String titulo;
    private int añoLanzamiento;
    private int numeroCanciones;

    public Album(String titulo, int añoLanzamiento, int numeroCanciones) {
        this.titulo = titulo;
        setAñoLanzamiento(añoLanzamiento);
        setNumeroCanciones(numeroCanciones);
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAñoLanzamiento() { return añoLanzamiento; }
    public void setAñoLanzamiento(int añoLanzamiento) {
        if (añoLanzamiento > 1900) {
            this.añoLanzamiento = añoLanzamiento;
        }
    }

    public int getNumeroCanciones() { return numeroCanciones; }
    public void setNumeroCanciones(int numeroCanciones) {
        if (numeroCanciones > 0) {
            this.numeroCanciones = numeroCanciones;
        }
    }

    public void mostrarDetallesAlbum() {
        System.out.println("Album: " + titulo + " (" + añoLanzamiento + ") - Pistas registradas: " + numeroCanciones);
    }    
}

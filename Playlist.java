/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soundwave;

/**
 *
 * @author USUARIO
 */
public class Playlist {
   private String nombrePlaylist;
    private int totalCanciones;
    private boolean esPublica;

    public Playlist(String nombrePlaylist, int totalCanciones, boolean esPublica) {
        this.nombrePlaylist = nombrePlaylist;
        setTotalCanciones(totalCanciones);
        this.esPublica = esPublica;
    }

    public String getNombrePlaylist() { return nombrePlaylist; }
    public void setNombrePlaylist(String nombrePlaylist) { this.nombrePlaylist = nombrePlaylist; }

    public int getTotalCanciones() { return totalCanciones; }
    public void setTotalCanciones(int totalCanciones) {
        if (totalCanciones >= 0) {
            this.totalCanciones = totalCanciones;
        }
    }

    public boolean isEsPublica() { return esPublica; }
    public void setEsPublica(boolean esPublica) { this.esPublica = esPublica; }

    public void mostrarInfoPlaylist() {
        String tipo = esPublica ? "Publica" : "Privada";
        System.out.println("Playlist: " + nombrePlaylist + " | Canciones: " + totalCanciones + " | Visibilidad: " + tipo);
    } 
}

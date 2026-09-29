/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soundwave;

/**
 *
 * @author karen
 */
public class Reproductor {
    
    private String estado;
    private int volumen;

    public Reproductor(String estado, int volumen) {
        this.estado = estado;
        setVolumen(volumen);
    }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public int getVolumen() { return volumen; }
    public void setVolumen(int volumen) {
        if (volumen >= 0 && volumen <= 100) {
            this.volumen = volumen;
        }
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("Reproductor cambio su estado a: " + this.estado);
    }

    public void ajustarVolumen(int nuevoVolumen) {
        setVolumen(nuevoVolumen);
        System.out.println("Volumen ajustado a: " + this.volumen + "%");
    }
}

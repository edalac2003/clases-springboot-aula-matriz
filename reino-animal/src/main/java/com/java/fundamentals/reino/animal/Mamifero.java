/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.fundamentals.reino.animal;

/**
 *
 * @author edala
 */
public class Mamifero extends Vertebrado {

    private float temperaturaPromedio;
    private boolean tienePelo;
    private boolean viveEnManada;
    private float tiempoSinRecibirOxigeno;
    private float grosorPiel;
    private short cantidadDientes;

    public boolean producirLeche(float edadMinima, float cantidadAProducir, float tiempoDeLactancia, byte cantidadCrias) {
        System.out.println("El mamifero ha producido leche.");
        return true;
    }

    public boolean regularTemperaturaEnSangre(float temperaturaMaxima, float temperaturaMinima) {
        System.out.println("Se ha regulado la sangre");
        return true;
    }

    public boolean inhalarOxigeno() {
        System.out.println("El mamifero ha inhalado el oxigeno");
        return true;
    }

    public boolean exhalarOxigeno() {
        System.out.println("El mamifero ha exhalado el oxigeno");
        return true;
    }

    public float getTemperaturaPromedio() {
        return temperaturaPromedio;
    }

    public void setTemperaturaPromedio(float temperaturaPromedio) {
        this.temperaturaPromedio = temperaturaPromedio;
    }

    public boolean isTienePelo() {
        return tienePelo;
    }

    public void setTienePelo(boolean tienePelo) {
        this.tienePelo = tienePelo;
    }

    public boolean isViveEnManada() {
        return viveEnManada;
    }

    public void setViveEnManada(boolean viveEnManada) {
        this.viveEnManada = viveEnManada;
    }

    public float getTiempoSinRecibirOxigeno() {
        return tiempoSinRecibirOxigeno;
    }

    public void setTiempoSinRecibirOxigeno(float tiempoSinRecibirOxigeno) {
        this.tiempoSinRecibirOxigeno = tiempoSinRecibirOxigeno;
    }

    public float getGrosorPiel() {
        return grosorPiel;
    }

    public void setGrosorPiel(float grosorPiel) {
        this.grosorPiel = grosorPiel;
    }

    public short getCantidadDientes() {
        return cantidadDientes;
    }

    public void setCantidadDientes(short cantidadDientes) {
        this.cantidadDientes = cantidadDientes;
    }

    @Override
    public String toString() {
        return "Mamifero{" + "temperaturaPromedio=" + temperaturaPromedio + ", tienePelo=" + tienePelo + ", viveEnManada=" + viveEnManada + ", tiempoSinRecibirOxigeno=" + tiempoSinRecibirOxigeno + ", grosorPiel=" + grosorPiel + ", cantidadDientes=" + cantidadDientes + '}';
    }
   
}

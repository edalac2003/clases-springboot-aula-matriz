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
public class Vertebrado {

    private float altura;
    private float peso;
    private short cantidadHuesos;
    private boolean tieneAlas;
    private String tipoEsqueleto;
    private String fechaNacimiento;
    private byte cantidadPatas;
    private short cantidadVertebras;

    public float correr(float posicionInicialX, float posicionInicialY, float velocidad, String tipoTerreno) {
        System.out.println("Método Correr");
        return 0f;
    }

    public float alimentarse(float cantidadAlimento, float cantidadAComer) {
        System.out.println("El animal se ha alimentado");
        return 0;
    }

    public byte ver(float intensidadLuz) {
        System.out.println("El animal está viendo");
        return 0;
    }

    public boolean comunicarse(Vertebrado receptor, String mensajeATransmitir, String canalComunicacion) {
        System.out.println("El animal se ha comunicado");
        return true;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public short getCantidadHuesos() {
        return cantidadHuesos;
    }

    public void setCantidadHuesos(short cantidadHuesos) {
        this.cantidadHuesos = cantidadHuesos;
    }

    public boolean isTieneAlas() {
        return tieneAlas;
    }

    public void setTieneAlas(boolean tieneAlas) {
        this.tieneAlas = tieneAlas;
    }

    public String getTipoEsqueleto() {
        return tipoEsqueleto;
    }

    public void setTipoEsqueleto(String tipoEsqueleto) {
        this.tipoEsqueleto = tipoEsqueleto;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public byte getCantidadPatas() {
        return cantidadPatas;
    }

    public void setCantidadPatas(byte cantidadPatas) {
        this.cantidadPatas = cantidadPatas;
    }

    public short getCantidadVertebras() {
        return cantidadVertebras;
    }

    public void setCantidadVertebras(short cantidadVertebras) {
        this.cantidadVertebras = cantidadVertebras;
    }

    @Override
    public String toString() {
        return "Vertebrado{" + "altura=" + altura + ", peso=" + peso + ", cantidadHuesos=" + cantidadHuesos + ", tieneAlas=" + tieneAlas + ", tipoEsqueleto=" + tipoEsqueleto + ", fechaNacimiento=" + fechaNacimiento + ", cantidadPatas=" + cantidadPatas + ", cantidadVertebras=" + cantidadVertebras + '}';
    }
}

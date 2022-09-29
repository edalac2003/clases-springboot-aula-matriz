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
public class ReinoAnimal {
    
    public static void main(String[] args) {
        
        Vertebrado ballena = new Vertebrado();
        ballena.setAltura(350);
        ballena.setCantidadHuesos((short)200);
        ballena.setCantidadVertebras((short)150);
        ballena.setFechaNacimiento("1999-01-01");
        ballena.setCantidadPatas((byte)2);
        ballena.setPeso(50.3f);
        ballena.setTieneAlas(false);
        ballena.setTipoEsqueleto("Oseo");
        
        Mamifero gato = new Mamifero();
        gato.setCantidadDientes((short) 30);
        gato.setGrosorPiel(1.5f);
        gato.setTemperaturaPromedio(32.7f);
        gato.setTiempoSinRecibirOxigeno(3f);
        gato.setTienePelo(true);
        gato.setViveEnManada(false);
        gato.setAltura(25.6f);
        gato.setCantidadHuesos((short)100);
        gato.setCantidadVertebras((short)20);
        
        
        System.out.println("Info de la ballena.  " + ballena);
        System.out.println("Info del gato.  " + gato);
        
        System.out.println(gato.correr(0, 3.4f, 6.2f, "piso"));
        System.out.println(gato.regularTemperaturaEnSangre(36, 32));
    }
}

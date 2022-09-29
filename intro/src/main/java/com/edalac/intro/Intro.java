/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edalac.intro;

/**
 *
 * @author edala
 */
public class Intro {
    public static void main(String[] args) {
        testASwitch();

    }
    
    public static void testASwitch(){
        int a = 8;
        
        try{
            throw new NullPointerException();
        }catch(NullPointerException e){
            a = (short)1;
        }
        
        switch(a){
            default: System.out.print("Saludos ");
            case 1: System.out.print("Hola ");
            case 2: System.out.print("Mundo ");
                
        }
    }
}

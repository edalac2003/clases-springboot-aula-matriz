package com.java.programming.ii.junio.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edala
 */
public class TestJavaIO {

    public static void main(String[] args) {
//        testByteStreamCopy();
//        testCharacterStreamCopy();
//        testBufferedStreamCopy();
//        testStandardInput();
//        testSaveObject();
//        testRecoverObject();
//        testNewIO2();
        testNewBufferedWriter();
    }

    public static void testByteStreamCopy() {
        byte[] b = new byte[128];

        File inputFile = new File("C:\\imagen\\flor-de-loto-735x450.jpg");
        try ( FileInputStream fis = new FileInputStream(inputFile);  FileOutputStream fos = new FileOutputStream("C:\\imagen\\copia_20220707.jpg");) {

            while (fis.read(b) != -1) {
                fos.write(b);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void testCharacterStreamCopy() {
        char[] c = new char[128];
        try ( FileReader fileReader = new FileReader("C:\\imagen\\ejemplo.txt");  FileWriter fileWriter = new FileWriter("C:\\imagen\\ejemplo_20220707.txt");) {

            while (fileReader.read(c) != -1) {
                fileWriter.write(c);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void testBufferedStreamCopy() {

        try ( BufferedReader br = new BufferedReader(new FileReader("C:\\imagen\\ejemplo.txt"));  BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\imagen\\ejemplo_20220707_buffered.txt"));) {

            String line = "";
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void testStandardInput() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escriba abc para salir...  ");
        String s = "";

        try {
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println("Eco: " + s);
                if (s.equals("abc")) {
                    System.exit(0);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void testSaveObject() {
        try ( FileOutputStream fos = new FileOutputStream("C:\\imagen\\ejemplo_persistencia");) {
            Cliente clienteX = new Cliente();
            clienteX.setId("88");
            clienteX.setName("Edwin");
            
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clienteX);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void testRecoverObject() {
        try (FileInputStream fis = new FileInputStream("C:\\imagen\\ejemplo_persistencia");
                ObjectInputStream ois = new ObjectInputStream(fis);){
            Cliente clienteRecuperado = (Cliente)ois.readObject();
            
            System.out.println("El cliente recuperado es:  " + clienteRecuperado);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void testNewIO2() {
        Path pathIn = Paths.get("C:\\imagen\\ejemplo.txt");
        Path pathOut = Paths.get("C:\\imagen\\ejemplo_outNIO2.txt");
        
        System.out.println("Info del Path " + pathIn.getParent());
        
        try {
            Files.copy(pathIn, pathOut);
        } catch (IOException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void testNewBufferedWriter() {
        
        Path pathOut = Path.of("C:\\imagen\\testBufferedWriter_outNIO2.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(pathOut);){
            bw.write("Esta es una prueba adicional");
        } catch (IOException ex) {
            Logger.getLogger(TestJavaIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

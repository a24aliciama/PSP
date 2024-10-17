package org.Ejercicios1_1;

import java.io.IOException;

public class Ejercicio1 {
    /**
     * DU1 - Exercise 1 - Java Runtime Class

     * Use the Java Runtime Class to do the following tasks:
     * Obtain the number of available processors for the JVM
     * Launch the Google Chrome browser
     * Launch YouTube on the Google Chrome browser
     * Launch notepad
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        Runtime runtime = Runtime.getRuntime();

        int procesadores = runtime.availableProcessors();

        System.out.println(procesadores);


    }
}

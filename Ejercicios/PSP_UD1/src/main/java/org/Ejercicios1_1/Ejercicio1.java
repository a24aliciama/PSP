package org.Ejercicios1_1;

import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException, InterruptedException {

        Runtime runtime = Runtime.getRuntime();

        int procesadores = runtime.availableProcessors();

        System.out.println(procesadores);


    }
}

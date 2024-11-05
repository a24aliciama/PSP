package org.example.ejercicio3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Ejecutable3 {
    /**
     * DU2 - Exercise 3 - Java Threads - Callable

     * We want to create a multithreaded application.
     * The main thread must create an array of ten words.
     * That main thread must create ten threads whose job is to check whether
     * a word is a palindrome or not. A palindrome is a word, phrase,
     * verse or even number that reads the same forwards or backwards.

     * Examples of palindromes:
     * kayak deified rotator repaper deed peep wow noon civic racecar level mom

     * The main thread must indicate in the standard output for each word whether
     * it is a palindrome or not.
     */
    public static void main(String[] args) {
        // Array de diez palabras
        String[] palabras = {
                "kayak", "deified", "hello", "repaper",
                "deed", "palabra", "wow", "noon",
                "civic", "level", "gato", "cama", "ama"
        };

        // HashSet para almacenar solo los palíndromos
        Set<String> palindromos = new HashSet<>();

        // Lista para almacenar los FutureTask de cada palabra
        List<FutureTask<Boolean>> tareas = new ArrayList<>();

        // Crear y arrancar FutureTask para cada palabra
        int indice = 1;
        for (String palabra : palabras) {
            Callable3 tarea = new Callable3(palabra, palindromos, indice);
            FutureTask<Boolean> futureTask = new FutureTask<>(tarea);
            Thread hilo = new Thread(futureTask); // Ejecutar el FutureTask en un Thread
            hilo.start();
            tareas.add(futureTask); // Añadir el FutureTask a la lista para obtener resultados después
            indice++;
        }

        // Imprimir resultados desde el main
        indice = 1;
        for (FutureTask<Boolean> tarea : tareas) {
            try {
                boolean esPalindromo = tarea.get();  // Espera a que termine el hilo y obtiene el resultado
                String palabra = palabras[indice - 1];
                if (esPalindromo) {
                    System.out.println("Palabra " + indice + ": '" + palabra + "' es un palíndromo.");
                } else {
                    System.out.println("Palabra " + indice + ": '" + palabra + "' no es un palíndromo.");
                }
                indice++;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Imprimir el conjunto de palíndromos encontrados
        System.out.println("\nPalíndromos encontrados: " + palindromos);
    }

}

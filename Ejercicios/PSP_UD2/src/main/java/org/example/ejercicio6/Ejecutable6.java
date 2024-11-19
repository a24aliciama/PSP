package org.example.ejercicio6;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Ejecutable6 {
    /**
     * DU2 - Exercise 6 - Java Threads - Thread pool - Multiples
     * We want to create a multithreaded application.
     * The main thread must create a thread pool to create using a single thread 50 numbers whose size must be between 20 and 50 digits. Numbers starting with 0 are not allowed.
     * Once all numbers have been generated, we want to verify if each of the numbers is a multiple of 3, 5 or 11.
     * Use another thread pool of size 12 to perform the calculation.
     * Use the following information to check if the numbers are multiples of 3, 5 or 11:
     * If the sum of digits in a number is a multiple of 3 then the number is a multiple of 3, e.g., for 612, the sum of digits is 9, so it’s a multiple of 3.
     * If the last character is "5" or "0" then the number is a multiple of 5, otherwise not.
     * A number is a multiple of 11 if the difference between the sum of its digits in odd positions and the sum of its digits in even positions is a multiple of 11 (including 0).
     * Display the information about each number and multiple on a separate line.
     * Once all numbers have been verified, the program must terminate.

     * DU2 - Ejercicio 6 - Subprocesos Java - Grupo de subprocesos - Múltiples
     * Queremos crear una aplicación multiproceso.
     * El hilo principal debe crear un grupo de hilos para crear, utilizando un único hilo, 50 números cuyo tamaño debe estar entre 20 y 50 dígitos .
     * No se permiten números que comiencen con  0 .
     * Una vez generados todos los números, queremos verificar si cada uno de los números es múltiplo de 3 , 5 o 11 .
     * Utilice otro grupo de subprocesos de tamaño 12 para realizar el cálculo.
     * Utilice la siguiente información para comprobar si los números son múltiplos de 3, 5 u 11:
     * Si la suma de los dígitos de un número es múltiplo de 3 , entonces el número es múltiplo de 3, por ejemplo, para 612, la suma de los dígitos es 9, por lo que es un múltiplo de 3.
     * Si el último carácter es '5' o '0', entonces el número es un múltiplo de 5, de lo contrario, no.
     * Un número es múltiplo de 11 si la diferencia entre la suma de sus dígitos en posiciones impares y la suma de sus dígitos en posiciones pares es un múltiplo de 11 (incluido 0).
     * Muestra la información sobre cada número y múltiplo en una línea separada.
     * Una vez verificados todos los números , el programa debe finalizar .
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Creación de Números con Callable y un thread
        ArrayList<String> numsString = new ArrayList<>();

        //creamos el pool de un solo thread
        ExecutorService ejecutor1 = Executors.newSingleThreadExecutor();

        for(int i = 0; i < 50; i++){

            //creamos el callable para pasársela al ejecutor1 (pool)
            Callable<String> tarea = new Calable6_CreaNums();
            //cogemos el return de la tarea al ejecutarla (que es básicamente el callable).
            Future<String> futuro = ejecutor1.submit(tarea);
            String resultado = futuro.get(); //aquí lo pasamos a una variable

            numsString.add(resultado); //Ahora hay 50 núm. de entre 20 y 50 dígitos en esta lista

            //comprobador de que números han salido
            //System.out.println(i + ": " + numsString.get(i));
        }

        ejecutor1.shutdownNow(); //cerramos el ejecutor1

        //Creamos el pool de 12
        ExecutorService ejecutor12 = Executors.newFixedThreadPool(12);

        //Ahora le pasamos los numeros a las tareas que comprobaran los multiplos
        for (int i = 0; i < numsString.size(); i++){
          Runnable tarea3 = new Runeable6_ComMul3(numsString.get(i), i+1);
          ejecutor12.submit(tarea3);

          Runnable tarea5 = new Runeable6_ComMul5(numsString.get(i), i+1);
          ejecutor12.submit(tarea5);

          Runnable tarea11 = new Runeable6_ComMul11(numsString.get(i), i+1);
          ejecutor12.submit(tarea11);

        }


        //cerramos del executor
        ejecutor12.shutdown();

        // Esperar 5 segundos a que termine
        if (ejecutor12.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Todas las tareas han terminado.");
        } else {
            System.out.println("No todas las tareas terminaron. Interrumpiendo...");
            ejecutor12.shutdownNow(); // Interrumpir tareas activas
        }
    }

}

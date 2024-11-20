package org.example.ejercicio7;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ejecutable7 {
    /**
     * DU2 - Exercise 7 - Java Threads - Atomic variables - Super even numbers

     * A super even number is a whole number in which every digit is even.//par
     * This means that each digit in the number must be one of the even digits: 0, 2, 4, 6, or 8.
     * Given a set of numbers, we try to determine whether or not they are super even or not by creating
     * a multithreading application.
     * The main thread must generate two random numbers (use java.util.Random)
     * between 1 and 10000 to determine the numbers we want to check.
     * That main thread must create a pool of four threads.
     * The main thread must check the numbers between the smallest and the largest of the randomly generated numbers.
     * For each number it will display a single line showing whether the number is a super even.
     * Each of the threads created by the main thread must create a thread pool
     * of two threads to check each of the digits of the number.
     * These threads must share an object named Number where the number is stored
     * and a boolean that informs whether or not the number is super even.
     * Review the following information if you need to wait for threads to finish:

     * https://ducmanhphan.github.io/2020-03-20-Waiting-threads-to-finish-completely-in-Java/

     * Follow the given specifications to create the application.
     */
    public static void main(String[] args) throws InterruptedException {
        Random ran = new Random();

        //creamos dos numeros aleatorios entre 1 y 1000
        int num1 = ran.nextInt(10000) + 1;
        int num2 = ran.nextInt(10000) + 1;

        //cogemos el menor y el mayor. Este será nuestro intervalo
        //int mayor = Math.max(num1, num2);
        //int menor = Math.min(num1, num2);
        int menor = 200;
        int mayor = 220;

        //imprimimos el intervalo
        System.out.println("Intervalo generado: " + menor + "-" + mayor + "\nSon " + (mayor - menor) + " numeros");

        //creamos la lista de los numeros a comprobar
        ArrayList<Integer> numsToCheck = new ArrayList<>();
        for (int i = menor; i <= mayor; i++){
            numsToCheck.add(i);
        }

        //creamos un pool de 4 threads
        ExecutorService ejecutor = Executors.newFixedThreadPool(4);

        //le pasamos los numeros al run
        for (int i = 0; i < numsToCheck.size(); i++){
            Runnable tarea = new Runeable7_SuperPar(numsToCheck.get(i), i+1);
            ejecutor.submit(tarea);
        }

        //cerramos el ejecutor
        ejecutor.shutdown();

        //esperamos a que termine
        if(ejecutor.awaitTermination(20, TimeUnit.SECONDS)) {
            System.out.println("Todas las tareas han terminado.");
        }else {
            System.out.println("No han terminado las tareas");
            ejecutor.shutdownNow();
        }
    }
}

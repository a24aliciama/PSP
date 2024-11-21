package org.example.ejercicio9;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ejecutable9 {
    /**
     * DU2 - Exercise 9 - Java Threads - Synchronization - Hidden number
     * We want to create a multithreading application.
     * The main thread must generate a random number (use java.util.Random) between 0 and 100.
     * That main thread must create ten threads whose job is to guess the number generated by the main thread.
     * To perform their tasks all threads must share an object of the HiddenNumber class.
     * The HiddenNumber class must have a method int numberGuess(int num) that has to return the following values:
     * -1 if the game is over because one thread has guessed the number
     * 1 if the proposed number (num) is the hidden number
     * 0 otherwise
     * Follow the given specifications to create the application.
     */
    public static void main(String[] args) {
        // generamos un numero random entre 0 y 100
        Random ran = new Random();
        int aleatorio = ran.nextInt(101);

        //creamos un pool de 10 threads
        ExecutorService ejecutor = Executors.newFixedThreadPool(10);

        //Creamo sun objeto NumeroOculto
        NumeroOculto numO = new NumeroOculto();
    }
}

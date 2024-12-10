package org.Ejercicios1_1.Ejercicio14;

import java.util.Scanner;

public class Elevador14 {
    /**
     * DU1 - Exercise 14 - Java ProcessBuilder
     * Create another program in Java that reads from the standard input a number and
     * after it reads the quantity of numbers indicated above.
     * The program must square all of the numbers and
     * then calculate their sum and display the result on the standard output.
     * Programa que lee una cantidad de números desde la entrada estándar,
     * calcula el cuadrado de cada uno, y luego suma los resultados.
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Leer la cantidad de números que se van a procesar.
        int cant = teclado.nextInt();
        int sum = 0; // Variable para acumular la suma de los cuadrados.

        // Bucle para leer cada número, elevarlo al cuadrado y acumular la suma.
        for (int i = 0; i < cant; i++) {
            sum += ((int) Math.pow(teclado.nextInt(), 2)); // Calcula el cuadrado y lo suma.
        }

        // Mostrar el resultado final.
        System.out.println("La suma de los cuadrados de los numeros es: " + sum + ".");
    }
}
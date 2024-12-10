package org.Ejercicios1_1.Ejercicio14;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Sumador14 {
    /**
     * Programa que lee una cantidad de números desde la entrada estándar,
     * calcula la suma de los números y luego calcula el cuadrado de dicha suma.
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Leer la cantidad de números que se van a procesar.
        int cant = teclado.nextInt();
        int sum = 0; // Variable para acumular la suma.

        // Bucle para leer y sumar cada número.
        for (int i = 0; i < cant; i++) {
            sum += teclado.nextInt(); // Suma el número actual a la variable acumuladora.
        }

        // Mostrar la suma y su cuadrado.
        System.out.println("La suma es: " + sum + ".\nEl cuadrado de la suma es: " + ((int) Math.pow(sum, 2)) + ".");
    }
}

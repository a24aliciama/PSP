package org.Ejercicios1_1.Ejercicio14;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Sumador14 {
    /**
     * DU1 - Exercise 14 - Java ProcessBuilder
     * Create a program in Java that reads from the standard input a number and
     * after it reads the quantity of numbers indicated above.
     * The program must add up all the numbers and
     * calculate the square of the sum and display the result on the standard output.
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
       // System.out.println("Hola, cuantos numeros quieres sumar?");
        int cant = teclado.nextInt();
        int sum = 0;

        for(int i = 0; i < cant; i ++){
            //System.out.println("Escribe el " + (i+1) + "º numero");
            sum += teclado.nextInt();
        }

        System.out.println("La suma es: " + sum + ".\nEl cuadrado de la suma es: " + ((int) Math.pow(sum, 2))  + "." );

    }
}

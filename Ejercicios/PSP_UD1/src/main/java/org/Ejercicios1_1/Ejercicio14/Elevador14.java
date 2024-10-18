package org.Ejercicios1_1.Ejercicio14;

import java.util.Scanner;

public class Elevador14 {
    /**
     * DU1 - Exercise 14 - Java ProcessBuilder
     * Create another program in Java that reads from the standard input a number and
     * after it reads the quantity of numbers indicated above.
     * The program must square all of the numbers and
     * then calculate their sum and display the result on the standard output.
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //System.out.println("Hola, cuantos numeros quieres elevar?");
        int cant = teclado.nextInt();
        int sum = 0;

        for(int i = 0; i < cant; i ++){
            //System.out.println("Escribe el " + (i+1) + "º numero");
            sum += ((int) Math.pow(teclado.nextInt(),2));
        }

        System.out.println("La suma de los cuadrados de los numeros es: " + sum + ".");

    }
}

package org.example;

import java.util.Scanner;

public class SumaCuadrado {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cantidad = sc.nextInt();
        int[] numeros = new int[cantidad];
        int suma = 0;
        int resultado = 0;

        for (int i = 0; i < cantidad; i++) {
            numeros[i] = sc.nextInt();
        }
        for (int numero : numeros) {
            suma += numero;
        }
        resultado = suma * suma;
        System.out.println(resultado);

    }
}

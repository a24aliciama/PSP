package org.example;

import java.util.Scanner;

public class SumaCuadradoDeCadaNumero {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cantidad = sc.nextInt();
        int[] numeros = new int[cantidad];
        int suma = 0;

        for (int i = 0; i < cantidad; i++) {
            numeros[i] = sc.nextInt() * 2;
        }
        for (int i = 0; i < cantidad; i++) {
            numeros[i] = numeros[i] * numeros[i];
        }
        for (int numero : numeros) {
            suma += numero;
        }
        System.out.println(suma);

    }
}

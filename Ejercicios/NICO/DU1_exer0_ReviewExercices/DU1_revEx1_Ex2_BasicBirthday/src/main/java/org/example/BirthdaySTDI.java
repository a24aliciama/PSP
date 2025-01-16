package org.example;

import java.util.Scanner;

/**
 * Calcula a cantidade de uns a pasar un decimal a binario
 */

public class BirthdaySTDI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        for (int i = 0; i < casos; i++){
            int velas = 0;
            int segundos = sc.nextInt();
            String binario = Integer.toBinaryString(segundos);
            for (int a = 0;a <binario.length();a++){
                if (binario.charAt(a) == '1'){
                    velas++;
                }
            }
            System.out.println(velas);
        }
    }
}
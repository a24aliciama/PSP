package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SumaPares {
    public static void main(String[] args) {
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);

        int suma = 0;

        for (int i = n1;i <= n2; i++){
            if (i%2 == 0){
                suma += i;
            }
        }

        System.out.println(suma);
    }
}

package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContadorVocales {

    public static void main(String[] args) {
        String inputFilePath = args[0];
        char vocal = args[1].charAt(0);

        ContadorVocales contadorVocales = new ContadorVocales();
        int count = contadorVocales.contar(vocal, inputFilePath);
        System.out.println(count);
    }

    public int contar(char vocal, String inputFilePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            int count = 0;
            int c;
            while ((c = reader.read()) != -1) {
                if (Character.toUpperCase(c) == Character.toUpperCase(vocal)) {
                    count++;
                }
            }
            return count;
        } catch (IOException e) {
            return 0;
        }
    }
}

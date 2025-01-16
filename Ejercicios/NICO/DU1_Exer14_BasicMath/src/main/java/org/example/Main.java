package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cantidad = sc.nextInt();
        int[] numeros = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            numeros[i] = sc.nextInt();
        }

        try {
            ProcessBuilder processBuilder1 = new ProcessBuilder("java", "-cp", "target/classes", "org.example.SumaCuadrado");
            Process process1 = processBuilder1.start();
            BufferedWriter writer1 = new BufferedWriter(new OutputStreamWriter(process1.getOutputStream()));
            writer1.write(cantidad + "\n");
            for (int numero : numeros) {
                writer1.write(numero + "\n");
            }
            writer1.flush();
            writer1.close();

            BufferedReader reader1 = new BufferedReader(new InputStreamReader(process1.getInputStream()));
            System.out.println("Resultado SumaCuadrado: " + reader1.readLine());
            reader1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*try {
            ProcessBuilder processBuilder2 = new ProcessBuilder("java", "-cp", "target/classes", "org.example.SumaCuadradoDeCadaNumero");
            Process process2 = processBuilder2.start();
            BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(process2.getOutputStream()));
            writer2.write(cantidad + "\n");
            for (int numero : numeros) {
                writer2.write(numero + "\n");
            }
            writer2.flush();
            writer2.close();

            BufferedReader reader2 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
            System.out.println("Resultado SumaCuadradoDeCadaNumero: " + reader2.readLine());
            reader2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
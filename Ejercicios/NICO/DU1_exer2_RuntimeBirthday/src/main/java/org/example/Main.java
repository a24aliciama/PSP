package org.example;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();

        Random random = new Random();
        int casos = random.nextInt(2,20);
        int[] velas = new int[casos];
        for (int i = 0; casos > i; i++){
           velas[i] = random.nextInt(1000);
        }

        String[] command = new String[5 + velas.length];
        command[0] = "java";
        command[1] = "-cp";
        command[2] = "E:/Clase/DAM2/PSP/DU1_exer2_RuntimeBirthday/src/main/resources/BasicBirthday-1.0-SNAPSHOT.jar";
        command[3] = "org.example.BirthdayArgs";
        command[4] = String.valueOf(casos);
        for (int i = 0; i < velas.length; i++) {
            command[5 + i] = String.valueOf(velas[i]);
        }

        Process process = runtime.exec(command);
        Scanner scIN = new Scanner(process.getInputStream());
        while (scIN.hasNextLine()) {
            System.out.println(scIN.nextLine());
        }
        scIN.close();
    }
}
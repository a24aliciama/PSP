package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Random random = new Random();

        //Almacenamiento de todas las temperaturas
        int[] temperaturas = new int[3650];
        for (int i = 0; i < temperaturas.length;i++){
            temperaturas[i] = random.nextInt(-30,50);
        }


        // Bucle que divide las temperaturas en 10 y las procesa
        int parte = 3650 / 10;
        int sumas[] = new int[10];
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new MediaRunnable(Arrays.copyOfRange(temperaturas, parte * i, parte * (i + 1)), sumas, i));
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        int total = 0;
        for (int i = 0; i < sumas.length;i++){
            total += sumas[i];
        }

        int media = total/3650;
        System.out.println(media);


        /*int total = 0;
        for (int i = 0; i < temperaturas.length;i++){
            total += temperaturas[i];
        }
        int media = total/3650;
        System.out.println(media);*/

    }
}
package org.example.ejercicio2;

import java.util.Random;

public class Ejecutable2 {
    private static final int NUM_DAYS = 3650; // Días en 10 años
    private static final int NUM_THREADS = 10; // Número de hilos
    private static final int MIN_TEMP = -30; // Temperatura mínima
    private static final int MAX_TEMP = 50; // Temperatura máxima

    public static void main(String[] args) {
        int[] temp = new int[NUM_DAYS]; //creamos un array del tamaño de los dias que queremos calcular
        Random random = new Random();

        // Generar temperaturas aleatorias para los 3650 dias
        for (int i = 0; i < NUM_DAYS; i++) {
            temp[i] = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
        }

        // Crear y lanzar hilos
        Thread[] trs = new Thread[NUM_THREADS];
        Runeable2[] calculo = new Runeable2[NUM_THREADS];
        int tamanhoGrupo = 365;

        for (int i = 0; i < NUM_THREADS; i++) {
            int start = i * tamanhoGrupo;
            int end = start + tamanhoGrupo;

            calculo[i] = new Runeable2(temp, start, end);
            trs[i] = new Thread(calculo[i]);

            trs[i].start();
        }

        // Esperar a que todos los hilos terminen
        double sumMedias = 0;

        for (int i = 0; i < NUM_THREADS; i++) {
            try {
                trs[i].join();
                sumMedias += calculo[i].getMediaSum();
                System.out.println(trs[i].getName() + ": en este año la media es " + calculo[i].getMediaSum());
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido: " + i);
            }
        }

        // Calcular la temperatura promedio
        double tempMedia = sumMedias/NUM_THREADS; //son 10 medias, una por thread

        // Mostrar el resultado
        System.out.println("La temperatura promedio de los últimos 10 años es: " + tempMedia);
    }
}

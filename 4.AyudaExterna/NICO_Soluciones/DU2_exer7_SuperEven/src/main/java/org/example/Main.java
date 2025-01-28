package org.example;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int NUM_THREADS = 4;

    public static void main(String[] args) {

        Random random = new Random();
        int num1 = random.nextInt(1,10000);
        int num2 = random.nextInt(1,10000);

        int min = Math.min(num1,num2);
        int max = Math.max(num1,num2);

        Number[] numerosClase = new Number[(max - min) + 1];

        ExecutorService threads = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i <= (max - min);i++){
            numerosClase[i] = new Number(min + i);
        }

        for (Number numero : numerosClase){
            threads.submit(new SuperEvenRunnable(numero));
        }

        threads.shutdown();

        try {
            threads.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Number numero : numerosClase){
            System.out.println(numero.toString());
        }

    }
}
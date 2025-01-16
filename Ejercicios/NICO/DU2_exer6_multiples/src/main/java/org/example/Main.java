package org.example;

import java.math.BigInteger;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static int NUM_BIGINTEGER = 50;

    public static void main(String[] args) {

        Random random = new Random();

        ExecutorService multiplo3 = Executors.newFixedThreadPool(NUM_BIGINTEGER);
        ExecutorService multiplo5 = Executors.newFixedThreadPool(NUM_BIGINTEGER);
        ExecutorService multiplo11 = Executors.newFixedThreadPool(NUM_BIGINTEGER);

        for (int i = 0; i < NUM_BIGINTEGER; i++) {
            int posiciones = random.nextInt(20,50);
            StringBuilder numero = new StringBuilder();
            numero.append(random.nextInt(1,10));
            for (int j = 0; j < posiciones - 1; j++) {
                numero.append(random.nextInt(0,10));
            }
            String numeroString = numero.toString();
            multiplo3.execute(new Multiplo3(numeroString));
            multiplo5.execute(new Multiplo5(numeroString));
            multiplo11.execute(new Multiplo11(numeroString));

        }

        multiplo3.shutdown();
        multiplo5.shutdown();
        multiplo11.shutdown();

    }


}
package org.example.ejercicio1;

import java.util.Random;

public class Runeable1 implements Runnable {

    private String threadName;

    public Runeable1(String name) {
            this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Hola soy " + threadName);

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            // Generate a random number between 10 and 500
            int randomNumber = random.nextInt(491) + 10; // 491 + 10 = 500
            try {
                // Pause the current thread for the random number of milliseconds
                Thread.sleep(randomNumber);
            } catch (InterruptedException e) {
                System.out.println(threadName + ": Me han interrumpido ");
            }
            System.out.println(threadName + ": He dormido " + randomNumber + " ms");
        }

        System.out.println("Adios,  " + threadName + " se marcha");

    }
}

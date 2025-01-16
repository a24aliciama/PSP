package org.example;

import java.util.Random;

public class RandomRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        Random random = new Random();
        int randomInt = random.nextInt(500);
        try {
            Thread.sleep(randomInt);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Bye" + Thread.currentThread().getName());
    }
}

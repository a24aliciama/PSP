package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SuperEvenRunnable implements Runnable {
    Number numero;

    public SuperEvenRunnable (Number numero){
        this.numero = numero;
    }

    @Override
    public void run() {
        ExecutorService threads = Executors.newFixedThreadPool(2);
        String numeroStr = String.valueOf(numero.getNumber());

        for (char c : numeroStr.toCharArray()) {
            threads.submit(new SuperEvenCharacterRunnable(numero, c));
        }

        threads.shutdown();
        try {
            threads.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

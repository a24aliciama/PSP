package org.example;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        HiddenNum hiddenNum = new HiddenNum(random.nextInt(0,2));

        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0;i< 10;i++){
            pool.submit(new Guess(random.nextInt(0,2), hiddenNum));
        }
        pool.shutdown();

        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static int NUM_THREADS = 3;
    public static void main(String[] args) {

        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};

        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            Runnable rg = new RunableGreet(names[i]);
            pool.execute(rg);
        }
        pool.shutdown();
    }
}
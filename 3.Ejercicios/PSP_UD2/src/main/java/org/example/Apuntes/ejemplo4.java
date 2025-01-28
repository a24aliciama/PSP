package org.example.Apuntes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ejemplo4 {

    public static final int NUM_TRHEADS = 6;

    public static void main(String[] args) {
        String[] names = {"1 ana", "2 pipo", "3 alba", "4 sonia", "5 lore", "6 casa"};

        ExecutorService pool = Executors.newFixedThreadPool(NUM_TRHEADS);

        for (int i = 0; i < NUM_TRHEADS; i++) {
            Runnable rg = new ejm4Run(names[i]);
            pool.execute(rg);
        }
        pool.shutdown(); //remata el programa
    }
}

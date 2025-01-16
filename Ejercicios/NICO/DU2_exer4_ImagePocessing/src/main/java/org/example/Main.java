package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Main {
    static int NUM_THREADS = 5;
    public static void main(String[] args) throws IOException {
        Stream<Path> paths = Files.list(Path.of("src/main/resources/originals/"));

        Object[] names = paths.toArray();

        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].toString().substring(29, names[i].toString().length()-4);
            System.out.println(names[i]);
        }

        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < (names.length + NUM_THREADS - 1) / NUM_THREADS; i++) {
            for (int ii = 0; ii < NUM_THREADS && (ii + i * NUM_THREADS) < names.length; ii++) {
                Runnable rg = new RunableGrey((String) names[ii + (i * NUM_THREADS)]);
                pool.execute(rg);
            }
        }
        pool.shutdown();

    }
}
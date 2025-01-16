package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder();

        File[] files = new File("src/main/resources/departments").listFiles();
        for (File file : files) {
            processBuilder.command("java", "-cp", "target/classes", "org.example.Sumador", file.getName());
            try {
                Process process = processBuilder.start();
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
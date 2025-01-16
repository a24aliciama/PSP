package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();

            Map<String, String> environment = processBuilder.environment();

            environment.put("key", "Hello world");

            processBuilder.command("cmd.exe", "/c", "echo %key%");

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

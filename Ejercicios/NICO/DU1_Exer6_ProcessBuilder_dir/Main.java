package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ruta del directorio: ");
            String path = sc.nextLine();

            ProcessBuilder processBuilder = new ProcessBuilder();

            processBuilder.command("cmd.exe", "/c", "dir", path);

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println( line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
        }
    }
}

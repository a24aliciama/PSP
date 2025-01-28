package org.example;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final long TIME_MAX = 8000;

    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("cmd.exe", "/c", "tracert iessanclemente.net");
            processBuilder.redirectOutput(new File("src/main/java/org/example/output.txt"));
            Process process = processBuilder.start();

            if (!process.waitFor(TIME_MAX, TimeUnit.MILLISECONDS)) {
                process.destroy();
                throw new InterruptedException("Process terminated because it took too long");
            }

            //Forma mas larga para leer el output

            /*try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/java/org/example/output.txt")))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    writer.write(line + " \n");
                }

                int exitCode = process.waitFor();
                System.out.println("\nExited with code: " + exitCode);
            }*/
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

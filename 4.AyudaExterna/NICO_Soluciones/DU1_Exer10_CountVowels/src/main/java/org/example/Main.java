package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        String inputFilePath = "file.txt";
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int total = 0;

        for (char vowel : vowels) {

            ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "target/classes", "org.example.ContadorVocales" , inputFilePath, String.valueOf(vowel));

            try {
                Process process = processBuilder.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = reader.readLine();
                System.out.println(vowel + ": " + line);
                total += Integer.parseInt(line);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       System.out.println("Total: " + total);
    }


}
package org.example;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder();

        pb.command("java", "-cp", "target/classes", "org.example.SumaPares", "2", "4");
        Process process = pb.start();

        try (BufferedReader brERRORES = new BufferedReader(process.errorReader());
             BufferedWriter bwERRORES = new BufferedWriter(new FileWriter("src/main/resources/errors.txt"));

             BufferedReader br = new BufferedReader(process.inputReader());
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/suma.txt"))) {

            String linea = br.readLine();

            if (linea != null){
                bw.write(linea);
            }

            String lineaError;
            while ((lineaError = brERRORES.readLine())!= null ){
                bwERRORES.write(lineaError);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
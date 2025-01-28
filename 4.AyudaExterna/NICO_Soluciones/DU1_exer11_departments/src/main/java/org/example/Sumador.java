package org.example;

import java.io.*;

public class Sumador {
    public static void main(String[] args){
        Double suma = 0.00;

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/departments/" + args[0]))){
            String linea;
            Double numero;
            while ((linea = br.readLine()) != null){
                numero = Double.parseDouble(linea);
                suma += numero;
            }
        }catch (IOException e){}

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/sumas.txt", true))){
            bw.write( args[0] + ": " + suma + "\n");
        } catch (IOException e) {}
    }
}

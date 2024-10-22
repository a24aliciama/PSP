package org.Ejercicios1_1.Ejercicio11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.out;

public class Hijos11 {
    public static void main(String[] args) throws IOException {
       if (args.length < 2){
            out.println("Necesito 1 args. archivo de entrada y nombre del archivo");
            return;
        }

        //archivo de entrada (se suma aqui)
        String archivoEn = args[0];

        //nombre del archivo que se suma
        String nombre = args[1];


        //contador
        double contador = 0;

        String depa = "101";
        String prueba = "./src/main/resources/entradas/departamentos11/department" + depa + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEn))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    double numero = Double.parseDouble(linea);
                    contador += numero;
                } catch (NumberFormatException e) {
                    System.out.println("Error al convertir el número: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        out.println("=====================");
        out.println(nombre);
        out.println("---------------------");
        System.out.printf("%.2f", contador);

    }


}


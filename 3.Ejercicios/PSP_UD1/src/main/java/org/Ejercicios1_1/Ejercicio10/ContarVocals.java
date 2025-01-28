package org.Ejercicios1_1.Ejercicio10;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.out;

public class ContarVocals {

    /**
     * DU1 - Exercise 10 - Java ProcessBuilder - count vowels
     * Create a program that is able to count how many vowels are in a file.
     * The parent program must launch five child processes, each of which will count a particular vowel
     * (which can be either lower or upper case).
     * Each vowel-counting process must leave the result in a file.
     * The parent program will then retrieve the results from the files,
     * add up all the subtotals and display the final result on the screen.
     *
     * Rsc: entrada1.10.txt
     * @param args
     */

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            // Verifica si el número de argumentos pasados al programa es menor a 3
            // Si no hay suficientes argumentos, imprime un mensaje indicando lo que se necesita y termina la ejecución
            out.println("Necesito 3 args. Vocal, archivo de entrada, archivo de salida");
            return; // Sale del programa porque no tiene los argumentos necesarios
        }

        // Definimos la ruta donde queremos guardar las salidas del programa
        Path rutaSalidas = Paths.get("./src/main/resources/salidas/salida1.10");

        // Verificamos si la ruta especificada no existe
        if (Files.notExists(rutaSalidas)) {
            // Si la ruta no existe, creamos los directorios necesarios para que exista
            Files.createDirectories(rutaSalidas);
        }

        //vocal que se va acontar
        char vocal = args[0].charAt(0);

        //archivo de entrada (se cuenta aqui)
        String archivoEn = args[1];

        //archivo de salida (se escribe el resultado aqui)
        String archivoSal = args[2];

        //contador
        int contador = 0;

        //leemos el archivo de entrada con Files, tenemos que pasarle el path del archivo.
        String lector = new String(Files.readAllBytes(Paths.get(archivoEn)));

        //contamos las vocales del string
        //pasamos el string a un array de caracteres.
        for(char c : lector.toCharArray()){
            //pasamos el caracter a minuscula y la vocal tambien para poder compararlas
            if (Character.toLowerCase(c) ==  Character.toLowerCase(vocal)){
                contador ++; //cada vez que son iguales se sumará una
            }
        }

        //ahora apuntamos el resultado en un archivo de salida
        try(PrintWriter salida = new PrintWriter(new FileWriter(archivoSal, false))){
            salida.write(String.valueOf(contador));
            //salida.println(contador); //sirven ambas
            out.println(contador);
        }catch (Exception e){
            System.err.println(e + "error, no se escribio el resultado");
        }

    }

}

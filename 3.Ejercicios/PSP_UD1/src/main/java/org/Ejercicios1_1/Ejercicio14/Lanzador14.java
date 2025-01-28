package org.Ejercicios1_1.Ejercicio14;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lanzador14 {
        /**
         * DU1 - Exercise 14 - Java ProcessBuilder
         * Finally, create another program that launches the two programs created earlier
         * using the same numbers and display the result on the standard output.
         * Use getInputStream and getOutputStream to communicate with the processes.
         * Programa que lanza los dos programas anteriores (`Sumador14` y `Elevador14`),
         * les pasa los mismos números como entrada y muestra sus salidas.
         * Programa que lanza los dos programas anteriores (`Sumador14` y `Elevador14`),
         * les pasa los mismos números como entrada y muestra sus salidas.
         */
        public static void main(String[] args) throws IOException {

            Scanner teclado = new Scanner(System.in);

            // Pedir la cantidad de números que se quieren procesar.
            System.out.println("Cuantos numeros quieres sumar y elevar?");
            int cant = teclado.nextInt();

            // Almacenar los números ingresados como texto para enviarlos a los procesos.
            String numTexto = "";
            int[] nums = new int[cant]; // Array para almacenar los números.

            // Leer cada número del usuario y construir la representación textual.
            for (int i = 0; i < cant; i++) {
                System.out.println("Escribe el " + (i + 1) + "º numero.");
                nums[i] = teclado.nextInt();
                numTexto += Integer.toString(nums[i]) + "\n"; // Concatenar los números separados por saltos de línea.
            }

            // Crear los ProcessBuilder para ejecutar `Sumador14` y `Elevador14`.
            ProcessBuilder pb1 = new ProcessBuilder("java", "-cp", "./target/classes", "org.Ejercicios1_1.Ejercicio14.Sumador14");
            ProcessBuilder pb2 = new ProcessBuilder("java", "-cp", "./target/classes", "org.Ejercicios1_1.Ejercicio14.Elevador14");

            // Lista para gestionar los procesos ejecutados.
            ArrayList<Process> procesos = new ArrayList<>();

            // Ejecutar el primer proceso (Sumador14) y agregarlo a la lista.
            Process p1 = pb1.start();
            procesos.add(p1);

            // Ejecutar el segundo proceso (Elevador14) y agregarlo a la lista.
            Process p2 = pb2.start();
            procesos.add(p2);

            // Enviar los números al proceso 1 (Sumador14).
            BufferedWriter escriba1 = new BufferedWriter(new OutputStreamWriter(p1.getOutputStream()));
            escriba1.write(cant + "\n"); // Enviar la cantidad de números.
            escriba1.write(numTexto); // Enviar los números.
            escriba1.flush(); // Forzar el envío de los datos.
            escriba1.close(); // Cerrar el flujo para indicar que terminamos.

            // Leer la respuesta del proceso 1.
            BufferedReader lector1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            String resultadoSumador = lector1.readLine(); // Leer la primera línea de la respuesta.
            String linea = "";
            while ((linea = lector1.readLine()) != null) { // Leer las líneas restantes.
                resultadoSumador += linea; // Acumular todas las líneas.
            }
            System.out.println("Resultado del Sumador14: \n" + resultadoSumador);
            lector1.close();

            // Enviar los números al proceso 2 (Elevador14).
            BufferedWriter escriba2 = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()));
            escriba2.write(cant + "\n"); // Enviar la cantidad de números.
            escriba2.write(numTexto); // Enviar los números.
            escriba2.flush();
            escriba2.close();

            // Leer la respuesta del proceso 2.
            BufferedReader lector2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            String resultadoElevador = lector2.readLine(); // Leer la primera línea de la respuesta.
            linea = "";
            while ((linea = lector2.readLine()) != null) { // Leer las líneas restantes.
                resultadoElevador += linea; // Acumular todas las líneas.
            }
            System.out.println("\nResultado del Elevador14: \n" + resultadoElevador);
            lector2.close();
        }
}

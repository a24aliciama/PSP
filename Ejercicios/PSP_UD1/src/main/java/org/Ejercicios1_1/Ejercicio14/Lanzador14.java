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
         */
        public static void main(String[] args) throws IOException {

            Scanner teclado = new Scanner(System.in);

            //como queremos enviar siempre los mismos numeros a ambos procesos vamos a preguntar primero los numeros
            System.out.println("cuantos numeros quieres sumar y elevar?");
            int cant = teclado.nextInt();

            //hacemso un array con el tamaño de cant
            int[] nums = new int[cant];
            for(int i = 0; i < cant; i++){
                System.out.println("escribe el " + (i+1) + "º numero.");
                nums[i] = teclado.nextInt();
            }

            String numerosComoTexto = nums.length + "\n" + Arrays.stream(nums)
                    .mapToObj(String::valueOf)
                    .reduce((x, y) -> x + "\n" + y)
                    .orElse("");

            //creamos los constructores de los procesos con los comandos de ejecucuion (previamente compilados)
            ProcessBuilder pb1 = new ProcessBuilder("java", "-cp", "./target/classes", "org.Ejercicios1_1.Ejercicio14.Sumador14");
            ProcessBuilder pb2 = new ProcessBuilder("java", "-cp", "./target/classes", "org.Ejercicios1_1.Ejercicio14.Elevador14");

            //creamos una lista de procesos
            ArrayList<Process> procesos = new ArrayList<Process>();

            //ejecutamos el proceso 1(Sumador) y los añadimos a la lista para poder esperar a que terminen
            Process p1 = pb1.start();
            procesos.add(p1);

            //ejecutamos el proceso 2(Elevador)
            Process p2 = pb2.start();
            procesos.add(p2);

            //primer proceso
            // Enviar los números al primer proceso (Sumador14)
            OutputStream os1 = p1.getOutputStream();
            BufferedWriter writer1 = new BufferedWriter(new OutputStreamWriter(os1));
            writer1.write(numerosComoTexto);
            writer1.flush();
            writer1.close();  // Cerramos el flujo de salida para indicar que hemos terminado de escribir

            // Leer la respuesta del proceso 1 (Sumador14)
            InputStream is1 = p1.getInputStream();
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(is1));
            String resultadoSumador = reader1.readLine();
            System.out.println("Resultado del Sumador14: " + resultadoSumador);
            reader1.close();




        }
}

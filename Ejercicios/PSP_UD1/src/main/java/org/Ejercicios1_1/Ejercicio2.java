package org.Ejercicios1_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {
    /**
     * DU1 - Exercise 2 - Java Runtime Class - RuntimeBirthday
     * Use the Java Runtime Class to launch the argument version encapsulated in the jar generated in the Birthday project.
     * <p>
     * Place the jar file in the resources folder of the new project.
     * Use java.util.Random to randomly generate the number of cases and each of the cases.
     * Display a message in the standard output to inform the user about the correct or incorrect execution of the Birthday argument program.
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */

    public static void main(String[] args) throws IOException, InterruptedException {
        // Importamos las clases necesarias para trabajar con procesos, listas y entrada/salida
        Random ran = new Random(); // Creamos un objeto Random para generar números aleatorios
        int random = ran.nextInt(10) + 1; // Generamos un número aleatorio entre 1 y 10
        String cant = String.valueOf(random); // Convertimos el número aleatorio a String

        // Creamos un array de Strings para guardar números aleatorios como argumentos
        String[] nums = new String[random];

        // Mostramos cuántos argumentos vamos a usar
        System.out.println(random + " argumentos");

        // Obtenemos la instancia de Runtime para ejecutar un proceso
        Runtime runtime = Runtime.getRuntime();

        // Creamos un ArrayList para construir el comando que vamos a ejecutar
        ArrayList<String> command = new ArrayList<>(Arrays.asList(
                "java", // El comando "java" para ejecutar un programa en Java
                "-cp", // Parámetro que indica la ruta del archivo JAR
                "./src/main/resources/BasicBirthday-1.0-SNAPSHOT.jar", // Ruta al JAR
                "org.example.BirthdayArgs", // Clase principal que queremos ejecutar
                cant // Primer argumento: el número de argumentos generados
        ));

        // Generamos los argumentos aleatorios y los añadimos al comando
        for (int i = 0; i < random; i++) {
            nums[i] = String.valueOf(ran.nextInt(100) + 1); // Generamos un número aleatorio entre 1 y 100
            command.add(nums[i]); // Lo añadimos al comando
            System.out.println(nums[i] + " arg num " + i); // Mostramos cada número generado
        }

        // Convertimos el ArrayList a un array de Strings para ejecutarlo con Runtime
        String[] comando = command.toArray(new String[0]);

        // Mostramos que vamos a ejecutar el comando
        System.out.println("ejecutamos");

        // Ejecutamos el proceso usando el comando construido
        Process process = runtime.exec(comando);

        // Creamos un Scanner para leer la salida estándar (stdout) del proceso
        Scanner sc = new Scanner(process.getInputStream());
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine()); // Imprimimos cada línea de la salida del proceso
        }

        sc.close(); // Cerramos el Scanner para liberar recursos

        // Esperamos a que el proceso termine y obtenemos su estado de salida
        int exitStatus = process.waitFor();
        System.out.println("Exit status process date " + exitStatus); // Mostramos el estado de salida

        /*
           - Si el estado de salida es 0, el proceso terminó bien.
           - Si es distinto de 0, hubo un error.
        */

        // Si hubo un error en el proceso (exitStatus != 0), mostramos la salida de error
        if (exitStatus != 0) {
            Scanner sce = new Scanner(process.getErrorStream()); // Leemos el flujo de error (stderr)
            while (sce.hasNextLine()) {
                System.out.println(sce.nextLine()); // Mostramos cada línea del error
            }
            sce.close(); // Cerramos el Scanner de error
        }
    }
}

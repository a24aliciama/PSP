package org.Ejercicios1_1;

import java.io.IOException;

public class Ejercicio1 {
    /**
     * DU1 - Exercise 1 - Java Runtime Class

     * Use the Java Runtime Class to do the following tasks:
     * Obtain the number of available processors for the JVM
     * Launch the Google Chrome browser
     * Launch YouTube on the Google Chrome browser
     * Launch notepad
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        // Obtenemos la instancia de Runtime para interactuar con el sistema
        Runtime runtime = Runtime.getRuntime();

        // Obtener el número de procesadores disponibles para la JVM
        int procesadores = runtime.availableProcessors();
        System.out.println("Número de procesadores disponibles: " + procesadores);

        // Lanzar Google Chrome
        System.out.println("Abriendo Google Chrome...");
        runtime.exec("C:/Program Files/Google/Chrome/Application/chrome.exe"); // Asegúrate de que esta ruta es correcta en tu sistema

        // Esperar un momento antes de lanzar YouTube (opcional, para observar los pasos)
        Thread.sleep(2000); // Pausa de 2 segundos

        // Abrir YouTube en Google Chrome
        System.out.println("Abriendo YouTube en Google Chrome...");
        runtime.exec(new String[]{"C:/Program Files/Google/Chrome/Application/chrome.exe", "https://www.youtube.com"});

        // Esperar un momento antes de lanzar Notepad
        Thread.sleep(2000); // Pausa de 2 segundos

        // Lanzar Notepad (Bloc de notas)
        System.out.println("Abriendo Notepad...");
        runtime.exec("notepad.exe");


    }
}

package org.example.ejercicio4;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageProcessor {

    // Ruta de las carpetas de entrada y salida
    private static final String INPUT_FOLDER = "src/main/resources/Entrada4";
    private static final String OUTPUT_FOLDER = "src/main/Salidas/Salida4";

    public static void main(String[] args) {
        // Crear un Thread Pool de tamaño 5
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Crear la carpeta de resultados si no existe
        File outputDir = new File(OUTPUT_FOLDER);
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        // Obtener los archivos de imagen en la carpeta de entrada
        File inputDir = new File(INPUT_FOLDER);
        File[] imageFiles = inputDir.listFiles((dir, name) ->
                name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpg"));

        if (imageFiles != null) {
            for (File imageFile : imageFiles) {
                // Crear una tarea Runnable para procesar la imagen
                Runnable task = new ImageTask(imageFile);
                // Enviar la tarea al Thread Pool
                executor.submit(task);
            }
        }

        // Apagar el Thread Pool después de enviar todas las tareas
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Esperar a que todas las tareas terminen
        }

        System.out.println("Todas las imágenes se han procesado correctamente.");
    }
}
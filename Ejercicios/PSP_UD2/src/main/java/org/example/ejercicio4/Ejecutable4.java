package org.example.ejercicio4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Ejecutable4 {

    /**
     * DU2 - Exercise 4 - Java Threads - Thread pool - Image processing
     * <p>
     * We want to create a multithreaded application.
     * The main thread must create a thread pool of size five.
     * Each thread must process an image placed in the resources/originals folder to convert its colours to grayscale.
     * Use the information given in the  following URL to perform the conversion:
     * https://www.geeksforgeeks.org/image-processing-in-java-colored-image-to-grayscale-image-conversion/
     * <p>
     * Place the processed images in a folder called results. The names of the processed images
     * should be the same as the names of the unprocessed images not but with _grey at the end.
     * Example:
     * lion.png when processed should be lion_grey.png.
     * Once all images have been processed, the program should terminate.
     */

        public static void main(String[] args) {
            File entradaC = new File("src/main/resources/Entrada4");
            File salidaC = new File("src/main/Salidas/Salida4");

            // Asegurarse de que la carpeta de resultados exista
            if (!salidaC.exists()) {
                salidaC.mkdirs();
            }

            // Crear un thread pool de 5 hilos
            ExecutorService ejecutor = Executors.newFixedThreadPool(5);

            // Obtener todas las imágenes en la carpeta "originals"
            File[] imageFiles = entradaC.listFiles((dir, name) -> name.toLowerCase().endsWith(".png") |name.toLowerCase().endsWith(".jpg"));

            //si es null paramos
            //assert imageFiles != null; //cosa nueva
            if (imageFiles== null | imageFiles.length == 0){
                System.out.println("No hay fotos en la carpeta");
                ejecutor.shutdown();
                return;
            }



                    // Lista para almacenar las tareas
            List<Callable<String>> tasks = new ArrayList<>();

            // Crear las tareas para cada imagen
            for (File imageFile : imageFiles) {
                File outputImageFile = new File(salidaC, imageFile.getName().replace(".png", "_grey.png"));
                tasks.add(new Calable4(imageFile, outputImageFile));
            }

            try {
                // Ejecutar todas las tareas en paralelo
                List<Future<String>> futures = ejecutor.invokeAll(tasks);

                // Esperar a que todas las tareas se completen y obtener el resultado
                for (Future<String> future : futures) {
                    System.out.println(future.get()); // Imprime el resultado de cada tarea
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                // Apagar el pool de hilos
                ejecutor.shutdown();
            }

            System.out.println("All images have been processed.");
        }

}

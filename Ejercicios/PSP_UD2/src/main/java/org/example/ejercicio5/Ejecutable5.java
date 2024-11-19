package org.example.ejercicio5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Ejecutable5 {
    /**
     * DU2 - Exercise 5 - Java Threads - Thread pool - Download files
     *
     * We want to create a multithreaded application.
     * The main thread must create a thread pool of size ten.
     * Use the file animal-urls.txt to get the URL from which download files.
     * Each thread must download a file from one of the URLs in animal-urls.txt.
     * Place the processed images in a folder called results.
     * The names of the processed files should be animali.jpg
     * where i is the number of the line in animal-urls.txt where the URL of the file is placed.
     * Once all files have been processed, the program should terminate.
     */

    final static int  NUM_THREADS = 10;
    private static final String ENTRADA = "src/main/resources/Entrada5";
    private static final String SALIDA = "src/main/Salidas/Salida5";

    public static void main(String[] args) throws InterruptedException {

        //comprobamos archivos entrada y salida
        //entrada
        File archivoEntrada = new File(ENTRADA);
        if (!archivoEntrada.exists()){
            System.err.println("El archivo de entrada no existe. Apagando...");
            System.exit(0);
        }else{
            System.out.println("El archivo de entrada existe");
        }

        //salida
        //mkdir() crea la carpeta si no existe, pero solo si el directorio padre ya existe.
        //mkdirs() crea la carpeta y todos los directorios intermedios si aún no existen.
        File carpetaSalida = new File(SALIDA);
        if (!carpetaSalida.exists()){
            carpetaSalida.mkdirs();
            System.out.println("Creando directorio de salida... (src/main/Salidas/Salida5)");
        }else{
            System.out.println("El archivo de salida existe");
        }


        //vamos a almacenar los url en una lista asi que la inicializamos
        List<String> links = new ArrayList<>();

        //leemos el archivo con un buffered
        try(BufferedReader br = new BufferedReader(new FileReader(ENTRADA))){
            String linea; //para almacenar el br
            while((linea = br.readLine()) != null ){
                links.add(linea); //añadimos la linea leida a los links
            }
        }catch (Exception e){
            System.err.println("Fallo de lectura");
        }

        //creamos un thread pool de 10
        ExecutorService ejecutor = Executors.newFixedThreadPool(NUM_THREADS);

        //hay que pasarle a cada thread un url del archivo de entrada
        //creamos un for del tamaño de la lista de links
        for (int i = 0; i < links.size(); i++){
            Runnable tarea = new Runeable5(links.get(i), i, SALIDA);
            ejecutor.submit(tarea);
        }

        //cerramos del executor
        ejecutor.shutdown();

        // Esperar 5 segundos a que termine
        if (ejecutor.awaitTermination(20, TimeUnit.SECONDS)) {
            System.out.println("Todas las tareas han terminado.");
        } else {
            System.out.println("No todas las tareas terminaron. Interrumpiendo...");
            ejecutor.shutdownNow(); // Interrumpir tareas activas
        }

    }
}

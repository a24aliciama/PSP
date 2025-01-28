package org.example.ejercicio5;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Runeable5 implements Runnable{
    String link;
    int posicion;
    String SALIDA;

    // Constructor
    public Runeable5(String link, int posicion, String salida) {
        this.link = link;
        this.posicion = posicion;
        this.SALIDA = salida;
    }

    @Override
    public void run() {
        try {
            // Crear un objeto URL
            URL url = new URL(link);

            // Abrir la conexión y obtener un flujo de entrada
            InputStream inputStream = url.openStream();

            // Crear el nombre del archivo usando la variable 'posicion' (ejemplo: animal1.jpg)
            String nombreArchivo = "animal" + posicion + ".jpg";  // Nombre del archivo con la posición
            Path carpeta = Paths.get(SALIDA);
            Path archivoDestino = carpeta.resolve(nombreArchivo);  // Unir la carpeta con el nombre del archivo

            // Usar Files.copy para copiar el flujo de entrada directamente al archivo
            Files.copy(inputStream, archivoDestino, StandardCopyOption.REPLACE_EXISTING);

            // Cerrar el flujo de entrada
            inputStream.close();

            System.out.println("Archivo descargado con éxito: " + nombreArchivo + archivoDestino);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

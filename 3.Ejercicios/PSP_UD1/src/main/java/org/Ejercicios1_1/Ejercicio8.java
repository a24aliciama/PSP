package org.Ejercicios1_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Ejercicio8 {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Definimos la ruta donde queremos guardar los archivos de salida
        Path rutaSalidas = Paths.get("src/main/resources/salidas");

        // Verificamos si el directorio no existe. Si no existe, lo creamos
        if (Files.notExists(rutaSalidas)) {
            Files.createDirectories(rutaSalidas); // Creamos el directorio
        }

        // Creamos la ruta para el archivo de salida donde se guardará el resultado
        Path rutatxt = rutaSalidas.resolve("salida1.8.txt");
        if (Files.notExists(rutatxt)) {
            Files.createFile(rutatxt); // Si el archivo no existe, lo creamos
        }

        // Creamos un objeto ProcessBuilder para configurar el comando a ejecutar
        ProcessBuilder pB = new ProcessBuilder();

        // Configuramos el comando que queremos ejecutar:
        // - "cmd" inicia el intérprete de comandos
        // - "/C" indica que queremos ejecutar un comando y cerrar el intérprete después
        // - "tracert" es el comando que rastrea la ruta hasta una dirección web
        // - "iessanclemente.net" es el dominio que queremos rastrear
        pB.command("cmd", "/C", "tracert", "iessanclemente.net");

        // Redirigimos la salida del comando al archivo "salida1.8.txt"
        pB.redirectOutput(rutatxt.toFile()); // Usa un buffer interno para escribir en el archivo

        // Iniciamos el proceso usando el ProcessBuilder configurado
        Process proceso = pB.start();

        // Esperamos hasta 500 milisegundos (medio segundo) para que el proceso termine
        if (!proceso.waitFor(500, TimeUnit.MILLISECONDS)) {
            // Si el proceso no termina en 500ms, lo destruimos forzosamente
            proceso.destroyForcibly();
            // Lanzamos una excepción indicando que el proceso fue interrumpido
            throw new InterruptedException("Han pasado 500 milisegundos, el proceso se interrumpió");
        }

        // Verificamos si el proceso sigue vivo (aunque esto no debería pasar si lo destruimos)
        if (proceso.isAlive()) {
            System.out.println("holiii. sigo aqui"); // Mensaje en caso de que el proceso no haya terminado
        }
    }
}

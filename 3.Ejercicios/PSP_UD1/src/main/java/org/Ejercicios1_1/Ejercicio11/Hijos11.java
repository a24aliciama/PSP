package org.Ejercicios1_1.Ejercicio11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.out;

public class Hijos11 {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            // Verifica si el número de argumentos pasados al programa es menor a 2.
            // Si no hay suficientes argumentos, muestra un mensaje indicando lo necesario y termina la ejecución.
            out.println("Necesito 1 args. archivo de entrada y nombre del archivo");
            return; // Detiene la ejecución del programa.
        }

    // Archivo de entrada (especificado en el primer argumento).
        String archivoEn = args[0];

    // Nombre asociado al archivo o al resultado (segundo argumento).
        String nombre = args[1];

    // Inicializamos un contador para acumular los valores numéricos leídos del archivo.
        double contador = 0;

    // Definimos un número de departamento como una cadena (puede usarse como una referencia).
        String depa = "101";

    // Creamos una ruta para un archivo de prueba (aunque no se utiliza en el programa final).
        String prueba = "./src/main/resources/entradas/departamentos11/department" + depa + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEn))) {
            // Abrimos un archivo de entrada utilizando un BufferedReader.
            // Esto permite leer el archivo línea por línea de manera eficiente.

            String linea; // Variable para almacenar cada línea del archivo.

            // Leemos línea por línea mientras haya contenido en el archivo.
            while ((linea = br.readLine()) != null) {
                try {
                    // Intentamos convertir la línea leída a un número decimal (double).
                    double numero = Double.parseDouble(linea);

                    // Si la conversión es exitosa, lo sumamos al contador.
                    contador += numero;

                } catch (NumberFormatException e) {
                    // Si no se puede convertir la línea a un número (por ejemplo, contiene texto no numérico),
                    // mostramos un mensaje indicando el error y la línea problemática.
                    System.out.println("Error al convertir el número: " + linea);
                }
            }
        } catch (IOException e) {
            // Si ocurre un error al leer el archivo (por ejemplo, el archivo no existe o no se puede abrir),
            // mostramos un mensaje de error con la descripción del problema.
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

    // Imprimimos el resultado:
        out.println("====================="); // Separador visual.
        out.println(nombre);          // Imprimimos el nombre pasado como argumento.
        out.println("---------------------"); // Otro separador.
        System.out.printf("%.2f", contador); // Imprimimos el valor acumulado del contador con dos decimales.

    }
}


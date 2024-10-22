package org.Ejercicios1_1.Ejercicio11;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Padre11 {

    /**
     * DU1 - Exercise 11 - Java ProcessBuilder - departments
     * Make a program that goes through all the files in the departments directory calculating
     * the sum of the values stored in each of the files and creates a report in a file with this information.
     * The program must create one process for each file. The code for each process must be the same.
     */

    public static void main(String[] args) throws IOException, InterruptedException {
        //directorio donde tenemos los depas
        Path archivoEnt = Paths.get("./src/main/resources/entradas/departamentos11");

        //depas
        String[] depas = {"101","102","103","105","106","107","108"};

        //necesitamos un archivo de salida para el proceso
        Path rutaSalida = Paths.get("./src/main/resources/salidas/salida11.txt");
        if (Files.notExists(rutaSalida)){
            Files.createFile(rutaSalida);
        }

        //vamos a iniciar procesos y a meterlos en una lista para poder controlarlos a la vez
        //creamos una lista donde meterlos una vez iniciados
        List<Process> procesos = new ArrayList<>();

        //primero los creamos y los iniciamos
        for (String depa : depas){

            //creamos la ruta de lo que tienen que leer los procesos
            Path archivo = archivoEnt.resolve("department" + depa + ".txt");
            String ruta = archivo.toString();

            System.out.println("Hola soy la ruta del " + depa + ". " + ruta + "     chao");

            //iniciamos el proceso correspondiente al depa
            try {
                ProcessBuilder pb = new ProcessBuilder("java", "-cp" , ".\\target\\classes\\",
                        "org.Ejercicios1_1.Ejercicio11.Hijos11", ruta , "department" + depa + ".txt");

                //iniciamos el proceso
                Process p = pb.start();

                //lo incluimos en la lista de procesos
                procesos.add(p);

            }catch (Exception e){
                System.err.println(e + "no esta bien el comando");
            }
        }
        //String de respuesta general
        String fin = "";

        for (Process pp : procesos){
            pp.waitFor();

            //recoger la respuesta
            BufferedReader lector = new BufferedReader(new InputStreamReader(pp.getInputStream()));
            String resultado = lector.readLine();
            String linea = "";
            while((linea = lector.readLine()) != null){
                resultado += "\n" + linea;
            }

            lector.close();

            fin += resultado + "\n";
        }

        // escribir el contenido en el txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaSalida.toFile()))) {
            writer.write(fin);
            System.out.println("El archivo se ha escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }


    }
}

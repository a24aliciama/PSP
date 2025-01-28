package org.Ejercicios1_1.Ejercicio10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContadorPrincipal {

    /**
     * Contador de vocales padre: llamará a ContarVocals 5 veces.
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */

    public static void main(String[] args) throws IOException, InterruptedException {

        //archivo donde vamos a contar las vocales
        String archivoEnt = "./src/main/resources/entradas/entrada1.10.txt";

        //vocales a contar
        String[] vocales = {"a","e","i","o","u"};

        //necesitamos una carpeta de salida para el proceso
        Path rutaSalidas = Paths.get("./src/main/resources/salidas/salida1.10");
        if (Files.notExists(rutaSalidas)){
            Files.createDirectories(rutaSalidas);
        }

        //vamos a iniciar 5 procesos y a meterlos en una lista para poder controlarlos a la vez
        //creamos una lista donde meterlos una vez iniciados
        List<Process> procesos = new ArrayList<>();

        //primero los creamos y los iniciamos
        for (String vocal : vocales){
            //creamos el archivo de salida si no esta creado
            Path rutatxt = rutaSalidas.resolve("resultado_" + vocal + ".txt");
            if (Files.notExists(rutatxt)){
                Files.createFile(rutatxt);
            }
            //pasamos el Path a string para poder pasarlo como arg al hijo
            String archivoSali = rutatxt.toString();

            //iniciamos el proceso correspondiente a la vocal
           try {
               ProcessBuilder pb = new ProcessBuilder("java", "-cp" , ".\\target\\classes\\",
                       "org.Ejercicios1_1.Ejercicio10.ContarVocals",
                       vocal, archivoEnt, archivoSali);

               //iniciamos el proceso
               Process p = pb.start();

               //lo incluimos en la lista de procesos
               procesos.add(p);

           }catch (Exception e){
               System.err.println(e + "no esta bien el comando");
           }

        }

        //ahora vamos a esperar a que todos los procesos esten terminados
        for (Process pp : procesos){
            pp.waitFor();
        }

        //una vez terminados debemos leer los archivos de salida y sumar los resultados
        //contador de la suma
        int contadorTotal = 0;

        //necesitamos leer los archivos uno a uno
        for (String vocal : vocales) {
            //de donde lo leemos
            Path rutatxt = rutaSalidas.resolve("resultado_" + vocal + ".txt");
            String salida = rutatxt.toString();

            //intentamos leerlo con un buffer que crea un lector de archivos
            try(BufferedReader lector = new BufferedReader(new FileReader(rutatxt.toFile()))){

                //si lo lee creamos un contador para el num de esa vocal
                int contarVocal = Integer.parseInt(lector.readLine()); //solo habra una linea (el num de esa vocal)

                //imprimimos el numero de vocales que habia en el archivo
                System.out.println("Numero de " + vocal + ": " +  contarVocal );

                //sumamos el num al total
                contadorTotal += contarVocal;
            }
        }

        //mostramos el total de vocales
        System.out.println("Total: "+ contadorTotal);


    }
}

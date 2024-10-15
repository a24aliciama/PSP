package org.Ejercicios1_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Ejercicio8 {

    public static void main(String[] args) throws IOException, InterruptedException {

        Path rutaSalidas = Paths.get("src/main/resources/salidas");
        if (Files.notExists(rutaSalidas)){
            Files.createDirectories(rutaSalidas);
        }

        Path rutatxt = rutaSalidas.resolve("salida1.8.txt");
        if (Files.notExists(rutatxt)){
            Files.createFile(rutatxt);
        }

        ProcessBuilder pB = new ProcessBuilder();
        pB.command("cmd","/C","tracert","iessanclemente.net");
        pB.redirectOutput(rutatxt.toFile()); //usa buffer

        Process proceso = pB.start();

        if(!proceso.waitFor(500, TimeUnit.MILLISECONDS)){
            proceso.destroyForcibly();
            throw new InterruptedException("Han pasado 500 milisegundos, el proceso se interrumpio");
        }
        if (proceso.isAlive()){
            System.out.println("holiii. sigo aqui");
        }





    }
}

package org.RunTimeExec;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CmdDate {
    public static void main(String[] args) throws IOException, InterruptedException {

        /**
         * Comando de windows hay que llamar a cmd
         * se abre un proceso donde command1 en el padre y command2 se habre dentro del padre
         * El barra c es para que cuando remates peches o command.
         * falta recibir os datos
         * cojo los datos del proceso, luego los paso al escaner y este debe leer todas las lineas
         * se puede usar el buffered reader
         */

        Runtime runtime = Runtime.getRuntime();
        String[] command = {"cmd","/C","dater","/t"};

        Process process = runtime.exec(command);  //Ahora hace falta para recoger los datos
        Scanner sc = new Scanner(process.getInputStream()); //el escaner lee los datos

        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }

        sc.close(); //borra el objeto scanner


        int exitStatus = process.waitFor();
        System.out.println("Exit status process date " + exitStatus);
        /* si tenemos un error saldra 1 y si va bien 0  sin embargo tenemos un error que no aparecera*/
        if(exitStatus != 0){
            Scanner sce = new Scanner(process.getErrorStream()); //asi podemos leer la salida de error que es distinta a la salida de input
            while(sce.hasNextLine()){
                System.out.println(sce.nextLine());
            }
            sce.close();
        }









    }
}
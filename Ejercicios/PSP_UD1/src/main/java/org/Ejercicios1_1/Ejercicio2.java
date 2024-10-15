package org.Ejercicios1_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {
    /**
     * DU1 - Exercise 2 - Java Runtime Class - RuntimeBirthday
     * Use the Java Runtime Class to launch the argument version encapsulated in the jar generated in the Birthday project.
     *
     * Place the jar file in the resources folder of the new project.
     *
     * Use java.util.Random to randomly generate the number of cases and each of the cases.
     *
     * Display a message in the standard output to inform the user about the correct or incorrect execution of the Birthday argument program.
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Random ran = new Random();
        int random = ran.nextInt(10)+1;
        String cant = String.valueOf(random); //pasa de int a string

        String[] nums = new String[random];

        System.out.println(random + " argumentos");

        Runtime runtime = Runtime.getRuntime();
        ArrayList<String> command = new ArrayList<>(Arrays.asList("java","-cp",
                "./src/main/resources/BasicBirthday-1.0-SNAPSHOT.jar",
                "org.example.BirthdayArgs",cant));

        for (int i = 0; i < random; i++){

            nums[i]= String.valueOf(ran.nextInt(100)+1);
            command.add(nums[i]);
            System.out.println(nums[i]+ " arg num " + i);
        }

        String[] comando = command.toArray(new String[0]);

        System.out.println("ejecutamos");

        Process process = runtime.exec(comando);

        Scanner sc = new Scanner(process.getInputStream()); //el escaner lee los datos
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        sc.close();

        int exitStatus = process.waitFor();
        System.out.println("Exit status process date " + exitStatus);
        /* si tenemos un error saldra 1 y si va bien 0  sin embargo tenemos un error que no aparecera*/
        if(exitStatus != 0){
            Scanner sce = new Scanner(process.getErrorStream()); //asi podemos leer la salida de error que es distinta a la salida de input
            while(sce.hasNextLine()){
                System.out.println(sce.nextLine());
            }
            sce.close();//borra el objeto scanner
        }

    }
}

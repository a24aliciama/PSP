package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {
    /**
     * DU1 - Exercise 2 - Java Runtime Class - RuntimeBirthday
     *
     *
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
        int random = ran.nextInt(10);
        String cant = String.valueOf(random); //pasa de int a string

        String[] nums = new String[random];

        System.out.println(random);
        System.out.println(cant);

        Runtime runtime = Runtime.getRuntime();
        String[] command = {"java", "-cp","./src/main/resources/BasicBirthday-1.0-SNAPSHOT.jar", "org.example.BirthdayArgs", cant,  };

        Process process = runtime.exec(command);

        for (int i = 0; i < random; i++){

            nums[i]= String.valueOf(ran.nextInt(100));
            System.out.println(nums[i]);
            command.add(nums[i]);
        }


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

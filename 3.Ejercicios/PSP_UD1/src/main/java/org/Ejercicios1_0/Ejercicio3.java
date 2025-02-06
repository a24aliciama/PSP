package org.Ejercicios1_0;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * DU1 - Review Exercise 3 - Java - Git repository - Steps
 * Create a Java program for the following scenario by creating a maven project in IntellijIDEA.
 * Add the project to a Git repository. Create a README.md.
 * Suppose a person who is able to climb several steps in one go.
 * This ability has led them to travel the world participating in so-called vertical races,
 * such as the world's oldest and most famous tower race in which participants
 * must climb the 1576 steps of the Empire State Building.
 * A normal person would need 1576 steps to climb all those steps.
 * Climbing them two at a time, 788 would be enough, and three at a time only 526.

 * Input
 * The first number in the input indicates how many test cases are to be processed.
 * It is followed by a line for each test case, with two numbers between 1 and 1,000,000.
 * The first one indicates the number of steps and the second one indicates how many steps can be climbed at a time.

 * Example of input
 * 5
 * 1576 1
 * 1576 2
 * 1576 3
 * 4000 1999
 * 3 4

 * Output
 * For each test case the minimum number of jumps needed to climb all the rungs shall be written.
 * Example of output
 * 1576
 * 788
 * 526
 * 3
 * 1

 * Use Javadoc comments to document the program.
 * The final version of the project must be in the Git repository.
 * Execute the program from the command line.
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("A continuacion pon cuantos casos escribiras. " +
                "Despues escribe en cada linea dos numeros el primero, los escalones " +
                "y el segundo, los escalones que puedes subir de un paso.");

        Scanner teclado = new Scanner(System.in);

        int casos = teclado.nextInt();
        teclado.nextLine(); //hacer nextline y me ahorro estas cosiñas

        List<Integer> escalones = new ArrayList<>();
        List<Integer> pasos = new ArrayList<>();


        for(int i = 0; i < casos; i ++){
            String[] nums = new String[2];
            String frase = teclado.nextLine().trim();//trim quita espacios al principio y al final.
            //System.out.println("'" + frase + "'");
            nums = frase.split("\\s+");

            escalones.add(Integer.valueOf(nums[0]));
            pasos.add(Integer.valueOf(nums[1]));
        }

        for(int i = 0; i < casos; i++){
            System.out.println((int) Math.ceil((double) escalones.get(i)/pasos.get(i)));
        }
    }
}

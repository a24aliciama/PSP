package org.BirthdayArgs;

import java.util.Scanner;

/**
 * Calcula cuantos 1 tendria en binario un numero entero.
 */

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BirthdayStdrIN {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("How old are you going to be?\r");
        Scanner keyboard = new Scanner(System.in);
        int num = keyboard.nextInt();
        int ncandles = 0;


        System.out.print("Wow " + num + " years old. So... you need ");

        do{
            if(num %2 != 0){
                ncandles ++;
            }

            num = num/2;
            //System.out.println(" " + num );

        }while(num != 0);

        System.out.println( " " + ncandles + " candles\r");

        //String binario = Integer.toBinaryString(num)
        //binario
    }
}
package org.example.ejercicio6;

import java.util.Random;
import java.util.concurrent.Callable;

public class Calable6_CreaNums implements Callable<String> {



    public Calable6_CreaNums(){
    }


    @Override
    public String call() throws Exception {
        Random ran = new Random();
        StringBuilder numS = new StringBuilder();

        int tamanho = ran.nextInt(31)+ 20; // (50 - 20 + 1 = 31)

        int num = ran.nextInt(9) + 1; //(9-1 + 1 = 9)
        numS.append(num);

        for (int j = 0; j < tamanho; j++){
            num = ran.nextInt(10);
            numS.append(num);
        }

        return String.valueOf(numS);
    }
}

package org.example.ejercicio9;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Runeable9 implements Runnable {

    int intento;

    NumOculto9 numOculto;

    public Runeable9(NumOculto9 numOculto) {
        this.numOculto =  numOculto;
    }

    @Override
    public void run() {
        Random ran = new Random();


        do {
            //probamos suerte a ver si es el num
            intento = ran.nextInt(101);

            //imprimir
            if (numOculto.numberGuess(intento) == 1) {
                System.out.println("NUMERO ENCONTRADO :" + intento + " = " + numOculto.getAleatorio());
            }else {
                System.out.println(intento + "; " + numOculto.getAleatorio());
            }

        }while (numOculto.numberGuess(intento) == 0);

        if (numOculto.numberGuess(intento) == -1) {
            System.out.println("Game over");
        }
    }
}

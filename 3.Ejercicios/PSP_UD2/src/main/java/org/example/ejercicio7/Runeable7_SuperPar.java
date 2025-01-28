package org.example.ejercicio7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Runeable7_SuperPar implements Runnable{

    Number7 num;
    int orden;

    public Runeable7_SuperPar(Number7 num, int orden){
        this.num = num;
        this.orden = orden;
    }



    @Override
    public void run() {
        //debemos comprobar si el num es super par
        //creamos el pool de 2
        ExecutorService ejecutor = Executors.newFixedThreadPool(2);

        //le pasamos cada digito por separado del numero para que compruebe que es par
        String digitos = String.valueOf(num.getValue());

        for (int i = 0; i < digitos.length(); i++){
            int digito = Character.getNumericValue(digitos.charAt(i));

            Runnable tarea = new Runeable7_DigitoPar(num, digito);
            ejecutor.submit(tarea);

        }

        //cerramos el ejecutor
        ejecutor.shutdown();

        //esperamos por si no termino
        try {
            if(ejecutor.awaitTermination(20, TimeUnit.SECONDS)) {
                ejecutor.shutdownNow();
            }else {
                System.out.println("No han terminado las tareas2");
                System.exit(1);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

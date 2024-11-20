package org.example.ejercicio7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Runeable7_SuperPar implements Runnable{

    int num;
    int orden;

    public Runeable7_SuperPar(int num, int orden){
        this.num = num;
        this.orden = orden;
    }



    @Override
    public void run() {
        //debemos comprobar si el num es super par
        //creamos el pool de 2
        ExecutorService ejecutor = Executors.newFixedThreadPool(2);

        //le pasamos todos los digitos del numero para que compruebe que son pares
        Runnable tarea = new Runeable7_DigitoPar(num);
        ejecutor.submit(tarea);


        //cerramos el ejecutor
        ejecutor.shutdown();

        //esperamos por si no termino
        try {
            if(!ejecutor.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("No han terminado las tareas");
                ejecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //RESULTADO
        String resultado = _esSuperPar.get()? "es SUPERPAR":"NO es superpar";
        System.out.println(orden + "º numero: " + num + " " + resultado);
    }
}

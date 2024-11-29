package org.example.ejercicio10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BandejaEntrada5_10 {
    private String mensaje;
    private boolean hayMensaje = false;
    private boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        BandejaEntrada5_10 bandejaEntrada510 = new BandejaEntrada5_10();
        Random ran = new Random();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            Thread productor = new Thread(() -> {
                while (bandejaEntrada510.run){
                    //bucle infinito de mensajes
                    try {
                        bandejaEntrada510.dejarMensaje();
                        Thread.sleep(ran.nextInt(1000));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

            }, "Productor-" + (i + 1));
            threads.add(productor);
            productor.start();

            Thread consumidor = new Thread(() -> {
                while (bandejaEntrada510.run){
                    //bucle infinito de mensajes
                    try {
                        bandejaEntrada510.recoger();
                        Thread.sleep(ran.nextInt(1000));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }, "Consumidor-" + (i + 1));
            threads.add(consumidor);
            consumidor.start();
        }

        Thread.sleep(10000);
        bandejaEntrada510.stop();

        for (Thread t : threads) {
            t.interrupt();
        }
        for (Thread t : threads) {
            t.join();
        }
    }

    //metodos sincronizados para configurar los threads
    public synchronized void dejarMensaje() throws InterruptedException {
        while (hayMensaje){
            wait();
        }
        hayMensaje = true;
        System.out.println(Thread.currentThread().getName() + " deposito el msg");
        notifyAll(); //avisa a otros threads que esten esperando
    }

    public synchronized void recoger() throws InterruptedException {
        while (!hayMensaje){
            wait();
        }
        hayMensaje = false;
        System.out.println(Thread.currentThread().getName() + " recogio el msg");
        notifyAll();
    }

    public void stop(){
        run = false;
    }
}

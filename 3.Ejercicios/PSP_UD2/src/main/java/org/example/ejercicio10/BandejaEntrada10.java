package org.example.ejercicio10;

import java.util.Random;

public class BandejaEntrada10 {
    private String mensaje;
    private boolean hayMensaje = false;
    private boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        BandejaEntrada10 bandejaEntrada = new BandejaEntrada10();
        Random ran = new Random();

        Thread productor = new Thread(() -> {
            int cont = 1;
            while (bandejaEntrada.run){
                //bucle infinito de mensajes
                try {
                    bandejaEntrada.dejarMensaje("Mensaje nº: " + (cont++));
                    Thread.sleep(ran.nextInt(1000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        });

        Thread consumidor = new Thread(() -> {
            while (bandejaEntrada.run){
                //bucle infinito de mensajes
                try {
                    bandejaEntrada.recoger();
                    Thread.sleep(ran.nextInt(1000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        });

        productor.start();
        consumidor.start();

        Thread.sleep(10000);
        bandejaEntrada.stop();
        productor.interrupt();
        consumidor.interrupt();
        productor.join();
        consumidor.join();


    }

    //metodos sincronizados para configurar los threads
    public synchronized void dejarMensaje(String mensaje) throws InterruptedException {
        while (hayMensaje){
            wait();
        }
        this.mensaje = mensaje;
        hayMensaje = true;
        System.out.println(mensaje + " depositado");
        notifyAll(); //avisa a otros threads que esten esperando
    }

    public synchronized void recoger() throws InterruptedException {
        while (!hayMensaje){
            wait();
        }
        hayMensaje = false;
        String mensajeRecogido = mensaje;
        System.out.println(mensaje + " recogido");
        notifyAll();
    }

    public void stop(){
        run = false;
    }
}

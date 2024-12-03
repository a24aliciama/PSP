package org.example.ejercicio11;

public class Ejecutor11 {
    public static void main(String[] args) throws InterruptedException {
        //mesa compartida
        Mesa mesa = new Mesa();

        //hilos 3 fumadores y un estanco
        Fumador estebanF1 = new Fumador(mesa,"tabaco");
        estebanF1.setName("Esteban");

        Fumador jorgeF2 = new Fumador(mesa, "papel");
        jorgeF2.setName("Jorge");

        Fumador aliciaF3 = new Fumador(mesa, "cerillas");
        aliciaF3.setName("Alicia");

        Estanco alvaroEst = new Estanco(mesa);
        alvaroEst.setName("Tabaquero Alvaro");

        //iniciamos hilos
        alvaroEst.start();

        estebanF1.start();
        jorgeF2.start();
        aliciaF3.start();

        Thread.sleep(10000);

        alvaroEst.pararEstanco();
        aliciaF3.pararFumador();
        estebanF1.pararFumador();
        jorgeF2.pararFumador();

        aliciaF3.interrupt();
        aliciaF3.join();
        System.out.println("Alicia se murio de cancer");

        estebanF1.interrupt();
        estebanF1.join();
        System.out.println("Esteban se murio de cancer");

        jorgeF2.interrupt();
        jorgeF2.join();
        System.out.println("Jorge se murio de cancer");

        alvaroEst.interrupt();
        alvaroEst.join();
        System.out.println("Alvaro cerro el estanco");

        System.exit(0);

    }
}

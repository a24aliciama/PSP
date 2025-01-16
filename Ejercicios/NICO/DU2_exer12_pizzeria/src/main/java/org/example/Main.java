package org.example;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Pizzeria pizzeria = new Pizzeria();
        Deliverer deliverer = new Deliverer(pizzeria);
        Cook cook = new Cook(pizzeria);

        Thread thCook = new Thread(cook);
        Thread thDeliverer = new Thread(deliverer);

        thDeliverer.start();
        thCook.start();
        thDeliverer.join();
        thCook.join();

    }
}
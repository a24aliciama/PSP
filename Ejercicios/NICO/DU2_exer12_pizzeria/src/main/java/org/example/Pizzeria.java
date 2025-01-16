package org.example;

import java.util.LinkedList;

public class Pizzeria {
    LinkedList<Pizza> tray;

    public Pizzeria(){
        tray = new LinkedList<Pizza>();
    }

    public synchronized void put(Pizza pizza) throws InterruptedException {
        while (tray.size() >= 5){
            wait();
        }
        tray.add(pizza);
        System.out.println("Cooked: " + pizza.id + " Price: " + pizza.price);
        notifyAll();
    }

    public synchronized Pizza get() throws InterruptedException {
        while (tray.isEmpty()){
            wait();
        }

        Pizza pizza = tray.getFirst();
        tray.removeFirst();
        System.out.println("Delivered: " + pizza.id + " Price: " + pizza.price);
        notifyAll();
        return pizza;
    }
}

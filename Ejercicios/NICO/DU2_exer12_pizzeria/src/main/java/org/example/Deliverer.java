package org.example;

import java.util.Random;

public class Deliverer implements Runnable{
    Pizzeria pizzeria;

    public Deliverer (Pizzeria pizzeria){
        this.pizzeria = pizzeria;
    }

    @Override
    public void run() {

        while (true){
            try {
                Random random = new Random();
                Pizza pizza = pizzeria.get();

                Thread.sleep(random.nextInt(1000, 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

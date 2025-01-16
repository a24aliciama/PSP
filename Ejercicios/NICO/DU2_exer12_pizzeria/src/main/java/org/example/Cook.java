package org.example;

import java.util.Random;

public class Cook implements Runnable{
    Pizzeria pizzeria;
    int id;

    public Cook (Pizzeria pizzeria){
        this.pizzeria = pizzeria;
        id = 0;
    }

    @Override
    public void run() {

        while (id <= 100){
            Pizza pizza = new Pizza(id);
            id++;
            try {
                Random random = new Random();
                pizzeria.put(pizza);

                Thread.sleep(random.nextInt(500, 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

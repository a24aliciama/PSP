package org.example;


import java.util.Random;

public class Pizza {
    int id;
    int price;

    public Pizza(int id) {
        Random random = new Random();
        this.id = id;
        this.price = random.nextInt(0,51);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

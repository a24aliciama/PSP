package org.example;

public class Bakery {
    public static void main(String[] args) throws InterruptedException {
        TakeANumber takeANumber = new TakeANumber();

        Baker baker = new Baker(takeANumber);
        Thread thBaker = new Thread(baker);
        thBaker.start();

        for (int i = 1; i <= 100; i++){
            Client client = new Client(takeANumber);
            Thread thClient = new Thread(client, "Client" + i);
            thClient.start();
        }


    }
}
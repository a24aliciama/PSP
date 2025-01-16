package org.example;

import java.util.Random;

public class Consumer implements Runnable {
    private MailBox mailBox;

    public Consumer(MailBox mailBox) {
        this.mailBox = mailBox;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                String val = mailBox.get();
                System.out.println("The consumer got " + val);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
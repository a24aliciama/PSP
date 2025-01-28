package org.example;

import java.util.Random;

public class Producer implements Runnable {
    private MailBox mailBox;

    public Producer(MailBox mailBox) {
        this.mailBox = mailBox;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                int num = random.nextInt(100);
                System.out.println("Producer produced the message " + num);
                mailBox.put(num + "");
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
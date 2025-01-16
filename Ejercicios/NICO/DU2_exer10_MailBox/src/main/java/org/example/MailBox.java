package org.example;

public class MailBox {
    private String message;
    private boolean available = false;

    public synchronized void put(String message) throws InterruptedException {
        while (available){
            wait();
        }
        this.message = message;
        available=true;
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while (!available){
            wait();
        }
        available = false;
        notifyAll();
        return this.message;
    }
}

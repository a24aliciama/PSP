package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RandomRunnable());
        Thread t2 = new Thread(new RandomRunnable());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Main thread name: " + Thread.currentThread().getName());
    }
}
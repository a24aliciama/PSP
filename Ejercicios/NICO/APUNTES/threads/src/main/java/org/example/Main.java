package org.example;

public class Main {
    public static void main(String[] args) {

        InfoRunnable ir = new InfoRunnable();
        Thread t1 = new Thread(ir);
        Thread t2 = new Thread(ir);
        Thread t3 = new Thread(ir,"T3");
        Thread t4 = new Thread(
                new Runnable(){
                    @Override
                    public void run() {
                        System.out.println("Runable anonymous");
                    }
                }
        );
        Thread t5 = new Thread(
                () -> System.out.println("Lambda Runnable")
        );


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
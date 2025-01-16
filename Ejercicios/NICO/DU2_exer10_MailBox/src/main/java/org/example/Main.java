package org.example;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MailBox mailBox = new MailBox();
        Consumer consumer = new Consumer(mailBox);
        Producer producer = new Producer(mailBox);

        Thread thProducer = new Thread(producer);
        Thread thConsumer = new Thread(consumer);

        thConsumer.start();
        thProducer.start();
        thProducer.join();
        thConsumer.join();


        ExecutorService producerPool = Executors.newFixedThreadPool(5);
        ExecutorService consumerPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            producerPool.submit(new Thread(new Consumer(mailBox)));
            consumerPool.submit(new Thread(new Producer(mailBox)));

        }
        producerPool.shutdown();
        consumerPool.shutdown();

        producerPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        consumerPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

    }
}
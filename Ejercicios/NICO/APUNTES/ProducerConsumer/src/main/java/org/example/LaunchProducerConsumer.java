package org.example;


public class LaunchProducerConsumer {
    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource();
        Consumer consumer = new Consumer(resource);
        Producer producer = new Producer(resource);

        Thread thProducer = new Thread(producer);
        Thread thConsumer = new Thread(consumer);

        thConsumer.start();
        thProducer.start();
        thProducer.join();
        thConsumer.join();

    }
}
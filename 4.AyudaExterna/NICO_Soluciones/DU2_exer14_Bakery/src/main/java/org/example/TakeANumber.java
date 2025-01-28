package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TakeANumber {
    boolean attending = false;
    int currentNum = 1;
    //crea una lista con los numeros del 1 al 100
    List<Integer> ticketNumbers = new ArrayList<>();

    public TakeANumber(){
        for (int i = 1; i <= 100; i++){
            ticketNumbers.add(i);
        }
    }

    public synchronized int getCurrentNum() {
        return currentNum;
    }

    public synchronized void put() throws InterruptedException {
        while (attending){
            wait();
        }
        currentNum++;
        System.out.println("Baker put the ticked"+ currentNum +" waiting for client");
        attending = true;
        Thread.sleep(1000);
        notifyAll();
    }

    public synchronized void get(int ticketNum) throws InterruptedException {
        while(currentNum != ticketNum){
            wait();
        }
        attending = false;
        System.out.println( Thread.currentThread().getName() + " was attended with the number " + ticketNum);
        notifyAll();
    }

    public synchronized int getTicketNumber() throws InterruptedException {
        Random random = new Random();
        while (ticketNumbers.isEmpty()){
            wait();
        }
        int randomIndex = random.nextInt(ticketNumbers.size());
        int ticketNum = ticketNumbers.get(randomIndex);
        ticketNumbers.remove(randomIndex);
        Thread.sleep(random.nextInt(500, 1000));
        notifyAll();
        return ticketNum;
    }
}

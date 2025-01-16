package org.example;

public class Client implements Runnable{
    TakeANumber takeANumber;
    int ticketNumber;

    public Client(TakeANumber takeANumber) throws InterruptedException {
        this.takeANumber = takeANumber;
        this.ticketNumber = takeANumber.getTicketNumber();
    }

    @Override
    public void run() {
        try {
            takeANumber.get(ticketNumber);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

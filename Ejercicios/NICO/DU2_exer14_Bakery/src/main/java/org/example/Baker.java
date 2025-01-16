package org.example;

public class Baker implements Runnable{
    TakeANumber takeANumber;


    public Baker(TakeANumber takeANumber) {
        this.takeANumber = takeANumber;
    }

    @Override
    public void run() {
        while (takeANumber.getCurrentNum() <= 100){
            try {
                takeANumber.put();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package org.example;

public class Guess implements Runnable{
    int guess;
    HiddenNum hiddenNum;

    public Guess(int guess, HiddenNum hiddenNum){
        this.guess = guess;
        this.hiddenNum = hiddenNum;
    }
    @Override
    public void run() {
        System.out.println(hiddenNum.numberGuess(guess));
    }
}

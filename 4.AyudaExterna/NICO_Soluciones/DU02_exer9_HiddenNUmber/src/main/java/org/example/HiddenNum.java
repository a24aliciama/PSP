package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class HiddenNum {
    int num;
    AtomicBoolean guessed;

    public HiddenNum(int num){
        this.num = num;
        guessed = new AtomicBoolean(false);
    }

    public int numberGuess(int guess) {
        if (guessed.get()) {
            return -1;
        } else if (num == guess) {
            if (guessed.compareAndSet(false, true)) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }
}

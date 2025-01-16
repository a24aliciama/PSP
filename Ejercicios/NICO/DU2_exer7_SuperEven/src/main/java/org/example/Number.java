package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class Number {
    int number;
    AtomicBoolean isSuperEven;

    public Number(int number){
        this.number = number;
        this.isSuperEven = new AtomicBoolean(true);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isSuperEven() {
        return isSuperEven.get();
    }

    public void setSuperEven(boolean superEven) {
        this.isSuperEven.getAndSet(superEven);
    }

    public String toString(){
        return "El numero: " + number + (isSuperEven.get() ? " es super par" : " no es super par");
    }
}
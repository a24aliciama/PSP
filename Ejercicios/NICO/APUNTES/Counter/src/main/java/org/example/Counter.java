package org.example;

public class Counter {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increase(){
        count++;
        return count;
    }
}

package org.example;

public class RunableGreet implements Runnable {
    private String name;

    public RunableGreet(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }
}

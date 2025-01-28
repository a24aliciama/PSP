package org.example.Apuntes;

public class ejm4Run implements Runnable {

    private String names;

    public ejm4Run(String name){
        names = name;
    }

    @Override
    public void run() {
        System.out.println("hola soy " + names);
    }
}

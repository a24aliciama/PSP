package org.example;

import java.io.IOException;

public class JVM {
    public static void main(String[] args) throws IOException{
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
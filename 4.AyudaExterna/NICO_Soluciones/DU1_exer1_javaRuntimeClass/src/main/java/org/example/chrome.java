package org.example;

import java.io.IOException;

public class chrome {
    public static void main(String[] args) throws IOException{
        Runtime runtime = Runtime.getRuntime();
        String[] command = {"C:/Program Files/Google/Chrome/Application/chrome.exe"};
        Process process = runtime.exec(command);
    }
}
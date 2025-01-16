package org.example;

import java.io.IOException;
import java.util.Scanner;

public class CmdDate {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        String[] command = {"cmd", "/C", "date", "/T"};
        Process process = runtime.exec(command);
        Scanner scIN = new Scanner(process.getInputStream());
        while (scIN.hasNextLine()) {
            System.out.println(scIN.nextLine());
        }
        scIN.close();
        int exitStatus = process.waitFor();
        System.out.println("Exit status process data " + exitStatus);
        if (exitStatus != 0) {
            Scanner scERROR = new Scanner(process.getErrorStream());
            while (scERROR.hasNextLine()) {
                System.out.println(scERROR.nextLine());
            }
            scERROR.close();
        }
    }
}
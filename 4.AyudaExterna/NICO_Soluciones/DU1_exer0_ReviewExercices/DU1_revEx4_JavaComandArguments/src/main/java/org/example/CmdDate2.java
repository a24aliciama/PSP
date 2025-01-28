package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CmdDate2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        String[] command = {"cmd", "/C", "date"};
        Process process = runtime.exec(command);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        writer.write("27-10-24");
        writer.close();

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
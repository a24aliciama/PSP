package org.RunTimeExec;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class NotepadPlusPlusFile {
    public static void main(String[] args) throws IOException {

        Runtime runtime = Runtime.getRuntime();
        String[] command = {"C:/Program Files/Notepad++/notepad++.exe","./src/main/resources/info.txt"};

        //Process process = runtime.exec(command);  //non fai falta el Process.
        runtime.exec(command);

        /**
         * se abre un proceso donde command1 en el padre y command2 se habre dentro del padre
         */




    }
}
package org.example;

public class SuperEvenCharacterRunnable implements Runnable{
    char c;
    Number numero;

    public SuperEvenCharacterRunnable(Number numero,char c){
        this.c = c;
        this.numero = numero;
    }

    @Override
    public void run() {
        if (!(c == '0'||c == '2'||c == '4'||c == '6'||c == '8')){
            numero.setSuperEven(false);
        }
    }
}

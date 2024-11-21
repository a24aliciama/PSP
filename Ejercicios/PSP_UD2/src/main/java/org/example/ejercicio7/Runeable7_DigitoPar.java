package org.example.ejercicio7;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Runeable7_DigitoPar implements Runnable {

    Number7 num;
    int digito;

    public Runeable7_DigitoPar(Number7 num, int digito) {
        this.num = num;
        this.digito = digito;
    }

    @Override
    public void run() {
        if(digito %2 != 0) num.set_esSuperPar(false); //si no es par es false
        if (digito %2 == 0){
            num._esSuperPar.compareAndExchange(true,true); //si es par y ya esta en true sigue siendo true
        }
    }
}

package org.example.ejercicio9;

import java.util.concurrent.atomic.AtomicBoolean;

public class NumOculto9 {
    int aleatorio;

    AtomicBoolean adivinado;

    public NumOculto9(int aleatorio) {
        this.aleatorio = aleatorio;
        this.adivinado = new AtomicBoolean(false);
    }

    public int getAleatorio() {
        return aleatorio;
    }

    public void setAleatorio(int aleatorio) {
        this.aleatorio = aleatorio;
    }

    public synchronized int numberGuess(int num){

        if (adivinado.get()) {
            return -1;
        }

        if(num == aleatorio){
            adivinado.set(true);
            return 1;
        }

        return 0;
    };



}

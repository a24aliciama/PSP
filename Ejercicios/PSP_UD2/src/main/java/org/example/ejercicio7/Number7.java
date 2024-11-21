package org.example.ejercicio7;

import java.util.concurrent.atomic.AtomicBoolean;

public class Number7 {
    int value;
    int orden;
    AtomicBoolean _esSuperPar;

    public Number7(int value) {
        this.value = value;
        this._esSuperPar = new AtomicBoolean(true); //suponemos que es par en un principio
    }

    public int getOrden(){return orden;}

    public int getValue() {
        return value;
    }

    public boolean get_esSuperPar() {
        return _esSuperPar.get();
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public void set_esSuperPar(boolean _esSuperPar) {
        this._esSuperPar.set(_esSuperPar);
    }


    public String resultado(){
        String resultado = _esSuperPar.get()? "es SUPERPAR":"NO es superpar";
        return orden + "º numero: " + value + " " + resultado;
    }
}

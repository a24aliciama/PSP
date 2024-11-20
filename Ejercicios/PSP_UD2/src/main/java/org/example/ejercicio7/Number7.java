package org.example.ejercicio7;

import java.util.concurrent.atomic.AtomicBoolean;

public class Number7 {
    int value;
    AtomicBoolean _esSuperPar;

    public Number7(int value) {
        this.value = value;
        this._esSuperPar = new AtomicBoolean(false);
    }

    public int getValue() {
        return value;
    }

    public boolean get_esSuperPar() {
        return _esSuperPar.get();
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void set_esSuperPar(boolean _esSuperPar) {
        this._esSuperPar.set(_esSuperPar);
    }

    // Métod para verificar si todos los dígitos del número son pares

    public void comprobarDigitos()  {

    //comprobaremos si los digitos son todos pares

        String digitos = Integer.toString(value);
        for (char digito : digitos.toCharArray()) {
            if (!esPar(digito)) {
                set_esSuperPar(false); // Si algún dígito no es par, no es super even
                break;
            }
        }
    }

    public boolean esPar(char digito) {
        return  digito == '0' || digito == '2' || digito == '4' || digito == '6' || digito == '8';
    }

}

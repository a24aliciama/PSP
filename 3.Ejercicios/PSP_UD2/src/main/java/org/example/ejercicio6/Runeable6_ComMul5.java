package org.example.ejercicio6;

public class Runeable6_ComMul5 implements Runnable {

    /**
     * Si el último carácter es '5' o '0',
     * entonces el número es un múltiplo de 5, de lo contrario, no.
     */


    static String num = "88493984398443421";
    int name = 0;
    Boolean _esMul5;

    public Runeable6_ComMul5(String num, int name){
        this.num = num;
        this.name = name;
    }

    @Override
    public void run() {
        char ulti = num.charAt(num.length() - 1);

        if (ulti == 5 || ulti == 0){
            _esMul5 = true;
        }else {
            _esMul5 = false;
        }

        System.out.println("El " + name +"º numero :" + num + " es multiplo de 5? " + _esMul5);
    }
}

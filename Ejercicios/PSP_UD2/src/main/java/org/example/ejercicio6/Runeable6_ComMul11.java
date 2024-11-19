package org.example.ejercicio6;

public class Runeable6_ComMul11 implements Runnable {

    /**
     * Un número es múltiplo de 11 si
     * la diferencia entre
     * la suma de sus dígitos en posiciones impares
     * y la suma de sus dígitos en posiciones pares
     * es un múltiplo de 11 (incluido 0).
     */


    String num = "88493984398443";
    int name = 0;
    Boolean _esMul11;

    public Runeable6_ComMul11(String num, int name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public void run() {
        int numPar = 0;
        int numImp = 0;

        for (int i = 0; i < num.length(); i += 2) {
            //System.out.println(numPar + " + " + num.charAt(i));
            numPar += Character.getNumericValue(num.charAt(i)) ;
        }

        for (int i = 1; i < num.length(); i += 2){
            //System.out.println(numImp + " + " + num.charAt(i));
            numImp += Character.getNumericValue(num.charAt(i));
        }

        int dif = numImp - numPar;

        if (dif%11 == 0){
            _esMul11 = true;
        }else {
            _esMul11 = false;
        }

        System.out.println( "El " + name +"º numero :" + num + " es multiplo de 11? " + _esMul11);
    }
}

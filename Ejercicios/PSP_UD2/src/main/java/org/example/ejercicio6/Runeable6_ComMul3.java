package org.example.ejercicio6;

public class Runeable6_ComMul3 implements Runnable{

    /**
     * Si la suma de los dígitos de un número es múltiplo de 3,
     * entonces el número es múltiplo de 3,
     * por ejemplo, para 612,
     * la suma de los dígitos es 9, por lo que es un múltiplo de 3.
     */


    String num = "88493984398443421";
    int name = 0;
    Boolean _esMul3;

    public Runeable6_ComMul3(String num, int name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public void run() {
        int sumDig = 0;

        for (int i = 0; i < num.length(); i ++) {
            //System.out.println(sumDig + " + " + num.charAt(i));
            sumDig += Character.getNumericValue(num.charAt(i)) ;
        }

        if(sumDig%3 == 0){
            _esMul3 = true;
        }else{
            _esMul3 = false;
        }

        System.out.println("El " + name +"º numero :" + num + " es multiplo de 3? " + _esMul3);
    }
}

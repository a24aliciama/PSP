package org.example;

public class Multiplo3 implements Runnable{
    String numero;

    public Multiplo3(String numero){
        this.numero = numero;
    }

    @Override
    public void run() {
        int suma = 0;
        for (int i = 0; i < numero.length(); i++) {
            suma += Integer.parseInt(String.valueOf(numero.charAt(i)));
        }
        if (suma % 3 == 0) {
            System.out.println("El número " + numero + " es múltiplo de 3");
        } else {
            System.out.println("El número " + numero + " no es múltiplo de 3");
        }
    }
}

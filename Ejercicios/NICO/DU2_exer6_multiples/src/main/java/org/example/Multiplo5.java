package org.example;

public class Multiplo5 implements Runnable{
    String numero;

    public Multiplo5(String numero){
        this.numero = numero;
    }

    @Override
    public void run() {
        int ultimo = Integer.parseInt(String.valueOf(numero.charAt(numero.length() - 1)));
        if (ultimo == 0 || ultimo == 5) {
            System.out.println("El número " + numero + " es múltiplo de 5");
        } else {
            System.out.println("El número " + numero + " no es múltiplo de 5");
        }
    }
}

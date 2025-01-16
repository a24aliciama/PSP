package org.example;

public class Multiplo11 implements Runnable{
    String numero;

    public Multiplo11(String numero){
        this.numero = numero;
    }

    @Override
    public void run() {
        int sumaPar = 0;
        int sumaImpar = 0;
        for (int i = 0; i < numero.length(); i++) {
            if (i % 2 == 0) {
                sumaPar += Integer.parseInt(String.valueOf(numero.charAt(i)));
            } else {
                sumaImpar += Integer.parseInt(String.valueOf(numero.charAt(i)));
            }
        }

        if ((sumaPar - sumaImpar) % 11 == 0) {
            System.out.println("El número " + numero + " es múltiplo de 11");
        } else {
            System.out.println("El número " + numero + " no es múltiplo de 11");
        }
    }
}

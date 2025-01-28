package org.example.ejercicio11;

import java.util.Random;

public class Estanco extends Thread{
    Mesa mesa;
    Random random = new Random();
    String[] ingredientes = {"tabaco", "papel", "cerillas"};
    Boolean activo = true;

    public Estanco(Mesa mesa){
        this.mesa = mesa;
    }

    @Override
    public void run() {
        while (activo){
            //ingredientes aleatorios
            int in1 = random.nextInt(3);
            int in2;
            do {
                in2 = random.nextInt(3);
            }while (in1 == in2);

            mesa.colocarIngredientes(ingredientes[in1], ingredientes[in2]);
        }
    }

    public void pararEstanco(){
        activo = false;
    }
}

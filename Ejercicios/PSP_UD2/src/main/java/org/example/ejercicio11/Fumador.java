package org.example.ejercicio11;

public class Fumador extends Thread{
    Mesa mesa;
    String ingrediente;
    Boolean activo = true;

    public Fumador(Mesa mesa, String ingrediente){
        this.mesa = mesa;
        this.ingrediente = ingrediente;
    }

    @Override
    public void run() {
        while (activo) {
            // Intenta tomar los ingredientes necesarios de la mesa
            if (mesa.cogerIngredientes(ingrediente)) {
                try {
                    Thread.sleep(1000); // Simula el tiempo que tarda en fumar
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                System.out.println(getName() + " ha terminado de fumar.");
            }
        }
    }
    public void pararFumador(){
        activo = false;
    }
}

package org.example.ejercicio11;

public class Mesa {

        private String ingrediente1 = null; // Primer ingrediente en la mesa
        private String ingrediente2 = null; // Segundo ingrediente en la mesa
        private boolean mesaVacia = true; // Estado de la mesa (vacía o no)

        // Método sincronizado para que el tabaquero coloque ingredientes en la mesa
        public synchronized void colocarIngredientes(String ingrediente1, String ingrediente2) {
            // Esperar si la mesa no está vacía
            while (!mesaVacia) {
                try {
                    wait(); // Bloquea el hilo hasta que otro lo notifique
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            // Coloca los ingredientes en la mesa
            this.ingrediente1 = ingrediente1;
            this.ingrediente2 = ingrediente2;
            mesaVacia = false; // Cambia el estado de la mesa a "no vacía"
            System.out.println(Thread.currentThread().getName() +" colocó: " + ingrediente1 + " y " + ingrediente2);
            notifyAll(); // Notifica a todos los hilos esperando en este monitor
        }

        // Método sincronizado para que los fumadores recojan los ingredientes
        public synchronized boolean cogerIngredientes(String ingredienteFumador) {
            // Esperar si la mesa está vacía o los ingredientes no son los que necesita el fumador
            while (mesaVacia || !puedeFumar(ingredienteFumador)) {
                try {
                    wait(); // Bloquea el hilo hasta que otro lo notifique
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
            // El fumador toma los ingredientes y comienza a fumar
            System.out.println(Thread.currentThread().getName()  + " con " + ingredienteFumador + " toma " + ingrediente1 + " y " + ingrediente2 + " y comienza a fumar.");
            mesaVacia = true; // Cambia el estado de la mesa a "vacía"
            ingrediente1 = null; // Limpia los ingredientes de la mesa
            ingrediente2 = null;
            notifyAll(); // Notifica al tabaquero que puede colocar nuevos ingredientes
            return true;
        }

        // Método privado para verificar si los ingredientes en la mesa son los que necesita el fumador
        private boolean puedeFumar(String ingredienteFumador) {
            return ingrediente1 != null && ingrediente2 != null &&
                    !ingrediente1.equals(ingredienteFumador) && !ingrediente2.equals(ingredienteFumador);
        }

}

package org.example.ejercicio1;

public class Ejecutable1 {
    public static void main(String[] args) {
        // Create two instances of WelcomeRunnable
        Thread tr1 = new Thread(new Runeable1("Pedro"));
        Thread tr2 = new Thread(new Runeable1("Amalia"));

        // Start the threads
        tr1.start();
        tr2.start();

        try {
            // Wait for both threads to finish
            tr1.join();
            tr2.join();
        } catch (InterruptedException e) {
            System.out.println("Se ha interrumpido.");
        }

        // Indicate that the main thread has finished
        System.out.println("Se ha interrumpido.");
    }
}

package org.example.ejercicio3;

import java.util.Set;
import java.util.concurrent.Callable;

class Callable3 implements Callable<Boolean> {
    private final String palabra;
    private final Set<String> palindromos;
    private final int indice;

    public Callable3(String palabra, Set<String> palindromos, int indice) {
        this.palabra = palabra;
        this.palindromos = palindromos;
        this.indice = indice;
    }

    // Verifica si una palabra es un palíndromo
    private boolean esPalindromo(String palabra) {
        String invertida = new StringBuilder(palabra).reverse().toString();
        return palabra.equals(invertida);
    }

    @Override
    public Boolean call() {
        boolean esPalindromo = esPalindromo(palabra);
        // Sincronización para evitar problemas de concurrencia al modificar el HashSet
        if (esPalindromo) {
            synchronized (palindromos) {
                palindromos.add(palabra); // Añadir al HashSet solo si es palíndromo
            }
        }
        return esPalindromo;
    }
}


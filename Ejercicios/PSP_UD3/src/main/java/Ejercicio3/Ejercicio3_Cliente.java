package Ejercicio3;

import java.io.*;
import java.net.*;

public class Ejercicio3_Cliente {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 12345;

        try (
                Socket socket = new Socket(serverAddress, port);
                BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println("Conectado al servidor en " + serverAddress + ":" + port);

            System.out.print("Introduce un mensaje para cifrar: ");
            String message = consoleInput.readLine();

            out.println(message);
            String encryptedMessage = in.readLine();

            System.out.println("Mensaje cifrado recibido del servidor: " + encryptedMessage);
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}

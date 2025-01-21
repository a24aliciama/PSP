package Ejercicio3;

import java.io.*;
import java.net.*;

public class Ejercicio3_Servidor {
    private static final String[][] TABLE = {
            {"A", "B", "C", "D", "E", "F"},
            {"G", "H", "I", "J", "K", "L"},
            {"M", "N", "O", "P", "Q", "R"},
            {"S", "T", "U", "V", "W", "X"},
            {"Y", "Z", "0", "1", "2", "3"},
            {"4", "5", "6", "7", "8", "9"}
    };

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor iniciado. Esperando conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado.");

                try (
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {
                    String message = in.readLine();
                    System.out.println("Mensaje recibido: " + message);

                    String encryptedMessage = encryptMessage(message.toUpperCase());
                    System.out.println("Mensaje cifrado: " + encryptedMessage);

                    out.println(encryptedMessage);
                } catch (IOException e) {
                    System.err.println("Error al manejar la conexión con el cliente: " + e.getMessage());
                } finally {
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }

    private static String encryptMessage(String message) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : message.toCharArray()) {
            boolean found = false;

            for (int row = 0; row < TABLE.length && !found; row++) {
                for (int col = 0; col < TABLE[row].length; col++) {
                    if (String.valueOf(c).equals(TABLE[row][col])) {
                        encrypted.append((row + 1)).append((col + 1)).append(" ");
                        found = true;
                        break;
                    }
                }
            }
        }

        return encrypted.toString().trim();
    }
}


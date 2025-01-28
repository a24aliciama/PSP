package org.example.ejercicio4;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTask implements Runnable {
    private static final String OUTPUT_FOLDER = "src/main/Salidas/Salida4";
    private final File inputFile;

    public ImageTask(File inputFile) {
        this.inputFile = inputFile;
    }

    @Override
    public void run() {
        try {
            // Leer la imagen original
            BufferedImage colorImage = ImageIO.read(inputFile);
            if (colorImage == null) {
                System.err.println("No se pudo leer la imagen: " + inputFile.getName());
                return;
            }

            // Convertir la imagen a escala de grises
            BufferedImage grayImage = new BufferedImage(
                    colorImage.getWidth(), colorImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            for (int y = 0; y < colorImage.getHeight(); y++) {
                for (int x = 0; x < colorImage.getWidth(); x++) {
                    int rgb = colorImage.getRGB(x, y);
                    grayImage.setRGB(x, y, rgb);
                }
            }

            // Guardar la imagen en escala de grises en la carpeta de salida
            String outputFileName = OUTPUT_FOLDER + "/" +
                    inputFile.getName().replace(".", "_grey.");
            ImageIO.write(grayImage, "png", new File(outputFileName));

            System.out.println("Imagen procesada: " + outputFileName);

        } catch (IOException e) {
            System.err.println("Error al procesar la imagen: " + inputFile.getName());
            e.printStackTrace();
        }
    }
}


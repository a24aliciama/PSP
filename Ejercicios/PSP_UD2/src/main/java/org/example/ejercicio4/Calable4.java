package org.example.ejercicio4;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

public class Calable4 implements Callable<String> {
    private File entradaC;
    private File salidaC;

    public Calable4(File entradaC, File salidaC) {
        this.entradaC = this.entradaC;
        this.salidaC = this.salidaC;
    }

    @Override
    public String call() throws Exception {
        try {
            BufferedImage originalImage = ImageIO.read(entradaC);
            BufferedImage grayscaleImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

            // Convert the image to grayscale
            Graphics2D g2d = grayscaleImage.createGraphics();
            g2d.drawImage(originalImage, 0, 0, null);
            g2d.dispose();

            // Save the grayscale image to the output file
            ImageIO.write(grayscaleImage, "png", salidaC);

            return "Processed: " + entradaC.getName();
        } catch (IOException e) {
            return "Error processing: " + entradaC.getName();
        }
    }
}

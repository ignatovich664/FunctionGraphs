package com.codebind.Classes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileHelper {
    private static BufferedImage createImage(JPanel panel) {
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        g.dispose();
        return bi;
    }
    public static void saveImage(JPanel panel) {
        try {
            BufferedImage bi = createImage(panel);
            File outputfile = new File("Graphs.png");
            ImageIO.write(bi, "png", outputfile);
        } catch (IOException e) {
            throw new Error(e.getMessage());
        }
    }
}

package com.codebind.Classes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
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





            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
            fileChooser.setSelectedFile(new File("Graphs.png"));
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
            fileChooser.setDialogTitle("Выберите куда сохранить файл");

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File outputfile = new File(fileChooser.getSelectedFile().toString());
                ImageIO.write(bi, "png", outputfile);
            }

        } catch (IOException e) {
            throw new Error(e.getMessage());
        }
    }

}

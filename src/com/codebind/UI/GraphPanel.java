package com.codebind.UI;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    int width;
    int height;
    public GraphPanel(int size){
        this.width = size;
        this.height = size;
        setOpaque(false);

    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(0,height / 2 , width , height / 2);
        g.drawLine(width / 2,0,width / 2,height);
        drawLine(g, 1,0);
    }

    private void drawLine(Graphics g, double k, double b) {
        for (int x = 0; x < width; x++) {
            int y = (int)( height - (k * x + b));
            g.fillOval(x, y, 2, 2);
        }
    }
}

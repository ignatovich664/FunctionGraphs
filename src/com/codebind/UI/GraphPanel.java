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
        g.setColor(Color.green);
        for(int y = 0; true; ) {
            //if(y == height / 2) continue;
            g.drawLine(0,y , height , y);
            y += 25;
            if(y > height)
                break;
        }

        for(int x = 0; true; ) {
            //if(x == width / 2) continue;
            g.drawLine(x,0 , x , width);
            x += 25;
            if(x > width)
                break;
        }
        g.setColor(Color.BLACK);
        g.drawLine(0,height / 2 , width , height / 2);
        g.drawLine(width / 2,0,width / 2,height);
        drawLineFunction(g, 6,10);
        drawSquareFunction(g, 1, 2, 5);
    }

    private void drawLineFunction(Graphics g, double k, double b) {
        drawFunction(g,0,k,b);
    }
    private void drawSquareFunction(Graphics g, double a, double b, double c){
        drawFunction(g,a,b,c);
    }

    private void drawFunction(Graphics g, double a, double b, double c) {
        g.setColor(Color.BLACK);
        int prevX = 0, prevY = 0;
        for (int i = 0; i < width; i++) {
            int x =  i - width / 2;
            int y = (int)( height / 2 - (a / 25 * x * x + b * x + c * 25));
            if(y != 0 && i < width && y < height)
                g.drawLine(prevX,prevY,i,y);
            //g.fillOval(i, y, 3, 3);
            prevX = i;
            prevY = y;
        }
    }
}

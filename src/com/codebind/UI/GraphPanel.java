package com.codebind.UI;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    int width;
    int height;
    int sqareSize;
    public GraphPanel(int size){
        this.width = size;
        this.height = size;
        sqareSize = size / 20;
        setOpaque(false);

    }

    public void paint(Graphics g){
        g.setColor(Color.green);
        for(int y = 0; true; ) {
            //if(y == height / 2) continue;
            g.drawLine(0,y , height , y);
            y += sqareSize;
            if(y > height)
                break;
        }

        for(int x = 0; true; ) {
            //if(x == width / 2) continue;
            g.drawLine(x,0 , x , width);
            x += sqareSize;
            if(x > width)
                break;
        }
        g.setColor(Color.BLACK);
        g.drawLine(0,height / 2 , width , height / 2);
        g.drawLine(width / 2,0,width / 2,height);
        drawLineFunction(g, 1,1);
        drawSquareFunction(g, 1, 0, 0);
        drawCubeFunction(g, 1,0,0,0);
    }

    private void drawLineFunction(Graphics g, double k, double b) {
        drawFunction(g,0,0,k,b, Color.red);
    }
    private void drawSquareFunction(Graphics g, double a, double b, double c){
        drawFunction(g,0,a,b,c, Color.blue);
    }
    private void drawCubeFunction(Graphics g, double a, double b, double c, double d){
        drawFunction(g,a,b,c, d, Color.MAGENTA);
    }
    private void drawFunction(Graphics g, double a, double b, double c, double d, Color color) {
        g.setColor(color);
        int prevX = 0, prevY = 0;
        for (int i = 0; i < width; i++) {
            int x =  i - width / 2;
            int y = (int)( height / 2 - ((a / sqareSize / sqareSize * x * x * x) + (b / sqareSize * x * x) + (c * x)  + (d * sqareSize)));
            if(y != 0 && i < width && y < height)
                g.drawLine(prevX,prevY,i,y);
            //g.fillOval(i, y, 3, 3);
            prevX = i;
            prevY = y;
        }
    }
}

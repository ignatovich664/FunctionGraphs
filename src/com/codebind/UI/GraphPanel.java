package com.codebind.UI;

import com.codebind.Classes.CubeFunction;
import com.codebind.Classes.LineFunction;
import com.codebind.Classes.SquareFunction;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    int width;
    int height;
    int sqareSize;
    LineFunction lineFunction;
    SquareFunction squareFunction;
    CubeFunction cubeFunction;
    public GraphPanel(int size , LineFunction lineFunction, SquareFunction squareFunction, CubeFunction cubeFunction){
        this.lineFunction = lineFunction;
        this.squareFunction = squareFunction;
        this.cubeFunction = cubeFunction;
        this.width = size;
        this.height = size;
        sqareSize = size / 20;
        setOpaque(false);
    }

    public void paint(Graphics g){
        drawGrid(g);
        drawAxis(g);
        drawLineFunction(g);
        drawSquareFunction(g);
        drawCubeFunction(g);
    }

    private void drawLineFunction(Graphics g) {
        if(lineFunction != null)
            drawFunction(g,0,0,lineFunction.k,lineFunction.b, Color.red);
    }
    private void drawSquareFunction(Graphics g){
        if(squareFunction != null)
            drawFunction(g,0,squareFunction.a, squareFunction.b, squareFunction.c, Color.blue);
    }
    private void drawCubeFunction(Graphics g){
        if(cubeFunction != null)
            drawFunction(g,cubeFunction.a,cubeFunction.b,cubeFunction.c, cubeFunction.d, Color.green);
    }
    private void drawFunction(Graphics g, double a, double b, double c, double d, Color color) {
        g.setColor(color);
        int prevX = 0, prevY = 0;
        for (int i = 0; i < width; i++) {
            int x =  i - width / 2;
            int y = (int)( height / 2 - ((a / sqareSize / sqareSize * x * x * x) + (b / sqareSize * x * x) + (c * x)  + (d * sqareSize)));
            if(y != 0 && i < width && y < height)
                g.drawLine(prevX,prevY,i,y);
            prevX = i;
            prevY = y;
        }
    }
    private void drawGrid(Graphics g) {
        g.setColor(new Color(153,153,153));
        for(int y = 0;; ) {
            g.drawLine(0,y , height , y);
            y += sqareSize;
            if(y > height)
                break;
        }

        for(int x = 0;; ) {
            g.drawLine(x,0 , x , width);
            x += sqareSize;
            if(x > width)
                break;
        }
    }
    private void drawAxis(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillPolygon(new int[] {width, width - 10, width - 10}, new int[] {height / 2, height / 2 - 5, height / 2 + 5}, 3);
        g.fillPolygon(new int[] {width / 2, width / 2 - 5, width / 2 + 5}, new int[] {0, 10, 10}, 3);
        g.drawString("Y", width / 2 + 8, 15);
        g.drawString("X", width - 8, height / 2 - 5);
        g.drawLine(0,height / 2 , width , height / 2);
        g.drawLine(0,height / 2 - 1 , width , height / 2 - 1);
        g.drawLine(0,height / 2 + 1 , width , height / 2 + 1);
        g.drawLine(width / 2,0,width / 2,height);
        g.drawLine(width / 2 - 1,0,width / 2 - 1,height);
        g.drawLine(width / 2 + 1,0,width / 2 + 1,height);
    }
}

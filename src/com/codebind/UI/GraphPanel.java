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
    int xOffset;
    LineFunction lineFunction;
    SquareFunction squareFunction;
    CubeFunction cubeFunction;
    public GraphPanel(int size , LineFunction lineFunction, SquareFunction squareFunction, CubeFunction cubeFunction, int mainPanelWidth){
        this.lineFunction = lineFunction;
        this.squareFunction = squareFunction;
        this.cubeFunction = cubeFunction;
        this.width = ((size - 15) / 20) * 20;
        this.height = ((size - 15) / 20) * 20;
        sqareSize = this.height / 20;
        this.xOffset = (mainPanelWidth / 2) - this.width / 2;
    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        drawGrid(g);
        drawAxis(g);
        drawCoordinatesGrid(g);
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
                g.drawLine(prevX,prevY,i + xOffset,y);
            prevX = i + xOffset;
            prevY = y;
        }
    }
    private void drawGrid(Graphics g) {
        g.setColor(new Color(153,153,153));
        for(int y = 0;; ) {
            g.drawLine(0 + xOffset,y , height + xOffset , y);
            y += sqareSize;
            if(y > height)
                break;
        }

        for(int x = 0;; ) {
            g.drawLine(x + xOffset,0 , x +xOffset , width);
            x += sqareSize;
            if(x > width)
                break;
        }
    }
    private void drawAxis(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillPolygon(new int[] {width + xOffset, width - 10 + xOffset, width - 10 + xOffset}, new int[] {height / 2, height / 2 - 5, height / 2 + 5}, 3);
        g.fillPolygon(new int[] {width / 2 + xOffset, width / 2 - 5 + xOffset, width / 2 + 5 + xOffset}, new int[] {0, 10, 10}, 3);
        g.drawString("Y", width / 2 + 8 + xOffset, 15);
        g.drawString("X", width - 8 + xOffset, height / 2 - 5);
        g.drawLine(0 + xOffset,height / 2 , width + xOffset, height / 2);
        g.drawLine(0 + xOffset,height / 2 - 1 , width + xOffset, height / 2 - 1);
        g.drawLine(0 + xOffset,height / 2 + 1 , width + xOffset, height / 2 + 1);
        g.drawLine(width / 2 + xOffset,0,width / 2 + xOffset,height);
        g.drawLine(width / 2 - 1 + xOffset,0,width / 2 - 1 + xOffset,height);
        g.drawLine(width / 2 + 1 + xOffset,0,width / 2 + 1 + xOffset,height);
    }
    private void drawCoordinatesGrid(Graphics g) {
        g.setColor(Color.BLACK);
        int ynumberCoeff = 0;
        for (int i = 0; i < 21; i++) {
            int centerCoeff = i >= 10 ? 3 : 8;
            g.drawString(String.valueOf(i - 10), i * sqareSize + xOffset - centerCoeff, height + 15);
            if(i == 0)
                g.drawString(String.valueOf(i + 10 - ynumberCoeff), 0 + xOffset - 20, i * sqareSize + 10);
            else if(i == 20)
                g.drawString(String.valueOf(i + 10 - ynumberCoeff), 0 + xOffset - 20, i * sqareSize + 5);
            else
                g.drawString(String.valueOf(i + 10 - ynumberCoeff), 0 + xOffset - 15, i * sqareSize + 5);
            ynumberCoeff += 2;
        }

        //g.drawString("0", width - 8 + xOffset, height / 2 - 5);
    }
}

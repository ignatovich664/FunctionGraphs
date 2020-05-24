package com.codebind.UI;

import com.codebind.Classes.AxisSetting;
import com.codebind.Classes.CubeFunction;
import com.codebind.Classes.LineFunction;
import com.codebind.Classes.SquareFunction;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Класс панели на котороый выводятся графики
 * @autor Игнатович
 * @version 1.0
 */
public class GraphPanel extends JPanel {
    /** Поле ширины области графика */
    int width;
    /** Поле высоты области графика */
    int height;
    /** Поле размер в пикселях 1 квартата координатной сетки */
    int sqareSize;
    /** Поле смещение графика он левой границы окна в пикселях */
    int xOffset;
    /** Поле масштаба по оси X */
    double xStep;
    /** Поле масштаба по оси Y */
    double yStep;
    /** Поле линейной функции */
    LineFunction lineFunction;
    /** Поле квадратной функции */
    SquareFunction squareFunction;
    /** Поле кубической функции */
    CubeFunction cubeFunction;
    /** Поле настроек координатный осей */
    AxisSetting axisSetting;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param size - длина и ширина координатной сетки
     * @param lineFunction - линейная функция
     * @param squareFunction - квадратная функция
     * @param cubeFunction - кубическая функция
     * @param mainPanelWidth - ширина панели в которой находится GraphPanel
     * @param axisSetting - найстройки координатный осей
     */
    public GraphPanel(int size , LineFunction lineFunction, SquareFunction squareFunction, CubeFunction cubeFunction, int mainPanelWidth, AxisSetting axisSetting){
        this.lineFunction = lineFunction;
        this.squareFunction = squareFunction;
        this.cubeFunction = cubeFunction;
        this.width = ((size - 15) / 20) * 20;
        this.height = ((size - 15) / 20) * 20;
        sqareSize = this.height / 20;
        this.xOffset = (mainPanelWidth / 2) - this.width / 2;
        this.axisSetting = axisSetting;
        xStep = (double) (axisSetting.xMax - axisSetting.xMin) / (double) 20;
        yStep = (double) (axisSetting.yMax - axisSetting.yMin) / (double) 20;
    }
    /**
     * Функция рисующая содедржимое GraphPanel
     * @param g графический контекст с помощью которого рисуется содедржимое GraphPanel
     */
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
    /**
     * Функция рисующая линейную функцию
     * @param g графический контекст с помощью которого рисуется содедржимое GraphPanel
     */
    private void drawLineFunction(Graphics g) {
        if(lineFunction != null)
            drawFunction(g,0,0,lineFunction.k,lineFunction.b, Color.red);
    }
    /**
     * Функция рисующая квадратную функцию
     * @param g графический контекст с помощью которого рисуется содедржимое GraphPanel
     */
    private void drawSquareFunction(Graphics g){
        if(squareFunction != null)
            drawFunction(g,0,squareFunction.a, squareFunction.b, squareFunction.c, Color.blue);
    }
    /**
     * Функция рисующая кубическую функцию
     * @param g графический контекст с помощью которого рисуется содедржимое GraphPanel
     */
    private void drawCubeFunction(Graphics g){
        if(cubeFunction != null)
            drawFunction(g,cubeFunction.a,cubeFunction.b,cubeFunction.c, cubeFunction.d, Color.green);
    }
    /**
     * Функция рисующая функцию
     * @param g графический контекст с помощью которого рисуется содедржимое GraphPanel
     * @param a параметр a
     * @param b параметр b
     * @param c параметр c
     * @param d параметр d
     * @param color цвет которым будет нарисована функция
     */
    private void drawFunction(Graphics g, double a, double b, double c, double d, Color color) {
        g.setColor(color);
        int screenX2 = 0, screenY2 = 0;
        for (int screenX1 = 0 + xOffset; screenX1 < width + xOffset; screenX1+=1) {
            double x1 = (double) (screenX1 - xOffset - width / 2) / (double) sqareSize * xStep;
            double y1 = (a * x1 * x1 * x1) + (b * x1 * x1) + (c * x1) + d;
            int screenY1 = (int) ((height /2) - (y1 * sqareSize / yStep));
            if (screenX1 != 0 && screenX1 > 0 + xOffset && screenX1 < width + xOffset && screenY1 < height)
                g.drawLine(screenX2, screenY2, screenX1, screenY1);
            screenX2 = screenX1;
            screenY2 = screenY1;
        }
    }
    /**
     * Функция рисующая коордитантую сетку
     * @param g графический контекст с помощью которого рисуется содедржимое GraphPanel
     */
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
    /**
     * Функция рисующая координатные оси
     * @param g графический контекст с помощью которого рисуется содедржимое GraphPanel
     */
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
    /**
     * Функция рисующая подписи координатных осей
     * @param g графический контекст с помощью которого рисуется содедржимое GraphPanel
     */
    private void drawCoordinatesGrid(Graphics g) {
        g.setColor(Color.BLACK);
        int maxLength = String.valueOf(axisSetting.xMin).length() + 1;
        double xCounter = axisSetting.xMin, yCounter = axisSetting.yMin;
        for (int i = 0; i <= 20; i++) {
            String text = new DecimalFormat("#.##").format((double) xCounter);
            g.drawString(text, (i * sqareSize) + xOffset - 2 * text.length(), height + 15);
            xCounter+=xStep;
        }
        for (int i = 0; i <= 20; i++) {
            String text = new DecimalFormat("#.##").format((double) yCounter * (yCounter == 0 ? 1.0 : -1.0));
            g.drawString(text, 0 + xOffset - 10 * maxLength, i * sqareSize + 10);
            yCounter+=yStep;
        }
    }
}

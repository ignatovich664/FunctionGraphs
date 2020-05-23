package com.codebind.UI;

import com.codebind.Classes.CubeFunction;
import com.codebind.Classes.FileHelper;
import com.codebind.Classes.LineFunction;
import com.codebind.Classes.SquareFunction;
import com.codebind.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainPanel extends JPanel {
    JTextField lineFunctionK;
    JTextField lineFunctionB;
    JTextField squareFunctionA;
    JTextField squareFunctionB;
    JTextField squareFunctionC;
    JTextField cubeFunctionA;
    JTextField cubeFunctionB;
    JTextField cubeFunctionC;
    JTextField cubeFunctionD;
    JCheckBox lineFunctionDraw;
    JCheckBox squareFunctionDraw;
    JCheckBox cubeFunctionDraw;
    GraphPanel graphPanel;
    JPanel bottomPanel;

    public MainPanel() {
        setLayout(new BorderLayout());
        addBottomPanel();
    }
    private void addBottomPanel() {
        bottomPanel = new JPanel(new GridLayout(1,5));

        bottomPanel.add(createLineFunctionPanel());
        bottomPanel.add(createSquareFunctionPanel());
        bottomPanel.add(createCubeFunctionPanel());
        JPanel buttonsPanel = new JPanel(new GridLayout(2,1));
        JButton b = new JButton("Построить графики");
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                drawGraphs(getWidth());
            }
        });
        buttonsPanel.add(b);

        JButton b1 = new JButton("Сохранить графики");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try {
                    FileHelper.saveImage(graphPanel);
                }
                catch (Error error) {
                    showWarning("При сохранении файла произошла ошибка: " + error.getMessage());
                }
            }
        });
        buttonsPanel.add(b1);
        bottomPanel.add(buttonsPanel);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    private JPanel createLineFunctionPanel() {
        JPanel functionPanel = new JPanel(new GridLayout(3,2));

        JLabel textLabel = new JLabel("y = kx + b");
        textLabel.setForeground(Color.RED);
        functionPanel.add(textLabel);
        lineFunctionDraw = new JCheckBox("", true);
        functionPanel.add(lineFunctionDraw);

        lineFunctionK = new JTextField("1");
        functionPanel.add(new JLabel("k:"));
        functionPanel.add(lineFunctionK);

        lineFunctionB = new JTextField("0");
        functionPanel.add(new JLabel("b:"));
        functionPanel.add(lineFunctionB);

        return functionPanel;
    }
    private JPanel createSquareFunctionPanel() {
        JPanel functionPanel = new JPanel(new GridLayout(4,2));

        JLabel textLabel = new JLabel("y = ax^2 + bx + c");
        textLabel.setForeground(Color.blue);
        functionPanel.add(textLabel);
        squareFunctionDraw = new JCheckBox("", true);
        functionPanel.add(squareFunctionDraw);

        squareFunctionA = new JTextField("1");
        functionPanel.add(new JLabel("a:"));
        functionPanel.add(squareFunctionA);

        squareFunctionB = new JTextField("0");
        functionPanel.add(new JLabel("b:"));
        functionPanel.add(squareFunctionB);

        squareFunctionC = new JTextField("0");
        functionPanel.add(new JLabel("c:"));
        functionPanel.add(squareFunctionC);

        return functionPanel;
    }
    private JPanel createCubeFunctionPanel() {
        JPanel functionPanel = new JPanel(new GridLayout(5,2));

        JLabel textLabel = new JLabel("y = ax^3 + bx^2 + cx + d");
        textLabel.setForeground(Color.green);
        functionPanel.add(textLabel);
        cubeFunctionDraw = new JCheckBox("", true);
        functionPanel.add(cubeFunctionDraw);

        cubeFunctionA = new JTextField("1");
        functionPanel.add(new JLabel("a:"));
        functionPanel.add(cubeFunctionA);

        cubeFunctionB = new JTextField("0");
        functionPanel.add(new JLabel("b:"));
        functionPanel.add(cubeFunctionB);

        cubeFunctionC = new JTextField("0");
        functionPanel.add(new JLabel("c:"));
        functionPanel.add(cubeFunctionC);

        cubeFunctionD = new JTextField("0");
        functionPanel.add(new JLabel("d:"));
        functionPanel.add(cubeFunctionD);

        return functionPanel;
    }
    public void drawGraphs(int mainPanelWidth) {
        if(graphPanel != null)
            this.remove(graphPanel);
        LineFunction lineFunction  =null;
        boolean needDrawLineFinction = lineFunctionDraw.isSelected();
        if(needDrawLineFinction) {
            double k = 0,b = 0;
            try {
                k = Integer.parseInt(lineFunctionK.getText());
            } catch (Exception ex) {
                showWarning("Коэффициент k для функции y = kx + b не является числом");
            }
            try {
                b = Integer.parseInt(lineFunctionB.getText());
            } catch (Exception ex) {
                showWarning("Коэффициент b для функции y = kx + b не является числом");
            }
            lineFunction = new LineFunction(k,b);
        }
        SquareFunction squareFunction = null;
        boolean needDrawSquareFunction = squareFunctionDraw.isSelected();
        if(needDrawSquareFunction) {
            double a = 0, b = 0, c = 0;
            try {
                a = Integer.parseInt(squareFunctionA.getText());
            } catch (Exception ex) {
                showWarning("Коэффициент a для функции y = ax^2 + bx + c не является числом");
            }
            try {
                b = Integer.parseInt(squareFunctionB.getText());
            } catch (Exception ex) {
                showWarning("Коэффициент b для функции y = ax^2 + bx + c не является числом");
            }
            try {
                c = Integer.parseInt(squareFunctionC.getText());
            } catch (Exception ex) {
                showWarning("Коэффициент c для функции y = ax^2 + bx + c не является числом");
            }
            squareFunction = new SquareFunction(a,b, c);
        }
        CubeFunction cubeFunction = null;
        boolean needDrawCubeFunction = cubeFunctionDraw.isSelected();
        if(needDrawCubeFunction) {
            double a = 0, b = 0, c = 0, d = 0;
            try {
                a = Integer.parseInt(cubeFunctionA.getText());
            } catch (Exception ex) {
                showWarning("Коэффициент a для функции y = ax^3 + bx^2 + cx + d не является числом");
            }
            try {
                b = Integer.parseInt(cubeFunctionB.getText());
            } catch (Exception ex) {
                showWarning("Коэффициент b для функции y = ax^3 + bx^2 + cx + d не является числом");
            }
            try {
                c = Integer.parseInt(cubeFunctionC.getText());
            } catch (Exception ex) {
                showWarning("Коэффициент c для функции y = ax^3 + bx^2 + cx + d не является числом");
            }
            try {
                d = Integer.parseInt(cubeFunctionD.getText());
            } catch (Exception ex) {
                showWarning("Коэффициент d для функции y = ax^3 + bx^2 + cx + d не является числом");
            }
            cubeFunction = new CubeFunction(a,b, c, d);
        }
        graphPanel = new GraphPanel(getHeight() - bottomPanel.getHeight(), lineFunction, squareFunction, cubeFunction, mainPanelWidth);
        add(graphPanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
    private void showWarning(String message) {
        JOptionPane.showMessageDialog(null,message);
    }

}

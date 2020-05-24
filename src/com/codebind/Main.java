package com.codebind;

import com.codebind.UI.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Locale;

/**
 * Основной класс приложения со свойством <b>mainPanel</b>
 * @autor Игнатович
 * @version 1.0
 */
public class Main {
    /** Полу вывода главной нанели содержащей все элементы интерфейса */
    public static MainPanel mainPanel;
    /**
     * Функция создающая интерфейс приложения
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        JFrame frame = new JFrame("Построитель графиков функций");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1100, 800));
        mainPanel = new MainPanel();
        frame.add(mainPanel);
        frame.setVisible(true);
        mainPanel.drawGraphs(mainPanel.getWidth());
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                mainPanel.drawGraphs(mainPanel.getWidth());
            }
        });
    }
}

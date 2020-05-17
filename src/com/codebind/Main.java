package com.codebind;

import com.codebind.UI.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Main {
    public static MainPanel mainPanel;
    /**
     * Функция создающая интерфейс приложения
     */

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000, 800));
        mainPanel = new MainPanel();
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}

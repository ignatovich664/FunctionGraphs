package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Main {
    /**
     * Функция создающая интерфейс приложения
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000, 800));
        frame.setVisible(true);
    }
}

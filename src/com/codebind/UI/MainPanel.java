package com.codebind.UI;

import com.codebind.Classes.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Класс вывода главной панели содержащей все элементы интерфейса.
 * @autor Игнатович
 * @version 1.0
 */
public class MainPanel extends JPanel {
    /** Поле ввода параметра k линейной функции */
    JTextField lineFunctionK;
    /** Поле ввода параметра b линейной функции */
    JTextField lineFunctionB;
    /** Поле ввода параметра a квадратной функции */
    JTextField squareFunctionA;
    /** Поле ввода параметра b квадратной функции */
    JTextField squareFunctionB;
    /** Поле ввода параметра c квадратной функции */
    JTextField squareFunctionC;
    /** Поле ввода параметра a кубической функции */
    JTextField cubeFunctionA;
    /** Поле ввода параметра b кубической функции */
    JTextField cubeFunctionB;
    /** Поле ввода параметра c кубической функции */
    JTextField cubeFunctionC;
    /** Поле ввода параметра d кубической функции */
    JTextField cubeFunctionD;
    /** Поле чекбокса показывающего нужно ли рисовать линейную функцию */
    JCheckBox lineFunctionDraw;
    /** Поле чекбокса показывающего нужно ли рисовать квадратную функцию */
    JCheckBox squareFunctionDraw;
    /** Поле чекбокса показывающего нужно ли рисовать кубическую функцию */
    JCheckBox cubeFunctionDraw;
    /** Поле панели на котороый выводятся графики */
    GraphPanel graphPanel;
    /** Поле нижней панели с интерфейсом программы */
    JPanel bottomPanel;
    /** Поле ввода минимального значение коордитантой оси X */
    JTextField xMinTextField;
    /** Поле ввода максимального значение коордитантой оси X */
    JTextField xMaxTextField;
    /** Поле ввода минимального значение коордитантой оси Y */
    JTextField yMinTextField;
    /** Поле ввода максимального значение коордитантой оси Y */
    JTextField yMaxTextField;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     */
    public MainPanel() {
        setLayout(new BorderLayout());
        addBottomPanel();
    }
    /**
     * Функция добавляющая нижнюю панель с интерфейсом программы
     */
    private void addBottomPanel() {
        bottomPanel = new JPanel(new GridLayout(1,5));

        bottomPanel.add(createLineFunctionPanel());
        bottomPanel.add(createSquareFunctionPanel());
        bottomPanel.add(createCubeFunctionPanel());
        bottomPanel.add(createAxisSettingsPanel());
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
    /**
     * Функция возвращает панель с настройками линейной функции
     * @return возвращает панель с настройками линейной функции
     */
    private JPanel createLineFunctionPanel() {
        JPanel functionPanel = new JPanel(new GridLayout(5,1));

        lineFunctionDraw = new JCheckBox("y = kx + b", true);
        lineFunctionDraw.setHorizontalAlignment(SwingConstants.CENTER);
        lineFunctionDraw.setForeground(Color.RED);
        functionPanel.add(lineFunctionDraw);

        JPanel panel1 = new JPanel();
        lineFunctionK = new JTextField("1", 10);
        panel1.add(new JLabel("k:"));
        panel1.add(lineFunctionK);
        functionPanel.add(panel1);

        JPanel panel2 = new JPanel();
        lineFunctionB = new JTextField("2", 10);
        panel2.add(new JLabel("b:"));
        panel2.add(lineFunctionB);
        functionPanel.add(panel2);

        return functionPanel;
    }
    /**
     * Функция возвращает панель с настройками квадратной функции
     * @return возвращает панель с настройками квадратной функции
     */
    private JPanel createSquareFunctionPanel() {
        JPanel functionPanel = new JPanel(new GridLayout(5,1));

        squareFunctionDraw = new JCheckBox("y = ax^2 + bx + c", true);
        squareFunctionDraw.setHorizontalAlignment(SwingConstants.CENTER);
        squareFunctionDraw.setForeground(Color.BLUE);
        functionPanel.add(squareFunctionDraw);

        JPanel panel1 = new JPanel();
        squareFunctionA = new JTextField("1", 10);
        panel1.add(new JLabel("a:"));
        panel1.add(squareFunctionA);
        functionPanel.add(panel1);

        JPanel panel2 = new JPanel();
        squareFunctionB = new JTextField("2", 10);
        panel2.add(new JLabel("b:"));
        panel2.add(squareFunctionB);
        functionPanel.add(panel2);

        JPanel panel3 = new JPanel();
        squareFunctionC = new JTextField("3", 10);
        panel3.add(new JLabel("c:"));
        panel3.add(squareFunctionC);
        functionPanel.add(panel3);

        return functionPanel;
    }
    /**
     * Функция возвращает панель с настройками кубической функции
     * @return возвращает панель с настройками кубической функции
     */
    private JPanel createCubeFunctionPanel() {
        JPanel functionPanel = new JPanel(new GridLayout(5,1));

        cubeFunctionDraw = new JCheckBox("y = ax^3 + bx^2 + cx + d", true);
        cubeFunctionDraw.setHorizontalAlignment(SwingConstants.CENTER);
        cubeFunctionDraw.setForeground(Color.green);
        functionPanel.add(cubeFunctionDraw);

        JPanel panel1 = new JPanel();
        cubeFunctionA = new JTextField("1", 10);
        panel1.add(new JLabel("a:"));
        panel1.add(cubeFunctionA);
        functionPanel.add(panel1);

        JPanel panel2 = new JPanel();
        cubeFunctionB = new JTextField("2", 10);
        panel2.add(new JLabel("b:"));
        panel2.add(cubeFunctionB);
        functionPanel.add(panel2);

        JPanel panel3 = new JPanel();
        cubeFunctionC = new JTextField("3", 10);
        panel3.add(new JLabel("c:"));
        panel3.add(cubeFunctionC);
        functionPanel.add(panel3);

        JPanel panel4 = new JPanel();
        cubeFunctionD = new JTextField("4", 10);
        panel4.add(new JLabel("d:"));
        panel4.add(cubeFunctionD);
        functionPanel.add(panel4);

        return functionPanel;
    }
    /**
     * Функция возвращает панель с настройками координатный осей X и Y
     * @return возвращает панель с настройками координатный осей X и Y
     */
    private JPanel createAxisSettingsPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1));
        JLabel textLabel = new JLabel("Оси");
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(textLabel);
        JPanel panel1 = new JPanel();
        xMinTextField = new JTextField("-10", 10);
        panel1.add(new JLabel("Xmin:"));
        panel1.add(xMinTextField);
        panel.add(panel1);

        JPanel panel2 = new JPanel();
        xMaxTextField = new JTextField("10", 10);
        panel2.add(new JLabel("Xmax:"));
        panel2.add(xMaxTextField);
        panel.add(panel2);

        JPanel panel3 = new JPanel();
        yMinTextField = new JTextField("-10", 10);
        panel3.add(new JLabel("Ymin:"));
        panel3.add(yMinTextField);
        panel.add(panel3);

        JPanel panel4 = new JPanel();
        yMaxTextField = new JTextField("10", 10);
        panel4.add(new JLabel("Ymin:"));
        panel4.add(yMaxTextField);
        panel.add(panel4);

        xMaxTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                xMaxTextFieldTextChange();
            }
            public void removeUpdate(DocumentEvent e) {
                xMaxTextFieldTextChange();
            }
            public void insertUpdate(DocumentEvent e) {
                xMaxTextFieldTextChange();
            }
        });
        xMinTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                xMinTextFieldTextChange();
            }
            public void removeUpdate(DocumentEvent e) {
                xMinTextFieldTextChange();
            }
            public void insertUpdate(DocumentEvent e) {
                xMinTextFieldTextChange();
            }
        });
        yMaxTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                yMaxTextFieldTextChange();
            }
            public void removeUpdate(DocumentEvent e) {
                yMaxTextFieldTextChange();
            }
            public void insertUpdate(DocumentEvent e) {
                yMaxTextFieldTextChange();
            }
        });
        yMinTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                yMinTextFieldTextChange();
            }
            public void removeUpdate(DocumentEvent e) {
                yMinTextFieldTextChange();
            }
            public void insertUpdate(DocumentEvent e) {
                yMinTextFieldTextChange();
            }
        });
        return panel;
    }
    /**
     * Функция вызывающаяся при событии изменеия текста в поле ввода максимального значение коордитантой оси X
     * @return возвращает панель с настройками координатный осей X и Y
     */
    void xMaxTextFieldTextChange() {
        try {
            int val = Integer.parseInt(xMaxTextField.getText());
            if(val <= 0)
                showWarning("xMax должен быть больше 0");
            else
                xMinTextField.setText(String.valueOf(-1 * val));
        }
        catch (Exception e) {
        }
    }
    /**
     * Функция вызывающаяся при событии изменеия текста в поле ввода минимального значение коордитантой оси X
     * @return возвращает панель с настройками координатный осей X и Y
     */
    void xMinTextFieldTextChange() {
        try {
            int val = Integer.parseInt(xMinTextField.getText());
            if(val >= 0)
                showWarning("xMin должен быть меньше 0");
            else
                xMaxTextField.setText(String.valueOf(-1 * val));
        }
        catch (Exception e) {
        }
    }
    /**
     * Функция вызывающаяся при событии изменеия текста в поле ввода максимального значение коордитантой оси Y
     * @return возвращает панель с настройками координатный осей X и Y
     */
    void yMaxTextFieldTextChange() {
        try {
            int val = Integer.parseInt(yMaxTextField.getText());
            if(val <= 0)
                showWarning("yMax должен быть больше 0");
            else
                yMinTextField.setText(String.valueOf(-1 * val));
        }
        catch (Exception e) {
        }
    }
    /**
     * Функция вызывающаяся при событии изменеия текста в поле ввода минимального значение коордитантой оси Y
     * @return возвращает панель с настройками координатный осей X и Y
     */
    void yMinTextFieldTextChange() {
        try {
            int val = Integer.parseInt(yMinTextField.getText());
            if(val >= 0)
                showWarning("yMin должен быть меньше 0");
            else
                yMaxTextField.setText(String.valueOf(-1 * val));
        }
        catch (Exception e) {
        }
    }

    /**
     * Функция создающая панель на котороый выводятся графики
     * @param mainPanelWidth ширина окна программы
     */
    public void drawGraphs(int mainPanelWidth) {
        LineFunction lineFunction = null;
        boolean needDrawLineFinction = lineFunctionDraw.isSelected(), parseFine = true;
        if (needDrawLineFinction) {
            double k = 0, b = 0;
            try {
                k = Double.parseDouble(lineFunctionK.getText().replace(',', '.'));
            } catch (Exception ex) {
                showWarning("Коэффициент k для функции y = kx + b не является числом");
                parseFine = false;
            }
            try {
                b = Double.parseDouble(lineFunctionB.getText().replace(',', '.'));
            } catch (Exception ex) {
                showWarning("Коэффициент b для функции y = kx + b не является числом");
                parseFine = false;
            }
            lineFunction = new LineFunction(k, b);
        }
        SquareFunction squareFunction = null;
        boolean needDrawSquareFunction = squareFunctionDraw.isSelected();
        if (needDrawSquareFunction) {
            double a = 0, b = 0, c = 0;
            try {
                a = Double.parseDouble(squareFunctionA.getText().replace(',', '.'));
            } catch (Exception ex) {
                showWarning("Коэффициент a для функции y = ax^2 + bx + c не является числом");
                parseFine = false;
            }
            try {
                b = Double.parseDouble(squareFunctionB.getText().replace(',', '.'));
            } catch (Exception ex) {
                showWarning("Коэффициент b для функции y = ax^2 + bx + c не является числом");
                parseFine = false;
            }
            try {
                c = Double.parseDouble(squareFunctionC.getText().replace(',', '.'));
            } catch (Exception ex) {
                showWarning("Коэффициент c для функции y = ax^2 + bx + c не является числом");
                parseFine = false;
            }
            squareFunction = new SquareFunction(a, b, c);
        }
        CubeFunction cubeFunction = null;
        boolean needDrawCubeFunction = cubeFunctionDraw.isSelected();
        if (needDrawCubeFunction) {
            double a = 0, b = 0, c = 0, d = 0;
            try {
                a = Double.parseDouble(cubeFunctionA.getText().replace(',', '.'));
            } catch (Exception ex) {
                showWarning("Коэффициент a для функции y = ax^3 + bx^2 + cx + d не является числом");
                parseFine = false;
            }
            try {
                b = Double.parseDouble(cubeFunctionB.getText().replace(',', '.'));
            } catch (Exception ex) {
                showWarning("Коэффициент b для функции y = ax^3 + bx^2 + cx + d не является числом");
                parseFine = false;
            }
            try {
                c = Double.parseDouble(cubeFunctionC.getText().replace(',', '.'));
            } catch (Exception ex) {
                showWarning("Коэффициент c для функции y = ax^3 + bx^2 + cx + d не является числом");
                parseFine = false;
            }
            try {
                d = Double.parseDouble(cubeFunctionD.getText().replace(',', '.'));
            } catch (Exception ex) {
                showWarning("Коэффициент d для функции y = ax^3 + bx^2 + cx + d не является числом");
                parseFine = false;
            }
            cubeFunction = new CubeFunction(a, b, c, d);
        }
        int xMin = 0, xMax = 0, yMin = 0, yMax = 0, xStep = 0, yStep = 0;
        try {
            xMin = Integer.parseInt(xMinTextField.getText());
            if(xMin > 0) throw new Exception();
        } catch (Exception ex) {
            showWarning("xMin не является целым числом или больше 0");
            parseFine = false;
        }
        try {
            xMax = Integer.parseInt(xMaxTextField.getText());
            if(xMax < 0) throw new Exception();
        } catch (Exception ex) {
            showWarning("xMax не является целым числом или меньше 0");
            parseFine = false;
        }
        try {
            yMin = Integer.parseInt(yMinTextField.getText());
            if(yMin > 0) throw new Exception();
        } catch (Exception ex) {
            showWarning("yMin не является целым числом или больше 0");
            parseFine = false;
        }
        try {
            yMax = Integer.parseInt(yMaxTextField.getText());
            if(yMax < 0) throw new Exception();
        } catch (Exception ex) {
            showWarning("yMax не является целым числом или меньше 0");
            parseFine = false;
        }

        if(parseFine) {
            if (graphPanel != null)
                this.remove(graphPanel);
            AxisSetting axisSetting = new AxisSetting(xMin, xMax, yMin, yMax);
            graphPanel = new GraphPanel(getHeight() - bottomPanel.getHeight(), lineFunction, squareFunction, cubeFunction, mainPanelWidth, axisSetting);
            add(graphPanel, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
        }
    }

    /**
     * Вывод окна с оповещением пользователю
     * @param message текст оповещения
     */
    private void showWarning(String message) {
        JOptionPane.showMessageDialog(null,message);
    }

}

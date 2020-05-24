package com.codebind.UI;

import com.codebind.Classes.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

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
    JTextField xMinTextField;
    JTextField xMaxTextField;
    JTextField yMinTextField;
    JTextField yMaxTextField;
    JTextField xStepTextField;
    JTextField yStepTextField;

    public MainPanel() {
        setLayout(new BorderLayout());
        addBottomPanel();
    }
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

        lineFunctionB = new JTextField("2");
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

        squareFunctionB = new JTextField("2");
        functionPanel.add(new JLabel("b:"));
        functionPanel.add(squareFunctionB);

        squareFunctionC = new JTextField("3");
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

        cubeFunctionB = new JTextField("2");
        functionPanel.add(new JLabel("b:"));
        functionPanel.add(cubeFunctionB);

        cubeFunctionC = new JTextField("3");
        functionPanel.add(new JLabel("c:"));
        functionPanel.add(cubeFunctionC);

        cubeFunctionD = new JTextField("4");
        functionPanel.add(new JLabel("d:"));
        functionPanel.add(cubeFunctionD);

        return functionPanel;
    }
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
    private void showWarning(String message) {
        JOptionPane.showMessageDialog(null,message);
    }

}

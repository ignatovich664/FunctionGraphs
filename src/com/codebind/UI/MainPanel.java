package com.codebind.UI;

import com.codebind.Classes.CubeFunction;
import com.codebind.Classes.LineFunction;
import com.codebind.Classes.SquareFunction;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel() {
        LineFunction lineFunction = new LineFunction(1,0);
        SquareFunction squareFunction = new SquareFunction(1,0,0);
        CubeFunction cubeFunction = new CubeFunction(1,0,0,0);
        GraphPanel panel = new GraphPanel(500, lineFunction, squareFunction, cubeFunction);
        setBackground(Color.white);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
    }
}

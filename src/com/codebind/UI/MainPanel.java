package com.codebind.UI;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel() {
        GraphPanel panel = new GraphPanel();
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        setBackground(Color.white);
    }
}

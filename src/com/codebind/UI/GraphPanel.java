package com.codebind.UI;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    int x,y;
    int ax,by;

    public GraphPanel(){
        setOpaque(false);
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(0,getHeight() / 2 ,getWidth() , getHeight() / 2);
        g.drawLine(getWidth() / 2,0,getWidth() / 2,getHeight());
    }
}

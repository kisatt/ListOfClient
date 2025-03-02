package com.mycompany.TrinhThiTrang;


import java.awt.*;
import javax.swing.border.Border;

public class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.gray);
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
    
}
package com.mycompany.TrinhThiTrang;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Button extends JButton{

    public Button(String s, int size, String nameFile) throws FontFormatException, IOException{
        super();
        ImageIcon icon = new ImageIcon(nameFile);
        setIcon(icon);
        setFont(new FONT(size));
        setText(s);
        setBorder(new RoundedBorder(20));
        setPreferredSize(new Dimension(120,30));
        setActionCommand(s);
        setContentAreaFilled(false);
    }
    
     @Override
    protected void paintComponent(Graphics g) {
        GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#FF9A8B"), getWidth(), getHeight(), Color.decode("#FF6A88"));

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(gradient);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }
}
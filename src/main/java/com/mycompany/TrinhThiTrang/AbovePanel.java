package com.mycompany.TrinhThiTrang;

import java.awt.*;
import java.io.*;
import javax.swing.*;


public class AbovePanel extends JLabel{

    public AbovePanel() throws FontFormatException, IOException{
        new JLabel();
        ImageIcon icon = new ImageIcon("./src/main/java/com/mycompany/Icon/GroupIcon.png");
        setPreferredSize(new Dimension(100, 50));
        setFont(new FONT(25));
        setText("List of Clients");
        setIcon(icon);
        setHorizontalAlignment(JLabel.CENTER);
        

    }

    
}


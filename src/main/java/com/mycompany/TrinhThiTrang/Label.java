package com.mycompany.TrinhThiTrang;

import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JLabel;

public class Label extends JLabel{
    public Label(String s, int size) throws FontFormatException, IOException{
        super();
        setFont(new FONT(size));
        setText(s);
        
    }
}

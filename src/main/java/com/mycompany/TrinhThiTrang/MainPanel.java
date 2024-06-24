package com.mycompany.TrinhThiTrang;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class MainPanel extends JPanel {
    private LeftPanel lPanel;
    public RightPanel rPanel ;
    public MainPanel() throws FontFormatException, IOException, Exception {
        super();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(Color.decode("#FFDEE9"));
        
        JPanel boxpanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.3;
        c.weighty = 1;
        lPanel = new LeftPanel();
        boxpanel.add(lPanel,c);
        
        c.weightx = 0.7;
        c.gridx = 1;
        rPanel = new RightPanel();
        boxpanel.add(rPanel,c);
        
        add(new AbovePanel(), BorderLayout.NORTH);
        add(boxpanel);
    }
}
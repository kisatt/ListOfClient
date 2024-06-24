package com.mycompany.TrinhThiTrang;

import static com.mycompany.TrinhThiTrang.TrinhThiTrang_225050549.frame;
import static com.mycompany.TrinhThiTrang.RightPanel.model;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

public class Frame extends JFrame{
    
    public static ArrayList<Client> list = new ArrayList();
    
    public Frame() throws FontFormatException, IOException, Exception{
        super("225050549 Trinh Thi Trang");
        setBackground(Color.decode("#FFDEE9"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        device.setFullScreenWindow(this);
        
        MainPanel panel = new MainPanel();
        add(panel);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                try {
                    readFile();
                    readList();
                } catch (IOException ex) {
                    ImageIcon icon = new ImageIcon("./src/main/java/com/mycompany/Icon/WarningIcon.png");
                    JOptionPane.showMessageDialog(frame,"No file found", "ERROR",JOptionPane.ERROR_MESSAGE, icon);
                }
            }
            
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    printFile();
                } catch (FileNotFoundException ex) {
                    ImageIcon icon = new ImageIcon("./src/main/java/com/mycompany/Icon/WarningIcon.png");
                    JOptionPane.showMessageDialog(frame,"No file found", "ERROR",JOptionPane.ERROR_MESSAGE, icon);
                }
            }
        });

        setVisible(true); 
   
    }
    
    public static void readFile() throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader("./ListOfClient.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new Client(value[0], value[1], value[2], value[3]));
        }
        reader.close();
    }
    
    public static void readList(){
        for (Client client: list){
            Object[] row = new Object[]{client.getName(), client.getEmail(), client.getPhone(), client.getAddress()};
            model.addRow(row);
        }
    }
        
    public static void printFile() throws FileNotFoundException{
        PrintWriter writer = new PrintWriter(new File("./ListOfClient.txt"));
        int i = 0;
        for (Client client : list) {
            writer.write(client.getName() + "\t" + client.getEmail() + "\t" + client.getPhone() + "\t" + client.getAddress() + "\n");
        }
        writer.flush();
        writer.close();

    }
}

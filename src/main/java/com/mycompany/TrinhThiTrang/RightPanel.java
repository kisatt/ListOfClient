package com.mycompany.TrinhThiTrang;

import static com.mycompany.TrinhThiTrang.Frame.list;
import static com.mycompany.TrinhThiTrang.Frame.printFile;
import static com.mycompany.TrinhThiTrang.TrinhThiTrang_225050549.frame;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.logging.*;
import java.util.logging.Logger;
import javax.swing.table.*;

public class RightPanel extends JPanel implements ActionListener{
    public static String[] columnNames = {"Name", "Email", "Phone", "Address"};
    public static JTable table;
    private Object[][] data = {{}};
    
    public static DefaultTableModel model;
    private static JScrollPane scrollPane;

    public RightPanel() throws FontFormatException, IOException{
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(700,80));
        setBorder(BorderFactory.createEmptyBorder(10,20, 0, 0));
        setBackground(Color.decode("#FFDEE9"));
        
        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        
        table.setFont(new FONT(15));
        table.getTableHeader().setFont(new FONT(17));
        table.getTableHeader().setBackground(Color.decode("#FC5C7D"));
        table.setRowHeight(25);
        table.setPreferredSize(new Dimension(500,1000));
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(170);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(170);
        
        model.removeRow(0);
        
        Button deleteButton = new Button("Delete",15, "./src/main/java/com/mycompany/Icon/DeleteIcon.png");
        deleteButton.addActionListener(this);
        
        JPanel deletePanel = new JPanel(new FlowLayout());
        deletePanel.setBackground(Color.decode("#FFDEE9"));
        deletePanel.add(deleteButton);
        deletePanel.add(Box.createRigidArea(new Dimension(700,0)));
        add(deletePanel);
        
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500,1000));
        scrollPane.setFont(new FONT(15));
        add(scrollPane);
        
    }
    
    public static void addRowToTable(String name, String email, String phone, String address) {
        model.addRow(new Object[]{name, email, phone, address});
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Delete".equals(e.getActionCommand())) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0){
                model.removeRow(selectedRow);
                list.remove(selectedRow);
            } else {
                ImageIcon icon = new ImageIcon("./src/main/java/com/mycompany/Icon/WarningIcon.png");
                JOptionPane.showMessageDialog(frame, "No row is selected! Please select one row.", "Select row", JOptionPane.ERROR_MESSAGE, icon);
            }
        }
    }

}

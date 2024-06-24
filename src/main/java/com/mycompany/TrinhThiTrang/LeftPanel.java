package com.mycompany.TrinhThiTrang;

import static com.mycompany.TrinhThiTrang.Frame.list;
import static com.mycompany.TrinhThiTrang.TrinhThiTrang_225050549.frame;
import static com.mycompany.TrinhThiTrang.RightPanel.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;


public class LeftPanel extends JPanel  implements ActionListener{

    public TextField textName;
    public TextField textEmail;
    public TextField textPhone;
    public TextField textAddress;
    private RightPanel rightPanel;


    String tfName;
    String tfMail;
    public String tfPhone;
    String tfAddress;

    Button addButton;
    Button clearButton;

    
    public TextField getTextName() {
        return textName;
    }

    public void setTextName(String string) {
        this.textName.setText(string);
    }

    public TextField getTextEmail() {
        return textEmail;
    }

    public void setTextEmail(String string) {
        this.textEmail.setText(string);
    }

    public TextField getTextPhone() {
        return textPhone;
    }

    public void setTextPhone(String string) {
        this.textPhone.setText(string);
    }

    public TextField getTextAddress() {
        return textAddress;
    }

    public void setTextAddress(String string) {
        this.textAddress.setText(string);
    }

    public LeftPanel() throws FontFormatException, IOException{
        super();
        setLayout(new GridLayout(9,1));
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setPreferredSize(new Dimension(300,80));
        setBackground(Color.decode("#FFDEE9"));
        
        setBorder(BorderFactory.createTitledBorder(new RoundedBorder(20), "New Client", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new FONT(18)));
        
        Label name = new Label("Name",15);
        textName = new TextField(15);
        
        Label mail = new Label("Mail",15);
        textEmail = new TextField(15);

        Label phone = new Label("Phone",15);
        textPhone = new TextField(15);
    
        Label address = new Label("Address", 15);
        textAddress = new TextField(15);
        
        addButton = new Button("Add",15, "./src/main/java/com/mycompany/Icon/AddIcon.png");
        clearButton = new Button("Clear",15, "./src/main/java/com/mycompany/Icon/ClearIcon.png");

        addButton.addActionListener(this);
        clearButton.addActionListener(this);

        

        
        add(name);
        add(textName);
        add(mail);
        add(textEmail);
        add(phone);
        add(textPhone);
        add(address);
        add(textAddress);
        

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.decode("#FFDEE9"));
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));
        buttonPanel.add(clearButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20,0, 0, 0));
        add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Add".equals(e.getActionCommand())) {
            getInputText();
        } else{
            if ("Clear".equals(e.getActionCommand())){
                clearTf();
            }
        }   
    }

    public void getInputText() {
        tfName = getTextName().getText();
        tfMail = getTextEmail().getText();
        tfPhone = getTextPhone().getText();
        tfAddress = getTextAddress().getText();
         
        if (!tfName.isEmpty() && !tfMail.isEmpty() && !tfPhone.isEmpty() && !tfAddress.isEmpty()) {
            if (checkPhoneNumber(tfPhone)){
                list.add(new Client(tfName, tfMail, tfPhone, tfAddress));
                addRowToTable(tfName, tfMail, tfPhone, tfAddress);
                clearTf();
            } else {
             ImageIcon icon = new ImageIcon("./src/main/java/com/mycompany/Icon/WarningIcon.png");
            JOptionPane.showMessageDialog(frame,"Phone number is not valid", "Try again",JOptionPane.ERROR_MESSAGE, icon);   
            }
        } else {
            ImageIcon icon = new ImageIcon("./src/main/java/com/mycompany/Icon/WarningIcon.png");
            JOptionPane.showMessageDialog(frame,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE, icon);
        }
    }
    
    private Boolean checkPhoneNumber(String phoneNumber) throws NumberFormatException{
        if (phoneNumber.length()>=10 && phoneNumber.length() <= 12){
            for (int i = 0; i< phoneNumber.length(); i++){
                if ( phoneNumber.charAt(i) - '0' > 9){
                    return false;
                }
            }
        } else return false;
        return true;
    }


    public void clearTf(){
        setTextName("");
        setTextEmail("");
        setTextPhone("");
        setTextAddress("");
    }
}

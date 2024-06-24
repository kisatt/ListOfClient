package com.mycompany.TrinhThiTrang;

import javax.swing.JTextArea;

public  class Client{
    private String name;
    private String email;
    private String phone;
    private String address;

    

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Client(){
        setName("");
        setEmail("");
        setPhone("");
        setAddress("");
    }

    public Client(String name, String email, String phone, String address){
        setName(name);
        setEmail(email);
        setPhone(phone);
        setAddress(address);
    }

    public void printClient(JTextArea jTextArea){
        jTextArea.append(getName() + "\t" + getEmail() + "\t" + getPhone() + "\t" + getAddress());
        jTextArea.setCaretPosition(jTextArea.getDocument().getLength());

    }

}

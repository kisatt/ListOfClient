package com.mycompany.TrinhThiTrang;

public class TrinhThiTrang_225050549{
    public static Frame frame;
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               try {
                    createAndShowGUI();
                } catch (Exception e) {
                }
            }

            private void createAndShowGUI()  throws Exception{
                frame = new Frame();
            }
        });
    }
}
package com.dematicket.form;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author lmonge
 */
public class Main{

    public Main() {
   
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // set look and feel to the system look and feel
        try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
                ex.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                        new FormLogin().setVisible(true);
                }
        });
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dematicket.util;

import com.dematicket.form.FormPasswordChange;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import javax.swing.JLabel;

public class JHyperlinkLabel extends JLabel {
  private Color underlineColor = null;
  private FormPasswordChange formPasswordChange;

  public JHyperlinkLabel(String label) {
    super(label);

    setForeground(Color.BLUE.darker());
    setCursor(new Cursor(Cursor.HAND_CURSOR));
    addMouseListener(new HyperlinkLabelMouseAdapter());
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(underlineColor == null ? getForeground() : underlineColor);

    Insets insets = getInsets();

    int left = insets.left;
    if (getIcon() != null)
      left += getIcon().getIconWidth() + getIconTextGap();

    g.drawLine(left, getHeight() - 1 - insets.bottom, (int) getPreferredSize().getWidth()
        - insets.right, getHeight() - 1 - insets.bottom);
  }

  public class HyperlinkLabelMouseAdapter extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
      //Seccion para cambiar contraseña
      if(getText().equalsIgnoreCase("Cambiar Contraseña")){
          if(formPasswordChange==null){
            formPasswordChange = new FormPasswordChange();
            formPasswordChange.setLocationRelativeTo(null);
            formPasswordChange.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            formPasswordChange.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            formPasswordChange.setVisible(true);
        }else{
            formPasswordChange.setVisible(true);
        }
      }
    }
  }

  public Color getUnderlineColor() {
    return underlineColor;
  }

  public void setUnderlineColor(Color underlineColor) {
    this.underlineColor = underlineColor;
  }
}
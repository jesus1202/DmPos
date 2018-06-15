/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.FormaPagoVO;
import com.dematicket.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class FormaPagoDAO {
  FormaPagoVO formapago;
  
  public FormaPagoVO consultarFormaPago() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT FORMAPAGO,DESFORMAPAGO "
           + "FROM DMTICKET.DMT_FORMASPAGO_MAE");
   
   ResultSet res = consulta.executeQuery();
    
  if(res.next()){
    formapago= new FormaPagoVO();
    
    formapago.setFORMAPAGO(res.getString("FORMAPAGO"));
    formapago.setDESFORMAPAGO(res.getString("DESFORMAPAGO"));
    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar la forma de pago\n"+e);
  }
  return formapago;
 }   
}

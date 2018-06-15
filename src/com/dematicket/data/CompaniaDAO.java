/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.CompaniaVO;
import com.dematicket.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class CompaniaDAO {
  CompaniaVO compania;
  
  public CompaniaVO consultarCompania() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT IDCOMPANIA,COMPANIA,DIRECCIONCOMPANIA,"
           + "FILESCOPY,RUCDERRAMA,NOMBDERRAMA,DIRECDERRAMA,UBGDERRAMA,PRVDERRAMA,DEPDERRAMA,DSTDERRAMA,PAIS "
           + "FROM DMTICKET.DMT_COMPANIA_MAE WHERE IDCOMPANIA =?");
   consulta.setString(1, "08");
   
   ResultSet res = consulta.executeQuery();
    
  if(res.next()){
    compania= new CompaniaVO();
    
    compania.setIDCOMPANIA(res.getString("IDCOMPANIA"));
    compania.setCOMPANIA(res.getString("COMPANIA"));
    compania.setDIRECCIONCOMPANIA(res.getString("DIRECCIONCOMPANIA"));
    compania.setFILESCOPY(res.getString("FILESCOPY"));
    compania.setRUCDERRAMA(res.getString("RUCDERRAMA"));
    compania.setNOMBDERRAMA(res.getString("NOMBDERRAMA"));
    compania.setDIRECDERRAMA(res.getString("DIRECDERRAMA"));
    compania.setUBGDERRAMA(res.getString("UBGDERRAMA"));
    compania.setPRVDERRAMA(res.getString("PRVDERRAMA"));
    compania.setDEPDERRAMA(res.getString("DEPDERRAMA"));
    compania.setDSTDERRAMA(res.getString("DSTDERRAMA"));
    compania.setPAIS(res.getString("PAIS"));
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar la compania\n"+e);
  }
  return compania;
 }  
}

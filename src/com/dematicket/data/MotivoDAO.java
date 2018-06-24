/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.DocumentosVO;
import com.dematicket.bean.EmpresaVO;
import com.dematicket.bean.MonedaVO;
import com.dematicket.bean.MotivoVO;
import com.dematicket.bean.PerfilesVO;
import com.dematicket.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class MotivoDAO {
   static MotivoVO motivo;
   static ArrayList<MotivoVO> motivoslList = new ArrayList<MotivoVO>();
   
  public static ArrayList<MotivoVO> consultarMotivos() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT IDMOTIVO, MOTIVO "
           + " FROM DMTICKET.DMT_MOTIVOS_MAE WHERE ESTADO =?");
   consulta.setString(1, "A");
   ResultSet res = consulta.executeQuery();
  
  motivoslList.clear();
  motivo= new MotivoVO();     
  motivo.setMOTIVO("- Seleccionar -");
  //motivo.setIDMOTIVO("");
  motivoslList.add(motivo);
  
  while(res.next()){
    motivo= new MotivoVO();     
    motivo.setIDMOTIVO(res.getString("IDMOTIVO"));
    motivo.setMOTIVO(res.getString("MOTIVO")); 
    motivoslList.add(motivo);
    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener las empresas\n"+e);
  }
  return motivoslList;
 }
  
 public static MotivoVO getByIndex(int index) {  
     return motivoslList.get(index);
 }
}

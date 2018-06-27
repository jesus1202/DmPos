/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.MedioPagoVO;
import com.dematicket.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class MedioPagoDAO {
   static MedioPagoVO medio;
   static ArrayList<MedioPagoVO> mediosList = new ArrayList<MedioPagoVO>();
   
  public static ArrayList<MedioPagoVO> consultarMedios() {
  
  DbConnection conex= new DbConnection();

  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT DESCRIPCION, FPAGOID, SUBFPAGOID, FPAGOID_SUNAT "
           + " FROM DMTICKET.dmt_fpago_par WHERE IDCOMPANIA IS NOT NULL AND FPAGOID IS NOT NULL AND SUBFPAGOID IS NOT NULL AND FPAGOID_SUNAT IS NOT NULL");
   ResultSet res = consulta.executeQuery();
  
  mediosList.clear();
  medio= new MedioPagoVO();     
  medio.setDESCRIPCION("- Seleccionar -");
  //motivo.setIDMOTIVO("");
  mediosList.add(medio);
  
  while(res.next()){
    medio= new MedioPagoVO();     
    medio.setFPAGOID(res.getString("FPAGOID"));
    medio.setFPAGOID_SUNAT(res.getString("FPAGOID_SUNAT")); 
    medio.setSUBFPAGOID(res.getString("SUBFPAGOID")); 
    medio.setDESCRIPCION(res.getString("DESCRIPCION")); 
    mediosList.add(medio);
    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener los medios de pago\n"+e);
  }
  return mediosList;
 }
  
 public static MedioPagoVO getByIndex(int index) {  
     return mediosList.get(index);
 }
}

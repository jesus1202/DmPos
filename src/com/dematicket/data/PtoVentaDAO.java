/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.DocumentosVO;
import com.dematicket.bean.EmpresaVO;
import com.dematicket.bean.PtoVentaVO;
import com.dematicket.bean.TiendaVO;
import com.dematicket.bean.TiendaVO2;
import com.dematicket.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class PtoVentaDAO {
   static PtoVentaVO ptovta;
   
 public static PtoVentaVO consultarPuntoxID(String codigoEmpresa, String idTienda) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT PVTAID, PVTADES "
           + " FROM DMTICKET.dmt_puntovta_mae WHERE PVTAESTADO =? AND CIAID=? AND TDAID =?");
   consulta.setString(1, "A");
   consulta.setString(2, codigoEmpresa);
   consulta.setString(3, idTienda);
   ResultSet res = consulta.executeQuery();
  
  while(res.next()){
    ptovta= new PtoVentaVO(); 
    ptovta.setPtovtades(res.getString("PVTADES"));   
    ptovta.setPtovtaid(res.getString("PVTAID")); 
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener las tiendas de la empresa seleccionada\n"+e);
  }
  return ptovta;
 } 
 
}

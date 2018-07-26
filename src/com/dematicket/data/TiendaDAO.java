/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.DocumentosVO;
import com.dematicket.bean.EmpresaVO;
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
public class TiendaDAO {
   static TiendaVO tienda;
   static TiendaVO2 tienda2;
   static ArrayList<TiendaVO> tiendaList = new ArrayList<TiendaVO>();
   
  public static ArrayList<TiendaVO> consultarTiendaxEmpresa(String codigoEmpresa) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CIAID, TDAID, TDADES "
           + " FROM DMTICKET.DMT_TIENDAS_MAE WHERE TDAESTADO =? AND CIAID=?");
   consulta.setString(1, "A");
   consulta.setString(2, codigoEmpresa);
   ResultSet res = consulta.executeQuery();
  
  tiendaList.clear();
  tienda= new TiendaVO();     
  tienda.setTiendadsc("- Seleccionar -");
  tiendaList.add(tienda);
  
  while(res.next()){
    tienda= new TiendaVO(); 
    tienda.setEmpresaid(res.getString("CIAID"));
    tienda.setTiendadsc(res.getString("TDADES"));   
    tienda.setTiendaid(res.getString("TDAID")); 
    tiendaList.add(tienda);
    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener las tiendas de la empresa seleccionada\n"+e);
  }
  return tiendaList;
 }
  
 public static TiendaVO2 consultarTiendaxID(String codigoEmpresa, String idTienda) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT TDAID, TDADES "
           + " FROM DMTICKET.DMT_TIENDAS_MAE WHERE TDAESTADO =? AND CIAID=? AND TDAID =?");
   consulta.setString(1, "A");
   consulta.setString(2, codigoEmpresa);
   consulta.setString(3, idTienda);
   ResultSet res = consulta.executeQuery();
  
  while(res.next()){
    tienda2= new TiendaVO2(); 
    tienda2.setTiendadsc(res.getString("TDADES"));   
    tienda2.setTiendaid(res.getString("TDAID")); 
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener las tiendas de la empresa seleccionada\n"+e);
  }
  return tienda2;
 } 
  
 public static TiendaVO getByIndex(int index) {  
     return tiendaList.get(index);
 }
}

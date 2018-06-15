/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.DocumentosVO;
import com.dematicket.bean.EmpresaVO;
import com.dematicket.bean.MonedaVO;
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
public class MonedasDAO {
   static MonedaVO moneda;
   static ArrayList<MonedaVO> monedaslList = new ArrayList<MonedaVO>();
   
  public static ArrayList<MonedaVO> consultarMonedas() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT MONEDA, MONEDAABR "
           + " FROM DMTICKET.DMT_MONEDAS_MAE WHERE ESTADO =?");
   consulta.setString(1, "A");
   ResultSet res = consulta.executeQuery();
  
  monedaslList.clear();
  moneda= new MonedaVO();     
  moneda.setMoneda("- Seleccionar -");
  moneda.setMonedaAbr("");
  monedaslList.add(moneda);
  
  while(res.next()){
    moneda= new MonedaVO();     
    moneda.setMoneda(res.getString("MONEDA"));
    moneda.setMonedaAbr(res.getString("MONEDAABR")); 
    monedaslList.add(moneda);
    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener las empresas\n"+e);
  }
  return monedaslList;
 }
  public static MonedaVO consultarMonedasXCod(String codigo) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT MONEDAABR,MONEDA "
           + " FROM DMTICKET.dmt_monedas_mae WHERE MONEDAABR=?");
   consulta.setString(1, codigo);
   ResultSet res = consulta.executeQuery();
  
  while(res.next()){
    moneda= new MonedaVO();     
    moneda.setMonedaAbr(res.getString("MONEDAABR"));
    moneda.setMoneda(res.getString("MONEDA"));    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener los tipos de moneda\n"+e);
  }
  return moneda;
 } 
 public static MonedaVO getByIndex(int index) {  
     return monedaslList.get(index);
 }
}

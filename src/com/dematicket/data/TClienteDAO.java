/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.DocumentosVO;
import com.dematicket.bean.EmpresaVO;
import com.dematicket.bean.PerfilesVO;
import com.dematicket.bean.TClienteVO;
import com.dematicket.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class TClienteDAO {
   static TClienteVO tcliente;
   static ArrayList<TClienteVO> tclienteList = new ArrayList<TClienteVO>();
   
  public static ArrayList<TClienteVO> consultarTClientes() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CODIGO,DESCRIPCION "
           + " FROM DMTICKET.DMT_TIPO_CLIENTE_MAE");
   ResultSet res = consulta.executeQuery();
  
  tclienteList.clear();
  tcliente= new TClienteVO(); 
  tcliente.setCodigo("");
  tcliente.setDescripcion("- Seleccionar -");
  tclienteList.add(tcliente);
  
  while(res.next()){
    tcliente= new TClienteVO();     
    tcliente.setCodigo(res.getString("CODIGO"));
    tcliente.setDescripcion(res.getString("DESCRIPCION")); 
    tclienteList.add(tcliente);
    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener los tipos de clientes\n"+e);
  }
  return tclienteList;
 }
 public static TClienteVO consultarTClientesXCod(String codigo) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CODIGO,DESCRIPCION "
           + " FROM DMTICKET.DMT_TIPO_CLIENTE_MAE WHERE CODIGO=?");
   consulta.setString(1, codigo);
   ResultSet res = consulta.executeQuery();
  
  while(res.next()){
    tcliente= new TClienteVO();     
    tcliente.setCodigo(res.getString("CODIGO"));
    tcliente.setDescripcion(res.getString("DESCRIPCION"));    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener los tipos de clientes\n"+e);
  }
  return tcliente;
 } 
 public static TClienteVO getByIndex(int index) {  
     return tclienteList.get(index);
 }
}

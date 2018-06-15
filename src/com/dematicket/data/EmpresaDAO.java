/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.DocumentosVO;
import com.dematicket.bean.EmpresaVO;
import com.dematicket.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class EmpresaDAO {
   static EmpresaVO empresa;
   static ArrayList<EmpresaVO> empresaList = new ArrayList<EmpresaVO>();
   
  public static ArrayList<EmpresaVO> consultarEmpresas() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT EMPRESA, EMPRESAID "
           + " FROM DMTICKET.DMT_EMPRESAS_MAE WHERE ESTADO =?");
   consulta.setString(1, "A");
   ResultSet res = consulta.executeQuery();
  
  empresaList.clear();
  empresa= new EmpresaVO();     
  empresa.setEmpresa("- Seleccionar -");
  empresaList.add(empresa);
  
  while(res.next()){
    empresa= new EmpresaVO();     
    empresa.setEmpresa(res.getString("EMPRESA"));   
    empresa.setEmpresaId(res.getString("EMPRESAID")); 
    empresaList.add(empresa);
    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener las empresas\n"+e);
  }
  return empresaList;
 }
  public static EmpresaVO consultarEmpresaxCodigo(String codigo) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT EMPRESA, EMPRESAID "
           + " FROM DMTICKET.DMT_EMPRESAS_MAE WHERE ESTADO =? AND EMPRESAID=?");
   consulta.setString(1, "A");
   consulta.setString(2, codigo);
   ResultSet res = consulta.executeQuery();
  
   while(res.next()){
      empresa= new EmpresaVO();     
      empresa.setEmpresa(res.getString("EMPRESA"));   
      empresa.setEmpresaId(res.getString("EMPRESAID")); 
    }
    res.close();
    consulta.close();
    conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener la empresas indicada para el codigo"+codigo+"\n"+e);
  }
  return empresa;
 }
 public static EmpresaVO getByIndex(int index) {  
     return empresaList.get(index);
 }
}

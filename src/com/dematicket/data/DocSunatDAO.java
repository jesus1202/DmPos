/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.DocSunatVO;
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
public class DocSunatDAO {
   static DocSunatVO documento;
   static ArrayList<DocSunatVO> documentoList = new ArrayList<DocSunatVO>();
   
  public static ArrayList<DocSunatVO> consultarDocSunat() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CODIGO,DESCRIPCION "
           + " FROM DMTICKET.catalogo06_Sunat");
   ResultSet res = consulta.executeQuery();
  
  documentoList.clear();
  documento= new DocSunatVO();  
  documento.setCodigo("");
  documento.setDescripcion("- Seleccionar -");
  documentoList.add(documento);
  
  while(res.next()){
    documento= new DocSunatVO();     
    documento.setCodigo(res.getString("CODIGO"));
    documento.setDescripcion(res.getString("DESCRIPCION")); 
    documentoList.add(documento);
    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener los documento Sunat\n"+e);
  }
  return documentoList;
 }
 public static DocSunatVO consultarDocSunatXCod(String codigo) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CODIGO,DESCRIPCION "
           + " FROM DMTICKET.catalogo06_Sunat WHERE CODIGO=?");
   consulta.setString(1, codigo);
   ResultSet res = consulta.executeQuery();
   
  while(res.next()){
    documento= new DocSunatVO();     
    documento.setCodigo(res.getString("CODIGO"));
    documento.setDescripcion(res.getString("DESCRIPCION")); 
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener los documento Sunat\n"+e);
  }
  return documento;
 }   
 public static DocSunatVO getByIndex(int index) {  
     return documentoList.get(index);
 }
}

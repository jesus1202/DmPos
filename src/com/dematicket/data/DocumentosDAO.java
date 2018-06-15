/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.DocumentosVO;
import com.dematicket.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class DocumentosDAO {
   static DocumentosVO documento;
   static ArrayList<DocumentosVO> documentoList = new ArrayList<DocumentosVO>();
   
  public static ArrayList<DocumentosVO> consultarDocumentos() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT TIPODOCUMENTO,DOCUMENTO "
           + " FROM DMTICKET.DMT_DOCUMENTOS_MAE WHERE ESTADO =?");
   consulta.setString(1, "A");
   ResultSet res = consulta.executeQuery();
  
  documentoList.clear();
  while(res.next()){
    documento= new DocumentosVO();     
    documento.setTIPODOCUMENTO(res.getString("TIPODOCUMENTO"));
    documento.setDOCUMENTO(res.getString("DOCUMENTO"));  
  
    documentoList.add(documento);
    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar los tipos de documentos\n"+e);
  }
  return documentoList;
 }  
}

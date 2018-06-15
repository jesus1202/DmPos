/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.DocumentosVO;
import com.dematicket.bean.EmpresaVO;
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
public class PerfilesDAO {
   static PerfilesVO perfil;
   static ArrayList<PerfilesVO> perfilList = new ArrayList<PerfilesVO>();
   
  public static ArrayList<PerfilesVO> consultarPerfiles() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT PERFIL,PERFILID "
           + " FROM DMTICKET.DMT_PERFILES_MAE WHERE ESTADO =?");
   consulta.setString(1, "A");
   ResultSet res = consulta.executeQuery();
  
  perfilList.clear();
  perfil= new PerfilesVO();     
  perfil.setPerfil("- Seleccionar -");
  perfilList.add(perfil);
  
  while(res.next()){
    perfil= new PerfilesVO();     
    perfil.setPerfil(res.getString("PERFIL"));
    perfil.setPerfilId(res.getString("PERFILID")); 
    perfilList.add(perfil);
    
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo obtener las empresas\n"+e);
  }
  return perfilList;
 }  
 public static PerfilesVO getByIndex(int index) {  
     return perfilList.get(index);
 }
}

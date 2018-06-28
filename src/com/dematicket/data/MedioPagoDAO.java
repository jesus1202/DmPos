/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.MedioPagoVO;
import com.dematicket.util.DbConnection;
import java.math.BigDecimal;
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
   static boolean resultado=true;
   
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
 
 public static boolean insertaMedioPago(String compania,String documento, String serie, String numero, int item, String fpagoid, String subfpago, String fpagSunat,String moneda,BigDecimal montori, BigDecimal montoLoc, BigDecimal montoExt){
     DbConnection conex= new DbConnection(); 
     try{
         PreparedStatement consulta = conex.getConnection().prepareStatement("INSERT INTO dmticket.dmt_fpago_mov "+
                        "(IDCOMPANIA, "+
                        "TIPODOCUMENTO, "+
                        "SERIE, "+
                        "NUMERO, "+
                        "ITEM, "+
                        "FPAGOID, "+
                        "SUBFPAGOID, "+
                        "FPAGOID_SUNAT, "+
                        "TIPODOC_REF, "+
                        "SERIE_REF, "+
                        "NUMERO_REF, "+
                        "TIPOMONEDA, "+
                        "MTOPAGORI, "+
                        "MTOPAGLOC, "+
                        "MTOPAGEXT, "+
                        "USUREG, "+
                        "FECREG) "+
                        "VALUES "+
                        "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURDATE());");
         consulta.setString(1,compania);
         consulta.setString(2,documento);
         consulta.setString(3,serie);
         consulta.setString(4,numero);
         consulta.setInt(5,item);
         consulta.setString(6,fpagoid);
         consulta.setString(7,subfpago);
         consulta.setString(8,fpagSunat);
         consulta.setString(9,null);
         consulta.setString(10,null);
         consulta.setString(11,null);
         consulta.setString(12,moneda);
         consulta.setBigDecimal(13,montori);
         consulta.setBigDecimal(14,montoLoc);
         consulta.setBigDecimal(15,montoExt);
         consulta.setString(16,UsuarioData.getUsuario().getUsuario());
         consulta.executeUpdate();
         consulta.close();
         conex.desconectar();
         
     }catch(Exception ex){
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
      }
     return resultado;
 }
    
}

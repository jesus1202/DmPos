/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.MaestroVentasVO;
import com.dematicket.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class MaestroVentasDAO {
  MaestroVentasVO maeven;
  
  public MaestroVentasVO consultarMaeVentas() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT IDCOMPANIA,PVTA_ID,"
           + "ID_TDA,LISTAPRECIOS,TIPOMONEDA,TIPOVENTA,UNIDADMEDIDA,TURNO,CLASEAUX,IMPRESIONES,TIPOCLIENTE,"
           + "IGVPORCENTAJE,CODIMPUESTO,IDLOCALIDAD,ALMACEN,FECHAPROCESO,IMPRESORA,RUTAFE,PRINTDEST FROM DMTICKET.DMT_VENTAS_MAE");
   ResultSet res = consulta.executeQuery();
    
  if(res.next()){
    maeven= new MaestroVentasVO();
    
    maeven.setIDCOMPANIA(res.getString("IDCOMPANIA"));
    maeven.setPVTA_ID(res.getString("PVTA_ID"));
    maeven.setID_TDA(res.getString("ID_TDA"));
    maeven.setLISTAPRECIOS(res.getString("LISTAPRECIOS"));
    maeven.setTIPOMONEDA(res.getString("TIPOMONEDA"));
    maeven.setTIPOVENTA(res.getString("TIPOVENTA"));
    maeven.setUNIDADMEDIDA(res.getString("UNIDADMEDIDA"));
    maeven.setTURNO(res.getString("TURNO"));
    maeven.setCLASEAUX(res.getString("CLASEAUX"));
    maeven.setIMPRESIONES(res.getString("IMPRESIONES"));
    maeven.setTIPOCLIENTE(res.getString("TIPOCLIENTE"));
    maeven.setIGVPORCENTAJE(res.getDouble("IGVPORCENTAJE"));
    maeven.setCODIMPUESTO(res.getDouble("CODIMPUESTO"));
    maeven.setIDLOCALIDAD(res.getString("IDLOCALIDAD"));
    maeven.setALMACEN(res.getString("ALMACEN"));
    maeven.setFECHAPROCESO(res.getDate("FECHAPROCESO"));
    maeven.setIMPRESORA(res.getString("IMPRESORA"));
    maeven.setRUTAFE(res.getString("RUTAFE"));
    maeven.setPRINTDEST(res.getString("PRINTDEST"));
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar el maestro de ventas\n"+e);
  }
  return maeven;
 }    
}

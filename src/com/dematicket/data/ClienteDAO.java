/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.ClienteVO;
import com.dematicket.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class ClienteDAO {
  ClienteVO cliente;
  
  public ClienteVO consultarCliente() {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CODIGOCLIENTE,NRODOCUMENTO,CLIENOM,CLIEDIR"
           + " FROM DMTICKET.DMT_CLIENTES_MAE WHERE ESTADO_CLI=? AND CODIGOCLIENTE = ?");
   consulta.setString(1, "A");
   consulta.setString(2, "33333333");
   ResultSet res = consulta.executeQuery();
    
  if(res.next()){
    cliente= new ClienteVO();
    
    cliente.setCODIGOCLIENTE(res.getString("CODIGOCLIENTE"));
    cliente.setCLIERUC(res.getString("NRODOCUMENTO"));
    cliente.setCLIENOM(res.getString("CLIENOM"));  
    cliente.setCLIEDIR(res.getString("CLIEDIR")); 
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar cliente genérico\n"+e);
  }
  return cliente;
 }    
  
   public ClienteVO consultarClientexDoc(String documento) {
  
    DbConnection conex= new DbConnection();

    try {
     PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT "
             +" CIAID,CODIGOCLIENTE,TIPOCLIENTE,TIPODOCSUNAT,NRODOCUMENTO,TIPOPERSONA,"
             +" CLIENOM,SEXO,FECNAC,CLIEDIR,UBIGEO,EMAIL,TELEFONO1,TELEFONO2,CELULAR,ESTADO_CLI"
             + " FROM DMTICKET.DMT_CLIENTES_MAE WHERE ESTADO_CLI=? AND CODIGOCLIENTE = ?");
     consulta.setString(1, "A");
     consulta.setString(2, documento);
     ResultSet res = consulta.executeQuery();

    if(res.next()){
      cliente= new ClienteVO();
      
      cliente.setCiaid(res.getString("CIAID"));
      cliente.setCODIGOCLIENTE(res.getString("CODIGOCLIENTE"));
      cliente.setTcliente(res.getString("TIPOCLIENTE"));
      cliente.setDocsunat(res.getString("TIPODOCSUNAT"));      
      cliente.setCLIERUC(res.getString("NRODOCUMENTO"));
      cliente.setTpersona(res.getString("TIPOPERSONA"));     
      cliente.setCLIENOM(res.getString("CLIENOM"));
      cliente.setSexo(res.getString("SEXO"));
      cliente.setFecnac(res.getString("FECNAC"));
      cliente.setCLIEDIR(res.getString("CLIEDIR"));
      
      cliente.setUbigeo(res.getString("UBIGEO"));
      cliente.setMail(res.getString("EMAIL"));
      cliente.setTelefono1(res.getString("TELEFONO1"));
      cliente.setTelefono2(res.getString("TELEFONO2"));
      cliente.setCelular(res.getString("CELULAR"));
      cliente.setEstado(res.getString("ESTADO_CLI"));
    }
    res.close();
    consulta.close();
    conex.desconectar();
    } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "no se pudo consultar cliente genérico\n"+e);
    }
    return cliente;
 }    
 public void ingresarCliente(boolean flag,String codClienteIni,String codCliente,String tcliente,String docsunat,String nrodocumento,
    String tpersona,String nombre,String sexo,String fecnac,String direccion,
    String ubigeo,String mail,String telefono1,String telefono2,String celular,String estado ) {
  DbConnection conex= new DbConnection();     
  try {        
       if(flag){
         PreparedStatement consultaUpdate = conex.getConnection().prepareStatement(
        "UPDATE dmticket.dmt_clientes_mae " +
        "SET " +
        //"CIAID = <{CIAID: }>,\n" +
        "CODIGOCLIENTE = ?," +
        "TIPOCLIENTE = ?, " +
        "TIPODOCSUNAT = ?, " +
        "NRODOCUMENTO = ?, " +
        "TIPOPERSONA = ?, " +
        "CLIENOM = ?, " +
        "SEXO =?, " +
        "FECNAC =  STR_TO_DATE(?, '%d/%m/%Y'), " +
        "CLIEDIR = ?, " +
        "UBIGEO = ?, " +
        "EMAIL = ?, " +
        "TELEFONO1 = ?, " +
        "TELEFONO2 = ?, " +
        "CELULAR = ?, " +
        "ESTADO_CLI = ?, " +
        //"USUREG = <{USUREG: }>, " +
        //"FECREG = <{FECREG: }>, " +
        "USUMOD = ?, " +
        "FECMOD = CURDATE() " +
        "WHERE CODIGOCLIENTE =?"); 
         
         consultaUpdate.setString(1,codCliente);
         consultaUpdate.setString(2,tcliente);
         consultaUpdate.setString(3,docsunat);
         consultaUpdate.setString(4,nrodocumento);
         consultaUpdate.setString(5,tpersona);
         consultaUpdate.setString(6,nombre.toUpperCase());
         consultaUpdate.setString(7,sexo);
         consultaUpdate.setString(8,fecnac);
         consultaUpdate.setString(9,direccion.toUpperCase());
         consultaUpdate.setString(10,ubigeo);
         consultaUpdate.setString(11,mail.toUpperCase());
         consultaUpdate.setString(12,telefono1);
         consultaUpdate.setString(13,telefono2);
         consultaUpdate.setString(14,celular);
         consultaUpdate.setString(15,estado);
         consultaUpdate.setString(16,UsuarioData.getUsuario().getUsuario());
         consultaUpdate.setString(17,codClienteIni);
         consultaUpdate.executeUpdate();
         consultaUpdate.close();
         JOptionPane.showMessageDialog(null, "Cliente modificado correctamente\n");
       }else{          
           PreparedStatement consultaInsert = conex.getConnection().prepareStatement("INSERT INTO DMTICKET.dmt_clientes_mae "
                   + "VALUES(?,?,?,?,?,?,?,?,STR_TO_DATE(?, '%d/%m/%Y'),?,?,?,?,?,?,?,?,CURDATE(),?,?)"); 
           consultaInsert.setString(1,UsuarioData.getUsuario().getEmpresa());
           consultaInsert.setString(2,nrodocumento);
           consultaInsert.setString(3,tcliente);
           consultaInsert.setString(4,docsunat);
           consultaInsert.setString(5,nrodocumento);
           consultaInsert.setString(6,tpersona);
           consultaInsert.setString(7,nombre.toUpperCase());
           consultaInsert.setString(8,sexo);
           consultaInsert.setString(9,fecnac);
           consultaInsert.setString(10,direccion.toUpperCase());
           consultaInsert.setString(11,ubigeo);
           consultaInsert.setString(12,mail.toUpperCase());
           consultaInsert.setString(13,telefono1);
           consultaInsert.setString(14,telefono2);
           consultaInsert.setString(15,celular);
           consultaInsert.setString(16,estado);
           consultaInsert.setString(17,UsuarioData.getUsuario().getUsuario());
           consultaInsert.setString(18,null);
           consultaInsert.setString(19,null);
           
           consultaInsert.executeUpdate();
           consultaInsert.close();
           JOptionPane.showMessageDialog(null, "Cliente registrado correctamente\n");
           //JOptionPane.showMessageDialog(null, "usuario o clave incorrecta\n"); 
       }
       conex.desconectar();
       
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar al Usuario\n"+e);
  }
 }    
}

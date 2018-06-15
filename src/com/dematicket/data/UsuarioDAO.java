/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.UsuarioVO;
import com.dematicket.util.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class UsuarioDAO {
  
  UsuarioVO usu;
  
  public UsuarioVO consultarUsuario(String usuario, String password) {
  
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT USUARIO,PASSWORD,NOMBRE,MAIL,CIAID,PERFIL,IDTIENDA FROM DMTICKET.DMT_USUARIOS_MAE WHERE USUARIO = ? AND PASSWORD= ? ");
   consulta.setString(1, usuario.toUpperCase());
   consulta.setString(2, password);
   ResultSet res = consulta.executeQuery();
    
  if(res.next()){
    usu= new UsuarioVO();
    
    usu.setUsuario(res.getString("USUARIO"));
    usu.setPassword(res.getString("PASSWORD"));
    usu.setNombre(res.getString("NOMBRE"));
    usu.setEmail(res.getString("MAIL"));
    usu.setEmpresa(res.getString("CIAID"));
    usu.setPerfil(res.getString("PERFIL"));
    usu.setTienda(res.getString("IDTIENDA"));
  }
  res.close();
  consulta.close();
  conex.desconectar();
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar al Usuario\n"+e);
  }
  return usu;
 }
 public void cambiarClaveUsuario(String usuario, String password, String newPassword) {
  boolean flag = false;
  DbConnection conex= new DbConnection();     
  try {        
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT USUARIO,PASSWORD,NOMBRE,MAIL FROM DMTICKET.DMT_USUARIOS_MAE WHERE USUARIO = ? AND PASSWORD= ? AND ESTADO =?");
        consulta.setString(1, usuario.toUpperCase());
        consulta.setString(2, password);
        consulta.setString(3, "A");        
        ResultSet res = consulta.executeQuery();

       if(res.next()){
         flag = true;         
       }       
       consulta.close();
       res.close();
       
       if(flag){
         PreparedStatement consulta2 = conex.getConnection().prepareStatement("UPDATE DMTICKET.DMT_USUARIOS_MAE SET PASSWORD=? WHERE USUARIO= ?"); 
         consulta2.setString(1,newPassword);
         consulta2.setString(2,usuario.toUpperCase());
         consulta2.executeUpdate();
         consulta2.close();
         JOptionPane.showMessageDialog(null, "clave modificada correctamente\n");
       }else{          
           JOptionPane.showMessageDialog(null, "usuario o clave incorrecta\n"); 
       }
       conex.desconectar();
       
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar al Usuario\n"+e);
  }
 }   
 
 public void ingresarUsuario(String usuario, String password, String empresa, String perfil, String email, String nombres, String tienda, String estado) {
  boolean flag = false;
  DbConnection conex= new DbConnection();     
  try {        
        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT USUARIO,PASSWORD,NOMBRE,MAIL FROM DMTICKET.DMT_USUARIOS_MAE WHERE USUARIO = ? AND PASSWORD=?");
        consulta.setString(1, usuario.toUpperCase());
        //consulta.setString(2, "A"); 
        consulta.setString(2, password);
        ResultSet res = consulta.executeQuery();

       if(res.next()){
         flag = true;
         JOptionPane.showMessageDialog(null, "El Usuario ya se encuentra registrado, se procederá a actualizarlo\n");         
       }       
       consulta.close();
       res.close();
       
       if(flag){
         PreparedStatement consulta2 = conex.getConnection().prepareStatement("UPDATE DMTICKET.DMT_USUARIOS_MAE SET CIAID=?, PERFIL=?,MAIL=?, NOMBRE=?, USUMOD=?, FECMOD=CURDATE(), IDTIENDA=?, ESTADO=?  WHERE USUARIO= ? AND PASSWORD=?"); 
         
         consulta2.setString(1,empresa);
         consulta2.setString(2,perfil);
         consulta2.setString(3,email);
         consulta2.setString(4,nombres);    
         consulta2.setString(5,UsuarioData.getUsuario().getUsuario());  
         consulta2.setString(6,tienda);
         consulta2.setString(7,estado);
         consulta2.setString(8,usuario.toUpperCase());
         consulta2.setString(9,password);
         consulta2.executeUpdate();
         consulta2.close();
         JOptionPane.showMessageDialog(null, "Usuario modificado correctamente\n");
       }else{          
           PreparedStatement consulta3 = conex.getConnection().prepareStatement("INSERT INTO DMTICKET.DMT_USUARIOS_MAE (USUARIO,PASSWORD,ESTADO,NOMBRE,MAIL,USUREG,FECREG,CIAID,PERFIL,IDTIENDA) VALUES (?,?,?,?,?,?,CURDATE(),?,?,?)"); 
           consulta3.setString(1,usuario.toUpperCase());
           consulta3.setString(2,password);
           consulta3.setString(3,estado);
           consulta3.setString(4,nombres);
           consulta3.setString(5,email);
           consulta3.setString(6,UsuarioData.getUsuario().getUsuario());
           consulta3.setString(7,empresa);
           consulta3.setString(8,perfil);
           consulta3.setString(9,tienda);
           
           consulta3.executeUpdate();
           consulta3.close();
           JOptionPane.showMessageDialog(null, "Usuario registrado correctamente\n");
           //JOptionPane.showMessageDialog(null, "usuario o clave incorrecta\n"); 
       }
       conex.desconectar();
       
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar al Usuario\n"+e);
  }
 }   
}

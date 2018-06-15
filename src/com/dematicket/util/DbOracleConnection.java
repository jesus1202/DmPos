/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jcastillop
 */
public class DbOracleConnection {
    Connection connection = null;
       
      public DbOracleConnection() {
      DbConnection conex= new DbConnection();
      StringBuffer sb = new StringBuffer("");
      String usuario="";
      String contrasenia="";
      try{
         try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT BDNAME,USER, PASS FROM dmticket.DMT_ORACLEUSER_MAE WHERE TIPOBD=?");
            consulta.setString(1,"ORACLE");
            ResultSet res = consulta.executeQuery();
            if(res.next()){
                sb.append("jdbc:oracle:thin:@10.14.10.51:1521:");
                sb.append(res.getString("BDNAME"));
                usuario=res.getString("USER");
                contrasenia=res.getString("PASS");
            }
            consulta.close();
            conex.desconectar();
            if(sb.length()>0){
               connection = DriverManager.getConnection(sb.toString(),usuario,contrasenia);
            }
//            connection = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@10.10.10.151:1521:test", "db2admin", "lider");

        } catch (SQLException e) {
            System.out.println("Falló conexión");
            conex.desconectar();
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("Conexión ok");
        } else {
            System.out.println("Falló conexión");
        }
      }catch(Exception e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return connection;
   }
 
   public void desconectar(){
      connection = null;
   }
}

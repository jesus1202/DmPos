package com.dematicket.util;
import java.sql.*;
 
/**
 * Clase que permite conectar con la base de datos
 * @author chenao
 *
 */
public class DbConnection {
   /**Parametros de conexion*/
   static String bd = "dmticket";
   static String login = "root";
   static String password = "root";
   static String url = "jdbc:mysql://192.168.31.1:3306/"+bd;
 
   Connection connection = null;
 
   /** Constructor de DbConnection */
   public DbConnection() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         connection = DriverManager.getConnection(url,login,password);
 
         if (connection!=null){
            System.out.println("Conexión a base de datos "+bd+" OK\n");
         }
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.ConceptoCobro;
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
public class ConceptosDAO {
   static ArrayList<ConceptoCobro> conceptos = new ArrayList<ConceptoCobro>();
   //static ConceptoCobro concepto = new ConceptoCobro();
   static ArrayList<ConceptoCobro> conceptosFiltrados = new ArrayList<ConceptoCobro>();
    
    public static ArrayList<ConceptoCobro> getConceptos(){
        if(conceptos.isEmpty()){
            DbConnection conex= new DbConnection();
            /*try{
                BufferedReader br = new BufferedReader(new FileReader(
                                        Util.validaArchivoTicket(TipoArchivo.DAT.getTipo(), "concepto")));
                String line = br.readLine();
                while (line != null) {
                    if(line!=null && line.trim().compareTo("")!=0){
                        String[] linea = line.split("\\"+Util.FILE_DELIMITADOR);
                        conceptos.add(new ConceptoCobro(linea[0],linea[1],new BigDecimal(linea[2]),new Boolean(linea[3])));
                        conceptosFiltrados.add(new ConceptoCobro(linea[0],linea[1],new BigDecimal(linea[2]),new Boolean(linea[3])));
                    }
                    line = br.readLine();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }*/
            try{
             PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT CODCON,DESCON,APLICAIGV,PRECONIGV,PRESINIGV,TipoMon,Exonerado,UNIMED "
                            + " FROM DMTICKET.DMT_CONCEPTOS_MAE WHERE ESTCON =? AND CIAID=?");
             consulta.setString(1, "A");   
             consulta.setString(2, UsuarioData.getUsuario().getEmpresa()); 
             ResultSet res = consulta.executeQuery();
             while(res.next()){
               boolean aplicaigv = "1".equals(res.getString("APLICAIGV"));
               conceptos.add(new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(aplicaigv),new BigDecimal(res.getDouble("PRESINIGV")),res.getString("TipoMon"),res.getString("Exonerado"),res.getString("UNIMED")));
               conceptosFiltrados.add(new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(aplicaigv),new BigDecimal(res.getDouble("PRESINIGV")),res.getString("TipoMon"),res.getString("Exonerado"),res.getString("UNIMED")));  
             }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
        return conceptos;
    }
    
    public static ConceptoCobro getBeanByIndex(int index){
        //return conceptos.get(index);
        return conceptosFiltrados.get(index);
    }
    
    public static void resetListConceptos(){
        conceptosFiltrados.clear();
        for(ConceptoCobro temp: conceptos){
            conceptosFiltrados.add(temp);
        }
    }
    public static void resetListArticulos(){
        conceptos.clear();        
    }
    
    public static void updateConceptos(ArrayList<ConceptoCobro> conceptosFiltradosParam){
        conceptosFiltrados.clear();
        for(ConceptoCobro temp: conceptosFiltradosParam){
            conceptosFiltrados.add(temp);
        }
    }
    public static ConceptoCobro getConceptoxCodigo(String codigo){
        ConceptoCobro conceptoCobro=null;
        DbConnection conex= new DbConnection();            
        try{
             PreparedStatement consulta = conex.getConnection().prepareStatement(
                     "SELECT CIAID,"
                    + "CODCON, "
                    + "DESCON, "
                    + "ESTCON, "
                    + "APLICAIGV, "
                    + "TipoMon, "
                    + "Preconigv, "
                    + "PreSinigv, "
                    + "UNIMED, "
                    + "CODBARRAS,Exonerado "
                    + " FROM DMTICKET.DMT_CONCEPTOS_MAE WHERE ESTCON =? AND CIAID=? AND CODCON=?");
             consulta.setString(1, "A");   
             consulta.setString(2, UsuarioData.getUsuario().getEmpresa());
             consulta.setString(3, codigo); 
             ResultSet res = consulta.executeQuery();
             while(res.next()){
               boolean aplicaigv = "1".equals(res.getString("APLICAIGV"));
               conceptoCobro= new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(aplicaigv),new BigDecimal(res.getDouble("PRESINIGV"))
                                ,res.getString("CODCON"),res.getString("ESTCON"),res.getString("TipoMon"),res.getString("UNIMED"),res.getString("CODBARRAS"),res.getString("Exonerado"));
              //conceptosFiltrados.add(new ConceptoCobro(res.getString("CODCON"),res.getString("DESCON"),new BigDecimal(res.getDouble("PRECONIGV")),new Boolean(res.getString("APLICAIGV")),new BigDecimal(res.getDouble("PRESINIGV"))));  
             }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return conceptoCobro;
    }
    public static void actualizarConcepto(String codigo,boolean aplicaIGV, String precio, String preciosinigv, String conceptodes, String exonerado ) {
    DbConnection conex= new DbConnection();     
    try {        
        PreparedStatement consultaUpdate = conex.getConnection().prepareStatement(
        "UPDATE DMTICKET.DMT_CONCEPTOS_MAE " +
        "SET APLICAIGV =?, PRECONIGV=?, PRESINIGV=?, DESCON=?" +
        "WHERE CODCON=? AND CIAID=? AND Exonerado=?"); 
        consultaUpdate.setBoolean(1,aplicaIGV);
        consultaUpdate.setBigDecimal(2,new BigDecimal(precio));
        consultaUpdate.setBigDecimal(3,new BigDecimal(preciosinigv));
        consultaUpdate.setString(4,conceptodes);
        consultaUpdate.setString(5,codigo);
        consultaUpdate.setString(6,UsuarioData.getUsuario().getEmpresa());
        consultaUpdate.setString(7,exonerado);
        consultaUpdate.executeUpdate();
        JOptionPane.showMessageDialog(null, "Articulo modificado correctamente\n");
         
        conex.desconectar();

    } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "no se pudo actualizar el Articulo\n"+e);
    }
   }   
}


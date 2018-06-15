/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.DocumentosVO;
import com.dematicket.bean.EmpresaVO;
import com.dematicket.bean.MonedaVO;
import com.dematicket.bean.PerfilesVO;
import com.dematicket.bean.TipoCambioVO;
import com.dematicket.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jcastillop
 */
public class TipoCambioDAO {
   static TipoCambioVO tipoCambio;
   boolean resultado=true;
   //static ArrayList<MonedaVO> monedaslList = new ArrayList<MonedaVO>();
   
  public static TipoCambioVO consultarTipoCambio() {
    DbConnection conex= new DbConnection();
    try {
     PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT COMPRA, VENTA "
             + " FROM DMTICKET.DMT_TCAMBIO_MAE WHERE FECHA = CURDATE() AND CIAID=?");
     consulta.setString(1,UsuarioData.getUsuario().getEmpresa());
     ResultSet res = consulta.executeQuery();

     while(res.next()){
      tipoCambio= new TipoCambioVO();     
      tipoCambio.setTcompra(res.getString("COMPRA"));
      tipoCambio.setTventa(res.getString("VENTA"));     
    }
    res.close();
    consulta.close();
    conex.desconectar();
    } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "no se pudo obtener el tipo de compra\n"+e);
    }
    return tipoCambio;
  }

  public boolean insertarActualizarTipoCambio(String tcompra, String tventa){
       tipoCambio = consultarTipoCambio();
       DbConnection conex= new DbConnection();
       PreparedStatement consulta = null;
       try{
       if(tipoCambio!=null){//ya existe un tipo de cambio registrado, entonces se debe de actualizar
           consulta = conex.getConnection().prepareStatement("UPDATE DMTICKET.DMT_TCAMBIO_MAE"
                   + " SET COMPRA = ?, VENTA=?, USUMOD=?, FECMOD=CURDATE(), CIAID=? WHERE FECHA = CURDATE()");
            
       }else{ // se debe insertar
           consulta = conex.getConnection().prepareStatement("INSERT INTO DMTICKET.DMT_TCAMBIO_MAE ( "
                   + "COMPRA,VENTA,FECHA,USUREG,FECREG,CIAID) VALUES(?,?,CURDATE(),?,CURDATE(),?)");           
       }
        consulta.setString(1,tcompra);
        consulta.setString(2,tventa);
        consulta.setString(3,UsuarioData.getUsuario().getUsuario());
        consulta.setString(4,UsuarioData.getUsuario().getEmpresa());
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

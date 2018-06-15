/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.ClienteVO;

/**
 *
 * @author jcastillop
 */
public class ClienteData {
  static ClienteVO clienteVO;
    
    public static ClienteVO getClienteBD(){
        ClienteDAO miClienteDAO = new ClienteDAO();
        clienteVO = miClienteDAO.consultarCliente();
      return clienteVO;
    } 
    public static ClienteVO getClientexNumDoc(String documento){
        ClienteDAO miClienteDAO = new ClienteDAO();
        clienteVO = miClienteDAO.consultarClientexDoc(documento);
      return clienteVO;
    }
    public static void ingresarCliente(boolean flag,String codClienteIni,String codCliente
            ,String tcliente,String docsunat,String nrodocumento,
            String tpersona,String nombre,String sexo,String fecnac,String direccion,
            String ubigeo,String mail,String telefono1,String telefono2,String celular,String estado){
        
        ClienteDAO miClienteDAO = new ClienteDAO();
        miClienteDAO.ingresarCliente(flag, codClienteIni, codCliente, tcliente, 
                docsunat, nrodocumento, tpersona, nombre, sexo, fecnac, direccion, 
                ubigeo, mail, telefono1, telefono2, celular, estado);
      
    } 
}

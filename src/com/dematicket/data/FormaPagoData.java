/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.FormaPagoVO;

/**
 *
 * @author jcastillop
 */
public class FormaPagoData {
   static FormaPagoVO formaPagoVO;
    
    public static FormaPagoVO getFormaPagoBD(){
        FormaPagoDAO miFormaPagoDAO = new FormaPagoDAO();
        formaPagoVO = miFormaPagoDAO.consultarFormaPago();
      return formaPagoVO;
    } 
}

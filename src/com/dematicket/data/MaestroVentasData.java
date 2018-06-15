/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.MaestroVentasVO;

/**
 *
 * @author jcastillop
 */
public class MaestroVentasData {
    static MaestroVentasVO maestroVentasVO;
    
    public static MaestroVentasVO getMaeVentasBD(){
        MaestroVentasDAO miMaestroVentasDAO = new MaestroVentasDAO();
        maestroVentasVO = miMaestroVentasDAO.consultarMaeVentas();
      return maestroVentasVO;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.CompaniaVO;

/**
 *
 * @author jcastillop
 */
public class CompaniaData {
    static CompaniaVO companiaVO;
    
    public static CompaniaVO getCompaniaBD(){
        CompaniaDAO miCompaniaDAO = new CompaniaDAO();
        companiaVO = miCompaniaDAO.consultarCompania();
      return companiaVO;
    }
}

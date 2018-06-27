/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.bean;

/**
 *
 * @author jcastillop
 */
public class MedioPagoVO {
    private String FPAGOID;
    private String SUBFPAGOID;
    private String FPAGOID_SUNAT;
    private String DESCRIPCION;

    /**
     * @return the FPAGOID
     */
    public String getFPAGOID() {
        return FPAGOID;
    }

    /**
     * @param FPAGOID the FPAGOID to set
     */
    public void setFPAGOID(String FPAGOID) {
        this.FPAGOID = FPAGOID;
    }

    /**
     * @return the SUBFPAGOID
     */
    public String getSUBFPAGOID() {
        return SUBFPAGOID;
    }

    /**
     * @param SUBFPAGOID the SUBFPAGOID to set
     */
    public void setSUBFPAGOID(String SUBFPAGOID) {
        this.SUBFPAGOID = SUBFPAGOID;
    }

    /**
     * @return the FPAGOID_SUNAT
     */
    public String getFPAGOID_SUNAT() {
        return FPAGOID_SUNAT;
    }

    /**
     * @param FPAGOID_SUNAT the FPAGOID_SUNAT to set
     */
    public void setFPAGOID_SUNAT(String FPAGOID_SUNAT) {
        this.FPAGOID_SUNAT = FPAGOID_SUNAT;
    }

    /**
     * @return the DESCRIPCION
     */
    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    /**
     * @param DESCRIPCION the DESCRIPCION to set
     */
    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    
    
}

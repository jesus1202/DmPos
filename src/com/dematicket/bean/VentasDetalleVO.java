/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.bean;

import java.math.BigDecimal;

/**
 *
 * @author jcastillop
 */
public class VentasDetalleVO {
    private String IDCOMPANIA;
    private String TIPODOCUMENTO;
    private String SERIE;
    private String NUMERO;
    private BigDecimal NUMREG;
    private String CODCON;
    private String DESCON;
    private String UNIDADMEDIDA;
    private BigDecimal CANTIDAD;
    private BigDecimal DFACPREUMO;
    private BigDecimal DFACPREUMN;
    private BigDecimal DFACPREUME;
    private BigDecimal DFACMTOMO;
    private BigDecimal DFACMTOMN;
    private BigDecimal DFACMTOME;
    private String FECHVTA;
    private BigDecimal DFACIMP1;
    private BigDecimal DFACIMPMTO1;
    private BigDecimal DFACVTOTMO;//DFACVTOTMO
    private BigDecimal DFACVTOTMN;//DFACVTOTMN
    private BigDecimal DFACVTOTME;//DFACVTOTME
    private String DFACTFLAG;
    private String USUREG;
    private String FECREG;    
    
    private BigDecimal DFACDCTOMO;    
    private BigDecimal DFACDCTOMN;    
    private BigDecimal DFACDCTOME;    
    private BigDecimal DFACPREVMO;    
    private BigDecimal DFACPREVMN;    
    private BigDecimal DFACPREVME;  
    private String APLIMPTO;
    
    private String PROCESADO;

        

    public String getIDCOMPANIA() {
        return IDCOMPANIA;
    }

    public void setIDCOMPANIA(String IDCOMPANIA) {
        this.IDCOMPANIA = IDCOMPANIA;
    }

    public String getTIPODOCUMENTO() {
        return TIPODOCUMENTO;
    }

    public void setTIPODOCUMENTO(String TIPODOCUMENTO) {
        this.TIPODOCUMENTO = TIPODOCUMENTO;
    }

    public String getSERIE() {
        return SERIE;
    }

    public void setSERIE(String SERIE) {
        this.SERIE = SERIE;
    }

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public BigDecimal getNUMREG() {
        return NUMREG;
    }

    public void setNUMREG(BigDecimal NUMREG) {
        this.NUMREG = NUMREG;
    }

    public String getCODCON() {
        return CODCON;
    }

    public void setCODCON(String CODCON) {
        this.CODCON = CODCON;
    }

    public String getDESCON() {
        return DESCON;
    }

    public void setDESCON(String DESCON) {
        this.DESCON = DESCON;
    }

    public String getUNIDADMEDIDA() {
        return UNIDADMEDIDA;
    }

    public void setUNIDADMEDIDA(String UNIDADMEDIDA) {
        this.UNIDADMEDIDA = UNIDADMEDIDA;
    }

    public BigDecimal getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(BigDecimal CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public BigDecimal getDFACPREUMO() {
        return DFACPREUMO;
    }

    public void setDFACPREUMO(BigDecimal DFACPREUMO) {
        this.DFACPREUMO = DFACPREUMO;
    }

    public BigDecimal getDFACPREUMN() {
        return DFACPREUMN;
    }

    public void setDFACPREUMN(BigDecimal DFACPREUMN) {
        this.DFACPREUMN = DFACPREUMN;
    }

    public BigDecimal getDFACPREUME() {
        return DFACPREUME;
    }

    public void setDFACPREUME(BigDecimal DFACPREUME) {
        this.DFACPREUME = DFACPREUME;
    }

    public BigDecimal getDFACMTOMO() {
        return DFACMTOMO;
    }

    public void setDFACMTOMO(BigDecimal DFACMTOMO) {
        this.DFACMTOMO = DFACMTOMO;
    }

    public BigDecimal getDFACMTOMN() {
        return DFACMTOMN;
    }

    public void setDFACMTOMN(BigDecimal DFACMTOMN) {
        this.DFACMTOMN = DFACMTOMN;
    }

    public BigDecimal getDFACMTOME() {
        return DFACMTOME;
    }

    public void setDFACMTOME(BigDecimal DFACMTOME) {
        this.DFACMTOME = DFACMTOME;
    }

    public String getFECHVTA() {
        return FECHVTA;
    }

    public void setFECHVTA(String FECHVTA) {
        this.FECHVTA = FECHVTA;
    }

    public BigDecimal getDFACIMP1() {
        return DFACIMP1;
    }

    public void setDFACIMP1(BigDecimal DFACIMP1) {
        this.DFACIMP1 = DFACIMP1;
    }

    public BigDecimal getDFACIMPMTO1() {
        return DFACIMPMTO1;
    }

    public void setDFACIMPMTO1(BigDecimal DFACIMPMTO1) {
        this.DFACIMPMTO1 = DFACIMPMTO1;
    }

    public BigDecimal getDFACVTOTMO() {
        return DFACVTOTMO;
    }

    public void setDFACVTOTMO(BigDecimal DFACVTOTMO) {
        this.DFACVTOTMO = DFACVTOTMO;
    }

    public BigDecimal getDFACVTOTMN() {
        return DFACVTOTMN;
    }

    public void setDFACVTOTMN(BigDecimal DFACVTOTMN) {
        this.DFACVTOTMN = DFACVTOTMN;
    }

    public BigDecimal getDFACVTOTME() {
        return DFACVTOTME;
    }

    public void setDFACVTOTME(BigDecimal DFACVTOTME) {
        this.DFACVTOTME = DFACVTOTME;
    }

    public String getDFACTFLAG() {
        return DFACTFLAG;
    }

    public void setDFACTFLAG(String DFACTFLAG) {
        this.DFACTFLAG = DFACTFLAG;
    }

    public String getUSUREG() {
        return USUREG;
    }

    public void setUSUREG(String USUREG) {
        this.USUREG = USUREG;
    }

    public String getFECREG() {
        return FECREG;
    }

    public void setFECREG(String FECREG) {
        this.FECREG = FECREG;
    }

    
    @Override
    public String toString() {
        return "VentasDetalleVO{" + "IDCOMPANIA=" + IDCOMPANIA + ", TIPODOCUMENTO=" + TIPODOCUMENTO + ", SERIE=" + SERIE + ", NUMERO=" + NUMERO + ", NUMREG=" + NUMREG + ", CODCON=" + CODCON + ", DESCON=" + DESCON + ", UNIDADMEDIDA=" + UNIDADMEDIDA + ", CANTIDAD=" + CANTIDAD + ", DFACPREUMO=" + DFACPREUMO + ", DFACPREUMN=" + DFACPREUMN + ", DFACPREUME=" + DFACPREUME + ", DFACMTOMO=" + DFACMTOMO + ", DFACMTOMN=" + DFACMTOMN + ", DFACMTOME=" + DFACMTOME + ", FECHVTA=" + FECHVTA + ", DFACIMP1=" + DFACIMP1 + ", DFACIMPMTO1=" + DFACIMPMTO1 + ", DFACVTOTMO=" + DFACVTOTMO + ", DFACVTOTMN=" + DFACVTOTMN + ", DFACVTOTME=" + DFACVTOTME + ", DFACTFLAG=" + DFACTFLAG + ", USUREG=" + USUREG + ", FECREG=" + FECREG +'}';
    }

    /**
     * @return the DFACDCTOMO
     */
    public BigDecimal getDFACDCTOMO() {
        return DFACDCTOMO;
    }

    /**
     * @param DFACDCTOMO the DFACDCTOMO to set
     */
    public void setDFACDCTOMO(BigDecimal DFACDCTOMO) {
        this.DFACDCTOMO = DFACDCTOMO;
    }

    /**
     * @return the DFACDCTOMN
     */
    public BigDecimal getDFACDCTOMN() {
        return DFACDCTOMN;
    }

    /**
     * @param DFACDCTOMN the DFACDCTOMN to set
     */
    public void setDFACDCTOMN(BigDecimal DFACDCTOMN) {
        this.DFACDCTOMN = DFACDCTOMN;
    }

    /**
     * @return the DFACDCTOME
     */
    public BigDecimal getDFACDCTOME() {
        return DFACDCTOME;
    }

    /**
     * @param DFACDCTOME the DFACDCTOME to set
     */
    public void setDFACDCTOME(BigDecimal DFACDCTOME) {
        this.DFACDCTOME = DFACDCTOME;
    }

    /**
     * @return the DFACPREVMO
     */
    public BigDecimal getDFACPREVMO() {
        return DFACPREVMO;
    }

    /**
     * @param DFACPREVMO the DFACPREVMO to set
     */
    public void setDFACPREVMO(BigDecimal DFACPREVMO) {
        this.DFACPREVMO = DFACPREVMO;
    }

    /**
     * @return the DFACPREVMN
     */
    public BigDecimal getDFACPREVMN() {
        return DFACPREVMN;
    }

    /**
     * @param DFACPREVMN the DFACPREVMN to set
     */
    public void setDFACPREVMN(BigDecimal DFACPREVMN) {
        this.DFACPREVMN = DFACPREVMN;
    }

    /**
     * @return the DFACPREVME
     */
    public BigDecimal getDFACPREVME() {
        return DFACPREVME;
    }

    /**
     * @param DFACPREVME the DFACPREVME to set
     */
    public void setDFACPREVME(BigDecimal DFACPREVME) {
        this.DFACPREVME = DFACPREVME;
    }

    /**
     * @return the APLIMPTO
     */
    public String getAPLIMPTO() {
        return APLIMPTO;
    }

    /**
     * @param APLIMPTO the APLIMPTO to set
     */
    public void setAPLIMPTO(String APLIMPTO) {
        this.APLIMPTO = APLIMPTO;
    }

    /**
     * @return the PROCESADO
     */
    public String getPROCESADO() {
        return PROCESADO;
    }

    /**
     * @param PROCESADO the PROCESADO to set
     */
    public void setPROCESADO(String PROCESADO) {
        this.PROCESADO = PROCESADO;
    }
  
    
}

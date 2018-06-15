/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dematicket.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author lmonge
 */
public class ConceptoCobro {

    private String tipo;
    private String concepto;
    private BigDecimal precioUnitario = BigDecimal.ZERO;
    private boolean aplicaIgv;
    //private String aplicaIgv;
    private BigDecimal precioUnitarioSinIgv = BigDecimal.ZERO;
    private String ciaid;
    private String estadocon;
    private String tipomon;
    private String unimed;
    private String codbarras;
    private String exonerado;

    public ConceptoCobro(String tipo, String concepto, BigDecimal monto, BigDecimal montoSinIgv) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.precioUnitario.setScale(4, RoundingMode.HALF_UP);
        this.precioUnitario = monto;
        aplicaIgv = true;
        //aplicaIgv = "1";
        this.precioUnitarioSinIgv.setScale(4, RoundingMode.HALF_UP);
        this.precioUnitarioSinIgv.setScale(4, RoundingMode.HALF_UP);
        this.precioUnitarioSinIgv = montoSinIgv;
    }

    public ConceptoCobro(String tipo, String concepto, BigDecimal monto, boolean aplicaIgv, BigDecimal montoSinIgv, String tipomon, String exonerado, String unimed) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.precioUnitario = monto;
        this.precioUnitario = this.precioUnitario.setScale(4, RoundingMode.HALF_UP);
        this.aplicaIgv = aplicaIgv;
        this.precioUnitarioSinIgv = montoSinIgv;
        this.precioUnitarioSinIgv = this.precioUnitarioSinIgv.setScale(4, RoundingMode.HALF_UP);
        this.tipomon=tipomon;
        this.exonerado=exonerado;
        this.unimed=unimed;
    }
    public ConceptoCobro(String tipo, String concepto, BigDecimal monto, boolean aplicaIgv, BigDecimal montoSinIgv
                        ,String ciaid,String estadocon,String tipomon,String unimed,String codbarras, String exonerado) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.precioUnitario = monto;
        this.precioUnitario = this.precioUnitario.setScale(4, RoundingMode.HALF_UP);
        this.aplicaIgv = aplicaIgv;
        this.precioUnitarioSinIgv = montoSinIgv;
        this.precioUnitarioSinIgv = this.precioUnitarioSinIgv.setScale(4, RoundingMode.HALF_UP);
        this.ciaid=ciaid;
        this.estadocon=estadocon;
        this.tipomon=tipomon;
        this.unimed=unimed;
        this.codbarras=codbarras;
        this.exonerado=exonerado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public boolean isAplicaIgv() {
        return aplicaIgv;
    }

    public void setAplicaIgv(boolean aplicaIgv) {
        this.aplicaIgv = aplicaIgv;
    }

    /**
     * @return the precioUnitarioSinIgv
     */
    public BigDecimal getPrecioUnitarioSinIgv() {
        return precioUnitarioSinIgv;
    }

    /**
     * @param precioUnitarioSinIgv the precioUnitarioSinIgv to set
     */
    public void setPrecioUnitarioSinIgv(BigDecimal precioUnitarioSinIgv) {
        this.precioUnitarioSinIgv = precioUnitarioSinIgv;
    }

    /**
     * @return the ciaid
     */
    public String getCiaid() {
        return ciaid;
    }

    /**
     * @param ciaid the ciaid to set
     */
    public void setCiaid(String ciaid) {
        this.ciaid = ciaid;
    }

    /**
     * @return the estadocon
     */
    public String getEstadocon() {
        return estadocon;
    }

    /**
     * @param estadocon the estadocon to set
     */
    public void setEstadocon(String estadocon) {
        this.estadocon = estadocon;
    }

    /**
     * @return the tipomon
     */
    public String getTipomon() {
        return tipomon;
    }

    /**
     * @param tipomon the tipomon to set
     */
    public void setTipomon(String tipomon) {
        this.tipomon = tipomon;
    }

    /**
     * @return the unimed
     */
    public String getUnimed() {
        return unimed;
    }

    /**
     * @param unimed the unimed to set
     */
    public void setUnimed(String unimed) {
        this.unimed = unimed;
    }

    /**
     * @return the codbarras
     */
    public String getCodbarras() {
        return codbarras;
    }

    /**
     * @param codbarras the codbarras to set
     */
    public void setCodbarras(String codbarras) {
        this.codbarras = codbarras;
    }

    /**
     * @return the exonerado
     */
    public String getExonerado() {
        return exonerado;
    }

    /**
     * @param exonerado the exonerado to set
     */
    public void setExonerado(String exonerado) {
        this.exonerado = exonerado;
    }

    @Override
    public String toString() {
        return "ConceptoCobro{" + "tipo=" + tipo + ", concepto=" + concepto + ", precioUnitario=" + precioUnitario + ", aplicaIgv=" + aplicaIgv + ", precioUnitarioSinIgv=" + precioUnitarioSinIgv + ", ciaid=" + ciaid + ", estadocon=" + estadocon + ", tipomon=" + tipomon + ", unimed=" + unimed + ", codbarras=" + codbarras + ", exonerado=" + exonerado + '}';
    }
    
    

}

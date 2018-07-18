/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.bean;

import com.dematicket.data.SesionData;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author lmonge
 */
public class DetalleTicket {
    private ConceptoCobro conceptoCobro;
    private int cantidad;
    private BigDecimal subtotal = BigDecimal.ZERO;
    private BigDecimal montoIgv = BigDecimal.ZERO;
    private String flag;
    private BigDecimal montoGravado = BigDecimal.ZERO;
    private BigDecimal montoExonerado = BigDecimal.ZERO;
    private BigDecimal montoInafecto = BigDecimal.ZERO;
    private String aplimpto;
    private BigDecimal descItem= BigDecimal.ZERO;
    //private String tmoneda;

    public DetalleTicket(ConceptoCobro conceptoCobro, int cantidad, String tmoneda,BigDecimal tcambio, BigDecimal desc) {
        this.subtotal.setScale(4, RoundingMode.HALF_DOWN);
        this.montoIgv.setScale(4, RoundingMode.HALF_UP);
        this.conceptoCobro = conceptoCobro;
        this.cantidad = cantidad;        
        this.subtotal = conceptoCobro.getPrecioUnitario().multiply(new BigDecimal(cantidad));
        this.descItem = desc.multiply(new BigDecimal(cantidad));
        if(this.descItem.compareTo(BigDecimal.ZERO)>0){
            this.subtotal = this.subtotal.subtract(this.descItem);
        }
        if(!conceptoCobro.getTipomon().equals(tmoneda)){
            if(tmoneda.equals("S")){
                //conceptoCobro.setPrecioUnitario(conceptoCobro.getPrecioUnitario().multiply(tcambio));
                this.subtotal = subtotal.multiply(tcambio);                
            }else if(tmoneda.equals("D")){
                //conceptoCobro.setPrecioUnitario(conceptoCobro.getPrecioUnitario().divide(tcambio,2, RoundingMode.HALF_UP));
                this.subtotal = subtotal.divide(tcambio,4, RoundingMode.HALF_UP);                
            }
        }
        
        BigDecimal factor = BigDecimal.ZERO;
        if(conceptoCobro.isAplicaIgv()){
            factor = SesionData.getSesion().getIgvPorcentaje().divide(new BigDecimal(100));
            factor = factor.add(BigDecimal.ONE);
            montoIgv = this.subtotal.divide(factor, 4, RoundingMode.HALF_DOWN);
            montoIgv = this.subtotal.subtract(montoIgv);
        }
        
        if(conceptoCobro.isAplicaIgv() && conceptoCobro.getExonerado().equals("N")){
            montoGravado= montoGravado.add(this.subtotal);
            aplimpto="G";
        }
        if(!conceptoCobro.isAplicaIgv() && conceptoCobro.getExonerado().equals("S")){
            montoExonerado= montoExonerado.add(this.subtotal);
            aplimpto="E";
        }
        if(!conceptoCobro.isAplicaIgv() && conceptoCobro.getExonerado().equals("N")){
            montoInafecto= montoInafecto.add(this.subtotal);
            aplimpto="I";
        }        
    }

    public ConceptoCobro getConceptoCobro() {
        return conceptoCobro;
    }

    public void setConceptoCobro(ConceptoCobro conceptoCobro) {
        this.conceptoCobro = conceptoCobro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getMontoIgv() {
        return montoIgv;
    }

    public void setMontoIgv(BigDecimal montoIgv) {
        this.montoIgv = montoIgv;
    }
        
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "DetalleTicket{" + " conceptoCobro=" + conceptoCobro + ", cantidad=" + cantidad + ", subtotal=" + subtotal + '}';
    }

    /**
     * @return the montoGravado
     */
    public BigDecimal getMontoGravado() {
        return montoGravado;
    }

    /**
     * @param montoGravado the montoGravado to set
     */
    public void setMontoGravado(BigDecimal montoGravado) {
        this.montoGravado = montoGravado;
    }

    /**
     * @return the montoExonerado
     */
    public BigDecimal getMontoExonerado() {
        return montoExonerado;
    }

    /**
     * @param montoExonerado the montoExonerado to set
     */
    public void setMontoExonerado(BigDecimal montoExonerado) {
        this.montoExonerado = montoExonerado;
    }

    /**
     * @return the montoInafecto
     */
    public BigDecimal getMontoInafecto() {
        return montoInafecto;
    }

    /**
     * @param montoInafecto the montoInafecto to set
     */
    public void setMontoInafecto(BigDecimal montoInafecto) {
        this.montoInafecto = montoInafecto;
    }

    /**
     * @return the aplimpto
     */
    public String getAplimpto() {
        return aplimpto;
    }

    /**
     * @param aplimpto the aplimpto to set
     */
    public void setAplimpto(String aplimpto) {
        this.aplimpto = aplimpto;
    }

    /**
     * @return the descItem
     */
    public BigDecimal getDescItem() {
        return descItem;
    }

    /**
     * @param descItem the descItem to set
     */
    public void setDescItem(BigDecimal descItem) {
        this.descItem = descItem;
    }
    
}

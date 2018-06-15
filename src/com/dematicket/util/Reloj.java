/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author lmonge
 */
public class Reloj extends Thread{

    private String dia, mes, año, hora, minutos, segundos; 
    private Calendar calendario = new GregorianCalendar();
    JLabel lblFecha;
    
    public Reloj(JLabel lblFecha) {
        this.lblFecha=lblFecha;
    }
    
    @Override
    public void run() {
        try{
            while(true){
                actualiza();
                String fecha = this.lblFecha.getText();
                String fechaNueva = dia+"/"+mes+"/"+año+" "+hora+":"+minutos+":"+segundos;
                if(fecha.compareTo(fechaNueva)!=0){
                    this.lblFecha.setText(dia+"/"+mes+"/"+año+" "+hora+":"+minutos+":"+segundos);
                }
                Thread.sleep(400);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void actualiza() { 
        Date fechaHoraActual = new Date(); 
        calendario.setTime(fechaHoraActual); 
        hora = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY)); 
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE); 
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND); 
        dia = calendario.get(Calendar.DATE) > 9 ? "" + calendario.get(Calendar.DATE) : "0" + calendario.get(Calendar.DATE); 
        mes = (calendario.get(Calendar.MONTH)+1) > 9 ? "" + calendario.get(Calendar.MONTH) : "0" + (calendario.get(Calendar.MONTH)+1); 
        año = calendario.get(Calendar.YEAR) > 9 ? "" + calendario.get(Calendar.YEAR) : "0" + calendario.get(Calendar.YEAR); 
    } 
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.util;

import com.dematicket.bean.Ticket;
import com.dematicket.data.SesionData;
import com.dematicket.data.UsuarioData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author lmonge
 */
public class Util {

    public static String FILE_DELIMITADOR = "|";
    public static String FILE_DELIMITADOR_FELOCAL = ";";
    public static String FILE_DELIMITADOR_NOMBFELOCAL = "_";
    
    public static String FILE_CAB1_CRISOL = "EN";
    public static String FILE_CAB2_CRISOL = "DOC";
    public static String FILE_CAB3_CRISOL = "DN";
    public static String FILE_CAB4_CRISOL = "DE";
    public static String FILE_CAB5_CRISOL = "DEDI";
    public static String FILE_CAB6_CRISOL = "DEDR";
    public static String FILE_CAB7_CRISOL = "DEIM";
    public static String FILE_CAB8_CRISOL = "DI";
    public static String FILE_CAB9_CRISOL = "FP";
    public static String FILE_CAB10_CRISOL = "PE";
    
    public static String formatDecimal(double value) {
        DecimalFormat myFormatter = new DecimalFormat("#######0.0000");
        String formato = myFormatter.format(value).replaceAll(",", ".");
        return formato;
    }
    
    public static String obtieneYYYYMMDD() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.get(Calendar.YEAR);
        String mes = (calendar.get(Calendar.MONTH)+1)<10?"0"+(calendar.get(Calendar.MONTH)+1):""+(calendar.get(Calendar.MONTH)+1);
        String dia =  calendar.get(Calendar.DAY_OF_MONTH)<10?"0"+calendar.get(Calendar.DAY_OF_MONTH):""+calendar.get(Calendar.DAY_OF_MONTH);
        return calendar.get(Calendar.YEAR) + mes + dia;
    }
    
    public static String obtieneFechaDia() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.get(Calendar.YEAR);
        String mes = (calendar.get(Calendar.MONTH)+1)<10?"0"+(calendar.get(Calendar.MONTH)+1):""+(calendar.get(Calendar.MONTH)+1);
        String dia =  calendar.get(Calendar.DAY_OF_MONTH)<10?"0"+calendar.get(Calendar.DAY_OF_MONTH):""+calendar.get(Calendar.DAY_OF_MONTH);
        //return dia + "/" + mes + "/" + calendar.get(Calendar.YEAR);
        return calendar.get(Calendar.YEAR)+ "/"+ mes + "/"+dia;
    }
    
    public static String obtieneFechaDiaHora() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.get(Calendar.YEAR);
        String mes = (calendar.get(Calendar.MONTH)+1)<10?"0"+(calendar.get(Calendar.MONTH)+1):""+(calendar.get(Calendar.MONTH)+1);
        String dia =  calendar.get(Calendar.DAY_OF_MONTH)<10?"0"+calendar.get(Calendar.DAY_OF_MONTH):""+calendar.get(Calendar.DAY_OF_MONTH);
        String hora = calendar.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendar.get(Calendar.HOUR_OF_DAY) : "0" + calendar.get(Calendar.HOUR_OF_DAY); 
        String minutos = calendar.get(Calendar.MINUTE) > 9 ? "" + calendar.get(Calendar.MINUTE) : "0" + calendar.get(Calendar.MINUTE); 
        String segundos = calendar.get(Calendar.SECOND) > 9 ? "" + calendar.get(Calendar.SECOND) : "0" + calendar.get(Calendar.SECOND); 
        return dia + "/" + mes + "/" + calendar.get(Calendar.YEAR) + " " + hora + ":" + minutos + ":" + segundos;
    }
    
    public static File validaArchivoTicket(int tipo) {
        /*String nombre = (tipo==TipoArchivo.DAT.getTipo())?"dmticket":
                UsuarioData.getUsuario().getUsuario().trim() + 
                Util.completarIzquierda(8, SesionData.getSesion().getTurno()+"", "0");*/
        //jcastillo inicio
        String nombre="";
        Ticket ticket = new Ticket();
        if(tipo==TipoArchivo.DAT.getTipo()){
           nombre =  "dmticket";
        }else if(tipo==TipoArchivo.TXT.getTipo() || tipo==TipoArchivo.TXTLocal.getTipo()){
           nombre = "FE"+Util.FILE_DELIMITADOR_NOMBFELOCAL+SesionData.getSesion().getTipoDocumento()+Util.FILE_DELIMITADOR_NOMBFELOCAL+ticket.getSerie()+Util.FILE_DELIMITADOR_NOMBFELOCAL+Util.completarIzquierda(7, ""+ticket.getNumero(), "0");
           //nombre = "FE"+Util.FILE_DELIMITADOR_NOMBFELOCAL+SesionData.getSesion().getTipoDocumento()+Util.FILE_DELIMITADOR_NOMBFELOCAL+Util.completarIzquierda(3, ""+ticket.getSerie(), "0")+Util.FILE_DELIMITADOR_NOMBFELOCAL+Util.completarIzquierda(8, ""+ticket.getNumero(), "0");
           //nombre = UsuarioData.getUsuario().getUsuario().trim() + Util.completarIzquierda(8, SesionData.getSesion().getTurno()+"", "0")+"_prueba"; 
           //nombreFELocal = ticket.getSerie()+Util.FILE_DELIMITADOR_NOMBFELOCAL+Util.completarIzquierda(8, ""+ticket.getNumero(), "0");
        }else{
           nombre = UsuarioData.getUsuario().getUsuario().trim() + Util.completarIzquierda(7, SesionData.getSesion().getTurno()+"", "0"); 
        }
        //jcastillo fin
        return validaArchivoTicket(tipo, nombre);
    }
    //jcastillo inicio
    /*public static File validaArchivoTicketFacturaElectronica(int tipo) {
        String nombre = (tipo==TipoArchivo.DAT.getTipo())?"dmticket":
                UsuarioData.getUsuario().getUsuario().trim() + "_PRUEBA";
        //return validaArchivoTicketFacturaElectronica(tipo, nombre);
        return validaArchivoTicket(tipo, nombre);
    }
    
    public static File validaArchivoTicketFacturaElectronica(int tipo, String nombre) {
        File folder = null;
        String extension = "";
        try{
            
            if(tipo==TipoArchivo.TXT.getTipo()) extension = "."+TipoArchivo.TXT.getExtension();
            
            String path = SesionData.getSesion().getRutaFacturacionElectronica();
            folder = new File(path);
            if(!folder.isDirectory()) {
                folder.mkdirs();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        File file = null;
        try{
                       
            file = new File(folder.getAbsolutePath()+"\\"+nombre+extension);
            if(!file.isFile()) {
                BufferedWriter bw = null;
                try{
                    bw = new BufferedWriter(new FileWriter(file));
                }catch(Exception ex){
                    ex.printStackTrace();
                }finally{
                    bw.close();
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return file;
    }
    //jcastillo fin
    */
    //jcastillo inicio
    public static File buscarTicketaImprimir(int tipo, String serie, String numero, String tipodocumento) {
        String nombre="";
        Ticket ticket = new Ticket();
        if(tipo==TipoArchivo.TXTLocal.getTipo()){
           //nombre = "FE"+Util.FILE_DELIMITADOR_NOMBFELOCAL+SesionData.getSesion().getTipoDocumento()+Util.FILE_DELIMITADOR_NOMBFELOCAL+serie+Util.FILE_DELIMITADOR_NOMBFELOCAL+numero;
            nombre = "FE"+Util.FILE_DELIMITADOR_NOMBFELOCAL+tipodocumento+Util.FILE_DELIMITADOR_NOMBFELOCAL+serie+Util.FILE_DELIMITADOR_NOMBFELOCAL+numero;
        }
        //jcastillo fin
        return validaTicketaImprimir(tipo, nombre);
    }
    //jcastillo fin
    public static File validaArchivoTicket(int tipo, String nombre) {
        File folder = null;
        try{
            String path = new File ("").getAbsolutePath();
            if(tipo==TipoArchivo.XLS.getTipo()){
                path = path+"\\print\\";
                //jcastillo inicio
            }else if(tipo==TipoArchivo.TXT.getTipo()){
                path = SesionData.getSesion().getrutaFELocal();
            }else if(tipo==TipoArchivo.TXTLocal.getTipo()){
                path = path+"\\in\\";
                //jcastillo fin
            }else{
                path = path+"\\data\\";
            }
            folder = new File(path);
            if(!folder.isDirectory()) {
                folder.mkdirs();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        File file = null;
        try{
            String extension = "";
            if(tipo==TipoArchivo.DAT.getTipo()) extension = "."+TipoArchivo.DAT.getExtension();
            if(tipo==TipoArchivo.DM.getTipo()) extension = "."+TipoArchivo.DM.getExtension();
            if(tipo==TipoArchivo.DMD.getTipo()) extension = "."+TipoArchivo.DMD.getExtension();
            if(tipo==TipoArchivo.XLS.getTipo()) extension = "."+TipoArchivo.XLS.getExtension();
            //jcastillo inicio
            if(tipo==TipoArchivo.TXT.getTipo()) extension = "."+TipoArchivo.TXT.getExtension();
            if(tipo==TipoArchivo.TXTLocal.getTipo()) extension = "."+TipoArchivo.TXT.getExtension();
            //jcastillo fin
            file = new File(folder.getAbsolutePath()+"\\"+nombre+extension);
            if(!file.isFile()) {
                BufferedWriter bw = null;
                try{
                    bw = new BufferedWriter(new FileWriter(file));
                }catch(Exception ex){
                    ex.printStackTrace();
                }finally{
                    bw.close();
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return file;
    }
    //jcastillo incio
    public static File validaTicketaImprimir(int tipo, String nombre) {
        File folder = null;
        try{
            String path = new File ("").getAbsolutePath();
            if(tipo==TipoArchivo.TXTLocal.getTipo()){
                path = path+"\\in\\";
                //jcastillo inicio
            }
            folder = new File(path);            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        File file = null;
        try{
            String extension = "";
            if(tipo==TipoArchivo.TXTLocal.getTipo()) extension = "."+TipoArchivo.TXT.getExtension();
            file = new File(folder.getAbsolutePath()+"\\"+nombre+extension);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return file;
    }
    //jcastillo fin
    
    public static boolean validaArchivo(int tipo) {
        File folder = null;
        try{
            String path = new File ("").getAbsolutePath();
            folder = new File(path+"\\data\\");
            if(!folder.isDirectory()) {
                folder.mkdirs();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        File file = null;
        try{
            String extension = "";
            if(tipo==TipoArchivo.DAT.getTipo()) extension = "."+TipoArchivo.DAT.getExtension();
            if(tipo==TipoArchivo.DM.getTipo()) extension = "."+TipoArchivo.DM.getExtension();
            if(tipo==TipoArchivo.DMD.getTipo()) extension = "."+TipoArchivo.DMD.getExtension();
            file = new File(folder.getAbsolutePath()+"\\"+obtieneYYYYMMDD()+extension);
            return file.isFile();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public static void writeUserdata(File file) throws IOException{
        FileWriter escribir = null;
        try{
            escribir = new FileWriter(file);
            escribir.write("USUARIO:"+UsuarioData.getUsuario().getUsuario()+"\n");
            escribir.write("NOMBRE:"+UsuarioData.getUsuario().getNombre()+"\n");
            escribir.write("MAIL:"+UsuarioData.getUsuario().getMail()+"\n");
            escribir.write("IDCOMPANIA:"+SesionData.getSesion().getIdcompania()+"\n");
            escribir.write("COMPANIA:"+SesionData.getSesion().getCompania()+"\n");
            escribir.write("DIRECCIONCOMPANIA:"+SesionData.getSesion().getDireccionCompania()+"\n");
            escribir.write("IDLOCALIDAD:"+SesionData.getSesion().getIdlocalidad()+"\n");
            escribir.write("ALMACEN:"+SesionData.getSesion().getAlmacen()+"\n");
            escribir.write("ID_TDA:"+SesionData.getSesion().getTienda()+"\n");
            escribir.write("PVTA_ID:"+SesionData.getSesion().getPtoventa()+"\n");
            escribir.write("LISTAPRECIOS:"+SesionData.getSesion().getListaPrecios()+"\n");
            escribir.write("CODIGOCLIENTE:"+SesionData.getSesion().getCodigoCliente()+"\n");
            escribir.write("CLASEAUX:"+SesionData.getSesion().getClaseAux()+"\n");
            escribir.write("TIPODOCUMENTO:"+SesionData.getSesion().getTipoDocumento()+"\n");
            escribir.write("FORMAPAGO:"+SesionData.getSesion().getFormaPago()+"\n");
            escribir.write("TIPOMONEDA:"+SesionData.getSesion().getTipoMoneda()+"\n");
            escribir.write("TIPOVENTA:"+SesionData.getSesion().getTipoVenta()+"\n");
            escribir.write("UNIDADMEDIDA:"+SesionData.getSesion().getUnidadMedida()+"\n");
            //jcastillo inicio
            escribir.write("SERIE:"+SesionData.getSesion().getSerie()+"\n");
            //jcastillo fin
            escribir.write("NUMERO:"+SesionData.getSesion().getNumero()+"\n");
            escribir.write("TURNO:"+SesionData.getSesion().getTurno()+"\n");
            escribir.write("IMPRESIONES:"+SesionData.getSesion().getImpresiones()+"\n");
            escribir.write("TIPOCLIENTE:"+SesionData.getSesion().getTipoCliente()+"\n");
            escribir.write("IGVPORCENTAJE:"+SesionData.getSesion().getIgvPorcentaje()+"\n");
            escribir.write("FILESCOPY:"+SesionData.getSesion().getCopyFilePath()+"\n");
            escribir.write("FECHAPROCESO:"+SesionData.getSesion().getFechaProceso()+"\n");
            escribir.write("TOPESERIE:"+SesionData.getSesion().getTopeSerie()+"\n");
            escribir.write("TOPENUMERO:"+SesionData.getSesion().getTopeNumero()+"\n");
            escribir.write("IMPRESORA:"+SesionData.getSesion().getImpresora()+"\n");
            escribir.write("MODELO:"+SesionData.getSesion().getModelo()+"\n");
            escribir.write("SERIAL:"+SesionData.getSesion().getSerial()+"\n");
            escribir.write("IPSERVER:"+SesionData.getSesion().getIpserver()+"\n");
            escribir.write("TOPETICKET:"+SesionData.getSesion().getTopeTicket()+"\n");
            //jcastillo
            escribir.write("RUTAFELOCAL:"+SesionData.getSesion().getrutaFELocal()+"\n");
            escribir.write("RUCDERRAMA:"+SesionData.getSesion().getRucDerrama()+"\n");
            escribir.write("NOMBDERRAMA:"+SesionData.getSesion().getNombDerrama()+"\n");
            escribir.write("DIRECDERRAMA:"+SesionData.getSesion().getDirecDerrama()+"\n");
            escribir.write("UBGDERRAMA:"+SesionData.getSesion().getUbgDerrama()+"\n");
            escribir.write("PRVDERRAMA:"+SesionData.getSesion().getPrvDerrama()+"\n");
            escribir.write("DEPDERRAMA:"+SesionData.getSesion().getDepDerrama()+"\n");
            escribir.write("DSTDERRAMA:"+SesionData.getSesion().getDstDerrama()+"\n");
            escribir.write("PAIS:"+SesionData.getSesion().getPais()+"\n");
            escribir.write("PRINTDEST:"+SesionData.getSesion().getPrintDestino()+"\n");
            escribir.write("CODIMPUESTO:"+SesionData.getSesion().getCodImpuesto()+"\n");
            escribir.write("MENSAJES:"+SesionData.getSesion().getMensajes()+"");
            
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            escribir.close();
        }
    }
    
    public static String completarDerecha(int cantidad, String texto){
        String textoNuevo = texto;
        if(texto.length()>cantidad){
            return texto.substring(0, cantidad);
        }else{
            for(int i=texto.length(); i<cantidad; i++){
                textoNuevo = textoNuevo + " ";
            }
            return textoNuevo;
        }
    }

    public static String completarIzquierda(int cantidad, String texto){
        return completarIzquierda(cantidad, texto, " ");
    }

    public static String completarIzquierda(int cantidad, String texto, String completa){
        String textoNuevo = texto;
        if(texto.length()>cantidad){
            return texto.substring(0, cantidad);
        }else{
            for(int i=texto.length(); i<cantidad; i++){
                textoNuevo = completa + textoNuevo;
            }
            return textoNuevo;
        }
    }
    
    public static int getLimitLine(){
        int limit = 56;
        if(SesionData.getSesion().getModelo().trim().compareTo("TM-U220")==0){
            limit = 40;
        }
        return limit;
    }
    
    public static int getNroRegistrosTurno(){
        File fileCab = null;
        int cantidad = 0;
        try{
            fileCab = Util.validaArchivoTicket(TipoArchivo.DM.getTipo());
            if(fileCab==null){
                return 0;
            }
            BufferedReader br = new BufferedReader(new FileReader(fileCab));
            String line = br.readLine();
            while (line != null) {
                if(line!=null && line.trim().compareTo("")!=0){
                    cantidad++;
                }
                line = br.readLine();
            }
            br.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return cantidad;
    }
    public static boolean validaCaracter(Character c) {
    int x=0;
    char Alfab[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z',
    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z',
    '1','2','3','4','5','6','7','8','9','0'};
    int longitud = Alfab.length;
    for (int i = 0; i<longitud; i++) {
        if(c!=(Alfab[i])){ /*aqui evaluo si elcaratér tipeado es distinto a los caracteres válidos*/
        x++;
        }
    }
    if(x < longitud){
        return true;
    }    
        return false;
    }
   
}

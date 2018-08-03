/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.VentasCabeceraVO;
import com.dematicket.bean.VentasDetalleVO;
import com.dematicket.util.DbConnection;
import com.dematicket.util.DbOracleConnection;
import com.dematicket.util.Util;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author jcastillop
 */
public class VentasDAO {
 /*
    String valor =jcbTipoDocumento.getSelectedItem().toString();
        System.out.println(valor);
        String valorSeleccionado[] = valor.split(" - ");
    */   
    /*VentasCabeceraVO ventasCabeceraVO;
    VentasDetalleVO ventasDetalleVO;*/
    static boolean resultado=true;
    
    public boolean insertaCabeceraVentas(VentasCabeceraVO ventasCabeceraVO){
       DbConnection conex= new DbConnection(); 
       try{ 
            PreparedStatement consulta = conex.getConnection().prepareStatement("INSERT INTO dmticket.dmt_ventas_cab " +
            "(IDCOMPANIA," +
            "TIPODOCUMENTO," +
            "SERIE," +
            "NUMERO," +
            "FECHAPROCESO," +
            "IDLOCALIDAD," +
            "TINID," +
            "ALMACEN," +
            "PVTAID," +
            "LISTAPRECIOS," +
            "CODIGOCLIENTE," +
            "CLASEAUX," +
            "CLIERUC," +
            "TURNO," +
            "VEID," +
            "FORMAPAGO," +
            "TIPOMONEDA," +
            "TIPOVENTA," +
            "FACMTOMO," +
            "FACMTOMN," +
            "FACMTOME," +
            "FACESTADO," +
            "FACDCTOMO," +
            "FACDCTOMN," +
            "FACDCTOME," +
            "FACUSER," +
            "FACFREG," +
            "FACHREG," +
            "FACANOMES," +
            "FACTCAM," +
            "FACFLAGD," +
            "FACIGVMO," +
            "FACIGVMN," +
            "FACIGVME," +
            "FACISCMO," +
            "FACISCMN," +
            "FACISCME," +
            "FACTOTMO," +
            "FACTOTMN," +
            "FACTOTME," +
            "FACTIP," +
            "TIPPERID," +
            "FACDSCTO1," +
            "FACIMPREP," +
            "FACFEVCMTO," +
            "FACTCLI," +
            "FACTDES," +
            "CLIEDIR," +
            "TIPOADQ," +
            "FACIGV2MN," +
            "FACIGV2ME," +
            "FACIGV2MO," +
            "INICIAL," +
            "FACSERMO," +
            "FACSERMN," +
            "FACSERME," +
            "PORIGV," +
            "PORSER," +
            "FACMTOGRAV," +
            "FACMTOEXO," +
            "FACMTOINA," +
            "FACMTOGRAT," +
            "TIPOPERACION)" +
            "VALUES" +
            "(?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?);");
            consulta.setString(1,ventasCabeceraVO.getIDCOMPANIA());
            consulta.setString(2,ventasCabeceraVO.getTIPODOCUMENTO());
            consulta.setString(3,ventasCabeceraVO.getSERIE());
            consulta.setString(4,ventasCabeceraVO.getNUMERO());
            consulta.setString(5,ventasCabeceraVO.getFECHAPROCESO());
            consulta.setString(6,ventasCabeceraVO.getIDLOCALIDAD());
            consulta.setString(7,ventasCabeceraVO.getTINID());
            consulta.setString(8,ventasCabeceraVO.getALMACEN());
            consulta.setString(9,ventasCabeceraVO.getPVTAID());
            consulta.setString(10,ventasCabeceraVO.getLISTAPRECIOS());
            consulta.setString(11,ventasCabeceraVO.getCODIGOCLIENTE());
            consulta.setString(12,ventasCabeceraVO.getCLASEAUX());
            consulta.setString(13,ventasCabeceraVO.getCLIERUC());
            consulta.setString(14,ventasCabeceraVO.getTURNO());
            consulta.setString(15,ventasCabeceraVO.getVEID());
            consulta.setString(16,ventasCabeceraVO.getFORMAPAGO());
            consulta.setString(17,ventasCabeceraVO.getTIPOMONEDA());
            consulta.setString(18,ventasCabeceraVO.getTIPOVENTA());            
            consulta.setBigDecimal(19,ventasCabeceraVO.getFACMTOMO());
            consulta.setBigDecimal(20,ventasCabeceraVO.getFACMTOMN());
            consulta.setBigDecimal(21,ventasCabeceraVO.getFACMTOME());
            consulta.setString(22,ventasCabeceraVO.getFACESTADO());
            consulta.setBigDecimal(23,ventasCabeceraVO.getFACDCTOMO());
            consulta.setBigDecimal(24,ventasCabeceraVO.getFACDCTOMN());
            consulta.setBigDecimal(25,ventasCabeceraVO.getFACDCTOME());
            consulta.setString(26,ventasCabeceraVO.getFACUSER());
            consulta.setString(27,ventasCabeceraVO.getFACFREG());
            consulta.setString(28,ventasCabeceraVO.getFACHREG());
            consulta.setString(29,ventasCabeceraVO.getFACANOMES());
            consulta.setBigDecimal(30,ventasCabeceraVO.getFACTCAM());
            consulta.setString(31,ventasCabeceraVO.getFACFLAGD());            
            consulta.setBigDecimal(32,ventasCabeceraVO.getFACIGVMO());
            consulta.setBigDecimal(33,ventasCabeceraVO.getFACIGVMN());
            consulta.setBigDecimal(34,ventasCabeceraVO.getFACIGVME());
            consulta.setBigDecimal(35,ventasCabeceraVO.getFACISCMO());
            consulta.setBigDecimal(36,ventasCabeceraVO.getFACISCMN());
            consulta.setBigDecimal(37,ventasCabeceraVO.getFACISCME());
            consulta.setBigDecimal(38,ventasCabeceraVO.getFACTOTMO());
            consulta.setBigDecimal(39,ventasCabeceraVO.getFACTOTMN());
            consulta.setBigDecimal(40,ventasCabeceraVO.getFACTOTME());
            consulta.setString(41,ventasCabeceraVO.getFACTIP());            
            consulta.setString(42,ventasCabeceraVO.getTIPPERID());
            consulta.setBigDecimal(43,ventasCabeceraVO.getFACDSCTO1());
            consulta.setString(44,ventasCabeceraVO.getFACIMPREP());
            consulta.setString(45,ventasCabeceraVO.getFACFEVCMTO());
            consulta.setString(46,ventasCabeceraVO.getFACTCLI());
            consulta.setString(47,ventasCabeceraVO.getFACTDES());
            consulta.setString(48,ventasCabeceraVO.getCLIEDIR());
            consulta.setString(49,ventasCabeceraVO.getTIPOADQ());
            consulta.setBigDecimal(50,ventasCabeceraVO.getFACIGV2MN());
            consulta.setBigDecimal(51,ventasCabeceraVO.getFACIGV2ME());
            consulta.setBigDecimal(52,ventasCabeceraVO.getFACIGV2MO());            
            consulta.setBigDecimal(53,ventasCabeceraVO.getINICIAL());
            consulta.setBigDecimal(54,ventasCabeceraVO.getFACSERMO());
            consulta.setBigDecimal(55,ventasCabeceraVO.getFACSERMN());
            consulta.setBigDecimal(56,ventasCabeceraVO.getFACSERME());
            consulta.setBigDecimal(57,ventasCabeceraVO.getPORIGV());
            consulta.setBigDecimal(58,ventasCabeceraVO.getPORSER());            
            consulta.setBigDecimal(59,ventasCabeceraVO.getFACMTOGRAV());
            consulta.setBigDecimal(60,ventasCabeceraVO.getFACMTOEXO());
            consulta.setBigDecimal(61,ventasCabeceraVO.getFACMTOINA());
            consulta.setBigDecimal(62,ventasCabeceraVO.getFACMTOGRAT());
            consulta.setString(63,ventasCabeceraVO.getTIPOPERACION());
            
            consulta.executeUpdate();
            consulta.close();
            conex.desconectar();
            
        }catch(Exception ex){
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
        }
        return resultado;
    }
    public boolean insertaCabeceraVentasNC(VentasCabeceraVO ventasCabeceraVO){
       DbConnection conex= new DbConnection(); 
       try{ 
            PreparedStatement consulta = conex.getConnection().prepareStatement("INSERT INTO dmticket.dmt_ventas_cab " +
            "(IDCOMPANIA," +
            "TIPODOCUMENTO," +
            "SERIE," +
            "NUMERO," +
            "FECHAPROCESO," +
            "IDLOCALIDAD," +
            "TINID," +
            "ALMACEN," +
            "PVTAID," +
            "LISTAPRECIOS," +
            "CODIGOCLIENTE," +
            "CLASEAUX," +
            "CLIERUC," +
            "TURNO," +
            "VEID," +
            "FORMAPAGO," +
            "TIPOMONEDA," +
            "TIPOVENTA," +
            "FACMTOMO," +
            "FACMTOMN," +
            "FACMTOME," +
            "FACESTADO," +
            "FACDCTOMO," +
            "FACDCTOMN," +
            "FACDCTOME," +
            "FACUSER," +
            "FACFREG," +
            "FACHREG," +
            "FACANOMES," +
            "FACTCAM," +
            "FACFLAGD," +
            "FACIGVMO," +
            "FACIGVMN," +
            "FACIGVME," +
            "FACISCMO," +
            "FACISCMN," +
            "FACISCME," +
            "FACTOTMO," +
            "FACTOTMN," +
            "FACTOTME," +
            "FACTIP," +
            "TIPPERID," +
            "FACDSCTO1," +
            "FACIMPREP," +
            "FACFEVCMTO," +
            "FACTCLI," +
            "FACTDES," +
            "CLIEDIR," +
            "TIPOADQ," +
            "FACIGV2MN," +
            "FACIGV2ME," +
            "FACIGV2MO," +
            "INICIAL," +
            "FACSERMO," +
            "FACSERMN," +
            "FACSERME," +
            "PORIGV," +
            "PORSER," +
            "FACMTOGRAV," +
            "FACMTOEXO," +
            "FACMTOINA," +
            "FACMTOGRAT," +
            "TIPOPERACION," +
            
            "TIPODOC_REF," +
            "SERIE_REF," +
            "NUMERO_REF," +
            "MOTIVO) " +
            "VALUES" +
            "(?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," + 
            "?," +
            "?);");
            consulta.setString(1,ventasCabeceraVO.getIDCOMPANIA());
            consulta.setString(2,ventasCabeceraVO.getTIPODOCUMENTO());
            consulta.setString(3,ventasCabeceraVO.getSERIE());
            consulta.setString(4,ventasCabeceraVO.getNUMERO());
            consulta.setString(5,ventasCabeceraVO.getFECHAPROCESO());
            consulta.setString(6,ventasCabeceraVO.getIDLOCALIDAD());
            consulta.setString(7,ventasCabeceraVO.getTINID());
            consulta.setString(8,ventasCabeceraVO.getALMACEN());
            consulta.setString(9,ventasCabeceraVO.getPVTAID());
            consulta.setString(10,ventasCabeceraVO.getLISTAPRECIOS());
            consulta.setString(11,ventasCabeceraVO.getCODIGOCLIENTE());
            consulta.setString(12,ventasCabeceraVO.getCLASEAUX());
            consulta.setString(13,ventasCabeceraVO.getCLIERUC());
            consulta.setString(14,ventasCabeceraVO.getTURNO());
            consulta.setString(15,ventasCabeceraVO.getVEID());
            consulta.setString(16,ventasCabeceraVO.getFORMAPAGO());
            consulta.setString(17,ventasCabeceraVO.getTIPOMONEDA());
            consulta.setString(18,ventasCabeceraVO.getTIPOVENTA());            
            consulta.setBigDecimal(19,ventasCabeceraVO.getFACMTOMO());
            consulta.setBigDecimal(20,ventasCabeceraVO.getFACMTOMN());
            consulta.setBigDecimal(21,ventasCabeceraVO.getFACMTOME());
            consulta.setString(22,ventasCabeceraVO.getFACESTADO());
            consulta.setBigDecimal(23,ventasCabeceraVO.getFACDCTOMO());
            consulta.setBigDecimal(24,ventasCabeceraVO.getFACDCTOMN());
            consulta.setBigDecimal(25,ventasCabeceraVO.getFACDCTOME());
            consulta.setString(26,ventasCabeceraVO.getFACUSER());
            consulta.setString(27,ventasCabeceraVO.getFACFREG());
            consulta.setString(28,ventasCabeceraVO.getFACHREG());
            consulta.setString(29,ventasCabeceraVO.getFACANOMES());
            consulta.setBigDecimal(30,ventasCabeceraVO.getFACTCAM());
            consulta.setString(31,ventasCabeceraVO.getFACFLAGD());            
            consulta.setBigDecimal(32,ventasCabeceraVO.getFACIGVMO());
            consulta.setBigDecimal(33,ventasCabeceraVO.getFACIGVMN());
            consulta.setBigDecimal(34,ventasCabeceraVO.getFACIGVME());
            consulta.setBigDecimal(35,ventasCabeceraVO.getFACISCMO());
            consulta.setBigDecimal(36,ventasCabeceraVO.getFACISCMN());
            consulta.setBigDecimal(37,ventasCabeceraVO.getFACISCME());
            consulta.setBigDecimal(38,ventasCabeceraVO.getFACTOTMO());
            consulta.setBigDecimal(39,ventasCabeceraVO.getFACTOTMN());
            consulta.setBigDecimal(40,ventasCabeceraVO.getFACTOTME());
            consulta.setString(41,ventasCabeceraVO.getFACTIP());            
            consulta.setString(42,ventasCabeceraVO.getTIPPERID());
            consulta.setBigDecimal(43,ventasCabeceraVO.getFACDSCTO1());
            consulta.setString(44,ventasCabeceraVO.getFACIMPREP());
            consulta.setString(45,ventasCabeceraVO.getFACFEVCMTO());
            consulta.setString(46,ventasCabeceraVO.getFACTCLI());
            consulta.setString(47,ventasCabeceraVO.getFACTDES());
            consulta.setString(48,ventasCabeceraVO.getCLIEDIR());
            consulta.setString(49,ventasCabeceraVO.getTIPOADQ());
            consulta.setBigDecimal(50,ventasCabeceraVO.getFACIGV2MN());
            consulta.setBigDecimal(51,ventasCabeceraVO.getFACIGV2ME());
            consulta.setBigDecimal(52,ventasCabeceraVO.getFACIGV2MO());            
            consulta.setBigDecimal(53,ventasCabeceraVO.getINICIAL());
            consulta.setBigDecimal(54,ventasCabeceraVO.getFACSERMO());
            consulta.setBigDecimal(55,ventasCabeceraVO.getFACSERMN());
            consulta.setBigDecimal(56,ventasCabeceraVO.getFACSERME());
            consulta.setBigDecimal(57,ventasCabeceraVO.getPORIGV());
            consulta.setBigDecimal(58,ventasCabeceraVO.getPORSER());            
            consulta.setBigDecimal(59,ventasCabeceraVO.getFACMTOGRAV());
            consulta.setBigDecimal(60,ventasCabeceraVO.getFACMTOEXO());
            consulta.setBigDecimal(61,ventasCabeceraVO.getFACMTOINA());
            consulta.setBigDecimal(62,ventasCabeceraVO.getFACMTOGRAT());
            consulta.setString(63,ventasCabeceraVO.getTIPOPERACION());
            
            consulta.setString(64,ventasCabeceraVO.getTIPODOC_REF());
            consulta.setString(65,ventasCabeceraVO.getSERIE_REF());
            consulta.setString(66,ventasCabeceraVO.getNUMERO_REF());
            consulta.setString(67,ventasCabeceraVO.getMOTIVO());
            
            consulta.executeUpdate();
            consulta.close();
            conex.desconectar();
            
        }catch(Exception ex){
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
        }
        return resultado;
    }
    
    
    public boolean verificaVentasSinProcesar(){
        boolean existe=false;
        DbConnection conex= new DbConnection();
        try{
            PreparedStatement consultaCab = conex.getConnection().prepareStatement("SELECT IDCOMPANIA,IDLOCALIDAD,TINID,ALMACEN,LISTAPRECIOS,CODIGOCLIENTE,CLASEAUX,CLIERUC, " +
            " SERIE,NUMERO,DATE_FORMAT(FECHAPROCESO,\"%Y/%m/%d\")FECHAPROCESO,VEID,FORMAPAGO,TIPOMONEDA,TIPOVENTA,FACMTOMO,FACMTOMN, " +
            " FACMTOME,FACESTADO,FACDCTOMO,FACDCTOMN,FACDCTOME,FACUSER,DATE_FORMAT(FACFREG,\"%Y/%m/%d\")FACFREG,DATE_FORMAT(STR_TO_DATE(FACHREG,'%d/%m/%Y %H:%i:%s'),\"%d/%m/%Y %H:%i:%s\")FACHREG,FACANOMES, " +
            " FACTCAM,FACFLAGD,FACIGVMO,FACIGVMN,FACIGVME,FACISCMO,FACISCMN,FACISCME,FACTOTMO, " +
            " FACTOTMN,FACTOTME,FACTIP,TIPODOCUMENTO,TIPPERID,FACDSCTO1,FACIMPREP,FACFEVCMTO, " +
            " FACTCLI,FACTDES,CLIEDIR,TIPOADQ,FACIGV2MN,FACIGV2ME,FACIGV2MO,INICIAL,FACSERMO, " +
            " FACSERMN,FACSERME,PORIGV,PORSER,FACMTOGRAV,FACMTOEXO,FACMTOINA,FACMTOGRAT,TIPOPERACION,PVTAID,TURNO FROM DMTICKET.DMT_VENTAS_CAB WHERE PROCESADO IS NULL AND IDCOMPANIA = ? AND PVTAID = ?");
            consultaCab.setString(1,UsuarioData.getUsuario().getEmpresa());
            consultaCab.setString(2,UsuarioData.getUsuario().getPtoVenta());
            ResultSet resCab = consultaCab.executeQuery();
            //esta seccion falta verificar
            PreparedStatement consultaDet = conex.getConnection().prepareStatement("SELECT IDCOMPANIA,TIPODOCUMENTO,SERIE,NUMERO,NUMREG,CODCON, " +
            " DESCON,UNIDADMEDIDA,CANTIDAD,DFACPREUMO,DFACPREUMN,DFACPREUME, " +
            " DFACMTOMO,DFACMTOMN,DFACMTOME,DATE_FORMAT(STR_TO_DATE(FECHVTA,'%d/%m/%Y %H:%i:%s'),\"%d/%m/%Y %H:%i:%s\")FECHVTA,DFACIMP1,DFACIMPMTO1, " +
            " DFACVTOTMO,DFACVTOTMN,DFACVTOTME,DFACTFLAG,USUREG,DATE_FORMAT(FECREG,\"%Y/%m/%d\")FECREG  " +
            " FROM DMTICKET.DMT_VENTAS_DET WHERE " +
            " PROCESADO IS NULL AND IDCOMPANIA =? ORDER BY NUMREG");
            consultaDet.setString(1,UsuarioData.getUsuario().getEmpresa());
            ResultSet resDet = consultaDet.executeQuery();
            
            if(resCab.next() || resDet.next()){
               existe=true; 
            }
            consultaCab.close();
            resCab.close();
            consultaDet.close();
            resDet.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            conex.desconectar();
        }
        return existe;
    }
    
    public ArrayList<VentasCabeceraVO> cabeceraSinProcesarList (){
       ArrayList<VentasCabeceraVO> cabeceraList = new ArrayList();
       VentasCabeceraVO ventasCabeceraVO;
       DbConnection conex= new DbConnection(); 
       try{
           PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT IDCOMPANIA,IDLOCALIDAD,TINID,ALMACEN,LISTAPRECIOS,CODIGOCLIENTE,CLASEAUX,CLIERUC, " +
            " SERIE,NUMERO,DATE_FORMAT(FECHAPROCESO,\"%Y/%m/%d\")FECHAPROCESO,VEID,FORMAPAGO,TIPOMONEDA,TIPOVENTA,FACMTOMO,FACMTOMN, " +
            " FACMTOME,FACESTADO,FACDCTOMO,FACDCTOMN,FACDCTOME,FACUSER,DATE_FORMAT(FACFREG,\"%Y/%m/%d\")FACFREG,DATE_FORMAT(STR_TO_DATE(FACHREG,'%d/%m/%Y %H:%i:%s'),\"%d/%m/%Y %H:%i:%s\")FACHREG,FACANOMES, " +
            " FACTCAM,FACFLAGD,FACIGVMO,FACIGVMN,FACIGVME,FACISCMO,FACISCMN,FACISCME,FACTOTMO, " +
            " FACTOTMN,FACTOTME,FACTIP,TIPODOCUMENTO,TIPPERID,FACDSCTO1,FACIMPREP,FACFEVCMTO, " +
            " FACTCLI,FACTDES,CLIEDIR,TIPOADQ,FACIGV2MN,FACIGV2ME,FACIGV2MO,INICIAL,FACSERMO, " +
            " FACSERMN,FACSERME,PORIGV,PORSER,FACMTOGRAV,FACMTOEXO,FACMTOINA,FACMTOGRAT,TIPOPERACION,PVTAID,TURNO FROM DMTICKET.DMT_VENTAS_CAB WHERE PROCESADO IS NULL");
           ResultSet res = consulta.executeQuery();
           while(res.next()){
              ventasCabeceraVO = new VentasCabeceraVO();
              
              ventasCabeceraVO.setIDCOMPANIA(res.getString("IDCOMPANIA"));
              ventasCabeceraVO.setIDLOCALIDAD(res.getString("IDLOCALIDAD"));
              ventasCabeceraVO.setTINID(res.getString("TINID"));
              ventasCabeceraVO.setALMACEN(res.getString("ALMACEN"));
              ventasCabeceraVO.setLISTAPRECIOS(res.getString("LISTAPRECIOS"));
              ventasCabeceraVO.setCODIGOCLIENTE(res.getString("CODIGOCLIENTE"));
              ventasCabeceraVO.setCLASEAUX(res.getString("CLASEAUX"));
              ventasCabeceraVO.setCLIERUC(res.getString("CLIERUC"));//si no ingresa ruc le pone el codigo de cliente genérico
              ventasCabeceraVO.setSERIE(res.getString("SERIE"));
              ventasCabeceraVO.setNUMERO(res.getString("NUMERO"));
              ventasCabeceraVO.setFECHAPROCESO(res.getString("FECHAPROCESO"));
              ventasCabeceraVO.setVEID(res.getString("VEID"));//codigo vendedor = id usuario
              ventasCabeceraVO.setFORMAPAGO(res.getString("FORMAPAGO"));
              ventasCabeceraVO.setTIPOMONEDA(res.getString("TIPOMONEDA"));
              ventasCabeceraVO.setTIPOVENTA(res.getString("TIPOVENTA"));
              ventasCabeceraVO.setFACMTOMO(res.getBigDecimal("FACMTOMO"));
              ventasCabeceraVO.setFACMTOMN(res.getBigDecimal("FACMTOMN"));
              ventasCabeceraVO.setFACMTOME(res.getBigDecimal("FACMTOME"));
              ventasCabeceraVO.setFACESTADO(res.getString("FACESTADO"));
              ventasCabeceraVO.setFACDCTOMO(res.getBigDecimal("FACDCTOMO"));
              ventasCabeceraVO.setFACDCTOMN(res.getBigDecimal("FACDCTOMN"));
              ventasCabeceraVO.setFACDCTOME(res.getBigDecimal("FACDCTOME"));
              ventasCabeceraVO.setFACUSER(res.getString("FACUSER"));
              ventasCabeceraVO.setFACFREG(res.getString("FACFREG"));
              ventasCabeceraVO.setFACHREG(res.getString("FACHREG"));
              ventasCabeceraVO.setFACANOMES(res.getString("FACANOMES"));
              ventasCabeceraVO.setFACTCAM(res.getBigDecimal("FACTCAM"));//tipo cambio 0
              ventasCabeceraVO.setFACFLAGD(res.getString("FACFLAGD"));
              ventasCabeceraVO.setFACIGVMO(res.getBigDecimal("FACIGVMO"));
              ventasCabeceraVO.setFACIGVMN(res.getBigDecimal("FACIGVMN"));
              ventasCabeceraVO.setFACIGVME(res.getBigDecimal("FACIGVME"));
              ventasCabeceraVO.setFACISCMO(res.getBigDecimal("FACISCMO"));
              ventasCabeceraVO.setFACISCMN(res.getBigDecimal("FACISCMN"));
              ventasCabeceraVO.setFACISCME(res.getBigDecimal("FACISCME"));
              ventasCabeceraVO.setFACTOTMO(res.getBigDecimal("FACTOTMO"));
              ventasCabeceraVO.setFACTOTMN(res.getBigDecimal("FACTOTMN"));
              ventasCabeceraVO.setFACTOTME(res.getBigDecimal("FACTOTME"));
              ventasCabeceraVO.setFACTIP(res.getString("FACTIP"));
              ventasCabeceraVO.setTIPODOCUMENTO(res.getString("TIPODOCUMENTO"));
              ventasCabeceraVO.setTIPPERID(res.getString("TIPPERID"));
              ventasCabeceraVO.setFACDSCTO1(res.getBigDecimal("FACDSCTO1"));
              ventasCabeceraVO.setFACIMPREP(res.getString("FACIMPREP"));
              ventasCabeceraVO.setFACFEVCMTO(res.getString("FACFEVCMTO"));//vacio
              ventasCabeceraVO.setFACTCLI(res.getString("FACTCLI"));
              ventasCabeceraVO.setFACTDES(res.getString("FACTDES"));
              ventasCabeceraVO.setCLIEDIR(res.getString("CLIEDIR"));
              ventasCabeceraVO.setTIPOADQ(res.getString("TIPOADQ"));
              ventasCabeceraVO.setFACIGV2MN(res.getBigDecimal("FACIGV2MN"));
              ventasCabeceraVO.setFACIGV2MO(res.getBigDecimal("FACIGV2MO"));
              ventasCabeceraVO.setFACIGV2ME(res.getBigDecimal("FACIGV2ME"));
              ventasCabeceraVO.setINICIAL(res.getBigDecimal("INICIAL"));
              ventasCabeceraVO.setFACSERMO(res.getBigDecimal("FACSERMO"));
              ventasCabeceraVO.setFACSERMN(res.getBigDecimal("FACSERMN"));
              ventasCabeceraVO.setFACSERME(res.getBigDecimal("FACSERME"));
              ventasCabeceraVO.setPORIGV(res.getBigDecimal("PORIGV"));
              ventasCabeceraVO.setPORSER(res.getBigDecimal("PORSER"));
              ventasCabeceraVO.setFACMTOGRAV(res.getBigDecimal("FACMTOGRAV"));
              ventasCabeceraVO.setFACMTOEXO(res.getBigDecimal("FACMTOEXO"));
              ventasCabeceraVO.setFACMTOINA(res.getBigDecimal("FACMTOINA"));
              ventasCabeceraVO.setFACMTOGRAT(res.getBigDecimal("FACMTOGRAT"));
              ventasCabeceraVO.setTIPOPERACION(res.getString("TIPOPERACION"));
              ventasCabeceraVO.setPVTAID(res.getString("PVTAID"));
              ventasCabeceraVO.setTURNO(res.getString("TURNO"));
              
              cabeceraList.add(ventasCabeceraVO);
              
           }
           consulta.close();
       }catch(Exception ex){
            conex.desconectar();
            ex.printStackTrace();
        }  
       
       return cabeceraList;
    }
    //esta seccion falta verificar
    public ArrayList<VentasDetalleVO> detalleSinProcesarList (VentasCabeceraVO ventasCabeceraVO){
       ArrayList<VentasDetalleVO> detalleList = new ArrayList();
       VentasDetalleVO ventasDetalleVO;
       DbConnection conex= new DbConnection(); 
       try{
           PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT IDCOMPANIA,TIPODOCUMENTO,SERIE,NUMERO,NUMREG,CODCON, " +
            " DESCON,UNIDADMEDIDA,CANTIDAD,DFACPREUMO,DFACPREUMN,DFACPREUME, " +
            " DFACMTOMO,DFACMTOMN,DFACMTOME,DATE_FORMAT(STR_TO_DATE(FECHVTA,'%d/%m/%Y %H:%i:%s'),\"%d/%m/%Y %H:%i:%s\")FECHVTA,DFACIMP1,DFACIMPMTO1, " +
            " DFACVTOTMO,DFACVTOTMN,DFACVTOTME,DFACTFLAG,USUREG,DATE_FORMAT(FECREG,\"%Y/%m/%d\")FECREG  " +
            " FROM DMTICKET.DMT_VENTAS_DET WHERE " +
            " IDCOMPANIA =? AND TIPODOCUMENTO =? AND SERIE =? AND NUMERO =? " +
            " AND PROCESADO IS NULL ORDER BY NUMREG");
           consulta.setString(1,ventasCabeceraVO.getIDCOMPANIA());
           consulta.setString(2,ventasCabeceraVO.getTIPODOCUMENTO());
           consulta.setString(3,ventasCabeceraVO.getSERIE());
           consulta.setString(4,Util.completarIzquierda(8, ventasCabeceraVO.getNUMERO(), "0"));
           ResultSet res = consulta.executeQuery();
           
           while(res.next()){
              ventasDetalleVO = new VentasDetalleVO();
              
              ventasDetalleVO.setIDCOMPANIA(res.getString("IDCOMPANIA"));
              ventasDetalleVO.setTIPODOCUMENTO(res.getString("TIPODOCUMENTO"));
              ventasDetalleVO.setSERIE(res.getString("SERIE"));
              ventasDetalleVO.setNUMERO(res.getString("NUMERO"));
              ventasDetalleVO.setNUMREG(res.getBigDecimal("NUMREG"));
              ventasDetalleVO.setCODCON(res.getString("CODCON"));
              ventasDetalleVO.setDESCON(res.getString("DESCON"));
              ventasDetalleVO.setUNIDADMEDIDA(res.getString("UNIDADMEDIDA"));
              ventasDetalleVO.setCANTIDAD(res.getBigDecimal("CANTIDAD"));
              ventasDetalleVO.setDFACPREUMO(res.getBigDecimal("DFACPREUMO"));
              ventasDetalleVO.setDFACPREUMN(res.getBigDecimal("DFACPREUMN"));
              ventasDetalleVO.setDFACPREUME(res.getBigDecimal("DFACPREUME"));
              ventasDetalleVO.setDFACMTOMO(res.getBigDecimal("DFACMTOMO"));
              ventasDetalleVO.setDFACMTOMN(res.getBigDecimal("DFACMTOMN"));
              ventasDetalleVO.setDFACMTOME(res.getBigDecimal("DFACMTOME"));
              ventasDetalleVO.setFECHVTA(res.getString("FECHVTA"));
              ventasDetalleVO.setDFACIMP1(res.getBigDecimal("DFACIMP1"));
              ventasDetalleVO.setDFACIMPMTO1(res.getBigDecimal("DFACIMPMTO1"));
              ventasDetalleVO.setDFACVTOTMO(res.getBigDecimal("DFACVTOTMO"));
              ventasDetalleVO.setDFACVTOTMN(res.getBigDecimal("DFACVTOTMN"));
              ventasDetalleVO.setDFACVTOTME(res.getBigDecimal("DFACVTOTME"));
              ventasDetalleVO.setDFACTFLAG(res.getString("DFACTFLAG"));
              ventasDetalleVO.setUSUREG(res.getString("USUREG"));
              ventasDetalleVO.setFECREG(res.getString("FECREG"));
              
              detalleList.add(ventasDetalleVO);
              
           }
           consulta.close();
       }catch(Exception ex){
            conex.desconectar();
            ex.printStackTrace();
        }  
       
       return detalleList;
    }
    public boolean actualizaCabeceraVentas(VentasCabeceraVO ventasCabeceraVO){
        DbConnection conex= new DbConnection(); 
        try{
            PreparedStatement consulta = conex.getConnection().prepareStatement("UPDATE DMTICKET.DMT_VENTAS_CAB SET PROCESADO=? WHERE "
                    + "IDCOMPANIA=? AND TIPODOCUMENTO=? AND SERIE=? AND NUMERO=? AND PVTAID=?");
            consulta.setString(1, "S");
            consulta.setString(2, ventasCabeceraVO.getIDCOMPANIA());
            consulta.setString(3, ventasCabeceraVO.getTIPODOCUMENTO());
            consulta.setString(4, ventasCabeceraVO.getSERIE());
            consulta.setString(5, ventasCabeceraVO.getNUMERO());
            consulta.setString(6, ventasCabeceraVO.getPVTAID());
            consulta.executeUpdate();          
            consulta.close();
            conex.desconectar();            
        }catch(Exception ex){
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
        }        
        return resultado;
    }
    public boolean actualizaCabeceraVentasNC(VentasCabeceraVO ventasCabeceraVO){
        DbConnection conex= new DbConnection(); 
        try{
            PreparedStatement consulta = conex.getConnection().prepareStatement("UPDATE DMTICKET.DMT_VENTAS_CAB SET FLAGNC=? "
                    + "WHERE "
                    + "IDCOMPANIA=? AND TIPODOCUMENTO=? AND SERIE=? AND NUMERO=? AND PVTAID=?");
            consulta.setString(1, "S");
            consulta.setString(2, ventasCabeceraVO.getIDCOMPANIA());
            consulta.setString(3, ventasCabeceraVO.getTIPODOCUMENTO());
            consulta.setString(4, ventasCabeceraVO.getSERIE());
            consulta.setString(5, ventasCabeceraVO.getNUMERO());
            consulta.setString(6, ventasCabeceraVO.getPVTAID());
            consulta.executeUpdate();          
            consulta.close();
            conex.desconectar();            
        }catch(Exception ex){
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
        }        
        return resultado;
    }
    public boolean insertaCabeceraOracleVentas(VentasCabeceraVO ventasCabeceraVO){
       DbOracleConnection conex= new DbOracleConnection(); 
       BigDecimal tasa= BigDecimal.ZERO;
       try{ 
           PreparedStatement consultaP = conex.getConnection().prepareStatement("SELECT ciaid FROM DB2ADMIN.fac305 where ciaid=? and facserie=? and nfac=? and facanomes=?");
           consultaP.setString(1,ventasCabeceraVO.getIDCOMPANIA());
           consultaP.setString(2,ventasCabeceraVO.getSERIE());
           consultaP.setString(3,Util.completarIzquierda(8, ventasCabeceraVO.getNUMERO(), "0"));
           consultaP.setString(4,ventasCabeceraVO.getFACANOMES());
           ResultSet rescon = consultaP.executeQuery();
           if(!rescon.next()){
             consultaP.close();
             rescon.close();
                    PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT tcamvbv FROM DB2ADMIN.tge107 WHERE FECHA=(SELECT MAX(FECHA) FROM DB2ADMIN.tge107 WHERE TCAMVBV IS NOT NULL AND FECHA <= SYSDATE)");
                    ResultSet res = consulta.executeQuery();
                    if(res.next()){
                       tasa= new BigDecimal(res.getString("tcamvbv")) ;
                    }
                    consulta.close();

                    consulta = conex.getConnection().prepareStatement(" Insert into DB2ADMIN.FAC305 " +
                     "    (CIAID, LOCID,TINID,ALMID,TLISTAID,CLIEID,CLAUXID,CLIERUC," +
                     "    FACSERIE,NFAC,FACFECHA,VEID,FPAGOID,TMONID,TIPVTAID," +
                     "    FACMTOMO,FACMTOMN,FACMTOME,FACESTADO,FACDCTOMO,FACDCTOMN,FACDCTOME," +
                     "    FACUSER,FACFREG,FACHREG,FACANOMES,FACTCAM,FACFLAGD," +
                     "    FACIGVMO,FACIGVMN,FACIGVME,FACISCMO,FACISCMN, FACISCME," +
                     "    FACTOTMO,FACTOTMN,FACTOTME,FACTIP," +
                     "    DOCID,TIPPERID, FACDSCTO1, FACIMPREP,FACFEVCMTO,FACTCLI,CLIEDES,CLIEDIR,TIPOADQ," +
                     "    FACIGV2MN,FACIGV2ME,FACIGV2MO,INICIAL,FACSERMO,FACSERMN,FACSERME,PORIGV,PORSER )" +
                     "    VALUES(?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'YYYY/MM/DD'),?,?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'YYYY/MM/DD'),TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
             
                     consulta.setString(1,ventasCabeceraVO.getIDCOMPANIA());
                     consulta.setString(2,ventasCabeceraVO.getIDLOCALIDAD());
                     consulta.setString(3,ventasCabeceraVO.getTINID());
                     consulta.setString(4,ventasCabeceraVO.getALMACEN());
                     consulta.setString(5,ventasCabeceraVO.getLISTAPRECIOS());
                     consulta.setString(6,ventasCabeceraVO.getCODIGOCLIENTE());
                     consulta.setString(7,ventasCabeceraVO.getCLASEAUX());
                     consulta.setString(8,ventasCabeceraVO.getCLIERUC());
                     consulta.setString(9,ventasCabeceraVO.getSERIE());
                     consulta.setString(10,Util.completarIzquierda(8, ventasCabeceraVO.getNUMERO(), "0"));
                     consulta.setString(11,ventasCabeceraVO.getFECHAPROCESO());
                     consulta.setString(12,ventasCabeceraVO.getVEID());
                     consulta.setString(13,ventasCabeceraVO.getFORMAPAGO());
                     consulta.setString(14,ventasCabeceraVO.getTIPOMONEDA());
                     consulta.setString(15,ventasCabeceraVO.getTIPOVENTA());
                     consulta.setBigDecimal(16,ventasCabeceraVO.getFACMTOMO());
                     consulta.setBigDecimal(17,ventasCabeceraVO.getFACMTOMN());

                     BigDecimal me= BigDecimal.ZERO;
                     if(tasa != BigDecimal.ZERO){
                         me = ventasCabeceraVO.getFACMTOMN().divide(tasa, 2, RoundingMode.HALF_UP);                
                     }           
                     consulta.setBigDecimal(18,me);//

                     consulta.setString(19,ventasCabeceraVO.getFACESTADO());
                     consulta.setBigDecimal(20,ventasCabeceraVO.getFACDCTOMO());
                     consulta.setBigDecimal(21,ventasCabeceraVO.getFACDCTOMN());
                     consulta.setBigDecimal(22,ventasCabeceraVO.getFACDCTOME());
                     consulta.setString(23,ventasCabeceraVO.getFACUSER());
                     consulta.setString(24,ventasCabeceraVO.getFACFREG());
                     consulta.setString(25,ventasCabeceraVO.getFACHREG());
                     consulta.setString(26,ventasCabeceraVO.getFACANOMES());

                     if(tasa != BigDecimal.ZERO){
                         consulta.setBigDecimal(27,tasa);                
                     }else{
                         consulta.setBigDecimal(27,ventasCabeceraVO.getFACTCAM());       
                     }                
                     consulta.setString(28,ventasCabeceraVO.getFACFLAGD());
                     consulta.setBigDecimal(29,ventasCabeceraVO.getFACIGVMO());
                     consulta.setBigDecimal(30,ventasCabeceraVO.getFACIGVMN());            

                     me= BigDecimal.ZERO;
                     if(tasa != BigDecimal.ZERO){
                         me = ventasCabeceraVO.getFACIGVMN().divide(tasa, 2, RoundingMode.HALF_UP);                
                     }        
                     consulta.setBigDecimal(31,me);            

                     consulta.setBigDecimal(32,ventasCabeceraVO.getFACISCMO());
                     consulta.setBigDecimal(33,ventasCabeceraVO.getFACISCMN());
                     consulta.setBigDecimal(34,ventasCabeceraVO.getFACISCME());
                     consulta.setBigDecimal(35,ventasCabeceraVO.getFACTOTMO());
                     consulta.setBigDecimal(36,ventasCabeceraVO.getFACTOTMN());

                     me= BigDecimal.ZERO;
                     if(tasa != BigDecimal.ZERO){
                         me = ventasCabeceraVO.getFACTOTMN().divide(tasa, 2, RoundingMode.HALF_UP);                
                     } 
                     consulta.setBigDecimal(37,me);

                     consulta.setString(38,ventasCabeceraVO.getFACTIP());
                     consulta.setString(39,ventasCabeceraVO.getTIPODOCUMENTO());
                     consulta.setString(40,ventasCabeceraVO.getTIPPERID());
                     consulta.setBigDecimal(41,ventasCabeceraVO.getFACDSCTO1());
                     consulta.setString(42,ventasCabeceraVO.getFACIMPREP());
                     consulta.setString(43,ventasCabeceraVO.getFACFEVCMTO());
                     consulta.setString(44,ventasCabeceraVO.getFACTCLI());
                     consulta.setString(45,ventasCabeceraVO.getFACTDES());
                     consulta.setString(46,ventasCabeceraVO.getCLIEDIR());
                     consulta.setString(47,ventasCabeceraVO.getTIPOADQ());
                     consulta.setBigDecimal(48,ventasCabeceraVO.getFACIGV2MN());
                     consulta.setBigDecimal(49,ventasCabeceraVO.getFACIGV2MO());
                     consulta.setBigDecimal(50,ventasCabeceraVO.getFACIGV2ME());
                     consulta.setBigDecimal(51,ventasCabeceraVO.getINICIAL());
                     consulta.setBigDecimal(52,ventasCabeceraVO.getFACSERMO());
                     consulta.setBigDecimal(53,ventasCabeceraVO.getFACSERMN());
                     consulta.setBigDecimal(54,ventasCabeceraVO.getFACSERME());
                     consulta.setBigDecimal(55,ventasCabeceraVO.getPORIGV());
                     consulta.setBigDecimal(56,ventasCabeceraVO.getPORSER());
                     consulta.executeUpdate();
                     consulta.close();
                     conex.desconectar();            
           }
        }catch(Exception ex){
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
        }
        return resultado;
    }
    public boolean actualizaDetalleVentas(VentasDetalleVO ventasDetalleVO){
        DbConnection conex= new DbConnection(); 
        try{
            PreparedStatement consulta = conex.getConnection().prepareStatement("UPDATE DMTICKET.DMT_VENTAS_DET SET PROCESADO=? WHERE "
                    + " IDCOMPANIA=? AND TIPODOCUMENTO=? AND SERIE=? AND NUMERO=? AND NUMREG=?");
            consulta.setString(1, "S");
            consulta.setString(2, ventasDetalleVO.getIDCOMPANIA());
            consulta.setString(3, ventasDetalleVO.getTIPODOCUMENTO());
            consulta.setString(4, ventasDetalleVO.getSERIE());
            consulta.setString(5, ventasDetalleVO.getNUMERO());
            consulta.setBigDecimal(6, ventasDetalleVO.getNUMREG());
            consulta.executeUpdate();          
            consulta.close();
            conex.desconectar();
        }catch(Exception ex){
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
        }
        return resultado;
    }
    public boolean insertaDetalleOracleVentas(VentasCabeceraVO ventasCabeceraVO,VentasDetalleVO ventasDetalleVO){
       DbOracleConnection conex= new DbOracleConnection(); 
       BigDecimal tasa= BigDecimal.ZERO;
       try{ 
           PreparedStatement consultaP = conex.getConnection().prepareStatement("SELECT ciaid FROM DB2ADMIN.fac306 where ciaid=? and facserie=? and nfac=? and dfacanomes=? and dfacitem=?");
           consultaP.setString(1,ventasCabeceraVO.getIDCOMPANIA());
           consultaP.setString(2,ventasCabeceraVO.getSERIE());
           consultaP.setString(3,Util.completarIzquierda(8, ventasCabeceraVO.getNUMERO(), "0"));
           consultaP.setString(4,ventasCabeceraVO.getFACANOMES());
           consultaP.setBigDecimal(5,ventasDetalleVO.getNUMREG());
           ResultSet rescon = consultaP.executeQuery();
           if(!rescon.next()){
              rescon.close();
              consultaP.close();
              PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT tcamvbv FROM DB2ADMIN.tge107 WHERE FECHA=(SELECT MAX(FECHA) FROM DB2ADMIN.tge107 WHERE TCAMVBV IS NOT NULL AND FECHA <= SYSDATE)");
                ResultSet res = consulta.executeQuery();
                if(res.next()){
                   tasa= new BigDecimal(res.getString("tcamvbv")) ;
                }
                consulta.close();

                consulta = conex.getConnection().prepareStatement("Insert into DB2ADMIN.FAC306 " +
                 " (CIAID,LOCID,TINID,ALMID,CLIEID,FACSERIE,NFAC,CLAUXID,CLIERUC,VEID," +
                 " GRARID, " +
                 " FAMID, " +
                 " SFAMID, " +
                 " TLISTAID,ARTID,UNMIDG,UNMABR,DFACCANTG,DFACPREUMO,DFACPREUMN,DFACPREUME, " +
                 " DFACDTOUMO,DFACDTOUMN,DFACDTOUME,DFACMTOMO,DFACMTOMN,DFACMTOME,DFACUSER, " +
                 " DFACFREG,DFACHREG,DFACANOMES,DFACTCAM,TMONID,DFACDCTO,DFACESTADO,FPAGOID,DFACITEM,DOCID, " +
                 " DFACHOR,FACFECHA,FACTIP,FACTCLI,TIPOADQ,DFACIMP1,DFACIMPMTO1,DFACIMP2,DFACIMPMTO2, " +
                 " ARTDES,DFACVTOTMO,DFACVTOTMN,DFACVTOTME, " +
                 " DFACIMPMTN1,DFACIMPMTE1,DFACIMPMTE2,DFACIMPMTN2,DFACTFLAG " +
                 " ) " +                              
                 " VALUES(?,?,?,?,?,?,?,?,?,?," +
                 "(SELECT GRARID FROM DB2ADMIN.TGE205 WHERE CIAID=? AND ARTID=?)," +
                 "(SELECT FAMID FROM DB2ADMIN.TGE205 WHERE CIAID=? AND ARTID=?)," +
                 "(SELECT SFAMID FROM DB2ADMIN.TGE205 WHERE CIAID=? AND ARTID=?)," +
                 "?,?,?,?,?,?,?,?,?,?,?,?," +
                 "?,?,?,TO_DATE(?,'YYYY/MM/DD'),TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,LPAD(?,3,'0'),?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),TO_DATE(?,'YYYY/MM/DD'),?,?,?,?,?,?,?,?,?,?," +
                 "?,?,?,?,?,?)");


                 consulta.setString(1,ventasDetalleVO.getIDCOMPANIA());
                 consulta.setString(2,ventasCabeceraVO.getIDLOCALIDAD());
                 consulta.setString(3,ventasCabeceraVO.getTINID());
                 consulta.setString(4,ventasCabeceraVO.getALMACEN());
                 consulta.setString(5,ventasCabeceraVO.getCODIGOCLIENTE());
                 consulta.setString(6,ventasDetalleVO.getSERIE());
                 consulta.setString(7,ventasDetalleVO.getNUMERO());
                 consulta.setString(8,ventasCabeceraVO.getCLASEAUX());
                 consulta.setString(9,ventasCabeceraVO.getCLIERUC());
                 consulta.setString(10,ventasCabeceraVO.getVEID());
                 consulta.setString(11,ventasDetalleVO.getIDCOMPANIA());
                 consulta.setString(12,ventasDetalleVO.getCODCON());
                 consulta.setString(13,ventasDetalleVO.getIDCOMPANIA());
                 consulta.setString(14,ventasDetalleVO.getCODCON());
                 consulta.setString(15,ventasDetalleVO.getIDCOMPANIA());
                 consulta.setString(16,ventasDetalleVO.getCODCON());
                 consulta.setString(17,ventasCabeceraVO.getLISTAPRECIOS());
                 consulta.setString(18,ventasDetalleVO.getCODCON());
                 consulta.setString(19,ventasDetalleVO.getUNIDADMEDIDA());
                 consulta.setString(20,ventasDetalleVO.getUNIDADMEDIDA());
                 consulta.setBigDecimal(21,ventasDetalleVO.getCANTIDAD());
                 consulta.setBigDecimal(22,ventasDetalleVO.getDFACPREUMO());
                 consulta.setBigDecimal(23,ventasDetalleVO.getDFACPREUMN());

                 BigDecimal me= BigDecimal.ZERO;
                 if(tasa != BigDecimal.ZERO){
                     me = ventasDetalleVO.getDFACPREUMN().divide(tasa, 2, RoundingMode.HALF_UP);                
                 }           
                 consulta.setBigDecimal(24,me);

                 consulta.setBigDecimal(25,BigDecimal.ZERO);
                 consulta.setBigDecimal(26,BigDecimal.ZERO);
                 consulta.setBigDecimal(27,BigDecimal.ZERO);
                 consulta.setBigDecimal(28,ventasDetalleVO.getDFACMTOMO());
                 consulta.setBigDecimal(29,ventasDetalleVO.getDFACMTOMN());

                 me= BigDecimal.ZERO;
                 if(tasa != BigDecimal.ZERO){
                     me = ventasDetalleVO.getDFACMTOMN().divide(tasa, 2, RoundingMode.HALF_UP);                
                 }           
                 consulta.setBigDecimal(30,me);


                 consulta.setString(31,ventasCabeceraVO.getFACUSER());
                 consulta.setString(32,ventasDetalleVO.getFECREG());
                 consulta.setString(33,ventasDetalleVO.getFECHVTA());
                 consulta.setString(34,ventasCabeceraVO.getFACANOMES());

                 consulta.setBigDecimal(35,tasa);    

                 consulta.setString(36,ventasCabeceraVO.getTIPOMONEDA());
                 consulta.setBigDecimal(37,BigDecimal.ZERO);
                 consulta.setString(38,ventasCabeceraVO.getFACESTADO());
                 consulta.setString(39,ventasCabeceraVO.getFORMAPAGO());
                 consulta.setBigDecimal(40,ventasDetalleVO.getNUMREG());
                 consulta.setString(41,ventasDetalleVO.getTIPODOCUMENTO());
                 consulta.setString(42,ventasDetalleVO.getFECHVTA());
                 consulta.setString(43,ventasDetalleVO.getFECREG());
                 consulta.setString(44,ventasCabeceraVO.getFACFLAGD());
                 consulta.setString(45,ventasCabeceraVO.getFACTCLI());
                 consulta.setString(46,ventasCabeceraVO.getTIPOADQ());
                 consulta.setBigDecimal(47,ventasDetalleVO.getDFACIMP1());
                 consulta.setBigDecimal(48,ventasDetalleVO.getDFACIMPMTO1());
                 consulta.setBigDecimal(49,BigDecimal.ZERO);
                 consulta.setBigDecimal(50,BigDecimal.ZERO);
                 consulta.setString(51,ventasDetalleVO.getDESCON());
                 consulta.setBigDecimal(52,ventasDetalleVO.getDFACVTOTMO());
                 consulta.setBigDecimal(53,ventasDetalleVO.getDFACVTOTMN());

                 me= BigDecimal.ZERO;
                 if(tasa != BigDecimal.ZERO){
                     me = ventasDetalleVO.getDFACVTOTMN().divide(tasa, 2, RoundingMode.HALF_UP);                
                 }             
                 consulta.setBigDecimal(54,me);

                 consulta.setBigDecimal(55,ventasDetalleVO.getDFACIMPMTO1());

                 me= BigDecimal.ZERO;
                 if(tasa != BigDecimal.ZERO){
                     me = ventasDetalleVO.getDFACIMPMTO1().divide(tasa, 2, RoundingMode.HALF_UP);                
                 } 
                 consulta.setBigDecimal(56,me);


                 consulta.setBigDecimal(57,BigDecimal.ZERO);
                 consulta.setBigDecimal(58,BigDecimal.ZERO);
                 consulta.setString(59,ventasDetalleVO.getDFACTFLAG());

                 consulta.executeUpdate();  
                 consulta.close();
                 conex.desconectar(); 
           }
          
        }catch(Exception ex){
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
        }
        return resultado;
    }
    public boolean insertaDetalleVentas(VentasDetalleVO ventasDetalleVO){
        DbConnection conex= new DbConnection(); 
       try{ 
            PreparedStatement consulta = conex.getConnection().prepareStatement("INSERT INTO DMTICKET.DMT_VENTAS_DET ( " +
            " IDCOMPANIA,TIPODOCUMENTO,SERIE,NUMERO,NUMREG,CODCON,DESCON,UNIDADMEDIDA,CANTIDAD,"+
            " DFACPREUMO,DFACPREUMN,DFACPREUME,DFACMTOMO,DFACMTOMN,DFACMTOME,FECHVTA,DFACIMP1,"+
            " DFACIMPMTO1,DFACVTOTMO,DFACVTOTMN,DFACVTOTME,DFACTFLAG,USUREG,FECREG,DFACDCTOMO,DFACDCTOMN,DFACDCTOME,DFACPREVMO,DFACPREVMN,DFACPREVME,APLIMPTO) " +
            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            consulta.setString(1,ventasDetalleVO.getIDCOMPANIA());
            consulta.setString(2,ventasDetalleVO.getTIPODOCUMENTO());
            consulta.setString(3,ventasDetalleVO.getSERIE());
            consulta.setString(4,ventasDetalleVO.getNUMERO());
            consulta.setBigDecimal(5,ventasDetalleVO.getNUMREG());
            consulta.setString(6,ventasDetalleVO.getCODCON());
            consulta.setString(7,ventasDetalleVO.getDESCON());
            consulta.setString(8,ventasDetalleVO.getUNIDADMEDIDA());
            consulta.setBigDecimal(9,ventasDetalleVO.getCANTIDAD());
            consulta.setBigDecimal(10,ventasDetalleVO.getDFACPREUMO());
            consulta.setBigDecimal(11,ventasDetalleVO.getDFACPREUMN());
            consulta.setBigDecimal(12,ventasDetalleVO.getDFACPREUME());
            consulta.setBigDecimal(13,ventasDetalleVO.getDFACMTOMO());
            consulta.setBigDecimal(14,ventasDetalleVO.getDFACMTOMN());
            consulta.setBigDecimal(15,ventasDetalleVO.getDFACMTOME());
            consulta.setString(16,ventasDetalleVO.getFECHVTA());
            consulta.setBigDecimal(17,ventasDetalleVO.getDFACIMP1());
            consulta.setBigDecimal(18,ventasDetalleVO.getDFACIMPMTO1());
            consulta.setBigDecimal(19,ventasDetalleVO.getDFACVTOTMO());
            consulta.setBigDecimal(20,ventasDetalleVO.getDFACVTOTMN());
            consulta.setBigDecimal(21,ventasDetalleVO.getDFACVTOTME());
            consulta.setString(22,ventasDetalleVO.getDFACTFLAG());
            consulta.setString(23,ventasDetalleVO.getUSUREG());
            consulta.setString(24,ventasDetalleVO.getFECREG());
            
            consulta.setBigDecimal(25,ventasDetalleVO.getDFACDCTOMO());
            consulta.setBigDecimal(26,ventasDetalleVO.getDFACDCTOMN());
            consulta.setBigDecimal(27,ventasDetalleVO.getDFACDCTOME());
            consulta.setBigDecimal(28,ventasDetalleVO.getDFACPREVMO());
            consulta.setBigDecimal(29,ventasDetalleVO.getDFACPREVMN());
            consulta.setBigDecimal(30,ventasDetalleVO.getDFACPREVME());
            consulta.setString(31,ventasDetalleVO.getAPLIMPTO());
            
            consulta.executeUpdate();  
            consulta.close();
            conex.desconectar();
        }catch(Exception ex){
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
        }
        return resultado;
    }
    public boolean aumentaSerieNumero(String tipodocumento , int numeroActual, String ciaid, String tdaid, String pvtaid ){
        DbConnection conex= new DbConnection();
        int numeroAumentado = numeroActual+1;
        try{
            PreparedStatement consulta = conex.getConnection().prepareStatement("UPDATE DMTICKET.DMT_SERIES_MAE SET NUMERO = ? WHERE "
                    + "TIPODOCUMENTO = ? AND CIAID=? AND TDAID=? AND PVTAID=?");
            consulta.setInt(1,numeroAumentado);
            consulta.setString(2,tipodocumento);
            consulta.setString(3,ciaid);
            consulta.setString(4,tdaid);
            consulta.setString(5,pvtaid);
            consulta.executeUpdate();          
            consulta.close();
            conex.desconectar();
        }catch(Exception ex){
            resultado = false;
            conex.desconectar();
            ex.printStackTrace();
        }
        return resultado;
    }
}

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
public class VentasCabeceraVO {
    private String IDCOMPANIA;
    private String IDLOCALIDAD;
    private String TINID;
    private String ALMACEN;
    private String LISTAPRECIOS;
    private String CODIGOCLIENTE;
    private String CLASEAUX;
    private String CLIERUC;
    private String SERIE;
    private String NUMERO;
    private String FECHAPROCESO;
    private String VEID;
    private String FORMAPAGO;
    private String TIPOMONEDA;
    private String TIPOVENTA;
    private BigDecimal FACMTOMO;
    private BigDecimal FACMTOMN;
    private BigDecimal FACMTOME;
    private String FACESTADO;
    private BigDecimal FACDCTOMO;
    private BigDecimal FACDCTOMN;
    private BigDecimal FACDCTOME;
    private String FACUSER;//usuario registro
    private String FACFREG;//fecha registro
    private String FACHREG;//fecha y hora registro
    private String FACANOMES;
    private BigDecimal FACTCAM;
    private String FACFLAGD;
    private BigDecimal FACIGVMO;
    private BigDecimal FACIGVMN;
    private BigDecimal FACIGVME;
    private BigDecimal FACISCMO;
    private BigDecimal FACISCMN;
    private BigDecimal FACISCME;
    private BigDecimal FACTOTMO;
    private BigDecimal FACTOTMN;
    private BigDecimal FACTOTME;
    private String FACTIP;
    private String TIPODOCUMENTO;
    private String TIPPERID;
    private BigDecimal FACDSCTO1;
    private String FACIMPREP;
    private String FACFEVCMTO;
    private String FACTCLI;
    private String FACTDES;
    private String CLIEDIR;
    private String TIPOADQ;
    private BigDecimal FACIGV2MN;
    private BigDecimal FACIGV2ME;
    private BigDecimal FACIGV2MO;
    private BigDecimal INICIAL;
    private BigDecimal FACSERMO;
    private BigDecimal FACSERMN;
    private BigDecimal FACSERME;
    private BigDecimal PORIGV;
    private BigDecimal PORSER;
    private String USUMOD;//usuario modifico
    private String FECMOD;//fecha modifico
    //modificacion Crisol
    private String PVTAID;
    private String TURNO;
    private BigDecimal FACMTOGRAV;
    private BigDecimal FACMTOEXO;
    private BigDecimal FACMTOINA;
    private BigDecimal FACMTOGRAT;
    private String TIPOPERACION;


    public String getIDCOMPANIA() {
        return IDCOMPANIA;
    }

    public void setIDCOMPANIA(String IDCOMPANIA) {
        this.IDCOMPANIA = IDCOMPANIA;
    }

    public String getIDLOCALIDAD() {
        return IDLOCALIDAD;
    }

    public void setIDLOCALIDAD(String IDLOCALIDAD) {
        this.IDLOCALIDAD = IDLOCALIDAD;
    }

    public String getTINID() {
        return TINID;
    }

    public void setTINID(String TINID) {
        this.TINID = TINID;
    }

    public String getALMACEN() {
        return ALMACEN;
    }

    public void setALMACEN(String ALMACEN) {
        this.ALMACEN = ALMACEN;
    }

    public String getLISTAPRECIOS() {
        return LISTAPRECIOS;
    }

    public void setLISTAPRECIOS(String LISTAPRECIOS) {
        this.LISTAPRECIOS = LISTAPRECIOS;
    }

    public String getCODIGOCLIENTE() {
        return CODIGOCLIENTE;
    }

    public void setCODIGOCLIENTE(String CODIGOCLIENTE) {
        this.CODIGOCLIENTE = CODIGOCLIENTE;
    }

    public String getCLASEAUX() {
        return CLASEAUX;
    }

    public void setCLASEAUX(String CLASEAUX) {
        this.CLASEAUX = CLASEAUX;
    }

    public String getCLIERUC() {
        return CLIERUC;
    }

    public void setCLIERUC(String CLIERUC) {
        this.CLIERUC = CLIERUC;
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

    public String getFECHAPROCESO() {
        return FECHAPROCESO;
    }

    public void setFECHAPROCESO(String FECHAPROCESO) {
        this.FECHAPROCESO = FECHAPROCESO;
    }

    public String getVEID() {
        return VEID;
    }

    public void setVEID(String VEID) {
        this.VEID = VEID;
    }

    public String getFORMAPAGO() {
        return FORMAPAGO;
    }

    public void setFORMAPAGO(String FORMAPAGO) {
        this.FORMAPAGO = FORMAPAGO;
    }

    public String getTIPOMONEDA() {
        return TIPOMONEDA;
    }

    public void setTIPOMONEDA(String TIPOMONEDA) {
        this.TIPOMONEDA = TIPOMONEDA;
    }

    public String getTIPOVENTA() {
        return TIPOVENTA;
    }

    public void setTIPOVENTA(String TIPOVENTA) {
        this.TIPOVENTA = TIPOVENTA;
    }

    public BigDecimal getFACMTOMO() {
        return FACMTOMO;
    }

    public void setFACMTOMO(BigDecimal FACMTOMO) {
        this.FACMTOMO = FACMTOMO;
    }

    public BigDecimal getFACMTOMN() {
        return FACMTOMN;
    }

    public void setFACMTOMN(BigDecimal FACMTOMN) {
        this.FACMTOMN = FACMTOMN;
    }

    public BigDecimal getFACMTOME() {
        return FACMTOME;
    }

    public void setFACMTOME(BigDecimal FACMTOME) {
        this.FACMTOME = FACMTOME;
    }

    public String getFACESTADO() {
        return FACESTADO;
    }

    public void setFACESTADO(String FACESTADO) {
        this.FACESTADO = FACESTADO;
    }

    public BigDecimal getFACDCTOMO() {
        return FACDCTOMO;
    }

    public void setFACDCTOMO(BigDecimal FACDCTOMO) {
        this.FACDCTOMO = FACDCTOMO;
    }

    public BigDecimal getFACDCTOMN() {
        return FACDCTOMN;
    }

    public void setFACDCTOMN(BigDecimal FACDCTOMN) {
        this.FACDCTOMN = FACDCTOMN;
    }

    public BigDecimal getFACDCTOME() {
        return FACDCTOME;
    }

    public void setFACDCTOME(BigDecimal FACDCTOME) {
        this.FACDCTOME = FACDCTOME;
    }

    public String getFACUSER() {
        return FACUSER;
    }

    public void setFACUSER(String FACUSER) {
        this.FACUSER = FACUSER;
    }

    public String getFACFREG() {
        return FACFREG;
    }

    public void setFACFREG(String FACFREG) {
        this.FACFREG = FACFREG;
    }

    public String getFACHREG() {
        return FACHREG;
    }

    public void setFACHREG(String FACHREG) {
        this.FACHREG = FACHREG;
    }

    public String getFACANOMES() {
        return FACANOMES;
    }

    public void setFACANOMES(String FACANOMES) {
        this.FACANOMES = FACANOMES;
    }

    public BigDecimal getFACTCAM() {
        return FACTCAM;
    }

    public void setFACTCAM(BigDecimal FACTCAM) {
        this.FACTCAM = FACTCAM;
    }

    public String getFACFLAGD() {
        return FACFLAGD;
    }

    public void setFACFLAGD(String FACFLAGD) {
        this.FACFLAGD = FACFLAGD;
    }

    public BigDecimal getFACIGVMO() {
        return FACIGVMO;
    }

    public void setFACIGVMO(BigDecimal FACIGVMO) {
        this.FACIGVMO = FACIGVMO;
    }

    public BigDecimal getFACIGVMN() {
        return FACIGVMN;
    }

    public void setFACIGVMN(BigDecimal FACIGVMN) {
        this.FACIGVMN = FACIGVMN;
    }

    public BigDecimal getFACIGVME() {
        return FACIGVME;
    }

    public void setFACIGVME(BigDecimal FACIGVME) {
        this.FACIGVME = FACIGVME;
    }

    public BigDecimal getFACISCMO() {
        return FACISCMO;
    }

    public void setFACISCMO(BigDecimal FACISCMO) {
        this.FACISCMO = FACISCMO;
    }

    public BigDecimal getFACISCMN() {
        return FACISCMN;
    }

    public void setFACISCMN(BigDecimal FACISCMN) {
        this.FACISCMN = FACISCMN;
    }

    public BigDecimal getFACISCME() {
        return FACISCME;
    }

    public void setFACISCME(BigDecimal FACISCME) {
        this.FACISCME = FACISCME;
    }

    public BigDecimal getFACTOTMO() {
        return FACTOTMO;
    }

    public void setFACTOTMO(BigDecimal FACTOTMO) {
        this.FACTOTMO = FACTOTMO;
    }

    public BigDecimal getFACTOTMN() {
        return FACTOTMN;
    }

    public void setFACTOTMN(BigDecimal FACTOTMN) {
        this.FACTOTMN = FACTOTMN;
    }

    public BigDecimal getFACTOTME() {
        return FACTOTME;
    }

    public void setFACTOTME(BigDecimal FACTOTME) {
        this.FACTOTME = FACTOTME;
    }

    public String getFACTIP() {
        return FACTIP;
    }

    public void setFACTIP(String FACTIP) {
        this.FACTIP = FACTIP;
    }

    public String getTIPODOCUMENTO() {
        return TIPODOCUMENTO;
    }

    public void setTIPODOCUMENTO(String TIPODOCUMENTO) {
        this.TIPODOCUMENTO = TIPODOCUMENTO;
    }

    public String getTIPPERID() {
        return TIPPERID;
    }

    public void setTIPPERID(String TIPPERID) {
        this.TIPPERID = TIPPERID;
    }

    public BigDecimal getFACDSCTO1() {
        return FACDSCTO1;
    }

    public void setFACDSCTO1(BigDecimal FACDSCTO1) {
        this.FACDSCTO1 = FACDSCTO1;
    }

    public String getFACIMPREP() {
        return FACIMPREP;
    }

    public void setFACIMPREP(String FACIMPREP) {
        this.FACIMPREP = FACIMPREP;
    }

    public String getFACFEVCMTO() {
        return FACFEVCMTO;
    }

    public void setFACFEVCMTO(String FACFEVCMTO) {
        this.FACFEVCMTO = FACFEVCMTO;
    }

    public String getFACTCLI() {
        return FACTCLI;
    }

    public void setFACTCLI(String FACTCLI) {
        this.FACTCLI = FACTCLI;
    }

    public String getFACTDES() {
        return FACTDES;
    }

    public void setFACTDES(String FACTDES) {
        this.FACTDES = FACTDES;
    }

    public String getCLIEDIR() {
        return CLIEDIR;
    }

    public void setCLIEDIR(String CLIEDIR) {
        this.CLIEDIR = CLIEDIR;
    }

    public String getTIPOADQ() {
        return TIPOADQ;
    }

    public void setTIPOADQ(String TIPOADQ) {
        this.TIPOADQ = TIPOADQ;
    }

    public BigDecimal getFACIGV2MN() {
        return FACIGV2MN;
    }

    public void setFACIGV2MN(BigDecimal FACIGV2MN) {
        this.FACIGV2MN = FACIGV2MN;
    }

    public BigDecimal getFACIGV2ME() {
        return FACIGV2ME;
    }

    public void setFACIGV2ME(BigDecimal FACIGV2ME) {
        this.FACIGV2ME = FACIGV2ME;
    }

    public BigDecimal getFACIGV2MO() {
        return FACIGV2MO;
    }

    public void setFACIGV2MO(BigDecimal FACIGV2MO) {
        this.FACIGV2MO = FACIGV2MO;
    }

    public BigDecimal getINICIAL() {
        return INICIAL;
    }

    public void setINICIAL(BigDecimal INICIAL) {
        this.INICIAL = INICIAL;
    }

    public BigDecimal getFACSERMO() {
        return FACSERMO;
    }

    public void setFACSERMO(BigDecimal FACSERMO) {
        this.FACSERMO = FACSERMO;
    }

    public BigDecimal getFACSERMN() {
        return FACSERMN;
    }

    public void setFACSERMN(BigDecimal FACSERMN) {
        this.FACSERMN = FACSERMN;
    }

    public BigDecimal getFACSERME() {
        return FACSERME;
    }

    public void setFACSERME(BigDecimal FACSERME) {
        this.FACSERME = FACSERME;
    }

    public BigDecimal getPORIGV() {
        return PORIGV;
    }

    public void setPORIGV(BigDecimal PORIGV) {
        this.PORIGV = PORIGV;
    }

    public BigDecimal getPORSER() {
        return PORSER;
    }

    public void setPORSER(BigDecimal PORSER) {
        this.PORSER = PORSER;
    }

    public String getUSUMOD() {
        return USUMOD;
    }

    public void setUSUMOD(String USUMOD) {
        this.USUMOD = USUMOD;
    }

    public String getFECMOD() {
        return FECMOD;
    }

    public void setFECMOD(String FECMOD) {
        this.FECMOD = FECMOD;
    }

    public String getPVTAID() {
        return PVTAID;
    }

    public void setPVTAID(String PVTAID) {
        this.PVTAID = PVTAID;
    }

    public String getTURNO() {
        return TURNO;
    }

    public void setTURNO(String TURNO) {
        this.TURNO = TURNO;
    }

    public BigDecimal getFACMTOGRAV() {
        return FACMTOGRAV;
    }

    public void setFACMTOGRAV(BigDecimal FACMTOGRAV) {
        this.FACMTOGRAV = FACMTOGRAV;
    }

    public BigDecimal getFACMTOEXO() {
        return FACMTOEXO;
    }

    public void setFACMTOEXO(BigDecimal FACMTOEXO) {
        this.FACMTOEXO = FACMTOEXO;
    }

    public BigDecimal getFACMTOINA() {
        return FACMTOINA;
    }

    public void setFACMTOINA(BigDecimal FACMTOINA) {
        this.FACMTOINA = FACMTOINA;
    }

    public BigDecimal getFACMTOGRAT() {
        return FACMTOGRAT;
    }

    public void setFACMTOGRAT(BigDecimal FACMTOGRAT) {
        this.FACMTOGRAT = FACMTOGRAT;
    }

    public String getTIPOPERACION() {
        return TIPOPERACION;
    }

    public void setTIPOPERACION(String TIPOPERACION) {
        this.TIPOPERACION = TIPOPERACION;
    }

    @Override
    public String toString() {
        return "VentasCabeceraVO{" + "IDCOMPANIA=" + IDCOMPANIA + ", IDLOCALIDAD=" + IDLOCALIDAD + ", TINID=" + TINID + ", ALMACEN=" + ALMACEN + ", LISTAPRECIOS=" + LISTAPRECIOS + ", CODIGOCLIENTE=" + CODIGOCLIENTE + ", CLASEAUX=" + CLASEAUX + ", CLIERUC=" + CLIERUC + ", SERIE=" + SERIE + ", NUMERO=" + NUMERO + ", FECHAPROCESO=" + FECHAPROCESO + ", VEID=" + VEID + ", FORMAPAGO=" + FORMAPAGO + ", TIPOMONEDA=" + TIPOMONEDA + ", TIPOVENTA=" + TIPOVENTA + ", FACMTOMO=" + FACMTOMO + ", FACMTOMN=" + FACMTOMN + ", FACMTOME=" + FACMTOME + ", FACESTADO=" + FACESTADO + ", FACDCTOMO=" + FACDCTOMO + ", FACDCTOMN=" + FACDCTOMN + ", FACDCTOME=" + FACDCTOME + ", FACUSER=" + FACUSER + ", FACFREG=" + FACFREG + ", FACHREG=" + FACHREG + ", FACANOMES=" + FACANOMES + ", FACTCAM=" + FACTCAM + ", FACFLAGD=" + FACFLAGD + ", FACIGVMO=" + FACIGVMO + ", FACIGVMN=" + FACIGVMN + ", FACIGVME=" + FACIGVME + ", FACISCMO=" + FACISCMO + ", FACISCMN=" + FACISCMN + ", FACISCME=" + FACISCME + ", FACTOTMO=" + FACTOTMO + ", FACTOTMN=" + FACTOTMN + ", FACTOTME=" + FACTOTME + ", FACTIP=" + FACTIP + ", TIPODOCUMENTO=" + TIPODOCUMENTO + ", TIPPERID=" + TIPPERID + ", FACDSCTO1=" + FACDSCTO1 + ", FACIMPREP=" + FACIMPREP + ", FACFEVCMTO=" + FACFEVCMTO + ", FACTCLI=" + FACTCLI + ", FACTDES=" + FACTDES + ", CLIEDIR=" + CLIEDIR + ", TIPOADQ=" + TIPOADQ + ", FACIGV2MN=" + FACIGV2MN + ", FACIGV2ME=" + FACIGV2ME + ", FACIGV2MO=" + FACIGV2MO + ", INICIAL=" + INICIAL + ", FACSERMO=" + FACSERMO + ", FACSERMN=" + FACSERMN + ", FACSERME=" + FACSERME + ", PORIGV=" + PORIGV + ", PORSER=" + PORSER + ", USUMOD=" + USUMOD + ", FECMOD=" + FECMOD + ", PVTAID=" + PVTAID + ", TURNO=" + TURNO + ", FACMTOGRAV=" + FACMTOGRAV + ", FACMTOEXO=" + FACMTOEXO + ", FACMTOINA=" + FACMTOINA + ", FACMTOGRAT=" + FACMTOGRAT + ", TIPOPERACION=" + TIPOPERACION + '}';
    }  
}

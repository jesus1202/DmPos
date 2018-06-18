package com.dematicket.form;

import com.dematicket.bean.ClienteVO;
import com.dematicket.bean.CompaniaVO;
import com.dematicket.bean.FormaPagoVO;
import com.dematicket.bean.MaestroVentasVO;
import com.dematicket.bean.MensajesVO;
import com.dematicket.bean.UsuarioVO;
import com.dematicket.data.ClienteData;
import com.dematicket.data.CompaniaData;
import com.dematicket.data.FormaPagoData;
import com.dematicket.data.MaestroVentasData;
import com.dematicket.data.MensajesData;
import com.dematicket.data.SesionData;
import com.dematicket.data.UsuarioData;
import com.dematicket.util.DbConnection;
import com.dematicket.util.JHyperlinkLabel;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import org.com.dm.util.Constants;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author lmonge
 */
public class FormLogin extends JFrame{

    private JLabel labelUsername = new JLabel("Enter username: ");
    private JLabel labelPassword = new JLabel("Enter password: ");
    private JTextField textUsername = new JTextField(20);
    private JPasswordField fieldPassword = new JPasswordField(20);
    private JButton btnRegister = new JButton("Registrar");
    private JButton btnLogin = new JButton("Login");
    //inicio jcastillo
    private JLabel labelwhitespace = new JLabel("        ");
    private JLabel labelwhitespace1 = new JLabel(" ");
    private JHyperlinkLabel labelCambiarPass = new JHyperlinkLabel("Cambiar Contraseña");    
    private FormUserRegister formUserRegister;
    //fin jcastillo
    private JButton btnOffline = new JButton("Offline");

    public FormLogin() {
        super("JPanel Demo Program");
        //String path = new File ("").getAbsolutePath();
        //path = path+"\\img\\";
        this.setTitle("DmPos");
        //this.setIconImage(new ImageIcon(path+"logowindow.png").getImage());
        
        JPanel newPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;		
        newPanel.add(labelUsername, constraints);
        constraints.gridx = 1;
        newPanel.add(textUsername, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;		
        newPanel.add(labelPassword, constraints);
        constraints.gridx = 1;
        newPanel.add(fieldPassword, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        
        JPanel pnlBotonera = new JPanel(new FlowLayout());
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        pnlBotonera.add(btnRegister);
        pnlBotonera.add(labelwhitespace);
        pnlBotonera.add(btnLogin);
        //inicio jcastillo
        pnlBotonera.add(labelwhitespace1);
        pnlBotonera.add(labelCambiarPass);        
        //fin jcastillo
        btnOffline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfflineActionPerformed(evt);
            }
        });
        //pnlBotonera.add(btnOffline);
        newPanel.add(pnlBotonera, constraints);        
        newPanel.setBorder(BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(), "Login Panel"));
        add(newPanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    }    
    
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        if(formUserRegister==null){
            formUserRegister = new FormUserRegister();
            formUserRegister.setLocationRelativeTo(null);
            formUserRegister.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            formUserRegister.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            formUserRegister.setVisible(true);
        }else{
            formUserRegister.setVisible(true);
        }
    }
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        RestTemplate restTemplate = new RestTemplate();
        LinkedHashMap<String, Object> parametrosAll = new LinkedHashMap<String, Object>();
        //parametrosAll.put("2", "LMONGE");
        //parametrosAll.put("3", "monitor123");
        parametrosAll.put("2", textUsername.getText());
        parametrosAll.put("3", fieldPassword.getText());
        parametrosAll.put("4", "0");
        parametrosAll.put(Constants.IDENTIFICADORES.ID_ESQUEMA, "SEGURIDAD");
        parametrosAll.put(Constants.IDENTIFICADORES.ID_COMPONENTE, "SAVELOGIN");
        try {
            
            //System.out.println(SesionData.getSesion().getIpserver() + Constants.REST_SERVICE_COMPONENT);
            /*List<LinkedHashMap<String, Object>> list = 
                    new Lanzador(restTemplate).sendReturnData(SesionData.getSesion().getIpserver() + Constants.REST_SERVICE_COMPONENT, parametrosAll, null);
            if(list==null){
                JOptionPane.showMessageDialog(null, "USUARIO/PASSWORD INCORRECTO");
                return;
            }else{
                UsuarioData.getUsuario().setUsuario(list.get(0).get("ID_USUARIO").toString());
                UsuarioData.getUsuario().setNombre(list.get(0).get("NOMBRE_COMPLETO").toString());
                UsuarioData.getUsuario().setMail(list.get(0).get("MAIL").toString());
                File file = Util.validaArchivoTicket(TipoArchivo.DAT.getTipo());
                Util.writeUserdata(file);
                callForm();
            }*/
            UsuarioVO usuarioVO;
            usuarioVO =UsuarioData.getUsuarioBD(textUsername.getText(), fieldPassword.getText()); 
            if( usuarioVO!= null){
                if(validaConArchivoIni(usuarioVO)){
                    UsuarioData.getUsuario().setUsuario(usuarioVO.getUsuario());
                    UsuarioData.getUsuario().setNombre(usuarioVO.getNombre());
                    UsuarioData.getUsuario().setMail(usuarioVO.getEmail());
                    UsuarioData.getUsuario().setEmpresa(usuarioVO.getEmpresa());
                    UsuarioData.getUsuario().setPerfil(usuarioVO.getPerfil());
                    UsuarioData.getUsuario().setTienda(usuarioVO.getTienda());
                    loadData();

                    /*File file = Util.validaArchivoTicket(TipoArchivo.DAT.getTipo());
                    Util.writeUserdata(file);*/
                    callForm(); 
                }else{
                    JOptionPane.showMessageDialog(null, "EL USUARIO NO ESTA ASIGNADO A ESTE LOCAL");
                    return; 
                }               
                
            }else{
               JOptionPane.showMessageDialog(null, "USUARIO/PASSWORD INCORRECTO");
               return; 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXIÓN");
            e.printStackTrace();
        }
    }
    private boolean validaConArchivoIni(UsuarioVO usuarioVO){
        String ciaid="",tienda="",ptoVenta="";
        String[] splitLine=null;
        boolean accesoCorrecto=false;
        try{
                BufferedReader br = new BufferedReader(new FileReader("C:\\DmPos\\DmPos.ini"));
                String line = br.readLine();
                while (line != null) {
                    if(line!=null && line.trim().compareTo("")!=0){
                        if(line.startsWith("CIA")){
                           splitLine=line.split("=");
                           ciaid=splitLine[1];
                        }
                        if(line.startsWith("TDA")){
                           splitLine=line.split("=");
                           tienda=splitLine[1];
                        }
                        if(line.startsWith("PVTA")){
                           splitLine=line.split("=");
                           ptoVenta=splitLine[1];
                        }
                    }
                    line = br.readLine();
                }
                if(ciaid.equals(usuarioVO.getEmpresa()) && tienda.equals(usuarioVO.getTienda())){
                    UsuarioData.getUsuario().setPtoVenta(ptoVenta);
                    accesoCorrecto=true;
                }
               
            }catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "NO SE PUEDE LEER ACHIVO DE CONFIGURACION DMPOS.INI");
            }
         return accesoCorrecto;
    }
    private void btnOfflineActionPerformed(java.awt.event.ActionEvent evt) {
        loadData();
        callForm();        
    }
    
    private void loadData(){
        try{
            DbConnection con = new DbConnection();
            String path = new File ("").getAbsolutePath();
            path = path+"\\img\\";
            if(UsuarioData.getUsuario().getEmpresa().equals("1")){
               this.setIconImage(new ImageIcon(path+"logowindow.png").getImage()); 
            }
            if(UsuarioData.getUsuario().getEmpresa().equals("2")){
               this.setIconImage(new ImageIcon(path+"logowindowCrisol.png").getImage()); 
            }
            MaestroVentasVO maestroVentasVO;
            maestroVentasVO =MaestroVentasData.getMaeVentasBD();
            
            CompaniaVO companiaVO;
            companiaVO = CompaniaData.getCompaniaBD();
            
            ClienteVO clienteVO;
            clienteVO = ClienteData.getClienteBD();
            
            FormaPagoVO formaPagoVO;
            formaPagoVO = FormaPagoData.getFormaPagoBD();
            
            MensajesVO mensajesVO;
            mensajesVO = MensajesData.getMensajesBD();
            
            SesionData.getSesion().setIdcompania(companiaVO.getIDCOMPANIA());
            SesionData.getSesion().setCompania(companiaVO.getCOMPANIA());
            SesionData.getSesion().setDireccionCompania(companiaVO.getDIRECCIONCOMPANIA());
            SesionData.getSesion().setIdlocalidad(maestroVentasVO.getIDLOCALIDAD());  
            SesionData.getSesion().setAlmacen(maestroVentasVO.getALMACEN()); 
            SesionData.getSesion().setTienda(maestroVentasVO.getID_TDA()); 
            SesionData.getSesion().setPtoventa(maestroVentasVO.getPVTA_ID());
            SesionData.getSesion().setListaPrecios(maestroVentasVO.getLISTAPRECIOS());
            SesionData.getSesion().setCodigoCliente(clienteVO.getCODIGOCLIENTE());  
            SesionData.getSesion().setClaseAux(maestroVentasVO.getCLASEAUX());
            SesionData.getSesion().setFormaPago(formaPagoVO.getFORMAPAGO());
            SesionData.getSesion().setTipoMoneda(maestroVentasVO.getTIPOMONEDA());
            SesionData.getSesion().setTipoVenta(maestroVentasVO.getTIPOVENTA());
            SesionData.getSesion().setUnidadMedida(maestroVentasVO.getUNIDADMEDIDA());
            
            
            //SesionData.getSesion().setTurno(Integer.parseInt(maestroVentasVO.getTURNO()));
            SesionData.getSesion().setTurno(maestroVentasVO.getTURNO());
            SesionData.getSesion().setImpresiones(Integer.parseInt(maestroVentasVO.getIMPRESIONES()));
            SesionData.getSesion().setIgvPorcentaje(new BigDecimal(maestroVentasVO.getIGVPORCENTAJE()));
            SesionData.getSesion().setTipoCliente(maestroVentasVO.getTIPOCLIENTE());
//SesionData.getSesion().setCopyFilePath(dato);
            SesionData.getSesion().setFechaProceso(maestroVentasVO.getFECHAPROCESO().toString());
            SesionData.getSesion().setImpresora(maestroVentasVO.getIMPRESORA());
            SesionData.getSesion().setrutaFELocal(maestroVentasVO.getRUTAFE());
            SesionData.getSesion().setRucDerrama(companiaVO.getRUCDERRAMA());
            SesionData.getSesion().setNombDerrama(companiaVO.getNOMBDERRAMA());
            SesionData.getSesion().setDirecDerrama(companiaVO.getDIRECDERRAMA());
            SesionData.getSesion().setUbgDerrama(companiaVO.getUBGDERRAMA());
            SesionData.getSesion().setPrvDerrama(companiaVO.getPRVDERRAMA());
            SesionData.getSesion().setDepDerrama(companiaVO.getDEPDERRAMA());
            SesionData.getSesion().setDstDerrama(companiaVO.getDSTDERRAMA());
            SesionData.getSesion().setPais(companiaVO.getPAIS());
            SesionData.getSesion().setPrintDestino(maestroVentasVO.getPRINTDEST());
            SesionData.getSesion().setCodImpuesto(String.valueOf(new BigDecimal(maestroVentasVO.getCODIMPUESTO())));
            SesionData.getSesion().setMensajes(mensajesVO.getMensajes());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void callForm(){
        FormTicket formTicket = new FormTicket();
        formTicket.setLocationRelativeTo(null);
        formTicket.setVisible(true);
        this.setVisible(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // set look and feel to the system look and feel
        try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
                ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

}

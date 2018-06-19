package com.dematicket.form;

import com.dematicket.bean.ConceptoCobro;
import com.dematicket.bean.MonedaVO;
import com.dematicket.data.ConceptosDAO;
import com.dematicket.data.MonedasDAO;
import static com.dematicket.form.FormTicket.jcbTipoConcepto;
import com.dematicket.util.Util;
import java.awt.Dialog;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author lmonge
 */
public class FormProductMaintainer extends javax.swing.JFrame {
    String cabecera = "";
    public static boolean flag;
    ArrayList<String> detalle = new ArrayList();
    String codigoProducto="";
    private MonedaVO monedaVO;
    private FormSupervisorValidator formSupervisorValidator;
    /**
     * Creates new form FormTicket
     */
    public FormProductMaintainer() {
        initComponents();
        loadComponentes();        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodArt = new javax.swing.JTextField();
        btnOKPassChange = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtArticuloDesc = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        jcheckIGV = new javax.swing.JCheckBox();
        txtPrecio = new javax.swing.JTextField();
        txtPrecioSinIGV = new javax.swing.JTextField();
        txtUMedida = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcbTipoMoneda = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jcheckExo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Código Articulo:");

        jLabel2.setText("Articulo:");

        jLabel3.setText("Precio :");

        txtCodArt.setEnabled(false);
        txtCodArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodArtActionPerformed(evt);
            }
        });

        btnOKPassChange.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnOKPassChange.setText("Grabar");
        btnOKPassChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKPassChangeActionPerformed(evt);
            }
        });

        jLabel5.setText("Precio Sin IGV:");

        jLabel6.setText("Aplica IGV:");

        jLabel9.setText("Und. Medida:");

        jLabel18.setText("Estado:");

        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A-Activo", "I-Inactivo" }));
        jcbEstado.setEnabled(false);

        jcheckIGV.setEnabled(false);

        txtUMedida.setEnabled(false);

        jLabel4.setText("Tipo Moneda:");

        jcbTipoMoneda.setEnabled(false);

        jLabel7.setText("Exonerado:");

        jcheckExo.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOKPassChange)
                        .addGap(224, 224, 224))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jcheckIGV)
                                                .addGap(144, 144, 144)
                                                .addComponent(jLabel7)
                                                .addGap(34, 34, 34)
                                                .addComponent(jcheckExo))
                                            .addComponent(txtArticuloDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jcbTipoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecioSinIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodArt, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtArticuloDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcheckExo)
                                .addGap(139, 139, 139))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcheckIGV)
                                    .addComponent(jLabel6))
                                .addGap(143, 143, 143))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jcbTipoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPrecioSinIGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtUMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnOKPassChange)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKPassChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKPassChangeActionPerformed
        // TODO add your handling code here:
        flag=false;
        if(formSupervisorValidator==null){
            formSupervisorValidator = new FormSupervisorValidator();
            formSupervisorValidator.setLocationRelativeTo(null);
            formSupervisorValidator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            formSupervisorValidator.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            //formUserMaintainer.setSize(710, 135);
            formSupervisorValidator.setVisible(true);
        }else{
            formSupervisorValidator.setVisible(true);
        }
        
    }//GEN-LAST:event_btnOKPassChangeActionPerformed

    public static void actualizarArticulo(){//el ultimo campo no debe ser vacio (es el indicador si es exonerado o no)
            String flag= "";
            if(jcheckExo.isSelected()){
                flag="S";
            }else{
                flag="N";
            }
            ConceptosDAO.actualizarConcepto(txtCodArt.getText(), jcheckIGV.isSelected(), txtPrecio.getText(), txtPrecioSinIGV.getText(),txtArticuloDesc.getText(),flag);      
            jcbTipoConcepto.removeAllItems();
            ConceptosDAO.resetListArticulos();
            for(ConceptoCobro temp: ConceptosDAO.getConceptos()){
                jcbTipoConcepto.addItem(temp.getConcepto() + " (S/. " + Util.formatDecimal(temp.getPrecioUnitario().doubleValue()) + ")");
            }
            //this.setVisible(false);
    }
    private void txtCodArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodArtActionPerformed

    
    
    private void loadComponentes(){        
        this.setTitle("DmPos - Actualizar Articulos");    
        loadComboMoneda();
    }
    
    public void loadCodigoConcepto(){
        txtCodArt.setText(codigoProducto);
        ConceptoCobro conceptoCobro = ConceptosDAO.getConceptoxCodigo(codigoProducto);
        txtArticuloDesc.setText(conceptoCobro.getConcepto());
        jcheckIGV.setSelected(conceptoCobro.isAplicaIgv());
        if(conceptoCobro.getExonerado().equals("S")){
            jcheckExo.setSelected(true);
        }else{
            jcheckExo.setSelected(false);
        }        
        monedaVO = MonedasDAO.consultarMonedasXCod(conceptoCobro.getTipomon());           
        jcbTipoMoneda.setSelectedItem(monedaVO.getMoneda() + " - " + monedaVO.getMonedaAbr());
                
        txtPrecio.setText(Util.formatDecimal(conceptoCobro.getPrecioUnitario().doubleValue()));
        txtPrecioSinIGV.setText(Util.formatDecimal(conceptoCobro.getPrecioUnitarioSinIgv().doubleValue()));
        txtUMedida.setText(conceptoCobro.getUnimed());
        if(conceptoCobro.getEstadocon()=="A"){
            jcbEstado.setSelectedIndex(0);
        }
        if(conceptoCobro.getEstadocon()=="I"){
            jcbEstado.setSelectedIndex(1);
        }    
    }
     private void loadComboMoneda(){
        for(MonedaVO temp: MonedasDAO.consultarMonedas()){
            if(temp.getMonedaAbr().equals("")){
                jcbTipoMoneda.addItem(temp.getMoneda()+"-Dolar");
            }else{
                jcbTipoMoneda.addItem(temp.getMoneda() + " - " + temp.getMonedaAbr());
            }            
        }
    }    
    
    
    public void Limpiar(){
       
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOKPassChange;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JComboBox<String> jcbTipoMoneda;
    public static javax.swing.JCheckBox jcheckExo;
    public static javax.swing.JCheckBox jcheckIGV;
    public static javax.swing.JTextField txtArticuloDesc;
    public static javax.swing.JTextField txtCodArt;
    public static javax.swing.JTextField txtPrecio;
    public static javax.swing.JTextField txtPrecioSinIGV;
    private javax.swing.JTextField txtUMedida;
    // End of variables declaration//GEN-END:variables
}

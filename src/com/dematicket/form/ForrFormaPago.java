package com.dematicket.form;

import com.dematicket.bean.MedioPagoVO;
import com.dematicket.bean.MonedaVO;
import com.dematicket.bean.Ticket;
import com.dematicket.data.MedioPagoDAO;
import com.dematicket.data.MonedasDAO;
import com.dematicket.data.SesionData;
import com.dematicket.data.UsuarioData;
import static com.dematicket.form.FormTicket.btnImprimir;
import static com.dematicket.form.FormTicket.jcbTipoDocumento;
import static com.dematicket.form.FormTicket.jcbTipoMoneda;
import static com.dematicket.form.FormTicket.lblExchangeRate;
import static com.dematicket.form.FormTicket.totalTemporal;
import com.dematicket.util.Util;
import java.awt.Toolkit;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lmonge
 */
public class ForrFormaPago extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    String cabecera = "";
    String moneda="";
    ArrayList<String> detalle = new ArrayList();
    BigDecimal monto = BigDecimal.ZERO;
    BigDecimal monto2 = BigDecimal.ZERO;
    BigDecimal temporal3 = BigDecimal.ZERO;
    BigDecimal tempPendiente = BigDecimal.ZERO;
    private Ticket ticket = null;
    private int index=0;
    String monedaTemp="";
    /**
     * Creates new form FormTicket
     */
    public ForrFormaPago() {
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

        labelTotal = new javax.swing.JLabel();
        lblTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = //jcastillo inicio
        new javax.swing.JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false;

            }
        };
        //jcastillo fin;
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jcbFP = new javax.swing.JComboBox();
        labelTipo1 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcbMonedaFP = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        lblmoneda = new javax.swing.JLabel();
        btnPagarTotal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);

        labelTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTotal.setText("TOTAL:");

        lblTotal.setEditable(false);
        lblTotal.setColumns(20);
        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(204, 0, 0));
        lblTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jcbFP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbFP.setMaximumSize(new java.awt.Dimension(350, 21));

        labelTipo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTipo1.setText("Forma Pago : ");

        btnPagar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPagar.setText("Agregar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTipo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbFP, 0, 279, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipo1)
                    .addComponent(btnPagar)))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Moneda : ");

        jcbMonedaFP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbMonedaFP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMonedaFPActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("SubTotal : ");

        txtSubTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSubTotalKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Total a Pagar :");

        txtTotalPagar.setEditable(false);
        txtTotalPagar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtTotalPagar.setToolTipText("");

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblmoneda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblmoneda.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbMonedaFP, 0, 116, Short.MAX_VALUE)
                            .addComponent(txtSubTotal))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblmoneda)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jcbMonedaFP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblmoneda))
                            .addComponent(jLabel3))
                        .addContainerGap())))
        );

        btnPagarTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPagarTotal.setText("Pagar");
        btnPagarTotal.setEnabled(false);
        btnPagarTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPagarTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotal)
                    .addComponent(btnPagarTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
        if(jcbFP.getSelectedItem().toString().startsWith("-")){
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR LA FORMA DE PAGO", "DmPos", JOptionPane.WARNING_MESSAGE);            
            return;  
        }
        
        if(jcbMonedaFP.getSelectedItem().toString().startsWith("-")){
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR EL TIPO DE MONEDA", "DmPos", JOptionPane.WARNING_MESSAGE);            
            return;  
        }  
        
        if(txtSubTotal.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN MONTO A PAGAR", "DmPos", JOptionPane.WARNING_MESSAGE);            
            return;  
        } 
                
        BigDecimal temporal1 = BigDecimal.ZERO;
        BigDecimal temporal2 = BigDecimal.ZERO;
        
        temporal1= new BigDecimal(txtSubTotal.getText());//monto que se desea pagar
        
        temporal2= new BigDecimal(txtTotalPagar.getText());//monto que se tiene que pagar
        
//        BigDecimal tcambio= new BigDecimal(lblExchangeRate.getText());
        
        if(temporal1.compareTo(temporal2)<=0){
            temporal2 = temporal2.subtract(temporal1);
            monto2=temporal1;
            monto2=monto2.setScale(2, BigDecimal.ROUND_HALF_UP);
            txtTotalPagar.setText(Util.formatDecimal(temporal2.doubleValue()));

            String tpago=MedioPagoDAO.getByIndex(jcbFP.getSelectedIndex()).getDESCRIPCION();
            Object [] object = new Object[]{
                  tpago,
                 monedaTemp,
                 monto2
            };
            modelo.addRow(object);
//            String valorTipDoc =jcbTipoDocumento.getSelectedItem().toString();            
//            String valorSeleccionado[] = valorTipDoc.split(" - ");
//            
//            BigDecimal montori=BigDecimal.ZERO;
//            BigDecimal montoLoc=BigDecimal.ZERO;
//            BigDecimal montoExt=BigDecimal.ZERO;
//            
//            if(moneda.equals("D")){
//                montori=monto2.multiply(tcambio);
//                montoLoc=monto2.multiply(tcambio);
//                montoExt=monto2;
//            }else{
//                montori=monto2;
//                montoLoc=monto2;
//                montoExt=monto2.divide(tcambio,2,RoundingMode.HALF_UP);
//            }
//            boolean estadoMedioPago =
//            MedioPagoDAO.insertaMedioPago(UsuarioData.getUsuario().getEmpresa(), 
//                    valorSeleccionado[0], 
//                    SesionData.getSesion().getSerie(), 
//                    Util.completarIzquierda(8, SesionData.getSesion().getNumero()+"", "0"), 
//                    (index+1), 
//                    MedioPagoDAO.getByIndex(jcbFP.getSelectedIndex()).getFPAGOID(), 
//                    MedioPagoDAO.getByIndex(jcbFP.getSelectedIndex()).getSUBFPAGOID(), 
//                    MedioPagoDAO.getByIndex(jcbFP.getSelectedIndex()).getFPAGOID_SUNAT(), 
//                    moneda,
//                    montori, 
//                    montoLoc, 
//                    montoExt);
//            
//            if(estadoMedioPago){
//                temporal3= temporal3.add(monto2);//acumulador de lo que se viene pagando
//                lblTotal.setText(Util.formatDecimal((temporal3.doubleValue())));
//
//                if(temporal2.compareTo(BigDecimal.ZERO)==0){
//                    btnImprimir.setEnabled(true);
//                }
//                txtSubTotal.setText("");
//                index++;
//            }else{
//                JOptionPane.showMessageDialog(null, "NO SE PUDO INGRESAR EL PAGO", "DmPos", JOptionPane.ERROR_MESSAGE);
//            }
            temporal3= temporal3.add(monto2);//acumulador de lo que se viene pagando
            lblTotal.setText(Util.formatDecimal((temporal3.doubleValue())));
            if(temporal2.compareTo(BigDecimal.ZERO)==0){
                   btnPagarTotal.setEnabled(true);
            }else{
                btnPagarTotal.setEnabled(false);
            }
            //txtSubTotal.setText("");
            tempPendiente=temporal2;
            totalTemporal=temporal2;
            
            txtSubTotal.setText(txtTotalPagar.getText());
            
        }else{
            JOptionPane.showMessageDialog(null, "NO SE PUEDE PAGAR UN MONTO MAYOR A LA VENTA", "DmPos", JOptionPane.ERROR_MESSAGE);
        }
        
        //temporal= 
    }//GEN-LAST:event_btnPagarActionPerformed
    private BigDecimal recalculaTotalPagar(BigDecimal montoEliminado, BigDecimal montoPendiente){
        BigDecimal mont= BigDecimal.ZERO;
        mont=temporal3;
        montoPendiente= montoPendiente.add(montoEliminado);        
        mont=mont.subtract(montoEliminado);
        lblTotal.setText(Util.formatDecimal((mont.doubleValue())));
        txtTotalPagar.setText(Util.formatDecimal((montoPendiente.doubleValue())));
        temporal3=mont;
        return montoPendiente;
    }
    private void jcbMonedaFPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMonedaFPActionPerformed
        // TODO add your handling code here:
        String valorTipDocPrincipal =jcbTipoMoneda.getSelectedItem().toString();
        BigDecimal tcambio= new BigDecimal(lblExchangeRate.getText());
        //calculaMonto();
        String monedaFormaPago = "";
        if(!jcbMonedaFP.getSelectedItem().toString().startsWith("-")){
            if(jcbMonedaFP.getSelectedItem().toString().startsWith("Soles")){
                monedaFormaPago="S";
                lblmoneda.setText("Soles");
            }
            if(jcbMonedaFP.getSelectedItem().toString().startsWith("Dolar")){
                monedaFormaPago="D";
                lblmoneda.setText("Dolares");
            }
            
            BigDecimal temporal2 = BigDecimal.ZERO;
            temporal2= new BigDecimal(txtTotalPagar.getText());
            
            if(!monedaTemp.equals(monedaFormaPago)){
                if(monedaTemp.equals("D") && monedaFormaPago.equals("S")){
                    temporal2= temporal2.multiply(tcambio);
                    monedaTemp="S";
                    txtTotalPagar.setText(Util.formatDecimal((temporal2.doubleValue())));
                    txtSubTotal.setText(txtTotalPagar.getText());
                }
                if(monedaTemp.equals("S") && monedaFormaPago.equals("D")){
                    temporal2= temporal2.divide(tcambio,2,RoundingMode.HALF_UP);
                    monedaTemp="D";
                    txtTotalPagar.setText(Util.formatDecimal((temporal2.doubleValue())));
                    txtSubTotal.setText(txtTotalPagar.getText());
                }
            }
        }
        
//        if(!jcbMonedaFP.getSelectedItem().toString().startsWith("-")){
//            if((valorTipDocPrincipal.startsWith("Dolar")) && (jcbMonedaFP.getSelectedItem().toString().startsWith("Soles"))){                       
//                    temporal3= temporal3.multiply(tcambio);
//                    moneda="S";
//                
//            }else{
//                if((valorTipDocPrincipal.startsWith("Soles")) && (jcbMonedaFP.getSelectedItem().toString().startsWith("Dolar"))){
//                    temporal3= temporal3.divide(tcambio,2,RoundingMode.HALF_UP);
//                    moneda="D";
//                }else{
//                    if((moneda.equals("D")) && (jcbMonedaFP.getSelectedItem().toString().startsWith("Soles"))){
//                        temporal3= temporal3.multiply(tcambio);
//                        moneda="S";
//                    }
//                    if((moneda.equals("S")) && (jcbMonedaFP.getSelectedItem().toString().startsWith("Dolar"))){
//                        temporal3= temporal3.divide(tcambio,2,RoundingMode.HALF_UP);
//                        moneda="D";
//                    }
//
//                }
//                
//            }
//            temporal3=temporal3.setScale(2, BigDecimal.ROUND_HALF_UP);
//            
//            if(temporal3.compareTo(BigDecimal.ZERO)==0){
//                txtTotalPagar.setText(txtTotalPagar.getText());
//            }
//            
//        }
        
        
    }//GEN-LAST:event_jcbMonedaFPActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        if(index<0){
            if(modelo.getRowCount()>0){
                JOptionPane.showMessageDialog(null, "POR FAVOR, PRIMERO SELECCIONE LA FORMA DE PAGO QUE DESEA ELIMINAR ", "DmPos",JOptionPane.WARNING_MESSAGE);
                return;
            }else if(modelo.getRowCount()<=0){
                JOptionPane.showMessageDialog(null, "PRIMERO DEBE INGRESAR UNA FORMA DE PAGO", "DmPos",JOptionPane.ERROR_MESSAGE);
                return;
            }            
        }
        
        
        String valorTipDocPrincipal =jcbTipoMoneda.getSelectedItem().toString();
        String valorSeleccionadoP[] = valorTipDocPrincipal.split(" - ");
        String monedaPrincipal=valorSeleccionadoP[0];
        if(monedaPrincipal.equals("Dolar")){
            monedaPrincipal="D";
        }else{
            monedaPrincipal="S";
        }
                        
        BigDecimal tcambio= new BigDecimal(lblExchangeRate.getText());
        String monedaTabla = (String)modelo.getValueAt(index, 1);
        BigDecimal montoTabla = (BigDecimal)modelo.getValueAt(index, 2);
        if(monedaTabla.equals(monedaPrincipal)){
            tempPendiente=recalculaTotalPagar(montoTabla, tempPendiente);
            //totalPagado= totalPagado.add(montoTabla);
        }else{
            if(monedaTabla.equals("D")){
                montoTabla= montoTabla.multiply(tcambio);
                //montoTabla= montoTabla.divide(tcambio,2,RoundingMode.HALF_UP);
                tempPendiente=recalculaTotalPagar(montoTabla, tempPendiente);
                                
                //totalPagado= totalPagado.add(montoTabla);
            }else if(monedaTabla.equals("S")){                        
                montoTabla= montoTabla.divide(tcambio,2,RoundingMode.HALF_UP);
                tempPendiente=recalculaTotalPagar(montoTabla, tempPendiente);
                //totalPagado= totalPagado.add(montoTabla);
            }
        }
        
        BigDecimal totalPagado = BigDecimal.ZERO;
        for(int i=0; i<modelo.getRowCount();i++){
            monedaTabla = (String)modelo.getValueAt(i, 1);
            montoTabla = (BigDecimal)modelo.getValueAt(i, 2);
            if(monedaTabla.equals(monedaPrincipal)){
                totalPagado= totalPagado.add(montoTabla);
            }else{
                if(monedaTabla.equals("D")){
                    montoTabla= montoTabla.multiply(tcambio);
                    totalPagado= totalPagado.add(montoTabla);
                }else if(monedaTabla.equals("S")){                        
                    montoTabla= montoTabla.divide(tcambio,2,RoundingMode.HALF_UP);
                    totalPagado= totalPagado.add(montoTabla);
                }
            }
        }
        totalTemporal = totalPagado;       
        //BigDecimal m = (BigDecimal) modelo.getValueAt(index, 2);
        
        modelo.removeRow(index);
        
        
        if(tempPendiente.compareTo(BigDecimal.ZERO)==0){
            btnPagarTotal.setEnabled(true);
        }else{
            btnPagarTotal.setEnabled(false);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnPagarTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarTotalActionPerformed
        // TODO add your handling code here:
        BigDecimal tcambio= new BigDecimal(lblExchangeRate.getText()); 
        boolean estadoMedioPago =false;
        for(int i=0; i<modelo.getRowCount();i++){
            String valorTipDoc =jcbTipoDocumento.getSelectedItem().toString();            
            String valorSeleccionado[] = valorTipDoc.split(" - ");
            
            String codigo="",subcodigo="",codigoSunat="";
            String medioPagoSeleccionado = (String)modelo.getValueAt(i, 0);
            
            for(MedioPagoVO temp: MedioPagoDAO.consultarMedios()){
                if(temp.getDESCRIPCION().equals(medioPagoSeleccionado)){
                    codigo=temp.getFPAGOID();
                    subcodigo=temp.getSUBFPAGOID();
                    codigoSunat=temp.getFPAGOID_SUNAT();
                }
            }
            BigDecimal montoConvertir=BigDecimal.ZERO;
            BigDecimal montori=BigDecimal.ZERO;
            BigDecimal montoLoc=BigDecimal.ZERO;
            BigDecimal montoExt=BigDecimal.ZERO;
            montoConvertir = (BigDecimal)modelo.getValueAt(i, 2);
            if(moneda.equals("D")){
                montori=montoConvertir.multiply(tcambio);
                montoLoc=montoConvertir.multiply(tcambio);
                montoExt=montoConvertir;
            }else{
                montori=montoConvertir;
                montoLoc=montoConvertir;
                montoExt=montoConvertir.divide(tcambio,2,RoundingMode.HALF_UP);
            }
            estadoMedioPago=
            MedioPagoDAO.insertaMedioPago(UsuarioData.getUsuario().getEmpresa(), 
                    valorSeleccionado[0], 
                    SesionData.getSesion().getSerie(), 
                    Util.completarIzquierda(8, SesionData.getSesion().getNumero()+"", "0"), 
                    (i+1), 
                    codigo, 
                    subcodigo, 
                    codigoSunat, 
                    monedaTemp,
                    montori, 
                    montoLoc, 
                    montoExt);
            
            if(estadoMedioPago){
//                temporal3= temporal3.add(montoConvertir);//acumulador de lo que se viene pagando
//                lblTotal.setText(Util.formatDecimal((temporal3.doubleValue())));
//                BigDecimal existePorPagar= new BigDecimal(txtTotalPagar.getText());
//                if(existePorPagar.compareTo(BigDecimal.ZERO)==0){
//                    btnImprimir.setEnabled(true);
//                }
                txtSubTotal.setText("");
                index++;
                
            }else{
                JOptionPane.showMessageDialog(null, "NO SE PUDO INGRESAR EL PAGO", "DmPos", JOptionPane.ERROR_MESSAGE);
            }
         }
        if(estadoMedioPago){
            BigDecimal existePorPagar= new BigDecimal(txtTotalPagar.getText());
            if(existePorPagar.compareTo(BigDecimal.ZERO)==0){
                btnImprimir.setEnabled(true);
            }
            JOptionPane.showMessageDialog(null, "PAGO INGRESADO CORRECTAMENTE, CLICK EN IMPRIMIR", "DmPos", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }
        
        //inicializa();
        //lblTotal.setText(Util.formatDecimal((temporal3.doubleValue())));
        
    }//GEN-LAST:event_btnPagarTotalActionPerformed

    private void txtSubTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubTotalKeyTyped
        // TODO add your handling code here:
        char kc = (char) evt.getKeyChar();
        if(Util.validaSoloNumero(kc)== false){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSubTotalKeyTyped
    public void calculaMonto(){
        monto = totalTemporal;
        monto=monto.setScale(2, BigDecimal.ROUND_HALF_UP);
        
        if(monto.compareTo(BigDecimal.ZERO)==0){
            txtTotalPagar.setText(Util.formatDecimal((BigDecimal.ZERO.doubleValue())));
//            Limpiar();
//            if(jTable1.getRowCount()==0){
//                //FormFormaPago.setVisible(true);
//                lblTotal.setText(Util.formatDecimal((monto.doubleValue())));
//                totalTemporal = BigDecimal.ZERO;
//                btnPagarTotal.setEnabled(false);
//            }else{
//                btnPagarTotal.setEnabled(true);
//            }
        }else{
            BigDecimal totalPagado = BigDecimal.ZERO;
            String valorTipDocPrincipal =jcbTipoMoneda.getSelectedItem().toString();
            String valorSeleccionadoP[] = valorTipDocPrincipal.split(" - ");
            String monedaPrincipal=valorSeleccionadoP[0];
            if(monedaPrincipal.equals("Dolar")){
                monedaPrincipal="D";
            }else{
                monedaPrincipal="S";
            }
                        
            BigDecimal tcambio= new BigDecimal(lblExchangeRate.getText());
            for(int i=0; i<modelo.getRowCount();i++){
                String monedaTabla = (String)modelo.getValueAt(i, 1);
                BigDecimal montoTabla = (BigDecimal)modelo.getValueAt(i, 2);
                if(monedaTabla.equals(monedaPrincipal)){
                    totalPagado= totalPagado.add(montoTabla);
                }else{
                    if(monedaTabla.equals("D")){
                        montoTabla= montoTabla.multiply(tcambio);
                        //montoTabla= montoTabla.divide(tcambio,2,RoundingMode.HALF_UP);
                        totalPagado= totalPagado.add(montoTabla);
                    }else if(monedaTabla.equals("S")){                        
                        montoTabla= montoTabla.divide(tcambio,2,RoundingMode.HALF_UP);
                        totalPagado= totalPagado.add(montoTabla);
                    }
                }
            }
                    
            txtTotalPagar.setText(Util.formatDecimal((monto.subtract(totalPagado).doubleValue())));
        }
        
        txtSubTotal.setText(txtTotalPagar.getText());
    }
    public void limpiaTabla(){
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            modelo.removeRow(i);
            i-=1;
        }
        monto = BigDecimal.ZERO;
        monto2 = BigDecimal.ZERO;
        temporal3 = BigDecimal.ZERO;
        tempPendiente = BigDecimal.ZERO;
        lblTotal.setText("");
    }
    public void Limpiar(){
        txtSubTotal.setText("");
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            modelo.removeRow(i);
            i-=1;
        }
    }
//    public void inicializa(){
//        tempPendiente=BigDecimal.ZERO;
//        temporal3 = BigDecimal.ZERO;
//    }
    public void seleccionaMoneda(){
        String valorTipDocPrincipal =jcbTipoMoneda.getSelectedItem().toString();        
        if(valorTipDocPrincipal.startsWith("Dolar")){
            moneda="D";
            monedaTemp="D";
        }else{
            moneda="S";
            monedaTemp="S";
        }
        jcbMonedaFP.setSelectedItem(valorTipDocPrincipal);
    }
    private void loadComponentes(){
        String path = new File ("").getAbsolutePath();
        path = path+"\\img\\";
        this.setTitle("DmPos - Seleccionar Forma Pago");
        //this.setIconImage(new ImageIcon(path+"logowindow.png").getImage());
        
        if(UsuarioData.getUsuario().getEmpresa().equals("1")){
           this.setIconImage(new ImageIcon(path+"logowindow.png").getImage());
        }
        if(UsuarioData.getUsuario().getEmpresa().equals("2")){
           this.setIconImage(new ImageIcon(path+"logowindowCrisol.png").getImage());           
        }   
        
        modelo = new DefaultTableModel(
            new Object [][] {
            },
            new Object [] {
                "FORMA PAGO","MONEDA","SUBTOTAL"
            });       
        jTable1.setModel(modelo);
        loadCombos();
        labelTotal.setVisible(false);
        lblTotal.setVisible(false);
    }
    private void loadCombos(){
        for(MedioPagoVO temp: MedioPagoDAO.consultarMedios()){
            if(temp.getFPAGOID() == null){
               jcbFP.addItem(temp.getDESCRIPCION());  
            }else{
               String codigo= temp.getFPAGOID()+"-"+temp.getSUBFPAGOID()+"-"+temp.getFPAGOID_SUNAT();
               jcbFP.addItem(codigo + " - " + temp.getDESCRIPCION()); 
            }
        }
        
        for(MonedaVO temp: MonedasDAO.consultarMonedas()){
            if(temp.getMonedaAbr().equals("")){
                jcbMonedaFP.addItem(temp.getMoneda());
            }else{
                jcbMonedaFP.addItem(temp.getMoneda() + " - " + temp.getMonedaAbr());
            }            
        }
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPagarTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JComboBox jcbFP;
    private javax.swing.JComboBox<String> jcbMonedaFP;
    private javax.swing.JLabel labelTipo1;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JTextField lblTotal;
    private javax.swing.JLabel lblmoneda;
    public static javax.swing.JTextField txtSubTotal;
    public static javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}

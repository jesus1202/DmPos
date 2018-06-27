package com.dematicket.form;

import com.dematicket.bean.ClienteVO;
import com.dematicket.bean.MedioPagoVO;
import com.dematicket.bean.MonedaVO;
import com.dematicket.bean.Ticket;
import com.dematicket.data.ClienteData;
import com.dematicket.data.MedioPagoDAO;
import com.dematicket.data.MonedasDAO;
import com.dematicket.data.SesionData;
import com.dematicket.data.UsuarioData;
import com.dematicket.data.VentasDAO;
import static com.dematicket.form.FormTicket.btnImprimir;
import static com.dematicket.form.FormTicket.jTable1;
import static com.dematicket.form.FormTicket.jcbTipoDocumento;
import static com.dematicket.form.FormTicket.lblFechaProceso;
import static com.dematicket.form.FormTicket.lblTicket;
import static com.dematicket.form.FormTicket.lblTurno;
import static com.dematicket.form.FormTicket.spnCantidad;
import static com.dematicket.form.FormTicket.totalTemporal;
import static com.dematicket.form.FormTicket.txtCliente;
import static com.dematicket.form.FormTicket.txtDireccionP;
import static com.dematicket.form.FormTicket.txtRUCDNI;
import com.dematicket.util.TipoArchivo;
import com.dematicket.util.Util;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lmonge
 */
public class ForrFormaPago extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    String cabecera = "";
    ArrayList<String> detalle = new ArrayList();
    BigDecimal monto = BigDecimal.ZERO;
    BigDecimal monto2 = BigDecimal.ZERO;
    BigDecimal temporal3 = BigDecimal.ZERO;
    private Ticket ticket = null;
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
                .addComponent(jcbFP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("SubTotal : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Total a Pagar :");

        txtTotalPagar.setToolTipText("");

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
                        .addGap(76, 76, 76)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalPagar))
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
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
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
                    .addComponent(labelTotal))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
        
        BigDecimal temporal1 = BigDecimal.ZERO;
        BigDecimal temporal2 = BigDecimal.ZERO;
        
        temporal1= new BigDecimal(txtSubTotal.getText());
        
        temporal2= new BigDecimal(txtTotalPagar.getText());
        
        if(temporal3.compareTo(temporal2)<0){
            temporal2 = temporal2.subtract(temporal1);
            monto2=temporal1;
            monto2=monto2.setScale(2, BigDecimal.ROUND_HALF_UP);
            txtTotalPagar.setText(Util.formatDecimal(temporal2.doubleValue()));

            String tpago=MedioPagoDAO.getByIndex(jcbFP.getSelectedIndex()).getDESCRIPCION();
            Object [] object = new Object[]{
                  tpago,
                 monto2
            };
            modelo.addRow(object);
            temporal3= temporal3.add(monto2);


            lblTotal.setText(Util.formatDecimal((temporal3.doubleValue())));
            
            if(temporal2.compareTo(BigDecimal.ZERO)==0){
                btnImprimir.setEnabled(true);
            }
            
            
            
        }else{
            JOptionPane.showMessageDialog(null, "NO SE PUEDE PAGAR UN MONTO MAYOR A LA VENTA", "DmPos", JOptionPane.ERROR_MESSAGE);
        }
        
        //temporal= 
    }//GEN-LAST:event_btnPagarActionPerformed
    public void calculaMonto(){
        monto = totalTemporal;
        monto=monto.setScale(2, BigDecimal.ROUND_HALF_UP);
        txtTotalPagar.setText(Util.formatDecimal((monto.subtract(monto2).doubleValue())));
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
                "FORMA PAGO", "SUBTOTAL"
            });       
        jTable1.setModel(modelo);
        loadCombos();
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
    private javax.swing.JButton btnPagar;
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
    public static javax.swing.JTextField txtSubTotal;
    public static javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}

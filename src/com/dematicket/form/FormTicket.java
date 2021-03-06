package com.dematicket.form;

import com.dematicket.bean.ClienteVO;
import com.dematicket.bean.ConceptoCobro;
import com.dematicket.bean.DetalleTicket;
import com.dematicket.bean.DocumentosVO;
import com.dematicket.bean.MonedaVO;
import com.dematicket.bean.Ticket;
import com.dematicket.bean.TipoCambioVO;
import com.dematicket.bean.UsuarioVO;
import com.dematicket.bean.VentasCabeceraVO;
import com.dematicket.bean.VentasDetalleVO;
import com.dematicket.data.ClienteData;
import com.dematicket.data.ConceptosDAO;
import com.dematicket.data.DocumentosDAO;
import com.dematicket.data.EmpresaDAO;
import com.dematicket.data.MonedasDAO;
import com.dematicket.data.PtoVentaDAO;
import com.dematicket.data.SesionData;
import com.dematicket.data.TiendaDAO;
import com.dematicket.data.TipoCambioDAO;
import com.dematicket.data.UsuarioDAO;
import com.dematicket.data.UsuarioData;
import com.dematicket.data.VentasDAO;

import static com.dematicket.form.ForrFormaPago.txtTotalPagar;
import com.dematicket.print.DirectPrinterT88V;
import com.dematicket.util.DbConnection;
import com.dematicket.util.NumberToLetterConverter;
import com.dematicket.util.Reloj;
import com.dematicket.util.TipoArchivo;
import com.dematicket.util.Util;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.log4j.Logger;

/**
 *
 * @author lmonge
 */
public class FormTicket extends javax.swing.JFrame {
    final static Logger logger = Logger.getLogger(FormTicket.class);
    private DefaultTableModel modelo;
    private Ticket ticket = null;
    private static final String CLIENTE_OTROS = "OTROS";
    private FormAnulacion formAnulacion;
    private FormUserMaintainer formUserMaintainer;
    private FormProductMaintainer formProductMaintainer;
    private FormExchangeRate formExchangeRate;  
    private ForrFormaPago FormFormaPago;
    
    /**
     * Creates new form FormTicket
     */
    public FormTicket() {
        loadFechaToFechaProcesoBD();
        initComponents();
        btnIniciarDia.setVisible(false);
        btnCerrarTurno.setVisible(true);//boton para cerrar turno
        btnImprimeCuadre.setVisible(true);//boton para imprimir cuadre
        lblTurno.setVisible(false);
        loadComboTipo();
        loadComboTipoDocumento();
        loadComboMoneda();
        loadComponentes();
        String path = new File ("").getAbsolutePath();
        path = path+"\\src\\imagenes\\";
        ImageIcon iconoUserMaintenance = new ImageIcon(path+"MantenedorUsuarios.png");
        ImageIcon iconoExchangeRate = new ImageIcon(path+"TipoCambio.png");
        ImageIcon iconoProductMaintenance = new ImageIcon(path+"MantenedorProductos.png");
        btnUserMaintenance.setIcon(iconoUserMaintenance);
        btnProdcutMaintenance.setIcon(iconoProductMaintenance);
        btnExchangeRate.setIcon(iconoExchangeRate);
        
        if(UsuarioData.getUsuario().getEmpresa().equals("1")){
            btnSincronizar.setVisible(true);
        }else{
            btnSincronizar.setVisible(false);
        }
        
        recuperaTurno(UsuarioData.getUsuario().getEmpresa(), UsuarioData.getUsuario().getTienda(), 
                UsuarioData.getUsuario().getPtoVenta(),true);
        
        jcbTipoMoneda.setSelectedIndex(jcbTipoMoneda.getItemCount()-1);
        txtDscto.setText("0.0");
        labelTotal3.setVisible(false);
        lblContadorServ.setVisible(false);
        spnCantidad.setValue(0);
        loadComboVendedor();
        lblFechaProceso.setVisible(false);
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
        labelTicket = new javax.swing.JLabel();
        lblTicket = new javax.swing.JTextField();
        labelTipo = new javax.swing.JLabel();
        jcbTipoConcepto = new javax.swing.JComboBox();
        labelCantidad = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        labelSubTotal = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminarDetalle = new javax.swing.JButton();
        btnBusqueda = new javax.swing.JButton();
        labelCantidad1 = new javax.swing.JLabel();
        lblPrecioUnitario = new javax.swing.JTextField();
        scrambledLabel2 = new javax.swing.JLabel();
        scrambledLabel3 = new javax.swing.JLabel();
        scrambledLabel4 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtRUCDNI = new javax.swing.JTextField();
        txtDireccionP = new javax.swing.JTextField();
        txtFiltro = new javax.swing.JTextField();
        jcbTipoDocumento = new javax.swing.JComboBox();
        labelTipo1 = new javax.swing.JLabel();
        btnUserMaintenance = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblExchangeRate = new javax.swing.JTextField();
        btnExchangeRate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jcbTipoMoneda = new javax.swing.JComboBox<>();
        btnProdcutMaintenance = new javax.swing.JButton();
        labelCantidad2 = new javax.swing.JLabel();
        txtDscto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        labelTipo2 = new javax.swing.JLabel();
        jcbVendedor = new javax.swing.JComboBox();
        jpnHeader = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        jpnUsuario = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblCompania = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        lblFechaProceso = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        lblTienda = new javax.swing.JLabel();
        lblPtoVta = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnImprimeCuadre = new javax.swing.JButton();
        btnCerrarTurno = new javax.swing.JButton();
        btnIniciarDia = new javax.swing.JButton();
        btnSincronizar = new javax.swing.JButton();
        labelTotal1 = new javax.swing.JLabel();
        lblContadorSubTotal = new javax.swing.JTextField();
        labelTotal2 = new javax.swing.JLabel();
        lblContadorDscto = new javax.swing.JTextField();
        labelTotal3 = new javax.swing.JLabel();
        lblContadorServ = new javax.swing.JTextField();
        labelTotal4 = new javax.swing.JLabel();
        lblContadorIGV = new javax.swing.JTextField();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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

        labelTicket.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTicket.setText("Comprobante:");

        lblTicket.setEditable(false);
        lblTicket.setColumns(20);
        lblTicket.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTicket.setForeground(new java.awt.Color(204, 51, 0));
        lblTicket.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        labelTipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTipo.setText("Tipo:");

        jcbTipoConcepto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbTipoConcepto.setMaximumSize(new java.awt.Dimension(350, 21));
        jcbTipoConcepto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTipoConceptoItemStateChanged(evt);
            }
        });

        labelCantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCantidad.setText("Cantidad:");

        spnCantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        spnCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCantidadStateChanged(evt);
            }
        });

        labelSubTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelSubTotal.setText("SubTotal:");

        lblSubTotal.setEditable(false);
        lblSubTotal.setColumns(20);
        lblSubTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSubTotal.setForeground(new java.awt.Color(204, 0, 0));
        lblSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar);

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar);

        btnEliminarDetalle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminarDetalle.setText("Eliminar Detalle");
        btnEliminarDetalle.setActionCommand("EliminarDetalle");
        btnEliminarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDetalleActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarDetalle);

        btnBusqueda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBusqueda.setText("Busqueda");
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });
        jPanel2.add(btnBusqueda);

        labelCantidad1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCantidad1.setText("Precio unit. :");

        lblPrecioUnitario.setEditable(false);
        lblPrecioUnitario.setColumns(20);
        lblPrecioUnitario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrecioUnitario.setForeground(new java.awt.Color(204, 0, 0));
        lblPrecioUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lblPrecioUnitario.setPreferredSize(new java.awt.Dimension(200, 21));

        scrambledLabel2.setText("Cliente :");

        scrambledLabel3.setText("RUC/DNI :");

        scrambledLabel4.setText("Dirección :");

        txtRUCDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRUCDNIKeyTyped(evt);
            }
        });

        txtFiltro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFiltroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFiltroFocusLost(evt);
            }
        });
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });

        jcbTipoDocumento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbTipoDocumento.setMaximumSize(new java.awt.Dimension(350, 21));
        jcbTipoDocumento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTipoDocumentoItemStateChanged(evt);
            }
        });

        labelTipo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTipo1.setText("Doc :");

        btnUserMaintenance.setToolTipText("Crear / Actualizar Clientes");
        btnUserMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserMaintenanceActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Tipo de Cambio :");

        lblExchangeRate.setEditable(false);
        lblExchangeRate.setColumns(20);
        lblExchangeRate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblExchangeRate.setForeground(new java.awt.Color(204, 51, 0));
        lblExchangeRate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnExchangeRate.setToolTipText("Actualizar Tipo Cambio");
        btnExchangeRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExchangeRateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Moneda :");

        jcbTipoMoneda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbTipoMoneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoMonedaActionPerformed(evt);
            }
        });

        btnProdcutMaintenance.setToolTipText("Actualizar Productos");
        btnProdcutMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdcutMaintenanceActionPerformed(evt);
            }
        });

        labelCantidad2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCantidad2.setText("Dscto :");

        txtDscto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDscto.setForeground(new java.awt.Color(204, 0, 0));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("PAGAR");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        labelTipo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTipo2.setText("Vend : ");

        jcbVendedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbVendedor.setMaximumSize(new java.awt.Dimension(350, 21));
        jcbVendedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbVendedorItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(scrambledLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccionP))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(scrambledLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(scrambledLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRUCDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addComponent(btnUserMaintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74)
                        .addComponent(labelTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbVendedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblExchangeRate, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExchangeRate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbTipoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(labelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbTipoConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnProdcutMaintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCantidad1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCantidad2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDscto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSubTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(318, 318, 318))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(labelTicket)
                                            .addComponent(lblTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jcbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelTipo1)))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jcbTipoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnExchangeRate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(lblExchangeRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(scrambledLabel3)
                                            .addComponent(txtRUCDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnUserMaintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(scrambledLabel2)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(scrambledLabel4)
                                    .addComponent(txtDireccionP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelTipo)
                                .addComponent(jcbTipoConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelCantidad)
                                .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelSubTotal)
                                .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelCantidad1)
                                .addComponent(lblPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelCantidad2)
                                .addComponent(txtDscto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTipo2)
                            .addComponent(jcbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(btnProdcutMaintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblImagen.setMaximumSize(new java.awt.Dimension(353, 72));
        lblImagen.setMinimumSize(new java.awt.Dimension(353, 72));

        jpnUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(204, 51, 0));
        lblUsuario.setText("lblUsuario");
        lblUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jpnUsuario.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 373, 17));

        lblCompania.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblCompania.setForeground(new java.awt.Color(102, 102, 102));
        lblCompania.setText("lblCompania");
        lblCompania.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jpnUsuario.add(lblCompania, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 17, 373, 14));

        lblTurno.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblTurno.setForeground(new java.awt.Color(102, 102, 102));
        lblTurno.setText("lblTurno");
        lblTurno.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jpnUsuario.add(lblTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 92, 373, 2));

        lblFechaProceso.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblFechaProceso.setForeground(new java.awt.Color(102, 102, 102));
        lblFechaProceso.setText("lblFechaProceso");
        lblFechaProceso.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jpnUsuario.add(lblFechaProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 97, 260, 14));

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(102, 102, 102));
        lblFecha.setText("lblFecha");
        lblFecha.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jpnUsuario.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 62, 373, 14));

        lblVersion.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        lblVersion.setForeground(new java.awt.Color(102, 102, 102));
        lblVersion.setText("Version 02.02.2017.1");
        lblVersion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jpnUsuario.add(lblVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 77, 373, 11));

        lblTienda.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblTienda.setForeground(new java.awt.Color(102, 102, 102));
        lblTienda.setText("lblTienda");
        lblTienda.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jpnUsuario.add(lblTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 32, 373, 14));

        lblPtoVta.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblPtoVta.setForeground(new java.awt.Color(102, 102, 102));
        lblPtoVta.setText("lblPtoVta");
        lblPtoVta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jpnUsuario.add(lblPtoVta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 373, 14));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jpnUsuario.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        javax.swing.GroupLayout jpnHeaderLayout = new javax.swing.GroupLayout(jpnHeader);
        jpnHeader.setLayout(jpnHeaderLayout);
        jpnHeaderLayout.setHorizontalGroup(
            jpnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHeaderLayout.createSequentialGroup()
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 481, Short.MAX_VALUE)
                .addComponent(jpnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnHeaderLayout.setVerticalGroup(
            jpnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnHeaderLayout.createSequentialGroup()
                .addComponent(jpnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnReporte.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReporte.setText("Reporte Diario");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnImprimeCuadre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImprimeCuadre.setText("Imprimir Cuadre");
        btnImprimeCuadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimeCuadreActionPerformed(evt);
            }
        });

        btnCerrarTurno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCerrarTurno.setText("Cerrar Turno");
        btnCerrarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarTurnoActionPerformed(evt);
            }
        });

        btnIniciarDia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIniciarDia.setText("Cambiar Día");
        btnIniciarDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarDiaActionPerformed(evt);
            }
        });

        btnSincronizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSincronizar.setText("Sincronizar con OASIS");
        btnSincronizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSincronizarActionPerformed(evt);
            }
        });

        labelTotal1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTotal1.setText("SubTotal :");

        lblContadorSubTotal.setEditable(false);
        lblContadorSubTotal.setColumns(20);
        lblContadorSubTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContadorSubTotal.setForeground(new java.awt.Color(204, 0, 0));
        lblContadorSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        labelTotal2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTotal2.setText("Dscto :");

        lblContadorDscto.setEditable(false);
        lblContadorDscto.setColumns(20);
        lblContadorDscto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContadorDscto.setForeground(new java.awt.Color(204, 0, 0));
        lblContadorDscto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        labelTotal3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTotal3.setText("Serv :");

        lblContadorServ.setEditable(false);
        lblContadorServ.setColumns(20);
        lblContadorServ.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContadorServ.setForeground(new java.awt.Color(204, 0, 0));
        lblContadorServ.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        labelTotal4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTotal4.setText("IGV :");

        lblContadorIGV.setEditable(false);
        lblContadorIGV.setColumns(20);
        lblContadorIGV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContadorIGV.setForeground(new java.awt.Color(204, 0, 0));
        lblContadorIGV.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSincronizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprimeCuadre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrarTurno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIniciarDia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelTotal3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblContadorServ, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelTotal1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblContadorSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelTotal2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblContadorDscto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelTotal4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblContadorIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(labelTotal)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jpnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotal)
                    .addComponent(labelTotal1)
                    .addComponent(lblContadorSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotal2)
                    .addComponent(lblContadorDscto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotal3)
                    .addComponent(lblContadorServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotal4)
                    .addComponent(lblContadorIGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporte)
                    .addComponent(btnImprimeCuadre)
                    .addComponent(btnCerrarTurno)
                    .addComponent(btnIniciarDia)
                    .addComponent(btnSincronizar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void loadComboMoneda(){
        for(MonedaVO temp: MonedasDAO.consultarMonedas()){
            if(temp.getMonedaAbr().equals("")){
                jcbTipoMoneda.addItem(temp.getMoneda());
            }else{
                jcbTipoMoneda.addItem(temp.getMoneda() + " - " + temp.getMonedaAbr());
            }            
        }
    }
    
    private void loadComboVendedor(){
        /*for(ConceptoCobro temp: ConceptoCobroList.getConceptos()){
            jcbTipoConcepto.addItem(temp.getConcepto() + " (S/. " + Util.formatDecimal(temp.getPrecioUnitario().doubleValue()) + ")");
        }*/
        for(UsuarioVO temp: UsuarioData.listarVendedoresBD(UsuarioData.getUsuario().getEmpresa(),UsuarioData.getUsuario().getTienda())){
            if(temp.getUsuario().startsWith("-")){
               jcbVendedor.addItem(temp.getUsuario()); 
            }else{
               jcbVendedor.addItem(temp.getUsuario() + " - " + temp.getNombre());
            }            
        }
    }
    
    private void loadComboTipo(){
        /*for(ConceptoCobro temp: ConceptoCobroList.getConceptos()){
            jcbTipoConcepto.addItem(temp.getConcepto() + " (S/. " + Util.formatDecimal(temp.getPrecioUnitario().doubleValue()) + ")");
        }*/
        for(ConceptoCobro temp: ConceptosDAO.getConceptos()){
            jcbTipoConcepto.addItem(temp.getConcepto() + " (S/. " + Util.formatDecimal(temp.getPrecioUnitario().doubleValue()) + ")");
        }
    }
    public void loadComboTipo2(){
        for(ConceptoCobro temp: ConceptosDAO.getConceptos()){
            jcbTipoConcepto.addItem(temp.getConcepto() + " (S/. " + Util.formatDecimal(temp.getPrecioUnitario().doubleValue()) + ")");
        }
    }
    private int indexComboTipoDocumento=0;
    private void loadComboTipoDocumento(){
        int i=0;
        for(DocumentosVO temp: DocumentosDAO.consultarDocumentos()){
            if(temp.getDOCUMENTO().equals("BOLETA")){
                indexComboTipoDocumento=i;
            }
            jcbTipoDocumento.addItem(temp.getTIPODOCUMENTO() + " - " + temp.getDOCUMENTO());
            i++;
        }
        jcbTipoDocumento.setSelectedIndex(indexComboTipoDocumento);
    }
    private void loadFechaToFechaProcesoBD(){
        DbConnection conex= new DbConnection();
        try{
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT FECHAPROCESO FROM DMTICKET.DMT_VENTAS_MAE WHERE "
                        + "IDCOMPANIA = ? AND IDLOCALIDAD = ?");
            consulta.setString(1,"08");
            consulta.setString(2,"01");
            ResultSet res = consulta.executeQuery();
            String stringDate="";
            if(res.next()){
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                stringDate = df.format(res.getDate("FECHAPROCESO"));
            }
            if(! Util.obtieneFechaDia().equalsIgnoreCase(stringDate) ){
                consulta = conex.getConnection().prepareStatement("UPDATE DMTICKET.DMT_VENTAS_MAE SET FECHAPROCESO = ? WHERE "
                        + "IDCOMPANIA = ? AND IDLOCALIDAD = ?");
                consulta.setString(1,Util.obtieneFechaDia());
                consulta.setString(2,"08");
                consulta.setString(3,"01");
                consulta.executeUpdate(); 
            }
            consulta.close();
            conex.desconectar();            
            SesionData.getSesion().setFechaProceso(Util.obtieneFechaDia());            
        }catch(Exception ex){
                conex.desconectar();
                ex.printStackTrace();
        }
    }
    private void loadComponentes(){
        String path = new File ("").getAbsolutePath();
        path = path+"\\img\\";
        
        if(UsuarioData.getUsuario().getEmpresa().equals("1")){
           ImageIcon icon = new ImageIcon(path+"logo.png");
           lblImagen.setIcon(icon);
           this.setIconImage(new ImageIcon(path+"logowindow.png").getImage());
        }
        if(UsuarioData.getUsuario().getEmpresa().equals("2")){
           ImageIcon icon = new ImageIcon(path+"logoCrisol.png"); 
           lblImagen.setIcon(icon);
           this.setIconImage(new ImageIcon(path+"logowindowCrisol.png").getImage());
        }     
        //lblImagen.setIcon(new ImageIcon(getClass().getResource(path+"logo.png")) );
        this.setTitle("DmPos");
        //this.setIconImage(new ImageIcon(path+"logowindow.png").getImage());
        lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsuario.setText(UsuarioData.getUsuario().getUsuario() + " (" + UsuarioData.getUsuario().getNombre() + ")");
        lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
        lblFechaProceso.setHorizontalAlignment(SwingConstants.RIGHT);
        lblVersion.setHorizontalAlignment(SwingConstants.RIGHT);
        
        lblTienda.setText("TIENDA: "+TiendaDAO.consultarTiendaxID(UsuarioData.getUsuario().getEmpresa(), UsuarioData.getUsuario().getTienda()).getTiendadsc());
        lblTienda.setHorizontalAlignment(SwingConstants.RIGHT);
        
        lblPtoVta.setText("P.VTA: "+PtoVentaDAO.consultarPuntoxID(UsuarioData.getUsuario().getEmpresa(), UsuarioData.getUsuario().getTienda()).getPtovtades());
        lblPtoVta.setHorizontalAlignment(SwingConstants.RIGHT);        
        
        String compania= EmpresaDAO.consultarEmpresaxCodigo(UsuarioData.getUsuario().getEmpresa()).getEmpresa();
        
        //lblCompania.setText("COMPAÑIA: "+SesionData.getSesion().getCompania().toUpperCase());
        lblCompania.setText("COMPAÑIA: "+compania.toUpperCase());
        lblCompania.setHorizontalAlignment(SwingConstants.RIGHT);
        btnSalir.setHorizontalAlignment(SwingConstants.RIGHT);
        //Inicializa tabla
        modelo = new DefaultTableModel(
            new Object [][] {
            },
                //"DESCRIPCION","PRECIO UNIT.","DESCUENTO","MONEDA", "CANTIDAD", "SUBTOTAL"
            new Object [] {
                "CODIGO","DESCRIPCION","MONEDA","CANTIDAD","PRECIO UNIT.","DESCUENTO","SUBTOTAL"
            });        
        jTable1.setModel(modelo);
        
        TableColumn columnaCodigo = jTable1.getColumn("CODIGO");
        columnaCodigo.setMinWidth(130);
        columnaCodigo.setMaxWidth(130);
        
        TableColumn columnaDescripcion = jTable1.getColumn("DESCRIPCION");
        columnaDescripcion.setMinWidth(550);
        columnaDescripcion.setMaxWidth(550);
        
        TableColumn columnaMoneda = jTable1.getColumn("MONEDA");
        columnaMoneda.setMinWidth(60);
        columnaMoneda.setMaxWidth(60);
        
        TableColumn columnaCantidad = jTable1.getColumn("CANTIDAD");
        columnaCantidad.setMinWidth(110);
        columnaCantidad.setMaxWidth(110);
        
        TableColumn columnaPU = jTable1.getColumn("PRECIO UNIT.");
        columnaPU.setMinWidth(130);
        columnaPU.setMaxWidth(130);
        
        TableColumn columnaDescuento = jTable1.getColumn("DESCUENTO");
        columnaDescuento.setMinWidth(110);
        columnaDescuento.setMaxWidth(110);
        
        TableColumn columnaSubTotal = jTable1.getColumn("SUBTOTAL");
        columnaSubTotal.setMinWidth(110);
        columnaSubTotal.setMaxWidth(110);
        //jTable1.getColumn(2).setPreferredWidth(10);
        //Implementar Reloj
        Reloj reloj = new Reloj(lblFecha);
        reloj.start();
        limpiarTicket();
        if(Util.obtieneFechaDia().compareTo(SesionData.getSesion().getFechaProceso())!=0){
            btnIniciarDia.setEnabled(true);
        }else{
            btnIniciarDia.setEnabled(false);
        }
        txtFiltro.setText("Filtro Productos...");
    }
    
    public static void calculaTotal(){
        BigDecimal cantidad = new BigDecimal(spnCantidad.getValue().toString().trim());
        BigDecimal descuento = BigDecimal.ZERO;
        if(!txtDscto.getText().trim().equals("")){
            descuento=new BigDecimal(txtDscto.getText().trim());
        }
        //BigDecimal monto = ConceptoCobroList.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getPrecioUnitario();
        BigDecimal monto = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;
        monto.setScale(4, RoundingMode.HALF_UP);
        monto=ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getPrecioUnitario();
        total.setScale(4, RoundingMode.HALF_UP);
        total = cantidad.multiply(monto);
        
        if((jcbTipoMoneda.getSelectedItem()!=null) && !(jcbTipoMoneda.getSelectedItem().toString().startsWith("-"))){       
            String tmoneda="";
            TipoCambioVO tipoCambio = TipoCambioDAO.consultarTipoCambio();
            BigDecimal tcambio=new BigDecimal(tipoCambio.getTventa());
            if(jcbTipoMoneda.getSelectedItem().toString().endsWith("S")){
                tmoneda="S";
            }else if(jcbTipoMoneda.getSelectedItem().toString().endsWith("D")){
                tmoneda="D";
                //tcambio = new BigDecimal(lblExchangeRate.getText());
            }
            ConceptoCobro conceptoCobro =  ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex());

            //BigDecimal precioConvertido=conceptoCobro.getPrecioUnitario();
            if(!conceptoCobro.getTipomon().equals(tmoneda)){
                  if(tmoneda.equals("S")){
                      monto= monto.multiply(tcambio);
                      total= total.multiply(tcambio);
                      //this.subtotal = subtotal.multiply(tcambio);
                  }else if(tmoneda.equals("D")){
                      monto= monto.divide(tcambio,4, RoundingMode.HALF_UP);
                      total= total.divide(tcambio,4, RoundingMode.HALF_UP);
                      //this.subtotal = subtotal.divide(tcambio);
                  }
            }
        }
        BigDecimal descItem= BigDecimal.ZERO;
        descItem=descuento.multiply(cantidad);
        if(descItem.compareTo(BigDecimal.ZERO)>0){
            total = total.subtract(descItem);
        }
        lblPrecioUnitario.setText(Util.formatDecimal(monto.doubleValue()));
        lblSubTotal.setText(Util.formatDecimal(total.doubleValue()));
    }
    
    public static void calculaTotal2(){
        BigDecimal cantidad = new BigDecimal(spnCantidad.getValue().toString().trim());
        //BigDecimal monto = ConceptoCobroList.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getPrecioUnitario();
        BigDecimal monto = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;
        monto.setScale(4, RoundingMode.HALF_UP);
        monto=ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getPrecioUnitario();
        total.setScale(4, RoundingMode.HALF_UP);
        total = cantidad.multiply(monto);
        
        if((jcbTipoMoneda.getSelectedItem()!=null) && !(jcbTipoMoneda.getSelectedItem().toString().startsWith("-"))){       
            String tmoneda="";
            TipoCambioVO tipoCambio = TipoCambioDAO.consultarTipoCambio();
            BigDecimal tcambio=new BigDecimal(tipoCambio.getTventa());
            if(jcbTipoMoneda.getSelectedItem().toString().endsWith("S")){
                tmoneda="S";
            }else if(jcbTipoMoneda.getSelectedItem().toString().endsWith("D")){
                tmoneda="D";
                //tcambio = new BigDecimal(lblExchangeRate.getText());
            }
            ConceptoCobro conceptoCobro =  ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex());

            //BigDecimal precioConvertido=conceptoCobro.getPrecioUnitario();
            if(!conceptoCobro.getTipomon().equals(tmoneda)){
                  if(tmoneda.equals("S")){
                      monto= monto.multiply(tcambio);
                      total= total.multiply(tcambio);
                      //this.subtotal = subtotal.multiply(tcambio);
                  }else if(tmoneda.equals("D")){
                      monto= monto.divide(tcambio,4, RoundingMode.HALF_UP);
                      total= total.divide(tcambio,4, RoundingMode.HALF_UP);
                      //this.subtotal = subtotal.divide(tcambio);
                  }
            }
        }
        
        lblPrecioUnitario.setText(Util.formatDecimal(monto.doubleValue()));
        lblSubTotal.setText(Util.formatDecimal(total.doubleValue()));
    }
    
    private void jcbTipoConceptoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTipoConceptoItemStateChanged
        // TODO add your handling code here:
        if(jcbTipoConcepto.getModel().getSize()>0){
            calculaTotal();
        }
    }//GEN-LAST:event_jcbTipoConceptoItemStateChanged

    private void spnCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCantidadStateChanged
        // TODO add your handling code here:
        if(jcbTipoConcepto.getModel().getSize()>0){
            TipoCambioVO tipoCambio = TipoCambioDAO.consultarTipoCambio();
            if(tipoCambio==null){
                JOptionPane.showMessageDialog(null, "POR FAVOR SELECCIONE TIPO DE MONEDA", "DmPos", JOptionPane.WARNING_MESSAGE);
                jcbTipoMoneda.requestFocus();
                //spnCantidad.setValue(0);
                return;
            }
            calculaTotal();
        }
    }//GEN-LAST:event_spnCantidadStateChanged

    private void seleccionarMedioPago(){
        String codVendedor= jcbVendedor.getSelectedItem().toString();
        if(codVendedor.startsWith("-")){
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE VENDEDOR", "DmPos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(FormFormaPago==null){
            FormFormaPago = new ForrFormaPago();
            
            txtTotalPagar.setText(Util.formatDecimal(ticket.getTotal().doubleValue()));
            FormFormaPago.calculaMonto();
            FormFormaPago.seleccionaMoneda();  
            //FormFormaPago.inicializa();
            FormFormaPago.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            FormFormaPago.setLocationRelativeTo(null);
            FormFormaPago.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            FormFormaPago.setVisible(true);
        }else{
            txtTotalPagar.setText(Util.formatDecimal(ticket.getTotal().doubleValue()));
            FormFormaPago.calculaMonto();
            FormFormaPago.seleccionaMoneda();
            //FormFormaPago.inicializa();
            FormFormaPago.setVisible(true);
        }
    }
    
    
    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        String valor= jcbTipoDocumento.getSelectedItem().toString();
        String valorSeleccionado[] = valor.split(" - ");
        if(valorSeleccionado[0].equals("01")){
            if((txtCliente.getText().trim().equals(""))){
                JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE NOMBRE DEL CLIENTE", "DmPos", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if((txtRUCDNI.getText().trim().equals(""))){
                JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE RUC DEL CLIENTE", "DmPos", JOptionPane.WARNING_MESSAGE);
                return;
            }            
            if((txtRUCDNI.getText().length()<10)){
                JOptionPane.showMessageDialog(null, "EL NUMERO DE DOCUMENTO NO CORRESPONDE A UN RUC", "DmPos", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if((txtDireccionP.getText().trim().equals(""))){
                JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE DIRECCIÓN DEL CLIENTE", "DmPos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        if(valorSeleccionado[0].equals("07")){
             JOptionPane.showMessageDialog(null, "OPERACIÓN NO PERMITIDA", "DmPos", JOptionPane.WARNING_MESSAGE);
             return;
        }
        if(ticket.getDetalleTicket().size() <= 0){
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE EL DETALLE", "DmPos", JOptionPane.WARNING_MESSAGE);
            spnCantidad.requestFocus();
            return;
        }        
        if(jcbTipoMoneda.getSelectedItem().toString().startsWith("-")){
            JOptionPane.showMessageDialog(null, "POR FAVOR SELECCIONE TIPO DE MONEDA", "DmPos", JOptionPane.WARNING_MESSAGE);
            jcbTipoMoneda.requestFocus();
            return;            
        }else if (jcbTipoMoneda.getSelectedItem().toString().startsWith("D")){
            if(lblExchangeRate.getText().length()==0){
               JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE TIPO DE CAMBIO PARA EL DIA DE HOY", "DmPos", JOptionPane.WARNING_MESSAGE);
               btnExchangeRate.requestFocus();
               return;  
            }
        }
        btnImprimir.setEnabled(false);
        try{
            completaTicket();//se completan los datos para el ticket
            int i=0;
            //jcastillo inicio
            /*while(i<SesionData.getSesion().getImpresiones()){
                if(i==0){
                    imprimir(false);
                }else{
                    imprimir(true);
                }
                i++;
            }*/
            //jcastillo inicio
            grabarDataTickets();//jcastillo creacion de archivo txt para Facturacion Electrónica
            aumentaSerieNumero();
            //grabarDataUsers();
            limpiarTicket();
            inicializaTablasFormaPago();
            FormFormaPago.limpiaTabla();
            jcbVendedor.setSelectedIndex(0);
            jcbTipoConcepto.setSelectedIndex(0);
        }catch(Exception ex){
            ex.printStackTrace();
        } 
        
        
        
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void inicializaTablasFormaPago(){
        totalTemporal = BigDecimal.ZERO;
        if(jTable1.getRowCount()==0){
            jButton1.setEnabled(false);
        }else{
            jButton1.setEnabled(true);
        }
    }
    private void completaTicket(){
        ClienteVO clienteVO;
        clienteVO = ClienteData.getClientexNumDoc(txtRUCDNI.getText());
        if(clienteVO!=null){
            ticket.setNombreCliente(clienteVO.getCLIENOM().toUpperCase());
            ticket.setIdentificacionCliente(clienteVO.getCLIERUC());
            ticket.setDireccionCliente(clienteVO.getCLIEDIR().toUpperCase());         
            SesionData.getSesion().setClaseAux(clienteVO.getTcliente());
        }else{
            ticket.setNombreCliente(txtCliente.getText().trim().toUpperCase());
            ticket.setIdentificacionCliente(txtRUCDNI.getText().trim());
            ticket.setDireccionCliente(txtDireccionP.getText().trim().toUpperCase());            
        }
        ticket.setFecha(SesionData.getSesion().getFechaProceso());
    }
    
    private void imprimir(boolean copia){
        try{
            int limit = Util.getLimitLine();
            DirectPrinterT88V printer = new DirectPrinterT88V();
            printer.initialize();
            printer.setCondensedHib(1);
            printer.setCenterAlignCommand();
            printer.setBoldOn();
            printer.println(" DERRAMA MAGISTERIAL");
            printer.setBoldOff();
            printer.println("Av.Gregorio Escobedo 598 Jesus Maria");
            printer.println(SesionData.getSesion().getCompania());
            printer.println(SesionData.getSesion().getDireccionCompania());
            printer.println("RUC: 20136424867");
            printer.printLine();
            printer.setBoldOn();
            //printer.setLeftAlignCommand();
            printer.println(" SERIE No: " + SesionData.getSesion().getSerial() );
            printer.println(" TICKET No: " + Util.completarIzquierda(3,ticket.getSerie()+"", "0")+" - "+Util.completarIzquierda(8,ticket.getNumero()+"", "0"));
            printer.println("FECHA: " + ticket.getFecha());
            printer.setBoldOff();
            printer.printLine();
            printer.setLeftAlignCommand();
            printer.println(Util.completarDerecha(limit,"CLIENTE: " + ticket.getNombreCliente()));
            printer.println(Util.completarDerecha(limit,"RUC/DNI: " + ticket.getIdentificacionCliente()));
            printer.println(Util.completarDerecha(limit,"DIRECCION: " + ticket.getDireccionCliente()));
            printer.setCenterAlignCommand();
            printer.printLine();
            if(SesionData.getSesion().getModelo().trim().compareTo("TM-T88V")==0){
                printer.println("CODIGO           CONCEPTO          P.UNIT.  CANT  TOTAL");
            }
            if(SesionData.getSesion().getModelo().trim().compareTo("TM-U220")==0){
                printer.println("CODIGO    CONCEPTO   P.UNIT. CANT  TOTAL");
            }
            printer.printLine();
            printer.setLeftAlignCommand();
            for(DetalleTicket temp :ticket.getDetalleTicket()){
                if(SesionData.getSesion().getModelo().trim().compareTo("TM-T88V")==0){
                    printer.println(
                            Util.completarIzquierda(8, temp.getConceptoCobro().getTipo()+"") + 
                            " "+Util.completarDerecha(24, temp.getConceptoCobro().getConcepto()) + 
                            Util.completarIzquierda(7, Util.formatDecimal(temp.getConceptoCobro().getPrecioUnitario().doubleValue())) + 
                            Util.completarIzquierda(6, temp.getCantidad()+"") + 
                            Util.completarIzquierda(8, Util.formatDecimal(temp.getSubtotal().doubleValue()))
                    );
                }
                if(SesionData.getSesion().getModelo().trim().compareTo("TM-U220")==0){
                    printer.println(
                            Util.completarIzquierda(8, temp.getConceptoCobro().getTipo()+"") + 
                            " "+Util.completarDerecha(13, temp.getConceptoCobro().getConcepto()) + 
                            Util.completarIzquierda(6, Util.formatDecimal(temp.getConceptoCobro().getPrecioUnitario().doubleValue())) + 
                            Util.completarIzquierda(5, temp.getCantidad()+"") + 
                            Util.completarIzquierda(7, Util.formatDecimal(temp.getSubtotal().doubleValue()))
                    );
                }
            }
            printer.printLine();
            if(SesionData.getSesion().getModelo().trim().compareTo("TM-T88V")==0){
                printer.setRightAlignCommand();
            }
            printer.println(
                    Util.completarIzquierda(limit,
                    "SUB TOTAL S/." + Util.completarIzquierda(8, Util.formatDecimal(ticket.getTotal().subtract(ticket.getMontoIgv()).doubleValue()))));
            printer.println(
                    Util.completarIzquierda(limit,
                    "IGV S/." + Util.completarIzquierda(8, Util.formatDecimal(ticket.getMontoIgv().doubleValue()))));
            printer.println(Util.completarIzquierda(limit,"---------------------"));
            printer.println(
                    Util.completarIzquierda(limit,
                    "TOTAL S/." + Util.completarIzquierda(8, Util.formatDecimal(ticket.getTotal().doubleValue()))));
            printer.printLine();
            printer.println(NumberToLetterConverter.convertNumberToLetter(ticket.getTotal().doubleValue()));
            printer.printLine();        
            if(SesionData.getSesion().getModelo().trim().compareTo("TM-T88V")==0){
                printer.setCenterAlignCommand();
            }
            printer.println("Cajero: "+UsuarioData.getUsuario().getUsuario());
            printer.println(Util.obtieneFechaDiaHora());
            printer.printLine();
            if(copia){
                printer.println("*** Copia ***");
            }
            printer.println("    \n");
            printer.println("    \n");
            printer.println("    \n");
            printer.println("    \n");
            printer.println("    \n");
            if(SesionData.getSesion().getModelo().trim().compareTo("TM-T88V")==0){
                printer.setCute();
            }
            printer.printHibrida(SesionData.getSesion().getImpresora()); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void grabarDataTickets(){
        try{
            /*File fileCab = Util.validaArchivoTicket(TipoArchivo.DM.getTipo());
            File fileDet = Util.validaArchivoTicket(TipoArchivo.DMD.getTipo());*/
            //jcastilo inicio
            
            //Esto se tiene que descomentar porque es para generar la facturacion electronica en la IP indicada
            //File fileFactElec = Util.validaArchivoTicket(TipoArchivo.TXT.getTipo());
            File fileFactElecLocal = Util.validaArchivoTicket(TipoArchivo.TXTLocal.getTipo());
            
            //jcastilo fin
            /*writeCabecera(fileCab);
            writeDetalle(fileDet);*/            
            writeCabeceraBD();
            writeDetalleBD();
            try{
                 //writeFactElec(fileFactElec);                
            }finally{
                switch(UsuarioData.getUsuario().getEmpresa()){
                    case "1": writeFactElec(fileFactElecLocal);
                              break;
                        
                    case "2": writeFactElecCrisol(fileFactElecLocal);
                              break;
                }
                //writeFactElec(fileFactElecLocal);
            }    
            
            /*if(writeCabeceraBD().equalsIgnoreCase("ok")){
                if(writeDetalleBD().equalsIgnoreCase("ok")){
                    try{
                        writeFactElec(fileFactElec);                
                    }finally{
                       writeFactElec(fileFactElecLocal);
                    }    
                }                    
            }*/
            //HISTORICOS
            /*String name = SesionData.getSesion().getIdcompania() + 
                    SesionData.getSesion().getTienda() + 
                    SesionData.getSesion().getPtoventa() + 
                    SesionData.getSesion().getFechaProceso().replaceAll("/", "");
            File fileCabHis = Util.validaArchivoTicket(TipoArchivo.DM.getTipo(), name);
            File fileDetHis = Util.validaArchivoTicket(TipoArchivo.DMD.getTipo(), name);
            writeCabecera(fileCabHis);
            writeDetalle(fileDetHis);*/
            
            //jcastilo inicio
            /*try{
                writeFactElec(fileFactElec);                
            }finally{
               writeFactElec(fileFactElecLocal);
            } */           
            //jcastillo fin           
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void aumentaSerieNumero(){
        try{
            String valor =jcbTipoDocumento.getSelectedItem().toString();            
            String valorSeleccionado[] = valor.split(" - ");
            VentasDAO ventasDAO = new VentasDAO();
            if(ventasDAO.aumentaSerieNumero(valorSeleccionado[0], ticket.getNumero(),UsuarioData.getUsuario().getEmpresa(),UsuarioData.getUsuario().getTienda(),UsuarioData.getUsuario().getPtoVenta())){
               SesionData.getSesion().setSerie(ticket.getSerie());
               SesionData.getSesion().setNumero(ticket.getNumero()+1);
            }else{
                JOptionPane.showMessageDialog(null, "NO SE PUDO GENERAR NUEVO NUMERO DE SERIE", "DmPos", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void grabarDataUsers(){
        try{
            File fileUser = Util.validaArchivoTicket(TipoArchivo.DAT.getTipo());
            Util.writeUserdata(fileUser);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void limpiarTicket(){
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            modelo.removeRow(i);
            i-=1;
        }
        ticket = new Ticket();
        lblFechaProceso.setText("FECHA PROCESO: "+SesionData.getSesion().getFechaProceso());
        lblTurno.setText("TURNO: "+Util.completarIzquierda(8, SesionData.getSesion().getTurno()+"", "0").toUpperCase());
        lblTurno.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTotal.setText("");
        lblContadorDscto.setText("");
        lblContadorIGV.setText("");
        lblContadorSubTotal.setText("");
        
        sumaDesc=BigDecimal.ZERO;
        sumaIGV=BigDecimal.ZERO;
        sumaSubtotalIgv=BigDecimal.ZERO;
        //jcastillo inicio  
//        lblTicket.setText(
//                Util.completarIzquierda(3, ticket.getSerie()+"", "0")
//                +"-"+ 
//                Util.completarIzquierda(8, ticket.getNumero()+"", "0"));
        lblTicket.setText(
                ticket.getSerie()
                +"-"+ 
                Util.completarIzquierda(8, ticket.getNumero()+"", "0"));
        //jcastillo fin
        txtCliente.setText(CLIENTE_OTROS);
        txtRUCDNI.setText("");
        txtDireccionP.setText("");
        spnCantidad.setValue(0);
        btnImprimir.setEnabled(false);
        jcbTipoDocumento.setSelectedIndex(indexComboTipoDocumento);        
    }
    
    private void writeCabecera(File file) throws IOException{
        FileWriter escribir = null;
        try{
            escribir = new FileWriter(file, true);
            escribir.write(SesionData.getSesion().getIdcompania()+Util.FILE_DELIMITADOR);//0
            escribir.write(SesionData.getSesion().getIdlocalidad()+Util.FILE_DELIMITADOR);
            escribir.write(SesionData.getSesion().getAlmacen()+Util.FILE_DELIMITADOR);
            escribir.write(SesionData.getSesion().getCodigoCliente()+Util.FILE_DELIMITADOR);
            escribir.write(SesionData.getSesion().getListaPrecios()+Util.FILE_DELIMITADOR);
            escribir.write(SesionData.getSesion().getClaseAux()+Util.FILE_DELIMITADOR);
            escribir.write(SesionData.getSesion().getTipoDocumento()+Util.FILE_DELIMITADOR);
            //jcastillo inicio
            //escribir.write(Util.completarIzquierda(3, ""+ticket.getSerie(), "0") +Util.FILE_DELIMITADOR);
            escribir.write(ticket.getSerie() +Util.FILE_DELIMITADOR);
            //jcastillo fin 
            escribir.write(Util.completarIzquierda(8, ""+ticket.getNumero(), "0") +Util.FILE_DELIMITADOR);
            escribir.write(SesionData.getSesion().getFechaProceso()+Util.FILE_DELIMITADOR);//9
            escribir.write(UsuarioData.getUsuario().getUsuario()+Util.FILE_DELIMITADOR);
            escribir.write(SesionData.getSesion().getFormaPago()+Util.FILE_DELIMITADOR);
            escribir.write(SesionData.getSesion().getTipoMoneda()+Util.FILE_DELIMITADOR);
            escribir.write(SesionData.getSesion().getTipoVenta()+Util.FILE_DELIMITADOR);
            escribir.write(ticket.getTotal().subtract(ticket.getMontoIgv())+Util.FILE_DELIMITADOR);
            escribir.write(ticket.getTotal().subtract(ticket.getMontoIgv())+Util.FILE_DELIMITADOR);
            escribir.write(BigDecimal.ZERO+Util.FILE_DELIMITADOR);
            escribir.write(ticket.getEstado()+Util.FILE_DELIMITADOR);
            escribir.write(UsuarioData.getUsuario().getUsuario()+Util.FILE_DELIMITADOR);
            escribir.write(Util.obtieneFechaDia()+Util.FILE_DELIMITADOR);//19
            escribir.write(Util.obtieneFechaDiaHora()+Util.FILE_DELIMITADOR);
            escribir.write(Util.obtieneYYYYMMDD().substring(0, 6)+Util.FILE_DELIMITADOR);
            escribir.write(BigDecimal.ZERO+Util.FILE_DELIMITADOR);
            escribir.write(ticket.getMontoIgv()+Util.FILE_DELIMITADOR);
            escribir.write(ticket.getMontoIgv()+Util.FILE_DELIMITADOR);
            escribir.write(BigDecimal.ZERO+Util.FILE_DELIMITADOR);
            escribir.write(ticket.getTotal()+Util.FILE_DELIMITADOR);
            escribir.write(ticket.getTotal()+Util.FILE_DELIMITADOR);
            escribir.write(BigDecimal.ZERO+Util.FILE_DELIMITADOR);
            escribir.write(SesionData.getSesion().getTipoCliente()+Util.FILE_DELIMITADOR);//29
            escribir.write((ticket.getNombreCliente().trim().compareTo("")==0?CLIENTE_OTROS:ticket.getNombreCliente())+Util.FILE_DELIMITADOR);
            escribir.write(SesionData.getSesion().getIgvPorcentaje()+Util.FILE_DELIMITADOR);
            escribir.write((ticket.getIdentificacionCliente().trim().compareTo("")==0?" ":ticket.getIdentificacionCliente())+Util.FILE_DELIMITADOR);
            escribir.write((ticket.getDireccionCliente().trim().compareTo("")==0?" ":ticket.getDireccionCliente())+"\n");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            escribir.close();
        }
    }
    VentasCabeceraVO ventasCabeceraVO = new VentasCabeceraVO();
    private String writeCabeceraBD() throws IOException{
        String resultado="ok";
        try{            
            //VentasCabeceraVO ventasCabeceraVO = new VentasCabeceraVO();
            VentasDAO ventasDAO = new VentasDAO();
            ventasCabeceraVO.setIDCOMPANIA(UsuarioData.getUsuario().getEmpresa());
            SesionData.getSesion().setCiaid(UsuarioData.getUsuario().getEmpresa());
            
            String valorTipDoc =jcbTipoDocumento.getSelectedItem().toString();            
            String valorSeleccionado[] = valorTipDoc.split(" - ");
            ventasCabeceraVO.setTIPODOCUMENTO(valorSeleccionado[0]);
            SesionData.getSesion().setTipoDocumento(valorSeleccionado[0]);
            
            ventasCabeceraVO.setSERIE(ticket.getSerie());
            ventasCabeceraVO.setNUMERO(Util.completarIzquierda(8, ""+ticket.getNumero(), "0") );
            ventasCabeceraVO.setFECHAPROCESO(SesionData.getSesion().getFechaProceso());
            ventasCabeceraVO.setIDLOCALIDAD(SesionData.getSesion().getIdlocalidad());
            ventasCabeceraVO.setTINID("21");
            ventasCabeceraVO.setALMACEN(SesionData.getSesion().getAlmacen());
            ventasCabeceraVO.setPVTAID(UsuarioData.getUsuario().getPtoVenta());
            ventasCabeceraVO.setLISTAPRECIOS(SesionData.getSesion().getListaPrecios());
            ventasCabeceraVO.setCODIGOCLIENTE(SesionData.getSesion().getCodigoCliente());
            ventasCabeceraVO.setCLASEAUX(SesionData.getSesion().getClaseAux());
            ventasCabeceraVO.setCLIERUC((ticket.getIdentificacionCliente().trim().compareTo("")==0?"00000000":ticket.getIdentificacionCliente()));//si no ingresa ruc le pone el codigo de cliente genérico
            ventasCabeceraVO.setTURNO(SesionData.getSesion().getTurno());
            ventasCabeceraVO.setVEID(UsuarioData.getVendedorByIndex(jcbVendedor.getSelectedIndex()).getUsuario());//codigo del vendedor
            ventasCabeceraVO.setFORMAPAGO(SesionData.getSesion().getFormaPago());
            String tmoneda="";
            if(jcbTipoMoneda.getSelectedItem().toString().endsWith("S")){
                tmoneda="S";
            }else if(jcbTipoMoneda.getSelectedItem().toString().endsWith("D")){
                tmoneda="D";
                //tcambio = new BigDecimal(lblExchangeRate.getText());
            }
            ventasCabeceraVO.setTIPOMONEDA(tmoneda);//tipo moneda
            SesionData.getSesion().setTipoMoneda(tmoneda);
                    
            ventasCabeceraVO.setTIPOVENTA(SesionData.getSesion().getTipoVenta());
            TipoCambioVO tipoCambio = TipoCambioDAO.consultarTipoCambio();
            BigDecimal tcambio=new BigDecimal(tipoCambio.getTventa());
            if(tmoneda.equals("S")){
                BigDecimal montoSoles= ticket.getTotal().subtract(ticket.getMontoIgv());
                BigDecimal montoDolares= montoSoles.divide(tcambio, 4, RoundingMode.HALF_UP);
                ventasCabeceraVO.setFACMTOMO(montoSoles);
                ventasCabeceraVO.setFACMTOMN(montoSoles);
                ventasCabeceraVO.setFACMTOME(montoDolares);
            }else if(tmoneda.equals("D")){
                BigDecimal montoDolares= ticket.getTotal().subtract(ticket.getMontoIgv());
                BigDecimal montoSoles= montoDolares.multiply(tcambio);
                ventasCabeceraVO.setFACMTOMO(montoSoles);
                ventasCabeceraVO.setFACMTOMN(montoSoles);
                ventasCabeceraVO.setFACMTOME(montoDolares);
            }
            
            ventasCabeceraVO.setFACESTADO(ticket.getEstado());
            ventasCabeceraVO.setFACDCTOMO(BigDecimal.ZERO);
            ventasCabeceraVO.setFACDCTOMN(BigDecimal.ZERO);
            ventasCabeceraVO.setFACDCTOME(BigDecimal.ZERO);
            ventasCabeceraVO.setFACUSER(UsuarioData.getUsuario().getUsuario());
            ventasCabeceraVO.setFACFREG(Util.obtieneFechaDia());
            ventasCabeceraVO.setFACHREG(Util.obtieneFechaDiaHora());
            ventasCabeceraVO.setFACANOMES(Util.obtieneYYYYMMDD().substring(0, 6));
            
            ventasCabeceraVO.setFACTCAM(tcambio);//tipo cambio
            ventasCabeceraVO.setFACFLAGD("N");
            if(tmoneda.equals("S")){
                BigDecimal montoSoles=ticket.getMontoIgv();
                BigDecimal montoDolares=montoSoles.divide(tcambio, 4,RoundingMode.HALF_UP);
                ventasCabeceraVO.setFACIGVMO(montoSoles);
                ventasCabeceraVO.setFACIGVMN(montoSoles);
                ventasCabeceraVO.setFACIGVME(montoDolares);        
            }else if(tmoneda.equals("D")){
                BigDecimal montoDolares=ticket.getMontoIgv();
                BigDecimal montoSoles=montoDolares.multiply(tcambio);
                ventasCabeceraVO.setFACIGVMO(montoSoles);
                ventasCabeceraVO.setFACIGVMN(montoSoles);
                ventasCabeceraVO.setFACIGVME(montoDolares); 
            }          
            
            ventasCabeceraVO.setFACISCMO(BigDecimal.ZERO);
            ventasCabeceraVO.setFACISCMN(BigDecimal.ZERO);
            ventasCabeceraVO.setFACISCME(BigDecimal.ZERO);
            
            if(tmoneda.equals("S")){
                BigDecimal montoSoles=ticket.getTotal();
                BigDecimal montoDolares=montoSoles.divide(tcambio, 4,RoundingMode.HALF_UP);
                ventasCabeceraVO.setFACTOTMO(montoSoles);
                ventasCabeceraVO.setFACTOTMN(montoSoles);
                ventasCabeceraVO.setFACTOTME(montoDolares);        
            }else if(tmoneda.equals("D")){
                BigDecimal montoDolares=ticket.getTotal();
                BigDecimal montoSoles=montoDolares.multiply(tcambio);
                ventasCabeceraVO.setFACTOTMO(montoSoles);
                ventasCabeceraVO.setFACTOTMN(montoSoles);
                ventasCabeceraVO.setFACTOTME(montoDolares);  
            }
            
            ventasCabeceraVO.setFACTIP("N");
            ventasCabeceraVO.setTIPPERID("00");
            ventasCabeceraVO.setFACDSCTO1(BigDecimal.ZERO);
            ventasCabeceraVO.setFACIMPREP("S");
            ventasCabeceraVO.setFACFEVCMTO(null);//vacio
            ventasCabeceraVO.setFACTCLI(SesionData.getSesion().getTipoCliente());
            ventasCabeceraVO.setFACTDES(ticket.getNombreCliente().trim().compareTo("")==0?CLIENTE_OTROS:ticket.getNombreCliente());
            ventasCabeceraVO.setCLIEDIR(ticket.getDireccionCliente().trim().compareTo("")==0?" ":ticket.getDireccionCliente());
            ventasCabeceraVO.setTIPOADQ("C");
            ventasCabeceraVO.setFACIGV2MN(BigDecimal.ZERO);
            ventasCabeceraVO.setFACIGV2MO(BigDecimal.ZERO);
            ventasCabeceraVO.setFACIGV2ME(BigDecimal.ZERO);
            ventasCabeceraVO.setINICIAL(BigDecimal.ZERO);
            ventasCabeceraVO.setFACSERMO(BigDecimal.ZERO);
            ventasCabeceraVO.setFACSERMN(BigDecimal.ZERO);
            ventasCabeceraVO.setFACSERME(BigDecimal.ZERO);
            ventasCabeceraVO.setPORIGV(SesionData.getSesion().getIgvPorcentaje());
            ventasCabeceraVO.setPORSER(BigDecimal.ZERO);
            
            ventasCabeceraVO.setFACMTOGRAV(ticket.getMontoGravado());//subtotal gravado
            ventasCabeceraVO.setFACMTOEXO(ticket.getMontoExonerado());//subtotal exonerado
            ventasCabeceraVO.setFACMTOINA(ticket.getMontoInafecto());//subtotal inafecto
            ventasCabeceraVO.setFACMTOGRAT(BigDecimal.ZERO);//Subtotal Transferencia Gratuita
            ventasCabeceraVO.setTIPOPERACION("01");//venta interna
            
            if(!ventasDAO.insertaCabeceraVentas(ventasCabeceraVO)){
                resultado="";
                JOptionPane.showMessageDialog(null, "NO SE PUDO GRABAR LA CABECERA DE LA VENTA", "DmPos", JOptionPane.ERROR_MESSAGE);
            }
            //descomentar al momento de pasarlo
            
            if(UsuarioData.getUsuario().getEmpresa().equals("1")){
                if(!ventasDAO.insertaCabeceraOracleVentas(ventasCabeceraVO)){
                    resultado="";
                    JOptionPane.showMessageDialog(null, "NO SE PUDO GRABAR LA CABECERA DE LA VENTA EN OASIS", "DeMaTicket", JOptionPane.ERROR_MESSAGE);
                }else if(!ventasDAO.actualizaCabeceraVentas(ventasCabeceraVO)){
                        resultado="";
                        JOptionPane.showMessageDialog(null, "NO SE PUDO ACTUALIZAR ESTADO DE LA CABECERA DE LA VENTA", "DeMaTicket", JOptionPane.ERROR_MESSAGE);
                }          
            }
        }catch(Exception ex){
            resultado="";
            ex.printStackTrace();
        }
        return resultado;
    }
    //jcastillo inicio
    private void writeFactElecCrisol(File file) throws IOException{
        FileWriter escribir = null;
        String mensajes[]=null;
        try{
            escribir = new FileWriter(file, true);
            int i=1;
                // cabecera del archivo
                escribir.write(Util.FILE_CAB1_CRISOL);//0
                escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write(SesionData.getSesion().getTipoDocumento());
                escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write(ticket.getSerie()+"-"+Util.completarIzquierda(8, ""+ticket.getNumero(), "0"));
                for(int z=0; z<4;z++) escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write(SesionData.getSesion().getFechaProceso().replaceAll("/", "-"));
                escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write((SesionData.getSesion().getTipoMoneda().equals("S")?"PEN":"USD"));
                escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write(SesionData.getSesion().getRucDerrama());//ruc crisol
                escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write("6");//
                escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write(SesionData.getSesion().getCompania());//nombre crisol
                escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write(SesionData.getSesion().getNombDerrama());//razon social
                escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write(SesionData.getSesion().getUbgDerrama());//ubigeo crisol
                escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write(SesionData.getSesion().getDirecDerrama());//direccion fiscal
                escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write(SesionData.getSesion().getPrvDerrama());//
                escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write(SesionData.getSesion().getDepDerrama());//
                escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write(SesionData.getSesion().getDstDerrama());//
                escribir.write(Util.FILE_DELIMITADOR);//0
                if(txtCliente.getText().equalsIgnoreCase("otros")){
                    escribir.write(Util.FILE_DELIMITADOR);//0
                    escribir.write(Util.FILE_DELIMITADOR);//0
                }else{
                     escribir.write((ticket.getIdentificacionCliente().trim().compareTo("")==0?"":ticket.getIdentificacionCliente()));
                     escribir.write(Util.FILE_DELIMITADOR);//0
                     escribir.write(SesionData.getSesion().getTipDocSunat());//
                     escribir.write(Util.FILE_DELIMITADOR);//0
                }
                escribir.write(ticket.getNombreCliente().trim().compareTo("")==0?"":ticket.getNombreCliente());
                escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write(txtDireccionP.getText());
                escribir.write(Util.FILE_DELIMITADOR);//0
                //bdTest = bdTest.setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal monto1 = (BigDecimal) (ticket.getMontoIgv()==BigDecimal.ZERO?BigDecimal.ZERO:ticket.getTotal().subtract(ticket.getMontoIgv()));
                monto1=monto1.setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal monto2 = (BigDecimal) ticket.getMontoIgv();
                monto2=monto2.setScale(2, BigDecimal.ROUND_HALF_UP);
                escribir.write(monto1+Util.FILE_DELIMITADOR+monto2);
                for(int z=0; z<3;z++) escribir.write(Util.FILE_DELIMITADOR);//0
                
                BigDecimal montot =ticket.getTotal();
                montot=montot.setScale(2, BigDecimal.ROUND_HALF_UP);
                if(ticket.getMontoGravado().compareTo(BigDecimal.ZERO) > 0){
                    escribir.write(montot+Util.FILE_DELIMITADOR+"1001");
                }else{
                    escribir.write(montot+Util.FILE_DELIMITADOR+"1003");
                }                
                escribir.write(Util.FILE_DELIMITADOR);
                escribir.write(monto1+Util.FILE_DELIMITADOR);
                escribir.write((ticket.getIdentificacionCliente().trim().compareTo("")==0?"":ticket.getIdentificacionCliente()));
                escribir.write(Util.FILE_DELIMITADOR);
                escribir.write(SesionData.getSesion().getTipDocSunat());//falta corregir es el tipo de documento osea dni
                for(int z=0; z<33;z++) escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write("01");
                escribir.write(Util.FILE_DELIMITADOR+"\n");
                
                //cabecera 2
                escribir.write(Util.FILE_CAB2_CRISOL);
                if(ticket.getMontoGravado().compareTo(BigDecimal.ZERO) > 0){
                    escribir.write(Util.FILE_DELIMITADOR+"1001"+Util.FILE_DELIMITADOR+monto1);
                }else{
                    escribir.write(Util.FILE_DELIMITADOR+"1003"+Util.FILE_DELIMITADOR+monto1);
                }   
                for(int z=0; z<2;z++) escribir.write(Util.FILE_DELIMITADOR);//0
                escribir.write("\n");
                
                
                //cabecera 3
                escribir.write(Util.FILE_CAB3_CRISOL);
                escribir.write(Util.FILE_DELIMITADOR);
                escribir.write("1");
                escribir.write(Util.FILE_DELIMITADOR);
                escribir.write("1000");
                escribir.write(Util.FILE_DELIMITADOR);
                String[] numeroToLetras = NumberToLetterConverter.convertNumberToLetter(ticket.getTotal().doubleValue()).split(":");
                escribir.write(numeroToLetras[1].substring(1));
                escribir.write(Util.FILE_DELIMITADOR+"\n");
                
                
                //cabecera 4
                BigDecimal divisorIGV = BigDecimal.ONE.add(SesionData.getSesion().getIgvPorcentaje().divide(new BigDecimal(100)));

                for(DetalleTicket temp: ticket.getDetalleTicket()){
                    escribir.write(Util.FILE_CAB4_CRISOL);
                    escribir.write(Util.FILE_DELIMITADOR+i+Util.FILE_DELIMITADOR);
                    BigDecimal montoCab4 =temp.getConceptoCobro().getPrecioUnitario();
                    montoCab4=montoCab4.setScale(2, BigDecimal.ROUND_HALF_UP);
                    escribir.write(montoCab4+Util.FILE_DELIMITADOR);
                    escribir.write((temp.getConceptoCobro().getUnimed().equals("UND")?"NIU":"-"));
                    escribir.write(Util.FILE_DELIMITADOR);
                    escribir.write(temp.getCantidad()+Util.FILE_DELIMITADOR);
                   
                    escribir.write((temp.getMontoIgv().compareTo(BigDecimal.ZERO)==0?temp.getConceptoCobro().getPrecioUnitario():((temp.getConceptoCobro().getPrecioUnitario()).divide(divisorIGV,2, RoundingMode.HALF_UP)))+Util.FILE_DELIMITADOR);
                    escribir.write(temp.getConceptoCobro().getTipo());
                    escribir.write(Util.FILE_DELIMITADOR);
                    escribir.write("01");
                    escribir.write(Util.FILE_DELIMITADOR);
                    escribir.write(montoCab4+Util.FILE_DELIMITADOR);
                    escribir.write(montoCab4+Util.FILE_DELIMITADOR+"\n");
                    //cabecera 5
                    escribir.write(Util.FILE_CAB5_CRISOL);
                    escribir.write(Util.FILE_DELIMITADOR);
                    escribir.write(temp.getConceptoCobro().getConcepto());
                    escribir.write(Util.FILE_DELIMITADOR+"\n");
                    //cabecera 6
                    escribir.write(Util.FILE_CAB6_CRISOL);
                    escribir.write(Util.FILE_DELIMITADOR);
                    escribir.write("FALSE");
                    escribir.write(Util.FILE_DELIMITADOR);
                    BigDecimal montoCab6 = BigDecimal.ZERO;
                    montoCab6=montoCab6.setScale(2, BigDecimal.ROUND_HALF_UP);
                    escribir.write(montoCab6+"\n");
                    //cabecera 7
                    escribir.write(Util.FILE_CAB7_CRISOL);
                    escribir.write(Util.FILE_DELIMITADOR);
                    BigDecimal montoIgv = temp.getMontoIgv();
                    montoIgv= montoIgv.setScale(2, BigDecimal.ROUND_HALF_UP);
                    escribir.write(montoIgv+Util.FILE_DELIMITADOR);                    
                    BigDecimal montoItem =(temp.getMontoIgv().compareTo(BigDecimal.ZERO)==0?temp.getSubtotal():(temp.getSubtotal()).subtract(temp.getMontoIgv()));
                    montoItem= montoItem.setScale(2, BigDecimal.ROUND_HALF_UP);
                    escribir.write(montoItem+Util.FILE_DELIMITADOR);
                    escribir.write(montoIgv+Util.FILE_DELIMITADOR);
                    BigDecimal porcIGV= SesionData.getSesion().getIgvPorcentaje();
                    porcIGV= porcIGV.setScale(2, BigDecimal.ROUND_HALF_UP);
                    escribir.write(porcIGV+Util.FILE_DELIMITADOR);
                    escribir.write(Util.FILE_DELIMITADOR);
                    escribir.write("10");
                    escribir.write(Util.FILE_DELIMITADOR);
                    escribir.write(Util.FILE_DELIMITADOR);
                    escribir.write("100");
                    escribir.write(Util.FILE_DELIMITADOR);
                    escribir.write("IGV");
                    escribir.write(Util.FILE_DELIMITADOR);
                    escribir.write("VAT");
                    escribir.write(Util.FILE_DELIMITADOR+"\n");
                    i++;
                    
                }
                //cabecera 8
                escribir.write(Util.FILE_CAB8_CRISOL);
                escribir.write(Util.FILE_DELIMITADOR);
                escribir.write(monto2+Util.FILE_DELIMITADOR+monto2+Util.FILE_DELIMITADOR);
                escribir.write("100");
                escribir.write(Util.FILE_DELIMITADOR);
                escribir.write("IGV");
                escribir.write(Util.FILE_DELIMITADOR);
                escribir.write("VAT");
                escribir.write(Util.FILE_DELIMITADOR+"\n");
                
                //cabecera 9
                escribir.write(Util.FILE_CAB9_CRISOL);
                escribir.write(Util.FILE_DELIMITADOR);
                escribir.write("01");//forma de pago
                escribir.write(Util.FILE_DELIMITADOR);
                escribir.write(SesionData.getSesion().getFechaProceso().replaceAll("/", "-")+"\n");
                
                //cabecera 10
                escribir.write(Util.FILE_CAB10_CRISOL);
                escribir.write(Util.FILE_DELIMITADOR);
                escribir.write("CodEstSUNAT");
                escribir.write(Util.FILE_DELIMITADOR);
                escribir.write("0001 \n");
               
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            escribir.close();
        }
    }
    //jcastillo fin
       private void writeFactElec(File file) throws IOException{
        FileWriter escribir = null;
        String mensajes[]=null;
        try{
            escribir = new FileWriter(file, true);
            int i=1;
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"CODI_EMPR"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getCiaid()+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"TipoDTE"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getTipoDocumento()+"\n");
                //jcastillo inicio
                //escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"Serie"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+(SesionData.getSesion().getTipoDocumento().equals("01")?"F":"B")+Util.completarIzquierda(3, ""+ticket.getSerie(), "0")+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"Serie"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+ticket.getSerie()+"\n");
                //jcastillo fin
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"Correlativo"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+Util.completarIzquierda(8, ""+ticket.getNumero(), "0")+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"FchEmis"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getFechaProceso().replaceAll("/", "-")+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"TipoMoneda"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+(SesionData.getSesion().getTipoMoneda().equals("S")?"PEN":"USD")+"\n");
                //datos emisor
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"RUTEmis"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getRucDerrama()+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"TipoRUCEmis"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+6+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"NomComer"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getNombDerrama()+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"RznSocEmis"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getNombDerrama()+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"ComuEmis"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getUbgDerrama()+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"DirEmis"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getDirecDerrama()+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"UrbanizaEmis"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+""+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"ProviEmis"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getPrvDerrama()+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"DeparEmis"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getDepDerrama()+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"DistriEmis"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getDstDerrama()+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"PaisEmis"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getPais()+"\n");
                //datos receptor
                if(txtCliente.getText().equalsIgnoreCase("otros")){
                    escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"TipoRutReceptor"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+BigDecimal.ZERO+"\n");
                    escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"RUTRecep"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+Util.completarIzquierda(8, "", "0")+"\n");
                }else{
                     escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"TipoRutReceptor"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+1+"\n");
                     escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"RUTRecep"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+(ticket.getIdentificacionCliente().trim().compareTo("")==0?"-":ticket.getIdentificacionCliente())+"\n");   
                }
                
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"RznSocRecep"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+(ticket.getNombreCliente().trim().compareTo("")==0?"-":ticket.getNombreCliente())+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"DirRecepUbigeo"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+""+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"DirRecep"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+(ticket.getDireccionCliente().trim().compareTo("")==0?"-":ticket.getDireccionCliente())+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"DirRecepUrbaniza"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+""+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"DirRecepProvincia"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+""+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"DirRecepDepartamento"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+""+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"DirRecepDistrito"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+""+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"DirRecepCodPais"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+""+"\n");
                
                //BigDecimal montoExe = BigDecimal.ZERO;
                BigDecimal montoExo = BigDecimal.ZERO;
                //BigDecimal montoIGV = BigDecimal.ZERO;
                
                for(DetalleTicket temp: ticket.getDetalleTicket()){    
                   if((temp.getMontoIgv().compareTo(BigDecimal.ZERO))==0){
                      montoExo=montoExo.add(temp.getSubtotal());                       
                   }
                   //montoIGV=montoIGV.add(temp.getMontoIgv());
                }
                //totales
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"MntNeto"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+(ticket.getMontoIgv()==BigDecimal.ZERO?0:ticket.getTotal().subtract(ticket.getMontoIgv()))+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"MntExe"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+BigDecimal.ZERO+"\n");
                //escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"MntExo"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+(ticket.getMontoIgv()==BigDecimal.ZERO?ticket.getTotal().subtract(ticket.getMontoIgv()):0)+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"MntExo"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+montoExo+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"MntTotGrat"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+BigDecimal.ZERO+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"MntTotBoni"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+BigDecimal.ZERO+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"MntTotAnticipo"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+BigDecimal.ZERO+"\n");
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"MntTotal"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+ticket.getTotal()+"\n");//monto total
                escribir.write("A"+Util.FILE_DELIMITADOR_FELOCAL+"ImprDest"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getPrintDestino()+"\n");
                
                escribir.write("A2"+Util.FILE_DELIMITADOR_FELOCAL+"CodigoImpuesto"+Util.FILE_DELIMITADOR_FELOCAL+BigDecimal.ONE+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getCodImpuesto()+"\n");
                escribir.write("A2"+Util.FILE_DELIMITADOR_FELOCAL+"MontoImpuesto"+Util.FILE_DELIMITADOR_FELOCAL+BigDecimal.ONE+Util.FILE_DELIMITADOR_FELOCAL+ticket.getMontoIgv()+"\n");
                escribir.write("A2"+Util.FILE_DELIMITADOR_FELOCAL+"TasaImpuesto"+Util.FILE_DELIMITADOR_FELOCAL+BigDecimal.ONE+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getIgvPorcentaje()+"\n");
                for(DetalleTicket temp: ticket.getDetalleTicket()){                
                    //B
                    escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"NroLinDet"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+i+"\n");
                    escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"QtyItem"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+temp.getCantidad()+"\n");
                    escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"UnmdItem"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+(temp.getConceptoCobro().getUnimed().equals("UND")?"NIU":"-")+"\n");//SesionData.getSesion().getUnidadMedida()
                    escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"VlrCodigo"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+(SesionData.getSesion().getIdcompania()+temp.getConceptoCobro().getTipo())+"\n");
                    escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"NmbItem"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+temp.getConceptoCobro().getConcepto()+"\n");
                    escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"PrcItem"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+temp.getConceptoCobro().getPrecioUnitario()+"\n");
                    
                    //escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"PrcItemSinIgv"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+(temp.getMontoIgv().compareTo(BigDecimal.ZERO)==0?temp.getConceptoCobro().getPrecioUnitario():(temp.getConceptoCobro().getPrecioUnitario()).subtract(temp.getMontoIgv()))+"\n");
                    //escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"PrcItemSinIgv"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+(temp.getMontoIgv().compareTo(BigDecimal.ZERO)==0?temp.getConceptoCobro().getPrecioUnitario():(temp.getConceptoCobro().getPrecioUnitario()).subtract((temp.getConceptoCobro().getPrecioUnitario().multiply(SesionData.getSesion().getIgvPorcentaje().divide(new BigDecimal(100)))).setScale(2, RoundingMode.HALF_UP)))+"\n");
                    BigDecimal divisorIGV = BigDecimal.ONE.add(SesionData.getSesion().getIgvPorcentaje().divide(new BigDecimal(100)));
                    escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"PrcItemSinIgv"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+(temp.getMontoIgv().compareTo(BigDecimal.ZERO)==0?temp.getConceptoCobro().getPrecioUnitario():((temp.getConceptoCobro().getPrecioUnitario()).divide(divisorIGV,2, RoundingMode.HALF_UP)))+"\n");
                    escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"MontoItem"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+(temp.getMontoIgv().compareTo(BigDecimal.ZERO)==0?temp.getSubtotal():(temp.getSubtotal()).subtract(temp.getMontoIgv()))+"\n");
                    
                    escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"DescuentoMonto"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+BigDecimal.ZERO+"\n");
                    escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"IndExe"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+BigDecimal.TEN+"\n");
                    escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"CodigoTipoIgv"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getCodImpuesto()+"\n");
                    escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"TasaIgv"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getIgvPorcentaje()+"\n");
                    escribir.write("B"+Util.FILE_DELIMITADOR_FELOCAL+"ImpuestoIgv"+Util.FILE_DELIMITADOR_FELOCAL+i+Util.FILE_DELIMITADOR_FELOCAL+ temp.getMontoIgv()+"\n");
                    i++;
                }
                //C
                escribir.write("C"+Util.FILE_DELIMITADOR_FELOCAL+"NroLinDR"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+BigDecimal.ONE+"\n");
                escribir.write("C"+Util.FILE_DELIMITADOR_FELOCAL+"TpoMov"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+"R"+"\n");
                escribir.write("C"+Util.FILE_DELIMITADOR_FELOCAL+"ValorDR"+Util.FILE_DELIMITADOR_FELOCAL+Util.FILE_DELIMITADOR_FELOCAL+BigDecimal.ZERO+"\n");
                    
               i=1; 
               mensajes=SesionData.getSesion().getMensajes().split("@");
               for(String mensaje:mensajes){
                   if(i<10){
                    escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"TipoAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+("0"+String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+"01"+"\n");
                    escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"NmrLineasAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+("0"+String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+String.valueOf(i)+"\n");
                   }else{
                    escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"TipoAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+(String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+"01"+"\n");
                    escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"NmrLineasAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+(String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+String.valueOf(i)+"\n");   
                   }
                   if(mensaje.equals("*")){
                       switch(i){
                           case 1:
                               String[] numeroToLetras = NumberToLetterConverter.convertNumberToLetter(ticket.getTotal().doubleValue()).split(":");
                               //escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"DescripcionAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+("0"+String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+NumberToLetterConverter.convertNumberToLetter(ticket.getTotal().doubleValue())+"\n");
                               escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"DescripcionAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+("0"+String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+numeroToLetras[1].substring(1)+"\n");
                               break;
                           case 8:
                               escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"DescripcionAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+("0"+String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getCompania()+"\n");
                               break;
                           case 9:
                               escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"DescripcionAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+("0"+String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getDireccionCompania()+"\n");
                               break;
                           case 10:
                               //escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"DescripcionAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+(String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+SesionData.getSesion().getFechaProceso()+"\n");q
                               escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"DescripcionAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+(String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+Util.obtieneFechaDiaHora()+"\n");
                               break;
                           case 11:
                               escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"DescripcionAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+(String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+UsuarioData.getUsuario().getUsuario()+"\n");
                               break;
                       }
                   }else if (i<10){
                       escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"DescripcionAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+("0"+String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+mensaje+"\n");
                   }else{
                       escribir.write("E"+Util.FILE_DELIMITADOR_FELOCAL+"DescripcionAdicSunat"+Util.FILE_DELIMITADOR_FELOCAL+(String.valueOf(i))+Util.FILE_DELIMITADOR_FELOCAL+mensaje+"\n");
                   }
                   i++;                  
              }
               
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            escribir.close();
        }
    }
    
    
    
    private void writeDetalle(File file) throws IOException{
        FileWriter escribir = null;
        try{
            escribir = new FileWriter(file, true);
            int i=1;
            for(DetalleTicket temp: ticket.getDetalleTicket()){
                escribir.write(SesionData.getSesion().getIdcompania()+Util.FILE_DELIMITADOR);//0
                escribir.write(SesionData.getSesion().getTipoDocumento()+Util.FILE_DELIMITADOR);
                escribir.write(ticket.getSerie()+Util.FILE_DELIMITADOR);
                escribir.write(ticket.getNumero()+Util.FILE_DELIMITADOR);
                escribir.write(i+Util.FILE_DELIMITADOR);
                escribir.write(temp.getConceptoCobro().getTipo()+Util.FILE_DELIMITADOR);
                escribir.write(temp.getConceptoCobro().getConcepto()+Util.FILE_DELIMITADOR);
                escribir.write(SesionData.getSesion().getUnidadMedida()+Util.FILE_DELIMITADOR);
                escribir.write(temp.getCantidad()+Util.FILE_DELIMITADOR);
                escribir.write(temp.getConceptoCobro().getPrecioUnitario()+Util.FILE_DELIMITADOR);//9
                escribir.write(temp.getConceptoCobro().getPrecioUnitario()+Util.FILE_DELIMITADOR);//10
                escribir.write(BigDecimal.ZERO+Util.FILE_DELIMITADOR);
                escribir.write(temp.getSubtotal().subtract(temp.getMontoIgv())+Util.FILE_DELIMITADOR);
                escribir.write(temp.getSubtotal().subtract(temp.getMontoIgv())+Util.FILE_DELIMITADOR);
                escribir.write(BigDecimal.ZERO+Util.FILE_DELIMITADOR);
                escribir.write(Util.obtieneFechaDiaHora()+Util.FILE_DELIMITADOR);//15
                escribir.write(SesionData.getSesion().getIgvPorcentaje()+Util.FILE_DELIMITADOR);
                escribir.write(temp.getMontoIgv()+Util.FILE_DELIMITADOR);
                escribir.write(temp.getSubtotal()+Util.FILE_DELIMITADOR);
                escribir.write(temp.getSubtotal()+Util.FILE_DELIMITADOR);
                escribir.write(BigDecimal.ZERO+Util.FILE_DELIMITADOR);//20
                escribir.write("S"+"\n");
                i++;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            escribir.close();
        }
    }
    private String writeDetalleBD() throws IOException{
        String resultado="ok";
        VentasDetalleVO ventasDetalleVO;
        VentasDAO ventasDAO = new VentasDAO();
        try{
            int i=1;
            String tmonedaVenta="";
            if(jcbTipoMoneda.getSelectedItem().toString().endsWith("S")){
                tmonedaVenta="S";
            }else if(jcbTipoMoneda.getSelectedItem().toString().endsWith("D")){
                tmonedaVenta="D";                    
            }
            TipoCambioVO tipoCambio = TipoCambioDAO.consultarTipoCambio();
            BigDecimal tcambio=new BigDecimal(tipoCambio.getTventa());
            
            for(DetalleTicket temp: ticket.getDetalleTicket()){
                ventasDetalleVO= new VentasDetalleVO();                
                ventasDetalleVO.setIDCOMPANIA(UsuarioData.getUsuario().getEmpresa());
                ventasDetalleVO.setTIPODOCUMENTO(SesionData.getSesion().getTipoDocumento());
                ventasDetalleVO.setSERIE(ticket.getSerie());
                ventasDetalleVO.setNUMERO(Util.completarIzquierda(8, ""+ticket.getNumero(), "0"));
                ventasDetalleVO.setNUMREG(new BigDecimal(i));
                ventasDetalleVO.setCODCON(temp.getConceptoCobro().getTipo());
                ventasDetalleVO.setDESCON(temp.getConceptoCobro().getConcepto());                
                ventasDetalleVO.setUNIDADMEDIDA(temp.getConceptoCobro().getUnimed());
                ventasDetalleVO.setCANTIDAD(new BigDecimal(temp.getCantidad()));
                
                if(temp.getConceptoCobro().getTipomon().equals("S")){
                    BigDecimal montoDolares= temp.getConceptoCobro().getPrecioUnitario().divide(tcambio, 4, RoundingMode.HALF_UP);
                    ventasDetalleVO.setDFACPREUMO(temp.getConceptoCobro().getPrecioUnitario());
                    ventasDetalleVO.setDFACPREUMN(temp.getConceptoCobro().getPrecioUnitario());
                    ventasDetalleVO.setDFACPREUME(montoDolares);
                }else if (temp.getConceptoCobro().getTipomon().equals("D")){
                    BigDecimal montoSoles= temp.getConceptoCobro().getPrecioUnitario().multiply(tcambio);
                    ventasDetalleVO.setDFACPREUMO(temp.getConceptoCobro().getPrecioUnitario());
                    ventasDetalleVO.setDFACPREUMN(montoSoles);
                    ventasDetalleVO.setDFACPREUME(temp.getConceptoCobro().getPrecioUnitario());
                }
//                ventasDetalleVO.setDFACPREUMO(temp.getConceptoCobro().getPrecioUnitario());
//                ventasDetalleVO.setDFACPREUMN(temp.getConceptoCobro().getPrecioUnitario());
//                ventasDetalleVO.setDFACPREUME(BigDecimal.ZERO);
                
//                ventasDetalleVO.setDFACMTOMO(temp.getSubtotal().subtract(temp.getMontoIgv()));
//                ventasDetalleVO.setDFACMTOMN(temp.getSubtotal().subtract(temp.getMontoIgv()));
//                ventasDetalleVO.setDFACMTOME(BigDecimal.ZERO);
                
                BigDecimal venta = temp.getSubtotal().subtract(temp.getMontoIgv());
                if(tmonedaVenta.equals("S")){                   
                   BigDecimal ventaDolares= venta.divide(tcambio, 4, RoundingMode.HALF_UP);
                   ventasDetalleVO.setDFACMTOMO(venta);
                   ventasDetalleVO.setDFACMTOMN(venta);
                   ventasDetalleVO.setDFACMTOME(ventaDolares); 
                }else if(tmonedaVenta.equals("D")){
                   BigDecimal ventaSoles= venta.multiply(tcambio);
                   ventasDetalleVO.setDFACMTOMO(venta);
                   ventasDetalleVO.setDFACMTOMN(ventaSoles);
                   ventasDetalleVO.setDFACMTOME(venta); 
                }                          
                
                ventasDetalleVO.setFECHVTA(Util.obtieneFechaDiaHora());
                ventasDetalleVO.setDFACIMP1(SesionData.getSesion().getIgvPorcentaje());
                ventasDetalleVO.setDFACIMPMTO1(temp.getMontoIgv());
                
                
                if(tmonedaVenta.equals("S")){                   
                   BigDecimal ventaTotalDolares= temp.getSubtotal().divide(tcambio, 4, RoundingMode.HALF_UP);
                   ventasDetalleVO.setDFACVTOTMO(temp.getSubtotal());
                   ventasDetalleVO.setDFACVTOTMN(temp.getSubtotal());
                   ventasDetalleVO.setDFACVTOTME(ventaTotalDolares);
                }else if(tmonedaVenta.equals("D")){
                   BigDecimal ventaTotalSoles= temp.getSubtotal().multiply(tcambio);
                   ventasDetalleVO.setDFACVTOTMO(temp.getSubtotal());
                   ventasDetalleVO.setDFACVTOTMN(temp.getSubtotal());
                   ventasDetalleVO.setDFACVTOTME(ventaTotalSoles);
                }  
//                ventasDetalleVO.setDFACVTOTMO(temp.getSubtotal());
//                ventasDetalleVO.setDFACVTOTMN(temp.getSubtotal());
//                ventasDetalleVO.setDFACVTOTME(BigDecimal.ZERO);
                
                ventasDetalleVO.setDFACTFLAG("S");
                ventasDetalleVO.setUSUREG(UsuarioData.getUsuario().getUsuario());
                ventasDetalleVO.setFECREG(Util.obtieneFechaDia());
                                
                ventasDetalleVO.setDFACDCTOMO(BigDecimal.ZERO);
                ventasDetalleVO.setDFACDCTOMN(BigDecimal.ZERO);
                ventasDetalleVO.setDFACDCTOME(BigDecimal.ZERO);
                
                
//                ventasDetalleVO.getDFACMTOMO();
//                ventasDetalleVO.getDFACMTOMN();
//                ventasDetalleVO.getDFACMTOME(); 
                   
                ventasDetalleVO.setDFACPREVMO(ventasDetalleVO.getDFACMTOMO());
                ventasDetalleVO.setDFACPREVMN(ventasDetalleVO.getDFACMTOMN());
                ventasDetalleVO.setDFACPREVME(ventasDetalleVO.getDFACMTOME());
                ventasDetalleVO.setAPLIMPTO(temp.getAplimpto());
                
                if(!ventasDAO.insertaDetalleVentas(ventasDetalleVO)){
                    resultado="mysql";                    
                }
                if(UsuarioData.getUsuario().getEmpresa().equals("1")){//si es DM entonces que grabe en OASIS
                    if(!ventasDAO.insertaDetalleOracleVentas(ventasCabeceraVO, ventasDetalleVO)){
                        resultado="oracle";                    
                    }
                }else if(!ventasDAO.actualizaDetalleVentas(ventasDetalleVO)){
                    resultado="updmysql";                    
                }
                i++;
            }
            if(resultado.equalsIgnoreCase("mysql")){
              resultado="";  
              JOptionPane.showMessageDialog(null, "NO SE PUDO GRABAR EL DETALLE DE LA VENTA", "DmPos", JOptionPane.ERROR_MESSAGE);
            }
            if(resultado.equalsIgnoreCase("oracle")){
              resultado="";  
              JOptionPane.showMessageDialog(null, "NO SE PUDO GRABAR EL DETALLE DE LA VENTA EN OASIS", "DmPos", JOptionPane.ERROR_MESSAGE);  
            }
            if(resultado.equalsIgnoreCase("updmysql")){
              resultado="";  
              JOptionPane.showMessageDialog(null, "NO SE PUDO ACTUALIZAR ESTADO DEL DETALLE DE LA VENTA", "DmPos", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception ex){
            resultado="";
            ex.printStackTrace();
        }
        return resultado;
    }
    static BigDecimal totalTemporal = BigDecimal.ZERO;
    static BigDecimal sumaDesc=BigDecimal.ZERO;
    static BigDecimal sumaIGV=BigDecimal.ZERO;
    static BigDecimal sumaSubtotalIgv=BigDecimal.ZERO;
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String valor= jcbTipoDocumento.getSelectedItem().toString();
        String valorSeleccionado[] = valor.split(" - ");
        if(valorSeleccionado[0].equals("07")){
            JOptionPane.showMessageDialog(null, "OPERACIÓN NO PERMITIDA", "DmPos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int cantidad = Integer.parseInt(spnCantidad.getValue().toString().trim());
        if(cantidad <= 0){
            JOptionPane.showMessageDialog(null, "INGRESAR UNA CANTIDAD VÁLIDA", "DmPos", JOptionPane.WARNING_MESSAGE);
            spnCantidad.requestFocus();
            return;
        }
        //verifica si antes de agregar el item fue seleccionado el tipo de moneda
        if(jcbTipoMoneda.getSelectedItem().toString().startsWith("-")){
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR EL TIPO DE MONEDA", "DmPos", JOptionPane.WARNING_MESSAGE);
            spnCantidad.requestFocus();
            return;  
        }
        String tmoneda="";
        TipoCambioVO tipoCambio = TipoCambioDAO.consultarTipoCambio();
        BigDecimal tcambio=new BigDecimal(tipoCambio.getTventa());
        if(jcbTipoMoneda.getSelectedItem().toString().endsWith("S")){
            tmoneda="S";
        }else if(jcbTipoMoneda.getSelectedItem().toString().endsWith("D")){
            tmoneda="D";
            //tcambio = new BigDecimal(lblExchangeRate.getText());
        }
                
        DetalleTicket detalleTicket = new DetalleTicket(
                //ConceptoCobroList.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()), 
        ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()),cantidad,tmoneda,tcambio, new BigDecimal(txtDscto.getText()));
        
        //jcastillo inicio
        //if(modelo.getRowCount()>0 && ConceptoCobroList.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).isAplicaIgv()!=ticket.isAplicaIGV()){
        if(modelo.getRowCount()>0 && ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).isAplicaIgv()!=ticket.isAplicaIGV()){
           JOptionPane.showMessageDialog(null, "CONCEPTO SELECCIONADO NO CONCUERDA CON EL FLAG DE IGV DEL CONCEPTO AGREGADO AL TICKET " ,
                    "DmPos", JOptionPane.WARNING_MESSAGE);
           return;
        }
        //jcastillo fin
        
        BigDecimal total = ticket.getTotal().add(detalleTicket.getSubtotal());
        /*if(SesionData.getSesion().getTopeTicket()<total.doubleValue()){
            JOptionPane.showMessageDialog(null, "MONTO DE TICKET NO DEBE SUPERAR " + 
                    (new BigDecimal(SesionData.getSesion().getTopeTicket())).setScale(2, RoundingMode.HALF_UP),
                    "DeMaTicket", JOptionPane.WARNING_MESSAGE);
            spnCantidad.requestFocus();
            return;        
        }*/
        ticket.addDetalleTicket(detalleTicket);
        BigDecimal suma=BigDecimal.ZERO;
        if (detalleTicket.getMontoGravado().compareTo(BigDecimal.ZERO) > 0){
            suma= ticket.getMontoGravado().add(detalleTicket.getMontoGravado());
            ticket.setMontoGravado(suma);
        }
        if (detalleTicket.getMontoExonerado().compareTo(BigDecimal.ZERO) > 0){
            suma= ticket.getMontoExonerado().add(detalleTicket.getMontoExonerado());
            ticket.setMontoGravado(suma);
        }
        if (detalleTicket.getMontoInafecto().compareTo(BigDecimal.ZERO) > 0){
            suma= ticket.getMontoInafecto().add(detalleTicket.getMontoInafecto());
            ticket.setMontoGravado(suma);
        }
        
        sumaDesc= sumaDesc.add(detalleTicket.getDescItem());
        BigDecimal importeSinIgv = BigDecimal.ZERO;
        sumaIGV = sumaIGV.add(detalleTicket.getMontoIgv());
        importeSinIgv=detalleTicket.getSubtotal().subtract(detalleTicket.getMontoIgv());
        sumaSubtotalIgv = sumaSubtotalIgv.add(importeSinIgv);
        
        //lblContadorSubTotal.setText(Util.formatDecimal(sumaSubtotalIgv.doubleValue()));
        lblContadorSubTotal.setText(Util.formatDecimal((sumaSubtotalIgv.add(sumaDesc)).doubleValue()));
        lblContadorDscto.setText(Util.formatDecimal(sumaDesc.doubleValue()));
        lblContadorServ.setText("0");
        lblContadorIGV.setText(Util.formatDecimal(sumaIGV.doubleValue()));
        
//        ticket.setMontoGravado(detalleTicket.getMontoGravado());
//        ticket.setMontoExonerado(detalleTicket.getMontoExonerado());
//        ticket.setMontoInafecto(detalleTicket.getMontoInafecto());


        /*ConceptoCobro miconcepto = null;
        ArrayList<DetalleTicket> listaDetalles = ticket.getDetalleTicket();
        DetalleTicket midetalle = listaDetalles.get(listaDetalles.size()-1);
        miconcepto = midetalle.getConceptoCobro();
        String monedaConcepto = ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getTipomon();
        BigDecimal montoPrecioUnitario = miconcepto.getPrecioUnitario();
        if(!monedaConcepto.equals(tmoneda)){
            if(tmoneda.equals("S")){
                miconcepto.setPrecioUnitario(montoPrecioUnitario.multiply(tcambio));
                //this.subtotal = subtotal.multiply(tcambio);
            }else if(tmoneda.equals("D")){
                //conceptoCobro.setPrecioUnitario(conceptoCobro.getPrecioUnitario().divide(tcambio,2, RoundingMode.HALF_UP));
                miconcepto.setPrecioUnitario(montoPrecioUnitario.divide(tcambio,2, RoundingMode.HALF_UP));
                //this.subtotal = subtotal.divide(tcambio,2, RoundingMode.HALF_UP);
            }
        }*/
        
      /*  Object [] object = new Object[]{ConceptoCobroList.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getConcepto(),
            Util.formatDecimal(ConceptoCobroList.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getPrecioUnitario().doubleValue()),*/
      ConceptoCobro conceptoCobro =  ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex());
      BigDecimal precioConvertido=conceptoCobro.getPrecioUnitario();
      if(!conceptoCobro.getTipomon().equals(tmoneda)){
            if(tmoneda.equals("S")){
                precioConvertido= conceptoCobro.getPrecioUnitario().multiply(tcambio);
                //this.subtotal = subtotal.multiply(tcambio);
            }else if(tmoneda.equals("D")){
                precioConvertido= conceptoCobro.getPrecioUnitario().divide(tcambio,4, RoundingMode.HALF_UP);
                //this.subtotal = subtotal.divide(tcambio);
            }
        }
      
      //jesuscp
      Object [] object = new Object[]{
          ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getTipo(),
          ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getConcepto(),
          tmoneda,
          spnCantidad.getValue().toString().trim(),
          Util.formatDecimal(precioConvertido.doubleValue()),
          detalleTicket.getDescItem(),        
          lblSubTotal.getText(),
          2
      };
      /*
        ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getConcepto(),
            //Util.formatDecimal(ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getPrecioUnitario().doubleValue()),
            Util.formatDecimal(precioConvertido.doubleValue()),
        detalleTicket.getDescItem(),
        tmoneda,
        spnCantidad.getValue().toString().trim(),
        lblSubTotal.getText(),
        2
      */
        modelo.addRow(object);
        lblTotal.setText(Util.formatDecimal(ticket.getTotal().doubleValue()));
        btnImprimir.setEnabled(false);       
        totalTemporal= new BigDecimal(ticket.getTotal().doubleValue());
        if(jTable1.getRowCount()==0){
            jButton1.setEnabled(false);
        }else{
            jButton1.setEnabled(true);
        }
      spnCantidad.setValue(0);
      txtDscto.setText("0.0");
    }//GEN-LAST:event_btnAgregarActionPerformed
  
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarTicket();
        btnImprimir.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDetalleActionPerformed
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        
//        JOptionPane.showMessageDialog(null, ticket.getDetalleTicket().get(index).getSubtotal().subtract(ticket.getDetalleTicket().get(index).getMontoIgv()), "DmPos",JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null, ticket.getDetalleTicket().get(index).getDescItem(), "DmPos",JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null, ticket.getDetalleTicket().get(index).getMontoIgv(), "DmPos",JOptionPane.WARNING_MESSAGE);
        if(index<0){
            if(modelo.getRowCount()>0){
                JOptionPane.showMessageDialog(null, "POR FAVOR, PRIMERO SELECCIONE EL DETALLE QUE DESEA ELIMINAR ", "DmPos",JOptionPane.WARNING_MESSAGE);
                return;
            }else if(modelo.getRowCount()<=0){
                JOptionPane.showMessageDialog(null, "PRIMERO DEBE INGRESAR UN CONCEPTO DE PAGO ", "DmPos",JOptionPane.ERROR_MESSAGE);
                return;
            }            
        }
        modelo.removeRow(index);
        
        if(ticket.getDetalleTicket().get(index).getConceptoCobro().isAplicaIgv() &&
            ticket.getDetalleTicket().get(index).getConceptoCobro().getExonerado().equals("N")){
            ticket.setMontoGravado(ticket.getMontoGravado().subtract(ticket.getDetalleTicket().get(index).getSubtotal()));
        }
        if(!ticket.getDetalleTicket().get(index).getConceptoCobro().isAplicaIgv() &&
            ticket.getDetalleTicket().get(index).getConceptoCobro().getExonerado().equals("S")){
            ticket.setMontoExonerado(ticket.getMontoExonerado().subtract(ticket.getDetalleTicket().get(index).getSubtotal()));
        }
        if(!ticket.getDetalleTicket().get(index).getConceptoCobro().isAplicaIgv() &&
            ticket.getDetalleTicket().get(index).getConceptoCobro().getExonerado().equals("N")){
            ticket.setMontoInafecto(ticket.getMontoInafecto().subtract(ticket.getDetalleTicket().get(index).getSubtotal()));
        }
        BigDecimal cantSinIGV = ticket.getDetalleTicket().get(index).getSubtotal().subtract(ticket.getDetalleTicket().get(index).getMontoIgv());
        sumaSubtotalIgv= sumaSubtotalIgv.subtract(cantSinIGV);
        sumaDesc= sumaDesc.subtract(ticket.getDetalleTicket().get(index).getDescItem());
        sumaIGV= sumaIGV.subtract(ticket.getDetalleTicket().get(index).getMontoIgv());
        
        lblContadorSubTotal.setText(Util.formatDecimal(sumaSubtotalIgv.doubleValue()));
        lblContadorDscto.setText(Util.formatDecimal(sumaDesc.doubleValue()));
        lblContadorIGV.setText(Util.formatDecimal(sumaIGV.doubleValue()));
        
        
        ticket.getDetalleTicket().remove(index);
        ticket.calculateTicket();
        totalTemporal=ticket.getTotal();
        lblTotal.setText(Util.formatDecimal(ticket.getTotal().doubleValue()));
        if(ticket.getDetalleTicket().isEmpty()){
            btnImprimir.setEnabled(false);
        }
    }//GEN-LAST:event_btnEliminarDetalleActionPerformed

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        if(formAnulacion==null){
            formAnulacion = new FormAnulacion();
            formAnulacion.evaluaComboNC();
            formAnulacion.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            formAnulacion.setLocationRelativeTo(null);
            formAnulacion.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            formAnulacion.setVisible(true);
        }else{
            formAnulacion.evaluaComboNC();
            formAnulacion.setVisible(true);
        }
        formAnulacion.Limpiar();
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        imprimirReporte();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void imprimirReporte(){
        //File fileCab = null;
        WritableWorkbook writableWorkbook = null;
        WritableSheet sheet = null;
        DbConnection conex= new DbConnection();
        try{
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT IDCOMPANIA,IDLOCALIDAD,TINID,ALMACEN,LISTAPRECIOS,CODIGOCLIENTE,CLASEAUX,CLIERUC,SERIE,NUMERO, " +
                "FECHAPROCESO,VEID,FORMAPAGO,TIPOMONEDA,TIPOVENTA,FACMTOMO,FACMTOMN,FACMTOME,FACESTADO,FACDCTOMO, " +
                "FACDCTOMN,FACDCTOME,FACUSER,FACFREG,FACHREG,FACANOMES,FACTCAM,FACFLAGD,FACIGVMO,FACIGVMN,FACIGVME, " +
                "FACISCMO,FACISCMN,FACISCME,FACTOTMO,FACTOTMN,FACTOTME,FACTIP,TIPODOCUMENTO,TIPPERID,FACDSCTO1, " +
                "FACIMPREP,FACFEVCMTO,FACTCLI,FACTDES,CLIEDIR,TIPOADQ,FACIGV2MN,FACIGV2ME,FACIGV2MO,INICIAL, " +
                "FACSERMO,FACSERMN,FACSERME,PORIGV,PORSER " +
                "FROM DMTICKET.DMT_VENTAS_CAB WHERE FECHAPROCESO=STR_TO_DATE(?,'%Y/%m/%d') AND TURNO=?");
            consulta.setString(1, Util.obtieneFechaDia());
            consulta.setString(2, SesionData.getSesion().getTurno());
            ResultSet res = consulta.executeQuery();
            if(!res.next()){
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA CON INFORMACIÓN DE VENTAS PARA LA ACTUAL FECHA DE PROCESO", "DmPos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            /*fileCab = Util.validaArchivoTicket(TipoArchivo.DM.getTipo());
            if(fileCab==null){
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA CON INFORMACIÓN DEL TURNO", "DeMaTicket", JOptionPane.ERROR_MESSAGE);
                return;
            }*/
            File fileRep = Util.validaArchivoTicket(TipoArchivo.XLS.getTipo());
            int row=0;
            WritableFont cellFontBold = new WritableFont(WritableFont.TAHOMA, 10);
            cellFontBold.setBoldStyle(WritableFont.BOLD);
            WritableFont cellFont = new WritableFont(WritableFont.TAHOMA, 10);
            WritableFont cellFontBoldGra = new WritableFont(WritableFont.TAHOMA, 10);
            cellFontBoldGra.setColour(Colour.DARK_RED2);
            cellFontBoldGra.setBoldStyle(WritableFont.BOLD);
            try{
                writableWorkbook = Workbook.createWorkbook(fileRep);
                sheet = writableWorkbook.createSheet("Reporte", 0);                
                sheet.addCell(new jxl.write.Label(0, row, "USUARIO", new WritableCellFormat(cellFontBold)));
                sheet.addCell(new jxl.write.Label(1, row, UsuarioData.getUsuario().getUsuario(), new WritableCellFormat(cellFont)));
                sheet.addCell(new jxl.write.Label(2, row, UsuarioData.getUsuario().getNombre(), new WritableCellFormat(cellFont)));
                row++;
                sheet.addCell(new jxl.write.Label(0, row, "COMPAÑIA", new WritableCellFormat(cellFontBold) ));
                //sheet.addCell(new jxl.write.Label(1, row, SesionData.getSesion().getCompania(), new WritableCellFormat(cellFont) ));
                sheet.addCell(new jxl.write.Label(1, row, lblCompania.getText(), new WritableCellFormat(cellFont) ));
                
                row++;
                sheet.addCell(new jxl.write.Label(0, row, "TURNO", new WritableCellFormat(cellFontBold) ));
                sheet.addCell(new jxl.write.Label(1, row, Util.completarIzquierda(8, SesionData.getSesion().getTurno()+"", "0"), new WritableCellFormat(cellFont) ));
                
                sheet.addCell(new jxl.write.Label(2, row, "TIENDA", new WritableCellFormat(cellFontBold) ));
                sheet.addCell(new jxl.write.Label(3, row, TiendaDAO.consultarTiendaxID(UsuarioData.getUsuario().getEmpresa(), UsuarioData.getUsuario().getTienda()).getTiendadsc(), new WritableCellFormat(cellFont) ));
                
                sheet.addCell(new jxl.write.Label(4, row, "P.VTA", new WritableCellFormat(cellFontBold) ));
                sheet.addCell(new jxl.write.Label(5, row, PtoVentaDAO.consultarPuntoxID(UsuarioData.getUsuario().getEmpresa(), UsuarioData.getUsuario().getTienda()).getPtovtades(), new WritableCellFormat(cellFont) ));
                                
                row++;
                sheet.addCell(new jxl.write.Label(0, row, "FECHA Y HORA", new WritableCellFormat(cellFontBold) ));
                sheet.addCell(new jxl.write.Label(1, row, Util.obtieneFechaDiaHora(), new WritableCellFormat(cellFont) ));
                row++;row++;
                //cabecera
                WritableCellFormat cellFormat = new WritableCellFormat(cellFontBoldGra);
                cellFormat.setBackground(Colour.GREY_25_PERCENT);
                cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
                cellFormat.setAlignment(Alignment.CENTRE);
                sheet.addCell(new jxl.write.Label(0, row, "SERIE", cellFormat ));
                sheet.addCell(new jxl.write.Label(1, row, "NUMERO", cellFormat ));
                sheet.addCell(new jxl.write.Label(2, row, "FECHA HORA", cellFormat ));
                sheet.addCell(new jxl.write.Label(3, row, "CLIENTE", cellFormat ));
                sheet.addCell(new jxl.write.Label(4, row, "ESTADO", cellFormat ));
                sheet.addCell(new jxl.write.Label(5, row, "TOTAL", cellFormat ));
                row++;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            /*BufferedReader br = new BufferedReader(new FileReader(fileCab));
            String line = br.readLine();*/
            Double total = 0.0;
            Double anulados = 0.0;
            WritableCellFormat cellFormatL = new WritableCellFormat(cellFont);
            cellFormatL.setBorder(Border.ALL, BorderLineStyle.THIN);
            cellFormatL.setAlignment(Alignment.LEFT);
            WritableCellFormat cellFormatR = new WritableCellFormat(cellFont);
            cellFormatR.setBorder(Border.ALL, BorderLineStyle.THIN);
            cellFormatR.setAlignment(Alignment.RIGHT);
            res.beforeFirst();
            while(res.next()){
               try{
                        total = total + Double.parseDouble(res.getString("FACTOTMO"));
                        if(res.getString("FACESTADO").compareTo("ANULADO")==0){
                            anulados = anulados + Double.parseDouble(res.getString("FACTOTMO"));
                        }
                        sheet.addCell(new jxl.write.Label(0, row, Util.completarIzquierda(4, res.getString("SERIE"), "0") , cellFormatL  ));
                        sheet.addCell(new jxl.write.Label(1, row, Util.completarIzquierda(8, res.getString("NUMERO"), "0"), cellFormatL  ));
                        sheet.addCell(new jxl.write.Label(2, row, res.getString("FACHREG"), cellFormatL ));
                        sheet.addCell(new jxl.write.Label(3, row, res.getString("FACTDES"), cellFormatL ));
                        sheet.addCell(new jxl.write.Label(4, row, res.getString("FACESTADO"), cellFormatL ));
                        sheet.addCell(new jxl.write.Label(5, row, res.getString("FACTOTMO"), cellFormatR ));
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    row++; 
            }
            /*while (line != null) {
                if(line!=null && line.trim().compareTo("")!=0){
                    String[] data = line.split("\\"+Util.FILE_DELIMITADOR);
                    try{
                        total = total + Double.parseDouble(data[26]);
                        if(data[17].compareTo("ANULADO")==0){
                            anulados = anulados + Double.parseDouble(data[26]);
                        }
                        sheet.addCell(new jxl.write.Label(0, row, Util.completarIzquierda(3, data[7], "0") , cellFormatL  ));
                        sheet.addCell(new jxl.write.Label(1, row, Util.completarIzquierda(8, data[8], "0"), cellFormatL  ));
                        sheet.addCell(new jxl.write.Label(2, row, data[20], cellFormatL ));
                        sheet.addCell(new jxl.write.Label(3, row, data[30], cellFormatL ));
                        sheet.addCell(new jxl.write.Label(4, row, data[17], cellFormatL ));
                        sheet.addCell(new jxl.write.Label(5, row, data[26], cellFormatR ));
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    row++;
                }
                line = br.readLine();
            }*/
            sheet.addCell(new jxl.write.Label(4, row, "TOTAL", new WritableCellFormat(cellFontBold) ));
            sheet.addCell(new jxl.write.Label(5, row, Util.formatDecimal(total), cellFormatR ));
            row++;
            sheet.addCell(new jxl.write.Label(4, row, "ANULADOS", new WritableCellFormat(cellFontBold) ));
            sheet.addCell(new jxl.write.Label(5, row, Util.formatDecimal(anulados), cellFormatR ));
            row++;
            sheet.addCell(new jxl.write.Label(4, row, "EFECTIVO", new WritableCellFormat(cellFontBold) ));
            sheet.addCell(new jxl.write.Label(5, row, Util.formatDecimal(total-anulados), cellFormatR ));
            //Autoajuste de celdas
            for(int x=0;x<6;x++){
                CellView cell = sheet.getColumnView(x);
                cell.setAutosize(true);
                sheet.setColumnView(x, cell);
            }
            writableWorkbook.write();
            writableWorkbook.close(); 
            //br.close();
            consulta.close();
            conex.desconectar();
            
            Desktop.getDesktop().open(fileRep);
        }catch(Exception ex){
            conex.desconectar();
            ex.printStackTrace();
        }
    }
    
    private void imprimirReporteDetallado(){
        File fileDet = null;
        WritableWorkbook writableWorkbook = null;
        WritableSheet sheet = null;
        try{
            fileDet = Util.validaArchivoTicket(TipoArchivo.DMD.getTipo());
            if(fileDet==null){
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA CON INFORMACIÓN DEL TURNO", "DmPos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            File fileRep = Util.validaArchivoTicket(TipoArchivo.XLS.getTipo());
            int row=0;
            WritableFont cellFontBold = new WritableFont(WritableFont.TAHOMA, 10);
            cellFontBold.setBoldStyle(WritableFont.BOLD);
            WritableFont cellFont = new WritableFont(WritableFont.TAHOMA, 10);
            WritableFont cellFontBoldGra = new WritableFont(WritableFont.TAHOMA, 10);
            cellFontBoldGra.setColour(Colour.DARK_RED2);
            cellFontBoldGra.setBoldStyle(WritableFont.BOLD);
            try{
                writableWorkbook = Workbook.createWorkbook(fileRep);
                sheet = writableWorkbook.createSheet("Reporte", 0);                
                sheet.addCell(new jxl.write.Label(0, row, "USUARIO", new WritableCellFormat(cellFontBold)));
                sheet.addCell(new jxl.write.Label(1, row, UsuarioData.getUsuario().getUsuario(), new WritableCellFormat(cellFont)));
                sheet.addCell(new jxl.write.Label(2, row, UsuarioData.getUsuario().getNombre(), new WritableCellFormat(cellFont)));
                row++;
                sheet.addCell(new jxl.write.Label(0, row, "COMPAÑIA", new WritableCellFormat(cellFontBold) ));
                sheet.addCell(new jxl.write.Label(1, row, SesionData.getSesion().getCompania(), new WritableCellFormat(cellFont) ));
                row++;
                sheet.addCell(new jxl.write.Label(0, row, "TURNO", new WritableCellFormat(cellFontBold) ));
                sheet.addCell(new jxl.write.Label(1, row, Util.completarIzquierda(8, SesionData.getSesion().getTurno()+"", "0"), new WritableCellFormat(cellFont) ));
                row++;
                sheet.addCell(new jxl.write.Label(0, row, "FECHA Y HORA", new WritableCellFormat(cellFontBold) ));
                sheet.addCell(new jxl.write.Label(1, row, Util.obtieneFechaDiaHora(), new WritableCellFormat(cellFont) ));
                row++;row++;
                //cabecera
                WritableCellFormat cellFormat = new WritableCellFormat(cellFontBoldGra);
                cellFormat.setBackground(Colour.GREY_25_PERCENT);
                cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
                cellFormat.setAlignment(Alignment.CENTRE);
                sheet.addCell(new jxl.write.Label(0, row, "SERIE", cellFormat ));
                sheet.addCell(new jxl.write.Label(1, row, "NUMERO", cellFormat ));
                sheet.addCell(new jxl.write.Label(2, row, "FECHA HORA", cellFormat ));
                sheet.addCell(new jxl.write.Label(3, row, "CLIENTE", cellFormat ));
                sheet.addCell(new jxl.write.Label(4, row, "ESTADO", cellFormat ));
                sheet.addCell(new jxl.write.Label(5, row, "TOTAL", cellFormat ));
                row++;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            BufferedReader br = new BufferedReader(new FileReader(fileDet));
            String line = br.readLine();
            Double total = 0.0;
            Double anulados = 0.0;
            WritableCellFormat cellFormatL = new WritableCellFormat(cellFont);
            cellFormatL.setBorder(Border.ALL, BorderLineStyle.THIN);
            cellFormatL.setAlignment(Alignment.LEFT);
            WritableCellFormat cellFormatR = new WritableCellFormat(cellFont);
            cellFormatR.setBorder(Border.ALL, BorderLineStyle.THIN);
            cellFormatR.setAlignment(Alignment.RIGHT);
            while (line != null) {
                if(line!=null && line.trim().compareTo("")!=0){
                    String[] data = line.split("\\"+Util.FILE_DELIMITADOR);
                    try{
                        total = total + Double.parseDouble(data[26]);
                        if(data[17].compareTo("ANULADO")==0){
                            anulados = anulados + Double.parseDouble(data[26]);
                        }
                        sheet.addCell(new jxl.write.Label(0, row, Util.completarIzquierda(3, data[7], "0") , cellFormatL  ));
                        sheet.addCell(new jxl.write.Label(1, row, Util.completarIzquierda(8, data[8], "0"), cellFormatL  ));
                        sheet.addCell(new jxl.write.Label(2, row, data[20], cellFormatL ));
                        sheet.addCell(new jxl.write.Label(3, row, data[30], cellFormatL ));
                        sheet.addCell(new jxl.write.Label(4, row, data[17], cellFormatL ));
                        sheet.addCell(new jxl.write.Label(5, row, data[26], cellFormatR ));
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    row++;
                }
                line = br.readLine();
            }
            sheet.addCell(new jxl.write.Label(4, row, "TOTAL", new WritableCellFormat(cellFontBold) ));
            sheet.addCell(new jxl.write.Label(5, row, Util.formatDecimal(total), cellFormatR ));
            row++;
            sheet.addCell(new jxl.write.Label(4, row, "ANULADOS", new WritableCellFormat(cellFontBold) ));
            sheet.addCell(new jxl.write.Label(5, row, Util.formatDecimal(anulados), cellFormatR ));
            row++;
            sheet.addCell(new jxl.write.Label(4, row, "EFECTIVO", new WritableCellFormat(cellFontBold) ));
            sheet.addCell(new jxl.write.Label(5, row, Util.formatDecimal(total-anulados), cellFormatR ));
            //Autoajuste de celdas
            for(int x=0;x<6;x++){
                CellView cell = sheet.getColumnView(x);
                cell.setAutosize(true);
                sheet.setColumnView(x, cell);
            }
            writableWorkbook.write();
            writableWorkbook.close(); 
            br.close();
            Desktop.getDesktop().open(fileRep);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void btnImprimeCuadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimeCuadreActionPerformed
        // TODO add your handling code here:
        //imprimirCuadre();
        imprimirCuadreBD();
    }//GEN-LAST:event_btnImprimeCuadreActionPerformed

    private void imprimirCuadreBD(){
        DbConnection conex= new DbConnection();
        try{
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT IDCOMPANIA,IDLOCALIDAD,TINID,ALMACEN,LISTAPRECIOS,CODIGOCLIENTE,CLASEAUX,CLIERUC,SERIE,NUMERO, " +
                "FECHAPROCESO,VEID,FORMAPAGO,TIPOMONEDA,TIPOVENTA,FACMTOMO,FACMTOMN,FACMTOME,FACESTADO,FACDCTOMO, " +
                "FACDCTOMN,FACDCTOME,FACUSER,FACFREG,FACHREG,FACANOMES,FACTCAM,FACFLAGD,FACIGVMO,FACIGVMN,FACIGVME, " +
                "FACISCMO,FACISCMN,FACISCME,FACTOTMO,FACTOTMN,FACTOTME,FACTIP,TIPODOCUMENTO,TIPPERID,FACDSCTO1, " +
                "FACIMPREP,FACFEVCMTO,FACTCLI,FACTDES,CLIEDIR,TIPOADQ,FACIGV2MN,FACIGV2ME,FACIGV2MO,INICIAL, " +
                "FACSERMO,FACSERMN,FACSERME,PORIGV,PORSER " +
                "FROM DMTICKET.DMT_VENTAS_CAB WHERE FECHAPROCESO=STR_TO_DATE(?,'%Y/%m/%d')");
            consulta.setString(1, Util.obtieneFechaDia());
            ResultSet res = consulta.executeQuery();
            if(!res.next()){
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA CON INFORMACIÓN DE VENTAS PARA LA ACTUAL FECHA DE PROCESO", "DmPos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int limit = Util.getLimitLine();
            DirectPrinterT88V printer = new DirectPrinterT88V();
            printer.initialize();
            printer.setCondensedHib(1);
            printer.setCenterAlignCommand();
            printer.setBoldOn();
            printer.println(" DERRAMA MAGISTERIAL");
            printer.setBoldOff();
            printer.println("Av.Gregorio Escobedo 598 Jesus Maria");
            printer.println(SesionData.getSesion().getCompania());
            printer.println("RUC: 20136424867");
            printer.printLine();
            printer.setBoldOn();
            printer.println(" CUADRE OPERATIVO ");
            printer.println(" TURNO " + Util.completarIzquierda(8, SesionData.getSesion().getTurno()+"", "0"));
            printer.setBoldOff();
            printer.setCenterAlignCommand();
            printer.printLine();
            if(SesionData.getSesion().getModelo().trim().compareTo("TM-T88V")==0){
                printer.println(" SERIE NUMERO         FECHA          ESTADO    TOTAL  ");
            }
            if(SesionData.getSesion().getModelo().trim().compareTo("TM-U220")==0){
                printer.println("SER NUMERO        FECHA        EST TOTAL");
            }
            printer.printLine();
            Double total = 0.0;
            Double anulados = 0.0;
            res.beforeFirst();
            while(res.next()){
               try{
                        total = total + Double.parseDouble(res.getString("FACTOTMO"));
                        if(res.getString("FACESTADO").compareTo("ANULADO")==0){
                            anulados = anulados + Double.parseDouble(res.getString("FACTOTMO"));
                        }
                        if(SesionData.getSesion().getModelo().trim().compareTo("TM-T88V")==0){
                            printer.println(
                                    Util.completarIzquierda(3, res.getString("SERIE"), "0") + " " +
                                    Util.completarIzquierda(8, res.getString("NUMERO"), "0") + 
                                    Util.completarIzquierda(20, res.getString("FACHREG"), " ") + 
                                    Util.completarIzquierda(10, res.getString("FACESTADO"), " ") + 
                                    Util.completarIzquierda(10, Util.formatDecimal(Double.parseDouble(res.getString("FACTOTMO"))))
                            );
                        }
                        if(SesionData.getSesion().getModelo().trim().compareTo("TM-U220")==0){
                            String fecha = res.getString("FACHREG");
                            fecha = fecha.substring(0, 6) + fecha.substring(8);
                            printer.println(
                                    Util.completarIzquierda(3, res.getString("SERIE"), "0") + " " + //4
                                    Util.completarIzquierda(8, res.getString("NUMERO"), "0") + " " + //9
                                    Util.completarIzquierda(17, fecha, " ")  + " " + //19
                                    Util.completarIzquierda(2, res.getString("FACESTADO"), " ") + //2
                                    Util.completarIzquierda(6, Util.formatDecimal(Double.parseDouble(res.getString("FACTOTMO"))))
                            );
                        }
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
            }
            printer.printLine();
            printer.println(Util.completarIzquierda(limit, "TOTAL S/." + Util.completarIzquierda(10, Util.formatDecimal(total), " ")));
            printer.println(Util.completarIzquierda(limit, "ANULADOS S/." + Util.completarIzquierda(10, Util.formatDecimal(anulados), " ")));
            printer.println(Util.completarIzquierda(limit, "EFECTIVO S/." + Util.completarIzquierda(10, Util.formatDecimal(total-anulados), " ")));
            printer.printLine();
            if(SesionData.getSesion().getModelo().trim().compareTo("TM-T88V")==0){
                printer.setCenterAlignCommand();
            }
            printer.println("Cajero: "+UsuarioData.getUsuario().getUsuario());
            printer.println(Util.obtieneFechaDiaHora());
            printer.printLine();
            printer.println("    \n");
            printer.println("    \n");
            printer.println("    \n");
            printer.println("    \n");
            printer.println("    \n");
            if(SesionData.getSesion().getModelo().trim().compareTo("TM-T88V")==0){
                printer.setCute();
            }
            printer.printHibrida(SesionData.getSesion().getImpresora()); 
            //br.close();
            consulta.close();
            conex.desconectar();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void imprimirCuadre(){
        File fileCab = null;
        try{
            fileCab = Util.validaArchivoTicket(TipoArchivo.DM.getTipo());
            if(fileCab==null){
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA CON INFORMACIÓN DEL TURNO", "DmPos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int limit = Util.getLimitLine();
            DirectPrinterT88V printer = new DirectPrinterT88V();
            printer.initialize();
            printer.setCondensedHib(1);
            printer.setCenterAlignCommand();
            printer.setBoldOn();
            printer.println(" DERRAMA MAGISTERIAL");
            printer.setBoldOff();
            printer.println("Av.Gregorio Escobedo 598 Jesus Maria");
            printer.println(SesionData.getSesion().getCompania());
            printer.println("RUC: 20136424867");
            printer.printLine();
            printer.setBoldOn();
            printer.println(" CUADRE OPERATIVO ");
            printer.println(" TURNO " + Util.completarIzquierda(8, SesionData.getSesion().getTurno()+"", "0"));
            printer.setBoldOff();
            printer.setCenterAlignCommand();
            printer.printLine();
            if(SesionData.getSesion().getModelo().trim().compareTo("TM-T88V")==0){
                printer.println(" SERIE NUMERO         FECHA          ESTADO    TOTAL  ");
            }
            if(SesionData.getSesion().getModelo().trim().compareTo("TM-U220")==0){
                printer.println("SER NUMERO        FECHA        EST TOTAL");
            }
            printer.printLine();
            BufferedReader br = new BufferedReader(new FileReader(fileCab));
            String line = br.readLine();
            Double total = 0.0;
            Double anulados = 0.0;
            while (line != null) {
                if(line!=null && line.trim().compareTo("")!=0){
                    String[] data = line.split("\\"+Util.FILE_DELIMITADOR);
                    total = total + Double.parseDouble(data[26]);
                    if(data[17].compareTo("ANULADO")==0){
                        anulados = anulados + Double.parseDouble(data[26]);
                    }
                    if(SesionData.getSesion().getModelo().trim().compareTo("TM-T88V")==0){
                        printer.println(
                                Util.completarIzquierda(3, data[7], "0") + " " +
                                Util.completarIzquierda(8, data[8], "0") + 
                                Util.completarIzquierda(20, data[20], " ") + 
                                Util.completarIzquierda(10, data[17], " ") + 
                                Util.completarIzquierda(10, Util.formatDecimal(Double.parseDouble(data[26])))
                        );
                    }
                    if(SesionData.getSesion().getModelo().trim().compareTo("TM-U220")==0){
                        String fecha = data[20];
                        fecha = fecha.substring(0, 6) + fecha.substring(8);
                        printer.println(
                                Util.completarIzquierda(3, data[7], "0") + " " + //4
                                Util.completarIzquierda(8, data[8], "0") + " " + //9
                                Util.completarIzquierda(17, fecha, " ")  + " " + //19
                                Util.completarIzquierda(2, data[17], " ") + //2
                                Util.completarIzquierda(6, Util.formatDecimal(Double.parseDouble(data[26])))
                        );
                    }
                }
                line = br.readLine();
            }
            printer.printLine();
            printer.println(Util.completarIzquierda(limit, "TOTAL S/." + Util.completarIzquierda(10, Util.formatDecimal(total), " ")));
            printer.println(Util.completarIzquierda(limit, "ANULADOS S/." + Util.completarIzquierda(10, Util.formatDecimal(anulados), " ")));
            printer.println(Util.completarIzquierda(limit, "EFECTIVO S/." + Util.completarIzquierda(10, Util.formatDecimal(total-anulados), " ")));
            printer.printLine();
            if(SesionData.getSesion().getModelo().trim().compareTo("TM-T88V")==0){
                printer.setCenterAlignCommand();
            }
            printer.println("Cajero: "+UsuarioData.getUsuario().getUsuario());
            printer.println(Util.obtieneFechaDiaHora());
            printer.printLine();
            printer.println("    \n");
            printer.println("    \n");
            printer.println("    \n");
            printer.println("    \n");
            printer.println("    \n");
            if(SesionData.getSesion().getModelo().trim().compareTo("TM-T88V")==0){
                printer.setCute();
            }
            printer.printHibrida(SesionData.getSesion().getImpresora()); 
            br.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void recuperaTurno(String ciaid, String tienda, String ptvta, boolean accion){
        String turnoBD="0000";
        SesionData.getSesion().setIdcompania(UsuarioData.getUsuario().getEmpresa());      
        SesionData.getSesion().setTienda(UsuarioData.getUsuario().getTienda());
        SesionData.getSesion().setPtoventa(UsuarioData.getUsuario().getPtoVenta());
        DbConnection conex= new DbConnection();
        try{
            if(accion){
                PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT TURNO "
                    + " FROM DMTICKET.dmt_puntovta_mae WHERE CIAID=? AND TDAID=? AND PVTAID=?");
                consulta.setString(1, SesionData.getSesion().getIdcompania());
                consulta.setString(2, SesionData.getSesion().getTienda());   
                consulta.setString(3, SesionData.getSesion().getPtoventa());
                ResultSet res = consulta.executeQuery();
                if(res.next()){
                    turnoBD = res.getString("TURNO");                
                }
                res.close();
                consulta.close();
                SesionData.getSesion().setTurno(turnoBD);
            }else{
                PreparedStatement consulta =conex.getConnection().prepareStatement("UPDATE DMTICKET.dmt_puntovta_mae "
                        + "SET TURNO=? "
                        + "WHERE CIAID=? AND TDAID=? AND PVTAID=?");
                consulta.setString(1, SesionData.getSesion().getTurno());
                consulta.setString(2, UsuarioData.getUsuario().getEmpresa());
                consulta.setString(3, UsuarioData.getUsuario().getTienda());   
                consulta.setString(4, UsuarioData.getUsuario().getPtoVenta());
                consulta.executeUpdate();
                consulta.close();
            }
            conex.desconectar();
                
        }catch(Exception ex){
            conex.desconectar();
            ex.printStackTrace();
        } 
    }
    
    private void btnCerrarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarTurnoActionPerformed
        // TODO add your handling code here:        
        DbConnection conex= new DbConnection();       
        
        int dialogButton = JOptionPane.showConfirmDialog (null, 
                "ESTA SEGURO QUE DESEA CERRAR EL TURNO "+
                Util.completarIzquierda(8, SesionData.getSesion().getTurno()+"", "0").toUpperCase()+
                "?", "CONFIRMACION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(dialogButton == JOptionPane.YES_OPTION){
            try{
                //imprimirCuadre();
                imprimirReporte();
                copyFile();
                //sendFile(); // se comento
                int turno = Integer.parseInt(SesionData.getSesion().getTurno())+1;
                        
                SesionData.getSesion().setTurno(Util.completarIzquierda(4, ""+turno, "0"));
                if(SesionData.getSesion().getFechaProceso().compareTo(Util.obtieneFechaDia())!=0){
                    SesionData.getSesion().setFechaProceso(Util.obtieneFechaDia());
                }
                //actualiza el turno ene la BD con el correlativo
                recuperaTurno(UsuarioData.getUsuario().getEmpresa(), UsuarioData.getUsuario().getTienda(), 
                UsuarioData.getUsuario().getPtoVenta(),false);
                
                
                grabarDataUsers();
                limpiarTicket();
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "TURNO CERRADO CORRECTAMENTE", "DmPos", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCerrarTurnoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.showConfirmDialog (null, 
                "ESTA SEGURO QUE DESEA CERRAR LA APLICACIÓN"+
                "?", "CONFIRMACION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(dialogButton == JOptionPane.YES_OPTION){
            if(UsuarioData.getUsuario().getEmpresa().equals("1")){
                VentasDAO ventasDAO = new VentasDAO();            
                if(ventasDAO.verificaVentasSinProcesar()){
                     JOptionPane.showMessageDialog(null, 
                            "PRIMERO DEBE DE SINCRONIZAR LAS VENTAS CON OASIS", "DmPos", JOptionPane.INFORMATION_MESSAGE);
                     btnSincronizar.requestFocus();
                }else{
                    System.exit(0); 
                }               
            }else{
                System.exit(0);
            }
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIniciarDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarDiaActionPerformed
        // TODO add your handling code here:
        if(Util.obtieneFechaDia().compareTo(SesionData.getSesion().getFechaProceso())!=0){
            int cantidad = Util.getNroRegistrosTurno();
            if(cantidad>0){
                JOptionPane.showMessageDialog(null, 
                        "EN EL TURNO SE REGISTRARON " + cantidad + ", "
                                + "POR FAVOR CERRAR TURNO ANTES DE CAMBIAR DE DÍA", "DmPos", JOptionPane.INFORMATION_MESSAGE);
            }else{
                int dialogButton = JOptionPane.showConfirmDialog (null, 
                        "ESTA SEGURO QUE DESEA CAMBIAR DE DÍA"+
                        "?", "CONFIRMACION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(dialogButton == JOptionPane.YES_OPTION){
                    SesionData.getSesion().setFechaProceso(Util.obtieneFechaDia());
                    grabarDataUsers();
                    limpiarTicket();
                    btnIniciarDia.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_btnIniciarDiaActionPerformed
//jcastillo inicio
    private void txtRUCDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUCDNIKeyTyped
        // TODO add your handling code here:
//        if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())){
//            Toolkit.getDefaultToolkit().beep();
//            evt.consume();
//        }
//        int k = (int) evt.getKeyChar();
//        //txtRUCDNI.getText().length() trae el numero de caracteres sin contar el actual, por eso colocamos 7 como nuestro liminite
//        if (txtRUCDNI.getText().length() > 14 && k!=KeyEvent.VK_ENTER) {            
//                evt.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
//                JOptionPane.showMessageDialog(null, "EL MAXIMO DE CARACTERES PERMITOS ES 15", "DmPos",JOptionPane.ERROR_MESSAGE);                      
//        }else if(txtRUCDNI.getText().length() == 8 && k == KeyEvent.VK_ENTER){
//            ClienteVO clienteVO = ClienteData.getClientexNumDoc(txtRUCDNI.getText());
//            if(clienteVO!=null){
//                 txtCliente.setText(clienteVO.getCLIENOM());
//                 txtDireccionP.setText(clienteVO.getCLIEDIR());    
//                 SesionData.getSesion().setTipDocSunat(clienteVO.getDocsunat());
//            }else{
//                txtCliente.setText("OTROS");
//                SesionData.getSesion().setTipDocSunat("1");
//                txtDireccionP.setText("");
//                btnUserMaintenance.setFocusPainted(true);
//                JOptionPane.showMessageDialog(null, "CLIENTE NO REGISTRADO, POR FAVOR INGRESARLO DATOS DEL CLIENTE", "DmPos",JOptionPane.ERROR_MESSAGE);
//            }
//        }
        char kc = (char) evt.getKeyChar();
        if(Util.validaCaracter(kc)== false){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
        int k = (int) evt.getKeyChar();
        //txtRUCDNI.getText().length() trae el numero de caracteres sin contar el actual, por eso colocamos 7 como nuestro liminite
        if (txtRUCDNI.getText().length() > 14 && k!=KeyEvent.VK_ENTER) {  
                if(k!=KeyEvent.VK_ESCAPE){
                    evt.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
                    JOptionPane.showMessageDialog(null, "EL MAXIMO DE CARACTERES PERMITOS ES 15", "DmPos",JOptionPane.ERROR_MESSAGE);                                                     
                }
        }else if(k == KeyEvent.VK_ENTER){
             ClienteVO clienteVO = ClienteData.getClientexNumDoc(txtRUCDNI.getText());
            if(clienteVO!=null){
                 txtCliente.setText(clienteVO.getCLIENOM());
                 txtDireccionP.setText(clienteVO.getCLIEDIR());    
                 SesionData.getSesion().setTipDocSunat(clienteVO.getDocsunat());
            }else{
                txtCliente.setText("OTROS");
                SesionData.getSesion().setTipDocSunat("1");
                txtDireccionP.setText("");
                btnUserMaintenance.setFocusPainted(true);
                JOptionPane.showMessageDialog(null, "CLIENTE NO REGISTRADO, POR FAVOR INGRESARLO DATOS DEL CLIENTE", "DmPos",JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_txtRUCDNIKeyTyped

    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroKeyTyped

    private void txtFiltroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFiltroFocusGained
        // TODO add your handling code here:
        if(txtFiltro.getText().equals("Filtro Conceptos...")){
            txtFiltro.setText("");
            txtFiltro.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtFiltroFocusGained

    private void txtFiltroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFiltroFocusLost
        // TODO add your handling code here:
        if(txtFiltro.getText().equals("")){
            txtFiltro.setText("Filtro Conceptos...");
            txtFiltro.setForeground(new java.awt.Color(150, 150, 150));
            jcbTipoConcepto.removeAllItems();
            //for(ConceptoCobro temp: ConceptoCobroList.getConceptos()){
            for(ConceptoCobro temp: ConceptosDAO.getConceptos()){
                jcbTipoConcepto.addItem(temp.getConcepto() + " (S/. " + Util.formatDecimal(temp.getPrecioUnitario().doubleValue()) + ")");
            }
            //ConceptoCobroList.resetListConceptos();
            ConceptosDAO.resetListConceptos();
        }else{
            ArrayList<ConceptoCobro> conceptosFiltrados = new ArrayList<ConceptoCobro>();
            jcbTipoConcepto.removeAllItems();
            //for(ConceptoCobro temp: ConceptoCobroList.getConceptos()){
            for(ConceptoCobro temp: ConceptosDAO.getConceptos()){
                if( temp.getConcepto().toUpperCase().indexOf(txtFiltro.getText().toUpperCase()) > 0 ){
                    jcbTipoConcepto.addItem(temp.getConcepto() + " (S/. " + Util.formatDecimal(temp.getPrecioUnitario().doubleValue()) + ")");
                    conceptosFiltrados.add(temp);
                }
            }
            //ConceptoCobroList.updateConceptos(conceptosFiltrados);
            ConceptosDAO.updateConceptos(conceptosFiltrados);
        }
        if(jcbTipoConcepto.getModel().getSize()>0){
            calculaTotal();
        }
    }//GEN-LAST:event_txtFiltroFocusLost

    private void jcbTipoDocumentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTipoDocumentoItemStateChanged
        // TODO add your handling code here:
        String valor =jcbTipoDocumento.getSelectedItem().toString();
        System.out.println(valor);
        String valorSeleccionado[] = valor.split(" - ");
            DbConnection conex= new DbConnection();
            try{
                PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT SERIE,NUMERO "
                                    + " FROM DMTICKET.DMT_SERIES_MAE WHERE ESTADO =? AND TIPODOCUMENTO=? AND CIAID=? AND TDAID=? AND PVTAID=?");
                consulta.setString(1, "A");
                consulta.setString(2, valorSeleccionado[0]);   
                consulta.setString(3, UsuarioData.getUsuario().getEmpresa());
                consulta.setString(4, UsuarioData.getUsuario().getTienda());
                consulta.setString(5, UsuarioData.getUsuario().getPtoVenta());
                ResultSet res = consulta.executeQuery();
                if(res.next()){
                   SesionData.getSesion().setSerie(res.getString("SERIE"));
                   SesionData.getSesion().setNumero(Integer.parseInt(res.getString("NUMERO")));
                   SesionData.getSesion().setTipoDocumento(valorSeleccionado[0]);
                   if(ticket!=null){
                   ticket.setSerie(SesionData.getSesion().getSerie());
                   ticket.setNumero(SesionData.getSesion().getNumero());
                   }
                }
                if(ticket!=null){
                lblTicket.setText(ticket.getSerie()+"-"+Util.completarIzquierda(8, ticket.getNumero()+"", "0"));
                }else{
                lblTicket.setText( SesionData.getSesion().getSerie() +"-"+Util.completarIzquierda(8, SesionData.getSesion().getNumero()+"", "0"));  
                }
                res.close();
                consulta.close();
                conex.desconectar();
                
            }catch(Exception ex){
                conex.desconectar();
                ex.printStackTrace();
            } 
        
    }//GEN-LAST:event_jcbTipoDocumentoItemStateChanged

    private void btnSincronizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSincronizarActionPerformed
        // TODO add your handling code here:
        ArrayList<VentasCabeceraVO> cabeceraList = new ArrayList();
        ArrayList<VentasDetalleVO> detalleList = new ArrayList();
        int dialogButton = JOptionPane.showConfirmDialog (null, 
                "¿DESEA SINCRONIZAR LAS VENTAS CON OASIS? "
                , "CONFIRMACION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(dialogButton == JOptionPane.YES_OPTION){
         try{
            VentasDAO ventasDAO = new VentasDAO();
            cabeceraList = ventasDAO.cabeceraSinProcesarList();
            if(cabeceraList.size()>0){
               for(VentasCabeceraVO item : cabeceraList){
                    try{
                        if(!ventasDAO.insertaCabeceraOracleVentas(item)){
                            JOptionPane.showMessageDialog(null, "NO SE PUDO GRABAR LA CABECERA DE LA VENTA EN OASIS", "DmPos", JOptionPane.ERROR_MESSAGE);
                            return;
                        }else{
                            ventasDAO.actualizaCabeceraVentas(item);
                            detalleList = ventasDAO.detalleSinProcesarList(item);
                            if(detalleList.size()>0){
                                for(VentasDetalleVO itemdet : detalleList){
                                    try{
                                        if(!ventasDAO.insertaDetalleOracleVentas(item, itemdet)){
                                            JOptionPane.showMessageDialog(null, "NO SE PUDO GRABAR EL DETALLE DE LA VENTA EN OASIS", "DmPos", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }else{
                                            ventasDAO.actualizaDetalleVentas(itemdet);
                                        }
                                    }catch(Exception ex){
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        }
                            
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                } 
            }else{
                JOptionPane.showMessageDialog(null, "LAS VENTAS YA SE ENCUENTRAN SINCRONIZADAS", "DmPos", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
         }catch(Exception ex){
             ex.printStackTrace();
         }
         JOptionPane.showMessageDialog(null, "SINCRONIZACIÓN REALIZADA CORRECTAMENTE", "DmPos", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSincronizarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        //btnSalir.doClick();        
        int dialogButton = JOptionPane.showConfirmDialog (null, 
                "ESTA SEGURO QUE DESEA CERRAR LA APLICACIÓN"+
                "?", "CONFIRMACION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(dialogButton == JOptionPane.YES_OPTION){
              if(UsuarioData.getUsuario().getEmpresa().equals("1")){
                    VentasDAO ventasDAO = new VentasDAO();            
                    if(ventasDAO.verificaVentasSinProcesar()){
                         JOptionPane.showMessageDialog(null, 
                                "PRIMERO DEBE DE SINCRONIZAR LAS VENTAS CON OASIS", "DmPos", JOptionPane.INFORMATION_MESSAGE);
                         btnSincronizar.requestFocus();
                         setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    }else{
                        System.exit(0); 
                    }
              }else{
                  System.exit(0);
              }
        }else{
          setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnExchangeRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExchangeRateActionPerformed
        // TODO add your handling code here:
        if(formExchangeRate==null){
            formExchangeRate = new FormExchangeRate();
            formExchangeRate.setLocationRelativeTo(null);
            formExchangeRate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            formExchangeRate.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            formExchangeRate.setVisible(true);
        }else{
            formExchangeRate.setVisible(true);
        }        
    }//GEN-LAST:event_btnExchangeRateActionPerformed

    private void jcbTipoMonedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoMonedaActionPerformed
        // TODO add your handling code here:
        if(!jcbTipoMoneda.getSelectedItem().toString().startsWith("-")){
            TipoCambioVO tipoCambio = TipoCambioDAO.consultarTipoCambio();
            BigDecimal tcambio = BigDecimal.ZERO;
            if(tipoCambio == null){
                JOptionPane.showMessageDialog(null, 
                        "NO EXISTE TIPO DE CAMBIO PARA EL DIA DE HOY", "DmPos", JOptionPane.INFORMATION_MESSAGE);
                return;
            }    
            ArrayList<DetalleTicket> listaDetalles = ticket.getDetalleTicket();
            ConceptoCobro concepto= null;
            if(jcbTipoMoneda.getSelectedItem().toString().startsWith("Dolar")){
                SesionData.getSesion().setTipoMoneda("D");
                lblExchangeRate.setText(tipoCambio.getTventa());
                if(modelo!=null){
                    if(modelo.getRowCount()>0){
                        System.out.println("filas  Dolar-> "+modelo.getRowCount());
                        if(!modelo.getValueAt(0, 2).equals("D")){
                            for(int i=0; i<modelo.getRowCount();i++){
                                BigDecimal precioUnitario = new BigDecimal((String) modelo.getValueAt(i, 4));//1
                                BigDecimal subTotal = new BigDecimal((String) modelo.getValueAt(i, 6));//5
                                //System.out.println("Antes : "+precioUnitario+"  -  "+subTotal);
                                tcambio=new BigDecimal(tipoCambio.getTventa());
                                modelo.setValueAt(Util.formatDecimal((precioUnitario.divide(tcambio,2,RoundingMode.HALF_UP)).doubleValue()), i, 4);//1
                                modelo.setValueAt(Util.formatDecimal((subTotal.divide(tcambio,2,RoundingMode.HALF_UP)).doubleValue()), i, 6);//5
                                modelo.setValueAt("D",i,2);
                                //System.out.println("Despues : "+modelo.getValueAt(i, 1)+"  -  "+modelo.getValueAt(i, 4));
                            }
                            jTable1.removeAll();
                            jTable1.setModel(modelo);
                            modelo.fireTableDataChanged();
//                            for(DetalleTicket d: listaDetalles){
//                                concepto = d.getConceptoCobro();
//                                BigDecimal monto = ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getPrecioUnitario();
//                                BigDecimal monto2 = concepto.getPrecioUnitario().divide(tcambio,2,RoundingMode.HALF_UP);
//                                if(monto2.compareTo(monto)==1){
//                                    concepto.setPrecioUnitario(concepto.getPrecioUnitario());
//                                }else{
//                                    concepto.setPrecioUnitario(concepto.getPrecioUnitario().divide(tcambio,2,RoundingMode.HALF_UP));
//                                }
//                                
//                                d.setSubtotal(d.getSubtotal().divide(tcambio,2,RoundingMode.HALF_UP));
//                                
//                            }
                            ticket.calculateTicket();
                            lblTotal.setText(Util.formatDecimal(ticket.getTotal().doubleValue()));
                        }
                        
                    }
                }
                //btnExchangeRate.setEnabled(true);            
            }else{
                SesionData.getSesion().setTipoMoneda("S");
                lblExchangeRate.setText(tipoCambio.getTventa());
                if(modelo!=null){
                    if(modelo.getRowCount()>0){
                        System.out.println("filas  Soles-> "+modelo.getRowCount());
                        if(!modelo.getValueAt(0, 2).equals("S")){
                            for(int i=0; i<modelo.getRowCount();i++){
                                BigDecimal precioUnitario = new BigDecimal((String) modelo.getValueAt(i, 4));//1
                                BigDecimal subTotal = new BigDecimal((String) modelo.getValueAt(i, 6));//5
                                tcambio=new BigDecimal(tipoCambio.getTventa());
                                //aca es para modificar
                                BigDecimal monto =precioUnitario.multiply(tcambio);
                                modelo.setValueAt(Util.formatDecimal(monto.doubleValue()), i, 4);
                                modelo.setValueAt(Util.formatDecimal((subTotal.multiply(tcambio)).doubleValue()), i, 6);
                                modelo.setValueAt("S",i,2);
                                //System.out.println("Despues : "+modelo.getValueAt(i, 1)+"  -  "+modelo.getValueAt(i, 4));
                            }
                            jTable1.removeAll();
                            jTable1.setModel(modelo);
                            modelo.fireTableDataChanged();
//                            for(DetalleTicket d: listaDetalles){
//                                concepto = d.getConceptoCobro();
//                                BigDecimal monto = concepto.getPrecioUnitario().multiply(tcambio);
//                                
//                                concepto.setPrecioUnitario(monto);
//
//                                d.setSubtotal(d.getSubtotal().multiply(tcambio));
//                                
//                            }
                            ticket.calculateTicket();
                            lblTotal.setText(Util.formatDecimal(ticket.getTotal().doubleValue()));
                        }
                    }
                }
                //btnExchangeRate.setEnabled(false);
                
            }
            for(DetalleTicket d: listaDetalles){
                    concepto = d.getConceptoCobro();
                    System.out.println("Concepto Precio :" + concepto.getPrecioUnitario());
                    System.out.println("SubTotal:" + d.getSubtotal());
                    //System.out.println("Total:"+d.);
                } 
            
        }
    }//GEN-LAST:event_jcbTipoMonedaActionPerformed

    private void btnUserMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserMaintenanceActionPerformed
        // TODO add your handling code here:
        if(formUserMaintainer==null){
            formUserMaintainer = new FormUserMaintainer();
            formUserMaintainer.setLocationRelativeTo(null);
            formUserMaintainer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            formUserMaintainer.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            //formUserMaintainer.setSize(710, 135);
            formUserMaintainer.setVisible(true);
        }else{
            formUserMaintainer.setSize(710, 135);
            formUserMaintainer.setVisible(true);
        }
    }//GEN-LAST:event_btnUserMaintenanceActionPerformed

    private void btnProdcutMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdcutMaintenanceActionPerformed
        // TODO add your handling code here:
        if(formProductMaintainer==null){
            
            formProductMaintainer = new FormProductMaintainer();            
            formProductMaintainer.codigoProducto=ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getTipo();
            formProductMaintainer.loadCodigoConcepto();            
            formProductMaintainer.setLocationRelativeTo(null);
            formProductMaintainer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            formProductMaintainer.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            //formUserMaintainer.setSize(710, 135);
            formProductMaintainer.setVisible(true);
        }else{
            formProductMaintainer.codigoProducto=ConceptosDAO.getBeanByIndex(jcbTipoConcepto.getSelectedIndex()).getTipo();
            formProductMaintainer.loadCodigoConcepto(); 
            formProductMaintainer.setVisible(true);
        }
    }//GEN-LAST:event_btnProdcutMaintenanceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        seleccionarMedioPago();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcbVendedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbVendedorItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbVendedorItemStateChanged
 
//jcastillo fin           
    private void sendFile(){
        String to = "scabanillas@derrama.org.pe";
        String from = "scabanillas@derrama.org.pe";
        String host = "demamail01.derrama.org.pe";
        //String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            MimeMultipart mimeMultipart = new MimeMultipart();
            String addressTo[] = to.split(";");
            Address addressArrayTo[] = new InternetAddress[addressTo.length];
            for(int i=0;i<addressTo.length;i++){
                    addressArrayTo[i] =  new InternetAddress(addressTo[i]);
            }
            message.setFrom(new InternetAddress(from));		
            message.addRecipients(Message.RecipientType.TO, addressArrayTo);
            message.setSubject("Archivo");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("Archivos de proceso", "text/html");
            mimeMultipart.addBodyPart(messageBodyPart);
            MimeBodyPart adjuntoBodyPart = new MimeBodyPart();
            adjuntoBodyPart.attachFile(Util.validaArchivoTicket(TipoArchivo.DM.getTipo()));
            adjuntoBodyPart.attachFile(Util.validaArchivoTicket(TipoArchivo.DMD.getTipo()));
            mimeMultipart.addBodyPart(adjuntoBodyPart);
            message.setContent(mimeMultipart, "text/html");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    private void copyFile(){
        try{
            File fileCab = Util.validaArchivoTicket(TipoArchivo.DM.getTipo());
            File fileDet = Util.validaArchivoTicket(TipoArchivo.DMD.getTipo());
            String name = SesionData.getSesion().getIdcompania() + 
                    SesionData.getSesion().getTienda() + 
                    SesionData.getSesion().getPtoventa() + 
                    SesionData.getSesion().getFechaProceso().replaceAll("/", "");
            File fileCabHis = Util.validaArchivoTicket(TipoArchivo.DM.getTipo(), name);
            File fileDetHis = Util.validaArchivoTicket(TipoArchivo.DMD.getTipo(), name);
            File destino = new File(SesionData.getSesion().getCopyFilePath());
            if(destino.isDirectory()){
                Files.copy(
                        Paths.get(fileCab.getPath()), 
                        Paths.get(destino.getPath()+"\\"+fileCab.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
                Files.copy(
                        Paths.get(fileDet.getPath()), 
                        Paths.get(destino.getPath()+"\\"+fileDet.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
                Files.copy(
                        Paths.get(fileCabHis.getPath()), 
                        Paths.get(destino.getPath()+"\\"+fileCabHis.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
                Files.copy(
                        Paths.get(fileDetHis.getPath()), 
                        Paths.get(destino.getPath()+"\\"+fileDetHis.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnCerrarTurno;
    private javax.swing.JButton btnEliminarDetalle;
    private javax.swing.JButton btnExchangeRate;
    private javax.swing.JButton btnImprimeCuadre;
    public static javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnIniciarDia;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnProdcutMaintenance;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSincronizar;
    private javax.swing.JButton btnUserMaintenance;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JComboBox jcbTipoConcepto;
    public static javax.swing.JComboBox jcbTipoDocumento;
    public static javax.swing.JComboBox<String> jcbTipoMoneda;
    public static javax.swing.JComboBox jcbVendedor;
    private javax.swing.JPanel jpnHeader;
    private javax.swing.JPanel jpnUsuario;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCantidad1;
    private javax.swing.JLabel labelCantidad2;
    private javax.swing.JLabel labelSubTotal;
    private javax.swing.JLabel labelTicket;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelTipo1;
    private javax.swing.JLabel labelTipo2;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTotal1;
    private javax.swing.JLabel labelTotal2;
    public static javax.swing.JLabel labelTotal3;
    private javax.swing.JLabel labelTotal4;
    private javax.swing.JLabel lblCompania;
    private javax.swing.JTextField lblContadorDscto;
    private javax.swing.JTextField lblContadorIGV;
    private javax.swing.JTextField lblContadorServ;
    private javax.swing.JTextField lblContadorSubTotal;
    public static javax.swing.JTextField lblExchangeRate;
    private javax.swing.JLabel lblFecha;
    public static javax.swing.JLabel lblFechaProceso;
    private javax.swing.JLabel lblImagen;
    public static javax.swing.JTextField lblPrecioUnitario;
    private javax.swing.JLabel lblPtoVta;
    public static javax.swing.JTextField lblSubTotal;
    public static javax.swing.JTextField lblTicket;
    private javax.swing.JLabel lblTienda;
    private javax.swing.JTextField lblTotal;
    public static javax.swing.JLabel lblTurno;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JLabel scrambledLabel2;
    private javax.swing.JLabel scrambledLabel3;
    private javax.swing.JLabel scrambledLabel4;
    public static javax.swing.JSpinner spnCantidad;
    public static javax.swing.JTextField txtCliente;
    public static javax.swing.JTextField txtDireccionP;
    public static javax.swing.JTextField txtDscto;
    private javax.swing.JTextField txtFiltro;
    public static javax.swing.JTextField txtRUCDNI;
    // End of variables declaration//GEN-END:variables
}

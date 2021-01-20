/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import practica9.GestionIO;
import practica9.Internacionalizacion;
import practica9.Practica9;
import practica9.Registro;
import practica9.Usuario;

/**
 *
 * @author Miguel Angel Gonzalez Gallardo
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    private Usuario u;
    private DefaultListModel modelo;
    private final Internacionalizacion idioma;

    public Principal(Internacionalizacion idioma) {
        initComponents();
        this.idioma = idioma;
        this.setTitle(idioma.nombreAplicacion);
        inicializarMenu();
        jPanelCrearUser.setVisible(false);
        jPanelBorrarUser.setVisible(false);
        jPaneModificarUser.setVisible(false);
        jPanelRegistros.setVisible(false);
        jPanelAjustes.setVisible(false);

        //Operaciones de cierre
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                GestionIO.guardarConfiguracion();
                GestionIO.guardarDatos();
            }
        });

        inicializarJPanelPrincipal();
        this.setVisible(true);
    }

    private void inicializarAjustes() {
        //Inicializacion
        jComboBox1.removeAllItems();
        jComboBox1.addItem(idioma.nombreIdiomaActual);
        for (int i = 0; i < idioma.nombresIdiomas.length; i++) {
            if (!idioma.nombresIdiomas[i].equals(idioma.nombreIdiomaActual)) {
                jComboBox1.addItem(idioma.nombresIdiomas[i]);
            }
        }
        jLabelElegirIdioma.setText(idioma.fraseElegirIdioma);
        botonAplicarAjustes.setText(idioma.fraseAplicar);
        jCheckBoxSonido.setText(idioma.fraseSonido);
        jCheckBoxSonido.setSelected(Practica9.sonido);

        //Accesibilidad
        jComboBox1.getAccessibleContext().setAccessibleName(idioma.fraseElegirIdioma);
        botonAplicarAjustes.getAccessibleContext().setAccessibleName(idioma.fraseAplicar);
        jCheckBoxSonido.getAccessibleContext().setAccessibleName(idioma.fraseSonido);
        this.jCheckBoxSonido.setVisible(true);
        jComboBox1.setVisible(true);
    }

    private void inicializarRegistros() {

        //Inicializacion
        jLabelRegUser.setText(idioma.fraseDNI);
        jLabelRegFechaIni.setText(idioma.fraseFechaIni);
        jLabelFechaFin.setText(idioma.fraseFechaFin);
        jTextRegUserLogin.setText("");
        botonBuscarAsistencias.setText(idioma.fraseOK);
        jLabelRegExplicar.setText(idioma.nombreRegistros);
        modelo = new DefaultListModel();
        Calendar d = Calendar.getInstance();
        jFormattedFechaIni.setText(d.get(Calendar.DATE) + "/" + (d.get(Calendar.MONTH) + 1) + "/" + d.get(Calendar.YEAR));
        jFormattedFechaFin.setText(d.get(Calendar.DATE) + "/" + (d.get(Calendar.MONTH) + 1) + "/" + d.get(Calendar.YEAR));
        jList1.setModel(modelo);

        //Accesibilidad
        jTextRegUserLogin.getAccessibleContext().setAccessibleName(idioma.fraseDNI);
        botonBuscarAsistencias.getAccessibleContext().setAccessibleName(idioma.fraseOK);
        jFormattedFechaIni.getAccessibleContext().setAccessibleName(idioma.fraseFechaIni);
        jFormattedFechaFin.getAccessibleContext().setAccessibleName(idioma.fraseFechaFin);
        this.jCheckBoxSonido.setVisible(false);
        jComboBox1.setVisible(false);
        this.jPanelAjustes.setVisible(true);
    }

    private void inicializarAgregarUser() {
        //Inicializo
        jLabelApellidos.setText(idioma.fraseApellidos);
        jLabelNombre.setText(idioma.fraseNombre);
        jLabelNSS.setText(idioma.fraseNSS);
        jLabelDNI.setText(idioma.fraseDNI);
        jLabelCargo.setText(idioma.fraseCargo);
        jLabelPasswd1.setText(idioma.fraseContrasena);
        jLabelPasswd2.setText(idioma.fraseRepetirContrasena);
        jTextFieldApellidos.setText("");
        jTextFieldCargo.setText("");
        jTextFieldDNI.setText("");
        jTextFieldNSS.setText("");
        jTextFieldNombre.setText("");
        jPasswordField1.setText("");
        jPasswordField2.setText("");
        botonCrearUser.setText(idioma.fraseOK);

        //Accesibilidad
        jTextFieldApellidos.getAccessibleContext().setAccessibleName(idioma.fraseApellidos);
        jTextFieldCargo.getAccessibleContext().setAccessibleName(idioma.fraseCargo);
        jTextFieldDNI.getAccessibleContext().setAccessibleName(idioma.fraseDNI);
        jTextFieldNSS.getAccessibleContext().setAccessibleName(idioma.fraseNSS);
        jTextFieldNombre.getAccessibleContext().setAccessibleName(idioma.fraseNombre);
        jPasswordField1.getAccessibleContext().setAccessibleName(idioma.fraseContrasena);
        jPasswordField2.getAccessibleContext().setAccessibleName(idioma.fraseRepetirContrasena);
    }

    private void inicializarBorrarUser() {
        //Inicializo el contenido de los label
        jLabelDNIaBorrar.setText(idioma.fraseDNI);
        jLabelPassABorrar.setText(idioma.fraseContrasena);
        jLabelAdvertenciaBorrar.setText(idioma.fraseAdvertenciaBorrado);
        jLabelAdvertenciaABorrar2.setText(idioma.fraseConfirmacionBorrado);

        //Vacio los inputs 
        jPasswordABorrar1.setText("");
        jTextFieldDNIaBorrar.setText("");
        jTextFieldConfirmarUser.setText("");

        //Pongo el nombre de los botones
        botonBorrar.setText(idioma.fraseBotonBorrarUser);
        botonConfirmarBorrado.setText(idioma.fraseOK);

        //Accesibilidad
        jPasswordABorrar1.getAccessibleContext().setAccessibleName(idioma.fraseContrasena);
        jLabelDNIaBorrar.getAccessibleContext().setAccessibleName(idioma.fraseDNI);
        botonBorrar.getAccessibleContext().setAccessibleName(idioma.fraseAdvertenciaBorrado);
        botonConfirmarBorrado.getAccessibleContext().setAccessibleName(idioma.fraseConfirmacionBorrado);

        jPanel2.setVisible(false);
        jPanelBorrarUser.setVisible(true);
    }

    private void inicializarMenu() {
        //Inicializo botones
        this.botonAjustes.setIcon(new ImageIcon(idioma.urlIconoAjustes));
        this.botonIrPrincipal.setIcon(new ImageIcon(idioma.urlIconoHome));
        this.botonRegistro.setIcon(new ImageIcon(idioma.urlIconoRegistros));
        this.botonNuevoRegistro.setIcon(new ImageIcon(idioma.urlNuevoRegistro));

        //Accesibilidad
        this.botonAjustes.getAccessibleContext().setAccessibleName(idioma.nombreAjustes);
        this.botonIrPrincipal.getAccessibleContext().setAccessibleName(idioma.nombreHome);
        this.botonRegistro.getAccessibleContext().setAccessibleName(idioma.nombreRegistros);

        this.setTitle(idioma.nombreAplicacion);

        this.repaint();
        this.validate();
    }

    private void inicializarJPanelPrincipal() {
        //Inicializo botones con imagenes
        this.botonAnadirUser.setIcon(new ImageIcon(idioma.urlIconoNuevoUser));
        this.botonBorrarUser.setIcon(new ImageIcon(idioma.urlIconoEliminarUser));
        this.botonModificarDatos.setIcon(new ImageIcon(idioma.urlIconoModificarUser));

        //Accesibilidad
        this.botonAnadirUser.getAccessibleContext().setAccessibleName(idioma.fraseAnadirUser);
        this.botonBorrarUser.getAccessibleContext().setAccessibleName(idioma.fraseDNI);
        this.botonModificarDatos.getAccessibleContext().setAccessibleName(idioma.fraseModificarUser);

        this.jPanelPrincipal.setVisible(true);
        this.repaint();
        this.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAjustes = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelElegirIdioma = new javax.swing.JLabel();
        botonAplicarAjustes = new javax.swing.JButton();
        jCheckBoxSonido = new javax.swing.JCheckBox();
        jPaneModificarUser = new javax.swing.JPanel();
        jLabelIntroDNI = new javax.swing.JLabel();
        jLabelIntroContraseña = new javax.swing.JLabel();
        jPassCambiarPrincipal = new javax.swing.JPasswordField();
        jTextDNIPricipal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabelNombreAcambiar = new javax.swing.JLabel();
        jLabelApellidosAcambiar = new javax.swing.JLabel();
        jLabelCargoAcambiar = new javax.swing.JLabel();
        jLabelPassAcambiar1 = new javax.swing.JLabel();
        jLabelPassAcambiar2 = new javax.swing.JLabel();
        botonConfirmarCambios = new javax.swing.JButton();
        jPasswordAcambiar1 = new javax.swing.JPasswordField();
        jPasswordAcambiar2 = new javax.swing.JPasswordField();
        jTextFieldCargoAcambiar = new javax.swing.JTextField();
        jTextFieldApellidosAcambiar = new javax.swing.JTextField();
        jTextFieldNombreAcambiar = new javax.swing.JTextField();
        jButtonModificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        botonAjustes = new javax.swing.JButton();
        botonIrPrincipal = new javax.swing.JButton();
        botonRegistro = new javax.swing.JButton();
        jPanelPrincipal = new javax.swing.JPanel();
        botonAnadirUser = new javax.swing.JButton();
        botonBorrarUser = new javax.swing.JButton();
        botonModificarDatos = new javax.swing.JButton();
        botonNuevoRegistro = new javax.swing.JButton();
        jPanelBorrarUser = new javax.swing.JPanel();
        jLabelDNIaBorrar = new javax.swing.JLabel();
        jLabelPassABorrar = new javax.swing.JLabel();
        jLabelAdvertenciaBorrar = new javax.swing.JLabel();
        jPasswordABorrar1 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabelAdvertenciaABorrar2 = new javax.swing.JLabel();
        jLabelUsuarioABorrar2 = new javax.swing.JLabel();
        jTextFieldConfirmarUser = new javax.swing.JTextField();
        botonConfirmarBorrado = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        jTextFieldDNIaBorrar = new javax.swing.JTextField();
        jPanelCrearUser = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelDNI = new javax.swing.JLabel();
        jLabelNSS = new javax.swing.JLabel();
        jLabelCargo = new javax.swing.JLabel();
        jLabelPasswd1 = new javax.swing.JLabel();
        jLabelPasswd2 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldCargo = new javax.swing.JTextField();
        jTextFieldDNI = new javax.swing.JTextField();
        jTextFieldNSS = new javax.swing.JTextField();
        botonCrearUser = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanelRegistros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabelRegExplicar = new javax.swing.JLabel();
        jLabelRegUser = new javax.swing.JLabel();
        jLabelRegFechaIni = new javax.swing.JLabel();
        jTextRegUserLogin = new javax.swing.JTextField();
        botonNuevaAsistencia = new javax.swing.JButton();
        botonBuscarAsistencias = new javax.swing.JButton();
        jFormattedFechaIni = new javax.swing.JFormattedTextField();
        jLabelFechaFin = new javax.swing.JLabel();
        jFormattedFechaFin = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelAjustes.setBackground(new java.awt.Color(102, 153, 255));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelElegirIdioma.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelElegirIdioma.setForeground(new java.awt.Color(255, 255, 255));
        jLabelElegirIdioma.setText("Idioma:");

        botonAplicarAjustes.setText("jButton1");
        botonAplicarAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAplicarAjustesActionPerformed(evt);
            }
        });

        jCheckBoxSonido.setText("jCheckBox1");
        jCheckBoxSonido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSonidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAjustesLayout = new javax.swing.GroupLayout(jPanelAjustes);
        jPanelAjustes.setLayout(jPanelAjustesLayout);
        jPanelAjustesLayout.setHorizontalGroup(
            jPanelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAjustesLayout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addGroup(jPanelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAjustesLayout.createSequentialGroup()
                        .addComponent(botonAplicarAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAjustesLayout.createSequentialGroup()
                        .addComponent(jLabelElegirIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAjustesLayout.createSequentialGroup()
                        .addComponent(jCheckBoxSonido, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))))
        );
        jPanelAjustesLayout.setVerticalGroup(
            jPanelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAjustesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelElegirIdioma))
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxSonido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(botonAplicarAjustes)
                .addGap(49, 49, 49))
        );

        jPaneModificarUser.setBackground(new java.awt.Color(102, 153, 255));

        jLabelIntroDNI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIntroDNI.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIntroDNI.setText("Introduce DNI usuario: ");

        jLabelIntroContraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIntroContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIntroContraseña.setText("Introduce constraseña usuario: ");

        jPassCambiarPrincipal.setText("jPasswordField3");

        jTextDNIPricipal.setText("jTextField2");

        jLabelNombreAcambiar.setText("Nombre:");

        jLabelApellidosAcambiar.setText("Apellidos:");

        jLabelCargoAcambiar.setText("Cargo:");

        jLabelPassAcambiar1.setText("Contraseña:");

        jLabelPassAcambiar2.setText("Repetir contraseña:");

        botonConfirmarCambios.setText("jButton2");
        botonConfirmarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarCambiosActionPerformed(evt);
            }
        });

        jPasswordAcambiar1.setText("jPasswordField4");
        jPasswordAcambiar1.setMaximumSize(new java.awt.Dimension(111, 20));
        jPasswordAcambiar1.setMinimumSize(new java.awt.Dimension(111, 20));

        jPasswordAcambiar2.setText("jPasswordField5");
        jPasswordAcambiar2.setMaximumSize(new java.awt.Dimension(111, 20));
        jPasswordAcambiar2.setMinimumSize(new java.awt.Dimension(111, 20));

        jTextFieldCargoAcambiar.setText("jTextField3");

        jTextFieldApellidosAcambiar.setText("jTextField4");

        jTextFieldNombreAcambiar.setText("jTextField5");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(botonConfirmarCambios))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabelPassAcambiar2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPasswordAcambiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(175, 175, 175)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldApellidosAcambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldNombreAcambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabelPassAcambiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(79, 79, 79)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPasswordAcambiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldCargoAcambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabelApellidosAcambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombreAcambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCargoAcambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreAcambiar)
                    .addComponent(jTextFieldNombreAcambiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelApellidosAcambiar)
                    .addComponent(jTextFieldApellidosAcambiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCargoAcambiar)
                    .addComponent(jTextFieldCargoAcambiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordAcambiar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPassAcambiar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordAcambiar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPassAcambiar2))
                .addGap(30, 30, 30)
                .addComponent(botonConfirmarCambios)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jButtonModificar.setText("jButton1");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPaneModificarUserLayout = new javax.swing.GroupLayout(jPaneModificarUser);
        jPaneModificarUser.setLayout(jPaneModificarUserLayout);
        jPaneModificarUserLayout.setHorizontalGroup(
            jPaneModificarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneModificarUserLayout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addGroup(jPaneModificarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneModificarUserLayout.createSequentialGroup()
                        .addComponent(jButtonModificar)
                        .addGap(203, 203, 203))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneModificarUserLayout.createSequentialGroup()
                        .addGroup(jPaneModificarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPaneModificarUserLayout.createSequentialGroup()
                                .addGroup(jPaneModificarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIntroDNI, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelIntroContraseña, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPaneModificarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextDNIPricipal)
                                    .addComponent(jPassCambiarPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPaneModificarUserLayout.setVerticalGroup(
            jPaneModificarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneModificarUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneModificarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDNIPricipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIntroDNI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPaneModificarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassCambiarPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIntroContraseña))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botonAjustes.setBorderPainted(false);
        botonAjustes.setContentAreaFilled(false);
        botonAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAjustesActionPerformed(evt);
            }
        });

        botonIrPrincipal.setBorder(null);
        botonIrPrincipal.setBorderPainted(false);
        botonIrPrincipal.setContentAreaFilled(false);
        botonIrPrincipal.setMaximumSize(new java.awt.Dimension(80, 80));
        botonIrPrincipal.setMinimumSize(new java.awt.Dimension(80, 80));
        botonIrPrincipal.setPreferredSize(new java.awt.Dimension(80, 80));
        botonIrPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIrPrincipalActionPerformed(evt);
            }
        });

        botonRegistro.setBorderPainted(false);
        botonRegistro.setContentAreaFilled(false);
        botonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonIrPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonIrPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(botonAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelPrincipal.setBackground(new java.awt.Color(102, 153, 255));

        botonAnadirUser.setBorder(null);
        botonAnadirUser.setBorderPainted(false);
        botonAnadirUser.setContentAreaFilled(false);
        botonAnadirUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirUserActionPerformed(evt);
            }
        });

        botonBorrarUser.setBorder(null);
        botonBorrarUser.setBorderPainted(false);
        botonBorrarUser.setContentAreaFilled(false);
        botonBorrarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarUserActionPerformed(evt);
            }
        });

        botonModificarDatos.setBorder(null);
        botonModificarDatos.setBorderPainted(false);
        botonModificarDatos.setContentAreaFilled(false);
        botonModificarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarDatosActionPerformed(evt);
            }
        });

        botonNuevoRegistro.setBorder(null);
        botonNuevoRegistro.setBorderPainted(false);
        botonNuevoRegistro.setContentAreaFilled(false);
        botonNuevoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAnadirUser, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(botonModificarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                        .addComponent(botonBorrarUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonNuevoRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonAnadirUser, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(botonBorrarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(botonModificarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(botonNuevoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanelBorrarUser.setBackground(new java.awt.Color(102, 153, 255));

        jLabelDNIaBorrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDNIaBorrar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDNIaBorrar.setText("DNI Usuario a borrar:");

        jLabelPassABorrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPassABorrar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassABorrar.setText("Contraseña:");

        jLabelAdvertenciaBorrar.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabelAdvertenciaBorrar.setForeground(new java.awt.Color(153, 255, 153));
        jLabelAdvertenciaBorrar.setText("El usuario y todos los datos asociados a él se borrarán permanentemente.");

        jPasswordABorrar1.setText("jPasswordField3");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelAdvertenciaABorrar2.setText("Si realmente quiere borrar el usuario escriba: ");

        jLabelUsuarioABorrar2.setText("jLabel6");

        jTextFieldConfirmarUser.setText("jTextField2");

        botonConfirmarBorrado.setText("jButton2");
        botonConfirmarBorrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarBorradoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelAdvertenciaABorrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelUsuarioABorrar2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(botonConfirmarBorrado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jTextFieldConfirmarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdvertenciaABorrar2)
                    .addComponent(jLabelUsuarioABorrar2))
                .addGap(18, 18, 18)
                .addComponent(jTextFieldConfirmarUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(botonConfirmarBorrado)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        botonBorrar.setText("jButton1");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        jTextFieldDNIaBorrar.setText("jTextField2");

        javax.swing.GroupLayout jPanelBorrarUserLayout = new javax.swing.GroupLayout(jPanelBorrarUser);
        jPanelBorrarUser.setLayout(jPanelBorrarUserLayout);
        jPanelBorrarUserLayout.setHorizontalGroup(
            jPanelBorrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBorrarUserLayout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(jPanelBorrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAdvertenciaBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBorrarUserLayout.createSequentialGroup()
                        .addGroup(jPanelBorrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelDNIaBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(jLabelPassABorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBorrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDNIaBorrar)
                            .addComponent(jPasswordABorrar1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelBorrarUserLayout.setVerticalGroup(
            jPanelBorrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBorrarUserLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanelBorrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDNIaBorrar)
                    .addComponent(jTextFieldDNIaBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBorrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassABorrar)
                    .addComponent(jPasswordABorrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBorrar))
                .addGap(18, 18, 18)
                .addComponent(jLabelAdvertenciaBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanelCrearUser.setBackground(new java.awt.Color(102, 153, 255));
        jPanelCrearUser.setPreferredSize(new java.awt.Dimension(447, 389));

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombre");

        jLabelApellidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelApellidos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellidos.setText("Apellidos");

        jLabelDNI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDNI.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDNI.setText("DNI");

        jLabelNSS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNSS.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNSS.setText("Nº Seguridad Social:");

        jLabelCargo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCargo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCargo.setText("Cargo");

        jLabelPasswd1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPasswd1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPasswd1.setText("Contraseña");

        jLabelPasswd2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPasswd2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPasswd2.setText("Repite Contraseña");

        jTextFieldDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDNIActionPerformed(evt);
            }
        });

        botonCrearUser.setText("jButton1");
        botonCrearUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCrearUserLayout = new javax.swing.GroupLayout(jPanelCrearUser);
        jPanelCrearUser.setLayout(jPanelCrearUserLayout);
        jPanelCrearUserLayout.setHorizontalGroup(
            jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrearUserLayout.createSequentialGroup()
                .addGap(31, 81, Short.MAX_VALUE)
                .addGroup(jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCrearUserLayout.createSequentialGroup()
                        .addGroup(jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCrearUserLayout.createSequentialGroup()
                                .addComponent(jLabelCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCrearUserLayout.createSequentialGroup()
                                .addComponent(jLabelPasswd2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCrearUserLayout.createSequentialGroup()
                                .addComponent(jLabelPasswd1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1)))
                        .addGap(0, 95, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCrearUserLayout.createSequentialGroup()
                        .addGroup(jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelCrearUserLayout.createSequentialGroup()
                                .addGroup(jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelApellidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDNI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                            .addGroup(jPanelCrearUserLayout.createSequentialGroup()
                                .addComponent(jLabelNSS, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldNSS, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCrearUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonCrearUser)
                .addGap(185, 185, 185))
        );
        jPanelCrearUserLayout.setVerticalGroup(
            jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrearUserLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombre))
                .addGap(18, 18, 18)
                .addGroup(jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellidos)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDNI)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNSS)
                    .addComponent(jTextFieldNSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCargo)
                    .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPasswd1)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCrearUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPasswd2)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(botonCrearUser)
                .addGap(36, 36, 36))
        );

        jPanelRegistros.setBackground(new java.awt.Color(102, 153, 255));
        jPanelRegistros.setPreferredSize(new java.awt.Dimension(447, 389));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabelRegExplicar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelRegExplicar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegExplicar.setText("Ultimos registros");

        jLabelRegUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelRegUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegUser.setText("Usuario:");

        jLabelRegFechaIni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelRegFechaIni.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegFechaIni.setText("Fecha Inicio:");

        botonNuevaAsistencia.setBorder(null);
        botonNuevaAsistencia.setBorderPainted(false);
        botonNuevaAsistencia.setContentAreaFilled(false);
        botonNuevaAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaAsistenciaActionPerformed(evt);
            }
        });

        botonBuscarAsistencias.setText("jButton1");
        botonBuscarAsistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarAsistenciasActionPerformed(evt);
            }
        });

        jFormattedFechaIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/MM/yyyy"))));

        jLabelFechaFin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelFechaFin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFechaFin.setText("Fecha Fin:");

        jFormattedFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/MM/yyyy"))));

        javax.swing.GroupLayout jPanelRegistrosLayout = new javax.swing.GroupLayout(jPanelRegistros);
        jPanelRegistros.setLayout(jPanelRegistrosLayout);
        jPanelRegistrosLayout.setHorizontalGroup(
            jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrosLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelRegistrosLayout.createSequentialGroup()
                        .addGroup(jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelRegistrosLayout.createSequentialGroup()
                                .addComponent(jLabelRegUser, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124))
                            .addComponent(jLabelRegExplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(botonNuevaAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(jPanelRegistrosLayout.createSequentialGroup()
                        .addGroup(jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRegistrosLayout.createSequentialGroup()
                                .addComponent(jLabelFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelRegistrosLayout.createSequentialGroup()
                                .addComponent(jLabelRegFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextRegUserLogin)
                                    .addComponent(jFormattedFechaIni))
                                .addGap(53, 53, 53)
                                .addComponent(botonBuscarAsistencias)))
                        .addGap(49, 49, 49)))
                .addContainerGap())
        );
        jPanelRegistrosLayout.setVerticalGroup(
            jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRegUser, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextRegUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRegFechaIni)
                    .addComponent(jFormattedFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarAsistencias))
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonNuevaAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelRegistrosLayout.createSequentialGroup()
                        .addGroup(jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFechaFin)
                            .addComponent(jFormattedFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jLabelRegExplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 100, Short.MAX_VALUE)
                    .addComponent(jPanelCrearUser, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 62, Short.MAX_VALUE)
                    .addComponent(jPanelBorrarUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPaneModificarUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 98, Short.MAX_VALUE)
                    .addComponent(jPanelRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 67, Short.MAX_VALUE)
                    .addComponent(jPanelAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelCrearUser, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelBorrarUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPaneModificarUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAjustesActionPerformed
        jPanelCrearUser.setVisible(false);
        jPanelBorrarUser.setVisible(false);
        jPaneModificarUser.setVisible(false);
        jPanelPrincipal.setVisible(false);
        jPanelRegistros.setVisible(false);
        jPanelAjustes.setVisible(true);
        inicializarAjustes();
    }//GEN-LAST:event_botonAjustesActionPerformed

    private void botonIrPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIrPrincipalActionPerformed
        this.jPaneModificarUser.setVisible(false);
        this.jPanelBorrarUser.setVisible(false);
        this.jPanelCrearUser.setVisible(false);
        this.jPanelRegistros.setVisible(false);
        this.jPanelAjustes.setVisible(false);
        this.jPanelPrincipal.setVisible(true);
    }//GEN-LAST:event_botonIrPrincipalActionPerformed

    private void botonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistroActionPerformed
        this.jPaneModificarUser.setVisible(false);
        this.jPanelAjustes.setVisible(false);
        this.jPanelBorrarUser.setVisible(false);
        this.jPanelCrearUser.setVisible(false);
        this.jPanelPrincipal.setVisible(false);
        inicializarRegistros();
        this.jPanelRegistros.setVisible(true);
    }//GEN-LAST:event_botonRegistroActionPerformed

    private void botonAnadirUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirUserActionPerformed
        this.jPanelAjustes.setVisible(false);
        this.jPanelPrincipal.setVisible(false);
        //Reseteo valores del panel de crear usuario
        inicializarAgregarUser();
        this.jPanelCrearUser.setVisible(true);

    }//GEN-LAST:event_botonAnadirUserActionPerformed

    private void jTextFieldDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDNIActionPerformed

    private void botonCrearUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearUserActionPerformed
        boolean correcto = false;
        //Valido que se hayan rellenado todos los campos y que las contraseñas coincidan
        try {
            if (jTextFieldApellidos.getText().isEmpty()
                    || jTextFieldCargo.getText().isEmpty()
                    || jTextFieldDNI.getText().isEmpty()
                    || jTextFieldNSS.getText().isEmpty()
                    || jTextFieldNombre.getText().isEmpty()
                    || jPasswordField1.getPassword().length == 0
                    || jPasswordField2.getPassword().length == 0) {
                ErrorAlert error = new ErrorAlert(idioma, 0);
            } else {
                if (existeUser(jTextFieldDNI.getText())) {
                    ErrorAlert error = new ErrorAlert(idioma, 2);
                } else {
                    String p1 = String.copyValueOf(jPasswordField1.getPassword());
                    String p2 = String.copyValueOf(jPasswordField2.getPassword());
                    if (!p1.equals(p2)) {
                        ErrorAlert error = new ErrorAlert(idioma, 1);
                    } else {
                        notificarAlert notificacion = new notificarAlert(idioma, 0);
                        String p = String.copyValueOf(jPasswordField1.getPassword());
                        Usuario u = new Usuario(jTextFieldDNI.getText(), jTextFieldNSS.getText(), jTextFieldNombre.getText(), jTextFieldApellidos.getText(), jTextFieldCargo.getText(), p);
                        Practica9.usuarios.add(u);
                        correcto = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (correcto) {
            this.jPanelCrearUser.setVisible(false);
            this.jPanelPrincipal.setVisible(true);
            //Reseteo los jTextField
            resetearJFieldFormularioNuevoUser();
        }

    }//GEN-LAST:event_botonCrearUserActionPerformed

    private void botonBorrarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarUserActionPerformed
        this.jPanelPrincipal.setVisible(false);
        this.jPanelCrearUser.setVisible(false);
        this.inicializarBorrarUser();
    }//GEN-LAST:event_botonBorrarUserActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        if (!existeUser(jTextFieldDNIaBorrar.getText())) {
            try {
                ErrorAlert error = new ErrorAlert(idioma, 3);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            boolean valido = false;
            for (int i = 0; i < Practica9.usuarios.size(); i++) {
                if (jTextFieldDNIaBorrar.getText().equals(Practica9.usuarios.get(i).getDNI())
                        && Practica9.usuarios.get(i).comprobarContraseña(String.copyValueOf(jPasswordABorrar1.getPassword()))) {
                    valido = true;
                    break;
                }
            }
            if (valido) {
                jLabelUsuarioABorrar2.setText(jTextFieldDNIaBorrar.getText());
                jPanel2.setVisible(true);
            } else {
                try {
                    ErrorAlert error = new ErrorAlert(idioma, 1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonConfirmarBorradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarBorradoActionPerformed
        if (!jTextFieldDNIaBorrar.getText().equals(jTextFieldConfirmarUser.getText())) {
            try {
                ErrorAlert error = new ErrorAlert(idioma, 4);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            //Aqui se borra el usuario

            for (int i = 0; i < Practica9.usuarios.size(); i++) {
                if (Practica9.usuarios.get(i).getDNI().equals(jTextFieldDNIaBorrar.getText())) {
                    Practica9.usuarios.remove(i);
                    break;
                }
            }
            //Borro registros del usuario
            //Comentar esto si no se quiere borrar esto
            Iterator it = Practica9.registros.iterator();
            while (it.hasNext()) {
                Registro r = (Registro) it.next();
                if (r.user.equals(jTextFieldDNIaBorrar.getText())) {
                    it.remove();
                }
            }

            try {
                notificarAlert n = new notificarAlert(idioma, 1);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            this.jPanelBorrarUser.setVisible(false);
            inicializarJPanelPrincipal();
        }
    }//GEN-LAST:event_botonConfirmarBorradoActionPerformed

    private void botonModificarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarDatosActionPerformed
        inicializarModificarUser();
    }//GEN-LAST:event_botonModificarDatosActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (jTextDNIPricipal.getText().isEmpty() || jPassCambiarPrincipal.getPassword().length == 0) {
            try {
                ErrorAlert e = new ErrorAlert(idioma, 0);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            //Miro si existe el usuario
            u = null;
            for (int i = 0; i < Practica9.usuarios.size(); i++) {
                if (jTextDNIPricipal.getText().equals(Practica9.usuarios.get(i).getDNI()) && Practica9.usuarios.get(i).comprobarContraseña(String.copyValueOf(jPassCambiarPrincipal.getPassword()))) {
                    u = Practica9.usuarios.get(i);
                    break;
                }
            }
            if (u == null) {
                try {
                    ErrorAlert e = new ErrorAlert(idioma, 3);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                //Inicializo inputs
                jTextFieldApellidosAcambiar.setText(u.getApellidos());
                jTextFieldCargoAcambiar.setText(u.getCargo());
                jTextFieldNombreAcambiar.setText(u.getNombre());
                jPasswordAcambiar1.setText("");
                jPasswordAcambiar2.setText("");
                botonConfirmarCambios.setText(idioma.fraseOK);
                jPanel3.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void botonConfirmarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarCambiosActionPerformed
        if (jTextFieldApellidosAcambiar.getText().isEmpty()
                || jTextFieldCargoAcambiar.getText().isEmpty()
                || jTextFieldNombreAcambiar.getText().isEmpty()) {
            try {
                ErrorAlert e = new ErrorAlert(idioma, 0);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            if (jPasswordAcambiar1.getPassword().length > 0) {
                String p1 = String.copyValueOf(jPasswordAcambiar1.getPassword());
                String p2 = String.copyValueOf(jPasswordAcambiar2.getPassword());
                if (!p1.equals(p2)) {
                    try {
                        ErrorAlert e = new ErrorAlert(idioma, 1);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    u.setPassword(p1);
                }
            }
        }
        u.setApellidos(jTextFieldApellidosAcambiar.getText());
        u.setCargo(jTextFieldCargoAcambiar.getText());
        u.setNombre(jTextFieldNombreAcambiar.getText());
        this.jPanel3.setVisible(false);
        this.jPaneModificarUser.setVisible(false);
        this.jPanelPrincipal.setVisible(true);
        u = null;
    }//GEN-LAST:event_botonConfirmarCambiosActionPerformed

    private Date getFecha(String cad) {
        String d = "", m = "", a = "";
        int i = 0;
        for (; i < cad.length(); i++) {
            if (cad.charAt(i) == '/') {
                break;
            } else {
                d += cad.charAt(i);
            }
        }
        ++i;
        for (; i < cad.length(); i++) {
            if (cad.charAt(i) == '/') {
                break;
            } else {
                m += cad.charAt(i);
            }
        }
        ++i;
        for (; i < cad.length(); i++) {
            a += cad.charAt(i);
        }
        if (a.length() != 4 || d.length() == 0 || m.length() == 0) {
            return null;
        }
        return new Date(Integer.parseInt(a), Integer.parseInt(m), Integer.parseInt(d));
    }

    private void botonBuscarAsistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarAsistenciasActionPerformed
        long f1, f2;
        if (getFecha(jFormattedFechaIni.getText()) == null || getFecha(jFormattedFechaFin.getText()) == null) {
            try {
                ErrorAlert erro = new ErrorAlert(idioma, 5);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            f1 = getFecha(jFormattedFechaIni.getText()).getTime();
            f2 = getFecha(jFormattedFechaFin.getText()).getTime();
            if (f1 > f2) {
                long aux = f1;
                f1 = f2;
                f2 = aux;
            }
            modelo.clear();
            for (int i = 0; i < Practica9.registros.size(); i++) {
                if (Practica9.registros.get(i).user.equals(jTextRegUserLogin.getText())
                        && Practica9.registros.get(i).estaEnIntervalo(f1, f2)) {
                    modelo.addElement(Practica9.registros.get(i).presentar(idioma));
                }
            }
        }
    }//GEN-LAST:event_botonBuscarAsistenciasActionPerformed

    private void botonNuevaAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaAsistenciaActionPerformed

    }//GEN-LAST:event_botonNuevaAsistenciaActionPerformed

    private void botonAplicarAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAplicarAjustesActionPerformed
        idioma.elegirIdioma((String) jComboBox1.getSelectedItem());
        Practica9.sonido = jCheckBoxSonido.isSelected();
        inicializarAjustes();
        inicializarJPanelPrincipal();
        this.jPanelPrincipal.setVisible(false);
        inicializarMenu();

    }//GEN-LAST:event_botonAplicarAjustesActionPerformed

    private void jCheckBoxSonidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSonidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxSonidoActionPerformed

    private void botonNuevoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoRegistroActionPerformed
        this.setEnabled(false);
        nuevaAsistencia na = new nuevaAsistencia(this, idioma);
        this.jPanelRegistros.setVisible(false);
        inicializarJPanelPrincipal();
    }//GEN-LAST:event_botonNuevoRegistroActionPerformed

    private boolean existeUser(String _DNI) {
        for (int i = 0; i < Practica9.usuarios.size(); i++) {
            if (Practica9.usuarios.get(i).getDNI().equals(_DNI)) {
                return true;
            }
        }
        return false;
    }

    private void resetearJFieldFormularioNuevoUser() {
        jTextFieldApellidos.setText("");
        jTextFieldCargo.setText("");
        jTextFieldDNI.setText("");
        jTextFieldNSS.setText("");
        jTextFieldNombre.setText("");
        jPasswordField1.setText("");
        jPasswordField2.setText("");
    }

    private void inicializarModificarUser() {
        //Inicializar elementos
        jLabelIntroDNI.setText(idioma.fraseDNI);
        jLabelIntroContraseña.setText(idioma.fraseContrasena);
        jLabelPassAcambiar1.setText(idioma.fraseContrasena);
        jLabelPassAcambiar2.setText(idioma.fraseRepetirContrasena);
        jLabelCargoAcambiar.setText(idioma.fraseCargo);
        jLabelNombreAcambiar.setText(idioma.fraseNombre);
        jLabelApellidosAcambiar.setText(idioma.fraseApellidos);

        jButtonModificar.setText(idioma.fraseModificar);
        jTextDNIPricipal.setText("");
        jPassCambiarPrincipal.setText("");
        this.jPanel3.setVisible(false);

        //Accesibilidad
        jButtonModificar.getAccessibleContext().setAccessibleName(idioma.fraseModificar);
        jTextDNIPricipal.getAccessibleContext().setAccessibleName(idioma.fraseDNI);
        jPassCambiarPrincipal.getAccessibleContext().setAccessibleName(idioma.fraseContrasena);
        jTextFieldApellidosAcambiar.getAccessibleContext().setAccessibleName(idioma.fraseApellidos);
        jTextFieldCargoAcambiar.getAccessibleContext().setAccessibleName(idioma.fraseCargo);
        jTextFieldNombreAcambiar.getAccessibleContext().setAccessibleName(idioma.fraseNombre);
        jPasswordAcambiar1.getAccessibleContext().setAccessibleName(idioma.fraseContrasena);
        jPasswordAcambiar2.getAccessibleContext().setAccessibleName(idioma.fraseContrasena);

        this.jPanelPrincipal.setVisible(false);
        this.jPanelBorrarUser.setVisible(false);
        this.jPanelCrearUser.setVisible(false);
        this.jPaneModificarUser.setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAjustes;
    private javax.swing.JButton botonAnadirUser;
    private javax.swing.JButton botonAplicarAjustes;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonBorrarUser;
    private javax.swing.JButton botonBuscarAsistencias;
    private javax.swing.JButton botonConfirmarBorrado;
    private javax.swing.JButton botonConfirmarCambios;
    private javax.swing.JButton botonCrearUser;
    private javax.swing.JButton botonIrPrincipal;
    private javax.swing.JButton botonModificarDatos;
    private javax.swing.JButton botonNuevaAsistencia;
    private javax.swing.JButton botonNuevoRegistro;
    private javax.swing.JButton botonRegistro;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JCheckBox jCheckBoxSonido;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedFechaFin;
    private javax.swing.JFormattedTextField jFormattedFechaIni;
    private javax.swing.JLabel jLabelAdvertenciaABorrar2;
    private javax.swing.JLabel jLabelAdvertenciaBorrar;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelApellidosAcambiar;
    private javax.swing.JLabel jLabelCargo;
    private javax.swing.JLabel jLabelCargoAcambiar;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelDNIaBorrar;
    private javax.swing.JLabel jLabelElegirIdioma;
    private javax.swing.JLabel jLabelFechaFin;
    private javax.swing.JLabel jLabelIntroContraseña;
    private javax.swing.JLabel jLabelIntroDNI;
    private javax.swing.JLabel jLabelNSS;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombreAcambiar;
    private javax.swing.JLabel jLabelPassABorrar;
    private javax.swing.JLabel jLabelPassAcambiar1;
    private javax.swing.JLabel jLabelPassAcambiar2;
    private javax.swing.JLabel jLabelPasswd1;
    private javax.swing.JLabel jLabelPasswd2;
    private javax.swing.JLabel jLabelRegExplicar;
    private javax.swing.JLabel jLabelRegFechaIni;
    private javax.swing.JLabel jLabelRegUser;
    private javax.swing.JLabel jLabelUsuarioABorrar2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPaneModificarUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelAjustes;
    private javax.swing.JPanel jPanelBorrarUser;
    private javax.swing.JPanel jPanelCrearUser;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelRegistros;
    private javax.swing.JPasswordField jPassCambiarPrincipal;
    private javax.swing.JPasswordField jPasswordABorrar1;
    private javax.swing.JPasswordField jPasswordAcambiar1;
    private javax.swing.JPasswordField jPasswordAcambiar2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextDNIPricipal;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldApellidosAcambiar;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldCargoAcambiar;
    private javax.swing.JTextField jTextFieldConfirmarUser;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldDNIaBorrar;
    private javax.swing.JTextField jTextFieldNSS;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombreAcambiar;
    private javax.swing.JTextField jTextRegUserLogin;
    // End of variables declaration//GEN-END:variables
}

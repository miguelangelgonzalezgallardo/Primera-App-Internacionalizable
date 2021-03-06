/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import practica9.Internacionalizacion;
import practica9.Practica9;
import practica9.Registro;

/**
 *
 * @author Miguel Angel Gonzalez Gallardo
 */
public class nuevaAsistencia extends javax.swing.JFrame {

    /**
     * Creates new form nuevaAsistencia
     */
    private final JFrame padre;
    private final Internacionalizacion idi;

    public nuevaAsistencia(JFrame Padre, Internacionalizacion idioma) {
        padre = Padre;
        idi = idioma;
        initComponents();

        //Inicializar
        this.setTitle(idioma.fraseNuevoRegistro);
        jLabelDNI.setText(idioma.fraseDNI);
        jLabelEvento.setText(idioma.fraseEvento);
        jLabelObservaciones.setText(idioma.fraseObservaciones);
        jLabelPassword.setText(idioma.fraseContrasena);
        jTextFieldDNI.setText("");
        jPassword.setText("");
        jTextArea1.setText("");
        jComboBox1.removeAllItems();
        jComboBox1.addItem(idioma.fraseLlegada);
        jComboBox1.addItem(idioma.fraseSalida);
        BotonRegistrar.setText(idioma.fraseOK);

        //Accesibilidad
        jPassword.getAccessibleContext().setAccessibleName(idioma.fraseContrasena);
        jTextFieldDNI.getAccessibleContext().setAccessibleName(idioma.fraseDNI);
        jTextArea1.getAccessibleContext().setAccessibleName(idioma.fraseObservaciones);
        jComboBox1.getAccessibleContext().setAccessibleName(idioma.fraseEvento);
        BotonRegistrar.getAccessibleContext().setAccessibleName(idioma.fraseOK);

        //Operaciones de cierre
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                padre.setEnabled(true);
                padre.setVisible(true);
            }
        });

        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelObservaciones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelEvento = new javax.swing.JLabel();
        BotonRegistrar = new javax.swing.JButton();
        jLabelDNI = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldDNI = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jLabelObservaciones.setText("Observaciones:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelEvento.setText("Evento:");

        BotonRegistrar.setText("jButton1");
        BotonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistrarActionPerformed(evt);
            }
        });

        jLabelDNI.setText("DNI USER:");

        jLabelPassword.setText("PASS USER:");

        jTextFieldDNI.setText("jTextField1");

        jPassword.setText("jPasswordField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEvento)
                    .addComponent(jLabelDNI)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPassword)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelObservaciones)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonRegistrar)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarActionPerformed
        int usu = -1; //Indice al usuario que registra la asistencia
        for (int i = 0; i < Practica9.usuarios.size(); i++) {
            if (Practica9.usuarios.get(i).getDNI().equals(jTextFieldDNI.getText()) && Practica9.usuarios.get(i).comprobarContraseña(jPassword.getPassword())) {
                usu = i;
            }
        }
        if (usu == -1) {//Si no se ha encontrado el usuario o contraseña incorrecta, error
            try {
                ErrorAlert error = new ErrorAlert(idi, 3);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            this.setVisible(false);//Me oculto
            padre.setEnabled(true);//Activo a la vista padre
            if (jComboBox1.getSelectedItem().equals(idi.fraseLlegada)) {//Añado el registro a la estructura de datos
                Practica9.registros.add(new Registro(Practica9.usuarios.get(usu), jTextArea1.getText(), 'l'));
            } else {
                Practica9.registros.add(new Registro(Practica9.usuarios.get(usu), jTextArea1.getText(), 's'));
            }
            this.dispose();//libero recursos
            try {
                notificarAlert n = new notificarAlert(idi, 2);//notifico
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            padre.setVisible(true);//Si no se pone, la vista padre se minimiza 
        }
    }//GEN-LAST:event_BotonRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonRegistrar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelEvento;
    private javax.swing.JLabel jLabelObservaciones;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldDNI;
    // End of variables declaration//GEN-END:variables
}

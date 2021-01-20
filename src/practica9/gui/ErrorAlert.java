/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9.gui;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import practica9.Internacionalizacion;
import practica9.Practica9;

/**
 *
 * @author Miguel Angel Gonzalez Gallardo
 */
public class ErrorAlert extends javax.swing.JFrame {

    /**
     * Creates new form ErrorAlert
     */
    public ErrorAlert(Internacionalizacion idioma, int codigoError) throws Exception {
        initComponents();

        //Pongo la imagen
        imagen.setIcon(new ImageIcon(idioma.urlErrorAlertImage));

        //Pongo la informacion
        this.setTitle(idioma.getTitleAlertError(codigoError));
        labelFrase.setText(idioma.getAlertError(codigoError));
        boton.setText(idioma.fraseOK);

        //Informacion de accesibilidad
        this.getAccessibleContext().setAccessibleName(idioma.getTitleAlertError(codigoError));
        this.getAccessibleContext().setAccessibleDescription(idioma.getAlertError(codigoError));
        this.boton.getAccessibleContext().setAccessibleName(idioma.fraseOK);

        this.setVisible(true);

        //Ejecuto sonido
        if (Practica9.sonido) {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream(new File(idioma.urlSonidoError)));
            sonido.start();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton = new javax.swing.JButton();
        labelFrase = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Error");
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(550, 220));
        setMinimumSize(new java.awt.Dimension(550, 220));
        setPreferredSize(new java.awt.Dimension(550, 220));
        setResizable(false);

        boton.setText("jButton1");
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });

        labelFrase.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFrase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(boton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelFrase, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(boton)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Error Alert");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_botonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel labelFrase;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import agentes.AgenteDemo;
import agentes.AgenteEsqueleto;

/**
 *
 */
public class FinalizacionDialog extends javax.swing.JDialog {

    private AgenteDemo myAgent;
    private AgenteEsqueleto esqueleto;
    private String tipo;

    /**
     * Creates new form SalidaDialog
     *
     * @param parent
     * @param modal
     * @param myAgent
     */
    public FinalizacionDialog(java.awt.Frame parent, boolean modal, AgenteDemo myAgent) {
        super(parent, modal);
        initComponents();
        this.myAgent = myAgent;
        this.setTitle("Finalizar " + this.myAgent.getName());
        tipo = "demo";
    }

    /**
     * Creates new form SalidaDialog
     *
     * @param parent
     * @param modal
     * @param ag
     */
    public FinalizacionDialog(java.awt.Frame parent, boolean modal, AgenteEsqueleto ag) {
        super(parent, modal);
        initComponents();
        this.esqueleto = ag;
        this.setTitle("Finalizar " + this.esqueleto.getName());
        tipo = "esqueleto";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonFin = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Finalizar");

        botonFin.setText("Finalizar");
        botonFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(botonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(botonFin)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonFin)
                    .addComponent(botonCancelar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinActionPerformed
        // TODO add your handling code here:
        if ("demo".equals(tipo)) {
            myAgent.doDelete();
            this.dispose();
        } else if ("esqueleto".equals(tipo)) {
            esqueleto.doDelete();
            this.dispose();
        }
    }//GEN-LAST:event_botonFinActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonFin;
    // End of variables declaration//GEN-END:variables
}

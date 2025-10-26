/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.clinicaapp.Presentacion.AdminMedicos;

import com.mycompany.clinicaapp.Modelos.Especialidad;
import com.mycompany.clinicaapp.Modelos.Medico;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author johan
 */
public class VentanaEditarMedico extends javax.swing.JPanel {

    private Medico medico;
    
    
    public VentanaEditarMedico(Medico medico) {
        this.medico=medico;
        initComponents();
        cargarDatos();
        tablaEdicion.getTableHeader().setReorderingAllowed(false);
        tablaEdicion.setShowGrid(true);
        tablaEdicion.setGridColor(Color.LIGHT_GRAY);
        
        
    }
    private void cargarDatos(){
        if(medico !=null){
            
        
        DefaultTableModel model= (DefaultTableModel) tablaEdicion.getModel();
        model.setRowCount(0);
        model.addRow(new Object[]{
            medico.getNombre(),
            medico.getCedula(),
            medico.getEspecialidad().getNombre()
        });
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEdicion = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        aceptarCambios = new javax.swing.JButton();

        tablaEdicion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Nombre", "Cedula", "Especialidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaEdicion.setRowHeight(40);
        jScrollPane2.setViewportView(tablaEdicion);
        if (tablaEdicion.getColumnModel().getColumnCount() > 0) {
            tablaEdicion.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        aceptarCambios.setText("Confirmar Cambios");
        aceptarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aceptarCambios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                    VentanaMedica panel = new VentanaMedica();
                    panel.setSize(this.getSize());
                    panel.setLocation(0, 0);
                    java.awt.Window window = SwingUtilities.getWindowAncestor(this);
                    if (window instanceof JFrame frame) {
                        frame.setContentPane(panel);
                        frame.revalidate();
                        frame.repaint();
                    }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void aceptarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarCambiosActionPerformed
      medico.setNombre(tablaEdicion.getValueAt(0, 0).toString());
      medico.setCedula(tablaEdicion.getValueAt(0, 1).toString());
      Especialidad especialidad= new Especialidad(tablaEdicion.getValueAt(0, 2).toString());
      medico.setEspecialidad(especialidad);
        JOptionPane.showMessageDialog(null,"Cambios realizados con éxito",null,JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_aceptarCambiosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarCambios;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaEdicion;
    // End of variables declaration//GEN-END:variables
}

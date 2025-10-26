/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.Utilidades;
import com.mycompany.clinicaapp.LogicaDelNegocio.GestorCita;
import com.mycompany.clinicaapp.Modelos.Cita;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author hecto
 */
public class BotonDiagnosticoCita extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private JPanel panel;
    private JButton btnAgregar;
    private JTable tabla;
    private GestorCita gestor;

    public BotonDiagnosticoCita(GestorCita gestor, JTable tabla) {
        this.gestor = gestor;
        this.tabla = tabla;
        crearPanelBotones();
    }

    private void crearPanelBotones() {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        btnAgregar = new JButton("Agregar");
        btnAgregar.setFocusPainted(false);
        btnAgregar.setMargin(new Insets(2, 5, 2, 5));
        panel.add(btnAgregar);

        // Acción del botón
        btnAgregar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                String id = tabla.getValueAt(fila, 0).toString();
                System.out.println("DEBUG → ID de la fila seleccionada: " + id);

                Cita cita = gestor.buscarCitaPorId(id);

                if (cita == null) {
                    JOptionPane.showMessageDialog(tabla, "No se encontró la cita con ID: " + id);
                } else {
                    String diagnostico = JOptionPane.showInputDialog(tabla,
                            "Ingrese diagnóstico para la cita " + id + ":");

                    if (diagnostico != null && !diagnostico.trim().isEmpty()) {
                        cita.setDiagnostico(diagnostico);
                        JOptionPane.showMessageDialog(tabla, "Diagnóstico agregado correctamente.");
                        tabla.setValueAt(diagnostico, fila, 3); // Actualiza la tabla visualmente
                    }
                }
            }
            fireEditingStopped();
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        return panel;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}

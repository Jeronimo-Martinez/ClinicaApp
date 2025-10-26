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
    private JButton btnDiagnostico;
    private JTable tabla;
    private GestorCita gestor;

    public BotonDiagnosticoCita(GestorCita gestor, JTable tabla) {
        this.gestor = gestor;
        this.tabla = tabla;
        crearBoton();
    }

    private void crearBoton() {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        btnDiagnostico = new JButton("Agregar Diagnóstico");

        btnDiagnostico.setFocusPainted(false);
        btnDiagnostico.setMargin(new Insets(2, 5, 2, 5));

        panel.add(btnDiagnostico);

        // Acción del botón
        btnDiagnostico.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                // Obtener el ID de la cita
                int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());

                // Buscar la cita en el gestor
                Cita cita = gestor.buscarCitaPorId(String.valueOf(id));
                if (cita == null) {
                    JOptionPane.showMessageDialog(tabla, "No se encontró la cita con ID: " + id);
                    return;
                }

                // Pedir el diagnóstico al médico
                String nuevoDiagnostico = JOptionPane.showInputDialog(
                        tabla,
                        "Ingrese el diagnóstico para la cita ID " + id + ":",
                        cita.getDiagnostico() != null ? cita.getDiagnostico() : ""
                );

                if (nuevoDiagnostico != null && !nuevoDiagnostico.trim().isEmpty()) {
                    cita.setDiagnostico(nuevoDiagnostico);
                    gestor.actualizarCita(cita);

                    // Refrescar el valor en la tabla
                    tabla.setValueAt(nuevoDiagnostico, fila, 3);

                    JOptionPane.showMessageDialog(tabla, "Diagnóstico guardado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(tabla, "No se ingresó ningún diagnóstico.");
                }
            }
            fireEditingStopped();
        });
    }

    // 🔹 Renderiza el botón en la celda
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        return panel;
    }

    // 🔹 Devuelve el botón cuando se hace clic
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

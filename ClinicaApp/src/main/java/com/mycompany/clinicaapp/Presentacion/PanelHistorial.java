package com.mycompany.clinicaapp.Presentacion;
import com.mycompany.clinicaapp.LogicaDelNegocio.IHistorialService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Este panel está encargado de mostrar el historial clínico de un paciente.
 */

public class PanelHistorial extends JPanel {

    private final IHistorialService gestorHistorial;
    private final JTextField txtBuscar;
    private final JTable tablaHistorial;
    private final DefaultTableModel modeloTabla;


    /**
     * Constructor del panel de historial.
     * @param gestorHistorial 
     */
    public PanelHistorial(IHistorialService gestorHistorial) {
        this.gestorHistorial = gestorHistorial;

        // Configuración de la vista del panel
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(245, 245, 250));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
}
}

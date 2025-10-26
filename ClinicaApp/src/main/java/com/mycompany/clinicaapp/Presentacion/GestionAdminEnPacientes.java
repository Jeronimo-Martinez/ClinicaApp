package com.mycompany.clinicaapp.Presentacion;

import com.mycompany.clinicaapp.Modelos.*;
import com.mycompany.clinicaapp.LogicaDelNegocio.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Panel para la gestión de pacientes: registrar, editar y eliminar.
 */
public class GestionAdminEnPacientes extends JPanel {

    private final GestorAdministrador gestor;

    private JTextField txtCedula, txtNombre, txtEdad, txtTelefono;
    private JTable tablaPacientes;
    private DefaultTableModel modeloTabla;

    public GestionAdminEnPacientes(GestorAdministrador gestor) {
        this.gestor = gestor;
        initComponents();
        cargarPacientes();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createTitledBorder("Gestión de Pacientes"));

        // ====== FORMULARIO SUPERIOR ======
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 5, 5));
        panelForm.add(new JLabel("Cédula:"));
        txtCedula = new JTextField();
        panelForm.add(txtCedula);

        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panelForm.add(txtEdad);

        panelForm.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panelForm.add(txtTelefono);

        add(panelForm, BorderLayout.NORTH);

        // ====== TABLA CENTRAL ======
        String[] columnas = {"Cédula", "Nombre", "Dirección", "Teléfono"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaPacientes = new JTable(modeloTabla);
        add(new JScrollPane(tablaPacientes), BorderLayout.CENTER);

        // ====== BOTONES INFERIORES ======
        JPanel panelBotones = new JPanel();
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnVer = new JButton("Ver Pacientes");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnVer);
        add(panelBotones, BorderLayout.SOUTH);

        // ====== EVENTOS ======
        btnRegistrar.addActionListener(this::registrarPaciente);
        btnEditar.addActionListener(this::editarPaciente);
        btnEliminar.addActionListener(this::eliminarPaciente);
        btnVer.addActionListener(this::verPacientes);
    }

    // ---------------------------------------------------------------------
    // MÉTODOS DE GESTIÓN
    // ---------------------------------------------------------------------
    private void registrarPaciente(ActionEvent e) {
        String cedula = txtCedula.getText().trim();
        String nombre = txtNombre.getText().trim();
        int edad = Integer.parseInt(txtEdad.getText().trim());
        String telefono = txtTelefono.getText().trim();

        if (cedula.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cédula y nombre son obligatorios");
            return;
        }

        Paciente nuevo = new Paciente(cedula, nombre, telefono, edad);
        boolean exito = gestor.registrarPaciente(nuevo);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Paciente registrado correctamente");
            limpiarCampos();
            cargarPacientes();
        } else {
            JOptionPane.showMessageDialog(this, "Error: no se pudo registrar el paciente");
        }
    }

    private void editarPaciente(ActionEvent e) {
        String cedula = txtCedula.getText().trim();
        String nombre = txtNombre.getText().trim();
        int edad = Integer.parseInt(txtEdad.getText().trim());
        String telefono = txtTelefono.getText().trim();

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la cédula del paciente");
            return;
        }

        Paciente actualizado = new Paciente(cedula, nombre, telefono, edad);
        boolean exito = gestor.editarPaciente(actualizado);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Paciente actualizado correctamente");
            limpiarCampos();
            cargarPacientes();
        } else {
            JOptionPane.showMessageDialog(this, "Error: no se pudo actualizar el paciente");
        }
    }

    private void eliminarPaciente(ActionEvent e) {
        String cedula = txtCedula.getText().trim();

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la cédula del paciente a eliminar");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar al paciente con cédula " + cedula + "?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean exito = gestor.eliminarPaciente(cedula);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Paciente eliminado correctamente");
                limpiarCampos();
                cargarPacientes();
            } else {
                JOptionPane.showMessageDialog(this, "Error: no se pudo eliminar el paciente");
            }
        }
    }

    private void cargarPacientes() {
        modeloTabla.setRowCount(0); // limpia la tabla
        List<Paciente> pacientes = gestor.listarPacientes();
        for (Paciente p : pacientes) {
            modeloTabla.addRow(new Object[]{
                p.getCedula(),
                p.getNombre(),
                p.getEdad(),
                p.getTelefono()
            });
        }
    }

    private void verPacientes(ActionEvent e) {
        List<Paciente> pacientes = gestor.listarPacientes();
        if (pacientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay pacientes registrados");
            return;
        }

        StringBuilder sb = new StringBuilder("Listado de Pacientes:\n\n");
        for (Paciente p : pacientes) {
            sb.append("• ").append(p.getCedula())
                    .append(" - ").append(p.getNombre())
                    .append(" (").append(p.getEdad()).append(", ")
                    .append(p.getTelefono()).append(")\n");
        }

        JTextArea area = new JTextArea(sb.toString(), 15, 40);
        area.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(area), "Pacientes", JOptionPane.INFORMATION_MESSAGE);
    }

    private void limpiarCampos() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
    }
}

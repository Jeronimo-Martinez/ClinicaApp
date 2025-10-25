package com.mycompany.clinicaapp.Presentacion;
import com.mycompany.clinicaapp.Interfaces.*;
import com.mycompany.clinicaapp.Modelos.*;
import com.mycompany.clinicaapp.LogicaDelNegocio.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.util.ArrayList;




/**
 * Panel para la gestión de médicos.
 */
public class GestionAdminEnMedicos extends JPanel {

    private final GestorAdministrador gestor;
    private JTextField txtCedula, txtNombre;
    private JComboBox<Especialidad> comboEspecialidad;

    public GestionAdminEnMedicos(GestorAdministrador gestor) {
        this.gestor = gestor;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createTitledBorder("Gestión de Médicos"));

        JPanel panelForm = new JPanel(new GridLayout(3, 2, 5, 5));
        panelForm.add(new JLabel("Cédula:"));
        txtCedula = new JTextField();
        panelForm.add(txtCedula);

        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Especialidad:"));
        comboEspecialidad = new JComboBox<>();
        cargarEspecialidades();
        panelForm.add(comboEspecialidad);

        add(panelForm, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnVer = new JButton("Ver Médicos");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnVer);

        add(panelBotones, BorderLayout.SOUTH);

        btnRegistrar.addActionListener(this::registrarMedico);
        btnEditar.addActionListener(this::editarMedico);
        btnEliminar.addActionListener(this::eliminarMedico);
        btnVer.addActionListener(this::verMedicos);
    }

    private void registrarMedico(ActionEvent e) {
        String cedula = txtCedula.getText().trim();
        String nombre = txtNombre.getText().trim();
        Especialidad esp = (Especialidad) comboEspecialidad.getSelectedItem();

        if (cedula.isEmpty() || nombre.isEmpty() || esp == null) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
            return;
        }

        Medico nuevo = new Medico(cedula, nombre, esp);
        boolean exito = gestor.registrarMedico(nuevo);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Médico registrado correctamente");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar médico");
        }
    }

    private void editarMedico(ActionEvent e) {
        String cedula = txtCedula.getText().trim();
        String nombre = txtNombre.getText().trim();
        Especialidad esp = (Especialidad) comboEspecialidad.getSelectedItem();

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la cédula del médico a editar");
            return;
        }

        Medico actualizado = new Medico(cedula, nombre, esp);
        boolean exito = gestor.editarMedico(actualizado);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Médico actualizado correctamente");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar médico");
        }
    }

    private void eliminarMedico(ActionEvent e) {
        String cedula = txtCedula.getText().trim();
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la cédula del médico a eliminar");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el médico?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            boolean exito = gestor.eliminarMedico(cedula);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Médico eliminado");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar médico");
            }
        }
    }

    private void verMedicos(ActionEvent e) {
        List<Medico> medicos = gestor.listarMedicos();
        if (medicos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay médicos registrados");
            return;
        }

        StringBuilder sb = new StringBuilder("Listado de Médicos:\n\n");
        for (Medico m : medicos) {
            sb.append("• ").append(m.getCedula()).append(" - ").append(m.getNombre());
            if (m.getEspecialidad() != null)
                sb.append(" (").append(m.getEspecialidad().getNombre()).append(")");
            sb.append("\n");
        }

        JTextArea area = new JTextArea(sb.toString(), 15, 40);
        area.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(area), "Médicos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cargarEspecialidades() {
        comboEspecialidad.removeAllItems();
        for (Especialidad e : gestor.listarEspecialidades()) {
            comboEspecialidad.addItem(e);
        }
    }

    private void limpiarCampos() {
        txtCedula.setText("");
        txtNombre.setText("");
        comboEspecialidad.setSelectedIndex(-1);
    }
}
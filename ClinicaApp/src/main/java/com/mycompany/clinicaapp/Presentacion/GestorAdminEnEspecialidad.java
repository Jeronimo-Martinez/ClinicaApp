package com.mycompany.clinicaapp.Presentacion;

import com.mycompany.clinicaapp.Modelos.*;
import com.mycompany.clinicaapp.LogicaDelNegocio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Panel simple para registrar y eliminar especialidades.
 */
public class GestorAdminEnEspecialidad extends JPanel {

    private final GestorAdministrador gestor;
    private JTextField txtNombre;

    public GestorAdminEnEspecialidad(GestorAdministrador gestor) {
        this.gestor = gestor;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createTitledBorder("Gestión de Especialidades"));

        // === Panel central con el campo de texto ===
        JPanel panelForm = new JPanel(new GridLayout(1, 2, 5, 5));
        panelForm.add(new JLabel("Nombre de la especialidad:"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);
        add(panelForm, BorderLayout.CENTER);

        // === Panel inferior con botones ===
        JPanel panelBotones = new JPanel();
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnVer = new JButton("Ver Especialidades");
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnEliminar);
        add(panelBotones, BorderLayout.SOUTH);
        panelBotones.add(btnVer);
        // === Listeners ===
        btnRegistrar.addActionListener(this::registrarEspecialidad);
        btnEliminar.addActionListener(this::eliminarEspecialidad);
        btnVer.addActionListener(this::verEspecialidades);


    }

    private void registrarEspecialidad(ActionEvent e) {
        String nombre = txtNombre.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de la especialidad");
            return;
        }

        Especialidad nueva = new Especialidad(nombre);
        try {
            gestor.registrarEspecialidad(nueva);
            JOptionPane.showMessageDialog(this, "Especialidad registrada correctamente");
            txtNombre.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar: " + ex.getMessage());
        }
    }

    private void eliminarEspecialidad(ActionEvent e) {
        String nombre = txtNombre.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de la especialidad a eliminar");
            return;
        }

        Especialidad esp = new Especialidad(nombre);
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Seguro que desea eliminar la especialidad \"" + nombre + "\"?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                gestor.eliminarEspecialidad(esp);
                JOptionPane.showMessageDialog(this, "Especialidad eliminada correctamente");
                txtNombre.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage());
            }
        }
    }
    private void verEspecialidades(ActionEvent e) {
    List<Especialidad> especialidades = gestor.listarEspecialidades();
    if (especialidades.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No hay especialidades registradas");
        return;
    }

    StringBuilder sb = new StringBuilder("Listado de Especialidades:\n\n");
    for (Especialidad esp : especialidades) {
        sb.append("• ").append(esp.getNombre()).append("\n");
    }

    JTextArea area = new JTextArea(sb.toString(), 10, 30);
    area.setEditable(false);
    JOptionPane.showMessageDialog(this, new JScrollPane(area), "Especialidades", JOptionPane.INFORMATION_MESSAGE);
}
}
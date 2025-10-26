package com.mycompany.clinicaapp.Presentacion;
import com.mycompany.clinicaapp.LogicaDelNegocio.GestorAdministrador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * 
 * Panel principal del Administrador.
 * Desde aquí puede gestionar Médicos, Pacientes y Especialidades.
 */
public class PanelAdministrador extends JPanel {

    private final GestorAdministrador gestor;

    public PanelAdministrador(GestorAdministrador gestor) {
        this.gestor = gestor;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createTitledBorder("Panel del Administrador"));

        JLabel lblTitulo = new JLabel("Gestión del Sistema Médico", JLabel.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton btnMedicos = new JButton("Gestionar Médicos");
        JButton btnPacientes = new JButton("Gestionar Pacientes");
        JButton btnEspecialidades = new JButton("Gestionar Especialidades");
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");

        panelBotones.add(btnMedicos);
        panelBotones.add(btnPacientes);
        panelBotones.add(btnEspecialidades);
        panelBotones.add(btnCerrarSesion);

        add(panelBotones, BorderLayout.CENTER);

        // Eventos
        btnMedicos.addActionListener(this::abrirPanelMedicos);
        btnPacientes.addActionListener(this::abrirPanelPacientes);
        btnEspecialidades.addActionListener(this::abrirPanelEspecialidades);
        btnCerrarSesion.addActionListener(this::cerrarSesion);
    }

    private void abrirPanelMedicos(ActionEvent e) {
        cambiarContenido(new GestionAdminEnMedicos(gestor));
    }

    private void abrirPanelPacientes(ActionEvent e) {
        cambiarContenido(new GestionAdminEnPacientes(gestor));
    }

    private void abrirPanelEspecialidades(ActionEvent e) {
        cambiarContenido(new GestorAdminEnEspecialidad(gestor));
    }

    private void cambiarContenido(JPanel nuevoPanel) {
        JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(this);

        JPanel panelContenedor = new JPanel(new BorderLayout());
        panelContenedor.add(nuevoPanel, BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver al Panel Administrador");
        btnVolver.addActionListener(a -> volverAlPanelAdministrador());
        panelContenedor.add(btnVolver, BorderLayout.SOUTH);

        ventana.setContentPane(panelContenedor);
        ventana.revalidate();
        ventana.repaint();
    }

    private void volverAlPanelAdministrador() {
        JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(this);
        ventana.setContentPane(new PanelAdministrador(gestor));
        ventana.revalidate();
        ventana.repaint();
    }

    private void cerrarSesion(ActionEvent e) {
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Desea cerrar sesión y volver al inicio?",
                "Cerrar sesión",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(this);
            ventana.dispose();

            // Volver al login
            VentanaIniciarSesion ventanaLogin = new VentanaIniciarSesion(
                    gestor.getMedicoService(),
                    gestor.getPacienteService(),
                    gestor.getEspecialidadService()
            );
            ventanaLogin.setVisible(true);
        }
    }
}

package com.mycompany.clinicaapp.Presentacion;
import com.mycompany.clinicaapp.Modelos.*;
import com.mycompany.clinicaapp.Interfaces.*;
import com.mycompany.clinicaapp.LogicaDelNegocio.GestorMedico;
import com.mycompany.clinicaapp.LogicaDelNegocio.GestorPaciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
*Panel que permite al administrador gestionar médicos, pacientes y especialidades.
*/

public class PanelAdministrador extends JPanel {

    // Gestores declarados por sus interfaces
    private IMedicoService gestorMedico;
    private IPacienteService gestorPaciente;
    private IEspecialidadService gestorEspecialidad;

    // Componentes de la interfaz
    private JButton btnRegistrarMedico, btnEditarMedico, btnEliminarMedico;
    private JButton btnRegistrarPaciente, btnEditarPaciente, btnEliminarPaciente;
    private JButton btnRegistrarEspecialidad, btnVolver;

    private JLabel lblTitulo;

    private JFrame ventanaPrincipal; // Para poder volver a login

    



    /** 
     * Constructor del panel principal del administrador.
     * @param ventanaPrincipal la ventana JFrame principal desde la cual se abrió el panel.
     */
    public PanelAdministrador(JFrame ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.gestorMedico = new GestorMedico();
        this.gestorPaciente = new GestorPaciente();
        this.gestorEspecialidad = new GestorEspecialidad();

        // Inicialización de la interfaz gráfica y configuración del comportamiento.
        inicializarComponentes();
        configurarEstilos();
        configurarEventos();

    }



    /** 
     * Inicializa y organiza los componentes visuales del panel del administrador. 
     *  Este método no asigna eventos a los botones, solo define su estructura * y disposición visual.
     */

    private void inicializarComponentes() {
        // Define el diseño general del panel
        setLayout(new BorderLayout());

        // Título principal
        lblTitulo = new JLabel("Panel del Administrador", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        
        // Panel que contiene los botones en forma de cuadrícula
        JPanel panelBotones = new JPanel(new GridLayout(4, 3, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Botones
        btnRegistrarMedico = new JButton("Registrar Médico");
        btnEditarMedico = new JButton("Editar Médico");
        btnEliminarMedico = new JButton("Eliminar Médico");

        btnRegistrarPaciente = new JButton("Registrar Paciente");
        btnEditarPaciente = new JButton("Editar Paciente");
        btnEliminarPaciente = new JButton("Eliminar Paciente");

        btnRegistrarEspecialidad = new JButton("Registrar Especialidad");
        btnVolver = new JButton("Volver al inicio");
        // Agregar al panel
        panelBotones.add(btnRegistrarMedico);
        panelBotones.add(btnEditarMedico);
        panelBotones.add(btnEliminarMedico);
        panelBotones.add(btnRegistrarPaciente);
        panelBotones.add(btnEditarPaciente);
        panelBotones.add(btnEliminarPaciente);
        panelBotones.add(btnRegistrarEspecialidad);
        panelBotones.add(new JLabel()); // espacio
        panelBotones.add(btnVolver);

        add(lblTitulo, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
    }

    /**
     * Aplica estilos visuales  a los componentes del panel del administrador.
     * De esta forma, se garantiza una apariencia uniforme y profesional 
     * en toda la interfaz del panel de administración.
     */

    private void configurarEstilos() {
        setBackground(new Color(240, 240, 240));

        Font btnFont = new Font("Segoe UI", Font.PLAIN, 15);
        for (Component c : ((JPanel) getComponent(1)).getComponents()) {
            if (c instanceof JButton boton) {
                boton.setFont(btnFont);
                boton.setBackground(new Color(30, 144, 255));
                boton.setForeground(Color.WHITE);
                boton.setFocusPainted(false);
            }
        }
    }



    /**
     * Asocia los eventos de acción a los botones del panel del administrador.
     */
    private void configurarEventos() {
        btnRegistrarMedico.addActionListener(e -> registrarMedico());
        btnEditarMedico.addActionListener(e -> editarMedico());
        btnEliminarMedico.addActionListener(e -> eliminarMedico());

        btnRegistrarPaciente.addActionListener(e -> registrarPaciente());
        btnEditarPaciente.addActionListener(e -> editarPaciente());
        btnEliminarPaciente.addActionListener(e -> eliminarPaciente());

        btnRegistrarEspecialidad.addActionListener(e -> registrarEspecialidad());

        btnVolver.addActionListener(e -> volverInicio());
    }

     // ================= ACCIONES =================

    private void registrarMedico() {

        JOptionPane.showMessageDialog(this, "Registrar médico...");
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del médico:");
        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula del médico:");
        String especialidad = JOptionPane.showInputDialog(this, "Ingrese la especialidad:");

        if (nombre != null && cedula != null && especialidad != null) {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del médico:");
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula del médico:");
        if (cedula == null || cedula.trim().isEmpty() || !cedula.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una cédula válida (solo números).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String especialidad = JOptionPane.showInputDialog(this, "Ingrese la especialidad del médico:");
        if (especialidad == null || especialidad.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La especialidad no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Medico nuevo = new Medico(cedula, nombre, especialidad);
            gestorMedico.registrarMedico(nuevo);
            JOptionPane.showMessageDialog(this, "Médico registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar médico: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
    }


    private void editarMedico() {
            
        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula del médico a eliminar:");
        if (cedula != null) {
            gestorMedico.eliminarMedico(cedula);
            JOptionPane.showMessageDialog(this, "Médico eliminado correctamente.");
        }
    }

    private void eliminarMedico() {
        JOptionPane.showMessageDialog(this, "Eliminar médico...");
    }

    private void registrarPaciente() {
        JOptionPane.showMessageDialog(this, "Registrar paciente...");
    }

    private void editarPaciente() {
        JOptionPane.showMessageDialog(this, "Editar paciente...");
    }

    private void eliminarPaciente() {
        JOptionPane.showMessageDialog(this, "Eliminar paciente...");
    }

    private void registrarEspecialidad() {
        JOptionPane.showMessageDialog(this, "Registrar especialidad...");
    }

    private void volverInicio() {
        // Vuelve a la ventana de inicio de sesión
        ventanaPrincipal.getContentPane().removeAll();
        ventanaPrincipal.getContentPane().add(new VentanaIniciarSesion());
        ventanaPrincipal.revalidate();
        ventanaPrincipal.repaint();
    }
}



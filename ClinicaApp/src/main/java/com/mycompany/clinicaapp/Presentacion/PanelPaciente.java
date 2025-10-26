package com.mycompany.clinicaapp.Presentacion;
import com.mycompany.clinicaapp.Interfaces.IPacienteService;
import com.mycompany.clinicaapp.Interfaces.IHistorialService;
import com.mycompany.clinicaapp.Interfaces.IGestorCita;
import com.mycompany.clinicaapp.Modelos.Paciente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPaciente extends JPanel {

    private final IPacienteService gestorPaciente;
    private Paciente pacienteAutenticado;
    //private final IGestorCita gestorCita; // Esto ahorita se va
    //private final IHistorialService gestorHistorial; // Igual con esta
    private JButton btnCitas;
    private JButton btnHistorialMedico;
    private JButton btnEditarDatos;
    private JButton btnCerrarSesion;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtEdad;
    private JTextField txtTelefono;
    private JLabel tituloPanelPaciente;

    /**
     * Este es el constructor del panel paciente
     * Inicializa los servicios (gestorPaciente) y los datos del paciente autenticado
     * @param gestorPaciente Servicio que gestiona las operaciones del paciente 
     * @param pacienteAutenticado Paciente que se ha autenticado
     */
    public PanelPaciente(IPacienteService gestorPaciente, Paciente pacienteAutenticado) {
        this.gestorPaciente = gestorPaciente;
        this.pacienteAutenticado = pacienteAutenticado;
        inicializarComponentes();
        configurarEstilodelPanelPaciente();
        configurarEventosdelPanelPaciente();
    }

    public void inicializarComponentes() {
        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(245, 247, 252));
        tituloPanelPaciente = new JLabel("Panel del Paciente", SwingConstants.CENTER);
        add(tituloPanelPaciente, BorderLayout.NORTH);
        add(crearPanelDatosPaciente(), BorderLayout.CENTER);
        add(crearPanelBotones(), BorderLayout.SOUTH);
    }

    public JPanel crearPanelDatosPaciente() {
        JPanel panelDatos = new JPanel (new GridLayout(4, 2, 12, 12));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos Personales: "));

        txtNombre = new JTextField(pacienteAutenticado.getNombre());
        txtCedula = new JTextField(pacienteAutenticado.getCedula());
        txtCedula.setEditable(false);
        txtEdad = new JTextField(pacienteAutenticado.getEdad());
        txtTelefono = new JTextField(pacienteAutenticado.getTelefono());

        panelDatos.add(new JLabel("Nombre: "));
        panelDatos.add(txtNombre);
        panelDatos.add(new JLabel("Cédula: "));
        panelDatos.add(txtCedula);
        panelDatos.add(new JLabel("Edad: "));
        panelDatos.add(txtEdad);
        panelDatos.add(new JLabel("Teléfono"));
        panelDatos.add(txtTelefono);

        return panelDatos;
    }

    public JPanel crearPanelBotones() {

    }

    public void configurarEstilodelPanelPaciente() {
        Font fuenteTitulo = new Font("Roboto", Font.BOLD, 20);
        Font fuenteCuerpo = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteBtn = new Font("Segoe UI", Font.BOLD, 14);
        tituloPanelPaciente.setFont(fuenteTitulo);
        txtNombre.setFont(fuenteCuerpo);
        txtCedula.setFont(fuenteCuerpo);
        txtEdad.setFont(fuenteCuerpo);
        txtTelefono.setFont(fuenteCuerpo);
        btnCitas.setFont(fuenteBtn);
        btnHistorialMedico.setFont(fuenteBtn);
        btnEditarDatos.setFont(fuenteBtn);
        btnCerrarSesion.setFont(fuenteBtn);
        btnCitas.setBackground(new Color(66, 133, 244));
        btnHistorialMedico.setBackground(new Color(66, 133, 244));
        btnCerrarSesion.setBackground(new Color(229, 57, 53));
        tituloPanelPaciente.setForeground(new Color(51, 51, 51));
        btnCitas.setForeground(new Color(255, 255, 255));
        btnEditarDatos.setForeground(new Color(255, 255, 255));
        btnHistorialMedico.setForeground(new Color(255, 255, 255));
        btnCerrarSesion.setForeground(new Color(255, 255, 255));
    }

    public void configurarEventosdelPanelPaciente() {

    }
}
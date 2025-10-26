package com.mycompany.clinicaapp.Presentacion;
import com.mycompany.clinicaapp.Interfaces.IPacienteService;
import com.mycompany.clinicaapp.Interfaces.IHistorialService;
import com.mycompany.clinicaapp.Interfaces.IGestorCita;
import com.mycompany.clinicaapp.Modelos.Paciente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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

    private void inicializarComponentes() {
        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(245, 247, 252));
        tituloPanelPaciente = new JLabel("Panel del Paciente", SwingConstants.CENTER);
        add(tituloPanelPaciente, BorderLayout.NORTH);
        add(crearPanelDatosPaciente(), BorderLayout.CENTER);
        add(crearPanelBotones(), BorderLayout.SOUTH);
    }

    private JPanel crearPanelDatosPaciente() {
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

    private JPanel crearPanelBotones() {
        JPanel panelBotones = new JPanel(new GridLayout(1, 4, 10, 10));

        // Creación de los bontones en el panelBotones
        btnCitas = new JButton("Citas");
        btnHistorialMedico = new JButton("Historial Médico");
        btnEditarDatos = new JButton("Editar Datos");
        btnCerrarSesion = new JButton("Cerrar Sesión");

        return panelBotones;
    }

    private void configurarEstilodelPanelPaciente() {

        // Creación de Fuentes
        Font fuenteTitulo = new Font("Roboto", Font.BOLD, 20);
        Font fuenteCuerpo = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteBtn = new Font("Segoe UI", Font.BOLD, 14);

        // Asignación de fuentes
        tituloPanelPaciente.setFont(fuenteTitulo);
        txtNombre.setFont(fuenteCuerpo);
        txtCedula.setFont(fuenteCuerpo);
        txtEdad.setFont(fuenteCuerpo);
        txtTelefono.setFont(fuenteCuerpo);
        btnCitas.setFont(fuenteBtn);
        btnHistorialMedico.setFont(fuenteBtn);
        btnEditarDatos.setFont(fuenteBtn);
        btnCerrarSesion.setFont(fuenteBtn);

        // Personalización de color de los botones y fuentes
        btnCitas.setBackground(new Color(66, 133, 244));
        btnHistorialMedico.setBackground(new Color(66, 133, 244));
        btnCerrarSesion.setBackground(new Color(229, 57, 53));
        tituloPanelPaciente.setForeground(new Color(51, 51, 51));
        btnCitas.setForeground(new Color(255, 255, 255));
        btnEditarDatos.setForeground(new Color(255, 255, 255));
        btnHistorialMedico.setForeground(new Color(255, 255, 255));
        btnCerrarSesion.setForeground(new Color(255, 255, 255));
    }

    private void configurarEventosdelPanelPaciente() {

        // Configutación del botón "Citas"
        
        // Configuración del botón "Historial Médico"

        // Configuración del botón "Editar Datos"
        btnEditarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clickEvento) {

                try {
                    
                    // Se piden los datos
                    String nombre = txtNombre.getText().trim();
                    String cedula = pacienteAutenticado.getCedula();
                    String edad = txtEdad.getText().trim();
                    String telefono = txtTelefono.getText().trim();

                    // Se comprueba que no este ningún campo vacío
                    if (nombre.isEmpty() || cedula.isEmpty() || edad.isEmpty() || telefono.isEmpty()) {
                        JOptionPane.showMessageDialog(PanelPaciente.this, "Debe rellenar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // Se comprueba que la edad sea un número y que sea positivo
                    int edadValidacionNumero;
                    try {
                        edadValidacionNumero = Integer.parseInt(edad);
                        if (edadValidacionNumero <= 0){
                            JOptionPane.showMessageDialog(PanelPaciente.this, "La edad debe ser un número positivo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(PanelPaciente.this, "La edad debe ser un número", "Advertencia", JOptionPane.WARNING_MESSAGE);

                    }

                    edadValidacionNumero = Integer.parseInt(edad);

                    // Se comprueba que el nombre sean solo letras con opción de espacios
                    if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")){
                        JOptionPane.showMessageDialog(PanelPaciente.this, "Carácteres no válidos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // Se comprueba que la cédula sean números positivos
                    if (!cedula.matches("^\\d+$")) {
                        return;
                    }

                    // Se comprueba que el teléfono sean números positivos
                    if (!telefono.matches("^\\d+$")) {
                        return;
                    }

                    pacienteAutenticado.setNombre(nombre);
                    pacienteAutenticado.setCedula(cedula);
                    pacienteAutenticado.setEdad(edadValidacionNumero);
                    pacienteAutenticado.setTelefono(telefono);

                    // Se realiza la modificación
                    boolean estaPacienteEditado = gestorPaciente.editarPaciente(pacienteAutenticado);
                    if (estaPacienteEditado){
                        JOptionPane.showMessageDialog(PanelPaciente.this, "Datos actualizados con éxito", "Cambio Éxitoso", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(PanelPaciente.this, "No se encontró la cédula", "Error", JOptionPane.ERROR_MESSAGE);
                    }


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(PanelPaciente.this, "¡Ups! Ha ocurrido un error en la edición de datos ...", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Configuración del botón "Cerrar Sesión"
    }
}
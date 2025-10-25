package com.mycompany.clinicaapp.LogicaDelNegocio;
<<<<<<< HEAD

import com.mycompany.clinicaapp.Interfaces.IPacienteService;
=======
>>>>>>> main
import com.mycompany.clinicaapp.Modelos.Paciente;

import java.util.ArrayList;
<<<<<<< HEAD
import javax.swing.JOptionPane;
=======
import java.util.List;
>>>>>>> main

/**
 * Esta clase implementa la interfaz IPacienteService y se encarga de gestionar las operaciones CRUD sobre los objetos Paciente
 * @author Valentina
 */
<<<<<<< HEAD
public class GestorPaciente implements IPacienteService{
    private static GestorPaciente instancia;
    private final ArrayList<Paciente> listaPacientes = new ArrayList<>();
=======

public class GestorPaciente implements IPacienteService{

    private List<Paciente> pacientes;

    /**
     * Constructor por defecto 
     */
>>>>>>> main

    public GestorPaciente() {
        this.pacientes = new ArrayList<>();
    }
<<<<<<< HEAD
    
    public static GestorPaciente getInstanciaPaciente() {
        if (instancia == null) {
            instancia = new GestorPaciente();
        }
        return instancia;
    }    
    
    public boolean registrarPaciente(Paciente paciente) {
        if (paciente.getNombre().isEmpty() ||
            paciente.getTelefono().isEmpty() ||
            paciente.getCedula().isEmpty() ||
            paciente.getContrasena().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                "Por favor complete todos los campos.",
                "Campos vacíos",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Validar edad
        if (paciente.getEdad() <= 0 ) {
            JOptionPane.showMessageDialog(null,
                "La edad debe ser mayor a 0.",
                "Edad inválida",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (paciente.getEdad() > 100 ) {
            JOptionPane.showMessageDialog(null,
                "La edad debe ser menor a 100.",
                "Edad inválida",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }

    // Validar duplicados (cedula, telefono o nombre)
    for (Paciente pacienteExistente : listaPacientes) {
        if (pacienteExistente.getCedula().equals(paciente.getCedula())) {
            JOptionPane.showMessageDialog(null,
                "Ya existe un paciente con esta cédula.",
                "Cédula duplicada",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (pacienteExistente.getTelefono().equals(paciente.getTelefono())) {
            JOptionPane.showMessageDialog(null,
                "Ya existe un paciente con este número de teléfono.",
                "Teléfono duplicado",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (pacienteExistente.getNombre().equalsIgnoreCase(paciente.getNombre())) {
            JOptionPane.showMessageDialog(null,
                "Ya existe un paciente con este nombre.",
                "Nombre duplicado",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        }        
        
        
        // Si pasa todas las validaciones, lo agrega
        listaPacientes.add(paciente);
        JOptionPane.showMessageDialog(null,
            "Paciente registrado correctamente.",
            "Registro exitoso",
            JOptionPane.INFORMATION_MESSAGE);

=======

    /**
     * Constructor con parámetros
     * 
     * @param gestorPaciente
     * @param pacientes
     */

    public GestorPaciente (List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    /**
     * Este método registra a un nuevo paciente
     * @param paciente  Paciente nuevo
     * @return true  (En caso de que el paciente sea creado con éxito)
     */
    @Override
    public boolean registrarPaciente(Paciente paciente) {
        // en caso de que este vacío
        if (paciente == null) {
            return false;
        }

        for (Paciente pac : pacientes) {
            if (pac.getCedula().equals(paciente.getCedula())) {
                return false; // si ya existe un paciente con esa cédula
            }
        }
        
        pacientes.add(paciente);
>>>>>>> main
        return true;
    }
    

    /**
     * Este método edita los datos de un paciente
     * @param paciente  Paciente a editar
     * @return true  (En caso de que el paciente sea encontrado y editado con éxito)
     */
    @Override
    public boolean editarPaciente(Paciente paciente) {
        for (int i=0; i < pacientes.size(); i++){
            if (paciente.getCedula().equals(pacientes.get(i).getCedula())){
                pacientes.set(i, paciente);
                return true;
            }
        }
        return false;
    }
<<<<<<< HEAD
=======

    /**
     * Este método elimina a un paciente
     * @param paciente  Paciente a eliminar
     * @return true  (En caso de que el paciente sea eliminado con éxito)
     */
    @Override
    public boolean eliminarPaciente(Paciente paciente) {
        for (int i=0; i < pacientes.size(); i++){
            if (paciente.getCedula().equals(pacientes.get(i).getCedula())) {
                pacientes.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Este método lista a los pacientes registrados
     * @return pacientes (la lista de pacientes registrados)
     */
    @Override
    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    
>>>>>>> main
}
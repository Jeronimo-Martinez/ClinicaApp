package com.mycompany.clinicaapp.LogicaDelNegocio;
import com.mycompany.clinicaapp.Modelos.Paciente;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz IPacienteService y se encarga de gestionar las operaciones CRUD sobre los objetos Paciente
 * @author Valentina
 */

public class GestorPaciente implements IPacienteService{

    private List<Paciente> pacientes;

    /**
     * Constructor por defecto 
     */

    public GestorPaciente() {
        this.pacientes = new ArrayList<>();
    }
    /**
     * Constructor con parámetros
     * 
     * @param gestorPaciente
     * @param pacientes
     */

    public GestorPaciente (List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

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
        return true;
    }

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

    @Override
    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    
}
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarPaciente'");
    }

    @Override
    public boolean editarPaciente(Paciente paciente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editarPaciente'");
    }

    @Override
    public boolean eliminarPaciente(Paciente paciente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPaciente'");
    }

    @Override
    public List<Paciente> listarPacientes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPacientes'");
    }

    
}
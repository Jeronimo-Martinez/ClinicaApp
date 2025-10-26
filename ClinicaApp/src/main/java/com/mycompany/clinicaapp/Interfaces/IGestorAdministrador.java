package com.mycompany.clinicaapp.Interfaces;

import com.mycompany.clinicaapp.Modelos.Paciente;

import java.util.List;

import com.mycompany.clinicaapp.Modelos.Especialidad;
import com.mycompany.clinicaapp.Modelos.Medico;

public interface IGestorAdministrador {

    boolean registrarMedico(Medico medico);

    boolean editarMedico(Medico medico, String nuevoNombre, Especialidad especialidad);

    boolean eliminarMedico(String cedula);

    boolean registrarPaciente(Paciente paciente);

    boolean editarPaciente(Paciente paciente);

    boolean eliminarPaciente(String id);

    void registrarEspecialidad(Especialidad especialidad);

    void eliminarEspecialidad(Especialidad especialidad);

    List<Paciente> listarPacientes();

    List<Medico> listarMedicos();

    List<Especialidad> listarEspecialidades();
}

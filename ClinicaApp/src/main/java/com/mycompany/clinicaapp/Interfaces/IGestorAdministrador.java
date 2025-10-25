package com.mycompany.clinicaapp.Interfaces;
import com.mycompany.clinicaapp.Modelos.Paciente;
import com.mycompany.clinicaapp.Modelos.Especialidad;
import com.mycompany.clinicaapp.Modelos.Medico;



public interface IGestorAdministrador {
    void registrarMedico(Medico medico);
    void editarMedico(Medico medico);
    void eliminarMedico(String id);
    void registrarPaciente(Paciente paciente);
    void editarPaciente(Paciente paciente);
    void eliminarPaciente(String id);
    void registrarEspecialidad(Especialidad especialidad);
}
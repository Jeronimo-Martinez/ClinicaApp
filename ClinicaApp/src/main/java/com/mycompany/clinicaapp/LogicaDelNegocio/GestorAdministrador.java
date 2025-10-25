package com.mycompany.clinicaapp.LogicaDelNegocio;
import com.mycompany.clinicaapp.Interfaces.IMedicoService;
import com.mycompany.clinicaapp.Interfaces.IEspecialidadService;
import com.mycompany.clinicaapp.Interfaces.IGestorCita;
import com.mycompany.clinicaapp.Interfaces.IPacienteService;
import com.mycompany.clinicaapp.Interfaces.IHistorialService;
import com.mycompany.clinicaapp.Modelos.*;
import java.util.List;

/**
 * Gestiona las acciones que puede realizar el administrador
 * usando las interfaces de los distintos gestores.
 */
public class GestorAdministrador {

    private IMedicoService gestorMedico;
    private IEspecialidadService gestorEspecialidad;
    private IGestorCita gestorCita;
    private IPacienteService gestorPaciente;
    private IHistorialService gestorHistorial;

    // Constructor con inyección de dependencias (interfaces)
    public GestorAdministrador(IMedicoService gm, IEspecialidadService ge,IGestorCita gc, IPacienteService gp, IHistorialService gh) {
                               
        this.gestorMedico = gm;
        this.gestorEspecialidad = ge;
        this.gestorCita = gc;
        this.gestorPaciente = gp;
        this.gestorHistorial = gh;
    }

    /** Registra un nuevo médico */
    public void registrarMedico(Medico medico) {
        gestorMedico.registrarMedico(medico);
    }

    /** Modifica datos de un médico */
    public void editarMedico(Medico medico) {
        gestorMedico.editarMedico(medico);
    }

    /** Elimina un médico */
    public void eliminarMedico(String idMedico) {
        gestorMedico.eliminarMedico(idMedico);
    }

    /** Lista los pacientes registrados */
    public List<Paciente> listarPacientes() {
        return gestorPaciente.listarPacientes();
    }


    /** Lista todas las especialidades */
    public List<Especialidad> listarEspecialidades() {
        return gestorEspecialidad.listarEspecialidades();
    }
}


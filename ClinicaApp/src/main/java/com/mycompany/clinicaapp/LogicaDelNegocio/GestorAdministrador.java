package com.mycompany.clinicaapp.LogicaDelNegocio;
import com.mycompany.clinicaapp.Interfaces.IMedicoService;
import com.mycompany.clinicaapp.Interfaces.IEspecialidadService;
import com.mycompany.clinicaapp.Interfaces.IPacienteService;
import com.mycompany.clinicaapp.Interfaces.IGestorAdministrador;
import com.mycompany.clinicaapp.Modelos.*;

import java.util.ArrayList;
import java.util.List;




/**
 * Esta clase se encarga de implementar las operaciones
 * que el administrador puede realizar sobre médicos, pacientes
 * y especialidades.
 */
public class GestorAdministrador implements IGestorAdministrador {

    private static GestorAdministrador instancia;
    private final IMedicoService medicoService;
    private final IPacienteService pacienteService;
    private final IEspecialidadService especialidadService;
    private final List<Administrador> listaAdministradores;

    /**
     * Constructor que recibe las dependencias desde fuera.
     * Esto permite inyectar las implementaciones concretas.
     */
    private GestorAdministrador(IMedicoService medicoService, IPacienteService pacienteService, IEspecialidadService especialidadService) {
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
        this.especialidadService = especialidadService;
        this.listaAdministradores = new ArrayList<>();

        // Admin por defecto
        listaAdministradores.add(new Administrador("12345", "1234"));
    }

    /**
     * Devuelve la única instancia de GestorAdministrador.
     * @param medicoService
     * @param pacienteService
     * @param especialidadService
     * @return 
     */
    public static GestorAdministrador getInstancia(
        IMedicoService medicoService,
        IPacienteService pacienteService,
        IEspecialidadService especialidadService
) {
    if (instancia == null) {
        instancia = new GestorAdministrador(medicoService, pacienteService, especialidadService);
    }
    return instancia;
}
    /**
     * Permite iniciar sesión del administrador por usuario y contraseña.
     * @param cedula
     * @param contrasena
     * @return 
     */
    public Administrador iniciarSesion(String cedula, String contrasena) {
        for (Administrador admin : listaAdministradores) {
            if (admin.getCedula().equals(cedula) && admin.getContrasena().equals(contrasena)) {
                return admin;
            }
        }
        return null;
    }

    // -------------------------------------------------------------------------
    // MÉTODOS DE GESTIÓN DE MÉDICOS
    // -------------------------------------------------------------------------
    @Override
    public boolean registrarMedico(Medico medico) {
        return medicoService.agregarMedic(medico);
    }

    @Override
    public boolean editarMedico(Medico medico, String nuevoNombre, Especialidad nuevaEspecialidad) {
    medicoService.editarMedico(medico, nuevoNombre, nuevaEspecialidad);
    return true;
}

    @Override
    public boolean eliminarMedico(String cedula) {
        return medicoService.eliminarMedico(cedula);
    }

    // -------------------------------------------------------------------------
    // MÉTODOS DE GESTIÓN DE PACIENTES
    // -------------------------------------------------------------------------
    @Override
    public boolean registrarPaciente(Paciente paciente) {
        return pacienteService.registrarPaciente(paciente);
    }

    @Override
    public boolean editarPaciente(Paciente paciente) {
        return pacienteService.editarPaciente(paciente);
    }

    @Override
    public boolean eliminarPaciente(String id) {
        return pacienteService.eliminarPaciente(id);
    }

    // -------------------------------------------------------------------------
    // MÉTODOS DE GESTIÓN DE ESPECIALIDADES
    // -------------------------------------------------------------------------
    @Override
    public void registrarEspecialidad(Especialidad especialidad) {
        especialidadService.ingresarEspecialidad(especialidad);
    }

    @Override
    public void eliminarEspecialidad(Especialidad especialidad) {
        especialidadService.EliminarEspecialidad(especialidad);
    }


    @Override
public List<Medico> listarMedicos() {
    return medicoService.listarMedicos();
}

@Override
public List<Paciente> listarPacientes() {
    return pacienteService.listarPacientes();
}

@Override
public List<Especialidad> listarEspecialidades() {
    return especialidadService.listarEspecialidades();
}

public IMedicoService getMedicoService() {
        return medicoService;
    }

    public IPacienteService getPacienteService() {
        return pacienteService;
    }

    public IEspecialidadService getEspecialidadService() {
        return especialidadService;
    }
}
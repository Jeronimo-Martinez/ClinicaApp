package com.mycompany.clinicaapp.LogicaDelNegocio;
import com.mycompany.clinicaapp.Interfaces.IMedicoService;
import com.mycompany.clinicaapp.Interfaces.IEspecialidadService;
import com.mycompany.clinicaapp.Interfaces.IGestorCita;
import com.mycompany.clinicaapp.Interfaces.IPacienteService;
import com.mycompany.clinicaapp.Interfaces.IHistorialService;
import com.mycompany.clinicaapp.Interfaces.IGestorAdministrador;
import com.mycompany.clinicaapp.Modelos.*;

import java.util.ArrayList;
import java.util.List;



/**
 * GestorAdministrador actúa como fachada para las operaciones
 * que el administrador puede realizar sobre médicos, pacientes
 * y especialidades.
 * 
 * Cumple el principio de inversión de dependencias (D de SOLID)
 * ya que depende de las interfaces, no de las implementaciones concretas.
 */
public class GestorAdministrador implements IGestorAdministrador {
    private static GestorAdministrador instancia;
    private final IMedicoService medicoService;
    private final IPacienteService pacienteService;
    private final IEspecialidadService especialidadService;
    private final List<Administrador> listaAdministradores; // para simular registro/login
    /**
     * Constructor que recibe las dependencias desde fuera.
     * Esto permite inyectar las implementaciones concretas.
     */
    public GestorAdministrador(IMedicoService medicoService, IPacienteService pacienteService,IEspecialidadService especialidadService) {
                                                     
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
        this.especialidadService = especialidadService;
         this.listaAdministradores = new ArrayList<>();
        // Se podría crear un admin por defecto
        listaAdministradores.add(new Administrador("admin", "1234"));
    }

    /**
     * Devuelve la única instancia de GestorAdministrador.
     * 
     * @param medicoService gestor de médicos (inyectado)
     * @param pacienteService gestor de pacientes (inyectado)
     * @param especialidadService gestor de especialidades (inyectado)
     * @return instancia única del GestorAdministrador
     */
    public static GestorAdministrador getInstancia(IMedicoService medicoService,  IPacienteService pacienteService,   IEspecialidadService especialidadService) {
                                                  
                                                 
        if (instancia == null) {
            instancia = new GestorAdministrador(medicoService, pacienteService, especialidadService);
        }
        return instancia;
    }
     // -------------------- MÉTODOS DE INICIO DE SESIÓN --------------------

    /**
     * Permite iniciar sesión del administrador por usuario y contraseña.
     * 
     * @param usuario nombre de usuario
     * @param contrasena contraseña
     * @return el Administrador si coincide, o null si no existe
     */
    public Administrador iniciarSesion(String cedula, String contrasena) {
        for (Administrador admin : listaAdministradores) {
            if (admin.getCedula().equals(cedula) && admin.getContrasena().equals(contrasena)) {
                return admin;
            }
        }
        return null;
    }

    // -------------------- MÉTODOS ADMIN --------------------

    @Override
    public void registrarMedico(Medico medico) {
        medicoService.registrarMedico(medico);
    }

    @Override
    public void editarMedico(Medico medico) {
        medicoService.editarMedico(medico);
    }

    @Override
    public void eliminarMedico(String id) {
        medicoService.eliminarMedico(id);
    }

    @Override
    public void registrarPaciente(Paciente paciente) {
        pacienteService.registrarPaciente(paciente);
    }

    @Override
    public void editarPaciente(Paciente paciente) {
        pacienteService.editarPaciente(paciente);
    }

    @Override
    public void eliminarPaciente(String id) {
        pacienteService.eliminarPaciente(id);
    }

    @Override
    public void registrarEspecialidad(Especialidad especialidad) {
        especialidadService.registrarEspecialidad(especialidad);
    }
}


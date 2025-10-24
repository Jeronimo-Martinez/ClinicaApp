package com.mycompany.clinicaapp.LogicaDelNegocio;
import java.util.List;
import com.mycompany.clinicaapp.Modelos.Paciente;
/**
 * Esta interfaz se encarga de definir las operaciones que pueden realizarse sobre los pacientes
 * @author Valentina
 */

public interface IPacienteService {

    boolean registrarPaciente (Paciente paciente);
    boolean editarPaciente (Paciente paciente);
    boolean eliminarPaciente (Paciente paciente);
    List<Paciente> listarPacientes ();
}

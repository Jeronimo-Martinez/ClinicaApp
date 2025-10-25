<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.clinicaapp.Interfaces;

=======
package com.mycompany.clinicaapp.Interfaces;
import java.util.List;
import com.mycompany.clinicaapp.Modelos.Paciente;
>>>>>>> main
/**
 * Esta interfaz se encarga de definir las operaciones CRUD que deben realizarse sobre los pacientes
 * @author Valentina
 */
<<<<<<< HEAD
public interface IPacienteService {

    
} 


=======

public interface IPacienteService {

    boolean registrarPaciente (Paciente paciente);
    boolean editarPaciente (Paciente paciente);
    boolean eliminarPaciente (Paciente paciente);
    List<Paciente> listarPacientes ();
}
>>>>>>> main

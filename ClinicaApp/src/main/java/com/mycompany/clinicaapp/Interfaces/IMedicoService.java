/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinicaapp.Interfaces;
import com.mycompany.clinicaapp.Modelos.Medico;
import java.util.List;

/**
 *
 * @author hecto
 */
public interface IMedicoService {

    // Registra un nuevo médico 
    boolean registrarMedico(Medico medico);

    // Permite iniciar sesión 
    Medico iniciarSesion(String cedula, String contrasena);

    // Elimina un médico por cédula 
    boolean eliminarMedico(String cedula);

    // Edita los datos de un médico 
    boolean editarMedico(Medico medicoActualizado);

    // Devuelve la lista de médicos registrados 
    List<Medico> listarMedicos();
}    
    
    

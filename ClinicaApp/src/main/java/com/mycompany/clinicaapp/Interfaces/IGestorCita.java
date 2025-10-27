/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinicaapp.Interfaces;

import java.util.List;
import com.mycompany.clinicaapp.Modelos.Paciente;
import com.mycompany.clinicaapp.Modelos.Cita;

/**
 *
 * @author jmart
 */
public interface IGestorCita {
    
    boolean registrarCita(Cita c);
    List<Cita> consultarCitasPaciente(Paciente paciente);
    boolean eliminarCita(String idCita);
    boolean modificarCita(String idCita, Cita nueva);
    List<Cita> getCitas();
    
}

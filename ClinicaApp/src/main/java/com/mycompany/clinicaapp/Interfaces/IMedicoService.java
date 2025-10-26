/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinicaapp.Interfaces;

import com.mycompany.clinicaapp.Modelos.Especialidad;
import com.mycompany.clinicaapp.Modelos.Medico;
import java.util.ArrayList;

/**
 *
 * @author johan
 */
public interface IMedicoService {
    boolean registrarPacienteAdmin(Medico medico);
    boolean agregarMedicoAdmin(Medico medico);
    void eliminarMedicoAdmin(int posicion);
    Medico iniciarSesion(String cedula, String contrasena);
    ArrayList<Medico> getListaMedicos();
    void actualizarMedico(Medico medico, String nuevoNombre, String nuevaCedula, Especialidad nuevaEspecialidad);

    
}

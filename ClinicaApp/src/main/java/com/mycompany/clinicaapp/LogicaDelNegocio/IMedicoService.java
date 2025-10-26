/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinicaapp.LogicaDelNegocio;

import com.mycompany.clinicaapp.Modelos.Especialidad;
import com.mycompany.clinicaapp.Modelos.Medico;
import java.util.ArrayList;

/**
 *
 * @author johan
 */
public interface IMedicoService {
    boolean registrarPaciente(Medico medico);
    boolean agregarMedico(Medico medico);
    void eliminarMedico(int posicion);
    Medico iniciarSesion(String cedula, String contrasena);
    ArrayList<Medico> getListaMedicos();
    void actualizarMedico(Medico medico, String nuevoNombre, String nuevaCedula, Especialidad nuevaEspecialidad);

    
}

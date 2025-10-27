/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.Interfaces;

import com.mycompany.clinicaapp.Modelos.Especialidad;
import java.util.List;

/**
 *
 * @author hecto
 */
public interface IEspecialidadService {
    
    void ingresarEspecialidad (Especialidad especialidad);
    void eliminarEspecialidad(Especialidad especialidad);
    List<Especialidad> listarEspecialidades();    

}

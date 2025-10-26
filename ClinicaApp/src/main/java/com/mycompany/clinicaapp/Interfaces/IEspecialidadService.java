/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.Interfaces;
import java.util.ArrayList;
import com.mycompany.clinicaapp.Modelos.Especialidad;
/**
 *
 * @author hecto
 */
public interface IEspecialidadService {
    
    ArrayList<Especialidad> listarEspecialidades();
    
    void ingresarEspecialidad(Especialidad esp);
    
    void eliminarEspecialidad(Especialidad esp);
}


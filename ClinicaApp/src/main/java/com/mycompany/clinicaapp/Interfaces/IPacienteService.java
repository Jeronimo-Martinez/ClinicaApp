/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.clinicaapp.Interfaces;

import com.mycompany.clinicaapp.Modelos.Paciente;

/**
 *
 * @author hecto
 */
public interface IPacienteService {

    public boolean registrarPaciente(Paciente paciente);

    public void editarPaciente(Paciente paciente);

    public void eliminarPaciente(String id);

    
} 



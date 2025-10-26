/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.clinicaapp.Interfaces;

import com.mycompany.clinicaapp.Modelos.Medico;

/**
 *
 * @author hecto
 */
public interface IMedicoService {

    public void editarMedico(Medico medico);

    public void registrarMedico(Medico medico);

    public void eliminarMedico(String id);

    
} 

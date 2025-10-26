/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.clinicaapp.Interfaces;

import com.mycompany.clinicaapp.Modelos.Medico;
import java.util.List;

/**
 *
 * @author hecto
 */
public interface IMedicoService {

    boolean editarMedico(Medico medico);

    boolean registrarMedico(Medico medico);

    boolean eliminarMedico(String id);

    public List<Medico> getListaMedicos();

    
} 

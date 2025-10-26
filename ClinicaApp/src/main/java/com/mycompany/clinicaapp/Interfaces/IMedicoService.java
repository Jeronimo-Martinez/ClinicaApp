/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinicaapp.Interfaces;
import com.mycompany.clinicaapp.Modelos.Medico;
import java.util.ArrayList;
/**
 *
 * @author hecto
 */
public interface IMedicoService {

    
    boolean registrarMedico(Medico medico);
    
    ArrayList<Medico> listarMedicos();
    
    boolean editarMedico(Medico medico);
    
    boolean eliminarMedico(String id);
}
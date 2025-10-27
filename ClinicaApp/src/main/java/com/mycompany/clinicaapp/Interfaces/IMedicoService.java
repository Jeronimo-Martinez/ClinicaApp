/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinicaapp.Interfaces;
import com.mycompany.clinicaapp.Modelos.Medico;
import java.util.List;

/**
 * Encargada de definir todas las operaciones CRUD(Create, Read, Update and Delete)
 * que deben realizarse sobre los Medicos
 * @author hecto
 */
public interface IMedicoService {

    boolean editarMedico(Medico medico);

    boolean registrarMedico(Medico medico);

    List<Medico> listaMedicos();


    
} 


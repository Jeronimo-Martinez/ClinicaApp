/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.LogicaDelNegocio;

import com.mycompany.clinicaapp.Modelos.Medico;
import java.util.ArrayList;

/**
 *
 * @author hecto
 */
public class GestorMedico {
    private final ArrayList<Medico> listaMedicos = new ArrayList<>();

    public boolean registrarPaciente(Medico medico) {
        listaMedicos.add(medico);
        return true;
    }

    public Medico iniciarSesion(String cedula, String contrasena) {
        for (Medico medicoingresado : listaMedicos) {
            if (medicoingresado.getCedula().equals(cedula) && medicoingresado.getContrasena().equals(contrasena)) {
                return medicoingresado;
            }
        }
        return null;
    }
    
}

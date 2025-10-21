/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.LogicaDelNegocio;

import com.mycompany.clinicaapp.Modelos.Paciente;
import java.util.ArrayList;

/**
 *
 * @author hecto
 */
public class GestorPaciente{
    private final ArrayList<Paciente> listaPacientes = new ArrayList<>();

    
    public boolean registrarPaciente(Paciente paciente) {
        listaPacientes.add(paciente);
        return true;
    }

    public Paciente iniciarSesion(String cedula, String contrasena) {
        for (Paciente pacienteingresado : listaPacientes) {
            if (pacienteingresado.getCedula().equals(cedula) && pacienteingresado.getContrasena().equals(contrasena)) {
                return pacienteingresado;
            }
        }
        return null;
    }
}

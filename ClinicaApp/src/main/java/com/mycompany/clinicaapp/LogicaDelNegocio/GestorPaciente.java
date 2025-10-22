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

    public GestorPaciente() {
        listaPacientes.add(new Paciente("0000", "Juan Pérez", "3001234567", 28, "0000"));
        listaPacientes.add(new Paciente("2020", "María López", "3107654321", 35, "abcd"));
        listaPacientes.add(new Paciente("3030", "Carlos Ruiz", "3209876543", 42, "clave"));
    }
    
    public String registrarPaciente(Paciente paciente) {
       
        if (paciente.getCedula().isEmpty() || paciente.getNombre().isEmpty() ||
            paciente.getTelefono().isEmpty() || paciente.getContrasena().isEmpty()) {
            return "Por favor complete todos los campos obligatorios.";
        }

   
        for (Paciente p : listaPacientes) {
            if (p.getCedula().equals(paciente.getCedula())) {
                return "Ya existe un paciente registrado con esa cédula.";
            }
        }

        listaPacientes.add(paciente);
        return "Paciente registrado correctamente.";
    }

    public Paciente iniciarSesion(String cedula, String contrasena) {
        for (Paciente paciente : listaPacientes) {
            if (paciente.getCedula().equals(cedula) && paciente.getContrasena().equals(contrasena)) {
                return paciente;
            }
        }
        return null;
    }
}

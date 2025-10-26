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
    private static GestorPaciente instancia;

    public GestorPaciente() {
        listaPacientes.add(new Paciente("0000", "Juan Pérez", "3001234567", 28, "0000"));
        listaPacientes.add(new Paciente("2020", "María López", "3107654321", 35, "abcd"));
        listaPacientes.add(new Paciente("3030", "Carlos Ruiz", "3209876543", 42, "clave"));
    }
    
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
    
    public static GestorPaciente getInstancia() {
        if (instancia == null) {
            instancia = new GestorPaciente();
        }
        return instancia;
    }
}

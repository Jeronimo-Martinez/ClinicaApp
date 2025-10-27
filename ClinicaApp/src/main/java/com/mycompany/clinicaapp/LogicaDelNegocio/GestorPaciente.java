/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.LogicaDelNegocio;

import com.mycompany.clinicaapp.Interfaces.IPacienteService;
import com.mycompany.clinicaapp.Modelos.Paciente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hecto
 */
public class GestorPaciente implements IPacienteService{
    private static GestorPaciente instancia;
    public final ArrayList<Paciente> listaPacientes = new ArrayList<>();

    public GestorPaciente() {
        listaPacientes.add(new Paciente("0000", "Juan Pérez", "3001234567", 28, "0000"));
        listaPacientes.add(new Paciente("2020", "María López", "3107654321", 35, "abcd"));
        listaPacientes.add(new Paciente("3030", "Carlos Ruiz", "3209876543", 42, "clave"));
    }
    
    public static GestorPaciente getInstanciaPaciente() {
        if (instancia == null) {
            instancia = new GestorPaciente();
        }
        return instancia;
    }    
    
   
    public boolean registrarPaciente(Paciente paciente) {
        if (paciente.getNombre().isEmpty() ||
            paciente.getTelefono().isEmpty() ||
            paciente.getCedula().isEmpty() ||
            paciente.getContrasena().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                "Por favor complete todos los campos.",
                "Campos vacíos",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Validar edad
        if (paciente.getEdad() <= 0 ) {
            JOptionPane.showMessageDialog(null,
                "La edad debe ser mayor a 0.",
                "Edad inválida",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (paciente.getEdad() > 100 ) {
            JOptionPane.showMessageDialog(null,
                "La edad debe ser menor a 100.",
                "Edad inválida",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }

    // Validar duplicados (cedula, telefono o nombre)
    for (Paciente pacienteExistente : listaPacientes) {
        if (pacienteExistente.getCedula().equals(paciente.getCedula())) {
            JOptionPane.showMessageDialog(null,
                "Ya existe un paciente con esta cédula.",
                "Cédula duplicada",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (pacienteExistente.getTelefono().equals(paciente.getTelefono())) {
            JOptionPane.showMessageDialog(null,
                "Ya existe un paciente con este número de teléfono.",
                "Teléfono duplicado",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (pacienteExistente.getNombre().equalsIgnoreCase(paciente.getNombre())) {
            JOptionPane.showMessageDialog(null,
                "Ya existe un paciente con este nombre.",
                "Nombre duplicado",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        }        
        
        
        // Si pasa todas las validaciones, lo agrega
        listaPacientes.add(paciente);
        JOptionPane.showMessageDialog(null,
            "Paciente registrado correctamente.",
            "Registro exitoso",
            JOptionPane.INFORMATION_MESSAGE);

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

    @Override
    public void editarPaciente(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarPaciente(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
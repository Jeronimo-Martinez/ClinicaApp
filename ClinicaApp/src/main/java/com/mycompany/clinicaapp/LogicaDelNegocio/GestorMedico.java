/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.LogicaDelNegocio;

import com.mycompany.clinicaapp.Modelos.Especialidad;
import com.mycompany.clinicaapp.Modelos.Medico;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author hecto
 */
public class GestorMedico {
    private static GestorMedico instancia;
    private final ArrayList<Medico> listaMedicos = new ArrayList<>();

    public GestorMedico() {
        Especialidad cardio = new Especialidad("Cardiología");
        Especialidad general = new Especialidad("Medicina General");
        listaMedicos.add(new Medico("1111", "Andrés Gómez", cardio, "1111"));
        listaMedicos.add(new Medico("222", "Laura Torres", general, "2222"));
    }
    
    public static GestorMedico getInstanciaMedico() {
        if (instancia == null) {
            instancia = new GestorMedico();
        }
        return instancia;
    }    
    
    
    public boolean registrarMedico(Medico medico) {
        // Validar campos vacíos
        if (medico.getNombre().isEmpty() ||
            medico.getCedula().isEmpty() ||
            medico.getContrasena().isEmpty() ||
            medico.getEspecialidad() == null ||
            medico.getEspecialidad().getNombre().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                "Por favor complete todos los campos.",
                "Campos vacíos",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Validar duplicados (cédula o nombre)
        for (Medico existente : listaMedicos) {
            if (existente.getCedula().equals(medico.getCedula())) {
                JOptionPane.showMessageDialog(null,
                    "Ya existe un médico con esta cédula.",
                    "Cédula duplicada",
                    JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if (existente.getNombre().equalsIgnoreCase(medico.getNombre())) {
                JOptionPane.showMessageDialog(null,
                    "Ya existe un médico con este nombre.",
                    "Nombre duplicado",
                    JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        // Si pasa todas las validaciones, se agrega
        listaMedicos.add(medico);
        JOptionPane.showMessageDialog(null,
            "Médico registrado correctamente.",
            "Registro exitoso",
            JOptionPane.INFORMATION_MESSAGE);
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
    public List<Medico> listarMedicosEspecialidad(String nombreEspecialidad){
        return this.listaMedicos.stream().filter(m -> (m.getEspecialidad().getNombre() == null ? nombreEspecialidad == null : m.getEspecialidad().getNombre().equals(nombreEspecialidad))).collect(Collectors.toList());
    }
    
}

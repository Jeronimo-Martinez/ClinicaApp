/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.LogicaDelNegocio;

import com.mycompany.clinicaapp.Interfaces.IMedicoService;
import com.mycompany.clinicaapp.Modelos.Especialidad;
import com.mycompany.clinicaapp.Modelos.Medico;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hecto
 */
public class GestorMedico implements IMedicoService {
    private final ArrayList<Medico> listaMedicos = new ArrayList<>();
    private static GestorMedico instancia;
    private Medico medicoActual;

    public GestorMedico() {
        Especialidad e1 = new Especialidad("Medicina General");
        Especialidad e2 = new Especialidad("Pediatría");

        listaMedicos.add(new Medico("2001", "Dr. Suárez", e1, "m1pass"));
        listaMedicos.add(new Medico("2002", "Dra. López", e2, "m2pass"));
        Especialidad cardio = new Especialidad("Cardiología");
        Especialidad general = new Especialidad("Medicina General");
        listaMedicos.add(new Medico("1111", "Andrés Gómez", cardio, "1111"));
        listaMedicos.add(new Medico("222", "Laura Torres", general, "2222"));
    }
    
    private boolean validarInformacion(Medico medico) {
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

        // Validar duplicados
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

    return true; // Todo correcto
}
    
    @Override
    public boolean registrarMedico(Medico medico) {
        if (!validarInformacion(medico)) {
            return false; // Si falla la validación, no continúa
        }

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
    
    @Override
    public boolean eliminarMedico(String cedula) {
    for (Medico m : listaMedicos) {
        if (m.getCedula().equals(cedula)) {
            listaMedicos.remove(m);
            return true;
        }
    }
    return false; // No se encontró el médico
    }
    
    @Override
    public boolean editarMedico(Medico medicoActualizado) {
    for (int i = 0; i < listaMedicos.size(); i++) {
        Medico medico = listaMedicos.get(i);
        if (medico.getCedula().equals(medicoActualizado.getCedula())) {
            // Actualizar campos
            medico.setNombre(medicoActualizado.getNombre());
            medico.setEspecialidad(medicoActualizado.getEspecialidad());
            medico.setContrasena(medicoActualizado.getContrasena());
            return true;
        }
    }
    return false; // No se encontró el médico
    }
    
    public static GestorMedico getInstanciaMedico() {
        if (instancia == null) {
            instancia = new GestorMedico();
        }
        return instancia;
    }    
    
    public Medico getMedicoActual() {
        return medicoActual;
    }
    

    public Medico buscarPorCedula(String cedula) {
        for (Medico m : listaMedicos) {
            if (m.getCedula().equals(cedula)) {
                return m;
            }
        }
        return null;
    }
    
    public void setMedicoActual(Medico medico) {
        this.medicoActual = medico;
    }
    }
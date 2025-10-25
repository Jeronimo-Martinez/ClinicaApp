/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.LogicaDelNegocio;

import com.mycompany.clinicaapp.Interfaces.IMedicoService;
import com.mycompany.clinicaapp.Modelos.Especialidad;
import com.mycompany.clinicaapp.Modelos.Medico;
import java.util.ArrayList;

/**
 *
 * @author hecto
 */
public class GestorMedico implements IMedicoService {
    private final ArrayList<Medico> listaMedicos = new ArrayList<>();

    public GestorMedico() {
        Especialidad cardio = new Especialidad("Cardiología");
        Especialidad general = new Especialidad("Medicina General");
        listaMedicos.add(new Medico("1111", "Andrés Gómez", cardio, "1111"));
        listaMedicos.add(new Medico("222", "Laura Torres", general, "2222"));
    }
    
    
    public boolean registrarMedico(Medico medico) {
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
    
    public boolean eliminarMedico(String cedula) {
    for (Medico m : listaMedicos) {
        if (m.getCedula().equals(cedula)) {
            listaMedicos.remove(m);
            return true;
        }
    }
    return false; // No se encontró el médico
    }
    
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
   
    }

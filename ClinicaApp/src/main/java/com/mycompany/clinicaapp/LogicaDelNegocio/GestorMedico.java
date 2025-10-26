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

    private GestorMedico() {
        Especialidad cardio = new Especialidad("Cardiología");
        Especialidad general = new Especialidad("Medicina General");
        listaMedicos.add(new Medico("1111", "Andrés Gómez", cardio, "1111"));
        listaMedicos.add(new Medico("222", "Laura Torres", general, "2222"));
    }

    /**
     *
     * @param medico
     * @param nuevoNombre
     * @param nuevaCedula
     * @param nuevaEspecialidad
     */
    @Override
    public void actualizarMedico(Medico medico, String nuevoNombre, String nuevaCedula, Especialidad nuevaEspecialidad) {
    medico.setNombre(nuevoNombre);
    medico.setCedula(nuevaCedula);
    medico.setEspecialidad(nuevaEspecialidad);
}

    

    @Override
    public ArrayList<Medico> getListaMedicos() {
        return listaMedicos;
    }

    @Override
    public boolean registrarPacienteAdmin(Medico medico) {
    
        return false;
    
    }
    public boolean registrarMedico(Medico medico) {
        listaMedicos.add(medico);
        return true;
    }

    @Override
    public boolean agregarMedicoAdmin(Medico medico) {
        listaMedicos.add(medico);
        return true;
    }

    @Override
    public void eliminarMedicoAdmin(int posicion) {
        listaMedicos.remove(posicion);
    }

    @Override
    
    public Medico iniciarSesion(String cedula, String contrasena) {
        for (Medico medico : listaMedicos) {
            if (medico.getCedula().equals(cedula) && medico.getContrasena().equals(contrasena)) {
                return medico;
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

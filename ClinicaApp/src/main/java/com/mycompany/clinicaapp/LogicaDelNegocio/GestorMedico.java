/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.LogicaDelNegocio;

import com.mycompany.clinicaapp.Interfaces.IMedicoService;
import com.mycompany.clinicaapp.Modelos.Especialidad;
import com.mycompany.clinicaapp.Modelos.Medico;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author hecto
 */


public class GestorMedico implements IMedicoService {

    private final ArrayList<Medico> listaMedicos = new ArrayList<>();
    
    
    
   
    
    
    public GestorMedico() {
        // Datos de ejemplo
        Especialidad cardio = new Especialidad("Cardiología");
        Especialidad general = new Especialidad("Medicina General");
        Especialidad pediatria = new Especialidad("Pediatría");
        
        listaMedicos.add(new Medico("1111", "Andrés Gómez", cardio, "1111"));
        listaMedicos.add(new Medico("222", "Laura Torres", general, "2222"));
        listaMedicos.add(new Medico("333", "Carmen Díaz", pediatria, "3333"));
        listaMedicos.add(new Medico("444", "Roberto Sánchez", general, "4444"));
    }

    /**
     *
     * @param nombreEspecialidad
     * @param medico
     * @param nuevoNombre
     * @param nuevaEspecialidad
     * @return 
     */
    
    
    
    @Override
    public List<Medico> listarMedicosEspecialidad(String nombreEspecialidad) {
        if (nombreEspecialidad == null) return new ArrayList<>();
        
        return listaMedicos.stream()
            .filter(m -> m.getEspecialidad() != null && 
                        nombreEspecialidad.equals(m.getEspecialidad().getNombre()))
            .collect(Collectors.toList());
    }
    
    @Override
    public boolean editarMedico(Medico medico, String nuevoNombre, Especialidad nuevaEspecialidad) {
        medico.setNombre(nuevoNombre);
        medico.setEspecialidad(nuevaEspecialidad);
        return true;
    }

    @Override
    public List<Medico> listaMedicos() {
        return new ArrayList<>(listaMedicos);
    }
    
    public List<Medico> listarMedicos() {
        return listaMedicos();
    }

    /**
     *
     * @param medico
     * @return
     */
    @Override
    public boolean agregarMedic(Medico medico) {
        listaMedicos.add(medico);
        return true;
    }

    @Override
    public boolean eliminarMedico(String cedula) {
        return listaMedicos.removeIf(m -> m.getCedula().equals(cedula));
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

}
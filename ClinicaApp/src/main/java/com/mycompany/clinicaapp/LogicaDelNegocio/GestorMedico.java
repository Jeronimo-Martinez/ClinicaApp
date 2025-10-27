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
     * @param nuevaEspecialidad
     */
    
    @Override
    public void editarMedico(Medico medico, String nuevoNombre, Especialidad nuevaEspecialidad) {
        medico.setNombre(nuevoNombre);
        medico.setEspecialidad(nuevaEspecialidad);
    }

    @Override
    public ArrayList<Medico> getListaMedicos() {
        return listaMedicos;
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
    @Override
    public boolean editarMedico(Medico medico) {
        for (int i = 0; i < listaMedicos.size(); i++) {
            Medico actual = listaMedicos.get(i);
            if (actual.getCedula().equals(medico.getCedula())) {
                listaMedicos.set(i, medico); // reemplaza el objeto completo
                return true;
            }
        }
        return false; // no encontrado
}
    
}


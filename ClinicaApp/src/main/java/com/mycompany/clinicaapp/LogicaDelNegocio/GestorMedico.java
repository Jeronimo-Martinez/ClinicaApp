/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.LogicaDelNegocio;

import com.mycompany.clinicaapp.Modelos.Especialidad;
import com.mycompany.clinicaapp.Modelos.Medico;
import java.util.ArrayList;

/**
 *
 * @author hecto
 */
public class GestorMedico {
    private static final GestorMedico instancia = new GestorMedico();
    private final ArrayList<Medico> listaMedicos = new ArrayList<>();

    public GestorMedico() {
        Especialidad cardio = new Especialidad("Cardiología");
        Especialidad general = new Especialidad("Medicina General");
        listaMedicos.add(new Medico("1111", "Andrés Gómez", cardio, "" + "1111"));
        listaMedicos.add(new Medico("222", "Laura Torres", general, "2222"));
    }
    public static GestorMedico getInstancia() {
        return instancia;
    }

    public ArrayList<Medico> getListaMedicos() {
        return listaMedicos;
    }

    public boolean registrarPaciente(Medico medico) {
        listaMedicos.add(medico);
        return true;
    }

    public void eliminarMedico(int posicion) {
    listaMedicos.remove(posicion);
}
     
    public Medico iniciarSesion(String cedula, String contrasena) {
        for (Medico medicoingresado : listaMedicos) {
            if (medicoingresado.getCedula().equals(cedula) && medicoingresado.getContrasena().equals(contrasena)) {
                return medicoingresado;
            }
        }
        return null;
    }

}

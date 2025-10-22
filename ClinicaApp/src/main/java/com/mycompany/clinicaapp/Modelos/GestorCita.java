/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.Modelos;

import com.mycompany.clinicaapp.LogicaDelNegocio.IGestorCita;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jmart
 * @version 1.0.0
 */
public class GestorCita implements IGestorCita {
    private final ArrayList<Cita> listaCitas = new ArrayList<>(); 
    
    public GestorCita(){
        // citas de ejemplo
        Paciente p1 = new Paciente("1001","Juan Perez","3001112222",30,"pass1");
        Paciente p2 = new Paciente("1002","María Gómez","3003334444",25,"pass2");
        Paciente p3 = new Paciente("1003","Carlos Ruiz","3005556666",40,"pass3");
        
        Especialidad e1 = new Especialidad("Medicina General");
        Especialidad e2 = new Especialidad("Pediatría");
        
        Medico m1 = new Medico("2001","Dr. Suárez", e1, "m1pass");
        Medico m2 = new Medico("2002","Dra. López", e2, "m2pass");
        
        listaCitas.add(new Cita("001",LocalDate.of(2025, 10, 22), "Consulta general", m1, p1));
        listaCitas.add(new Cita("002",LocalDate.of(2025, 11, 5),  "Control pediátrico", m2, p2));
        listaCitas.add(new Cita("003",LocalDate.of(2025, 12, 1),  "Revisión anual", m1, p3));
    
    }
    @Override
    public boolean registrarCita(Cita c) {
        try {
            listaCitas.add(c);
            return true;
        }catch (Exception exception) {
            System.out.println("Error inesperado, no se pudo almacenar la cita");
            return false;
        }

        }

        @Override
        public List<Cita> consultarCitasPaciente
        (Paciente paciente
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public boolean eliminarCita
        (String idCita
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public boolean modificarCita
        (String idCita, Cita nueva
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

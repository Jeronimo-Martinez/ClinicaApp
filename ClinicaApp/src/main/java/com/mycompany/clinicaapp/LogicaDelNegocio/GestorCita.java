/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.LogicaDelNegocio;

import com.mycompany.clinicaapp.Interfaces.IGestorCita;
import com.mycompany.clinicaapp.Modelos.Paciente;
import com.mycompany.clinicaapp.Modelos.Especialidad;
import com.mycompany.clinicaapp.Modelos.Medico;
import com.mycompany.clinicaapp.Modelos.Cita;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 *
 * @author jmart
 * @version 1.0.0
 */
public class GestorCita implements IGestorCita {
    private final ArrayList<Cita> listaCitas = new ArrayList<>(); 
    
    public GestorCita(){
        // Obtener instancias de los gestores
        GestorMedico gestorMedico = new GestorMedico();
        GestorPaciente gestorPaciente = new GestorPaciente();
        
        // Obtener las listas de médicos y pacientes
        List<Medico> medicos = gestorMedico.listaMedicos();
        List<Paciente> pacientes = gestorPaciente.listarPacientes();
        
        // Crear citas de ejemplo usando los médicos y pacientes existentes
        // Para el Dr. Andrés Gómez (Cardiología)
        Medico drGomez = medicos.get(0); // "1111"
        listaCitas.add(new Cita("C001", LocalDate.of(2025, 10, 28), "09:00", drGomez, pacientes.get(0))); // Ana García
        listaCitas.add(new Cita("C002", LocalDate.of(2025, 10, 29), "10:30", drGomez, pacientes.get(1))); // Carlos López
        
        // Para la Dra. Laura Torres (Medicina General)
        Medico draTorres = medicos.get(1); // "222"
        listaCitas.add(new Cita("C003", LocalDate.of(2025, 10, 28), "11:00", draTorres, pacientes.get(2))); // María Rodríguez
        listaCitas.add(new Cita("C004", LocalDate.of(2025, 10, 30), "15:00", draTorres, pacientes.get(0))); // Ana García
        
        // Para la Dra. Carmen Díaz (Pediatría)
        Medico draDiaz = medicos.get(2); // "333"
        listaCitas.add(new Cita("C005", LocalDate.of(2025, 10, 29), "14:00", draDiaz, pacientes.get(1))); // Carlos López
        listaCitas.add(new Cita("C006", LocalDate.of(2025, 10, 31), "16:30", draDiaz, pacientes.get(2))); // María Rodríguez
        
        // Para el Dr. Roberto Sánchez (Medicina General)
        Medico drSanchez = medicos.get(3); // "444"
        listaCitas.add(new Cita("C007", LocalDate.of(2025, 11, 1), "08:30", drSanchez, pacientes.get(0))); // Ana García
        listaCitas.add(new Cita("C008", LocalDate.of(2025, 11, 2), "10:00", drSanchez, pacientes.get(2))); // María Rodríguez
    
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
        public List<Cita> consultarCitasPaciente(Paciente paciente){
        try {
            return this.listaCitas.stream().filter(c -> c.getPaciente() == paciente).collect(Collectors.toList()); // haskell me traumo con los maps y filter ;-;
        }catch (Exception exception) {
            System.out.println("Error inesperado");
            return null;
        }

        }
        
        @Override
        public List<Cita> consultarCitasMedico(Medico medico){
        try {
            return this.listaCitas.stream().filter(c -> c.getMedico() == medico).collect(Collectors.toList()); // haskell me traumo con los maps y filter ;-;
        }catch (Exception exception) {
            System.out.println("Error inesperado");
            return null;
        }
        }
        
        @Override
        public Cita buscarCitaPorId(String idCita) {
            for (Cita c : listaCitas) {
                if (c.getId().equals(idCita)) {
                     return c;
            }
        }return null;}

        @Override
        public boolean eliminarCita(String idCita) {
        try {
            return this.listaCitas.removeIf(c -> c.getId() == idCita); // la funcion remove if retorna un valor booleano dependiendo de si se elimino o no un elemento de la lista 
        }catch (Exception exception) {                                  
            System.out.println("Error inesperado");
            return false;
        }}

        @Override
        public boolean modificarCita(String idCita, Cita nueva) {
            try{
                for(int i = 0 ; i < listaCitas.size(); i++){
                    Cita c = listaCitas.get(i);
                    if (c.getId().equals(idCita)){
                        listaCitas.set(i, nueva);
                        return true;
                    
                }  
            }return false;
            }catch (Exception exception) {                                  
                System.out.println("Error inesperado");
                return false;
        }}
        @Override
         public List<Cita> getCitas() {
            return listaCitas;

    }
    }   

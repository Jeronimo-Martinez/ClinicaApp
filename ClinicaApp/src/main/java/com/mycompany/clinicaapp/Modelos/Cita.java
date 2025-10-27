/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.Modelos;
import java.time.LocalDate;
/**
 *
 * @author hecto
 * @vesion 1.1.0
 */
public class Cita {
    private String id;
    private LocalDate fecha;
    private String hora;
    private String diagnostico;
    private Medico medico;
    private Paciente paciente;

    public Cita(String id, LocalDate fecha, String hora, Medico medico, Paciente paciente) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.diagnostico = null;
        this.medico = medico;
        this.paciente = paciente;
    }

    public String getId() {
            return id;
        }
        
        // el stter de id no deberia de usarse , pero se incluye para no romnper encapsulacion
        public void setId(String diagnostico) {
            this.id = diagnostico;
        }
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public String getHora() {
        return hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    @Override
    public String toString() {
        return String.format("Cita %s - Fecha: %s - Hora: %s%nMédico: %s%nPaciente: %s", 
            id, fecha, hora, medico.getNombre(), paciente.getNombre());
    }
}
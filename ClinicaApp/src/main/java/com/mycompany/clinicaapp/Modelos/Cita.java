/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp.Modelos;
import java.time.LocalDate;
/**
 *
 * @author hecto
 */
public class Cita {
    private LocalDate fecha;
    private String diagnostico;
    private Medico medico;
    private Paciente paciente;

    public Cita(LocalDate fecha, String diagnostico, Medico medico, Paciente paciente) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.medico = medico;
        this.paciente = paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
}
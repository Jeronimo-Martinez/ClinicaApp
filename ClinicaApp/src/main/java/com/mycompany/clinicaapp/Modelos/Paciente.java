package com.mycompany.clinicaapp.Modelos;

/**
 * Esta clase representa a un paciente de la clínica
 * @author Valentina 
 */ 

public class Paciente {

    private String cedula;
    private String nombre;
    private String telefono;
    private int edad;

    /**
     * Constructor vacío por defecto
     */

    public Paciente() {
    }

    /**
     * Constructor para la instancia de un Paciente
     * @param cedula Cédula (identificación) del paciente que se va a instanciar
     * @param nombre Nombre del paciente que se va a instanciar
     * @param telefono Número de telefóno del paciente que se va a instanciar
     * @param edad Edad del paciente que se va a instanciar
     */
    
    public Paciente(String cedula, String nombre, String telefono, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
    }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
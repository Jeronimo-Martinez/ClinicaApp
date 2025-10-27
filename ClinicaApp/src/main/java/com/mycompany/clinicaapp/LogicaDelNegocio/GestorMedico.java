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

/**
 * 
 * Esta clase implementa la interfaz IMedicoService y se encarga de gestionar las operaciones CRUD
 * sobre los objetos {@link Medico}, incluyendo validaciones, registro, edición y eliminación
 * Implementa el patrón Singleton para asegurar que solo exista una instancia del gestor en el sistema.
 * @author hecto
 */
public class GestorMedico implements IMedicoService {
    /** Lista de médicos registrados en el sistema */
    private final ArrayList<Medico> listaMedicos = new ArrayList<>();
    /** Instancia única del gestor (patrón Singleton) */
    private static GestorMedico instancia;
    /** Médico actualmente autenticado en sesión */
    private Medico medicoActual;

    /**
     * Constructor por defecto.
     * Inicializa la lista de médicos con algunos valores predeterminados.
     */
    public GestorMedico() {
        Especialidad e1 = new Especialidad("Medicina General");
        Especialidad e2 = new Especialidad("Pediatría");

        listaMedicos.add(new Medico("2001", "Dr. Suárez", e1, "m1pass"));
        listaMedicos.add(new Medico("2002", "Dra. López", e2, "m2pass"));
        Especialidad cardio = new Especialidad("Cardiología");
        Especialidad general = new Especialidad("Medicina General");
        listaMedicos.add(new Medico("1111", "Andrés Gómez", cardio, "1111"));
        listaMedicos.add(new Medico("222", "Laura Torres", general, "2222"));
    }
    
    /**
     * Valida la información de un médico antes de registrarlo o editarlo.
     * Verifica que no haya campos vacíos y que no existan duplicados por cédula o nombre.
     * 
     * @param medico Médico a validar
     * @return true si la información es válida, false en caso contrario
     */
    private boolean validarInformacion(Medico medico) {
        // Validar campos vacíos
        if (medico.getNombre().isEmpty() ||
            medico.getCedula().isEmpty() ||
            medico.getContrasena().isEmpty() ||
            medico.getEspecialidad() == null ||
            medico.getEspecialidad().getNombre().isEmpty()) {

    @Override
    public List<Medico> listaMedicos() {
        return new ArrayList<>(listaMedicos);
    }

        // Validar duplicados
        for (Medico existente : listaMedicos) {
            if (existente.getCedula().equals(medico.getCedula())) {
                JOptionPane.showMessageDialog(null,
                    "Ya existe un médico con esta cédula.",
                    "Cédula duplicada",
                    JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if (existente.getNombre().equalsIgnoreCase(medico.getNombre())) {
                JOptionPane.showMessageDialog(null,
                    "Ya existe un médico con este nombre.",
                    "Nombre duplicado",
                    JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

    return true; // Todo correcto
}
    
    /**
     * Registra un nuevo médico en el sistema si pasa las validaciones.
     * 
     * @param medico Objeto de tipo Medico a registrar
     * @return true si el médico fue registrado exitosamente, false si hubo un error o duplicado
     */
    @Override
    public boolean registrarMedico(Medico medico) {
        if (!validarInformacion(medico)) {
            return false; // Si falla la validación, no continúa
        }

        listaMedicos.add(medico);
        JOptionPane.showMessageDialog(null,
            "Médico registrado correctamente.",
            "Registro exitoso",
            JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    /**
     * Permite iniciar sesión a un médico mediante su cédula y contraseña.
     * 
     * @param cedula Cédula del médico
     * @param contrasena Contraseña del médico
     * @return El objeto Medico si las credenciales son correctas, o null en caso contrario
     */
    public Medico iniciarSesion(String cedula, String contrasena) {
        for (Medico medicoingresado : listaMedicos) {
            if (medicoingresado.getCedula().equals(cedula) && medicoingresado.getContrasena().equals(contrasena)) {
                return medicoingresado;
            }
        }
        return null;
    }
    
    /**
     * Elimina un médico del sistema según su cédula.
     * 
     * @param cedula Cédula del médico a eliminar
     * @return true si el médico fue eliminado correctamente, false si no se encontró
     */
    @Override
    public boolean eliminarMedico(String cedula) {
    for (Medico m : listaMedicos) {
        if (m.getCedula().equals(cedula)) {
            listaMedicos.remove(m);
            return true;
        }
    }
    return false; // No se encontró el médico
    }
    
    /**
     * Edita la información de un médico existente en la lista.
     * 
     * @param medicoActualizado Objeto Medico con los datos actualizados
     * @return true si se encontró y actualizó correctamente, false si no se encontró el médico
     */
    @Override
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
    
    /**
     * Devuelve la instancia única del GestorMedico (patrón Singleton).
     * 
     * @return instancia única de GestorMedico
     */
    public static GestorMedico getInstanciaMedico() {
        if (instancia == null) {
            instancia = new GestorMedico();
        }
        return instancia;
    }    
    
    /**
     * Obtiene el médico actualmente autenticado en el sistema.
     * 
     * @return El médico actualmente activo
     */
    public Medico getMedicoActual() {
        return medicoActual;
    }
    

    /**
     * Busca un médico en la lista por su cédula.
     * 
     * @param cedula Cédula del médico a buscar
     * @return El objeto Medico si se encuentra, o null si no existe
     */
    public Medico buscarPorCedula(String cedula) {
        for (Medico m : listaMedicos) {
            if (m.getCedula().equals(cedula)) {
                return m;
            }
        }
        return null;
    }
    
    /**
     * Establece el médico actualmente autenticado.
     * 
     * @param medico Objeto Medico que se establecerá como el actual
     */
    public void setMedicoActual(Medico medico) {
        this.medicoActual = medico;
    }
    
    
    /**
     * Devuelve una lista con todos los médicos registrados.
     * 
     * @return Lista de objetos Medico registrados
     */
    public ArrayList<Medico> getListaMedicos() {
        return new ArrayList<>(listaMedicos); // devuelve una copia para proteger la lista original
    }
    }


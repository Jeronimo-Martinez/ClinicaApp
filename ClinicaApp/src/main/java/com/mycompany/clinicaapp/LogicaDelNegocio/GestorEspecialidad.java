package com.mycompany.clinicaapp.LogicaDelNegocio;
import java.util.ArrayList;
import com.mycompany.clinicaapp.Interfaces.IEspecialidadService;
import com.mycompany.clinicaapp.Modelos.Especialidad;

public class GestorEspecialidad implements IEspecialidadService {
     private ArrayList<Especialidad> especialidades;
    public GestorEspecialidad() {
        this.especialidades = new ArrayList<>();
    }

    // Listar todas las especialidades
    public ArrayList<Especialidad> listarEspecialidades() {
        return new ArrayList<>(especialidades); // Devuelve una copia para proteger la lista original
    }

    // Ingresar una nueva especialidad
    public void ingresarEspecialidad(Especialidad esp) {
        if (esp != null) {
            especialidades.add(esp);
        }
    }

    // Eliminar una especialidad (por objeto o criterio)
    public void eliminarEspecialidad(Especialidad esp) {
    if (esp != null && esp.getNombre() != null) {
        especialidades.removeIf(e -> e.getNombre().equalsIgnoreCase(esp.getNombre()));
    }
}

    @Override
    public void EliminarEspecialidad(Especialidad especialidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

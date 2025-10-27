
package com.mycompany.clinicaapp.LogicaDelNegocio;

import com.mycompany.clinicaapp.Interfaces.IEspecialidadService;
import com.mycompany.clinicaapp.Modelos.Especialidad;
import java.util.ArrayList;
import java.util.List;

public class GestorEspecialidad implements IEspecialidadService {

    private final List<Especialidad> listaEspecialidades = new ArrayList<>();

    public GestorEspecialidad() {
        listaEspecialidades.add(new Especialidad("Cardiología"));
        listaEspecialidades.add(new Especialidad("Pediatría"));
    }

    @Override
    public void ingresarEspecialidad(Especialidad especialidad) {
        listaEspecialidades.add(especialidad);
    }

    @Override
    public void eliminarEspecialidad(Especialidad especialidad) {
        listaEspecialidades.removeIf(e -> e.getNombre().equalsIgnoreCase(especialidad.getNombre()));
    }

    @Override
    public List<Especialidad> listarEspecialidades() {
        return listaEspecialidades;
    }
}


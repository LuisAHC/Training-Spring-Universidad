package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.modelos.entidades.Persona;

public interface ProfesorDAO extends PersonaDAO{
    public Iterable<Persona> buscarProfesorPorNombreCarrera(String carrera);
}

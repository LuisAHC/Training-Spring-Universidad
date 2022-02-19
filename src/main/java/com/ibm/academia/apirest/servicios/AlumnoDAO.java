package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.modelos.entidades.Carrera;
import com.ibm.academia.apirest.modelos.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO{
    public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre);
    public Persona actualizar(Long alumnoId, Persona alumno);
    public Persona asociarCarreraAlumno(Long carreraId, Long alumnoId);
}

package com.ibm.academia.apirest.repositorios;

import com.ibm.academia.apirest.modelos.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository {
    //@Query("select a from Alumno a join fetch a.carrera c where c.nombre = ?1")
    @Query("select a from Alumno a where a.carrera.nombre = ?1")
    public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombreCarrera);
}

package com.ibm.academia.apirest.repositorios;

import com.ibm.academia.apirest.modelos.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioProfesores")
public interface ProfesorRepository extends PersonaRepository {
    @Query("select p from Profesor p join p.carreras c where c.nombre = ?1")
    public Iterable<Persona> buscarProfesorPorNombreCarrera(String carrera);
}

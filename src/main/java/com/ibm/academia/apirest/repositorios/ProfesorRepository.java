package com.ibm.academia.apirest.repositorios;

import com.ibm.academia.apirest.modelos.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioProfesores")
public interface ProfesorRepository extends PersonaRepository{

    @Query(value="select p from Profesor p join p.carreras c join c.nombre n where n = ?1", nativeQuery = true)
    public Iterable<Persona> buscarProfesorPorNombreCarrera(String carrera);
}

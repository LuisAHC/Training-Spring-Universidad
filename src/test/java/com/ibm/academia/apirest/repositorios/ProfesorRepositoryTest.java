package com.ibm.academia.apirest.repositorios;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.modelos.entidades.Carrera;
import com.ibm.academia.apirest.modelos.entidades.Persona;
import com.ibm.academia.apirest.modelos.entidades.Profesor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static java.lang.Long.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProfesorRepositoryTest {
    @Autowired
    @Qualifier("repositorioProfesores")
    private PersonaRepository profesorRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Test
    @DisplayName("Test: Buscar profesor por nombre de carrera")
    void buscarProfesorPorNombreCarrera() {
        // Given
        profesorRepository.save(DatosDummy.profesor01());
        Persona persona = profesorRepository.findById(Long.valueOf(1)).get();

        Set<Carrera> carreras = new HashSet<>();
        carreras.add(carreraRepository.save(DatosDummy.carrera01()));
        carreras.add(carreraRepository.save(DatosDummy.carrera02()));
        carreras.add(carreraRepository.save(DatosDummy.carrera03()));

        ((Profesor)persona).setCarreras(carreras);
        profesorRepository.save(persona);

        // When
        List<Persona> expected =  (List<Persona>) ((ProfesorRepository)profesorRepository).buscarProfesorPorNombreCarrera("Ingenieria en Sistemas");

        //Then
        assertThat(expected.isEmpty()).isFalse();
    }
}
package com.ibm.academia.apirest.repositorios;

import com.ibm.academia.apirest.modelos.entidades.Alumno;
import com.ibm.academia.apirest.modelos.entidades.Carrera;
import com.ibm.academia.apirest.modelos.entidades.Persona;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AlumnoRepositoryTest {
    @Autowired
    @Qualifier("repositorioAlumnos")
    private PersonaRepository alumnoRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Test
    @DisplayName("Test: Buscar alumnos por nombre carrera")
    void buscarAlumnoPorNombreCarrera() {
        //Given
        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(
                        com.ibm.academia.apirest.datos.DatosDummy.alumno01(),
                        com.ibm.academia.apirest.datos.DatosDummy.alumno02(),
                        com.ibm.academia.apirest.datos.DatosDummy.alumno03())
        );

        Carrera carrera = carreraRepository.save(com.ibm.academia.apirest.datos.DatosDummy.carrera01());
        personas.forEach(alumno -> ((Alumno)alumno).setCarrera(carrera));
        alumnoRepository.saveAll(personas);

        //When
        String carreraNombre = "Ingenieria en Sistemas";
        List<Persona> expected =  (List<Persona>) ((AlumnoRepository)alumnoRepository).buscarAlumnoPorNombreCarrera(carreraNombre);

        //Then
        assertThat(expected.size() == 3).isTrue();
    }

    @Test
    @DisplayName("Test: Buscar alumnos por nombre carrera sin valores")
    void buscarAlumnosPorNombreCarreraSinValores() {
        //Given
        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(
                        com.ibm.academia.apirest.datos.DatosDummy.alumno01(),
                        com.ibm.academia.apirest.datos.DatosDummy.alumno02(),
                        com.ibm.academia.apirest.datos.DatosDummy.alumno03())
        );

        Carrera carrera = carreraRepository.save(com.ibm.academia.apirest.datos.DatosDummy.carrera01());
        personas.forEach(alumno -> ((Alumno)alumno).setCarrera(carrera));
        alumnoRepository.saveAll(personas);

        //When
        String carreraNombre = "Ingenieria en Alimentos";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository) alumnoRepository).buscarAlumnoPorNombreCarrera(carreraNombre);

        //Then
        assertThat(expected.isEmpty()).isTrue();
    }
}
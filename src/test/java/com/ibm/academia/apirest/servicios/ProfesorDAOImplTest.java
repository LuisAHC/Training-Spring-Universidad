package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.repositorios.ProfesorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ProfesorDAOImplTest {
    @MockBean
    private ProfesorRepository profesorRepository;

    @Autowired
    private ProfesorDAO profesorDao;

    @Test
    void buscarProfesorPorNombreCarrera() {
        // When
        profesorDao.buscarProfesorPorNombreCarrera(anyString());

        // Then
        verify(profesorRepository).buscarProfesorPorNombreCarrera(anyString());
    }

    @Test
    void buscarPorNombreYApellido() {
        // When
        profesorDao.buscarPorNombreYApellido(anyString(), anyString());

        // Then
        verify(profesorRepository).buscarPorNombreYApellido(anyString(), anyString());
    }

    @Test
    void buscarPorDni() {
        // When
        profesorDao.buscarPorDni(anyString());

        // Then
        verify(profesorRepository).buscarPorDni(anyString());
    }

    @Test
    void buscarPersonaPorApellido() {
        // When
        profesorDao.buscarPersonaPorApellido(anyString());

        // Then
        verify(profesorRepository).buscarPersonaPorApellido(anyString());
    }
}
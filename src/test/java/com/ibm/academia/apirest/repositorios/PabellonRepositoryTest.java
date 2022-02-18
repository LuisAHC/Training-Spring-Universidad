package com.ibm.academia.apirest.repositorios;

import com.ibm.academia.apirest.modelos.entidades.Pabellon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

@DataJpaTest
class PabellonRepositoryTest {
    @Autowired
    @Qualifier("repositorioPabellones")
    private PabellonRepository pabellonRepository;

    @Test
    void findPabellonsByDireccion_Localidad() {
        // When
        List<Pabellon> expected = (List<Pabellon>) pabellonRepository.findPabellonsByDireccion_Localidad(anyString());
        // Then
        assertThat(expected.isEmpty()).isTrue();
    }

    @Test
    void findPabellonsByNombre() {
        // When
        List<Pabellon> expected = (List<Pabellon>) pabellonRepository.findPabellonsByNombre(anyString());
        // Then
        assertThat(expected.isEmpty()).isTrue();
    }
}
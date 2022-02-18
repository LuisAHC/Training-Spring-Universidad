package com.ibm.academia.apirest.repositorios;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.enumeradores.TipoPizarron;
import com.ibm.academia.apirest.modelos.entidades.Aula;
import com.ibm.academia.apirest.modelos.entidades.Carrera;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

@DataJpaTest
class AulaRepositoryTest {
    @Autowired
    @Qualifier("repositorioAulas")
    private AulaRepository aulaRepository;

    @Test
    @DisplayName("Test: Encontrar aulas por tipo de pizarron")
    void findAulasByTipoPizarron() {
        // Given
        aulaRepository.save(DatosDummy.aula01());
        aulaRepository.save(DatosDummy.aula02());
        aulaRepository.save(DatosDummy.aula03());
        // When
        List<Aula> expected = (List<Aula>) aulaRepository.findAulasByTipoPizarron(TipoPizarron.PIZARRA_BLANCA);
        // Then
        System.out.println(expected.size());
        assertThat(expected.size() == 2).isTrue();
    }

    @Test
    void findAulasByPabellon() {
        // Given
        aulaRepository.save(DatosDummy.aula01());
        aulaRepository.save(DatosDummy.aula02());
        aulaRepository.save(DatosDummy.aula03());
        // When
        List<Aula> expected = (List<Aula>) aulaRepository.findAulasByPabellon(DatosDummy.pabellon01());
        // Then
        System.out.println(expected.size());
        assertThat(expected.size() == 3).isTrue();
    }

    @Test
    void findAulasByPabellonNombre() {
        // Given
        aulaRepository.save(DatosDummy.aula01());
        aulaRepository.save(DatosDummy.aula02());
        aulaRepository.save(DatosDummy.aula03());
        // When
        List<Aula> expected = (List<Aula>) aulaRepository.findAulasByPabellonNombre("Kala");
        // Then
        System.out.println(expected.size());
        assertThat(expected.isEmpty()).isFalse();
    }

    @Test
    void findAulaByNumeroAula() {
        // Given
        aulaRepository.save(DatosDummy.aula01());
        aulaRepository.save(DatosDummy.aula02());
        aulaRepository.save(DatosDummy.aula03());
        // When
        Aula aula = aulaRepository.findAulaByNumeroAula(1);
        // Then
        System.out.println(aula.toString());
        assertThat(aula);
    }
}
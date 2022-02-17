package com.ibm.academia.apirest.servicios;

import static com.ibm.academia.apirest.datos.DatosDummy.*;
import com.ibm.academia.apirest.enumeradores.TipoPizarron;
import com.ibm.academia.apirest.repositorios.AulaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class AulaDAOImplTest {
    @MockBean
    private AulaRepository aulaRepository;

    @Autowired
    private AulaDAO aulaDao;

    @Test
    void findAulasByTipoPizarron() {
        // Given
        Double aleatorio = Math.random();
        TipoPizarron tipoPizarron;
        if (aleatorio<=0.5){
            tipoPizarron = TipoPizarron.PIZARRA_TIZA;
        }else {
            tipoPizarron = TipoPizarron.PIZARRA_BLANCA;
        }

        // When
        aulaDao.findAulasByTipoPizarron(tipoPizarron);

        // Then
        verify(aulaRepository).findAulasByTipoPizarron(tipoPizarron);
    }

    @Test
    void findAulasByPabellon() {
        // When
        aulaDao.findAulasByPabellon(pabellon01());

        // Then
        verify(aulaRepository).findAulasByPabellon(pabellon01());
    }

    @Test
    void findAulasByPabellonNombre() {
        // When
        aulaDao.findAulasByPabellonNombre(anyString());

        // Then
        verify(aulaRepository).findAulasByPabellonNombre(anyString());
    }

    @Test
    void findAulaByNumeroAula() {
        // When
        aulaDao.findAulaByNumeroAula(anyInt());

        // Then
        verify(aulaRepository).findAulaByNumeroAula(anyInt());
    }
}
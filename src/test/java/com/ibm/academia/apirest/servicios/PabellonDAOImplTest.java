package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.repositorios.PabellonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;


@SpringBootTest
class PabellonDAOImplTest {
    @MockBean
    private PabellonRepository pabellonRepository;

    @Autowired
    private PabellonDAO pabellonDao;

    @Test
    void findPabellonsByDireccion_Localidad() {
        // When
        pabellonDao.findPabellonsByDireccion_Localidad(anyString());

        // Then
        verify(pabellonRepository).findPabellonsByDireccion_Localidad(anyString());
    }

    @Test
    void findPabellonsByNombre() {
        // When
        pabellonDao.findPabellonsByNombre(anyString());
        // Then
        verify(pabellonRepository).findPabellonsByNombre(anyString());
    }
}
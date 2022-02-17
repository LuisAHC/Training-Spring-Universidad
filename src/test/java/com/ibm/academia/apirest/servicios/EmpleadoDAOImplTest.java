package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.enumeradores.TipoEmpleado;
import com.ibm.academia.apirest.repositorios.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class EmpleadoDAOImplTest {
    @MockBean
    private EmpleadoRepository empleadoRepository;

    @Autowired
    EmpleadoDAO empleadoDao;

    @Test
    void buscarEmpleadoPorTipoEmpleado() {
        // Given
        Double aleatorio = Math.random();
        TipoEmpleado tipoEmpleado;
        if (aleatorio<=0.5){
            tipoEmpleado = TipoEmpleado.MANTENIMIENTO;
        }else {
            tipoEmpleado = TipoEmpleado.ADMINISTRATIVO;
        }

        // When
        empleadoDao.buscarEmpleadoPorTipoEmpleado(tipoEmpleado);

        // Then
        verify(empleadoRepository).buscarEmpleadoPorTipoEmpleado(tipoEmpleado);
    }
}
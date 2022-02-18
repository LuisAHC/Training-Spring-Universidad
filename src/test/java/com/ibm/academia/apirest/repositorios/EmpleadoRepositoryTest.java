package com.ibm.academia.apirest.repositorios;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.enumeradores.TipoEmpleado;
import com.ibm.academia.apirest.enumeradores.TipoPizarron;
import com.ibm.academia.apirest.modelos.entidades.Aula;
import com.ibm.academia.apirest.modelos.entidades.Empleado;
import com.ibm.academia.apirest.modelos.entidades.Persona;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmpleadoRepositoryTest {
    @Autowired
    @Qualifier("repositorioEmpleados")
    private EmpleadoRepository empleadoRepository;

    @Test
    @DisplayName("Test: Buscar empleado por tipo de empleado")
    void buscarEmpleadoPorTipoEmpleado() {
        // Given
        empleadoRepository.save(DatosDummy.empleado01());
        empleadoRepository.save(DatosDummy.empleado02());

        // When
        List<Persona> expected = (List<Persona>) empleadoRepository.buscarEmpleadoPorTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);

        // Then
        assertThat(expected.size() == 1).isTrue();
    }
}
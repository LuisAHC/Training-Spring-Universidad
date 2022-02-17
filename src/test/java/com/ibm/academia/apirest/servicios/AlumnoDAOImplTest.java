package com.ibm.academia.apirest.servicios;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

import static com.ibm.academia.apirest.datos.DatosDummy.*;
import com.ibm.academia.apirest.repositorios.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AlumnoDAOImplTest {
	@MockBean
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AlumnoDAO alumnoDao;
	
	@Test
	void buscarAlumnosPorNombreCarrera() {
		// When
		alumnoDao.buscarAlumnoPorNombreCarrera(anyString());

		// Then
		verify(alumnoRepository).buscarAlumnoPorNombreCarrera(anyString());
	}
}
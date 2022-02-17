package com.ibm.academia.apirest.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.modelos.entidades.Carrera;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CarreraRepositoryTest {
	@Autowired
	private CarreraRepository carreraRepository;
	
	@BeforeEach
	void setUp() {
		//Given
		carreraRepository.save(DatosDummy.carrera01());
		carreraRepository.save(DatosDummy.carrera02());
		carreraRepository.save(DatosDummy.carrera03());
	}
	
	@AfterEach
	void tearDown()
	{
		carreraRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Buscar carreras por nombre")
	void findCarrerasByNombreContains() {
		//Given
		/*carreraRepository.save(DatosDummy.carrera01());
		carreraRepository.save(DatosDummy.carrera02());
		carreraRepository.save(DatosDummy.carrera03());*/
		
		//When
		List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByNombreContains("Industrial");
		
		//Then 
		assertThat(expected.size() == 1).isTrue();
	}
	
	@Test
	@DisplayName("Test: Buscar carreras por nombre NO case sensitive")
	void findCarrerasByNombreContainsIgnoreCase() {
		//Given
		carreraRepository.save(DatosDummy.carrera01());
		carreraRepository.save(DatosDummy.carrera02());
		carreraRepository.save(DatosDummy.carrera03());
		
		//When
		List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByNombreContainsIgnoreCase("sistemas");
		
		//Then
		assertThat(expected.size() == 2).isTrue();
	}
	
	@Test
	@DisplayName("Test: Buscar carreras mayores a N años")
	void findCarrerasByCantidadAniosAfter() {
		//Given
		/*carreraRepository.save(DatosDummy.carrera01());
		carreraRepository.save(DatosDummy.carrera02());
		carreraRepository.save(DatosDummy.carrera03());*/
		
		//When
		List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByCantidadAniosAfter(4);
		
		//Then
		assertThat(expected.size() == 2).isTrue();
	}
}
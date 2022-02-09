package com.ibm.academia.apirest;

import com.ibm.academia.apirest.modelos.entidades.Carrera;
import com.ibm.academia.apirest.modelos.entidades.Persona;
import com.ibm.academia.apirest.servicios.AlumnoDAO;
import com.ibm.academia.apirest.servicios.CarreraDAO;
import com.ibm.academia.apirest.servicios.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TestAlumnoJPQL implements CommandLineRunner{
    @Autowired
    private CarreraDAO carreraDao;

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDao;

    @Override
    public void run(String... args) throws RuntimeException{
        /*Optional<Carrera> sistemas = carreraDao.buscarPorId(5L);

        Iterable<Persona> alumnos = personaDao.buscarTodos();*/

		/*alumnos.forEach(alumno -> {
			((Alumno)alumno).setCarrera(sistemas.get());
			personaDao.guardar(alumno);
		});*/

		/*alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(sistemas.get()));
		alumnos.forEach(alumno -> personaDao.guardar(alumno));*/

		/*Optional<Persona> alumnoUno = personaDao.buscarPorId(2L);
		Optional<Persona> personaNombreApellido = personaDao.buscarPorNombreYApellido(alumnoUno.get().getNombre(), alumnoUno.get().getApellido());
		System.out.println(personaNombreApellido.toString());

		Optional<Persona> personaDni = personaDao.buscarPorDni(alumnoUno.get().getDni());
        System.out.println(personaDni.toString());

        Iterable<Persona> personasApellido = personaDao.buscarPersonaPorApellido(alumnoUno.get().getApellido());
        personasApellido.forEach(System.out::println);*/

        /*Optional<Carrera> sistemas = carreraDao.buscarPorId(5L);
        Iterable<Persona> alumnosCarrera = ((AlumnoDAO)personaDao).buscarAlumnoPorNombreCarrera(sistemas.get().getNombre());
        alumnosCarrera.forEach(System.out::println);*/
    }
}
package com.ibm.academia.apirest;

import com.ibm.academia.apirest.modelos.entidades.*;
import com.ibm.academia.apirest.servicios.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ibm.academia.apirest.servicios.AlumnoDAO;
import com.ibm.academia.apirest.servicios.CarreraDAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class TestUniversidad implements CommandLineRunner{
    @Autowired
    private CarreraDAO carreraDao;

    @Autowired
    private AlumnoDAO alumnoDao;

    @Override
    public void run(String... args) throws RuntimeException{

        /*Direccion direccionProfesor = new Direccion("Calle algo", "16", "0001", "105", "55444", "Ciudad de México");
        BigDecimal sueldoProfesor = BigDecimal.valueOf(50000.00);
        Persona profesor = new Profesor(null, "242256790", "Israel", "Müller", direccionProfesor, sueldoProfesor, "luisceciliano");
        Persona personaProfesor = profesorDao.guardar(profesor);
        System.out.println(personaProfesor.toString());*/

        //TODO CREATE
        /*Carrera ingenieriaSistemas = new Carrera(null, "sistemas", 60, 5, "luisceciliano");
        Carrera carrera = carreraDao.guardar(ingenieriaSistemas);
        System.out.println(carrera.toString());

        Direccion direccionAlumno = new Direccion("Calle ciega", "75", "0005", "601", "6", "Puebla");
        Persona alumno = new Alumno(null, "123456789", "Pepito", "Perez", direccionAlumno, "luisceciliano");
        Persona personaAlumno = alumnoDao.guardar(alumno);
        System.out.println(personaAlumno.toString());*/


		//TODO READ
		/*List<Persona> alumnos = (List<Persona>)alumnoDao.buscarTodos();
		alumnos.forEach(System.out::println);

        //Carrera carrera = null;
		Carrera carrera = new Carrera(null, "Fisica", 60, 5, "luisceciliano");

		Optional<Carrera> oCarrera = carreraDao.buscarPorId(5L);

		if(oCarrera.isPresent()){
			carrera = oCarrera.get();
			System.out.println(carrera);
		}
		else{
			System.out.println("Carrera no se encuentra");
		}*/

		//TODO UPDATE
        /*Carrera carrera = new Carrera(null, "Fisica", 60, 5, "luisceciliano");

		carrera.setCantidadAnios(3);
		carrera.setCantidadMaterias(10);
		carreraDao.guardar(carrera);

		System.out.println("Carrera Actualizada: " + carreraDao.buscarPorId(1L).orElse(new Carrera()).toString());*/

		//TODO DELETE
		/*carreraDao.eliminarPorId(2L);
		System.out.println("Eliminado");*/

    }
}
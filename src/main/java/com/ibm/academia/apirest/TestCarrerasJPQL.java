package com.ibm.academia.apirest;

import com.ibm.academia.apirest.modelos.entidades.Carrera;
import com.ibm.academia.apirest.servicios.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestCarrerasJPQL implements CommandLineRunner {
    @Autowired
    private CarreraDAO carreraDao;

    @Override
    public void run(String... args) throws RuntimeException {
		/*Carrera ingSistemas = new Carrera(null, "Ingenieria en Sistemas", 60, 5, "luisceciliano");
        Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial", 55, 5, "luisceciliano");
        Carrera ingAlimentos = new Carrera(null, "Ingenieria en Alimentos", 53, 5, "luisceciliano");
        Carrera ingElectronica = new Carrera(null, "Ingenieria Electronica", 45, 5, "luisceciliano");
        Carrera licSistemas = new Carrera(null, "Licenciatura en Sistemas", 40, 4, "luisceciliano");
        Carrera licTurismo = new Carrera(null, "Licenciatura en Turismo", 42, 4, "luisceciliano");
        Carrera licYoga = new Carrera(null, "Licenciatura en Yoga", 25, 3, "luisceciliano");
        Carrera licRecursos = new Carrera(null, "Licenciatura en Recursos Humanos - RRHH", 33, 3, "luisceciliano");

        carreraDao.guardar(ingSistemas);
        carreraDao.guardar(ingIndustrial);
        carreraDao.guardar(ingAlimentos);
        carreraDao.guardar(ingElectronica);
        carreraDao.guardar(licSistemas);
        carreraDao.guardar(licTurismo);
        carreraDao.guardar(licYoga);
        carreraDao.guardar(licRecursos);*/

        /*List<Carrera> carreras = (List<Carrera>) carreraDao.findCarrerasByNombreContains("Sistemas");
        carreras.forEach(System.out::println);*/

		/*List<Carrera> carrerasIgnoreCaseUno = (List<Carrera>) carreraDao.findCarrerasByNombreContainsIgnoreCase("SISTEMAS");
		carrerasIgnoreCaseUno.forEach(System.out::println);*/

		/*List<Carrera> carrerasIgnoreCaseUno = (List<Carrera>) carreraDao.findCarrerasByCantidadAniosAfter(3);
		carrerasIgnoreCaseUno.forEach(System.out::println);*/
    }
}

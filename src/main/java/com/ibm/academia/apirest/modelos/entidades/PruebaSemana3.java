package com.ibm.academia.apirest.modelos.entidades;

import com.ibm.academia.apirest.enumeradores.TipoEmpleado;
import com.ibm.academia.apirest.servicios.CarreraDAO;
import com.ibm.academia.apirest.servicios.EmpleadoDAO;
import com.ibm.academia.apirest.servicios.PersonaDAO;
import com.ibm.academia.apirest.servicios.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class PruebaSemana3 implements CommandLineRunner {
    @Autowired
    private CarreraDAO carreraDao;

    @Autowired
    //@Qualifier("profesorDAOImpl")
    @Qualifier("empleadoDAOImpl")
    private PersonaDAO personaDao;

    @Autowired
    private ProfesorDAO profesorDao;

    @Autowired
    private EmpleadoDAO empleadoDao;

    @Override
    public void run(String... args) throws RuntimeException {

        // Pruebas a ProfesorRepository y ProfesorDAO
        /*Direccion direccionProfesor = new Direccion("Calle algo", "16", "0001", "105", "55444", "Coyoacan");
        BigDecimal sueldoProfesor = BigDecimal.valueOf(50000.00);
        Persona profesor = new Profesor(null, "242256790", "Israel", "Müller", direccionProfesor, sueldoProfesor, "luisceciliano");
        Persona personaProfesor = profesorDao.guardar(profesor);
        System.out.println(personaProfesor.toString());

        Direccion direccionProfesor2 = new Direccion("Calle 3", "122", "0", "0", "57424", "Iztapalapa");
        BigDecimal sueldoProfesor2 = BigDecimal.valueOf(16000.00);
        Persona profesor2 = new Profesor(null, "122566790", "Kevin", "Perez", direccionProfesor2, sueldoProfesor2, "luisceciliano");
        Persona personaProfesor2 = profesorDao.guardar(profesor2);
        System.out.println(personaProfesor2.toString());*/

        /*Optional<Carrera> licenciaturaSistemas = carreraDao.buscarPorId(5L);
        Optional<Carrera> licenciaturaTurismo = carreraDao.buscarPorId(6L);

        Set<Carrera> carreras = new HashSet<Carrera> ();
        carreras.add(licenciaturaSistemas.get());
        carreras.add(licenciaturaTurismo.get());

        Optional<Persona> profesor1 = personaDao.buscarPorId(2L);

        ((Profesor)profesor1.get()).setCarreras(carreras);
        profesorDao.guardar(profesor1.get());


        List<Persona> profesores = (List<Persona>) profesorDao.buscarProfesorPorNombreCarrera("Licenciatura en Sistemas");
        profesores.forEach(System.out::println);*/

        // pruebas a EmpleadoRepository y EmpleadoDAO
        /*Direccion direccionEmpleado = new Direccion("Victoria", "11", "0002", "002", "22222", "Monaco");
        BigDecimal sueldoEmpleado = BigDecimal.valueOf(5000.00);
        TipoEmpleado tipoEmpleado = TipoEmpleado.MANTENIMIENTO;
        Persona empleado = new Empleado(null, "222222222", "Sergio", "Perez", direccionEmpleado, sueldoEmpleado, tipoEmpleado, "luisceciliano");
        Persona personaEmpleado = empleadoDao.guardar((Empleado) empleado);
        System.out.println(personaEmpleado.toString());

        List<Persona> empleados = (List<Persona>) empleadoDao.buscarEmpleadoPorTipoEmpleado(TipoEmpleado.MANTENIMIENTO);
        empleados.forEach(System.out::println);*/

        // pruebas a CarreraRepository
        /*List<Carrera> carrerasPorNombreYApellidoProfesor = (List<Carrera>) carreraDao.buscarCarrerasPorProfesorNombreYApellido("Israel", "Müller");
        carrerasPorNombreYApellidoProfesor.forEach(System.out::println);*/

    }
}

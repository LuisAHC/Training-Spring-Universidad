package com.ibm.academia.apirest.controladores;

import com.ibm.academia.apirest.excepciones.NotFoundException;
import com.ibm.academia.apirest.modelos.entidades.Persona;
import com.ibm.academia.apirest.servicios.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ProfesorController {
    @Qualifier("profesorDAOImpl")
    @Autowired
    private ProfesorDAO profesorDao;

    @GetMapping("/profesor/nombreCarrera/{nombreCarrera}")
    public ResponseEntity<?> obtenerProfesorPorNombreCarrera(@PathVariable String nombreCarrera) {
        List<Persona> lProfesor = (List<Persona>) profesorDao.buscarProfesorPorNombreCarrera(nombreCarrera);

        if(lProfesor.isEmpty())
            throw new NotFoundException(String.format("No existen profesores en la carrera %s", nombreCarrera));

        return new ResponseEntity<List<Persona>>(lProfesor, HttpStatus.OK);
    }

    // C
    @PostMapping("/profesor")
    public ResponseEntity<?> crearPersona(@RequestBody Persona persona) {
        Persona profesorGuardado = profesorDao.guardar(persona);
        return new ResponseEntity<Persona>(profesorGuardado, HttpStatus.CREATED);
    }

    // R
    @GetMapping("/profesor/lista")
    public ResponseEntity<?> obtenerTodos() {
        List<Persona> profesores = (List<Persona>) profesorDao.buscarTodos();

        if(profesores.isEmpty())
            throw new NotFoundException("No existen profesores");

        return new ResponseEntity<List<Persona>>(profesores, HttpStatus.OK);
    }

    // U
    @GetMapping("/profesor/actualizar/{profesorId}")
    public ResponseEntity<?> actualizarProfesor(@RequestBody Long profesorId, @RequestBody Persona profesor) {
        Optional<Persona> oProfesor = profesorDao.buscarPorId(profesorId);

        if(!oProfesor.isPresent())
            throw new NotFoundException(String.format("El profesor con ID %s no existe", profesorId));

        Persona profesorActualizado = null;
        oProfesor.get().setNombre(profesor.getNombre());
        oProfesor.get().setApellido(profesor.getApellido());
        oProfesor.get().setDireccion(profesor.getDireccion());
        profesorActualizado = profesorDao.guardar(oProfesor.get());

        return new ResponseEntity<Persona>(profesorActualizado, HttpStatus.OK);
    }

    // D
    @DeleteMapping("/profesor/eliminar/profesorId/{profesorId}")
    public ResponseEntity<?> eliminarProfesor(@PathVariable Long profesorId) {
        Optional<Persona> oProfesor = profesorDao.buscarPorId(profesorId);

        if(!oProfesor.isPresent())
            throw new NotFoundException(String.format("El profesor con ID %d no existe", profesorId));

        profesorDao.eliminarPorId(oProfesor.get().getId());
        return new ResponseEntity<String>("Profesor ID: " + profesorId + " se elimino satisfactoriamente",  HttpStatus.NO_CONTENT);
    }
}

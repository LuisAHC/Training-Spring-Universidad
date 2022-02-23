package com.ibm.academia.apirest.controladores;

import com.ibm.academia.apirest.excepciones.NotFoundException;
import com.ibm.academia.apirest.modelos.entidades.Persona;
import com.ibm.academia.apirest.servicios.AlumnoDAO;
import com.ibm.academia.apirest.servicios.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restapi")
public class PersonaController {
    @Qualifier("empleadoDAOImpl")
    @Autowired
    private PersonaDAO personaDao;

    /**
     * Endpoint para obtener personar por DNI
     * @param personaDni El DNI de la persona a buscar
     * @return Retoruna un objeto de tipo Persona
     */
    @GetMapping("/persona/dni/{personaDni}")
    public ResponseEntity<?> obtenerPersonaPorDni(@PathVariable String personaDni) {
        Optional<Persona> oPersona = personaDao.buscarPorDni(personaDni);

        if(!oPersona.isPresent())
            throw new NotFoundException(String.format("Persona con dni %s no existe", personaDni));

        return new ResponseEntity<Persona>(oPersona.get(), HttpStatus.OK);
    }

    /**
     * Endpoint para buscar personas por apellido
     * @param personaApellido El apellido de las personas a buscar
     * @return Retorna una lista de Personas cuyo apellido concuerde con el establecido
     */
    @GetMapping("/persona/apellido/{personaApellido}")
    public ResponseEntity<?> obtenerPersonaPorApellido(@PathVariable String personaApellido) {
        List<Persona> oPersona = (List<Persona>) personaDao.buscarPersonaPorApellido(personaApellido);

        if(oPersona.isEmpty())
            throw new NotFoundException(String.format("Persona con apellido %s no existe", personaApellido));

        return new ResponseEntity<>(oPersona, HttpStatus.OK);
    }

    // C
    @PostMapping("/persona")
    public ResponseEntity<?> crearPersona(@RequestBody Persona persona) {
        Persona personaGuardada = personaDao.guardar(persona);
        return new ResponseEntity<Persona>(personaGuardada, HttpStatus.CREATED);
    }

    // R
    @GetMapping("/persona/lista")
    public ResponseEntity<?> obtenerTodos() {
        List<Persona> personas = (List<Persona>) personaDao.buscarTodos();

        if(personas.isEmpty())
            throw new NotFoundException("No existen personas");

        return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
    }

    // U

    // D
    @DeleteMapping("/persona/eliminar/personaId/{personaId}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable Long personaId) {
        Optional<Persona> oPersona = personaDao.buscarPorId(personaId);

        if(!oPersona.isPresent())
            throw new NotFoundException(String.format("La persona con ID %d no existe", personaId));

        personaDao.eliminarPorId(oPersona.get().getId());
        return new ResponseEntity<String>("Persona ID: " + personaId + " se elimino satisfactoriamente",  HttpStatus.NO_CONTENT);
    }
}

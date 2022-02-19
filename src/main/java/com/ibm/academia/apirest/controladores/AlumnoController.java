package com.ibm.academia.apirest.controladores;

import java.util.List;
import java.util.Optional;

import com.ibm.academia.apirest.modelos.entidades.Carrera;
import com.ibm.academia.apirest.modelos.entidades.Persona;
import com.ibm.academia.apirest.servicios.AlumnoDAO;
import com.ibm.academia.apirest.servicios.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.excepciones.NotFoundException;

@RestController
@RequestMapping("/restapi")
public class AlumnoController 
{
	//private final static Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	
	@Autowired
	@Qualifier("alumnoDAOImpl")
	private PersonaDAO alumnoDao;
	
	@PostMapping("/alumno")
	public ResponseEntity<?> crearAlumno(@RequestBody Persona alumno)
	{	
		Persona alumnoGuardado = alumnoDao.guardar(alumno);
		return new ResponseEntity<Persona>(alumnoGuardado, HttpStatus.CREATED);
	}
	
	@GetMapping("/alumnos/lista")
	public ResponseEntity<?> obtenerTodos()
	{
		List<Persona> alumnos = (List<Persona>) alumnoDao.buscarTodos();
		
		if(alumnos.isEmpty())
			throw new NotFoundException("No existen alumnos");
		
		return new ResponseEntity<List<Persona>>(alumnos, HttpStatus.OK);
	}
	
	@GetMapping("/alumno/{alumnoId}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Long alumnoId)
    {
        Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);
        
        if(!oAlumno.isPresent()) 
            throw new NotFoundException(String.format("Alumno con id %d no existe", alumnoId));
        
        return new ResponseEntity<Persona>(oAlumno.get(), HttpStatus.OK);
    }
	
	@DeleteMapping("/alumno/eliminar/alumnoId/{alumnoId}")
	public ResponseEntity<?> eliminarAlumno(@PathVariable Long alumnoId)
	{
		Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);
		
		if(!oAlumno.isPresent())
			throw new NotFoundException(String.format("El alumno con ID %d no existe", alumnoId));
		
		alumnoDao.eliminarPorId(oAlumno.get().getId()); 
		return new ResponseEntity<String>("Alumno ID: " + alumnoId + " se elimino satisfactoriamente",  HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/alumno/actualizar/alumnoId/{alumnoId}")
	public ResponseEntity<?> actualizarAlumno(@PathVariable Persona alumnoId, @RequestBody Persona alumno)
	{
		Persona alumnoActualizado = ((AlumnoDAO)alumnoDao).actualizar(alumnoId, alumno);
		return new ResponseEntity<Persona>(alumnoActualizado, HttpStatus.OK);
	}
	
	@PutMapping("/alumno/asociar-carrera")
	public ResponseEntity<?> asignarCarreraAlumno(@RequestParam Carrera carreraId, @RequestParam(name = "alumno_id") Persona alumnoId)
	{
		Persona alumno = ((AlumnoDAO)alumnoDao).asociarCarreraAlumno(alumnoId, carreraId);
		return new ResponseEntity<Persona>(alumno, HttpStatus.OK);
	}
}
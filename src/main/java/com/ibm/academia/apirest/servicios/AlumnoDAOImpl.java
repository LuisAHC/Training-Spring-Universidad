package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.excepciones.NotFoundException;
import com.ibm.academia.apirest.modelos.entidades.Alumno;
import com.ibm.academia.apirest.modelos.entidades.Carrera;
import com.ibm.academia.apirest.modelos.entidades.Persona;
import com.ibm.academia.apirest.repositorios.AlumnoRepository;
import com.ibm.academia.apirest.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO{
    @Autowired
    private CarreraDAO carreraDao;

    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre){
        return ((AlumnoRepository)repository).buscarAlumnoPorNombreCarrera(nombre);
    }

    @Override
    @Transactional
    public Persona actualizar(Long alumnoId, Persona alumno) {
        Optional<Persona> oAlumno = repository.findById(alumnoId);

        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("El alumno con ID %d no existe", alumnoId));

        Persona alumnoActualizado = null;
        oAlumno.get().setNombre(alumno.getNombre());
        oAlumno.get().setApellido(alumno.getApellido());
        oAlumno.get().setDireccion(alumno.getDireccion());
        alumnoActualizado = repository.save(oAlumno.get());

        return alumnoActualizado;
    }

    @Override
    @Transactional
    public Persona asociarCarreraAlumno(Long carreraId, Long alumnoId) {
        Optional<Persona> oAlumno = repository.findById(alumnoId);
        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("El alumno con ID %d no existe", alumnoId));

        Optional<Carrera> oCarrera = carreraDao.buscarPorId(carreraId);
        if(!oCarrera.isPresent())
            throw new NotFoundException(String.format("La carrera con ID %d no existe", carreraId));

        ((Alumno)oAlumno.get()).setCarrera(oCarrera.get());
        return repository.save(oAlumno.get());
    }
}

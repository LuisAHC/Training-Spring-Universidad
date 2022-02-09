package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.modelos.entidades.Persona;
import com.ibm.academia.apirest.repositorios.PersonaRepository;
import com.ibm.academia.apirest.repositorios.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO{
    @Autowired
    public ProfesorDAOImpl(@Qualifier("repositorioProfesores") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarProfesorPorNombreCarrera(String carrera) {
        return ((ProfesorRepository) repository).buscarProfesorPorNombreCarrera(carrera);
    }
}

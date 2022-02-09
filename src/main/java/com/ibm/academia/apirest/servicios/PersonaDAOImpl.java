package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.modelos.entidades.Persona;
import com.ibm.academia.apirest.repositorios.PersonaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO{
    public PersonaDAOImpl(PersonaRepository repository)
    {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido)
    {
        return repository.buscarPorNombreYApellido(nombre, apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorDni(String dni)
    {
        return repository.buscarPorDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarPersonaPorApellido(String apellido)
    {
        return repository.buscarPersonaPorApellido(apellido);
    }
}

package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.modelos.entidades.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona>{
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    public Optional<Persona> buscarPorDni(String dni);
    public Iterable<Persona> buscarPersonaPorApellido(String apellido);
}

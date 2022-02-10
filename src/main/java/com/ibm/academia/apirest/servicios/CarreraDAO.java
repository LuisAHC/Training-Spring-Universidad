package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.modelos.entidades.Carrera;

public interface CarreraDAO extends GenericoDAO<Carrera>{
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
    public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
    public Carrera actualizar(Carrera carreraEncontrada, Carrera carrera);
}

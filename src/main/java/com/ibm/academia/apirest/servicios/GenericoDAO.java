package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.modelos.entidades.Persona;

import java.util.Optional;

public interface GenericoDAO<E> {
    public Optional<E> buscarPorId(Long id);
    public E guardar(E entidad);
    public Iterable<E> buscarTodos();
    public void eliminarPorId(Long id);
    public E actualizar(Long id, E entidad);
}

package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.excepciones.NotFoundException;
import com.ibm.academia.apirest.modelos.entidades.Carrera;
import com.ibm.academia.apirest.repositorios.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CarreraDAOImpl extends GenericoDAOImpl<Carrera, CarreraRepository> implements CarreraDAO{
    @Autowired
    public CarreraDAOImpl(CarreraRepository repository)
    {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre) {
        return repository.findCarrerasByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {

        return repository.findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios) {
        return repository.findCarrerasByCantidadAniosAfter(cantidadAnios);
    }

    @Override
    public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido) {
        return repository.buscarCarrerasPorProfesorNombreYApellido(nombre, apellido);
    }

    @Override
    @Transactional
    public Carrera actualizar(Long carreraId, Carrera carrera) {
        Optional<Carrera> oCarrera = repository.findById(carreraId);

        if(!oCarrera.isPresent())
            throw new NotFoundException(String.format("La carrera con ID %d no existe", carreraId));

        Carrera carreraActualizada = null;
        oCarrera.get().setCantidadAnios(carrera.getCantidadAnios());
        oCarrera.get().setCantidadMaterias(carrera.getCantidadMaterias());
        carreraActualizada = repository.save(oCarrera.get());
        return carreraActualizada;
    }
}

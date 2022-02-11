package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.modelos.entidades.Pabellon;
import com.ibm.academia.apirest.repositorios.PabellonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PabellonDAOImpl extends GenericoDAOImpl<Pabellon, PabellonRepository> implements PabellonDAO{
    @Autowired
    public PabellonDAOImpl(PabellonRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Pabellon> findPabellonsByDireccion_Localidad(String localidad) {
        return repository.findPabellonsByDireccion_Localidad(localidad);
    }

    @Override
    public Iterable<Pabellon> findPabellonsByNombre(String nombre) {
        return repository.findPabellonsByNombre(nombre);
    }
}

package com.ibm.academia.apirest.repositorios;

import com.ibm.academia.apirest.modelos.entidades.Pabellon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PabellonRepository extends CrudRepository<Pabellon, Long>{
    public Iterable<Pabellon> findPabellonsByDireccion_Localidad(String localidad);
    public Iterable<Pabellon> findPabellonsByNombre(String nombre);
}

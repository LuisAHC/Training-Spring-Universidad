package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.modelos.entidades.Pabellon;

public interface PabellonDAO extends GenericoDAO<Pabellon>{
    public Iterable<Pabellon> findPabellonsByDireccion_Localidad(String localidad);
    public Iterable<Pabellon> findPabellonsByNombre(String nombre);
}

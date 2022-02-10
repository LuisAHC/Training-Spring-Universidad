package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.enumeradores.TipoEmpleado;
import com.ibm.academia.apirest.modelos.entidades.Empleado;
import com.ibm.academia.apirest.modelos.entidades.Persona;
import com.ibm.academia.apirest.repositorios.EmpleadoRepository;
import com.ibm.academia.apirest.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO{
    @Autowired
    public EmpleadoDAOImpl(@Qualifier("repositorioEmpleados") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarEmpleadoPorTipoEmpleado(TipoEmpleado tipoEmpleado) {
        return ((EmpleadoRepository)repository).buscarEmpleadoPorTipoEmpleado(tipoEmpleado);
    }
}

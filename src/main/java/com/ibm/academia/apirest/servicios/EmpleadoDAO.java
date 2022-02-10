package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.enumeradores.TipoEmpleado;
import com.ibm.academia.apirest.modelos.entidades.Persona;

public interface EmpleadoDAO extends PersonaDAO{
    public Iterable<Persona> buscarEmpleadoPorTipoEmpleado(TipoEmpleado tipoEmpleado);
}

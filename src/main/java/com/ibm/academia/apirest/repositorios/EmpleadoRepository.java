package com.ibm.academia.apirest.repositorios;

import com.ibm.academia.apirest.enumeradores.TipoEmpleado;
import com.ibm.academia.apirest.modelos.entidades.Empleado;
import com.ibm.academia.apirest.modelos.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("repositorioEmpleados")
public interface EmpleadoRepository extends PersonaRepository {
    @Query("select e from Empleado e where e.tipoEmpleado = ?1")
    public Iterable<Persona> buscarEmpleadoPorTipoEmpleado(TipoEmpleado tipoEmpleado);
}

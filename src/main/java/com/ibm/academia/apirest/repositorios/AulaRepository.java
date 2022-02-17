package com.ibm.academia.apirest.repositorios;

import com.ibm.academia.apirest.enumeradores.TipoPizarron;
import com.ibm.academia.apirest.modelos.entidades.Aula;
import com.ibm.academia.apirest.modelos.entidades.Pabellon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("repositorioAulas")
public interface AulaRepository extends CrudRepository<Aula, Long> {
    public Iterable<Aula> findAulasByTipoPizarron(TipoPizarron tipoPizarron);
    public Iterable<Aula> findAulasByPabellon(Pabellon pabellon);

    @Query("select a from Aula a join a.pabellon p where p.nombre = ?1")
    public Iterable<Aula> findAulasByPabellonNombre(String nombrePabellon);

    public Aula findAulaByNumeroAula(Integer numeroAula);
}

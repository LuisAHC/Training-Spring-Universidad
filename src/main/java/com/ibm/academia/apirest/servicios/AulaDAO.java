package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.enumeradores.TipoPizarron;
import com.ibm.academia.apirest.modelos.entidades.Aula;
import com.ibm.academia.apirest.modelos.entidades.Pabellon;

public interface AulaDAO extends GenericoDAO<Aula>{
    public Iterable<Aula> findAulasByTipoPizarron(TipoPizarron tipoPizarron);
    public Iterable<Aula> findAulasByPabellon(Pabellon pabellon);
    public Iterable<Aula> findAulasByPabellonNombre(String nombrePabellon);
    public Aula findAulaByNumeroAula(String numeroAula);
}

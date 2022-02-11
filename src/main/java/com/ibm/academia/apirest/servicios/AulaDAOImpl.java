package com.ibm.academia.apirest.servicios;

import com.ibm.academia.apirest.enumeradores.TipoPizarron;
import com.ibm.academia.apirest.modelos.entidades.Aula;
import com.ibm.academia.apirest.modelos.entidades.Pabellon;
import com.ibm.academia.apirest.repositorios.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AulaDAOImpl extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO{
    @Autowired
    public AulaDAOImpl(AulaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Aula> findAulasByTipoPizarron(TipoPizarron tipoPizarron) {
        return repository.findAulasByTipoPizarron(tipoPizarron);
    }

    @Override
    public Iterable<Aula> findAulasByPabellon(Pabellon pabellon) {
        return repository.findAulasByPabellon(pabellon);
    }

    @Override
    public Iterable<Aula> findAulasByPabellonNombre(String nombrePabellon) {
        return repository.findAulasByPabellonNombre(nombrePabellon);
    }

    @Override
    public Aula findAulaByNumeroAula(String numeroAula) {
        return repository.findAulaByNumeroAula(numeroAula);
    }
}

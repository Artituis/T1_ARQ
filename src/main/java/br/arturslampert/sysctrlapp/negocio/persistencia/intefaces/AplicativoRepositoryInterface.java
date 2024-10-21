package br.arturslampert.sysctrlapp.negocio.persistencia.intefaces;

import br.arturslampert.sysctrlapp.negocio.entidades.AplicativoEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AplicativoRepositoryInterface {
    List<AplicativoEntity> findAll();
    Optional<AplicativoEntity> findById(Long id);
    AplicativoEntity save(AplicativoEntity aplicativoEntity);
    void deleteById(Long id);
}

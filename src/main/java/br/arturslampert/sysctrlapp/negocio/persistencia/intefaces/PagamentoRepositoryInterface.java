package br.arturslampert.sysctrlapp.negocio.persistencia.intefaces;

import br.arturslampert.sysctrlapp.negocio.entidades.PagamentoEntity;

import java.util.List;
import java.util.Optional;

public interface PagamentoRepositoryInterface {
    List<PagamentoEntity> findAll();

    Optional<PagamentoEntity> findById(Long id);

    Long save(PagamentoEntity pagamentoEntity);

    void deleteById(Long id);
}

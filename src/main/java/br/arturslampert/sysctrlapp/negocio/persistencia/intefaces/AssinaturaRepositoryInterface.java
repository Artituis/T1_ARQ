package br.arturslampert.sysctrlapp.negocio.persistencia.intefaces;

import br.arturslampert.sysctrlapp.negocio.entidades.AssinaturaEntity;

import java.util.List;
import java.util.Optional;

public interface AssinaturaRepositoryInterface {
    List<AssinaturaEntity> findAll();
    Optional<AssinaturaEntity> findById(Long id);
    AssinaturaEntity save(AssinaturaEntity assinaturaEntity);
    void deleteById(Long id);
}

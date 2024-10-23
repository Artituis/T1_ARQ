package br.arturslampert.sysctrlapp.negocio.persistencia.intefaces;

import br.arturslampert.sysctrlapp.negocio.entidades.AplicativoEntity;
import br.arturslampert.sysctrlapp.negocio.entidades.AssinaturaEntity;
import br.arturslampert.sysctrlapp.negocio.entidades.ClienteEntity;

import java.util.List;
import java.util.Optional;

public interface AssinaturaRepositoryInterface {
    List<AssinaturaEntity> findAll();
    AssinaturaEntity findById(Long id);
    AssinaturaEntity save(AssinaturaEntity assinaturaEntity);
    void deleteById(Long id);
    List<AssinaturaEntity> findByCliente(ClienteEntity clienteEntity);
    List<AssinaturaEntity> findByAplicativo(AplicativoEntity aplicativoEntity);
}

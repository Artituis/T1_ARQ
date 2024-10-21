package br.arturslampert.sysctrlapp.negocio.persistencia.intefaces;

import br.arturslampert.sysctrlapp.negocio.entidades.ClienteEntity;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryInterface {
    List<ClienteEntity> findAll();

    Optional<ClienteEntity> findById(Long id);

    ClienteEntity save(ClienteEntity clienteEntity);

    void deleteById(Long id);
}

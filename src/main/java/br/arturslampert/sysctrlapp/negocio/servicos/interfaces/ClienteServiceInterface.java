package br.arturslampert.sysctrlapp.negocio.servicos.interfaces;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.ClienteJPAEntity;
import br.arturslampert.sysctrlapp.negocio.entidades.ClienteEntity;

import java.util.List;

public interface ClienteServiceInterface {
    List<ClienteEntity> get();

    ClienteEntity getById(Long id);

    Long create(ClienteEntity clienteJPAEntity);

    void delete(Long clienteEntity);

}

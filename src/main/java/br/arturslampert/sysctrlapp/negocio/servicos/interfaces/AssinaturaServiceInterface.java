package br.arturslampert.sysctrlapp.negocio.servicos.interfaces;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.AssinaturaJPAEntity;
import br.arturslampert.sysctrlapp.aplicacao.dtos.AssinaturaDTO;
import br.arturslampert.sysctrlapp.negocio.entidades.AplicativoEntity;
import br.arturslampert.sysctrlapp.negocio.entidades.AssinaturaEntity;
import br.arturslampert.sysctrlapp.negocio.entidades.ClienteEntity;

import java.util.List;
import java.util.Optional;

public interface AssinaturaServiceInterface {
    List<AssinaturaEntity> get();
    AssinaturaEntity getById(Long id);
    Long create(AssinaturaDTO assinaturaEntity);
    void delete(Long assinaturaEntity);

    List<AssinaturaEntity> getByTipo(String tipo);
    Boolean assinaturaValida(Long codass);
    List<AssinaturaEntity> getAssCli(Long codcli);
    List<AssinaturaEntity> getAssApp(Long codapp);
}

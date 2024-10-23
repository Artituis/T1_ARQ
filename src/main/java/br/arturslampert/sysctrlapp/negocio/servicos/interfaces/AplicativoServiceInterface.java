package br.arturslampert.sysctrlapp.negocio.servicos.interfaces;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.AplicativoJPAEntity;
import br.arturslampert.sysctrlapp.negocio.entidades.AplicativoEntity;
import br.arturslampert.sysctrlapp.negocio.entidades.AssinaturaEntity;

import java.util.List;

public interface AplicativoServiceInterface {

    List<AplicativoEntity> get();

    AplicativoEntity getById(Long id);

    Long create(AplicativoEntity aplicativoEntity);

    AplicativoEntity atualizaCusto(Long idAplicativo, Float custo);

    void delete(Long aplicativoEntity);


}

package br.arturslampert.sysctrlapp.negocio.servicos.interfaces;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.PagamentoJPAEntity;
import br.arturslampert.sysctrlapp.aplicacao.dtos.PagamentoDTO;
import br.arturslampert.sysctrlapp.negocio.entidades.PagamentoEntity;
import br.arturslampert.sysctrlapp.negocio.exeptions.PagamentoAssinaturaMuitoBaixa;

import java.util.List;

public interface PagamentoServiceInterface {
    List<PagamentoEntity> get();
    PagamentoEntity getById(Long id);
    PagamentoEntity create(PagamentoDTO pagamentoDTO) throws PagamentoAssinaturaMuitoBaixa;
    void delete(Long pagamentoEntity);
}

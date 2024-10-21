package br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.PagamentoJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PagamentoJPARepository extends JpaRepository<PagamentoJPAEntity, Long> {
}
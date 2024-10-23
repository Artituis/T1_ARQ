package br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.AplicativoJPAEntity;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.AssinaturaJPAEntity;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.ClienteJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AssinaturaJPARepository extends JpaRepository<AssinaturaJPAEntity, Long> {
    List<AssinaturaJPAEntity> findByAplicativo(AplicativoJPAEntity aplicativo);
    List<AssinaturaJPAEntity> findByCliente(ClienteJPAEntity cliente);
}
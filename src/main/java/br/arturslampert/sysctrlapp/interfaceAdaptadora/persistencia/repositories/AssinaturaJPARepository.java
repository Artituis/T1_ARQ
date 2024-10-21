package br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.AssinaturaJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AssinaturaJPARepository extends JpaRepository<AssinaturaJPAEntity, Long> {
}
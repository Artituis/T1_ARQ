package br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories;


import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.AplicativoJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AplicativoJPARepository extends JpaRepository<AplicativoJPAEntity, Long> {
}

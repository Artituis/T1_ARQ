package br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.ClienteJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteJPARepository extends JpaRepository<ClienteJPAEntity, Long> {
}

package br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.UsuarioJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioJPARepository extends JpaRepository<UsuarioJPAEntity, String> {
}

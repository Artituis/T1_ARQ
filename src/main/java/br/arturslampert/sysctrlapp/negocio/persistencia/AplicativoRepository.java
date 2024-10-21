package br.arturslampert.sysctrlapp.negocio.persistencia;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.AplicativoJPAEntity;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories.AplicativoJPARepository;
import br.arturslampert.sysctrlapp.negocio.entidades.AplicativoEntity;
import br.arturslampert.sysctrlapp.negocio.persistencia.intefaces.AplicativoRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class AplicativoRepository implements AplicativoRepositoryInterface {

    private final AplicativoJPARepository aplicativoJPARepository;

    @Override
    public List<AplicativoEntity> findAll() {
        return aplicativoJPARepository.findAll().stream().map(AplicativoJPAEntity::toAplicativoEntity).toList();
    }

    @Override
    public Optional<AplicativoEntity> findById(Long id) {
        return aplicativoJPARepository.findById(id).map(AplicativoJPAEntity::toAplicativoEntity);
    }

    @Override
    public AplicativoEntity save(AplicativoEntity aplicativoEntity) {
        return aplicativoJPARepository
                .save(AplicativoJPAEntity.fromAplicativoEntity(aplicativoEntity))
                .toAplicativoEntity();
    }

    @Override
    public void deleteById(Long id) {
        aplicativoJPARepository.deleteById(id);
    }
}

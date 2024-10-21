package br.arturslampert.sysctrlapp.negocio.persistencia;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.AssinaturaJPAEntity;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories.AssinaturaJPARepository;
import br.arturslampert.sysctrlapp.negocio.entidades.AssinaturaEntity;
import br.arturslampert.sysctrlapp.negocio.persistencia.intefaces.AssinaturaRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AssinaturaRepository implements AssinaturaRepositoryInterface {
    private final AssinaturaJPARepository assinaturaJPARepository;
    public List<AssinaturaEntity> findAll() {
        return assinaturaJPARepository.findAll().stream()
                .map(AssinaturaJPAEntity::toAssinaturaEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AssinaturaEntity> findById(Long id) {
        return assinaturaJPARepository.findById(id)
                .map(AssinaturaJPAEntity::toAssinaturaEntity);
    }

    @Override
    public AssinaturaEntity save(AssinaturaEntity assinaturaEntity) {
        return assinaturaJPARepository.save(AssinaturaJPAEntity.fromAssinaturaEntity(assinaturaEntity)).toAssinaturaEntity();
    }

    @Override
    public void deleteById(Long id) {
        assinaturaJPARepository.deleteById(id);
    }
}

package br.arturslampert.sysctrlapp.negocio.persistencia;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.PagamentoJPAEntity;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories.PagamentoJPARepository;
import br.arturslampert.sysctrlapp.negocio.entidades.PagamentoEntity;
import br.arturslampert.sysctrlapp.negocio.persistencia.intefaces.PagamentoRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PagamentoRepository implements PagamentoRepositoryInterface {
    private final PagamentoJPARepository pagamentoJPARepository;
    public List<PagamentoEntity> findAll() {
        return pagamentoJPARepository.findAll().stream()
                .map(PagamentoJPAEntity::toPagamentoEntity)
                .collect(Collectors.toList());
    }

    public Optional<PagamentoEntity> findById(Long id) {
        return pagamentoJPARepository.findById(id)
                .map(PagamentoJPAEntity::toPagamentoEntity);
    }

    public PagamentoEntity save(PagamentoEntity pagamentoEntity) {
        return pagamentoJPARepository.save(PagamentoJPAEntity.fromPagamentoEntity(pagamentoEntity)).toPagamentoEntity();
    }

    public void deleteById(Long id) {
        pagamentoJPARepository.deleteById(id);
    }
}

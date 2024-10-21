package br.arturslampert.sysctrlapp.negocio.servicos;

import br.arturslampert.sysctrlapp.negocio.entidades.AplicativoEntity;
import br.arturslampert.sysctrlapp.negocio.persistencia.intefaces.AplicativoRepositoryInterface;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.AplicativoServiceInterface;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AplicativoService implements AplicativoServiceInterface {

    private final AplicativoRepositoryInterface aplicativoRepository;

    @Override
    public List<AplicativoEntity> get() {
        return aplicativoRepository.findAll();
    }

    @Override
    public AplicativoEntity getById(Long id) {
        return aplicativoRepository.findById(id).orElse(null);
    }

    @Override
    public Long create(AplicativoEntity aplicativoEntity) {
        return aplicativoRepository.save(aplicativoEntity).getCodigo();
    }

    @Override
    public AplicativoEntity atualizaCusto(Long idAplicativo, Float custo) {
        AplicativoEntity aplicativoEntity = aplicativoRepository.findById(idAplicativo).orElse(null);
        if (aplicativoEntity != null) {
            aplicativoEntity.setCustoMensal(custo);
            return aplicativoRepository.save(aplicativoEntity);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        aplicativoRepository.deleteById(id);
    }

    @Override
    public AplicativoEntity getAssApp(Long codapp) {
//        return aplicativoRepository.findByCodigo(codapp);
        return null;
    }
}

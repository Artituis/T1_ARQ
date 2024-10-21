package br.arturslampert.sysctrlapp.negocio.servicos;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.PagamentoJPAEntity;
import br.arturslampert.sysctrlapp.aplicacao.dtos.PagamentoDTO;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories.PagamentoJPARepository;
import br.arturslampert.sysctrlapp.negocio.entidades.PagamentoEntity;
import br.arturslampert.sysctrlapp.negocio.persistencia.intefaces.PagamentoRepositoryInterface;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.AssinaturaServiceInterface;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.PagamentoServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PagamentoService implements PagamentoServiceInterface {
    private final PagamentoRepositoryInterface pagamentoRepository;
    private final AssinaturaServiceInterface assinaturaService;
    @Override
    public List<PagamentoEntity> get() {
        return pagamentoRepository.findAll();
    }

    @Override
    public PagamentoEntity getById(Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    @Override
    public PagamentoEntity create(PagamentoDTO pagamentoDTO) {
        PagamentoEntity pagamento = PagamentoEntity.builder()
                .assinatura(assinaturaService.getById(pagamentoDTO.getCodass()))
                .dataPagamento(pagamentoDTO.getDataPagamento())
                .valorPago(pagamentoDTO.getValorPago())
                .build();
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public void delete(Long pagamentoEntity) {

    }
}

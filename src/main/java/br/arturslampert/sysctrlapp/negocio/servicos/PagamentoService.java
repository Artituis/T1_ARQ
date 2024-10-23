package br.arturslampert.sysctrlapp.negocio.servicos;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.PagamentoJPAEntity;
import br.arturslampert.sysctrlapp.aplicacao.dtos.PagamentoDTO;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories.PagamentoJPARepository;
import br.arturslampert.sysctrlapp.negocio.entidades.AssinaturaEntity;
import br.arturslampert.sysctrlapp.negocio.entidades.PagamentoEntity;
import br.arturslampert.sysctrlapp.negocio.exeptions.PagamentoAssinaturaMuitoBaixa;
import br.arturslampert.sysctrlapp.negocio.persistencia.intefaces.PagamentoRepositoryInterface;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.AssinaturaServiceInterface;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.PagamentoServiceInterface;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public PagamentoEntity create(PagamentoDTO pagamentoDTO) throws PagamentoAssinaturaMuitoBaixa {

        AssinaturaEntity assinatura = assinaturaService.getById(pagamentoDTO.getCodass());
        if (assinatura.getAplicativo().getCustoMensal()>pagamentoDTO.getValorPago()){
            throw new PagamentoAssinaturaMuitoBaixa("Pagamento menor que o custo da assinatura");
        }

        PagamentoEntity pagamento = PagamentoEntity.builder()
                .assinatura(assinatura)
                .dataPagamento(pagamentoDTO.getDataPagamento())
                .valorPago(pagamentoDTO.getValorPago())
                .build();

        Date fimVigencia = DateUtils.addDays(pagamento.getAssinatura().getFimVigencia(), 30);
        assinaturaService.updateFimDaVigencia(pagamentoDTO.getCodass(), fimVigencia);

        Long pagamentoId = pagamentoRepository.save(pagamento);

        return pagamentoRepository.findAll().get(pagamentoId.intValue());
    }

    @Override
    public void delete(Long pagamentoEntity) {
        pagamentoRepository.deleteById(pagamentoEntity);
    }
}

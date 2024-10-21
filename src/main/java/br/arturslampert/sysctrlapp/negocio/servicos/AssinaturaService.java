package br.arturslampert.sysctrlapp.negocio.servicos;

import br.arturslampert.sysctrlapp.aplicacao.dtos.AssinaturaDTO;
import br.arturslampert.sysctrlapp.negocio.entidades.AssinaturaEntity;
import br.arturslampert.sysctrlapp.negocio.persistencia.intefaces.AssinaturaRepositoryInterface;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.AplicativoServiceInterface;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.AssinaturaServiceInterface;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.ClienteServiceInterface;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssinaturaService implements AssinaturaServiceInterface {

    private final AssinaturaRepositoryInterface assinaturaRepository;
    private final ClienteServiceInterface clienteService;
    private final AplicativoServiceInterface aplicativoService;

    @Override
    public List<AssinaturaEntity> get() {
        return assinaturaRepository.findAll();
    }

    @Override
    public AssinaturaEntity getById(Long id) {
        return assinaturaRepository.findById(id).orElse(null);
    }

    @Override
    public Long create(AssinaturaDTO assinaturaDTO) {
        AssinaturaEntity assinaturaEntity = AssinaturaEntity.builder()
                .cliente(clienteService.getById(assinaturaDTO.getCodCliente()))
                .aplicativo(aplicativoService.getById(assinaturaDTO.getCodAplicativo()))
                .inicioVigencia(new Date())
                .fimVigencia(DateUtils.addDays(new Date(), 7))
                .build();
        return assinaturaRepository.save(assinaturaEntity).getCodigo();
    }

    @Override
    public void delete(Long id) {
        assinaturaRepository.deleteById(id);
    }

    @Override
    public Boolean assinaturaValida(Long codass) {
        Optional<AssinaturaEntity> assinaturaEntity = assinaturaRepository.findById(codass);
        return assinaturaEntity.map(entity -> entity.getFimVigencia().after(new Date())).orElse(false);
    }
}

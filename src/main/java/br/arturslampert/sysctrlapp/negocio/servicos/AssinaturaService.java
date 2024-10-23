package br.arturslampert.sysctrlapp.negocio.servicos;

import br.arturslampert.sysctrlapp.aplicacao.dtos.AssinaturaDTO;
import br.arturslampert.sysctrlapp.negocio.entidades.AplicativoEntity;
import br.arturslampert.sysctrlapp.negocio.entidades.AssinaturaEntity;
import br.arturslampert.sysctrlapp.negocio.entidades.ClienteEntity;
import br.arturslampert.sysctrlapp.negocio.persistencia.intefaces.AssinaturaRepositoryInterface;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.AplicativoServiceInterface;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.AssinaturaServiceInterface;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.ClienteServiceInterface;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
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
        return assinaturaRepository.findById(id);
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

    public AssinaturaEntity updateFimDaVigencia(Long id, Date date){
        AssinaturaEntity assinaturaEntity = assinaturaRepository.findById(id);
        assinaturaEntity.setFimVigencia(date);
        return assinaturaRepository.save(assinaturaEntity);
    }

    @Override
    public void delete(Long id) {
        assinaturaRepository.deleteById(id);
    }

    @Override
    public List<AssinaturaEntity> getByTipo(String tipo) {
        return assinaturaRepository.findAll().stream().map(assinaturaEntity -> {
            if (assinaturaEntity.getStatus().toString().equalsIgnoreCase(tipo)) {
                return assinaturaEntity;
            } else if (tipo.equalsIgnoreCase("TODAS")) {
                return assinaturaEntity;
            }
            return null;
        }).toList();
    }
    @Override
    public Boolean assinaturaValida(Long codass) {
        AssinaturaEntity assinaturaEntity = assinaturaRepository.findById(codass);
        return assinaturaEntity.getFimVigencia().after(new Date());
    }

    @Override
    public List<AssinaturaEntity> getAssApp(Long codapp) {
        return assinaturaRepository.findByAplicativo(aplicativoService.getById(codapp));
    }

    @Override
    public List<AssinaturaEntity> getAssCli(Long codcli) {
        return assinaturaRepository.findByCliente(clienteService.getById(codcli));
    }
}

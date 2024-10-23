package br.arturslampert.sysctrlapp.negocio.servicos;

import br.arturslampert.sysctrlapp.negocio.entidades.AssinaturaEntity;
import br.arturslampert.sysctrlapp.negocio.entidades.ClienteEntity;
import br.arturslampert.sysctrlapp.negocio.persistencia.intefaces.ClienteRepositoryInterface;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.ClienteServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CilenteService implements ClienteServiceInterface {

    private final ClienteRepositoryInterface clienteRepository;
    @Override
    public List<ClienteEntity> get() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity getById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Long create(ClienteEntity clienteEntity) {
        return clienteRepository.save(clienteEntity).getCodigo();
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

}

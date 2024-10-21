package br.arturslampert.sysctrlapp.negocio.persistencia;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.ClienteJPAEntity;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories.ClienteJPARepository;
import br.arturslampert.sysctrlapp.negocio.entidades.ClienteEntity;
import br.arturslampert.sysctrlapp.negocio.persistencia.intefaces.ClienteRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ClienteRepository implements ClienteRepositoryInterface {
    private final ClienteJPARepository clienteJPARepository;
    public List<ClienteEntity> findAll() {
        return clienteJPARepository.findAll().stream()
                .map(ClienteJPAEntity::toClienteEntity)
                .collect(Collectors.toList());
    }

    public Optional<ClienteEntity> findById(Long id) {
        return clienteJPARepository.findById(id)
                .map(ClienteJPAEntity::toClienteEntity);
    }

    public ClienteEntity save(ClienteEntity clienteEntity) {
        return clienteJPARepository.save(ClienteJPAEntity.fromClienteEntity(clienteEntity)).toClienteEntity();
    }

    public void deleteById(Long id) {
        clienteJPARepository.deleteById(id);
    }
}

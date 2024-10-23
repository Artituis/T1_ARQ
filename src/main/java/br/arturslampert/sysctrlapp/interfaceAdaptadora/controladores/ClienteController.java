package br.arturslampert.sysctrlapp.interfaceAdaptadora.controladores;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.ClienteJPAEntity;
import br.arturslampert.sysctrlapp.negocio.entidades.ClienteEntity;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.ClienteServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteServiceInterface clienteService;

    // GET /servcad/cliente
    @Operation(summary = "Get all clients")
    @GetMapping("/clientes")
    public List<ClienteEntity> get() {
        return clienteService.get();
    }

//    @GetMapping("/clientes/{id}")
//    public ClienteEntity getById(Long id) {
//        return clienteService.getById(id);
//    }
//
//    @PostMapping("/clientes")
//    public Long create(ClienteEntity clienteJPAEntity) {
//        return clienteService.create(clienteJPAEntity);
//    }
//
//    @DeleteMapping("/clientes/{id}")
//    public void delete(@PathVariable Long id) {
//        clienteService.delete(id);
//    }

}

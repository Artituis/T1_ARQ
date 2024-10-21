package br.arturslampert.sysctrlapp.interfaceAdaptadora.controladores;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.PagamentoJPAEntity;
import br.arturslampert.sysctrlapp.aplicacao.dtos.PagamentoDTO;
import br.arturslampert.sysctrlapp.negocio.entidades.PagamentoEntity;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.PagamentoServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PagamentoController {

    private final PagamentoServiceInterface pagamentoService;

    //POST /registrarpagamento
    @PostMapping("/registrarpagamento")
    public ResponseEntity<PagamentoEntity> create(@RequestBody PagamentoDTO pagamentoDTO) {
        return ResponseEntity.ok(pagamentoService.create(pagamentoDTO));
    }

}

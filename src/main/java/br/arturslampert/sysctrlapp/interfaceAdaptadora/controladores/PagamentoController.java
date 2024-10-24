package br.arturslampert.sysctrlapp.interfaceAdaptadora.controladores;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.PagamentoJPAEntity;
import br.arturslampert.sysctrlapp.aplicacao.dtos.PagamentoDTO;
import br.arturslampert.sysctrlapp.negocio.entidades.PagamentoEntity;
import br.arturslampert.sysctrlapp.negocio.exeptions.PagamentoAssinaturaMuitoBaixa;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.PagamentoServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PagamentoController {

    private final PagamentoServiceInterface pagamentoService;

    //POST /registrarpagamento
    @Operation(description = "Registrar pagamento (ESSA FUNCIONALIDADE NÃO ESTÁ FUNCIONANDO)")
    @PostMapping("/registrarpagamento")
    public ResponseEntity<PagamentoEntity> create(@RequestBody PagamentoDTO pagamentoDTO) throws PagamentoAssinaturaMuitoBaixa {
        return ResponseEntity.ok(pagamentoService.create(pagamentoDTO));
    }

    @GetMapping("/pagamentos")
    public ResponseEntity<List<PagamentoEntity>> get() {
        return ResponseEntity.ok(pagamentoService.get());
    }

}

package br.arturslampert.sysctrlapp.interfaceAdaptadora.controladores;

import br.arturslampert.sysctrlapp.negocio.entidades.AplicativoEntity;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.AplicativoServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/servcad")
@RequiredArgsConstructor
public class AplicativoController {
    private final AplicativoServiceInterface aplicativoService;

    // GET /servcad/aplicativos
    @Operation(summary = "Get all applications")
    @GetMapping("/aplicativos")
    public List<AplicativoEntity> get() {
        return aplicativoService.get();
    }

//    @GetMapping("/aplicativos/{id}")
//    public AplicativoEntity getById(Long id) {
//        return aplicativoService.getById(id);
//    }
//
//    @PostMapping("/aplicativos")
//    public Long create(AplicativoEntity aplicativoEntity) {
//        return aplicativoService.create(aplicativoEntity);
//    }

    //POST /servcad/aplicativos/atualizacusto/:idAplicativo
    @PostMapping("/aplicativos/atualizacusto/{idAplicativo}")
    public ResponseEntity<AplicativoEntity> atualizaCusto(@PathVariable Long idAplicativo, @RequestBody Float custo) {
        return ResponseEntity.ok(aplicativoService.atualizaCusto(idAplicativo, custo));
    }

//    @DeleteMapping("/aplicativos/{id}")
//    public void delete(@PathVariable Long id) {
//        aplicativoService.delete(id);
//    }

}

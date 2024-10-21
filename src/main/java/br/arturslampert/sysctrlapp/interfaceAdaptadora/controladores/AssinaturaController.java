package br.arturslampert.sysctrlapp.interfaceAdaptadora.controladores;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.AssinaturaJPAEntity;
import br.arturslampert.sysctrlapp.aplicacao.dtos.AssinaturaDTO;
import br.arturslampert.sysctrlapp.negocio.entidades.AssinaturaEntity;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.AssinaturaServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad")
@RequiredArgsConstructor
public class AssinaturaController {
    private final AssinaturaServiceInterface assinaturaService;

//    @GetMapping("/assinaturas")
//    public List<AssinaturaEntity> get(){
//        return assinaturaService.get();
//    }
//
//    @GetMapping("/assinaturas/{id}")
//    public AssinaturaEntity getById(Long id){
//        return assinaturaService.getById(id);
//    }

    //POST /servcad/assinatura
    @PostMapping("/assinaturas")
    public Long create(AssinaturaDTO assinaturaDTO){
        return assinaturaService.create(assinaturaDTO);
    }

//    @DeleteMapping("/assinaturas/{id}")
//    public void delete(@PathVariable Long id){
//        assinaturaService.delete(id);
//    }

    // TODO: GET /servcad/assinaturas/{tipo}
    @GetMapping("/assinaturas/{tipo}")
    public List<AssinaturaEntity> getByTipo(@PathVariable String tipo){
//        return assinaturaService.getByTipo(tipo);
        return null;
    }
//    TODO: GET /assinvalida/:codass
    @GetMapping("/assinvalida/{codass}")
    public ResponseEntity<Boolean> invalidaAssinatura(@PathVariable Long codass){
        return ResponseEntity.ok(assinaturaService.assinaturaValida(codass));
    }
}

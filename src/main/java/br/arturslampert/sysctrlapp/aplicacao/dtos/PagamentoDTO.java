package br.arturslampert.sysctrlapp.aplicacao.dtos;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {
    Date dataPagamento;
    Long codass;
    Float valorPago;
}

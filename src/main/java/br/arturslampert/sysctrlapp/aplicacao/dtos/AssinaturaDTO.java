package br.arturslampert.sysctrlapp.aplicacao.dtos;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssinaturaDTO {
    Long codAplicativo;
    Long codCliente;
}

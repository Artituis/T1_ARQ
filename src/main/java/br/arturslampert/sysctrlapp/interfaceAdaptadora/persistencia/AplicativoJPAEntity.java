package br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia;

import br.arturslampert.sysctrlapp.negocio.entidades.AplicativoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "APLICATIVOS")
public class AplicativoJPAEntity {

    @Id
    @Column(name = "CODIGO", nullable = false, unique = true)
    private Long codigo;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CUSTO_MENSAL", nullable = false)
    private Float custoMensal;

    public AplicativoEntity toAplicativoEntity() {
        return AplicativoEntity.builder()
                .codigo(codigo)
                .nome(nome)
                .custoMensal(custoMensal)
                .build();
    }

    public static AplicativoJPAEntity fromAplicativoEntity(AplicativoEntity aplicativoEntity) {
        return AplicativoJPAEntity.builder()
                .codigo(aplicativoEntity.getCodigo())
                .nome(aplicativoEntity.getNome())
                .custoMensal(aplicativoEntity.getCustoMensal())
                .build();
    }
}
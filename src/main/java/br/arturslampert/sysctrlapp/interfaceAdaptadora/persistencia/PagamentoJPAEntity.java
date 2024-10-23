package br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia;

import br.arturslampert.sysctrlapp.negocio.entidades.PagamentoEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAGAMENTOS")
public class PagamentoJPAEntity {

    @Id
    @Column(name = "CODIGO", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ASSINATURA_ID", nullable = false)
    private AssinaturaJPAEntity assinatura;

    @Column(name = "VALOR_PAGO", nullable = false)
    private Float valorPago;

    @Column(name = "DATA_PAGAMENTO", nullable = false)
    private Date dataPagamento;

    @Column(name = "PROMOCAO")
    private String promocao;

    @Transactional
    public PagamentoEntity toPagamentoEntity() {
        return PagamentoEntity.builder()
                .codigo(codigo)
                .assinatura(assinatura.toAssinaturaEntity())
                .valorPago(valorPago)
                .dataPagamento(dataPagamento)
                .promocao(promocao)
                .build();
    }

    public static PagamentoJPAEntity fromPagamentoEntity(PagamentoEntity pagamentoEntity) {
        return PagamentoJPAEntity.builder()
                .codigo(pagamentoEntity.getCodigo())
                .assinatura(AssinaturaJPAEntity.builder().codigo(pagamentoEntity.getAssinatura().getCodigo()).build())
                .valorPago(pagamentoEntity.getValorPago())
                .dataPagamento(pagamentoEntity.getDataPagamento())
                .promocao(pagamentoEntity.getPromocao())
                .build();
    }
}
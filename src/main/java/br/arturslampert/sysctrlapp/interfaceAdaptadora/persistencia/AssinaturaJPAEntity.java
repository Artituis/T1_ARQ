package br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia;

import br.arturslampert.sysctrlapp.negocio.entidades.AssinaturaEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ASSINATURAS")
public class AssinaturaJPAEntity {

    @Id
    @Column(name = "CODIGO", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "APLICATIVO_ID", nullable = false)
    private AplicativoJPAEntity aplicativo;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private ClienteJPAEntity cliente;

    @Column(name = "INICIO_VIGENCIA", nullable = false)
    private Date inicioVigencia;

    @Column(name = "FIM_VIGENCIA", nullable = false)
    private Date fimVigencia;

    public enum Status {
        ATIVA,
        CANCELADA,
    }

    public Status getStatus() {
        return new Date().before(fimVigencia) ? Status.ATIVA : Status.CANCELADA;
    }
    public AssinaturaEntity toAssinaturaEntity() {
        return AssinaturaEntity.builder()
                .codigo(codigo)
                .aplicativo(aplicativo.toAplicativoEntity())
                .cliente(cliente.toClienteEntity())
                .inicioVigencia(inicioVigencia)
                .fimVigencia(fimVigencia)
                .build();
    }

    public static AssinaturaJPAEntity fromAssinaturaEntity(AssinaturaEntity assinaturaEntity) {
        return AssinaturaJPAEntity.builder()
                .codigo(assinaturaEntity.getCodigo())
                .aplicativo(AplicativoJPAEntity.fromAplicativoEntity(assinaturaEntity.getAplicativo()))
                .cliente(ClienteJPAEntity.fromClienteEntity(assinaturaEntity.getCliente()))
                .inicioVigencia(assinaturaEntity.getInicioVigencia())
                .fimVigencia(assinaturaEntity.getFimVigencia())
                .build();
    }
}
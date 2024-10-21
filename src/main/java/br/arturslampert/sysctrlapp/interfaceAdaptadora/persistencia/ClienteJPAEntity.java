package br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia;

import br.arturslampert.sysctrlapp.negocio.entidades.ClienteEntity;
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
@Table(name = "CLIENTES")
public class ClienteJPAEntity {

    @Id
    @Column(name = "CODIGO", nullable = false, unique = true)
    private Long codigo;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL", nullable = false)
    private String email;
    public ClienteEntity toClienteEntity() {
        return ClienteEntity.builder()
                .codigo(codigo)
                .nome(nome)
                .email(email)
                .build();
    }
    public static ClienteJPAEntity fromClienteEntity(ClienteEntity clienteEntity) {
        return ClienteJPAEntity.builder()
                .codigo(clienteEntity.getCodigo())
                .nome(clienteEntity.getNome())
                .email(clienteEntity.getEmail())
                .build();
    }
}
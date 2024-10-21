package br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia;

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
@Table(name = "USERS")
public class UsuarioJPAEntity {

    @Id
    Long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    String username;

    @Column(name = "PASSWORD", nullable = false, unique = false)
    String password;

    public static UsuarioJPAEntity fromUsuarioEntity(UsuarioJPAEntity usuarioEntity) {
        return UsuarioJPAEntity.builder()
                .id(usuarioEntity.getId())
                .username(usuarioEntity.getUsername())
                .password(usuarioEntity.getPassword())
                .build();
    }

    public UsuarioJPAEntity toUsuarioEntity() {
        return UsuarioJPAEntity.builder()
                .id(id)
                .username(username)
                .password(password)
                .build();
    }
}



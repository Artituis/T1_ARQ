package br.arturslampert.sysctrlapp.negocio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ClienteEntity {
    private Long codigo;
    private String nome;
    private String email;

    public ClienteEntity(Long codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long codigo;
        private String nome;
        private String email;

        public Builder codigo(Long codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public ClienteEntity build() {
            return new ClienteEntity(codigo, nome, email);
        }
    }
}

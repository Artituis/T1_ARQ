package br.arturslampert.sysctrlapp.negocio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class AplicativoEntity {
    private Long codigo;
    private String nome;
    private Float custoMensal;

    public AplicativoEntity(Long codigo, String nome, Float custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
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

    public Float getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(Float custoMensal) {
        this.custoMensal = custoMensal;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private Long codigo;
        private String nome;
        private Float custoMensal;

        public Builder codigo(Long codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder custoMensal(Float custoMensal) {
            this.custoMensal = custoMensal;
            return this;
        }

        public AplicativoEntity build() {
            return new AplicativoEntity(codigo, nome, custoMensal);
        }
    }
}

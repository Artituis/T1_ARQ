package br.arturslampert.sysctrlapp.negocio.entidades;

import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.AssinaturaJPAEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class PagamentoEntity {
    private Long codigo;
    private AssinaturaEntity assinatura;
    private Float valorPago;
    private Date dataPagamento;
    private String promocao;

    public PagamentoEntity(Long codigo, AssinaturaEntity assinatura, Float valorPago, Date dataPagamento, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public AssinaturaEntity getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(AssinaturaEntity assinatura) {
        this.assinatura = assinatura;
    }

    public Float getValorPago() {
        return valorPago;
    }

    public void setValorPago(Float valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long codigo;
        private AssinaturaEntity assinatura;
        private Float valorPago;
        private Date dataPagamento;
        private String promocao;

        public Builder codigo(Long codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder assinatura(AssinaturaEntity assinatura) {
            this.assinatura = assinatura;
            return this;
        }

        public Builder valorPago(Float valorPago) {
            this.valorPago = valorPago;
            return this;
        }

        public Builder dataPagamento(Date dataPagamento) {
            this.dataPagamento = dataPagamento;
            return this;
        }

        public Builder promocao(String promocao) {
            this.promocao = promocao;
            return this;
        }

        public PagamentoEntity build() {
            return new PagamentoEntity(codigo, assinatura, valorPago, dataPagamento, promocao);
        }
    }
}

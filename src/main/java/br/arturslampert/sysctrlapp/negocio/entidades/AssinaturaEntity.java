package br.arturslampert.sysctrlapp.negocio.entidades;

import java.util.Date;

public class AssinaturaEntity {
    private Long codigo;
    private AplicativoEntity aplicativo;
    private ClienteEntity cliente;
    private Date inicioVigencia;
    private Date fimVigencia;
    public enum Status {
        ATIVA,
        CANCELADA,
    }

    public Status getStatus() {
        return new Date().before(fimVigencia) ? Status.ATIVA : Status.CANCELADA;
    }

    public AssinaturaEntity(Long codigo, AplicativoEntity aplicativo, ClienteEntity cliente, Date inicioVigencia, Date fimVigencia) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public AplicativoEntity getAplicativo() {
        return aplicativo;
    }

    public void setAplicativo(AplicativoEntity aplicativo) {
        this.aplicativo = aplicativo;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long codigo;
        private AplicativoEntity aplicativo;
        private ClienteEntity cliente;
        private Date inicioVigencia;
        private Date fimVigencia;

        public Builder codigo(Long codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder aplicativo(AplicativoEntity aplicativo) {
            this.aplicativo = aplicativo;
            return this;
        }

        public Builder cliente(ClienteEntity cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder inicioVigencia(Date inicioVigencia) {
            this.inicioVigencia = inicioVigencia;
            return this;
        }

        public Builder fimVigencia(Date fimVigencia) {
            this.fimVigencia = fimVigencia;
            return this;
        }

        public AssinaturaEntity build() {
            return new AssinaturaEntity(codigo, aplicativo, cliente, inicioVigencia, fimVigencia);
        }
    }
}

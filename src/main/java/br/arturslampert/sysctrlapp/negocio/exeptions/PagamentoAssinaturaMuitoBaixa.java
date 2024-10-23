package br.arturslampert.sysctrlapp.negocio.exeptions;

public class PagamentoAssinaturaMuitoBaixa extends Exception {

    /**
     * Constructs a <code>UserIdNotFoundException</code> with the specified message.
     *
     * @param msg the detail message.
     */
    public PagamentoAssinaturaMuitoBaixa(String msg) {
        super(msg);
    }

    /**
     * Constructs a {@code UserIdNotFoundException} with the specified message and root
     * cause.
     *
     * @param msg   the detail message.
     * @param cause root cause
     */
    public PagamentoAssinaturaMuitoBaixa(String msg, Throwable cause) {
        super(msg, cause);
    }

}

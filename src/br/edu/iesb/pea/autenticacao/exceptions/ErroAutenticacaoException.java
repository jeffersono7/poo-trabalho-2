package br.edu.iesb.pea.autenticacao.exceptions;

public class ErroAutenticacaoException extends Exception {

    private String usuario;

    public ErroAutenticacaoException(String message, String usuario) {

        super(message);
        this.usuario = usuario;
    }
}

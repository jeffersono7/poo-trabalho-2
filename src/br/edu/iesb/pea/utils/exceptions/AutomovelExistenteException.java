package br.edu.iesb.pea.utils.exceptions;

public class AutomovelExistenteException extends ValidacaoException {

    private String automovel;

    public AutomovelExistenteException(String message, String automovel) {

        super(message);
        this.automovel = automovel;
    }
}

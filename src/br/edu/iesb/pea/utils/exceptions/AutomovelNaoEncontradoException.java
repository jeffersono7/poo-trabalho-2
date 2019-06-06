package br.edu.iesb.pea.utils.exceptions;

public class AutomovelNaoEncontradoException extends ValidacaoException {

    private Long id;

    public AutomovelNaoEncontradoException(String message,
                                           Long id) {
        super(message);
        this.id = id;
    }
}

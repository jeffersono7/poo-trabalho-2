package br.edu.iesb.pea.autenticacao;

import br.edu.iesb.pea.autenticacao.exceptions.ErroAutenticacaoException;

public interface AutenticacaoService {

    /**
     * <h3>Método para realizar login na aplicação.</h3>
     *
     * <p>Lança exception caso usuario ou senha inválidos.</p>
     * @throws ErroAutenticacaoException
     */
    void login() throws ErroAutenticacaoException;
}

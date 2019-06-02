package br.edu.iesb.pea.autenticacao;

import br.edu.iesb.pea.autenticacao.exceptions.ErroAutenticacaoException;

import java.util.Scanner;

public class AutenticacaoServiceImpl implements AutenticacaoService {

    private static final String usuario = "user";
    private static final String senha = "123";

    private Scanner scanner;

    public AutenticacaoServiceImpl(Scanner scanner) {

        this.scanner = scanner;
    }


    public void login() throws ErroAutenticacaoException {

        System.out.println("\n\n\n\tDigite seu usuario: ");
        String user = scanner.nextLine();

        System.out.println("\n\tDigite sua senha: ");
        String password = scanner.nextLine();

        autenticar(user, password);

        System.out.println("\n\n\tAutenticado com sucesso!");
    }


    /**
     * Realiza processo de autenticação.
     * @param usuario
     * @param senha
     * @throws ErroAutenticacaoException
     */
    private void autenticar(String usuario, String senha) throws ErroAutenticacaoException {

        boolean usuarioCerto = AutenticacaoServiceImpl.usuario.equals(usuario);
        boolean senhaCerta = AutenticacaoServiceImpl.senha.equals(senha);

        if (usuarioCerto && senhaCerta) {
            return;
        }

        throw new ErroAutenticacaoException("Usuário ou senha inválidos!", usuario);
    }
}

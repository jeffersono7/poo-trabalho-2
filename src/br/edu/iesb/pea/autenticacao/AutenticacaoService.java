package br.edu.iesb.pea.autenticacao;

public class AutenticacaoService {

    private static final String usuario = "user";
    private static final String senha = "123";

    public boolean autenticar(String usuario, String senha) {

        boolean usuarioCerto = AutenticacaoService.usuario.equals(usuario);
        boolean senhaCerta = AutenticacaoService.senha.equals(senha);

        return usuarioCerto && senhaCerta;
    }
}

package br.edu.iesb.pea.controllers;

import br.edu.iesb.pea.autenticacao.AutenticacaoService;
import br.edu.iesb.pea.autenticacao.exceptions.ErroAutenticacaoException;
import br.edu.iesb.pea.daos.AutomovelDAO;
import br.edu.iesb.pea.models.Automovel;
import br.edu.iesb.pea.views.impl.AutomovelView;

public class AutomovelController {

    private AutenticacaoService autenticacaoService;
    private AutomovelDAO dao;
    private AutomovelView view;

    public AutomovelController(AutenticacaoService autenticacaoService,
                               AutomovelView view,
                               AutomovelDAO dao) {

        this.autenticacaoService = autenticacaoService;
        this.view = view;
        this.dao = dao;
    }


    public Automovel cadastrarAutomovel() throws ErroAutenticacaoException {

        try {
            autenticacaoService.login();

            Automovel automovel = createAutomovel();

            dao.save(automovel);

            return automovel;

        } catch (ErroAutenticacaoException e) {

            throw e;
        }
    }

    /**
     * Cria um automóvel com as descrições informadas pelo usuário.
     *
     * @return
     */
    private Automovel createAutomovel() {

        return view.formAutomovel();
    }
}

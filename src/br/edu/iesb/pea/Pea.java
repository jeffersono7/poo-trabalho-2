package br.edu.iesb.pea;

import br.edu.iesb.pea.autenticacao.AutenticacaoService;
import br.edu.iesb.pea.autenticacao.AutenticacaoServiceImpl;
import br.edu.iesb.pea.controllers.AutomovelController;
import br.edu.iesb.pea.controllers.CarrinhoController;
import br.edu.iesb.pea.controllers.PedidoController;
import br.edu.iesb.pea.daos.impl.AutomovelDAO;
import br.edu.iesb.pea.daos.impl.CarrinhoDAO;
import br.edu.iesb.pea.views.impl.AutomovelView;
import br.edu.iesb.pea.views.impl.CarrinhoView;
import br.edu.iesb.pea.views.impl.MainView;
import br.edu.iesb.pea.views.impl.PedidoView;

import java.util.Scanner;

public class Pea {

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);

        AutenticacaoService autenticacaoService = new AutenticacaoServiceImpl(scanner);

        AutomovelDAO automovelDAO = new AutomovelDAO();
        AutomovelController automovelController = new AutomovelController(autenticacaoService, automovelDAO);
        AutomovelView automovelView = new AutomovelView(automovelController, scanner);

        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        CarrinhoController carrinhoController = new CarrinhoController(carrinhoDAO);
        CarrinhoView carrinhoView = new CarrinhoView(carrinhoController, scanner, automovelController);

        PedidoController pedidoController = new PedidoController();
        PedidoView pedidoView = new PedidoView(pedidoController, scanner);


        MainView mainView = new MainView(scanner,
                automovelView,
                carrinhoView,
                pedidoView);

        mainView.init();
    }

}

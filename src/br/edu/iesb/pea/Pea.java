package br.edu.iesb.pea;

import br.edu.iesb.pea.autenticacao.AutenticacaoService;
import br.edu.iesb.pea.autenticacao.AutenticacaoServiceImpl;
import br.edu.iesb.pea.controllers.AutomovelController;
import br.edu.iesb.pea.controllers.CarrinhoController;
import br.edu.iesb.pea.controllers.PedidoController;
import br.edu.iesb.pea.daos.impl.AutomovelDAO;
import br.edu.iesb.pea.daos.impl.CarrinhoDAO;
import br.edu.iesb.pea.models.Automovel;
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

        // popula com automóveis
        preencheAutomoveis(automovelDAO);

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

    public static void preencheAutomoveis(br.edu.iesb.pea.daos.AutomovelDAO dao) {

        Automovel automovel = new Automovel();
        automovel.setPossuiCorFosca(true);
        automovel.setNome("UP");
        automovel.setValor(55000.43);

        Automovel automovel2 = new Automovel();
        automovel.setPossuiCorFosca(true);
        automovel.setNome("Corolla");
        automovel.setValor(78050.43);

        Automovel automovel3 = new Automovel();
        automovel.setPossuiCorFosca(false);
        automovel.setNome("Celta");
        automovel.setValor(19000.43);

        dao.save(automovel);
        dao.save(automovel2);
        dao.save(automovel3);
    }

}

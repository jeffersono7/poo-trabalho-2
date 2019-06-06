package br.edu.iesb.pea.views.impl;

import br.edu.iesb.pea.controllers.AutomovelController;
import br.edu.iesb.pea.controllers.CarrinhoController;
import br.edu.iesb.pea.models.Automovel;
import br.edu.iesb.pea.models.Carrinho;
import br.edu.iesb.pea.utils.Group;
import br.edu.iesb.pea.utils.exceptions.AutomovelNaoEncontradoException;
import br.edu.iesb.pea.utils.exceptions.ValidacaoException;
import br.edu.iesb.pea.views.View;

import java.util.Scanner;

public class CarrinhoView implements View {

    private CarrinhoController carrinhoController;
    private AutomovelController automovelController;
    private Scanner scanner;

    public CarrinhoView(CarrinhoController carrinhoController,
                        Scanner scanner,
                        AutomovelController automovelController) {
        this.carrinhoController = carrinhoController;
        this.scanner = scanner;
        this.automovelController = automovelController;
    }

    public void init() {

        showOptions();

        Integer opcao = chooseOption();

        switch (opcao) {

            case 1:
                this.listarAutomoveis();
                break;
            case 2:
                this.adicionarAutomovelNoCarrinho();
                break;
            case 3:
                this.visualizarCarrinho();
            case 4:
                this.excluirAutomovelDoCarrinho();
            case 5:
                this.finalizarCompra();
            default:
                System.out.println("\n\n\tOpção não disponível!");
                break;
        }
    }

    private void finalizarCompra() {

        Long idPedido = null;

        try {
            idPedido = carrinhoController.finalizarCompra();

            System.out.println("Compra efetuada com identificador do pedido: " + idPedido + ", será entregue em 10 dias");
        } catch (ValidacaoException e) {

            System.out.println(e.getMessage());
        }

    }

    private void excluirAutomovelDoCarrinho() {

        Long idAutomovel = Long.valueOf(scanner.nextLine());

        carrinhoController.removerAutomovelDoCarrinho(idAutomovel);

        System.out.println("Automovel excluido com sucesso!");
    }

    private void visualizarCarrinho() {

        Carrinho carrinho = carrinhoController.obterCarrinho();

        carrinho.getItems().forEach(item -> {

            System.out.println("* " + item.getAutomovel().getNome());
        });
    }

    private void listarAutomoveis() {

        Group<Automovel> automovels = automovelController.listarAutomoveis();

        System.out.println("\n\nListando:");

        automovels.forEach(automovel -> {

            System.out.println("\n\tCarro: " + automovel.getId() + ", nome: " + automovel.getNome());
        });

        System.out.println("\n");
    }

    private void adicionarAutomovelNoCarrinho() {

        System.out.println("Digite o Id do automóvel: ");
        Long idAutomovel = Long.valueOf(scanner.nextLine());

        System.out.println("Digite a cor do veículo: ");
        String cor = scanner.nextLine();

        System.out.println("Cor é fosca? (s ou n)");
        String ehFoscaString = scanner.nextLine();

        boolean ehFosca = false;

        if (ehFoscaString.equals("s")) {

            ehFosca = true;
        }

        System.out.println("Digite a quantidade: ");
        Integer quantidade = Integer.valueOf(scanner.nextLine());

        try {

            carrinhoController.adicionarAutomovel(idAutomovel, cor, ehFosca, quantidade);

            System.out.println("Item adicionado ao carrinho!");
        } catch (AutomovelNaoEncontradoException e) {

            System.out.println("Automovel não encontrado!");
        }
    }

    /**
     * Mostra as opções disponíveis.
     */
    private void showOptions() {

        System.out.println("########################################################");
        System.out.println("#                    Carrinho                          #");
        System.out.println("#                                                      #");
        System.out.println("#   1- Listar automóveis                               #");
        System.out.println("#   2- Adicionar automóveis ao carrinho                #");
        System.out.println("#   3- Visualizar o carrinho                           #");
        System.out.println("#   4- Excluir automóvel do carrinho                   #");
        System.out.println("#   5- Finalizar compra                                #");
        System.out.println("#                                                      #");
    }

    /**
     * Seleciona a opção do usuário.
     *
     * @return
     */
    private Integer chooseOption() {

        System.out.println("    Digite uma opção: ");

        String opcao = scanner.nextLine();

        return Integer.valueOf(opcao);
    }
}

package br.edu.iesb.pea.views.impl;

import br.edu.iesb.pea.views.View;

import java.util.Scanner;

public class MainView implements View {

    private Scanner scanner;
    private AutomovelView automovelView;
    private CarrinhoView carrinhoView;
    private EstoqueView estoqueView;
    private PedidoView pedidoView;

    public MainView(Scanner scanner,
                    AutomovelView automovelView,
                    CarrinhoView carrinhoView,
                    EstoqueView estoqueView,
                    PedidoView pedidoView) {

        this.scanner = scanner;
        this.automovelView = automovelView;
        this.estoqueView = estoqueView;
    }

    /**
     * Exibe menu e opções do programa.
     *
     * @return Opção escolhida
     */
    public void init() {

        this.showMenu();

        String opcao = this.scanner.nextLine();

        chooseView(Integer.valueOf(opcao));
    }

    private void chooseView(Integer opcao) {

        switch (opcao) {
            case 1:
                this.automovelView.init();
                break;
            case 2:
                this.carrinhoView.init();
                break;
            case 3:
                this.pedidoView.init();
                break;
            case 4:
                this.estoqueView.init();
                break;
            case 5:
                break;
        }
    }

    private void showMenu() {

        System.out.println("########################################################");
        System.out.println("#                                                       #");
        System.out.println("#       PEA - Projeto Estações de Autoatendimento       #");
        System.out.println("#                                                       #");
        System.out.println("#                              Author: Jefferson Farias #");
        System.out.println("#     https://github.com/jeffersono7/poo-trabalho-2.git #");
        System.out.println("#                                                       #");
        System.out.println("#   1- Manter Automóveis                                #");
        System.out.println("#   2- Comprar automóveis                               #");
        System.out.println("#   3- Pedido                                           #");
        System.out.println("#   4- Controlar estoque                                #");
        System.out.println("#   5- Sair                                             #");
        System.out.println("#                                                       #");
        System.out.println("   Digite uma opção: ");
    }
}

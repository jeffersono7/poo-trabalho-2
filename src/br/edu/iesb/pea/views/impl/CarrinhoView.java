package br.edu.iesb.pea.views.impl;

import br.edu.iesb.pea.controllers.CarrinhoController;
import br.edu.iesb.pea.views.View;

import java.util.Scanner;

public class CarrinhoView implements View {

    private CarrinhoController controller;
    private Scanner scanner;

    public CarrinhoView(CarrinhoController controller,
                        Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void init() {

        showOptions();

        Integer opcao = chooseOption();

        switch (opcao) {

            case 1:
                break;
            case 2:
                break;
            default:
                System.out.println("\n\n\tOpção não disponível!");
                break;
        }
    }

    /**
     * Mostra as opções disponíveis.
     */
    public void showOptions() {

        System.out.println("########################################################");
        System.out.println("#                    Carrinho                          #");
        System.out.println("#                                                      #");
        System.out.println("#   1- Listar automóveis                               #");
        System.out.println("#   2- Adicionar automóveis ao carrinho                #");
        System.out.println("#                                                      #");
    }

    /**
     * Seleciona a opção do usuário.
     *
     * @return
     */
    public Integer chooseOption() {

        System.out.println("    Digite uma opção: ");

        String opcao = scanner.nextLine();

        return Integer.valueOf(opcao);
    }
}

package br.edu.iesb.pea.views.impl;

import br.edu.iesb.pea.controllers.PedidoController;
import br.edu.iesb.pea.views.View;

import java.util.Scanner;

public class PedidoView implements View {

    private PedidoController controller;
    private Scanner scanner;

    public PedidoView(PedidoController controller,
                      Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void init() {

        showOptions();

        Integer option = chooseOption();

        switch (option) {

            case 1:
                break;
            default:
                System.out.println("\n\n\tOpção não disponível!");
                break;
        }
    }

    /**
     * Mostra as opções disponíveis.
     */
    private void showOptions() {

        System.out.println("########################################################");
        System.out.println("#                    Pedido                            #");
        System.out.println("#                                                      #");
        System.out.println("#   1- Acompanhar pedido                               #");
        System.out.println("#                                                      #");
    }

    /**
     * Retorna opcao escolhida pelo usuário.
     * @return
     */
    private Integer chooseOption() {

        System.out.println("    Digite uma opção: ");

        String opcao = scanner.nextLine();

        return Integer.valueOf(opcao);
    }
}

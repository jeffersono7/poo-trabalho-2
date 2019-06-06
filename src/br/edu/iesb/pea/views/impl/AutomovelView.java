package br.edu.iesb.pea.views.impl;

import br.edu.iesb.pea.autenticacao.exceptions.ErroAutenticacaoException;
import br.edu.iesb.pea.controllers.AutomovelController;
import br.edu.iesb.pea.models.Automovel;
import br.edu.iesb.pea.utils.Group;
import br.edu.iesb.pea.views.View;

import java.util.Scanner;

public class AutomovelView implements View {

    private AutomovelController controller;
    private Scanner scanner;

    public AutomovelView(AutomovelController controller,
                         Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    /**
     * Formulário para criação de automóvel.
     *
     * @return
     */
    public static Automovel formAutomovel() {

        Scanner scanner = new Scanner(System.in);
        Automovel automovel = new Automovel();

        System.out.println("\n\n\tDigite o nome do automóvel: ");
        automovel.setNome(scanner.nextLine());

        System.out.println("\n\n\tDigite se automóvel possui opção para cores foscas: (s ou n) ");
        String possuiCorFosca = scanner.nextLine();

        if (possuiCorFosca.equals("s")) {

            automovel.setPossuiCorFosca(true);
        } else if (possuiCorFosca.equals("n")) {

            automovel.setPossuiCorFosca(false);
        } else {
            throw new IllegalArgumentException("Opção inválida!");
        }

        return automovel;
    }

    /**
     * Método principal para automóveis.
     */
    public void init() {

        this.showOptions();

        Integer option = this.chooseOption();

        switch (option) {

            case 1:
                this.cadastrarAutomoveis();
                break;
            case 2:
                this.listarAutomoveis();
                break;
            default:
                System.out.println("\n\n\tOpção não disponível!");
                break;
        }
    }

    private void cadastrarAutomoveis() {

        try {
            Automovel result = this.controller.cadastrarAutomovel();

            System.out.println("\n\n\tAutomóvel " + result.getNome() + " salvo com sucesso!");
        } catch (ErroAutenticacaoException e) {

            System.out.println("\n\n\tLogin inválido!");
        }
    }

    private void listarAutomoveis() {

        Group<Automovel> automovels = controller.listarAutomoveis();

        System.out.println("\n\nListando: " + automovels.size() + " automóveis!");

        automovels.forEach(automovel -> {

            System.out.println("\n\tCarro: " + automovel.getId() + ", nome: " + automovel.getNome());
        });

        System.out.println("\n");
    }


    /**
     * Exibe as opção disponíveis para automóveis.
     */
    private void showOptions() {

        System.out.println("########################################################");
        System.out.println("#                    Automóveis                        #");
        System.out.println("#                                                      #");
        System.out.println("#   1- Para cadastrar automóveis (restrito)            #");
        System.out.println("#   2- Listar automóveis                               #");
        System.out.println("#                                                      #");

    }

    /**
     * Retorna a opção escolhida pelo usuário.
     *
     * @return
     */
    private Integer chooseOption() {

        System.out.println("    Digite uma opção: ");

        String opcao = scanner.nextLine();

        return Integer.valueOf(opcao);
    }
}

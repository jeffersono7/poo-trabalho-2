package br.edu.iesb.pea.models;

import br.edu.iesb.pea.utils.Group;

public class Carrinho {

    private Group<Item> items;
    private double valorTotal;
    private Long id;

    public Group<Item> getItems() {
        return items;
    }

    public void setItems(Group<Item> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void calcularTotal() {

        double valorTotal = 0l;

        for (Item item : items) {

            double valorAutomovel = item.getAutomovel().getValor();

            double valor = item.getQuantidade().intValue() * valorAutomovel;

            if (item.isEhFosca()) {

                valorTotal = valor * (0.03);
            } else {

                valorTotal = valor;
            }
        }
    }
}

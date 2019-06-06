package br.edu.iesb.pea.daos.impl;

import br.edu.iesb.pea.models.Carrinho;
import br.edu.iesb.pea.models.Item;
import br.edu.iesb.pea.utils.Group;
import br.edu.iesb.pea.utils.exceptions.ValidacaoException;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoDAO implements br.edu.iesb.pea.daos.CarrinhoDAO {

    private Map<Long, Carrinho> histCompras;

    private Carrinho carrinho;
    private Long id = 0L;

    public CarrinhoDAO() {

        histCompras = new HashMap<>();
        carrinho = new Carrinho();
        carrinho.setItems(new Group<>());
    }

    @Override
    public void adicionarItem(Item item) {

        carrinho.getItems().add(item);
    }

    @Override
    public Carrinho obter() {

        return carrinho;
    }

    @Override
    public void save(Carrinho carrinho) {

        this.carrinho = carrinho;
    }

    @Override
    public Long finalizarCompra(Carrinho carrinho) throws ValidacaoException {

        if (carrinho.getItems().size() > 10) {
            throw new ValidacaoException("Limite máximo de automóveis no carrinho é 10");
        }

        Long id = getId();

        histCompras.put(id, carrinho);

        return id;
    }

    private Long getId() {

        return id++;
    }

}

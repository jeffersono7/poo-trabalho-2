package br.edu.iesb.pea.controllers;

import br.edu.iesb.pea.daos.AutomovelDAO;
import br.edu.iesb.pea.daos.CarrinhoDAO;
import br.edu.iesb.pea.models.Automovel;
import br.edu.iesb.pea.models.Carrinho;
import br.edu.iesb.pea.models.Item;
import br.edu.iesb.pea.utils.Group;
import br.edu.iesb.pea.utils.exceptions.AutomovelNaoEncontradoException;
import br.edu.iesb.pea.utils.exceptions.ValidacaoException;

public class CarrinhoController {

    private CarrinhoDAO dao;
    private AutomovelDAO automovelDAO;

    public CarrinhoController(CarrinhoDAO dao) {

        this.dao = dao;
    }

    /**
     * Adicionar automovel no carrinho.
     *
     * @param idAutomovel {@link Long}
     * @param cor
     * @param quantidade
     */
    public void adicionarAutomovel(Long idAutomovel,
                                       String cor,
                                       boolean ehFosca,
                                       Integer quantidade) throws AutomovelNaoEncontradoException {

        Item item = construirItem(idAutomovel, cor, ehFosca,quantidade);
        dao.adicionarItem(item);
    }

    /**
     * Retorna o carrinho.
     * @return
     */
    public Carrinho obterCarrinho() {

        return dao.obter();
    }

    /**
     * Remover automóvel do carrinho.
     */
    public void removerAutomovelDoCarrinho(Long idAutomovel) {

        Carrinho carrinho = dao.obter();

        Group<Item> items = new Group<>();

        carrinho.getItems()
                .stream()
                .filter(item -> !item.getAutomovel().getId().equals(idAutomovel))
                .forEach(items::add);

        carrinho.setItems(items);

        dao.save(carrinho);
    }


    public Long finalizarCompra() throws ValidacaoException {

        Carrinho carrinho = dao.obter();

        carrinho.calcularTotal();

        return dao.finalizarCompra(carrinho);
    }

    private Item construirItem(Long idAutomovel,
                          String cor,
                          boolean ehFosca,
                          Integer quantidade) throws AutomovelNaoEncontradoException {

        Automovel automovel = automovelDAO.obterPorId(idAutomovel);

        Item item = new Item();
        item.setAutomovel(automovel);
        item.setQuantidade(quantidade);
        item.setCor(cor);
        item.setEhFosca(ehFosca);

        return item;
    }
}

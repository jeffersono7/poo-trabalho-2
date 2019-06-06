package br.edu.iesb.pea.daos;

import br.edu.iesb.pea.models.Carrinho;
import br.edu.iesb.pea.models.Item;
import br.edu.iesb.pea.utils.exceptions.ValidacaoException;

public interface CarrinhoDAO {

    void adicionarItem(Item item);

    Carrinho obter();

    void save(Carrinho carrinho);

    Long finalizarCompra(Carrinho carrinho) throws ValidacaoException;
}

package br.edu.iesb.pea.daos;

import br.edu.iesb.pea.models.Automovel;
import br.edu.iesb.pea.utils.Group;
import br.edu.iesb.pea.utils.exceptions.AutomovelNaoEncontradoException;

public interface AutomovelDAO {

    /**
     * <h3>Salva um novo automóvel</h3>
     * @param {@link Automovel}
     * @return
     */
    Automovel save(Automovel automovel);

    /**
     * <h3>Lista todos os automóveis</h3>
     * @return
     */
    Group<Automovel> listar();

    /**
     * <h3>Obter um automóvel por id</h3>
     * @param id {@link Long}
     * @return
     */
    Automovel obterPorId(Long id) throws AutomovelNaoEncontradoException;
}

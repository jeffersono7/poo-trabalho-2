package br.edu.iesb.pea.daos;

import br.edu.iesb.pea.models.Automovel;

public interface AutomovelDAO {

    /**
     * <h3>Salva um novo automóvel</h3>
     * @param {@link Automovel}
     * @return
     */
    Automovel save(Automovel automovel);
}

package br.edu.iesb.pea.daos.impl;

import br.edu.iesb.pea.models.Automovel;
import br.edu.iesb.pea.utils.Group;
import br.edu.iesb.pea.utils.exceptions.AutomovelNaoEncontradoException;

import java.util.Objects;

public class AutomovelDAO implements br.edu.iesb.pea.daos.AutomovelDAO {

    private Group<Automovel> automovels;
    private Long id = 0L;

    public AutomovelDAO() {

        automovels = new Group<>();
    }

    public Automovel save(Automovel automovel) {

        automovel.setId(getId());

        automovels.add(automovel);

        return automovel;
    }

    public Group<Automovel> listar() {

        return automovels;
    }

    @Override
    public Automovel obterPorId(Long id) throws AutomovelNaoEncontradoException {

        Automovel result = automovels
                .stream()
                .filter(automovel -> automovel.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (Objects.isNull(result)) {
            throw new AutomovelNaoEncontradoException("Não encontrado", id);
        }

        return result;
    }


    private Long getId() {

        return id++;
    }
}

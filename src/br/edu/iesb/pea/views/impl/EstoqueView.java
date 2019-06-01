package br.edu.iesb.pea.views.impl;

import br.edu.iesb.pea.controllers.EstoqueController;
import br.edu.iesb.pea.views.View;

public class EstoqueView implements View {

    private EstoqueController controller;

    public EstoqueView(EstoqueController controller) {
        this.controller = controller;
    }
    
    public void init() {

    }
}

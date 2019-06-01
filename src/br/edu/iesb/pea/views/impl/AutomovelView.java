package br.edu.iesb.pea.views.impl;

import br.edu.iesb.pea.controllers.AutomovelController;
import br.edu.iesb.pea.views.View;

public class AutomovelView implements View {

    private AutomovelController controller;

    public AutomovelView(AutomovelController controller) {
        this.controller = controller;
    }

    public void init() {

    }
}

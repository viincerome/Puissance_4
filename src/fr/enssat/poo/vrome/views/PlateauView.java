package fr.enssat.poo.vrome.views;

import fr.enssat.poo.vrome.controlers.ApplicationController;

import javax.swing.*;

public class PlateauView extends JFrame {

    private static final long serialVersionUID = -2658676059456370329L;

    private final ApplicationController controler;

    public PlateauView(ApplicationController controller) {
        super("Puissance 4 - Vincent ROME");
        this.controler = controller;

        ViewsUtilities.setGeneralParameters(this);
    }

    public ApplicationController getControler() {
        return controler;
    }

}

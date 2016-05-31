package fr.enssat.poo.vrome.views;

import javax.swing.JFrame;

import fr.enssat.poo.vrome.controlers.ApplicationController;

public class MainView extends JFrame {

	private static final long serialVersionUID = -2658676059456370329L;

	private final ApplicationController controler;

	public MainView(ApplicationController controller) {
		super("Puissance 4 - Vincent ROME");
		this.controler = controller;

		ViewsUtilities.setGeneralParameters(this);
	}

	public ApplicationController getControler() {
		return controler;
	}
}

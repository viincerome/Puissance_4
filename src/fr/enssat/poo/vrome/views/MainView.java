package fr.enssat.poo.vrome.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

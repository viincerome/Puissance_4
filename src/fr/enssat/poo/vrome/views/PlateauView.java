package fr.enssat.poo.vrome.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.enssat.poo.vrome.controlers.ApplicationController;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;

public class PlateauView extends JFrame {

	private static final long serialVersionUID = -2658676059456370329L;

	private Logger LOGGER = new SystemOutLogger(PlateauView.class);

	private final ApplicationController controler;

	public PlateauView(final ApplicationController controler) {

		super("Puissance 4 - Vincent ROME");
		this.controler = controler;
		this.setSize(420, 420);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JButton[] buttons = new JButton[this.controler.getRows()];
		JPanel plateau = new JPanel();
		plateau.setPreferredSize(new Dimension(420, 60));
		plateau.setLayout(new GridLayout(this.controler.getRows(), this.controler.getColumns()));

		for ( int counter = 0; counter < this.controler.getRows(); counter++ ) {
			final int colonne = counter; // Javadoc: any local variable, used but not declared in an inner class must be definitely assigned before the body of the inner class.

			buttons[colonne] = new JButton(Integer.toString(colonne));
			buttons[colonne].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					PlateauView.this.LOGGER.debug("Demande de placer un pion sur le plateau sur la colonne " + colonne + " par l'interface graphique.");
					getControler().playPion(colonne);
				}
			});

			plateau.add(buttons[colonne]);
		}

		drawPlateau(plateau);
		this.add(plateau);

		ViewsUtilities.setGeneralParameters(this);
	}

	private void drawPlateau(final JPanel plateau) {
		for ( int x = 1; x < this.controler.getRows(); x++ ) {
			for ( int j = 0; j < this.controler.getColumns(); j++ ) {
				plateau.add(new Case());
			}
		}
	}

	private ApplicationController getControler() {
		assert this.controler != null;
		return this.controler;
	}

}

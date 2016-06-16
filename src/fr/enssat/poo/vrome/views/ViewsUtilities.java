package fr.enssat.poo.vrome.views;

import javax.swing.JFrame;

/**
 * Commons actions for each frames of the application.
 */
public final class ViewsUtilities {
	public static void setGeneralParameters(final JFrame window) {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.validate();
		window.setVisible(true);
	}

}

package fr.enssat.poo.vrome.views;

import com.sun.java.swing.plaf.windows.resources.windows;

import javax.swing.JFrame;

/**
 * Commons actions for each frames of the application.
 */
public final class ViewsUtilities {
	public static void setGeneralParameters(final JFrame window) {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.validate();
     //   window.pack();
		window.setVisible(true);
	}

}

package fr.enssat.poo.vrome.views;

import javax.swing.*;

/**
 * Commons actions for each frames of the application.
 */
public final class ViewsUtilities {

    public static void setGeneralParameters(final JFrame window) {
        window.setTitle("Puissance 4 - Vincent ROME");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); // Not reponsive
        window.pack();
        window.setVisible(true);
    }

}
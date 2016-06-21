package fr.enssat.poo.vrome.views;

import fr.enssat.poo.vrome.controlers.GameController;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlateauView extends JFrame {

    private static final long serialVersionUID = -2658676059456370329L;
    private static final int BUTTONS_HEIGHT = new JButton().getHeight();
    private final GameController controler;
    private Logger LOGGER = new SystemOutLogger(PlateauView.class);

    public PlateauView(final GameController controler) {
        super("Puissance 4 - Vincent ROME");
        this.controler = controler;
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().add(createInfoPanel(), BorderLayout.PAGE_START);
        getContentPane().add(createPlateauPanel(), BorderLayout.CENTER);

        ViewsUtilities.setGeneralParameters(this);
    }

    private JPanel createPlateauPanel() {
        JPanel plateauPanel = new JPanel();
        plateauPanel.setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel();
        JPanel grillePanel = new JPanel();

        grillePanel.setLayout(new GridLayout(this.controler.getRows(), this.controler.getColumns()));
        LOGGER.debug("On va créer " + this.controler.getColumns());
        for (int counter = 1; counter <= this.controler.getColumns(); counter++) {
            LOGGER.debug("Creating button " + counter);
            final int column = counter; // Any local variable, used but not declared in an inner class must be definitely assigned before the body of the inner class.

            JButton button = new JButton(Integer.toString(column));

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    LOGGER.debug("Demande de placer un pion sur le plateau sur la colonne " + column + " par l'interface graphique.");
                    getControler().playPion(column);
                }
            });

            buttonsPanel.add(button);
        }

        drawPlateau(grillePanel);

        plateauPanel.add(buttonsPanel, BorderLayout.PAGE_START);
        plateauPanel.add(grillePanel, BorderLayout.CENTER);
        return plateauPanel;
    }

    private JPanel createInfoPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("C'est au tour de " + getControler().getCurrentPlayerName() + " de jouer..."));
        return panel;
    }

    private void drawPlateau(final JPanel plateau) {
        for (int x = 0; x < this.controler.getRows(); x++) {
            for (int j = 0; j < this.controler.getColumns(); j++) {
                plateau.add(new Case());
            }
        }
    }

    private GameController getControler() {
        assert this.controler != null;
        return this.controler;
    }
    
}
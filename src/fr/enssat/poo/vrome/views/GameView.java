package fr.enssat.poo.vrome.views;

import fr.enssat.poo.vrome.controlers.GameController;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class GameView extends JFrame implements Observer {

    private static final long serialVersionUID = -2658676059456370329L;
    private final GameController controler;
    private Logger LOGGER = new SystemOutLogger(GameView.class);
    private JLabel playerToPlay;
    private JPanel grillePanel;

    public GameView(final GameController controler) {
        this.controler = controler;
        this.controler.registerObserver(this);

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
        this.grillePanel = new JPanel();

        grillePanel.setLayout(new GridLayout(this.controler.getRows(), this.controler.getColumns()));
        for (int counter = 0; counter < this.controler.getColumns(); counter++) {
            final int column = counter; // Any local variable, used but not declared in an inner class must be definitely assigned before the body of the inner class.

            JButton button = new JButton(Integer.toString(column + 1));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    LOGGER.debug("Demande de placer un pion sur le plateau sur la colonne " + column + " par l'interface graphique.");
                    getControler().playPion(column);
                }
            });

            buttonsPanel.add(button);
        }

        drawPlateau();

        plateauPanel.add(buttonsPanel, BorderLayout.PAGE_START);
        plateauPanel.add(grillePanel, BorderLayout.CENTER);
        return plateauPanel;
    }

    private void drawPlateau() {
        this.grillePanel.removeAll(); // Clear the panel before repainting
        for (int x = 0; x < this.controler.getRows(); x++) {
            for (int y = 0; y < this.controler.getColumns(); y++) {
                switch (getControler().getContentAt(x, y)) {
                    case '.':
                        this.grillePanel.add(new Case(Color.white));
                        break;
                    case 'Y':
                        this.grillePanel.add(new Case(Color.yellow));
                        break;
                    case 'R':
                        this.grillePanel.add(new Case(Color.red));
                        break;
                    case 'P':
                        this.grillePanel.add(new Case(Color.pink));
                        break;
                    case 'G':
                        this.grillePanel.add(new Case(Color.green));
                        break;
                    default:
                        LOGGER.debug("Default case should not happen.");
                        break;
                }
            }
        }
    }

    private JPanel createInfoPanel() {
        JPanel panel = new JPanel();
        this.playerToPlay = new JLabel();
        setPlayerToPlayValue();
        panel.add(playerToPlay);
        return panel;
    }

    private void setPlayerToPlayValue() {
        this.playerToPlay.setText("C'est au tour de " + getControler().getCurrentPlayerName() + " de jouer...");
    }

    private GameController getControler() {
        return this.controler;
    }

    @Override
    public void update(Observable observable, Object arg) {
        this.invalidate();

        setPlayerToPlayValue();
        if (getControler().isFinishWin()) {
            JOptionPane.showMessageDialog(this, "Partie terminée ! Le gagnant est " + getControler().getWinnerName());
            LOGGER.debug("The game is over. " + getControler().getWinnerName() + " won !");
        } else if (getControler().isFinishEquality()) {
            JOptionPane.showMessageDialog(this, "Partie terminée ! Egalité :(");
            LOGGER.debug("The game is over. Equality.");
        }
        drawPlateau();

        this.validate();
        LOGGER.debug("The frame has been successfully updated.");
    }
}
package fr.enssat.poo.vrome.views;

import fr.enssat.poo.vrome.controlers.ApplicationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mnantel on 21/06/16.
 */
public class MainView extends JFrame {

    private static final long serialVersionUID = 7564019879373920333L;

    private final ApplicationController controller;

    public MainView(final ApplicationController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        final JButton playButton = new JButton("Jouer");
        playButton.setPreferredSize(new Dimension(100, 50));

        final JButton dashboardButton = new JButton("Dashboard");
        dashboardButton.setPreferredSize(new Dimension(200, 50));

        JPanel panelLogo = new JPanel();
        JPanel panelButtons = new JPanel();

        playButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                // Pop-up construction
                JSpinner rowsCount = new JSpinner();
                JSpinner columnsCount = new JSpinner();
                rowsCount.setValue(controller.getDefaultRowsCount());
                columnsCount.setValue(controller.getDefaultColumnsCount());
                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Nombre de lignes: "));
                myPanel.add(rowsCount);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("Nombre de colonnes: "));
                myPanel.add(columnsCount);
                myPanel.add(Box.createHorizontalStrut(15));
                myPanel.add(new JLabel("Nombre de joueurs: "));
                String[] joueur = {"2", "3", "4"};
                JComboBox<String> liste_label_joueur = new JComboBox<>(joueur);
                JLabel label_joueur = new JLabel("Nombre de joueur");
                myPanel.add(liste_label_joueur);

                int result = JOptionPane.showConfirmDialog(getCurrentFrame(), myPanel, "Saisir les paramètres de configuration", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    int rows = (int) rowsCount.getValue();
                    int columns = (int) columnsCount.getValue();

                    controller.launchGame(rows, columns);

                    getCurrentFrame().setVisible(false);
                    getCurrentFrame().dispose();
                }
            }
        });

        dashboardButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                // getController().launchDashboard();
                // getCurrentFrame().dispose();
                JOptionPane.showMessageDialog(getCurrentFrame(), "La partie Dashboard n'a pas encore été réalisée !", "Impossible de réaliser l'action", JOptionPane.ERROR_MESSAGE);
            }
        });

        panelLogo.add(new JLabel(new ImageIcon(getClass().getResource("/logo.jpg"))));
        panelButtons.add(playButton);
        panelButtons.add(dashboardButton);

        add(panelLogo, BorderLayout.PAGE_START);
        add(panelButtons, BorderLayout.PAGE_END);

        ViewsUtilities.setGeneralParameters(getCurrentFrame());
    }

    /**
     * @return the current instance of MainView
     */
    public MainView getCurrentFrame() {
        return this;
    }

    public ApplicationController getController() {
        return controller;
    }
}


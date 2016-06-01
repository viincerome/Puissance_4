package fr.enssat.poo.vrome.views;

import fr.enssat.poo.vrome.controlers.ApplicationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class SettingView extends JFrame {

    private ApplicationController controller;

    private JButton start;
    private JButton quitter;

    private String[] Ligne = {"1", "2", "3", "4", "5", "6"};
    private JComboBox liste_label_ligne = new JComboBox(Ligne);
    private JLabel label_ligne = new JLabel("Nombre de ligne");

    private String[] colonne = {"1", "2", "3", "4", "5", "6", "7"};
    private JComboBox liste_label_colonne = new JComboBox(colonne);
    private JLabel label_colonne = new JLabel("Nombre de colonne");

    private String[] joueur = {"2", "3", "4"};
    private JComboBox liste_label_joueur = new JComboBox(joueur);
    private JLabel label_joueur = new JLabel("Nombre de joueur");


    public SettingView(ApplicationController controller) {

        super("Convertir");
        this.controller = controller;
        ViewsUtilities.setGeneralParameters(this);
        this.setSize(500, 150);
        this.setLocationRelativeTo(null);

        this.start = new JButton("Commencer la Partie");
        this.quitter = new JButton("Quitter");

        JPanel ligne = new JPanel();
        ligne.setLayout(new FlowLayout());
        ligne.add(label_ligne);
        ligne.add(liste_label_ligne);

        JPanel colonne = new JPanel();
        colonne.setLayout(new FlowLayout());
        colonne.add(label_colonne);
        colonne.add(liste_label_colonne);

        JPanel participant = new JPanel();
        participant.setLayout(new FlowLayout());
        participant.add(label_joueur);
        participant.add(liste_label_joueur);

        setLayout(new GridLayout(2, 3));
        add(ligne);
        add(colonne);
        add(participant);
        add(start);
        add(quitter);

        liste_label_ligne.setSelectedIndex(5);
        liste_label_colonne.setSelectedIndex(6);

        this.quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
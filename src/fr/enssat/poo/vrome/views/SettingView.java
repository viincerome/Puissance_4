package fr.enssat.poo.vrome.views;

import fr.enssat.poo.vrome.controlers.ApplicationController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class SettingView extends JFrame {

	private static final long serialVersionUID = -2658676059456370329L;
	
    private ApplicationController controler;

    private JButton start;
    private JButton quitter;

    //private String[] Ligne = {"1", "2", "3", "4", "5", "6"};
    //private JComboBox liste_label_ligne = new JComboBox(Ligne);
    private JLabel label_ligne = new JLabel("Nombre de ligne");
  //private JTextField liste_label_ligne = new JTextField(" 6 ");
    private JSpinner liste_label_ligne = new JSpinner();


    //private String[] colonne = {"1", "2", "3", "4", "5", "6", "7"};
    //private JComboBox liste_label_colonne = new JComboBox(colonne);
    private JLabel label_colonne = new JLabel("Nombre de colonne : ");
    //private JTextField liste_label_colonne = new JTextField(" 7 ");
    private JSpinner liste_label_colonne = new JSpinner();
    
    private String[] joueur = {"2", "3", "4"};
    private JComboBox liste_label_joueur = new JComboBox(joueur);
    private JLabel label_joueur = new JLabel("Nombre de joueur");


    public SettingView(ApplicationController controler) {

        super("Puissance 4 - Vincent ROME");
        this.controler = controler;
        ViewsUtilities.setGeneralParameters(this);
        this.setSize(500, 150);
        this.setLocationRelativeTo(null);

        this.start = new JButton("Commencer la Partie");
        this.quitter = new JButton("Quitter");

        JPanel ligne = new JPanel();
        ligne.setLayout(new FlowLayout());
        ligne.add(label_ligne);
        ligne.add(liste_label_ligne);

        //JTextField colonne = new JTextField();
        
        JPanel colonne = new JPanel();
        colonne.setLayout(new FlowLayout());
        colonne.add(label_colonne);
        colonne.add(liste_label_colonne);

        JPanel participant = new JPanel();
        participant.setLayout(new FlowLayout());
        participant.add(label_joueur);
        participant.add(liste_label_joueur);

        this.setLayout(new GridLayout(2, 3));
        this.add(ligne);
        this.add(colonne);
        this.add(participant);
        this.add(start);
        this.add(quitter);

        //liste_label_ligne.setSelectedIndex(5);
        //liste_label_colonne.setSelectedIndex(6);
        liste_label_ligne.setValue(6);
        liste_label_colonne.setValue(7);
        
        this.start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//int col = Integer.parseInt(liste_label_colonne.getToolTipText()); UN TRUC DU GENRE
				JFrame fenetrePlateau = new PlateauView(null);
				JFrame fenetreInfo = new InfoView(null);
				setVisible(false);				
			}
		});

        this.quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        
    }

}
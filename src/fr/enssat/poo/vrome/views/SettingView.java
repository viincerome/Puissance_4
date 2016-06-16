package fr.enssat.poo.vrome.views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import fr.enssat.poo.vrome.controlers.ApplicationController;

public class SettingView extends JFrame {

	private static final long serialVersionUID = -2658676059456370329L;

	private ApplicationController controler;

	private JButton start;
	private JButton quitter;

	private JLabel label_ligne = new JLabel("Nombre de ligne");
	private JSpinner liste_label_ligne = new JSpinner();

	private JLabel label_colonne = new JLabel("Nombre de colonne : ");
	private JSpinner liste_label_colonne = new JSpinner();

	private String[] joueur = { "2", "3", "4" };
	private JComboBox<String> liste_label_joueur = new JComboBox<>(this.joueur);
	private JLabel label_joueur = new JLabel("Nombre de joueur");

	public SettingView(final ApplicationController controler) {

		super("Puissance 4 - Vincent ROME");
		this.controler = controler;
		ViewsUtilities.setGeneralParameters(this);
		this.setSize(500, 150);
		setLocationRelativeTo(null);

		this.start = new JButton("Commencer la Partie");
		this.quitter = new JButton("Quitter");

		JPanel ligne = new JPanel();
		ligne.setLayout(new FlowLayout());
		ligne.add(this.label_ligne);
		ligne.add(this.liste_label_ligne);

		JPanel colonne = new JPanel();
		colonne.setLayout(new FlowLayout());
		colonne.add(this.label_colonne);
		colonne.add(this.liste_label_colonne);

		JPanel participant = new JPanel();
		participant.setLayout(new FlowLayout());
		participant.add(this.label_joueur);
		participant.add(this.liste_label_joueur);

		setLayout(new GridLayout(2, 3));
		this.add(ligne);
		this.add(colonne);
		this.add(participant);
		this.add(this.start);
		this.add(this.quitter);

		// Set default values
		this.liste_label_ligne.setValue(6);
		this.liste_label_colonne.setValue(7);

		this.start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub
				//int col = Integer.parseInt(liste_label_colonne.getToolTipText()); UN TRUC DU GENRE
				JFrame fenetrePlateau = new PlateauView(getControler()); // TODO: faire plusieurs controlleurs ?
				new InfoView(getControler(), fenetrePlateau);
				setVisible(false);
			}
		});

		this.quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private ApplicationController getControler() {
		return this.controler;
	}
}

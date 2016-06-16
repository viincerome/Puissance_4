package fr.enssat.poo.vrome.views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.enssat.poo.vrome.controlers.ApplicationController;

public class InfoView extends JFrame {

	private static final long serialVersionUID = -2658676059456370329L;

	private final ApplicationController controler;

	//4 Label pour nom des joueurs
	private JLabel joueur_1 = new JLabel("Joueur 1");
	private JLabel joueur_2 = new JLabel("Joueur 2");
	private JLabel joueur_3 = new JLabel("Joueur 3");
	private JLabel joueur_4 = new JLabel("Joueur 4");

	private JLabel nb_coup_joue = new JLabel("Nombre de coups jou�s");

	private JButton restart;
	private JButton quitter;

	private JFrame plateauView;

	public InfoView(final ApplicationController controler, final JFrame fenetrePlateau) {
		super("Puissance 4 - Vincent ROME");
		this.controler = controler;
		this.plateauView = fenetrePlateau;
		ViewsUtilities.setGeneralParameters(this);
		this.setBounds(50, 50, 175, 350);

		JPanel joueur1 = new JPanel();
		joueur1.setLayout(new FlowLayout());
		joueur1.add(this.joueur_1);

		JPanel joueur2 = new JPanel();
		joueur2.setLayout(new FlowLayout());
		joueur2.add(this.joueur_2);

		JPanel joueur3 = new JPanel();
		joueur3.setLayout(new FlowLayout());
		joueur3.add(this.joueur_3);

		JPanel joueur4 = new JPanel();
		joueur4.setLayout(new FlowLayout());
		joueur4.add(this.joueur_4);

		JPanel nb_joue = new JPanel();
		nb_joue.setLayout(new FlowLayout());
		nb_joue.add(this.nb_coup_joue);

		this.restart = new JButton("Restart");
		this.quitter = new JButton("Quitter");

		setLayout(new GridLayout(7, 1));
		add(joueur1);
		add(joueur2);
		add(joueur3);
		add(joueur4);
		add(nb_joue);
		add(this.restart);
		add(this.quitter);

		this.quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);
			}
		});

		this.restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				setVisible(false); //Pour le moment efface juste info trouver un moyen d'effacer plateau
				new SettingView(getControler());
				InfoView.this.plateauView.dispose();

			}
		});

	}

	public ApplicationController getControler() {
		return this.controler;
	}

}

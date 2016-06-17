package fr.enssat.poo.vrome.views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.enssat.poo.vrome.controlers.ApplicationController;

public class SettingView extends JFrame {

	private static final long serialVersionUID = -2658676059456370329L;

	private ApplicationController controler;

    private int wantedColumns;
    private int wantedRows;

    private JLabel label_ligne = new JLabel("Nombre de ligne : ");
	private JSpinner spinnerRows = new JSpinner();

	private JLabel label_colonne = new JLabel("Nombre de colonne : ");
	private JSpinner spinnerColumns = new JSpinner();

	private String[] joueur = { "2", "3", "4" };
	private JComboBox<String> liste_label_joueur = new JComboBox<>(this.joueur);
	private JLabel label_joueur = new JLabel("Nombre de joueur");

	public SettingView(final ApplicationController controler) {

		super("Puissance 4 - Vincent ROME");
		this.controler = controler;
        this.wantedRows = controler.getDefaultRowsCount();
        this.wantedColumns = controler.getDefaultColumnsCount();

		this.setSize(500, 150);
		setLocationRelativeTo(null);

		 JButton start = new JButton("Commencer la Partie");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                getControler().startGame(getCurrentFrame().getWantedRows(), getCurrentFrame().getWantedColumns());
               	getCurrentFrame().setVisible(false);
                getCurrentFrame().dispose();
            }
        });

        JButton quitter = new JButton("Quitter");
        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });

		JPanel ligne = new JPanel();
		ligne.setLayout(new FlowLayout());
		ligne.add(this.label_ligne);
		ligne.add(this.spinnerRows);

		JPanel colonne = new JPanel();
		colonne.setLayout(new FlowLayout());
		colonne.add(this.label_colonne);
		colonne.add(this.spinnerColumns);

		JPanel participant = new JPanel();
		participant.setLayout(new FlowLayout());
		participant.add(this.label_joueur);
		participant.add(this.liste_label_joueur);

		setLayout(new GridLayout(2, 3));
		this.add(ligne);
		this.add(colonne);
		this.add(participant);
		this.add(start);
		this.add(quitter);

		// Set default values
		this.spinnerRows.setValue(wantedRows);
        this.spinnerRows.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                getCurrentFrame().wantedRows = (int) getCurrentFrame().spinnerRows.getValue();
            }
        });

		this.spinnerColumns.setValue(wantedColumns);
        this.spinnerColumns.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                getCurrentFrame().wantedColumns = (int) getCurrentFrame().spinnerColumns.getValue();
            }
        });

        ViewsUtilities.setGeneralParameters(this);
    }

    private int getWantedRows() {
        return wantedRows;
    }

    private void setWantedRows(int wantedRows) {
        this.wantedRows = wantedRows;
    }


    private int getWantedColumns() {
        return wantedColumns;
    }

    private void setWantedColumns(int wantedColumns) {
        this.wantedColumns = wantedColumns;
    }

    private SettingView getCurrentFrame() {
        return this;
    }

	private ApplicationController getControler() {
		return this.controler;
	}
}

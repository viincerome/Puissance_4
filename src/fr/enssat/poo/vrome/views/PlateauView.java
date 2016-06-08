package fr.enssat.poo.vrome.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import fr.enssat.poo.vrome.controlers.ApplicationController;

import javax.swing.*;
import javax.swing.text.Position;

public class PlateauView extends JFrame {

    private static final long serialVersionUID = -2658676059456370329L;

    private final ApplicationController controler;
    
    public PlateauView(ApplicationController controler) {
    	super("Puissance 4 - Vincent ROME");
        this.controler = controler;
        this.setSize(750, 500);
        this.setLocationRelativeTo(null);
        
        JPanel plateau = new JPanel();
        plateau.setLayout(new GridLayout(6,7));
		plateau.setSize(400, 350);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				plateau.add(new Case());
			}
		}
		
        JPanel clavier = new JPanel();
        //Revoir la dimension
        
        setLayout(new BorderLayout());
        add(clavier,BorderLayout.NORTH);
        add(plateau, BorderLayout.SOUTH);
      
        
      ViewsUtilities.setGeneralParameters(this);
    }

    public ApplicationController getControler() {
        return controler;
    }

}

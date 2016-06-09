package fr.enssat.poo.vrome.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import fr.enssat.poo.vrome.controlers.ApplicationController;

import javax.swing.*;
import javax.swing.text.Position;

public class PlateauView extends JFrame {

    private static final long serialVersionUID = -2658676059456370329L;

    private final ApplicationController controler;
    
    public PlateauView(ApplicationController controler) {
    	
    	super("Puissance 4 - Vincent ROME");
    	ViewsUtilities.setGeneralParameters(this);
        this.controler = controler;
        this.setSize(420, 420);
       // this.setBounds(300, 150, 900, 500);
        this.setLocationRelativeTo(null);
        
        JPanel plateau = new JPanel();
        plateau.setLayout(new GridLayout(6,7));
		//plateau.setSize(750, 500);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				plateau.add(new Case());
			}
		}
		
        JPanel clavier = new JPanel();
        clavier.setPreferredSize(new Dimension(420,60)); //x --> vers la droite et y --> vers le bas !!!
        //Revoir la proportion
        setLayout(new BorderLayout());
        add(clavier, BorderLayout.NORTH);
        add(plateau, BorderLayout.CENTER);
        
        /*
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.125;
        
        //add(clavier);
        GridBagConstraints p = new GridBagConstraints();
        p.gridx = 0;
        p.gridy = 1;
        p.weighty = 0.875;
        clavier.add(clavier, c);
        plateau.add(plateau, p);*/
        //add(plateau);
        
              
      
    }

    public ApplicationController getControler() {
        return controler;
    }

}

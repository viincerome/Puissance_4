package fr.enssat.poo.vrome.views;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import fr.enssat.poo.vrome.controlers.ApplicationController;

import javax.swing.*;

public class PlateauView extends JFrame {

    private static final long serialVersionUID = -2658676059456370329L;

    private final ApplicationController controler;
    
    private JLabel label_plateau = new JLabel("Plateau");
    private JLabel label_info = new JLabel("Info");

    public PlateauView(ApplicationController controler) {
    	super("Puissance 4 - Vincent ROME");
        this.controler = controler;
        ViewsUtilities.setGeneralParameters(this);
        this.setSize(750, 500);
        this.setLocationRelativeTo(null);
        
        JPanel plateau = new JPanel();
        plateau.setLayout(new FlowLayout());
        plateau.add(label_plateau);
        
        JPanel info = new JPanel();
        info.setLayout(new FlowLayout());
        info.add(label_info);
        
        setLayout(new GridLayout(6,7));
		setSize(400, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				getContentPane().add(new Case());
				
			}
		}
        
    }

    public ApplicationController getControler() {
        return controler;
    }

}

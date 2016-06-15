package fr.enssat.poo.vrome.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.setLocationRelativeTo(null);
        
        /*
        JPanel buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(420,60)); //x --> vers la droite et y --> vers le bas !!!
        buttons.setLayout(new GridLayout(1,7));
        for (int i = 0; i < 7; i++) {
        	
        	//
        	 ActionListener actionListener = new ActionListener(){
      			public void actionPerformed(ActionEvent actionEvent) {
          			System.out.println(actionEvent.getActionCommand());
      			}
    		};
        	//

        	buttons.add((new JButton(""+ i)));
        }
        
        JPanel plateau = new JPanel();
        plateau.setLayout(new GridLayout(6,7)); // 6 lignes 7 colonnes
		//plateau.setSize(750, 500);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				plateau.add(new Case());
			}
		}
		
		setLayout(new BorderLayout());
        add(buttons, BorderLayout.NORTH);
        add(plateau, BorderLayout.CENTER);
		*/
                
        JPanel plateau = new JPanel();
        plateau.setPreferredSize(new Dimension(420,60));
        plateau.setLayout(new GridLayout(7,7));
        int x = 0;
        for (x = 0; x < 7; x++) {
        	plateau.add((new JButton(""+ x)));
			
		}
        for (x = 1; x < 7; x++) {
			for (int j = 0; j < 7; j++) {
				plateau.add(new Case());
			}
		}
		
        //System.out.println(plateau.getComponentCount() + plateau[0]);
        
        setLayout(new BorderLayout());
        add(plateau, BorderLayout.CENTER);
        
    }

    public ApplicationController getControler() {
        return controler;
    }

}

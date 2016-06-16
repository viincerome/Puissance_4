package fr.enssat.poo.vrome.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import fr.enssat.poo.vrome.controlers.ApplicationController;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;

public class PlateauView extends JFrame {

    private static final long serialVersionUID = -2658676059456370329L;

    private Logger LOGGER = new SystemOutLogger(PlateauView.class);

    private final ApplicationController controler;
    
    public PlateauView(ApplicationController controler) {
    	
    	super("Puissance 4 - Vincent ROME");
        this.controler = controler;
        this.setSize(420, 420);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        /*
        JPanel buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(420,60)); //x --> vers la droite et y --> vers le bas !!!
        buttons.setLayout(new GridLayout(1,7));
        for (int i = 0; i < 7; i++) {
        	
        	//
        	 ActionListener actionListener = new ActionListener(){
      			public void actionPerformed(ActionEvent actionEvent) {
          			//System.out.println(actionEvent.getActionCommand());
          			
          			// Appel du controleur (getter pour le récupérer car là on est dans une classe ActionListener)
          			getController().addPion(numero colonne du bouton);
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
           
        JButton[] buttons = new JButton[7];
        JPanel plateau = new JPanel();
        plateau.setPreferredSize(new Dimension(420,60));
        plateau.setLayout(new GridLayout(7,7));

        for (int counter = 0; counter < 7; counter++) { // TODO: 7 should not be hardcoded
            final int colonne = counter; // Javadoc: any local variable, used but not declared in an inner class must be definitely assigned before the body of the inner class.

        	buttons[colonne] = new JButton(Integer.toString(colonne));
        	buttons[colonne].addActionListener(new ActionListener(){
        		public void actionPerformed(ActionEvent e)
        		{
                    LOGGER.debug("Demande de placer un pion sur le plateau sur la colonne " + colonne + " par l'interface graphique.");
        			getControler().playPion(colonne);
        		}
        	});

            plateau.add(buttons[colonne]);
		}

        drawPlateau(plateau);
        this.add(plateau);

        ViewsUtilities.setGeneralParameters(this);
    }

    private void drawPlateau(JPanel plateau) {
        for (int x = 1; x < 7; x++) { // TODO: 7 should not be hardcoded
			for (int j = 0; j < 7; j++) {
				plateau.add(new Case());
			}
		}
    }

    private ApplicationController getControler() {
        assert controler != null;
        return controler;
    }

}

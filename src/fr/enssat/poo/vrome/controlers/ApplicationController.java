package fr.enssat.poo.vrome.controlers;

import fr.enssat.poo.vrome.models.Player;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;
import fr.enssat.poo.vrome.models.Game;
import fr.enssat.poo.vrome.models.entities.Pion;
import fr.enssat.poo.vrome.models.entities.PionColor;
import fr.enssat.poo.vrome.views.SettingView;

public class ApplicationController {

    private Logger LOGGER = new SystemOutLogger(ApplicationController.class);

    private Game modele;
    private Player currentPlayer;

    public ApplicationController() {
        this.modele = new Game(6, 7);
    }

    public void launch() {

        // Pour le moment, on ne gere que le cas d'une nouvelle partie entre 2 joueurs
    	this.modele.getPlateau().afficherPlateau();

        // TODO
        this.currentPlayer = new Player("Gertrude", PionColor.PURPLE);


      //  Pion premierPionJaune = new Pion(PionColor.YELLOW);
        
        //this.modele.afficherPlateau();
      //  System.out.println(this.modele.getGameStatus());
    //    this.modele.getPlateau().addPion(premierPionJaune, 0, 2);
     //   this.modele.getPlateau().addPion(premierPionJaune, 0, 3);
      //  this.modele.getPlateau().addPion(premierPionJaune, 0, 4);
       // this.modele.getPlateau().addPion(premierPionJaune, 0, 1);
       // this.modele.getPlateau().afficherPlateau();
       // System.out.println(this.modele.getGameStatus());
       // this.modele.updateGameStatus();
       // System.out.println(this.modele.getGameStatus());

        
        /*Pion premierPionRouge = new Pion(PionColor.RED);
        this.modele.addPion(premierPionRouge, 0, 1);
        this.modele.afficherPlateau();*/

        LOGGER.debug("Starting the app");
        new SettingView(this);
    }

    public boolean playPion(int columnIndex) {
        try {
            this.modele.getPlateau().addPion(new Pion(currentPlayer.getPionColor()), 0, columnIndex);
            //TODO: update current player
            this.modele.getPlateau().afficherPlateau();
            return true;
        } catch (Exception e) { // TODO catch more precise exception
            e.printStackTrace();
            return false;
        }
    }
    
    //method ajouter Pion(numero colonne) {
        //-> vérification des coordonnées (vérifier que le numéro de colonne est bien valide par rapport à la taille du plateau)
        
        //this.modele.addPion(0,colonne)

}

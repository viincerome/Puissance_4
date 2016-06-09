package fr.enssat.poo.vrome.controlers;

import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;
import fr.enssat.poo.vrome.models.Game;
import fr.enssat.poo.vrome.models.Plateau;
import fr.enssat.poo.vrome.models.entities.Pion;
import fr.enssat.poo.vrome.models.entities.PionColor;

public class ApplicationController {

    private Logger LOGGER = new SystemOutLogger(ApplicationController.class);

    private Game modele;

    public ApplicationController() {
        this.modele = new Game(6, 7);
    }

    public void launch() {

        // Pour le moment, on ne g�re que le cas d'une nouvelle partie entre 2 joueurs
    	this.modele.getPlateau().afficherPlateau();

        Pion premierPionJaune = new Pion(PionColor.YELLOW);
        
        //this.modele.afficherPlateau();
        System.out.println(this.modele.getGameStatus());
        this.modele.getPlateau().addPion(premierPionJaune, 0, 2);
        this.modele.getPlateau().addPion(premierPionJaune, 0, 3);
        this.modele.getPlateau().addPion(premierPionJaune, 0, 1);
        this.modele.getPlateau().addPion(premierPionJaune, 0, 4);
        this.modele.getPlateau().afficherPlateau();      
        System.out.println(this.modele.getGameStatus());
        this.modele.updateGameStatus();
        System.out.println(this.modele.getGameStatus());

        
        /*Pion premierPionRouge = new Pion(PionColor.RED);
        this.modele.addPion(premierPionRouge, 0, 1);
        this.modele.afficherPlateau();*/

        LOGGER.debug("Starting the app");
        //new SettingView(this);
    }
}
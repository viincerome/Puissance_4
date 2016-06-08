package fr.enssat.poo.vrome.controlers;

import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;
import fr.enssat.poo.vrome.models.PlateauMaelig;
import fr.enssat.poo.vrome.models.entities.Pion;
import fr.enssat.poo.vrome.models.entities.PionColor;

public class ApplicationController {

    private Logger LOGGER = new SystemOutLogger(ApplicationController.class);

    private PlateauMaelig modele;

    public ApplicationController() {
        this.modele = new PlateauMaelig(6, 7);
    }

    public void launch() {

        // Pour le moment, on ne gère que le cas d'une nouvelle partie entre 2 joueurs
    	this.modele.afficherPlateau();

        Pion premierPionJaune = new Pion(PionColor.YELLOW);
        this.modele.addPion(premierPionJaune, 0, 1);
        //this.modele.afficherPlateau();
        this.modele.addPion(premierPionJaune, 0, 1);
        //this.modele.afficherPlateau();

        Pion premierPionRouge = new Pion(PionColor.RED);
        this.modele.addPion(premierPionRouge, 0, 3);
        this.modele.afficherPlateau();

        LOGGER.debug("Starting the app");
        //new SettingView(this);
    }
}
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
        this.modele = new PlateauMaelig(7, 8);
    }

    public void launch() {

        // Pour le moment, one gère que le cas d'une nouvelle partie entre 2 joueurs
//        this.modele.afficherPlateau();

        Pion premierPionBleu = new Pion(PionColor.BLUE);
        this.modele.addPion(premierPionBleu, 0, 1);
        this.modele.afficherPlateau();

        LOGGER.debug("Starting the app");
        //new SettingView(this);
    }
}
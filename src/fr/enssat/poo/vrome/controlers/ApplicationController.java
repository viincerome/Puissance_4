package fr.enssat.poo.vrome.controlers;

import fr.enssat.poo.vrome.models.Player;
import fr.enssat.poo.vrome.models.entities.PionColor;
import fr.enssat.poo.vrome.models.save.PlayerRepository;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;
import fr.enssat.poo.vrome.views.DashboardView;
import fr.enssat.poo.vrome.views.MainView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main controller of the application. It make the link between the game and the dashboard.
 */
public class ApplicationController {

    private Logger LOGGER = new SystemOutLogger(ApplicationController.class);

    public void launch() {
        this.LOGGER.debug("Starting the app");
        new MainView(this);
    }

    /**
     * Start the game.
     *
     * @param rows    number of rows for the new game
     * @param columns number of columns for the new game
     */
    public void launchGame(int rows, int columns) {
        // TODO: Construire les objets joueurs à partir d'informations récupérées de la vue (pseudo, couleur de jetons...)
        // Il faut faire une pop-up ou autre pour pouvoir choisir un joueur éxistant (voir en dessous) ou en créer un nouveau
        List<Player> players = new ArrayList<>();
        Player player1 = new Player("Huguette", PionColor.YELLOW);
        Player player2 = new Player("Raymond", PionColor.GREEN);
        players.add(player1);
        players.add(player2);

        // -----------------------------------------------------------------------------------------
        //TODO: Test pour vérifier qu'on sait correctement sauvegarder et charger un joueur

        try {
            PlayerRepository.save(player1);
            LOGGER.debug("Player saved !");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Player playerLoaded = PlayerRepository.load(player1.getName());
        LOGGER.debug("Loaded player name = " + playerLoaded.getName());
        // -----------------------------------------------------------------------------------------

        new GameController().launch(rows, columns, players);
    }

    public int getDefaultRowsCount() {
        return 6; // Donné dans le sujet
    }

    public int getDefaultColumnsCount() {
        return 7; // Donné dans le sujet
    }

    /**
     * Start the dashboard. TODO: Not implemented yet !
     */
    public void launchDashboard() {
        new DashboardView(new DashboardController());
    }
}
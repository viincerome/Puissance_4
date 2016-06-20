package fr.enssat.poo.vrome.controlers;

import java.util.ArrayList;
import java.util.List;

import fr.enssat.poo.vrome.models.Player;
import fr.enssat.poo.vrome.models.entities.PionColor;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;
import fr.enssat.poo.vrome.views.SettingView;

public class ApplicationController {

    private Logger LOGGER = new SystemOutLogger(ApplicationController.class);

	public void launch() {
		this.LOGGER.debug("Starting the app");
		new SettingView(this);
	}

    public void startGame(int rows, int columns){
        List<Player> players = new ArrayList<>();
        // TODO: Construire les objets joueurs à partir d'informations récupérées de la vue (pseudo, couleur de jetons...)

        Player player1 = new Player("Huguette", PionColor.YELLOW);
        Player player2 = new Player("Raymond", PionColor.GREEN);
        players.add(player1);
        players.add(player2);
        new GameController().launch(rows, columns, players);
    }

    public int getDefaultRowsCount(){
        return 6;
    }

    public int getDefaultColumnsCount(){
        return 7;
    }

}
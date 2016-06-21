package fr.enssat.poo.vrome.controlers;

import fr.enssat.poo.vrome.models.Game;
import fr.enssat.poo.vrome.models.Player;
import fr.enssat.poo.vrome.models.entities.GameState;
import fr.enssat.poo.vrome.models.entities.Pion;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;
import fr.enssat.poo.vrome.views.PlateauView;

import java.util.List;

public class GameController {

    private Logger LOGGER = new SystemOutLogger(GameController.class);

    private Game modele;

    private List<Player> players;
    private Player currentPlayer;
    private int currentPlayerId;

    private int rows;
    private int columns;

    public boolean playPion(final int columnIndex) {
        checkGameStatus();
        try {
            this.modele.getPlateau().addPion(new Pion(this.currentPlayer.getPionColor()), 0, columnIndex);
            updateCurrentPlayer();
            this.modele.getPlateau().afficherPlateau();
            return true;
        } catch (Exception e) { // TODO catch more precise exception
            e.printStackTrace();
            return false;
        }
    }

    private void checkGameStatus() {
        System.out.println("game status -> " + this.modele.getGameStatus());
        if (this.modele.getGameStatus() != GameState.PENDING) {
            throw new GameFinishedException();
        }
    }

    public int getColumns() {
        return this.columns;
    }

    public int getRows() {
        return this.rows;
    }

    public void launch(int rows, int columns, List<Player> players) {
        this.modele = new Game(rows, columns);
        this.rows = rows;
        this.columns = columns;
        this.players = players;
        this.currentPlayerId = 0;
        this.currentPlayer = players.get(currentPlayerId);
        new PlateauView(this);
    }

    public void updateCurrentPlayer() {
        try {
            this.currentPlayerId++;
            players.get(this.currentPlayerId);
        } catch (IndexOutOfBoundsException e) {
            this.currentPlayerId = 0;
        }
        this.currentPlayer = players.get(currentPlayerId);
    }

    public String getCurrentPlayerName() {
        return this.currentPlayer.getName();
    }

}
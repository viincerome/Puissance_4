package fr.enssat.poo.vrome.controlers;

import fr.enssat.poo.vrome.models.Game;
import fr.enssat.poo.vrome.models.Player;
import fr.enssat.poo.vrome.models.entities.GameState;
import fr.enssat.poo.vrome.models.entities.Pion;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;
import fr.enssat.poo.vrome.views.GameView;

import java.util.List;
import java.util.Observer;

public class GameController {

    private Logger LOGGER = new SystemOutLogger(GameController.class);

    private Game modele;

    private List<Player> players;
    private Player currentPlayer;
    private int currentPlayerId;
    private String winnerName = null;

    private int rows;
    private int columns;

    public void playPion(final int columnIndex) {
        checkGameStatus();
        try {
            this.modele.getPlateau().addPion(new Pion(this.currentPlayer.getPionColor()), 0, columnIndex);
            checkGameStatus(); // Don't update the player if the game is finished, in order to get the winner !
            updateCurrentPlayer();
            this.modele.getPlateau().afficherPlateau();
        } catch (GameFinishedException e) { // TODO catch more precise exception
            this.winnerName = this.getCurrentPlayerName();
        }
    }

    public boolean isFinishWin() {
        return this.modele.getGameStatus() == GameState.FINISH_WIN;
    }

    public boolean isFinishEquality() {
        return this.modele.getGameStatus() == GameState.FINISH_EQUALITY;
    }

    /**
     * @return the name of the player that won the game or null if there is no winner.
     */
    public String getWinnerName() {
        return winnerName;
    }

    private void checkGameStatus() {
        LOGGER.debug("The game status is : " + this.modele.getGameStatus());
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
        new GameView(this);
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

    public char getContentAt(int x, int y) {
        return this.modele.getPlateau().getContentAt(x, y).getRepresentation();
    }

    public void registerObserver(Observer observer) {
        this.modele.getPlateau().addObserver(observer);
    }

}
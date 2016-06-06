package fr.enssat.poo.vrome.models;

import fr.enssat.poo.vrome.models.entities.GameState;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;

/**
 * Main model class to access the game.
 */
public class Game {
    private Logger LOGGER = new SystemOutLogger(Game.class);

    private static final int PIONS_ALIGNMENT_TO_WIN = 4;
    private PlateauMaelig plateau;
    private GameState gameState;

    public Game(int rows, int columns) {
        this.plateau = new PlateauMaelig(rows, columns);
        this.gameState = GameState.PENDING;
    }

    public void updateGameStatus() {
        if (plateau.haveHorizontalSerie(PIONS_ALIGNMENT_TO_WIN) || plateau.haveVerticalSerie(PIONS_ALIGNMENT_TO_WIN) || plateau.haveDiagonalRightSerie(PIONS_ALIGNMENT_TO_WIN) || plateau.haveDiagonalLeftSerie(PIONS_ALIGNMENT_TO_WIN)) {
            this.gameState = GameState.FINISH_WIN; // TODO: add a mechanism to get the winner
        }

        if (!plateau.haveEmptyPlace()) {
            this.gameState = GameState.FINISH_EQUALITY;
        }
    }

}

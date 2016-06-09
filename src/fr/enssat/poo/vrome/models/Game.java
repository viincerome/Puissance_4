package fr.enssat.poo.vrome.models;

import fr.enssat.poo.vrome.models.entities.GameState;
import fr.enssat.poo.vrome.utilities.Direction;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;

/**
 * Main model class to access the game.
 */
public class Game {
    private static final int PIONS_ALIGNMENT_TO_WIN = 4;

    private final Plateau plateau;
    private GameState gameState;

    public Game(int rows, int columns) {
        this.plateau = new Plateau(rows, columns);
        this.gameState = GameState.PENDING;
    }

    public void updateGameStatus() {
        for (Direction direction : Direction.values()) {
            if (this.plateau.haveSerie(direction, PIONS_ALIGNMENT_TO_WIN)) {
                this.gameState = GameState.FINISH_WIN; // TODO: add a mechanism to get the winner
            }
        }

        if (!plateau.haveEmptyPlace()) {
            this.gameState = GameState.FINISH_EQUALITY;
        }
    }

	public Plateau getPlateau() {
		return plateau;
	}

	public GameState getGameStatus() {
		return this.gameState;
	}
    
    

}

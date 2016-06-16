package fr.enssat.poo.vrome.models;

import fr.enssat.poo.vrome.models.entities.GameState;
import fr.enssat.poo.vrome.utilities.Direction;

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

	public GameState getGameStatus() {
		return this.gameState;
	}

	public Plateau getPlateau() {
		return this.plateau;
	}

	public void updateGameStatus() {
		//    for (Direction direction : Direction.values()) {
		//       if (this.plateau.haveSerie(direction, PIONS_ALIGNMENT_TO_WIN)) {
		//          this.gameState = GameState.FINISH_WIN;
		//     }
		//}
		if ( this.plateau.haveSerie(Direction.RIGHT, PIONS_ALIGNMENT_TO_WIN) ) {
			this.gameState = GameState.FINISH_WIN;
		}

		if ( !this.plateau.haveEmptyPlace() ) {
			this.gameState = GameState.FINISH_EQUALITY;
		}
	}

}

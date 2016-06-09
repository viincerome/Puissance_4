package fr.enssat.poo.vrome.models;

import fr.enssat.poo.vrome.models.entities.EmptyPlace;
import fr.enssat.poo.vrome.models.entities.GameEntity;
import fr.enssat.poo.vrome.models.entities.Pion;
import fr.enssat.poo.vrome.models.exceptions.CoordsException;
import fr.enssat.poo.vrome.models.matrix.GameEntityMatrix;
import fr.enssat.poo.vrome.models.matrix.GameEntityMatrix2DArrayImpl;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;

public class Plateau {

	private Logger LOGGER = new SystemOutLogger(Plateau.class);

	private GameEntityMatrix grille;
	private Pion lastPlayedPion; // Dernier pion plac� sur le plateau

	// ==============
	// INITIALISATION
	// ==============

	public Plateau(final int columns, final int rows) {
		this.grille = new GameEntityMatrix2DArrayImpl(columns, rows);
		init();
	}

	private void init() {
		final int rowsCount = this.grille.getRowsCount();
		final int columnsCount = this.grille.getColumnsCount();

		for ( int i = 0; i < rowsCount; i++ ) {
			for ( int j = 0; j < columnsCount; j++ ) {
				this.grille.setContentAt(i, j, new EmptyPlace());
			}
		}
		LOGGER.debug("La grille de taille " + rowsCount + "x" + columnsCount + " a bien ete initialisee avec des cases vides");
	}

	// ================
	// PIONS MANAGEMENT
	// ================

	// TODO: not tested yet
	public void addPion(final Pion pion, final int x, final int y) {
		if ( x != 0 || !isValidCoords(x, y) ) {
			throw new CoordsException("On ne peux ajouter un pion que sur la premiÃ¨re ligne !");
		}

		if ( !(getEntityBelow(x, y) instanceof EmptyPlace) ) {
			throw new RuntimeException("On ne peux placer un pion que sur une colonne ayant au moins une place"); // TODO: Create a more explicit exception
		}

		this.grille.setContentAt(x, y, pion);
		updatePionPosition(pion, x, y);
		this.lastPlayedPion = pion;
	}

	private void updatePionPosition(final Pion pion, int x, final int y) {
		while ( isValidCoords(x, y) && getEntityBelow(x, y) instanceof EmptyPlace ) {
			this.grille.setContentAt(x, y, new EmptyPlace());
			x = x + 1; // FIXME: parameter should not be assigned
			this.grille.setContentAt(x, y, pion);
		}
		pion.setX(x);
		pion.setY(y);
	}

	public boolean haveHorizontalRightSerie(final int count) { // count =4
		// Regarder � droite et � gauche � partir du dernier pion pos�
		// getEntityOnRight
		GameEntity entityRight = getNeighboringEntity(Direction.RIGHT, lastPlayedPion.getX(), lastPlayedPion.getY());
		for ( int i = 0; i < count; i++ ) {
			if ( entityRight instanceof EmptyPlace ) { //EmptyPlace = du vide
				return false;
			} // Forc�ment un Pion
			Pion pionRight = (Pion) entityRight; //Cast car on avait d��clar� une gameemtity
			if ( pionRight.getColor() != lastPlayedPion.getColor() ) {
				return false;
			}
			// A ce niveau l�, le pionRight est un pion de la m�me couleur que le dernier jou�
			entityRight = getNeighboringEntity(Direction.RIGHT, pionRight.getX(), pionRight.getY());
		}
		return true;

	}

	private GameEntity getNeighboringEntity(final Direction direction, final int x, final int y) {
		switch ( direction ) {
			case ABOVE :
				return this.grille.getContentAt(x - 1, y);
			case ABOVE_LEFT :
				return this.grille.getContentAt(x - 1, y - 1);
			case ABOVE_RIGHT :
				return this.grille.getContentAt(x - 1, y + 1);
			case BELOW :
				return this.grille.getContentAt(x + 1, y);
			case BELOW_LEFT :
				return this.grille.getContentAt(x + 1, y - 1);
			case BELOW_RIGHT :
				return this.grille.getContentAt(x + 1, y + 1);
			case LEFT :
				return this.grille.getContentAt(x, y - 1);
			case RIGHT :
				return this.grille.getContentAt(x, y + 1);
			default :
				assert false;
				return null;
		}
	}

	public boolean haveSerie(final int serieSize) {
		boolean find = false;
		for ( Direction direction : Direction.values() ) {
			//TODO
		}
		return false; //FIXME
	}

	public boolean haveVerticalSerie(final int count) {
		/*
		 * if(){ if (grille.getContentAt(count-1,count) instanceof Pion) { Pion
		 * pionRight = (Pion) grille.getContentAt(count-1,count);
		 * 
		 * } return true; }else{ return false; }
		 */
		return false;
	}// TODO

	public boolean haveDiagonalRightSerie(final int count) {
		/*
		 * if(){ if (grille.getContentAt(count-1,count) instanceof Pion) { Pion
		 * pionRight = (Pion) grille.getContentAt(count-1,count);
		 * 
		 * } return true; }else{ return false; }
		 */
		return false;
	}// TODO

	public boolean haveDiagonalLeftSerie(final int count) {
		/*
		 * if(){ if (grille.getContentAt(count-1,count) instanceof Pion) { Pion
		 * pionRight = (Pion) grille.getContentAt(count-1,count);
		 * 
		 * } return true; }else{ return false; }
		 */
		return false;
	}// TODO

	public boolean haveEmptyPlace() {
		return false;
	}// TODO

	// ======================
	// COORDINATES MANAGEMENT
	// ======================

	private boolean isValidCoords(final int x, final int y) {
		boolean validX = !(x < 0 || x >= this.grille.getRowsCount() - 1);
		boolean validY = !(y < 0 || y >= this.grille.getColumnsCount() - 1);
		return validX && validY;
	}

	// =============================
	// DEVELOPMENT / DEBUG UTILITIES
	// =============================

	public void afficherPlateau() {
		this.grille.display();
	}
}

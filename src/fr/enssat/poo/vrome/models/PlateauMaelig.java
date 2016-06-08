package fr.enssat.poo.vrome.models;

import fr.enssat.poo.vrome.models.entities.GameEntity;
import fr.enssat.poo.vrome.models.entities.GameState;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;
import fr.enssat.poo.vrome.models.entities.EmptyPlace;
import fr.enssat.poo.vrome.models.entities.Pion;
import fr.enssat.poo.vrome.models.exceptions.CoordsException;
import fr.enssat.poo.vrome.models.matrix.GameEntityMatrix;
import fr.enssat.poo.vrome.models.matrix.GameEntityMatrix2DArrayImpl;

public class PlateauMaelig {

	private Logger LOGGER = new SystemOutLogger(PlateauMaelig.class);

	private GameEntityMatrix grille;
	private Pion lastPlayedPion; // Dernier pion placé sur le plateau

	// ==============
	// INITIALISATION
	// ==============

	public PlateauMaelig(int columns, int rows) {
		this.grille = new GameEntityMatrix2DArrayImpl(columns, rows);
		init();
	}

	private void init() {
		final int rowsCount = this.grille.getRowsCount();
		final int columnsCount = this.grille.getColumnsCount();

		for (int i = 0; i < rowsCount; i++) {
			for (int j = 0; j < columnsCount; j++) {
				this.grille.setContentAt(i, j, new EmptyPlace());
			}
		}
		LOGGER.debug("La grille de taille " + rowsCount + "x" + columnsCount
				+ " a bien ete initialisee avec des cases vides");
	}

	// ================
	// PIONS MANAGEMENT
	// ================

	// TODO: not tested yet
	public void addPion(Pion pion, int x, int y) {
		if (x != 0 || !isValidCoords(x, y)) {
			throw new CoordsException(
					"On ne peux ajouter un pion que sur la premiÃƒÂ¨re ligne !");
		}

		if (!(getEntityBelow(x, y) instanceof EmptyPlace)) {
			throw new RuntimeException(
					"On ne peux placer un pion que sur une colonne ayant au moins une place"); // TODO:
																								// Create
																								// a
																								// more
																								// explicit
																								// exception
		}

		this.grille.setContentAt(x, y, pion);
		updatePionPosition(pion, x, y);
		this.lastPlayedPion = pion;
	}

	private void updatePionPosition(Pion pion, int x, int y) {
		while (isValidCoords(x, y)
				&& getEntityBelow(x, y) instanceof EmptyPlace) {
			this.grille.setContentAt(x, y, new EmptyPlace());
			x = x + 1; // FIXME: parameter should not be assigned
			this.grille.setContentAt(x, y, pion);
		}
		pion.setX(x);
		pion.setY(y);
	}

	// ======================
	// NEIGHTBORING ENTITIES
	// ======================

	public GameEntity getEntityBelow(final int x, final int y) {
		return this.grille.getContentAt(x + 1, y);
	}

	public GameEntity getEntityAbove(final int x, final int y) {
		return this.grille.getContentAt(x - 1, y);
	}

	public GameEntity getEntityOnRight(final int x, final int y) {
		return this.grille.getContentAt(x, y + 1);
	}

	public GameEntity getEntityOnLeft(final int x, final int y) {
		return this.grille.getContentAt(x, y - 1);
	}

	public GameEntity getEntityBelowRight(final int x, final int y) {
		return this.grille.getContentAt(x + 1, y + 1);
	}

	public GameEntity getEntityBelowLeft(final int x, final int y) {
		return this.grille.getContentAt(x + 1, y - 1);
	}

	public GameEntity getEntityAboveRight(final int x, final int y) {
		return this.grille.getContentAt(x - 1, y + 1);
	}

	public GameEntity getEntityAboveLeft(final int x, final int y) {
		return this.grille.getContentAt(x - 1, y - 1);
	}

	//
	//

	/*
	 * -> Recuperer la GameEntity qui est a  cote dans la bonne direction
	 * (getContentAt en ajustant les coords). -> C'est un pion ou pas ?
	 * (instanceof Pion true ? false ?) -> Si pas pion : return false -> Si pion
	 * : regarder la couleur -> Faire ca pour 4 distances
	 */
	public boolean haveHorizontalRightSerie(int count) { // count =4
		// Regarder à droite et à gauche à partir du dernier pion posé
		// getEntityOnRight
		GameEntity entityRight = getEntityOnRight(lastPlayedPion.getX(), lastPlayedPion.getY());
		for (int i = 0; i < count; i++) {
			if (entityRight instanceof EmptyPlace) {	//EmptyPlace = du vide
				return false;
			} // Forcément un Pion
			Pion pionRight = ((Pion) entityRight);	//Cast car on avait dééclaré une gameemtity
			if (pionRight.getColor() != lastPlayedPion.getColor()) {
				return false;
			}
			// A ce niveau là, le pionRight est un pion de la même couleur que le dernier joué
			entityRight = getEntityOnRight(pionRight.getX(), pionRight.getY());
		}
		return true;
	}

	public boolean haveVerticalSerie(int count) {
		/*
		 * if(){ if (grille.getContentAt(count-1,count) instanceof Pion) { Pion
		 * pionRight = (Pion) grille.getContentAt(count-1,count);
		 * 
		 * } return true; }else{ return false; }
		 */
		return false;
	}// TODO

	public boolean haveDiagonalRightSerie(int count) {
		/*
		 * if(){ if (grille.getContentAt(count-1,count) instanceof Pion) { Pion
		 * pionRight = (Pion) grille.getContentAt(count-1,count);
		 * 
		 * } return true; }else{ return false; }
		 */
		return false;
	}// TODO

	public boolean haveDiagonalLeftSerie(int count) {
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

	private boolean isValidCoords(int x, int y) {
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

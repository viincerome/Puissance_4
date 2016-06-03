package fr.enssat.poo.vrome.models;

import fr.enssat.poo.vrome.models.entities.GameEntity;
import fr.enssat.poo.vrome.models.entities.GameState;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;
import fr.enssat.poo.vrome.models.entities.EmptyPlace;
import fr.enssat.poo.vrome.models.entities.Pion;
import fr.enssat.poo.vrome.models.matrix.GameEntityMatrix;
import fr.enssat.poo.vrome.models.matrix.GameEntityMatrix2DArrayImpl;

public class PlateauMaelig {

    private Logger LOGGER = new SystemOutLogger(PlateauMaelig.class);

    private GameEntityMatrix grille;
    private GameState state;

    public PlateauMaelig(int columns, int rows) {
        this.grille = new GameEntityMatrix2DArrayImpl(columns, rows);
        init();
        this.state = GameState.PENDING;
    }

    private void init() {
        final int rowsCount = this.grille.getRowsCount();
        final int columnsCount = this.grille.getColumnsCount();

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                this.grille.setContentAt(i, j, new EmptyPlace());
            }
        }
        LOGGER.debug("La grille de taille " + rowsCount + "x" + columnsCount + " a bien été initialisée avec des cases vides");
    }

    public void afficherPlateau() {
        this.grille.display();
    }

    public void addPion(Pion pion, int x, int y) {
        // TODO: Vérifier les coords (on ne peut ajouter que sur la première ligne d'une colonne non pleine
        this.grille.setContentAt(x, y, pion);
        updatePionPosition(pion, x, y);
    }

    private void updatePionPosition(Pion pion, int x, int y) {
        while (isValidCoords(x,y) && getEntityBelow(x, y) instanceof EmptyPlace) {
                this.grille.setContentAt(x, y, new EmptyPlace());
                x = x + 1;
                this.grille.setContentAt(x, y, pion);
        }
    }

    private GameEntity getEntityBelow(int x, int y) {
        return this.grille.getContentAt(x + 1, y);
    }


    private boolean isValidCoords(int x, int y) {
        boolean validX = ! (x < 0 || x >= this.grille.getRowsCount()-1);
        boolean validY = !(y < 0 || y >= this.grille.getColumnsCount()-1);
        return validX && validY;
    }

}

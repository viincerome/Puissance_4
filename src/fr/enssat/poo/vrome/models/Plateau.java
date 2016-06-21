package fr.enssat.poo.vrome.models;

import fr.enssat.poo.vrome.models.entities.EmptyPlace;
import fr.enssat.poo.vrome.models.entities.GameEntity;
import fr.enssat.poo.vrome.models.entities.Pion;
import fr.enssat.poo.vrome.models.exceptions.CoordsException;
import fr.enssat.poo.vrome.models.matrix.GameEntityMatrix;
import fr.enssat.poo.vrome.models.matrix.GameEntityMatrix2DArrayImpl;
import fr.enssat.poo.vrome.utilities.Direction;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;

import java.util.Observable;

public class Plateau extends Observable {

    private Logger LOGGER = new SystemOutLogger(Plateau.class);

    private GameEntityMatrix grille;
    private Pion lastPlayedPion;

    // ==============
    // INITIALISATION
    // ==============

    public Plateau(final int columns, final int rows) {
        this.grille = new GameEntityMatrix2DArrayImpl(columns, rows);
        init();
    }

    public void addPion(final Pion pion, final int x, final int y) {
        if (x != 0 || !isValidCoords(x, y)) {
            throw new CoordsException("On ne peux ajouter un pion que sur la premiere ligne !");
        }

        if (!(getNeighboringEntity(Direction.BELOW, x - 1, y) instanceof EmptyPlace)) {
            throw new RuntimeException("On ne peux placer un pion que sur une colonne ayant au moins une place"); // TODO: Create a more explicit exception
        }

        this.grille.setContentAt(x, y, pion);
        updatePionPosition(pion, x, y);
        this.lastPlayedPion = pion;
    }

    // ================
    // PIONS MANAGEMENT
    // ================

    public void afficherPlateau() {
        this.grille.display();
    }

    private GameEntity getNeighboringEntity(final Direction direction, final int x, final int y) {
        switch (direction) {
            case ABOVE:
                return this.grille.getContentAt(x - 1, y);
            case ABOVE_LEFT:
                return this.grille.getContentAt(x - 1, y - 1);
            case ABOVE_RIGHT:
                return this.grille.getContentAt(x - 1, y + 1);
            case BELOW:
                return this.grille.getContentAt(x + 1, y);
            case BELOW_LEFT:
                return this.grille.getContentAt(x + 1, y - 1);
            case BELOW_RIGHT:
                return this.grille.getContentAt(x + 1, y + 1);
            case LEFT:
                return this.grille.getContentAt(x, y - 1);
            case RIGHT:
                return this.grille.getContentAt(x, y + 1);
            default:
                return null;
        }
    }

    public boolean haveEmptyPlace() {
        for (int columnIndex = 0; columnIndex <= this.grille.getColumnsCount(); columnIndex++) {
            if (this.grille.getContentAt(0, columnIndex) instanceof EmptyPlace) {
                return true;
            }
        }
        return false;
    }

    public boolean haveSerie(final Direction direction, final int serieSize) {
        if (lastPlayedPion == null) {
            return false;
        }
        GameEntity neighbor = getNeighboringEntity(direction, this.lastPlayedPion.getX(), this.lastPlayedPion.getY());
        for (int i = 0; i < serieSize; i++) {
            if (neighbor instanceof EmptyPlace) {
                return false;
            }
            Pion neighborPion = (Pion) neighbor;
            if (neighborPion.getColor() != this.lastPlayedPion.getColor()) {
                return false;
            }
            neighbor = getNeighboringEntity(direction, neighborPion.getX(), neighborPion.getY());
        }
        return true;
    }

    private void init() {
        final int rowsCount = this.grille.getRowsCount();
        final int columnsCount = this.grille.getColumnsCount();

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                this.grille.setContentAt(i, j, new EmptyPlace());
            }
        }
        this.LOGGER.debug("La grille de taille " + rowsCount + "x" + columnsCount + " a bien ete initialisee avec des cases vides");
    }

    public GameEntity getContentAt(int x, int y) {
        return this.grille.getContentAt(x, y);
    }

    // ======================
    // COORDINATES MANAGEMENT
    // ======================

    private boolean isValidCoords(final int x, final int y) {
        boolean validX = !(x < 0 || x >= this.grille.getRowsCount() - 1);
        boolean validY = !(y < 0 || y > this.grille.getColumnsCount() - 1);
        return validX && validY;
    }

    private void updatePionPosition(final Pion pion, int x, final int y) {
        this.afficherPlateau();
        while (isValidCoords(x, y) && getNeighboringEntity(Direction.BELOW, x, y) instanceof EmptyPlace) {
            this.grille.setContentAt(x, y, new EmptyPlace());
            x++; // FIXME: Parameter should not be assigned
            this.grille.setContentAt(x, y, pion);
            informView();
        }
        pion.setX(x);
        pion.setY(y);
    }

    private void informView() {
        setChanged();
        notifyObservers();
        try {
            Thread.sleep(100); // TODO: Move this in the controler or in the view
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package fr.enssat.poo.vrome.models;

import fr.enssat.poo.utilities.Logger;
import fr.enssat.poo.utilities.SystemOutLogger;
import fr.enssat.poo.vrome.models.entities.EmptyPlace;
import fr.enssat.poo.vrome.models.entities.GameEntity;
import fr.enssat.poo.vrome.models.entities.Pion;
import fr.enssat.poo.vrome.models.matrix.GameEntityMatrix;
import fr.enssat.poo.vrome.models.matrix.GameEntityMatrix2DArrayImpl;

public class PlateauMaelig {

    private Logger LOGGER = new SystemOutLogger(PlateauMaelig.class);

    private GameEntityMatrix grille;

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
        LOGGER.debug("La matrice de taille " + rowsCount + "x" + columnsCount + " a bien été initialisée avec de la terre et des cases vides");
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
        // TODO: il faut faire cette méthode, le code ci dessous marche pas trop
//        // Un pion doit "chuter" tant qu'il y a du vide en dessous lui
//        int x_tmp = x + 1;
//        boolean finish = false;
//
//        while (!finish) { // TODO: meilleure solution que 'instanceof' ?
//            GameEntity entityBelow = this.grille.getContentAt(x_tmp, y); // TODO coords
//            if (isValidCoords(x_tmp, y) && entityBelow instanceof EmptyPlace) {
//                LOGGER.debug("Il y a du vide en dessous, le pion chute...");
//                this.grille.setContentAt(x_tmp, y, new EmptyPlace());
//                x_tmp = x_tmp + 1;
//                this.grille.setContentAt(x_tmp, y, pion);
//            } else {
//                LOGGER.debug("Le pion ne peux plus tomber.");
//                finish = true;
//            }
//        }
    }

    private boolean isValidCoords(int x, int y) {
        LOGGER.debug("x = " + x);
        return !(x >= this.grille.getRowsCount() || x <= 0 || y <= 0 || y >= this.grille.getColumnsCount());
    }

}

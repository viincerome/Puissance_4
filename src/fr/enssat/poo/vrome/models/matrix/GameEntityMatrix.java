package fr.enssat.poo.vrome.models.matrix;

import fr.enssat.poo.vrome.models.entities.GameEntity;

public interface GameEntityMatrix {
    // debug/development only
    void display();

    /**
     * @return number of columns of the matrix
     */
    int getColumnsCount();

    /**
     * Get the game entity stored at the specified coords.
     *
     * @param x
     * @param y
     * @return
     */
    GameEntity getContentAt(final int x, final int y);

    /**
     * @return number of rows of the matrix
     */
    int getRowsCount();

    /**
     * Store a game entity for the specified coords.
     *
     * @param x
     * @param y
     * @param pion
     */
    void setContentAt(final int x, final int y, final GameEntity pion);

}

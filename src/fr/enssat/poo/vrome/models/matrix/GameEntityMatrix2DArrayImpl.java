package fr.enssat.poo.vrome.models.matrix;

import fr.enssat.poo.vrome.models.entities.GameEntity;
import fr.enssat.poo.vrome.models.exceptions.CoordsException;

final public class GameEntityMatrix2DArrayImpl implements GameEntityMatrix {
    private static final long serialVersionUID = 1620562427653382683L;

    private final int rows; // x coord
    private final int columns; // y coord
    private GameEntity[][] data;

    public GameEntityMatrix2DArrayImpl(final int rows, final int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new GameEntity[rows][columns];
    }

    @Override
    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(this.data[i][j].getRepresentation() + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    @Override
    public void setContentAt(final int x, final int y, final GameEntity entity) {
        checkCoords(x, y);
        this.data[x][y] = entity;
    }

    @Override
    public GameEntity getContentAt(final int x, final int y) {
        checkCoords(x, y);
        return this.data[x][y];
    }

    @Override
    public int getRowsCount() {
        return this.rows;
    }

    @Override
    public int getColumnsCount() {
        return this.columns;
    }

    private void checkCoords(final int x, final int y) {
        if (x > getRowsCount() || x < 0 || y < 0 || y > getColumnsCount()) {
            throw new CoordsException("Invalid coordinates for x = " + x + " and y = " + y);
        }
    }

}

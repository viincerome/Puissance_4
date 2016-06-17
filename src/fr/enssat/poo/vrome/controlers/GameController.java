package fr.enssat.poo.vrome.controlers;

import fr.enssat.poo.vrome.models.Game;
import fr.enssat.poo.vrome.models.Player;
import fr.enssat.poo.vrome.models.entities.Pion;
import fr.enssat.poo.vrome.models.entities.PionColor;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;
import fr.enssat.poo.vrome.views.PlateauView;

/**
 * Created by mnantel on 17/06/16.
 */
public class GameController {

    private Logger LOGGER = new SystemOutLogger(GameController.class);

    private Game modele;
    private Player currentPlayer = new Player("Gertrude", PionColor.PURPLE); //TODO player management not done at all
    private int rows;
    private int columns;

    public boolean playPion(final int columnIndex) {
        try {
            this.modele.getPlateau().addPion(new Pion(this.currentPlayer.getPionColor()), 0, columnIndex);
            //TODO: update current player
            this.modele.getPlateau().afficherPlateau();
            return true;
        } catch ( Exception e ) { // TODO catch more precise exception
            e.printStackTrace();
            return false;
        }
    }

    public int getColumns() {
        return this.columns;
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void launch(int rows, int columns) {
        this.modele = new Game(rows, columns);
        this.rows = rows;
        this.columns = columns;
        new PlateauView(this);
    }

}

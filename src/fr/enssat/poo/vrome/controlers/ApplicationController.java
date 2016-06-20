package fr.enssat.poo.vrome.controlers;

import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;
import fr.enssat.poo.vrome.views.SettingView;

public class ApplicationController {

    private Logger LOGGER = new SystemOutLogger(ApplicationController.class);

	public void launch() {
		this.LOGGER.debug("Starting the app");
		new SettingView(this);
	}

    public void startGame(int rows, int columns){
        new GameController().launch(rows, columns);
    }

    public int getDefaultRowsCount(){
        return 6;
    }

    public int getDefaultColumnsCount(){
        return 7;
    }

}
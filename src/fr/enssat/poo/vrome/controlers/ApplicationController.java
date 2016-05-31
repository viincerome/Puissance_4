package fr.enssat.poo.vrome.controlers;

import fr.enssat.poo.utilities.Logger;
import fr.enssat.poo.utilities.SystemOutLogger;
import fr.enssat.poo.vrome.views.MainView;

public class ApplicationController {

	private Logger LOGGER = new SystemOutLogger(ApplicationController.class);

	@SuppressWarnings("unused")
	public void launch() {
		LOGGER.debug("Starting the app");
		new MainView(this);
	}
}
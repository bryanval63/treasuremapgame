package fr.carbonit.treasuremapgame.game;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.carbonit.treasuremapgame.consts.ErrorMsgConsts;
import fr.carbonit.treasuremapgame.consts.GlobalConsts;
import fr.carbonit.treasuremapgame.controller.FileContentController;
import fr.carbonit.treasuremapgame.controller.TreasureMapGameController;
import fr.carbonit.treasuremapgame.exceptions.FileException;
import fr.carbonit.treasuremapgame.interfaces.impl.FileContentChecker;

public class TreasureMapGame {

	private static final Logger LOGGER = Logger.getLogger(TreasureMapGame.class.getName());

	public static void main(String[] args) {
		try {
			var fileContentController = new FileContentController(GlobalConsts.FILE_PATH_IN, new FileContentChecker());
			new TreasureMapGameController(fileContentController).start();
		} catch (FileException e) {
			String error = buildErrorMessage(e);
			LOGGER.log(Level.SEVERE, error);
			e.printStackTrace();
		}
	}

	private static String buildErrorMessage(Exception e) {
		return new StringBuilder(ErrorMsgConsts.ERROR_HAPPENED).append(e.getMessage()).append(GlobalConsts.RETURN)
				.toString();
	}

}

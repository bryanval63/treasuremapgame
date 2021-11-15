package fr.carbonit.treasuremapgame.game;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.carbonit.treasuremapgame.consts.ErrorMsgConsts;
import fr.carbonit.treasuremapgame.consts.GlobalConsts;
import fr.carbonit.treasuremapgame.controller.TreasureMapGameController;
import fr.carbonit.treasuremapgame.exceptions.FileException;
import fr.carbonit.treasuremapgame.interfaces.impl.FileContentChecker;
import fr.carbonit.treasuremapgame.interfaces.impl.FileContentService;

/**
 * Point d'entrée du jeu
 * 
 * @author bryan
 *
 */
public class TreasureMapGame {

	private static final Logger LOGGER = Logger.getLogger(TreasureMapGame.class.getName());

	public static void main(String[] args) {
		try {
			startGame();
		} catch (FileException e) {
			logError(e);
		}
	}

	private static void startGame() throws FileException {
		var fileContentChecker = new FileContentChecker();
		var fileContentController = new FileContentService(GlobalConsts.FILE_PATH_IN, fileContentChecker);

		new TreasureMapGameController(fileContentController, fileContentChecker).startGame();
	}

	private static void logError(FileException e) {
		String error = buildErrorMessage(e);
		LOGGER.log(Level.SEVERE, error);
		e.printStackTrace();
	}

	private static String buildErrorMessage(Exception e) {
		return new StringBuilder(ErrorMsgConsts.ERROR_HAPPENED).append(e.getMessage()).append(GlobalConsts.RETURN)
				.toString();
	}

}

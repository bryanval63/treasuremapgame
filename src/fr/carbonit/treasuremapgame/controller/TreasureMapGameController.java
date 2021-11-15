package fr.carbonit.treasuremapgame.controller;

import java.util.List;

import fr.carbonit.treasuremapgame.exceptions.FileContentException;
import fr.carbonit.treasuremapgame.exceptions.FileException;
import fr.carbonit.treasuremapgame.factory.AdventurerFactory;
import fr.carbonit.treasuremapgame.factory.MountainFactory;
import fr.carbonit.treasuremapgame.factory.TreasureFactory;
import fr.carbonit.treasuremapgame.interfaces.IFileContentChecker;
import fr.carbonit.treasuremapgame.interfaces.IFileContentService;
import fr.carbonit.treasuremapgame.interfaces.impl.AdventurerMoveChecker;
import fr.carbonit.treasuremapgame.interfaces.impl.MapObjectsChecker;
import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.GameMap;
import fr.carbonit.treasuremapgame.model.mapobject.moving.Adventurer;
import fr.carbonit.treasuremapgame.model.mapobject.nomoving.Mountain;
import fr.carbonit.treasuremapgame.model.mapobject.nomoving.Treasure;

/**
 * Contrôle le fil du jeu, de la récupération des données du fichier à
 * l'écriture du résultat dans un fichier
 * 
 * @author bryan
 *
 */
public class TreasureMapGameController {

	private IFileContentService fileContentService;
	private IFileContentChecker fileContentChecker;

	private GameMap map;

	public TreasureMapGameController(IFileContentService fileContentService, IFileContentChecker fileContentChecker) {
		this.fileContentService = fileContentService;
		this.fileContentChecker = fileContentChecker;
	}

	public void startGame() throws FileException {
		verifyFileContent();
		initGameMap();
		map.startGame();
		fileContentService.writeFile(map);
	}

	private void verifyFileContent() throws FileContentException {
		String[] fileContentLines = fileContentService.getFileContentLines();

		fileContentChecker.verifyFileNotEmpty(fileContentLines);
		fileContentChecker.verifyFileHasRightFormatedLines(fileContentLines);
	}

	private void initGameMap() throws FileContentException {
		String[] fileContentLines = fileContentService.getFileContentLines();

		List<Mountain> mountains = new MountainFactory(fileContentLines).getMountains();
		List<Treasure> treasures = new TreasureFactory(fileContentLines).getTreasures();
		List<Adventurer> adventurers = new AdventurerFactory(fileContentLines).getAdventurers();

		Coordinates mapSize = fileContentService.extractMapSize();

		map = new GameMap(mapSize, mountains, treasures, adventurers, new AdventurerMoveChecker());
		map.setMapObjectsChecker(new MapObjectsChecker(map));
		map.checkObjectsBeforeStarting();
	}
}

package fr.carbonit.treasuremapgame.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import fr.carbonit.treasuremapgame.consts.GlobalConsts;
import fr.carbonit.treasuremapgame.exceptions.FileContentException;
import fr.carbonit.treasuremapgame.exceptions.FileException;
import fr.carbonit.treasuremapgame.factory.AdventurerFactory;
import fr.carbonit.treasuremapgame.factory.MountainFactory;
import fr.carbonit.treasuremapgame.factory.TreasureFactory;
import fr.carbonit.treasuremapgame.interfaces.impl.AdventurerMoveChecker;
import fr.carbonit.treasuremapgame.interfaces.impl.MapObjectsChecker;
import fr.carbonit.treasuremapgame.model.Adventurer;
import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.GameMap;
import fr.carbonit.treasuremapgame.model.Mountain;
import fr.carbonit.treasuremapgame.model.MovingMapObject;
import fr.carbonit.treasuremapgame.model.NoMovingMapObject;
import fr.carbonit.treasuremapgame.model.Treasure;
import fr.carbonit.treasuremapgame.utils.FileUtils;

public class TreasureMapGameController {

	private FileContentController fileContentManager;
	private GameMap map;

	public TreasureMapGameController(FileContentController fileContentManager) {
		this.fileContentManager = fileContentManager;
	}

	public void start() throws FileException {
		checkFile();
		initGame();
		runGame();
		writeFile();
	}

	public void checkFile() throws FileException {
		fileContentManager.verifyFileContent();
	}

	public void initGame() throws FileContentException {
		initMap();
		map.checkObjectsBeforeStarting();
	}

	private void initMap() throws FileContentException {
		String[] fileContentLines = fileContentManager.getFileContentLines();

		List<Mountain> mountains = new MountainFactory(fileContentLines).getMountains();
		List<Treasure> treasures = new TreasureFactory(fileContentLines).getTreasures();
		List<Adventurer> adventurers = new AdventurerFactory(fileContentLines).getAdventurers();

		Coordinates mapSize = fileContentManager.extractMapSize();

		map = new GameMap(mapSize, mountains, treasures, adventurers, new AdventurerMoveChecker());
		map.setMapObjectsChecker(new MapObjectsChecker(map));
	}

	private void runGame() {
		map.startGame();
	}

	private void writeFile() throws FileException {
		FileUtils.writeFile(getLinesToWrite(), GlobalConsts.FILE_PATH_OUT);
	}

	private List<String> getLinesToWrite() {
		List<String> adventurerList = map.getAdventurers().stream().map(MovingMapObject::toString).toList();
		List<String> mountainList = map.getMountains().stream().map(NoMovingMapObject::toString).toList();
		List<String> treasuresList = map.getTreasures().stream().filter(treasure -> !treasure.isEmpty())
				.map(NoMovingMapObject::toString).toList();

		return Stream.of(List.of(map.toString()), mountainList, treasuresList, adventurerList)
				.flatMap(Collection::stream).toList();
	}
}

package fr.carbonit.treasuremapgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.carbonit.treasuremapgame.consts.GlobalConsts;
import fr.carbonit.treasuremapgame.exceptions.FileContentException;
import fr.carbonit.treasuremapgame.interfaces.IMapObjectsChecker;
import fr.carbonit.treasuremapgame.interfaces.IMoveChecker;

public class GameMap {

	private final Coordinates size;

	private List<Mountain> mountains = new ArrayList<>();
	private List<Treasure> treasures = new ArrayList<>();
	private List<Adventurer> adventurers = new ArrayList<>();

	private IMoveChecker moveChecker;
	private IMapObjectsChecker mapObjectsChecker;

	public GameMap(Coordinates size, List<Mountain> mountains, List<Treasure> treasures, List<Adventurer> adventurers,
			IMoveChecker moveChecker) {
		this.size = size;
		this.mountains = Collections.unmodifiableList(mountains);
		this.treasures = Collections.unmodifiableList(treasures);
		this.adventurers = Collections.unmodifiableList(adventurers);
		this.moveChecker = moveChecker;
	}

	public void checkObjectsBeforeStarting() throws FileContentException {
		mapObjectsChecker.checkDistinctCoordinates();
		mapObjectsChecker.checkNumberOfEntities();
		mapObjectsChecker.checkCoordinatesValues();
	}

	public void startGame() {
		while (isGameOnGoing()) {
			adventurers.forEach(this::performMovement);
		}
	}

	private boolean isGameOnGoing() {
		return adventurers.stream().map(MovingMapObject::isMovementOver).noneMatch(Boolean.TRUE::equals);
	}

	private void performMovement(MovingMapObject adventurer) {
		adventurer.calculateNewCoordinates().ifPresent(coordinates -> moveObjectAndCatchTreasure(adventurer, coordinates));
	}

	private void moveObjectAndCatchTreasure(MovingMapObject adventurer, Coordinates coordinates) {
		if (moveChecker.checkMovementPossible(this, coordinates)) {
			adventurer.setPosition(coordinates);
			adventurer.tryToCatchTreasure(treasures);
		}
	}

	public Coordinates getSize() {
		return size;
	}

	public List<Mountain> getMountains() {
		return Collections.unmodifiableList(mountains);
	}

	public List<Treasure> getTreasures() {
		return Collections.unmodifiableList(treasures);
	}

	public List<Adventurer> getAdventurers() {
		return Collections.unmodifiableList(adventurers);
	}

	public void setMapObjectsChecker(IMapObjectsChecker mapObjectsChecker) {
		this.mapObjectsChecker = mapObjectsChecker;
	}

	@Override
	public String toString() {
		return new StringBuilder("C").append(GlobalConsts.DASH).append(size.toString()).toString();
	}
}

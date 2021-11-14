package fr.carbonit.treasuremapgame.interfaces.impl;

import java.util.List;

import fr.carbonit.treasuremapgame.interfaces.IMoveChecker;
import fr.carbonit.treasuremapgame.model.Adventurer;
import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.GameMap;
import fr.carbonit.treasuremapgame.model.Mountain;

public class AdventurerMoveChecker implements IMoveChecker {

	@Override
	public boolean checkMovementPossible(GameMap map, Coordinates newPosition) {
		return !adventurerFound(map.getAdventurers(), newPosition) && !mountainFound(map.getMountains(), newPosition)
				&& !isAtBorder(map.getSize(), newPosition);
	}

	private static boolean adventurerFound(List<Adventurer> adventurers, Coordinates newPosition) {
		return adventurers.stream()
				.anyMatch(adventurer -> adventurer.getPosition().getCoordX() == newPosition.getCoordX()
						&& adventurer.getPosition().getCoordY() == newPosition.getCoordY());
	}

	private static boolean mountainFound(List<Mountain> mountains, Coordinates newPosition) {
		return mountains.stream().anyMatch(mountain -> mountain.getPosition().getCoordX() == newPosition.getCoordX()
				&& mountain.getPosition().getCoordY() == newPosition.getCoordY());
	}

	private static boolean isAtBorder(Coordinates mapSize, Coordinates newPosition) {
		return newPosition.getCoordX() < 0 || newPosition.getCoordY() < 0
				|| newPosition.getCoordX() == mapSize.getCoordX() || newPosition.getCoordY() == mapSize.getCoordY();
	}
}

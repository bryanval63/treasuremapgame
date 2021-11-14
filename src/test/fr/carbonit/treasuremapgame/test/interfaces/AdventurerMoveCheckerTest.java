package fr.carbonit.treasuremapgame.test.interfaces;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import fr.carbonit.treasuremapgame.interfaces.impl.AdventurerMoveChecker;
import fr.carbonit.treasuremapgame.model.Adventurer;
import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.GameMap;
import fr.carbonit.treasuremapgame.model.Mountain;

public class AdventurerMoveCheckerTest {

	private Coordinates coordinates = new Coordinates(1, 1);
	private Coordinates mapSize = new Coordinates(3, 3);

	@Test
	public void checkMovementPossible_whenAtBorder_thenShouldReturnFalse() {
		assertFalseMovement(List.of(), List.of());
	}

	@Test
	public void checkMovementPossible_whenNotAtBorder_thenShouldReturnTrue() {
		var map = new GameMap(mapSize, List.of(), List.of(), List.of(), null);
		assertTrue(new AdventurerMoveChecker().checkMovementPossible(map, coordinates));
	}

	@Test
	public void checkMovementPossible_whenMountain_thenShouldReturnFalse() {
		List<Mountain> mountain = List.of(new Mountain(coordinates));
		assertFalseMovement(mountain, List.of());
	}

	@Test
	public void checkMovementPossible_whenAdventurer_thenShouldReturnFalse() {
		List<Adventurer> adventurer = List.of(new Adventurer(null, null, null, coordinates));
		assertFalseMovement(List.of(), adventurer);
	}

	private void assertFalseMovement(List<Mountain> mountains, List<Adventurer> adventurers) {
		var map = new GameMap(mapSize, mountains, List.of(), adventurers, null);
		assertFalse(new AdventurerMoveChecker().checkMovementPossible(map, mapSize));
	}
}

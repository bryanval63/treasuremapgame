package fr.carbonit.treasuremapgame.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fr.carbonit.treasuremapgame.interfaces.impl.AdventurerMoveChecker;
import fr.carbonit.treasuremapgame.model.enums.OrientationEnum;

public class GameMapTest {

	@Test
	public void startGame_whenAdventurerReady_thenShouldHaveTheRightPosition() {
		List<Mountain> mountains = List.of(new Mountain(new Coordinates(2, 1)), new Mountain(new Coordinates(1, 0)));

		List<Treasure> treasures = List.of(new Treasure(new Coordinates(0, 3), 2),
				new Treasure(new Coordinates(1, 3), 3));

		List<Adventurer> adventurers = List
				.of(new Adventurer("", OrientationEnum.S, "AADADAGGA", new Coordinates(1, 1)));

		var map = new GameMap(new Coordinates(3, 4), mountains, treasures, adventurers, new AdventurerMoveChecker());

		map.startGame();

		Adventurer actualAdv = map.getAdventurers().get(0);

		assertEquals(0, actualAdv.getPosition().getCoordX());
		assertEquals(3, actualAdv.getPosition().getCoordY());
		assertEquals(OrientationEnum.S, actualAdv.getOrientation());
		assertEquals(3, actualAdv.getTreasuresQuantity());
	}
}

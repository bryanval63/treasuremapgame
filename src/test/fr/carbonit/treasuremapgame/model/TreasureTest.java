package fr.carbonit.treasuremapgame.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TreasureTest {

	@Test
	public void catchTreasure_whenQuantityIsOne_thenQuantityShouldBeEmpty() {
		var treasure = new Treasure(new Coordinates(0, 0), 1);

		treasure.catchTreasure();

		assertTrue(treasure.isEmpty());
	}

	@Test
	public void catchTreasure_whenQuantityIsTwo_thenQuantityShouldNotBeEmpty() {
		var treasure = new Treasure(new Coordinates(0, 0), 2);

		treasure.catchTreasure();

		assertFalse(treasure.isEmpty());
	}
}

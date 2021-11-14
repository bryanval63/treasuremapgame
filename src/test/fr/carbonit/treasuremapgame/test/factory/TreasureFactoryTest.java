package fr.carbonit.treasuremapgame.test.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.carbonit.treasuremapgame.factory.TreasureFactory;

public class TreasureFactoryTest {

	@Test
	public void getTreasures_whenContentLines_thenShouldCreateTreasures() {
		String[] adventurerToCreate = { "T - 0 - 3 - 0" };

		var treasure = new TreasureFactory(adventurerToCreate).getTreasures().get(0);

		assertEquals(0, treasure.getPosition().getCoordX());
		assertEquals(3, treasure.getPosition().getCoordY());
		assertTrue(treasure.isEmpty());
	}

}

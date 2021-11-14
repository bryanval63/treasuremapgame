package fr.carbonit.treasuremapgame.test.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.carbonit.treasuremapgame.factory.AdventurerFactory;
import fr.carbonit.treasuremapgame.model.enums.OrientationEnum;

public class AdventurerFactoryTest {

	@Test
	public void getAdventurers_whenContentLines_thenShouldCreateAdventurers() {
		String[] adventurerToCreate = { "A - Lara - 1 - 1 - S - AADADAGGA" };

		var adventurer = new AdventurerFactory(adventurerToCreate).getAdventurers().get(0);

		assertEquals("Lara", adventurer.getName());
		assertEquals(1, adventurer.getPosition().getCoordX());
		assertEquals(1, adventurer.getPosition().getCoordY());
		assertEquals(OrientationEnum.S, adventurer.getOrientation());
		assertEquals("AADADAGGA", adventurer.getMovementsSequence());
	}

}

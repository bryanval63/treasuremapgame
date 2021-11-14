package fr.carbonit.treasuremapgame.test.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.carbonit.treasuremapgame.factory.MountainFactory;

public class MountainFactoryTest {

	@Test
	public void getMountains_whenContentLines_thenShouldCreateMountains() {
		String[] adventurerToCreate = { "M - 2 - 1" };

		var moutain = new MountainFactory(adventurerToCreate).getMountains().get(0);

		assertEquals(2, moutain.getPosition().getCoordX());
		assertEquals(1, moutain.getPosition().getCoordY());
	}

}

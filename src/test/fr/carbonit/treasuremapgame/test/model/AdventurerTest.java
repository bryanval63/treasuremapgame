package fr.carbonit.treasuremapgame.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;

import fr.carbonit.treasuremapgame.model.Adventurer;
import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.Treasure;
import fr.carbonit.treasuremapgame.model.enums.MovementEnum;
import fr.carbonit.treasuremapgame.model.enums.OrientationEnum;

public class AdventurerTest {

	private Coordinates coordinates = new Coordinates(0, 0);

	@Test
	public void calculateNewCoordinates_whenMovementIsD_thenShouldReturnEmptyOptionalAndUpdateOrientation() {
		var adventurer = new Adventurer("", OrientationEnum.N, MovementEnum.D.toString(), coordinates);

		Optional<Coordinates> newCoords = adventurer.calculateNewCoordinates();

		assertTrue(newCoords.isEmpty());
		assertEquals(OrientationEnum.E, adventurer.getOrientation());
	}

	@Test
	public void calculateNewCoordinates_whenMovementIsG_thenShouldReturnEmptyOptionalAndUpdateOrientation() {
		var adventurer = new Adventurer("", OrientationEnum.N, MovementEnum.G.toString(), coordinates);

		Optional<Coordinates> newCoords = adventurer.calculateNewCoordinates();

		assertTrue(newCoords.isEmpty());
		assertEquals(OrientationEnum.W, adventurer.getOrientation());
	}

	@Test
	public void calculateNewCoordinates_whenMovementIsA_thenShouldReturnNewCoords() {
		var adventurer = new Adventurer("", OrientationEnum.S, MovementEnum.A.toString(), coordinates);

		Optional<Coordinates> newCoords = adventurer.calculateNewCoordinates();

		assertTrue(newCoords.isPresent());
		assertEquals(0, newCoords.get().getCoordX());
		assertEquals(1, newCoords.get().getCoordY());
	}

	@Test
	public void tryToCatchTreasure_whenTreasureIsPresent_thenShouldIncrementTreasureQuantity() {
		var adventurer = new Adventurer("", OrientationEnum.S, MovementEnum.A.toString(), coordinates);

		adventurer.tryToCatchTreasure(List.of(new Treasure(adventurer.getPosition(), 1)));

		assertEquals(1, adventurer.getTreasuresQuantity());
	}

	@Test
	public void tryToCatchTreasure_whenTreasureIsNotPresent_thenShouldNotIncrementTreasureQuantity() {
		var adventurer = new Adventurer("", OrientationEnum.S, MovementEnum.A.toString(), coordinates);

		adventurer.tryToCatchTreasure(List.of(new Treasure(new Coordinates(1, 1), 1)));

		assertEquals(0, adventurer.getTreasuresQuantity());
	}
}

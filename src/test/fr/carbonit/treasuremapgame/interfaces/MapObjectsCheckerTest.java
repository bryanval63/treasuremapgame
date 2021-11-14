package fr.carbonit.treasuremapgame.interfaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.Test;

import fr.carbonit.treasuremapgame.consts.ErrorMsgConsts;
import fr.carbonit.treasuremapgame.exceptions.FileContentException;
import fr.carbonit.treasuremapgame.interfaces.impl.AdventurerMoveChecker;
import fr.carbonit.treasuremapgame.interfaces.impl.MapObjectsChecker;
import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.GameMap;
import fr.carbonit.treasuremapgame.model.Mountain;

public class MapObjectsCheckerTest {

	@Test
	public void checkDistinctCoordinates_whenMultipleCoordinates_thenShouldThrowFileContentException() {
		List<Mountain> mountain = List.of(new Mountain(new Coordinates(1, 2)), new Mountain(new Coordinates(1, 2)));

		var map = new GameMap(new Coordinates(3, 3), mountain, List.of(), List.of(), new AdventurerMoveChecker());

		Exception exception = assertThrows(FileContentException.class,
				() -> new MapObjectsChecker(map).checkDistinctCoordinates());

		String actualMessage = exception.getMessage();

		assertEquals(actualMessage, ErrorMsgConsts.ERROR_DUPLIACTE_POSITION);
	}

	@Test
	public void checkNumberOfEntities_whenWrongEntitiesNumber_thenShouldThrowFileContentException() {
		List<Mountain> mountain = List.of(new Mountain(new Coordinates(1, 1)), new Mountain(new Coordinates(1, 2)));

		var map = new GameMap(new Coordinates(1, 1), mountain, List.of(), List.of(), new AdventurerMoveChecker());

		Exception exception = assertThrows(FileContentException.class,
				() -> new MapObjectsChecker(map).checkNumberOfEntities());

		String actualMessage = exception.getMessage();

		assertEquals(actualMessage, ErrorMsgConsts.ERROR_NUMBER_ENTITIES);
	}

	@Test
	public void checkCoordinatesValues_whenWrongCoordinatesValues_thenShouldThrowFileContentException() {
		List<Mountain> mountain = List.of(new Mountain(new Coordinates(2, 1)));

		var map = new GameMap(new Coordinates(1, 1), mountain, List.of(), List.of(), new AdventurerMoveChecker());

		Exception exception = assertThrows(FileContentException.class,
				() -> new MapObjectsChecker(map).checkCoordinatesValues());

		String actualMessage = exception.getMessage();

		assertEquals(actualMessage, ErrorMsgConsts.ERROR_WRONG_COORDS);
	}
}

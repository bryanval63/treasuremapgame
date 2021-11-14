package fr.carbonit.treasuremapgame.interfaces.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.carbonit.treasuremapgame.consts.ErrorMsgConsts;
import fr.carbonit.treasuremapgame.exceptions.FileContentException;
import fr.carbonit.treasuremapgame.interfaces.IMapObjectsChecker;
import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.GameMap;
import fr.carbonit.treasuremapgame.model.mapobject.moving.MovingMapObject;
import fr.carbonit.treasuremapgame.model.mapobject.nomoving.Mountain;
import fr.carbonit.treasuremapgame.model.mapobject.nomoving.Treasure;

public class MapObjectsChecker implements IMapObjectsChecker {

	private final GameMap map;

	public MapObjectsChecker(GameMap map) {
		this.map = map;
	}

	@Override
	public void checkDistinctCoordinates() throws FileContentException {
		List<Coordinates> allCoords = getListOfAllCoordinates();

		if (hasDuplicateCoordinates(allCoords)) {
			throw new FileContentException(ErrorMsgConsts.ERROR_DUPLIACTE_POSITION);
		}
	}

	private static boolean hasDuplicateCoordinates(List<Coordinates> coordinates) {
		return groupByCoordinates(coordinates).values().stream().map(Map::values)
				.anyMatch(listCoord -> listCoord.stream().anyMatch(coords -> coords.size() > 1));
	}

	private static Map<Integer, Map<Integer, List<Coordinates>>> groupByCoordinates(List<Coordinates> coordinates) {
		return coordinates.stream()
				.collect(Collectors.groupingBy(Coordinates::getCoordX, Collectors.groupingBy(Coordinates::getCoordY)));
	}

	@Override
	public void checkNumberOfEntities() throws FileContentException {
		if (hasWrongEntitiesNumber()) {
			throw new FileContentException(ErrorMsgConsts.ERROR_NUMBER_ENTITIES);
		}
	}

	private boolean hasWrongEntitiesNumber() {
		return map.getSize().getCoordX() * map.getSize().getCoordY() < getListOfAllCoordinates().size();
	}

	@Override
	public void checkCoordinatesValues() throws FileContentException {
		if (hasWrongCoords()) {
			throw new FileContentException(ErrorMsgConsts.ERROR_WRONG_COORDS);
		}
	}

	private boolean hasWrongCoords() {
		return getListOfAllCoordinates().stream().anyMatch(coord -> coord.getCoordX() > map.getSize().getCoordX() - 1
				|| coord.getCoordY() > map.getSize().getCoordY() - 1);
	}

	private List<Coordinates> getListOfAllCoordinates() {
		List<Coordinates> mountainsCoords = map.getMountains().stream().map(Mountain::getPosition).toList();
		List<Coordinates> treasuresCoords = map.getTreasures().stream().map(Treasure::getPosition).toList();
		List<Coordinates> adventurersCoords = map.getAdventurers().stream().map(MovingMapObject::getPosition).toList();

		return Stream.of(mountainsCoords, treasuresCoords, adventurersCoords).flatMap(Collection::stream).toList();
	}
}

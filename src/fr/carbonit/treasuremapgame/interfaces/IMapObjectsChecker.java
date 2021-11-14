package fr.carbonit.treasuremapgame.interfaces;

import fr.carbonit.treasuremapgame.exceptions.FileContentException;

public interface IMapObjectsChecker {

	void checkDistinctCoordinates() throws FileContentException;

	void checkNumberOfEntities() throws FileContentException;

	void checkCoordinatesValues() throws FileContentException;
}

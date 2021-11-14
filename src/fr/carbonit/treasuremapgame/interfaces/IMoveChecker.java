package fr.carbonit.treasuremapgame.interfaces;

import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.GameMap;

public interface IMoveChecker {

	boolean checkMovementPossible(GameMap map, Coordinates newPosition);
}

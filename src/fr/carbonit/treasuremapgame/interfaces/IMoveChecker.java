package fr.carbonit.treasuremapgame.interfaces;

import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.GameMap;

/**
 * Défini les règles des mouvements des objets de la map afin de garantir si
 * l'objet à le droit de se déplacer
 * 
 * @author bryan
 *
 */
public interface IMoveChecker {

	boolean checkMovementPossible(GameMap map, Coordinates newPosition);
}

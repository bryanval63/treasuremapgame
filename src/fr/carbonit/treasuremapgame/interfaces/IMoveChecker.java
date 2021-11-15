package fr.carbonit.treasuremapgame.interfaces;

import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.GameMap;

/**
 * D�fini les r�gles des mouvements des objets de la map afin de garantir si
 * l'objet � le droit de se d�placer
 * 
 * @author bryan
 *
 */
public interface IMoveChecker {

	boolean checkMovementPossible(GameMap map, Coordinates newPosition);
}

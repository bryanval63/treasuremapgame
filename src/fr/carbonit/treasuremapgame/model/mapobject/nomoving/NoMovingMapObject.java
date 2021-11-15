package fr.carbonit.treasuremapgame.model.mapobject.nomoving;

import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.mapobject.MapObject;

/**
 * Type d'objet qui peut pas se déplacer sur la carte
 * 
 * @author bryan
 *
 */
public abstract class NoMovingMapObject extends MapObject {

	protected NoMovingMapObject(Coordinates position) {
		super(position);
	}
}

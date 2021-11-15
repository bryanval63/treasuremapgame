package fr.carbonit.treasuremapgame.model.mapobject;

import fr.carbonit.treasuremapgame.model.Coordinates;

/**
 * Type d'objet qui est pr�sent sur la carte
 * 
 * @author bryan
 *
 */
public class MapObject {
	private Coordinates position;

	protected MapObject(Coordinates position) {
		this.position = position;
	}

	public Coordinates getPosition() {
		return position;
	}

	public void setPosition(Coordinates position) {
		this.position = position;
	}
}

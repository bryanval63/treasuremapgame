package fr.carbonit.treasuremapgame.model.mapobject;

import fr.carbonit.treasuremapgame.model.Coordinates;

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

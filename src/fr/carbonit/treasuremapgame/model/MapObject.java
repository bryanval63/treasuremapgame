package fr.carbonit.treasuremapgame.model;

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

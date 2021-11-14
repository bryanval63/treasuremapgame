package fr.carbonit.treasuremapgame.model.enums;

public enum OrientationEnum {
	N, E, S, W;

	private static final OrientationEnum[] orientations = values();

	public OrientationEnum getRight() {
		int orientation;

		if (this.ordinal() == orientations.length - 1) {
			orientation = 0;
		} else {
			orientation = this.ordinal() + 1;
		}

		return orientations[orientation];
	}

	public OrientationEnum getLeft() {
		int orientation;

		if (this.ordinal() == 0) {
			orientation = orientations.length - 1;
		} else {
			orientation = this.ordinal() - 1;
		}

		return orientations[orientation];
	}
}

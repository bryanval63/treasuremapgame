package fr.carbonit.treasuremapgame.model;

import fr.carbonit.treasuremapgame.consts.GlobalConsts;

public class Mountain extends NoMovingMapObject {

	public Mountain(Coordinates position) {
		super(position);
	}

	@Override
	public String toString() {
		return new StringBuilder("M").append(GlobalConsts.DASH).append(getPosition().toString()).toString();
	}

}

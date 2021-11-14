package fr.carbonit.treasuremapgame.model.mapobject.nomoving;

import fr.carbonit.treasuremapgame.consts.GlobalConsts;
import fr.carbonit.treasuremapgame.model.Coordinates;

public class Mountain extends NoMovingMapObject {

	public Mountain(Coordinates position) {
		super(position);
	}

	@Override
	public String toString() {
		return new StringBuilder("M").append(GlobalConsts.DASH).append(getPosition().toString()).toString();
	}

}

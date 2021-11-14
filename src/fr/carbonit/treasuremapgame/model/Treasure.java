package fr.carbonit.treasuremapgame.model;

import fr.carbonit.treasuremapgame.consts.GlobalConsts;

public class Treasure extends NoMovingMapObject {
	private int quantity;

	public Treasure(Coordinates position, int quantity) {
		super(position);
		this.quantity = quantity;
	}

	public int catchTreasure() {
		if (quantity > 0) {
			quantity--;
			return 1;
		} else {
			return 0;
		}
	}

	public boolean isEmpty() {
		return quantity == 0;
	}

	@Override
	public String toString() {
		return new StringBuilder("T").append(GlobalConsts.DASH).append(getPosition().toString())
				.append(GlobalConsts.DASH).append(quantity).toString();
	}
}

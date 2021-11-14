package fr.carbonit.treasuremapgame.model;

import java.util.List;
import java.util.Optional;

import fr.carbonit.treasuremapgame.consts.GlobalConsts;
import fr.carbonit.treasuremapgame.model.enums.MovementEnum;
import fr.carbonit.treasuremapgame.model.enums.OrientationEnum;

public class Adventurer extends MovingMapObject {

	private String name;
	private int treasuresQuantity;

	public Adventurer(String name, OrientationEnum orientation, String movementsSequence, Coordinates position) {
		super(position, orientation, movementsSequence);

		this.name = name;
	}

	public Optional<Coordinates> calculateNewCoordinates() {
		MovementEnum newMovement = getValueFromMovementsSeq();
		Optional<Coordinates> newCoordinates = Optional.empty();

		if (MovementEnum.A == newMovement) {
			newCoordinates = Optional.of(getNewPosition());
		} else {
			rotate(MovementEnum.valueOf(newMovement.toString()));
		}

		return newCoordinates;
	}

	private MovementEnum getValueFromMovementsSeq() {
		var movement = String.valueOf(getMovementsSequence().charAt(incrementIndexMovSeq()));

		return MovementEnum.valueOf(movement);
	}

	private Coordinates getNewPosition() {
		Coordinates copyPosition = getCopyPosition();

		switch (getOrientation()) {
		case E: // EAST
			copyPosition.incrementCoordX();
			break;
		case N: // NORTH
			copyPosition.decrementCoordY();
			break;
		case W: // WEST
			copyPosition.decrementCoordX();
			break;
		case S: // SOUTH
			copyPosition.incrementCoordY();
			break;
		}

		return copyPosition;
	}

	private Coordinates getCopyPosition() {
		return new Coordinates(getPosition().getCoordX(), getPosition().getCoordY());
	}

	private void rotate(MovementEnum rotation) {
		if (rotation == MovementEnum.G) {
			setOrientation(getOrientation().getLeft());
		} else {
			setOrientation(getOrientation().getRight());
		}
	}

	public void tryToCatchTreasure(List<Treasure> treasures) {
		isTreasurePresent(treasures, getPosition())
				.ifPresent(treasure -> treasuresQuantity += treasure.catchTreasure());
	}

	private static Optional<Treasure> isTreasurePresent(List<Treasure> treasures, Coordinates position) {
		return treasures.stream().filter(treasure -> treasure.getPosition().getCoordX() == position.getCoordX()
				&& treasure.getPosition().getCoordY() == position.getCoordY()).findAny();
	}

	public int getTreasuresQuantity() {
		return treasuresQuantity;
	}

	@Override
	public String toString() {
		return new StringBuilder("A").append(GlobalConsts.DASH).append(name).append(GlobalConsts.DASH)
				.append(getPosition().toString()).append(GlobalConsts.DASH).append(getOrientation())
				.append(GlobalConsts.DASH).append(treasuresQuantity).toString();
	}
}

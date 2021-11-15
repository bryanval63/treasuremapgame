package fr.carbonit.treasuremapgame.model.mapobject.moving;

import java.util.List;
import java.util.Optional;

import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.enums.OrientationEnum;
import fr.carbonit.treasuremapgame.model.mapobject.MapObject;
import fr.carbonit.treasuremapgame.model.mapobject.nomoving.Treasure;

/**
 * Type d'objet qui peut se déplacer sur la carte
 * 
 * @author bryan
 *
 */
public abstract class MovingMapObject extends MapObject {

	private String movementsSequence;
	private int indexMovementSeq;
	private OrientationEnum orientation;

	protected MovingMapObject(Coordinates position, OrientationEnum orientation, String movementsSequence) {
		super(position);

		this.orientation = orientation;
		this.movementsSequence = movementsSequence;
	}

	public abstract Optional<Coordinates> calculateNewCoordinates();

	public abstract void tryToCatchTreasure(List<Treasure> treasures);

	public boolean isMovementOver() {
		return getIndexMovementSeq() == getMovementsSequence().length();
	}

	protected int incrementIndexMovSeq() {
		return indexMovementSeq++;
	}

	public String getMovementsSequence() {
		return movementsSequence;
	}

	protected int getIndexMovementSeq() {
		return indexMovementSeq;
	}

	public OrientationEnum getOrientation() {
		return orientation;
	}

	protected void setOrientation(OrientationEnum orientation) {
		this.orientation = orientation;
	}
}

package fr.carbonit.treasuremapgame.factory;

import java.util.List;

import fr.carbonit.treasuremapgame.consts.GlobalConsts;
import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.mapobject.nomoving.Treasure;

public class TreasureFactory extends MapObjectFactory {

	private static final int QUANTITY_INDEX = 2;
	private static final int COORDS_INDEX_END = 1;
	private static final int COORDS_INDEX_START = 0;
	private static final int TREASURE_INDEX_END = 4;
	private static final int TREASURE_INDEX_START = 1;

	public TreasureFactory(String[] fileContentLines) {
		super(fileContentLines);
	}

	public List<Treasure> getTreasures() {
		List<String> treasures = getMatchingRegLine(GlobalConsts.REGEX_T_X_X_X);

		return extractCoordinates(treasures, TREASURE_INDEX_START, TREASURE_INDEX_END).map(TreasureFactory::createTreasure).toList();
	}

	private static Treasure createTreasure(String[] treasure) {
		var coords = new Coordinates(treasure[COORDS_INDEX_START], treasure[COORDS_INDEX_END]);
		var treasureQuantity = Integer.valueOf(treasure[QUANTITY_INDEX]);

		return new Treasure(coords, treasureQuantity);
	}

}

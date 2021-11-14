package fr.carbonit.treasuremapgame.factory;

import java.util.List;

import fr.carbonit.treasuremapgame.consts.GlobalConsts;
import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.Mountain;

public class MountainFactory extends MapObjectFactory {

	private static final int COORDS_INDEX_END = 1;
	private static final int COORDS_INDEX_START = 0;
	private static final int MOUNTAIN_INDEX_END = 3;
	private static final int MOUNTAIN_INDEX_START = 1;

	public MountainFactory(String[] fileContentLines) {
		super(fileContentLines);
	}

	public List<Mountain> getMountains() {
		List<String> mountains = getMatchingRegLine(GlobalConsts.REGEX_M_X_X);

		return extractCoordinates(mountains, MOUNTAIN_INDEX_START, MOUNTAIN_INDEX_END).map(MountainFactory::createMountain).toList();
	}

	private static Mountain createMountain(String[] mountain) {
		var coords = new Coordinates(mountain[COORDS_INDEX_START], mountain[COORDS_INDEX_END]);

		return new Mountain(coords);
	}

}

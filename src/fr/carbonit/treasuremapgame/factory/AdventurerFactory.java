package fr.carbonit.treasuremapgame.factory;

import java.util.List;

import fr.carbonit.treasuremapgame.consts.GlobalConsts;
import fr.carbonit.treasuremapgame.model.Adventurer;
import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.enums.OrientationEnum;

public class AdventurerFactory extends MapObjectFactory {

	private static final int MOVEMENTS_SEQ_INDEX = 4;
	private static final int NAME_INDEX = 0;
	private static final int ORIENTATION_INDEX = 3;
	private static final int COORDS_INDEX_END = 2;
	private static final int COORDS_INDEX_START = 1;
	private static final int ADVENTURER_INDEX_END = 6;
	private static final int ADVENTURER_INDEX_START = 1;

	public AdventurerFactory(String[] fileContentLines) {
		super(fileContentLines);
	}

	public List<Adventurer> getAdventurers() {
		List<String> adventurers = getMatchingRegLine(GlobalConsts.REGEX_A_XXX_X_X_NEWS_ADG);

		return extractCoordinates(adventurers, ADVENTURER_INDEX_START, ADVENTURER_INDEX_END)
				.map(AdventurerFactory::createAdventurer).toList();
	}

	private static Adventurer createAdventurer(String[] adventurer) {
		var coords = new Coordinates(adventurer[COORDS_INDEX_START], adventurer[COORDS_INDEX_END]);
		var orientation = OrientationEnum.valueOf(adventurer[ORIENTATION_INDEX]);

		String name = adventurer[NAME_INDEX];
		String movementsSequence = adventurer[MOVEMENTS_SEQ_INDEX];

		return new Adventurer(name, orientation, movementsSequence, coords);
	}
}

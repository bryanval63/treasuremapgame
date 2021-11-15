package fr.carbonit.treasuremapgame.factory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import fr.carbonit.treasuremapgame.consts.GlobalConsts;

/**
 * Créé les objets de la map nécéssaires au fonctionnement du jeu
 * 
 * @author bryan
 *
 */
public class MapObjectFactory {

	private String[] fileContentLines = new String[0];

	protected MapObjectFactory(String[] fileContentLines) {
		this.fileContentLines = fileContentLines.clone();
	}

	protected List<String> getMatchingRegLine(String regex) {
		return Arrays.stream(fileContentLines).filter(line -> line.matches(regex)).toList();
	}

	protected Stream<String[]> extractCoordinates(List<String> mountains, int startIndex, int endIndex) {
		return mountains.stream().map(getSplitStringFunction(startIndex, endIndex));
	}

	private static Function<String, String[]> getSplitStringFunction(int startIndex, int endIndex) {
		return line -> Arrays.copyOfRange(line.split(GlobalConsts.PATTERN_DASH.pattern()), startIndex, endIndex);
	}
}

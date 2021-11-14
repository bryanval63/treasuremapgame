package fr.carbonit.treasuremapgame.interfaces.impl;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import fr.carbonit.treasuremapgame.consts.ErrorMsgConsts;
import fr.carbonit.treasuremapgame.consts.GlobalConsts;
import fr.carbonit.treasuremapgame.exceptions.FileContentException;
import fr.carbonit.treasuremapgame.interfaces.IFileContentChecker;

public class FileContentChecker implements IFileContentChecker {

	private static final Pattern PATTERN_REGEX_C_M_T_A = Pattern.compile(GlobalConsts.REGEX_C_M_T_A);
	private static final Pattern PATTERN_REGEX_C_X_X = Pattern.compile(GlobalConsts.REGEX_C_X_X);

	@Override
	public void verifyFileNotEmpty(String[] fileContentLines) throws FileContentException {
		if (fileContentLines.length == 0) {
			throw new FileContentException(ErrorMsgConsts.FICHIER_VIDE);
		}
	}

	@Override
	public void verifyFileHasRightFormatedLines(String[] fileContentLines) throws FileContentException {
		if (hasWrongLines(fileContentLines)) {
			throw new FileContentException(ErrorMsgConsts.ERROR_WRONG_LINES);
		}
	}

	private static boolean hasWrongLines(String[] fileContentLines) {
		return Arrays.stream(fileContentLines).anyMatch(line -> !PATTERN_REGEX_C_M_T_A.matcher(line).matches());
	}

	@Override
	public String verifyOnlyOneMapDefined(String[] fileContentLines) throws FileContentException {
		List<String> map = Arrays.stream(fileContentLines).filter(line -> PATTERN_REGEX_C_X_X.matcher(line).matches())
				.toList();

		if (map.size() != 1) {
			throw new FileContentException(ErrorMsgConsts.ERROR_MAP_COORDS);
		}

		return map.get(0);
	}

}

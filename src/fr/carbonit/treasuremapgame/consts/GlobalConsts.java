package fr.carbonit.treasuremapgame.consts;

import java.util.regex.Pattern;

public final class GlobalConsts {

	private static final String PIPE = "|";

	public static final String RETURN = "\n";
	public static final String DASH = " - ";
	public static final String FILE_PATH_IN = "src/resources/params.txt";
	public static final String FILE_PATH_OUT = "src/resources/results.txt";

	public static final String REGEX_C_X_X = "^C - \\d+ - \\d+$";
	public static final String REGEX_M_X_X = "^M - \\d+ - \\d+$";
	public static final String REGEX_T_X_X_X = "^T - \\d+ - \\d+ - \\d+$";
	public static final String REGEX_A_XXX_X_X_NEWS_ADG = "^A - \\w+ - \\d+ - \\d+ - [NEWS] - [ADG]+$";
	public static final String REGEX_C_M_T_A = REGEX_C_X_X + PIPE + REGEX_M_X_X + PIPE + REGEX_T_X_X_X + PIPE
			+ REGEX_A_XXX_X_X_NEWS_ADG;

	public static final Pattern PATTERN_DASH = Pattern.compile(DASH);

	private GlobalConsts() {
		throw new IllegalStateException("Constants class");
	}
}

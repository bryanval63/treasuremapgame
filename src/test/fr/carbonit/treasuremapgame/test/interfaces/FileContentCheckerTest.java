package fr.carbonit.treasuremapgame.test.interfaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.carbonit.treasuremapgame.consts.ErrorMsgConsts;
import fr.carbonit.treasuremapgame.exceptions.FileContentException;
import fr.carbonit.treasuremapgame.interfaces.impl.FileContentChecker;

public class FileContentCheckerTest {

	private static final String C_1_2 = "C - 1 - 2";

	@Test
	public void verifyFileNotEmpty_whenEmptyFile_thenShouldThrowNewFileContentException() {
		Exception exception = assertThrows(FileContentException.class,
				() -> new FileContentChecker().verifyFileNotEmpty(new String[0]));

		String actualMessage = exception.getMessage();

		assertEquals(actualMessage, ErrorMsgConsts.FICHIER_VIDE);
	}

	@Test
	public void verifyFileHasRightFormatedLines_whenWrongLines_thenShouldThrowNewFileContentException() {
		String[] fileContentLines = { "123" };

		Exception exception = assertThrows(FileContentException.class,
				() -> new FileContentChecker().verifyFileHasRightFormatedLines(fileContentLines));

		String actualMessage = exception.getMessage();

		assertEquals(actualMessage, ErrorMsgConsts.ERROR_WRONG_LINES);
	}

	@Test
	public void verifyOnlyOneMapDefined_whenMultipleMapLines_thenShouldThrowNewFileContentException() {
		String[] fileContentLines = { C_1_2, "C - 2 - 3" };

		Exception exception = assertThrows(FileContentException.class,
				() -> new FileContentChecker().verifyOnlyOneMapDefined(fileContentLines));

		String actualMessage = exception.getMessage();

		assertEquals(actualMessage, ErrorMsgConsts.ERROR_MAP_COORDS);
	}

	@Test
	public void verifyOnlyOneMapDefined_whenOneMapLines_thenShouldReturnMapInfo() throws FileContentException {
		String[] fileContentLines = { C_1_2 };

		String actual = new FileContentChecker().verifyOnlyOneMapDefined(fileContentLines);

		assertEquals(C_1_2, actual);
	}
}

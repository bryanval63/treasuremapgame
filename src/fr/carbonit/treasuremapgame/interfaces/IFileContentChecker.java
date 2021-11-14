package fr.carbonit.treasuremapgame.interfaces;

import fr.carbonit.treasuremapgame.exceptions.FileContentException;

public interface IFileContentChecker {

	void verifyFileNotEmpty(String[] fileContentLines) throws FileContentException;

	void verifyFileHasRightFormatedLines(String[] fileContentLines) throws FileContentException;

	String verifyOnlyOneMapDefined(String[] fileContentLines) throws FileContentException;
}

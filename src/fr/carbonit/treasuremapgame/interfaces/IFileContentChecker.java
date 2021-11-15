package fr.carbonit.treasuremapgame.interfaces;

import fr.carbonit.treasuremapgame.exceptions.FileContentException;

/**
 * Permet de vérifier que la structure du fichier en entrée est correcte au bon
 * déroulement du jeu
 * 
 * @author bryan
 *
 */
public interface IFileContentChecker {

	void verifyFileNotEmpty(String[] fileContentLines) throws FileContentException;

	void verifyFileHasRightFormatedLines(String[] fileContentLines) throws FileContentException;

	String verifyOnlyOneMapDefined(String[] fileContentLines) throws FileContentException;
}

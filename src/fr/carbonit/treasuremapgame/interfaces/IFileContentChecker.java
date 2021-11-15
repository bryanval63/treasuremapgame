package fr.carbonit.treasuremapgame.interfaces;

import fr.carbonit.treasuremapgame.exceptions.FileContentException;

/**
 * Permet de v�rifier que la structure du fichier en entr�e est correcte au bon
 * d�roulement du jeu
 * 
 * @author bryan
 *
 */
public interface IFileContentChecker {

	void verifyFileNotEmpty(String[] fileContentLines) throws FileContentException;

	void verifyFileHasRightFormatedLines(String[] fileContentLines) throws FileContentException;

	String verifyOnlyOneMapDefined(String[] fileContentLines) throws FileContentException;
}

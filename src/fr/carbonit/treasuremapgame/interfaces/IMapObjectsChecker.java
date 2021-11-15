package fr.carbonit.treasuremapgame.interfaces;

import fr.carbonit.treasuremapgame.exceptions.FileContentException;

/**
 * Permet de v�rifier si le contenu des fichiers est coh�rent pour la cr�ation
 * du jeu
 * 
 * @author bryan
 *
 */
public interface IMapObjectsChecker {

	void checkDistinctCoordinates() throws FileContentException;

	void checkNumberOfEntities() throws FileContentException;

	void checkCoordinatesValues() throws FileContentException;
}

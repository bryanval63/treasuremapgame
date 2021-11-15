package fr.carbonit.treasuremapgame.interfaces;

import fr.carbonit.treasuremapgame.exceptions.FileContentException;

/**
 * Permet de vérifier si le contenu des fichiers est cohérent pour la création
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

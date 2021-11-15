package fr.carbonit.treasuremapgame.interfaces;

import fr.carbonit.treasuremapgame.exceptions.FileContentException;
import fr.carbonit.treasuremapgame.exceptions.FileException;
import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.GameMap;

/**
 * Actions sur les fichiers
 * 
 * @author bryan
 *
 */
public interface IFileContentService {

	void writeFile(GameMap map) throws FileException;

	Coordinates extractMapSize() throws FileContentException;

	String[] getFileContentLines();

}

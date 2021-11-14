package fr.carbonit.treasuremapgame.interfaces.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import fr.carbonit.treasuremapgame.consts.GlobalConsts;
import fr.carbonit.treasuremapgame.exceptions.FileContentException;
import fr.carbonit.treasuremapgame.exceptions.FileException;
import fr.carbonit.treasuremapgame.interfaces.IFileContentChecker;
import fr.carbonit.treasuremapgame.interfaces.IFileContentService;
import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.model.GameMap;
import fr.carbonit.treasuremapgame.model.mapobject.moving.MovingMapObject;
import fr.carbonit.treasuremapgame.model.mapobject.nomoving.NoMovingMapObject;
import fr.carbonit.treasuremapgame.utils.FileUtils;

public class FileContentService implements IFileContentService {

	private static final int COORDS_INDEX_START = 1;
	private static final int COORDS_INDEX_END = 3;

	private String[] fileContentLines = new String[0];
	private IFileContentChecker fileContentChecker;

	public FileContentService(String path, IFileContentChecker fileContentChecker) throws FileException {
		spiltFileContent(FileUtils.readFile(path));
		this.fileContentChecker = fileContentChecker;
	}

	private void spiltFileContent(String fileContent) {
		if (!fileContent.isBlank()) {
			this.fileContentLines = fileContent.split(GlobalConsts.RETURN);
		}
	}

	@Override
	public void verifyFileContent() throws FileContentException {
		fileContentChecker.verifyFileNotEmpty(fileContentLines);
		fileContentChecker.verifyFileHasRightFormatedLines(fileContentLines);
	}

	@Override
	public Coordinates extractMapSize() throws FileContentException {
		String mapLine = extractMapLine();
		String[] size = Arrays.copyOfRange(mapLine.split(GlobalConsts.PATTERN_DASH.pattern()), COORDS_INDEX_START,
				COORDS_INDEX_END);

		return new Coordinates(size[0], size[1]);
	}

	private String extractMapLine() throws FileContentException {
		return fileContentChecker.verifyOnlyOneMapDefined(fileContentLines);
	}

	@Override
	public void writeFile(GameMap map) throws FileException {
		FileUtils.writeFile(getLinesToWrite(map), GlobalConsts.FILE_PATH_OUT);
	}

	private List<String> getLinesToWrite(GameMap map) {
		List<String> adventurerList = map.getAdventurers().stream().map(MovingMapObject::toString).toList();
		List<String> mountainList = map.getMountains().stream().map(NoMovingMapObject::toString).toList();
		List<String> treasuresList = map.getTreasures().stream().filter(treasure -> !treasure.isEmpty())
				.map(NoMovingMapObject::toString).toList();

		return Stream.of(List.of(map.toString()), mountainList, treasuresList, adventurerList)
				.flatMap(Collection::stream).toList();
	}

	@Override
	public String[] getFileContentLines() {
		return fileContentLines.clone();
	}
}

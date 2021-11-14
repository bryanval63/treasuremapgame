package fr.carbonit.treasuremapgame.controller;

import java.util.Arrays;

import fr.carbonit.treasuremapgame.consts.GlobalConsts;
import fr.carbonit.treasuremapgame.exceptions.FileContentException;
import fr.carbonit.treasuremapgame.exceptions.FileException;
import fr.carbonit.treasuremapgame.interfaces.IFileContentChecker;
import fr.carbonit.treasuremapgame.model.Coordinates;
import fr.carbonit.treasuremapgame.utils.FileUtils;

public class FileContentController {

	private static final int COORDS_INDEX_START = 1;
	private static final int COORDS_INDEX_END = 3;

	private String[] fileContentLines = new String[0];
	private IFileContentChecker fileContentChecker;

	public FileContentController(String path, IFileContentChecker fileContentChecker) throws FileException {
		spiltFileContent(FileUtils.readFile(path));
		this.fileContentChecker = fileContentChecker;
	}

	private void spiltFileContent(String fileContent) {
		if (!fileContent.isBlank()) {
			this.fileContentLines = fileContent.split(GlobalConsts.RETURN);
		}
	}

	public void verifyFileContent() throws FileContentException {
		fileContentChecker.verifyFileNotEmpty(fileContentLines);
		fileContentChecker.verifyFileHasRightFormatedLines(fileContentLines);
	}

	public Coordinates extractMapSize() throws FileContentException {
		String mapLine = extractMapLine();
		String[] size = Arrays.copyOfRange(mapLine.split(GlobalConsts.PATTERN_DASH.pattern()), COORDS_INDEX_START,
				COORDS_INDEX_END);

		return new Coordinates(size[0], size[1]);
	}

	private String extractMapLine() throws FileContentException {
		return fileContentChecker.verifyOnlyOneMapDefined(fileContentLines);
	}

	public String[] getFileContentLines() {
		return fileContentLines.clone();
	}
}

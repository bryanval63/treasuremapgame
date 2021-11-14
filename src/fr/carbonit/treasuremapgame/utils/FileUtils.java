package fr.carbonit.treasuremapgame.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import fr.carbonit.treasuremapgame.consts.ErrorMsgConsts;
import fr.carbonit.treasuremapgame.consts.GlobalConsts;
import fr.carbonit.treasuremapgame.exceptions.FileException;

public final class FileUtils {

	private FileUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static String readFile(String path) throws FileException {
		var fileContent = new StringBuilder();

		try (var reader = new BufferedReader(new FileReader(path))) {
			fileContent = readFile(reader);
		} catch (FileNotFoundException e) {
			throw new FileException(ErrorMsgConsts.FICHIER_INEXISTANT, e);
		} catch (IOException e) {
			throw new FileException(ErrorMsgConsts.FICHIER_ERREUR_IO, e);
		}

		return fileContent.toString();
	}

	private static StringBuilder readFile(BufferedReader reader) throws IOException {
		var fileContent = new StringBuilder();
		String currentLine;

		while ((currentLine = reader.readLine()) != null) {
			fileContent.append(currentLine).append(GlobalConsts.RETURN);
		}

		return fileContent;
	}

	public static void writeFile(Iterable<String> contentToWrite, String fileName) throws FileException {
		try (var fileWriter = new FileWriter(fileName)) {
			writeLines(contentToWrite, fileWriter);
		} catch (IOException e) {
			throw new FileException(ErrorMsgConsts.FICHIER_ERREUR_IO, e);
		}
	}

	private static void writeLines(Iterable<String> contentToWrite, FileWriter fileWriter) {
		var printWriter = new PrintWriter(fileWriter);

		contentToWrite.forEach(printWriter::println);
		printWriter.close();
	}
}

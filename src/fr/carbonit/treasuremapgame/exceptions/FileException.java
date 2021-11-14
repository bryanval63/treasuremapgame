package fr.carbonit.treasuremapgame.exceptions;

public class FileException extends Exception {

	public FileException(String errorMessage) {
		super(errorMessage);
	}

	public FileException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}

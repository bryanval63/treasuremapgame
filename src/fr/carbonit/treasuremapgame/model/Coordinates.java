package fr.carbonit.treasuremapgame.model;

import fr.carbonit.treasuremapgame.consts.GlobalConsts;

public class Coordinates {

	private int coordX;
	private int coordY;

	public Coordinates(String coordX, String coordY) {
		this.coordX = Integer.valueOf(coordX);
		this.coordY = Integer.valueOf(coordY);
	}

	public Coordinates(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public void incrementCoordX() {
		coordX++;
	}

	public void incrementCoordY() {
		coordY++;
	}

	public void decrementCoordX() {
		coordX--;
	}

	public void decrementCoordY() {
		coordY--;
	}

	public int getCoordX() {
		return coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	@Override
	public String toString() {
		return new StringBuilder(String.valueOf(coordX)).append(GlobalConsts.DASH).append(coordY).toString();
	}
}

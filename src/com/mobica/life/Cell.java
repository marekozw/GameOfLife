package com.mobica.life;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.mobica.life.excpetions.CellIsDeadException;

public class Cell {
	public enum Coordinate {
		X, Y;
	}

	private final Position position;
	private State nextState;
	private State currentState;

	public Cell(int x, int y) {
		position = new Position(x, y);

	}

	public Set<Cell> getNeightbours() {
		Cell[] cells = generateNeightbours();
		Set<Cell> neightbours = new HashSet<Cell>(Arrays.asList(cells));
		return neightbours;
	}

	public int getX() {
		return getCoordinate(Coordinate.X);
	}

	public int getY() {
		return getCoordinate(Coordinate.Y);
	}

	public boolean isAlive() {
		return currentState.isAlive();
	}

	private int getCoordinate(Coordinate coordinate) {
		return coordinate == Coordinate.X ? position.getX() : position.getY();
	}

	private Cell[] generateNeightbours() {
		int x = position.getX();
		int y = position.getY();

		Cell[] cells = { new Cell(x - 1, y - 1), new Cell(x - 1, y),
				new Cell(x - 1, y + 1), new Cell(x, y - 1), new Cell(x, y + 1),
				new Cell(x + 1, y - 1), new Cell(x + 1, y),
				new Cell(x + 1, y + 1) };

		return cells;
	}

	@Override
	public String toString() {
		return "Cell [position=" + position.getX() + " / " + position.getY()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cell))
			return false;
		Cell other = (Cell) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

}

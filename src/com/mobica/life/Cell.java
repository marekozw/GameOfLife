package com.mobica.life;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cell {
	private final Position position;
	private State nextState;

	public Cell(int x, int y) {
		position = new Position(x, y);

	}

	public Set<Cell> getNeightbours() {
		Cell[] cells = generateNeightbours();
		Set<Cell> neightbours = new HashSet<Cell>(Arrays.asList(cells));
		return neightbours;
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

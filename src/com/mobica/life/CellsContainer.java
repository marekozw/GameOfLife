package com.mobica.life;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CellsContainer {

	public Set<Cell> cells;

	public CellsContainer() {
		cells = new HashSet<Cell>();
	}

	public void killCell(Cell cell) {
		cells.remove(cell);
	}

	public void killCell(int x, int y) {
		killCell(new Cell(x, y));
	}

	public void resurectCell(int x, int y) {
		resurectCell(new Cell(x, y));
	}

	public void resurectCell(Cell cell) {
		cells.add(cell);
	}

	public boolean isCellAlive(Cell cell) {
		return cell.isAlive();
	}

	public int getNeightbourCount(Cell cell) {
		Set<Cell> neightbours = cell.getNeightbours();
		int counter = 0;
		for (Iterator<Cell> iterator = neightbours.iterator(); iterator
				.hasNext();) {
			Cell neightbour = (Cell) iterator.next();
			if (cells.contains(neightbour) & getCellAt(neightbour).isAlive()) {
				// if (isCellOnBoard(neightbour) && neightbour.isAlive()) {
				counter++;
			}
		}

		return counter;
	}

	private boolean isCellOnBoard(Cell cell) {
		if (cell.getX() < 0 || cell.getY() < 0) {
			return false;
		}
		return true;
	}

	private void addRelevantCells() {
		Set<Cell> neightbours = new HashSet<Cell>();
		for (Iterator<Cell> cellIterator = cells.iterator(); cellIterator
				.hasNext();) {
			Cell cell = (Cell) cellIterator.next();
			neightbours.addAll(cell.getNeightbours());

		}

		cells.addAll(neightbours);
	}

	private Cell getCellAt(Cell other) {
		for (Iterator<Cell> cellIterator = cells.iterator(); cellIterator
				.hasNext();) {
			Cell cell = (Cell) cellIterator.next();

			if (cell.equals(other)) {
				return cell;
			}

		}
		return new Cell(-1, -1, State.DEAD);
	}

}

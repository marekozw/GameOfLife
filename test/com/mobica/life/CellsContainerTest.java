package com.mobica.life;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CellsContainerTest {

	private CellsContainer cellContainer;

	@Before
	public void setUp() throws Exception {
		cellContainer = new CellsContainer();
	}

	@After
	public void tearDown() throws Exception {
		cellContainer = null;
	}

	@Ignore
	@Test
	public void shouldCountNeightboursForGivenDeadCell() {
		Cell[] baseCells = { new Cell(1, 1), new Cell(2, 1), new Cell(1, 2),
				new Cell(1, 3) };
		for (int i = 0; i < baseCells.length; i++) {
			Cell cell = baseCells[i];

			cellContainer.resurectCell(cell);

		}

		assertEquals(4, cellContainer.getNeightbourCount(new Cell(2, 2)));
		assertEquals(2, cellContainer.getNeightbourCount(new Cell(2, 3)));
		assertEquals(3, cellContainer.getNeightbourCount(new Cell(0, 2)));
	}

}

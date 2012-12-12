package com.mobica.life;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CellTest {

	private int x = 0;
	private int y = 0;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldBeAbleToRecognizeTwoCellsWithTheSameValues() {

		Cell same1 = new Cell(x, y);
		Cell same2 = new Cell(x, y);

		assertEquals(same1, same2);
	}

	@Test
	public void sohuldNotAllowDuplicatesWithReferences() {
		Cell same1 = new Cell(x, y);
		Cell same2 = new Cell(x, y);

		Set<Cell> set = new HashSet<Cell>();

		// @When
		set.add(same1);
		set.add(same2);

		int expectedLength = 1;
		int actualLength = set.size();

		assertEquals(expectedLength, actualLength);
	}

	@Test
	public void shouldNotAllowDuplicatesWithNewKeyWord() {
		Set<Cell> set = new HashSet<Cell>();

		// @When
		set.add(new Cell(x, y));
		set.add(new Cell(x, y));

		int expectedLength = 1;
		int actualLength = set.size();

		assertEquals(expectedLength, actualLength);
	}

	@Test
	public void shouldContainsAllNeightbours() {
		Cell baseCell = new Cell(10, 10);
		Set<Cell> actualNeightbours = baseCell.getNeightbours();

		assertTrue(actualNeightbours.contains(new Cell(9, 9)));
	}

	@Test
	public void shouldNotContainsAllNonNeightbours() {
		Cell baseCell = new Cell(10, 10);
		Set<Cell> actualNeightbours = baseCell.getNeightbours();

		assertFalse(actualNeightbours.contains(new Cell(8, 9)));
	}

}

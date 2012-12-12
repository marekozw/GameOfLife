/**
 * 
 */
package com.mobica.life;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Marek
 * 
 */
public class StateTest {

	private State state;

	@Test
	public void deadStateShouldReturnFalse() {
		state = State.DEAD;

		assertFalse(state.isAlive());
	}

	@Test
	public void liveStateShouldReturnTrue() {
		state = State.ALIVE;

		assertTrue(state.isAlive());
	}

}

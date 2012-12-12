package com.mobica.life;

public enum State {
	ALIVE(true), DEAD(false);

	private boolean alive;

	State(boolean alive) {
		this.alive = alive;
	}

	public boolean isAlive() {
		return alive;
	}

}

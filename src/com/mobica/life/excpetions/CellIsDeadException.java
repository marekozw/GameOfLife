package com.mobica.life.excpetions;

import com.mobica.life.Position;

@SuppressWarnings("serial")
public class CellIsDeadException extends Exception {

	private static final String MESSAGE = "The following cell is dead ";
	private Position position;

	public CellIsDeadException(Position position) {
		this.position = position;
	}

	@Override
	public String getMessage() {
		int x = position.getX();
		int y = position.getY();

		String message = MESSAGE + "[" + x + " / " + y + "]";

		return message;
	}
}

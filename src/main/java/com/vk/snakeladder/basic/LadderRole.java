package com.vk.snakeladder.basic;

public final class LadderRole extends SquareRole {
	private int transport;

	public LadderRole(Square s, int t) {
		super(s);
		assert t > 0 : "A ladder shift must be positive ";
		transport = t;
	}

	@Override
	public Square landHereOrGoHome() {
		System.out.println("Ladder from " + (square.getPosition()) + " to " + (destination().getPosition()));
		return destination().landHereOrGoHome();
	}

	private Square destination() {
		return square.findRelativeSquare(transport);
	}
}

package com.vk.snakeladder.basic;

public final class SnakeRole extends SquareRole {
	private int transport;
	private int hungerLevel;
	
	public SnakeRole(Square s, int t, int h) {
		super(s);
		assert t < 0 : "A snake shift must be negative ";
		transport = t;
		hungerLevel = h;
	}

	@Override
	public Square landHereOrGoHome(int moves) {
		
		if ( hungerLevel == 0) return square;
		
		hungerLevel = hungerLevel - 1;
		System.out.println("Snake from " + (square.getPosition()) + " to " + (destination().getPosition()));
		return destination().landHereOrGoHome(moves);
	}

	private Square destination() {
		return square.findRelativeSquare(transport);
	}
	
	@Override
	public String getSquareName()
	{
		return "Snake";
	}
}

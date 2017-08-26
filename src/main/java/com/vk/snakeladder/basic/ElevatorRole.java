package com.vk.snakeladder.basic;

public final class ElevatorRole extends SquareRole 
{

	public ElevatorRole(Square s) {
		super(s);
	}


	public Square moveAndLand(int moves) {
		int lastPosition = square.findLastSquare().getPosition();
		int presentPosition = square.getPosition();
		if (presentPosition + moves > lastPosition) {
			System.out.println("Should go to " + (presentPosition + moves) + " beyond last square "
					+ (lastPosition + 1) + " so don ’t move ");
			return square;
		} else {
			System.out.println("Move from " + (square.getPosition()) + " to "

					+ (square.findRelativeSquare(moves).getPosition()));
			return square.findRelativeSquare(moves).landHereOrGoHome(moves);
		}
	}

	@Override
	public Square landHereOrGoHome(int moves) {
		
		int presentPosition = square.getPosition();
		int newposition = square.moveUpInZigZagMatrix(moves);
		int lastPosition = square.findLastSquare().getPosition();
		if ( newposition  > lastPosition) {
			System.out.println("Should go to " + (newposition) + " beyond last square "
					+ (lastPosition + 1) + " so don ’t move ");
			return square;
		} else {
			System.out.println("Elevator from " + (square.getPosition()) + " to " + square.findRelativeSquare((newposition - presentPosition)).getPosition());
			return square.findRelativeSquare( (newposition - presentPosition) );
		}
	}
	
}

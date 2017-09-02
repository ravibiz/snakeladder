package com.vk.snakeladder.basic;

public final class TrampolineRole extends SquareRole 
{

	public TrampolineRole(Square s) {
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
			System.out.println("Trampoline Move from " + (square.getPosition()) + " to "

					+ (square.findRelativeSquare(moves).getPosition()));
			return square.findRelativeSquare(moves).landHereOrGoHome(moves);
		}
	}

	@Override
	public Square landHereOrGoHome(int moves) {
		
		int lastPosition = square.findLastSquare().getPosition();
		int presentPosition = square.getPosition();
		if (presentPosition + moves > lastPosition) {
			System.out.println("Should go to " + (presentPosition + moves) + " beyond last square "
					+ (lastPosition + 1) + " so don ’t move ");
			return square;
		} else {
			System.out.println("Trampoline from " + (square.getPosition()) + " to " + square.findRelativeSquare(moves).getPosition());
			return square.findRelativeSquare(moves);
		}
	}
	
	@Override
	public String getSquareName()
	{
		return "Trampoline";
	}
	
}

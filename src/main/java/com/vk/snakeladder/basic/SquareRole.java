package com.vk.snakeladder.basic;

public abstract class SquareRole {
	protected Square square = null;

	public SquareRole(Square s) {
		assert s != null : " Null square for square role ";
		square = s;
	}

	public boolean isOccupied() {
		return square.getPlayer() != null;
	}

	public boolean isFirstSquare() {
		return false;
	}

	public boolean isLastSquare() {
		return false;
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
			return square.findRelativeSquare(moves).landHereOrGoHome();
		}
	}

	public Square landHereOrGoHome() {
		if (square.isOccupied()) {
			System.out.println("square " + (square.getPosition()) + " is occupied ");
		} else {
			System.out.println("land at " + (square.getPosition()));
		}
		
		Square newSquare = square.moveEndIfStartingRow();
		if ( newSquare != null )
			return newSquare.isOccupied() ? newSquare.findFirstSquare() : newSquare;
		else
			return square.isOccupied() ? square.findFirstSquare() : square;
	}

	
	public Square landHereOrGoHome(int moves) {
		return square;
	}
	
	public Square apply(Player player)
	{
		player.moved();
		return square;
	}
	
	public void enter(Player player) {
		square.setPlayer(player);
		player.setSquare(square);
	}

	public void leave(Player player) {
		square.setPlayer(null);
	}
}
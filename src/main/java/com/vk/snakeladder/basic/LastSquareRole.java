package com.vk.snakeladder.basic;

public final class LastSquareRole extends SquareRole {

	public LastSquareRole(Square s) {
		super(s);
	}

	@Override
	public boolean isLastSquare() {
		return true;
	}
	
	@Override
	public String getSquareName()
	{
		return "Regular";
	}
}
package com.vk.snakeladder.basic;

public final class PitStopRole extends SquareRole {

	protected Square square = null;
	protected int energy = 0;
	
	public PitStopRole(Square s, int e) {
		super(s);
		square = s;
		energy = e;
	}
	
	@Override
	public Square apply(Player player)
	{
		player.moved();
		player.incrementEngergy(energy);
		System.out.println("PitStop energy gained at " + square.getPosition() + " and total = " + player.getEnergy());
		return square;
	}
	
	@Override
	public String getSquareName()
	{
		return "PitStop";
	}
}
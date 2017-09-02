package com.vk.snakeladder.basic;

public final class Player {
	private Square square = null;
	private String name;
	private int energy;
	private int startEnergy;
	
	
	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	public int position() {
		return square.getPosition();
	}

	public String getName() {
		return name;
	}

	public Player(String strname, int playerEnegry) {
		name = strname;
		energy = playerEnegry;
		startEnergy = playerEnegry;
	}
	
	public int getEnergy()
	{
		return energy;
	}


	public void moved()
	{
		energy = energy - 1;
	}
	
	public void incrementEngergy(int e)
	{
		energy = energy + e;
	}
	
	public int getStartEnergy()
	{
		return startEnergy;
	}

	public void recharge()
	{
		energy = startEnergy;
	}
		
	@Override
	public String toString() {
		return name + "(Enery=" + energy + ")";
	}

	public boolean wins() {
		return square.isLastSquare();
	}

	public void moveForward(int moves) {
		assert moves > 0 : "non - positive moves ";
		
		
		square.leave(this);
		square = square.moveAndLand(moves);
		square = square.apply(this);
		square.enter(this);
		if (this.energy == 0) square.leave(this);
		
		if ( ! square.getRole().equalsIgnoreCase("Regular"))
		{
			moveForward(moves);
		}
	}
	
	public String getConstruct(int pos) {
		return square.getRole();
	}
}
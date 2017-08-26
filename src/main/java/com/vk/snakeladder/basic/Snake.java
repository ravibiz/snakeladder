package com.vk.snakeladder.basic;

public class Snake 
{
	private int fromPosition;
	private int toPosition;
	private int hungerLevel;
	
	public Snake(int fromPosition, int toPosition, int hungerLevel) {
		this.fromPosition = fromPosition;
		this.toPosition = toPosition;
		this.hungerLevel = hungerLevel;
	}
	
	public int getFromPosition() {
		return fromPosition;
	}
	
	public void setFromPosition(int fromPosition) {
		this.fromPosition = fromPosition;
	}
	
	public int getToPosition() {
		return toPosition;
	}
	
	public void setToPosition(int toPosition) {
		this.toPosition = toPosition;
	}

	public int getHungerLevel() {
		return hungerLevel;
	}

	public void setHungerLevel(int hungerLevel) {
		this.hungerLevel = hungerLevel;
	}
	
	
	
}


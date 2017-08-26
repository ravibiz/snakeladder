package com.vk.snakeladder.basic;

public class Ladder 
{
	private int fromPosition;
	private int toPosition;
	
	public Ladder(int fromPosition, int toPosition) {
		this.fromPosition = fromPosition;
		this.toPosition = toPosition;
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
}

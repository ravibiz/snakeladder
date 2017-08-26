package com.vk.snakeladder.basic;

public class PitStop 
{
	private int position;
	private int energy;
	
	public PitStop(int position, int energy) {
		this.position = position;
		this.energy = energy;
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	
}

package com.vk.snakeladder.basic;

public class Die 
{

	private static final int MINVALUE = 1;
	private static final int MAXVALUE = 6;

	public static int roll() 
	{
		return random(MINVALUE, MAXVALUE);
	}

	private static int random(int min, int max) 
	{
		assert min < max;
		return (int) (min + Math.round((max - min) * Math.random()));
	}
	
}

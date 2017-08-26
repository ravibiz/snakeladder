package com.vk.snakeladder.basic;

public class TEst 
{
	public static void main(String[] args) {
		
		//int x = (int) Math.ceil( 1 / (double) 5);
		int currentPosition = 3;
		int sqrtNo = 5;
		int rollValue = 2;
		int x = moveUpInZigZagMatrix(currentPosition, sqrtNo, rollValue);
		System.out.println(x);
	}
	
	public static int moveUpInZigZagMatrix(int currentPosition, int sqrtNo, int rollValue)
	{
		int newposition = currentPosition;
		int currentRow = (int) Math.ceil( currentPosition / (double) sqrtNo);
		
		int startRow = currentRow;
		while ( startRow < (currentRow + rollValue) )
		{
			int colValueInRow = (newposition % sqrtNo);
			colValueInRow = colValueInRow == 0 ? sqrtNo : colValueInRow;
			newposition = newposition + 2 * (sqrtNo - colValueInRow ) + 1;
			startRow = startRow + 1;
		}
		return newposition;
	}
}
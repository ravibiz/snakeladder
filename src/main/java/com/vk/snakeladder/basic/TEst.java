package com.vk.snakeladder.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TEst 
{
	public static void main(String[] args) {
		
//		//int x = (int) Math.ceil( 1 / (double) 5);
//		int currentPosition = 3;
//		int sqrtNo = 5;
//		int rollValue = 2;
//		int x = moveUpInZigZagMatrix(currentPosition, sqrtNo, rollValue);
//		System.out.println(x);
		
		askinput();
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
	
	public static void askinput()
	{
		
		
		while(true)
		{
			try
			{
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        System.out.print("Enter Dice values");
		        String diceStr = br.readLine();
		        try{
		        	String [] diveV = diceStr.trim().split(",");
		            int first = Integer.parseInt(diveV[0]);
		            int second = Integer.parseInt(diveV[1]);
		            System.out.println(first + ":" + second);
		        }catch(NumberFormatException nfe){
		            System.err.println("Invalid Format!");
		        }
		        
					
				
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
}
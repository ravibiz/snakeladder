package com.vk.snakeladder.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public final class Game 
{
	private LinkedList<Player> players = new LinkedList<Player>();
	private Board board = null;
	private Player winner;

	private void movePlayer(int roll) 
	{
		Player currentPlayer = players.remove();
		
		if ( currentPlayer.getEnergy() == 0 )
		{
			currentPlayer.recharge();
			board.firstSquare().enter(currentPlayer);
		}
		
		currentPlayer.moveForward(roll);
		players.add(currentPlayer);
		if (currentPlayer.wins()) {
			winner = currentPlayer;
		}
	}

	public Game(String[] playerNames, int playerEnegry, int numSquares, List<Snake> snakes, List<Ladder> ladders,
			List<Trampoline> tramploines, List<Elevator> elevators, List<PitStop> pitStops) {
		makeBoard(numSquares, snakes, ladders, tramploines, elevators, pitStops);
		makePlayers(playerNames, playerEnegry);
	}

	private void makeBoard(int numSquares, List<Snake> snakes, List<Ladder> ladders,
			List<Trampoline> tramploines, List<Elevator> elevators, List<PitStop> pitStops) {
		board = new Board(numSquares);
		board.makeLadders(ladders);
		board.makeSnakes(snakes);
		board.makeTrampolines(tramploines);
		board.makeElevators(elevators);
		board.makePitStops(pitStops);
	}

	private void makePlayers(String[] playerNames, int playerEnegry) 
	{
		assert playerNames.length > 0 : "There must be some player ";
		System.out.println("Players are : ");
		int i = 1;
		for (String str : playerNames) {
			Player player = new Player(str, playerEnegry);
			players.add(player);
			System.out.println(i + ". " + str);
			i++;
		}
	}

	public void play() 
	{
		assert !players.isEmpty() : "No players to play ";
		assert board != null : "No scoreboard to play ";

		startGame();

		System.out.println("Initial state : \n" + this);
		
		while(true)
		{
			try
			{
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        System.out.print("Enter Dice values for players first:second");
		        String diceStr = br.readLine();
		        try
		        {
		        	 String [] diveV = diceStr.trim().split(",");
		        	 
		        	 int first = Integer.parseInt(diveV[0]);
		        	 int second = Integer.parseInt(diveV[1]);
		            
		            if ( notOver())
		            {
		            	System.out.println("Rolls for first and second " + first + ":" + second);
		    			movePlayer(first);
		    			movePlayer(second);
		    			System.out.println("State : \n" + this);
		            }
		            else
		            {
		            	break;
		            }
		            
		        }catch(NumberFormatException nfe){
		            System.err.println("Invalid Format!");
		        }
		        
					
				
			}
			catch(Exception e)
			{
				
			}
		}
		
		
		//System.out.println(winner + " has won.");
	}

	private void startGame() {
		placePlayersAtFirstSquare();
		winner = null;
	}

	private void placePlayersAtFirstSquare() {
		for (Player player : players) {
			board.firstSquare().enter(player);
		}
	}

	private void printConstruct(int pos)
	{
		System.out.println(board.getConstruct(pos));
	}
	
	private boolean notOver() {
		return winner == null;
	}

	@Override
	public String toString() {
		String str = new String();
		for (Player player : players) {
			str += player.getName() + " is at square " + (player.position()) + "\n";
		}
		return str;
	}

	Player currentPlayer() {
		assert players.size() > 0;
		return players.peek();
	}
}
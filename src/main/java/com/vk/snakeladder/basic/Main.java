package com.vk.snakeladder.basic;

import java.util.ArrayList;
import java.util.List;

public final class Main {
	public static void main(String[] args) 
	{
		String[] playerNames = { "Kumar", "John"};
		int playerEnegry = 21;
		
		int numSquares = 64;
		
		List<Snake> snakes = new ArrayList<>();
		snakes.add(new Snake(30, 2, 5));
		snakes.add(new Snake(39, 24, 2));
		snakes.add(new Snake(54, 35, 3));
		
		List<Ladder> ladders = new ArrayList<>();
		ladders.add(new Ladder(13, 38));
		ladders.add(new Ladder(18, 33));
		ladders.add(new Ladder(46, 63));
		
		List<Trampoline> trampolines = new ArrayList<>();
		trampolines.add(new Trampoline(20));
		trampolines.add(new Trampoline(36));

		List<Elevator> elevators = new ArrayList<>();
		elevators.add(new Elevator(11));
		elevators.add(new Elevator(31));
		
		List<PitStop> pitstops = new ArrayList<>();
		pitstops.add(new PitStop(19, 5));
		pitstops.add(new PitStop(27, 10));
		pitstops.add(new PitStop(44, 15));
		
		Game game = new Game(playerNames, playerEnegry, numSquares, snakes, ladders, trampolines, elevators, pitstops);
		game.play();
	}
}

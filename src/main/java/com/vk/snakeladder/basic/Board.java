package com.vk.snakeladder.basic;

import java.util.ArrayList;
import java.util.List;

public final class Board {
	private ArrayList<Square> squares = new ArrayList<Square>();
	private static int MINNUMSQUARES = 9;
	private int sqrtNo = 3;
	
	public Board(int numSquares) {

		assert numSquares > MINNUMSQUARES : "There must be at least " + MINNUMSQUARES + " squares ";
		makeSquares(numSquares);
	}

	private void makeSquares(int numSquares) {
		System.out.println("There are " + numSquares + " squares ");
		
		int sqrt = (int) Math.sqrt(numSquares);
		assert (sqrt * sqrt != numSquares );
		
		sqrtNo = sqrt;
		
		for (int position = 1; position <= numSquares; position++) {
			Square square = new Square(position, this);
			squares.add(square);
			square.setSquareRole(new RegularSquareRole(square));
		}
		firstSquare().setSquareRole(new FirstSquareRole(firstSquare()));
		lastSquare().setSquareRole(new LastSquareRole(lastSquare()));
	}

	public int getSqrtNo()
	{
		return sqrtNo;
	}
	
	public Square firstSquare() {
		return squares.get(0);
	}

	public Square lastSquare() {
		return squares.get(squares.size() - 1);
	}

	public Square findSquare(int position) {
		assert (position > 0) && (position <= numberOfSquares()) : " inexistent square ";
		return squares.get(position - 1);
	}

	private int numberOfSquares() {
		assert !squares.isEmpty();
		return squares.size();
	}

	public void makeSnakes(List<Snake> snakes) 
	{
		for (Snake snake: snakes) 
		{
			int fromPosition = snake.getFromPosition();
			int toPosition = snake.getToPosition();
			int transport = toPosition - fromPosition;

			assert transport < 0 : "In snake , destination after origin ";
			assert (toPosition > 0) && (toPosition < numberOfSquares() - 1);
			assert (fromPosition < numberOfSquares() - 1) && (fromPosition > 0);

			System.out.println("Snake from " + (fromPosition) + " to " + (toPosition));

			Square snakeSquare = squares.get(fromPosition - 1);
			snakeSquare.setSquareRole(new SnakeRole(snakeSquare, transport, snake.getHungerLevel()));
		}
	}
	

	public void makeLadders(List<Ladder> ladders) {
		for (Ladder ladder : ladders) {

			int fromPosition = ladder.getFromPosition();
			int toPosition = ladder.getToPosition();

			int transport = toPosition - fromPosition;

			assert transport > 0 : "In ladder , origin after destination ";
			assert (toPosition < numberOfSquares()) && (toPosition > 0);
			assert (fromPosition > 0) && (fromPosition < numberOfSquares());

			System.out.println("Ladder from " + (fromPosition) + " to " + (toPosition));

			Square ladderSquare = squares.get(fromPosition - 1);
			ladderSquare.setSquareRole(new LadderRole(ladderSquare, transport));
		}
	}
	
	public void makeTrampolines(List<Trampoline> tramploines) {
		for (Trampoline trampoline : tramploines) {

			assert (trampoline.getPosition() < numberOfSquares()) && (trampoline.getPosition() > 1);
			
			System.out.println("Trampoline at " + (trampoline.getPosition()));

			Square trampolineSquare = squares.get(trampoline.getPosition() - 1);
			trampolineSquare.setSquareRole( new TrampolineRole(trampolineSquare) );
		}
	}
	
	public void makeElevators(List<Elevator> elevators) {
		for (Elevator elevator : elevators) {

			assert (elevator.getPosition() < numberOfSquares()) && (elevator.getPosition() > 1);
			
			System.out.println("Elevator at " + (elevator.getPosition()));

			Square elevatorSquare = squares.get(elevator.getPosition() - 1);
			elevatorSquare.setSquareRole( new ElevatorRole(elevatorSquare) );
		}
	}
	
	public void makePitStops(List<PitStop> pitStops) {
		for (PitStop pitStop : pitStops) {

			assert pitStop.getEnergy() > 0 : "Pitstop energy should be greater than 0 ";
			assert (pitStop.getPosition() < numberOfSquares()) && (pitStop.getPosition() > 1);
			
			System.out.println("Pitstop at " + (pitStop.getPosition()) + " with energy " + (pitStop.getEnergy()));

			Square pitStopSquare = squares.get(pitStop.getPosition() - 1);
			pitStopSquare.setSquareRole(new PitStopRole(pitStopSquare, pitStop.getEnergy()));
		}
	}
}
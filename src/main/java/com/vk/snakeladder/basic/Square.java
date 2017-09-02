package com.vk.snakeladder.basic;

public class Square {
	private Board board = null;
	private Player player = null;
	private int position;
	private SquareRole squareRole = null;
	
	public Square(int pos, Board b) {
		assert pos >= 0 : " Square number must be positive or zero ";
		position = pos;
		board = b;
	}
	
	public String getRole()
	{
		return squareRole.getSquareName();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player p) {
		player = p;
	}

	public int getPosition() {
		return position;
	}

	public void setSquareRole(SquareRole sr) {
		assert sr != null;
		squareRole = sr;
	}

	public SquareRole getSquareRole()
	{
		return squareRole;
	}
	
	public boolean isOccupied() {
		return squareRole.isOccupied();
	}

	public boolean isLastSquare() {
		return squareRole.isLastSquare();
	}

	public Square moveAndLand(int moves) {
		return squareRole.moveAndLand(moves);
	}


	public Square landHereOrGoHome(int moves) {
		return squareRole.landHereOrGoHome(moves);

	}
	
	public Square apply(Player player)
	{
		return squareRole.apply(player);
	}

	public void enter(Player p) {
		squareRole.enter(p);
	}

	public void leave(Player p) {
		squareRole.leave(p);
	}

	public Square findRelativeSquare(int shift) {
		return board.findSquare(position + shift);
	}


	public Square findFirstSquare() {
		return board.firstSquare();
	}

	public Square findLastSquare() {
		return board.lastSquare();
	}

	public Square moveEndIfStartingRow()
	{
		int rowNo = position / board.getSqrtNo(); 
		int posInRow = position % board.getSqrtNo();
		if ( rowNo > 1 && posInRow == 1)
		{
			return board.findSquare(position + board.getSqrtNo() - 1);
		}
		return null;
	}
	
	public int moveUpInZigZagMatrix( int moves)
	{
		int newposition = position;
		int currentRow = (int) Math.ceil( position / (double) board.getSqrtNo());
		
		int startRow = currentRow;
		while ( startRow < (currentRow + moves) )
		{
			int colValueInRow = (newposition % board.getSqrtNo() );
			colValueInRow = colValueInRow == 0 ? board.getSqrtNo() : colValueInRow;
			newposition = newposition + 2 * ( board.getSqrtNo() - colValueInRow ) + 1;
			startRow = startRow + 1;
		}
		return newposition;
	}
	
	public void addEnergyToPlayer()
	{
		player.incrementEngergy(position);
	}
}
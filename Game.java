/**
 * This class generates the game board & tracks movement of the player.
 * 
 * @author Chris Myhre
 * @version 1.1 (CS-131 Final Project)
 * Spring 2023 (04/23/2023)
 */
public class Game{
	private int movesLeft = 100;//Tracks number of moves the player has done.
	private int score = 0;//Tracks the total point value of all gems collected.
	private int playerRow = 7;//Tracks the player's row # on the board, starts in the middle (7,7).
	private int playerColumn = 7;//Tracks the player's column # on the board, starts in the middle (7,7).
	private int gemsRemaining = 0;//Tracks how many gems are left on the board.
	private String[][] board = new String[15][15];//String array is the board the player will see.
	private Gem gem[][] = new Gem[15][15];//Gem array tracks where gems are generated.
	
	
	/*
	 * default generate() constructor, generates the board and gems.
	 */
	public void generate() {
		for (int i = 0; i<15; i++) {
			for(int j = 0; j<15; j++) {
				double r = 100*Math.random();
				/*
				 * if-else statement that generates a gem if 100r % Difficulty is 0.
				 * This determines if a gem will spawn on a given tile.
				 */
				if((int)r%2==0) {
					board[i][j] = " * ";
					gem[i][j] = new Gem();
					gem[i][j].setValue(1);
					gemsRemaining = gemsRemaining+1;
				}//end if statement
				else {
					board[i][j] = " O ";
					gem[i][j] = new Gem();
					gem[i][j].setValue(0);
				}//end else statement
			}//end inner loop
		}//end outer loop
		
		
		/*
		 * A filled in square is placed on the board to show where the player 
		 * is currently located. The filled in square starts at (7,7) because
		 * that is where the player starts at.
		 */
		board[7][7]="YOU";
	}//end setupGems()
	
	
	/**
	 * Getter for score
	 * @return score
	 */
	public int getScore() {
		return score;
	}//end getScore()
	
	
	/**
	 * Setter for score
	 * @param s
	 */
	public void setScore(int s) {
		score=s;
	}//end setScore()
	
	
	/**
	 * Getter for getPlayerRow
	 * @return getPlayerRow
	 */
	public int getPlayerRow() {
		return playerRow;
	}//end getPlayerRow()
	
	
	/**
	 * Setter for playerRow
	 * @param r
	 */
	public void setPlayerRow(int r) {
		playerRow=r;
	}//end setPlayerRow()
	
	
	/**
	 * Getter for getPlayerColumn
	 * @return playerColumn
	 */
	public int getPlayerColumn() {
		return playerColumn;
	}//end getPlayerColumn()
	
	
	/**
	 * Setter for playerColumn
	 * @param c
	 */
	public void setPlayerColum(int c) {
		playerColumn=c;
	}//end setPlayerColumn()
	
	
	/**
	 * Getter for movesLeft
	 * @return movesLeft
	 */
	public int getMovesLeft() {
		return movesLeft;
	}//end getMovesLeft()
	
	
	/**
	 * Setter for movesLeft
	 * @param m
	 */
	public void setMovesLeft(int m) {
		movesLeft=m;
	}//end setMovesLeft()
	
	
	/**
	 * Getter for gemsRemaining
	 * @return gemsRemaining
	 */
	public int getGemsRemaining() {
		return gemsRemaining;
	}//end getGemsRemaining()
	
	
	/**
	 * Setter for gemsRemaining
	 * @param g
	 */
	public void setGemsRemaining(int g) {
		gemsRemaining=g;
	}//end setGemsRemaining()
	
	
	/*
	 * The set of instructions for when the player moves up.
	 * (Moves are 1 space each upwards)
	 */
	public void moveUp() {
		if(playerRow>0) {
			board[playerRow][playerColumn] = " O ";
			playerRow=playerRow-1;
			board[playerRow][playerColumn] = "YOU";
		}//end if statement
		else {
			board[playerRow][playerColumn] = " O ";
			playerRow=14;
			board[playerRow][playerColumn] = "YOU";
		}//end else statement
	}//end moveUp()
	
	
	/*
	 * The set of instructions for when the player moves down.
	 * (Moves are 1 space each downwards)
	 */
	public void moveDown() {
		if(playerRow<14) {
			board[playerRow][playerColumn] = " O ";
			playerRow=playerRow+1;
			board[playerRow][playerColumn] = "YOU";
		}//end if statement
		else {
			board[playerRow][playerColumn] = " O ";
			playerRow=0;
			board[playerRow][playerColumn] = "YOU";
		}//end else statement
	}//end moveDown()
	
	
	/*
	 * The set of instructions for when the player moves left.
	 * (Moves are 1 space each to the left)
	 */
	public void moveLeft() {
		if(playerColumn>0) {
			board[playerRow][playerColumn] = " O ";
			playerColumn=playerColumn-1;
			board[playerRow][playerColumn] = "YOU";
		}//end if statement
		else {
			board[playerRow][playerColumn] = " O ";
			playerColumn=14;
			board[playerRow][playerColumn] = "YOU";
		}//end else statement
	}//end moveLeft()
	
	
	/*
	 * The set of instructions for when the player moves right.
	 * (Moves are 1 space each to the right)
	 */
	public void moveRight() {
		if(playerColumn<14) {
			board[playerRow][playerColumn] = " O ";
			playerColumn=playerColumn+1;
			board[playerRow][playerColumn] = "YOU";
		}//end if statement
		else {
			board[playerRow][playerColumn] = " O ";
			playerColumn=0;
			board[playerRow][playerColumn] = "YOU";
		}//end else statement
	}//end moveRight()
	
	
	/*
	 * This method checks the player's current location for gems and if there is a gem,
	 * to add its value to the player's score and make the gem valueless for the rest
	 * of the game so it can only be collected once.
	 */
	public void checkLocation() {
		movesLeft = movesLeft - 1;
		int gemValue = gem[playerRow][playerColumn].getValue();
		if(gemValue>0) {
			gem[playerRow][playerColumn].setValue(0);
			setScore(score+gemValue);
			board[playerRow][playerColumn] = "YOU";
			System.out.println("\nYou got a gem! Score +" + gemValue);
			gemsRemaining=gemsRemaining-1;
		}//end if statement
	}//end checkLocation()
	
	
	/*
	 * This method checks if the player has any gems or moves left. If the player runs
	 * out of gems or moves, the game ends with the appropriate message printed.
	 */
	public void checkBoard() {
		if(gemsRemaining==0) {
			System.out.println("\nGame Over: Congrats you collected all the gems! Rerun the game to play again.");
			System.out.println("Score: " + score + "  Moves Left: " + movesLeft);
			System.exit(0);
		}//if statement
		else if(movesLeft==0) {
			System.out.println("\nGame Over: You ran out of moves! Rerun the game to play again.");
			System.out.println("Score: " + score + "  Moves Left: " + movesLeft);
			System.exit(0);
		}//end else if statement
	}//end checkBoard()
	
	
	/*
	 * This method prints the player's move counter, score & the game's board.
	 */
	public void printBoard() {
		StringBuilder sb = new StringBuilder("\n=====================================================================");
		sb.append("\n" + " Score: " + score + "  Moves Left: " + movesLeft);
		for(int i=0; i<15;i++) {
		sb.append("\n");
			for(int j=0;j<15;j++) {
				sb.append(" " + board[i][j]);
			}//end inner for loop
		}//end outer for loop
		System.out.print(sb.toString());
	}//end printBoard()
}//end Game class
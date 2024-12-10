package TicTacToe;

public class TicTacToe {
	private boolean turn;
	boolean gameOver;
	String winner;
	
	public TicTacToe() {
		this.turn = true;
		this.gameOver = false;
		this.winner = null;
	}
	
	final int[][] winningLines = {{0,1,2}, {3,4,5}, {6,7,8},
							{0,3,6}, {1,4,7}, {2,5,8},
							{0,4,8}, {2,4,6}};
	
	public String grid[] = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
	
	
	public String getTextForButton(String curText) {
		if(turn) {
			if(curText.equals(" ")) {
				turn = !turn;
				return "X";
			}
		}else {
			if(curText.equals(" ")) {
				turn = !turn;
				return "O";
			}
		}
		return curText;
	}
	
	public boolean hasWon() {
		for(int[] dimension : winningLines) {
			if (grid[dimension[0]].equals(grid[dimension[1]]) && grid[dimension[1]].equals(grid[dimension[2]]) && !grid[dimension[0]].equals(" ")) { 
				this.winner = grid[dimension[0]];
				this.gameOver = true;
				return true;
			}
		}
		return false;
	}
	
	public void clear() {
		for(int i = 0; i < grid.length; i++) {
			grid[i] = " ";
		}
		this.turn = true;
		this.gameOver = false;
		this.winner = null;
	}
	
	public boolean isDraw() {
		for(String button : grid) {
			if(button.equals(" ")) return false;
		}
		return true;
	}
	
}

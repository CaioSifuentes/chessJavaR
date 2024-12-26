package boardgame;

public class Position {
	
	private int row;
	private int col;
	
	public Position() {
		super();
	}

	public Position(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public void setValues(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public String toString() {
		return "Position [row=" + row + ", col=" + col + "]";
	}

}

package boardgame;

public abstract class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		super();
		this.board = board;
		this.position = null;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getCol()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] movesMat = possibleMoves();
		for (int i = 0; i < movesMat.length; i++) {
			for (int j = 0; j < movesMat[i].length; j++) {
				if (movesMat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	protected Board getBoard() {
		return board;
	}
	
	

}

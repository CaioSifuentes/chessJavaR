package chess;

import boardgame.Position;
import chess.exceptions.ChessException;

public class ChessPosition {
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	protected Position toPosition() {
		return new Position(8 - this.getRow(), this.getColumn() - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition( (char) ('a' + position.getCol()) , ( 8 - position.getRow()) );
	}
	
	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
	
}

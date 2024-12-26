package boardgame;

import boardgame.exceptions.BoardException;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position do not exists.");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return piece(position.getRow(), position.getCol());
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		
		this.pieces[position.getRow()][position.getCol()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int column) {
		return (row >= 0 && row < rows) && (column >= 0 && column < columns);
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getCol());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position do not exist.");
		}
		return piece(position) != null;
	}

	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}


}

package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.exceptions.ChessException;

public class Program {

	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		while (!chessMatch.isCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				ChessPosition source = UI.readChessPosition(sc);

				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);

				ChessPosition target = UI.readChessPosition(sc);
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}

				String type = sc.nextLine().toUpperCase();
				while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
					System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
					type = sc.nextLine().toUpperCase();
				}
			} catch (ChessException e) {
				System.out.print(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.print(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);

	}

}

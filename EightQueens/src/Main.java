/*
 * Darey Lee
 * Assignment 3 Problem 5
 */

public class Main {

	public static void main(String[] args) {
		Chessboard chessboard = new Chessboard();
		System.out.println("********************\n"
				+ "********************\n"
				+ "IGNORE FIRST TRIAL SET BECAUSE JIT OPTIMIZATIONS\n"
				+ "DON'T FULLY TAKE HOLD UNTIL LATER ITERATIONS OF THE LOOP\n"
				+ "********************\n"
				+ "********************");
		chessboard.solveEightQueens(0);
		System.out.println("********************\n"
				+ "********************\n"
				+ "IGNORE PREVIOUS TRIAL SET BECAUSE JIT OPTIMIZATIONS\n"
				+ "DID NOT FULLY TAKE HOLD UNTIL A FEW ITERATIONS INTO THE LOOP\n"
				+ "********************\n"
				+ "********************\n");
		
		chessboard.solveEightQueens(0);
		chessboard.solveEightQueens(1);
		chessboard.solveEightQueens(2);
		chessboard.solveEightQueens(3);
		chessboard.solveEightQueens(4);
		chessboard.solveEightQueens(5);
		chessboard.solveEightQueens(6);
		chessboard.solveEightQueens(7);
		chessboard.solveEightQueens(8);	
	}
}

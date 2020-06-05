import java.util.Random;

public class Chessboard {
	
	private Boolean[] blockedSquares = new Boolean[64];
	private int[] queenLocations = new int[8];
	
	private long startTime;
	private long endTime;
	private long trialRunTime;
	private long sumRunTime;
	
	private Random random = new Random();
	
	public Chessboard() {}
	
	public void solveEightQueens(int numberOfRandomizedQueens) {
		System.out.println("========== " + numberOfRandomizedQueens + " RANDOMIZED QUEENS ==========");
		
		sumRunTime = 0;
		
		for (int trial = 1; trial <= 100; trial++) {
			resetQueenLocations();
			resetBlockedSquares();
			
			startTime = System.nanoTime() / 1000;
			
			placeRandomQueens(numberOfRandomizedQueens);
			
			endTime = System.nanoTime() / 1000;
			trialRunTime = endTime - startTime;
			sumRunTime += trialRunTime;
			
			System.out.println("Trial " + trial + " Runtime: " + trialRunTime);
			
			StringBuilder positionsStringBuilder = new StringBuilder();
			for (int i = 0; i < queenLocations.length; i++) {
				positionsStringBuilder.append(queenLocations[i] + " ");
			}
			
			System.out.println(positionsStringBuilder.toString());
		}
		
		System.out.println("AVERAGE RUNTIME: " + sumRunTime / 100);
		
	}
	
	private void placeRandomQueens(int numberOfRandomizedQueens) {
		int i = 1;
		
		while (i <= numberOfRandomizedQueens) {
			if (boardCompletelyBlocked()) {
				resetBlockedSquares();
				resetQueenLocations();
				i = 1;
			}
			
			int randomRow = random.nextInt(8);
			int randomColumn = random.nextInt(8);
			
			if (squareNotBlocked(randomRow, randomColumn)) {
				placeQueen(randomRow, randomColumn);
				i++;
			}
		}
		
		if (!backtrackRemainingQueens(0)) {
			resetBlockedSquares();
			resetQueenLocations();
			placeRandomQueens(numberOfRandomizedQueens);
		};
	}
		
	private Boolean backtrackRemainingQueens(int row) {
		if (row == 8) {
			return true;
		}
		
		if (queenLocations[row] != -1) {
			return backtrackRemainingQueens(row + 1);
		}
		
		if (rowCompletelyBlocked(row)) {
			return false;
		}
		
		for (int column = 0; column <= 7; column++) {
			if (squareNotBlocked(row, column)) {
				placeQueen(row, column);
				
				if(backtrackRemainingQueens(row + 1)) {
					return true;
				} else {
					removeQueen(row);
				}
			}
		}
		
		return false;
	}
	
	private void removeQueen(int row) {
		queenLocations[row] = -1;
		updateBlockedSquares();
	}
	
	private void placeQueen(int row, int column) {
		queenLocations[row] = column;
		updateBlockedSquares();
	}
	
	private void updateBlockedSquares() {
		resetBlockedSquares();
		
		int row = 0;
		
		while (row < 8) {
			if (queenLocations[row] >= 0) {
				int rowLeftIndex = row * 8;
				int rowRightIndex = rowLeftIndex + 7;
				int queenIndex = rowLeftIndex + queenLocations[row];
				
				//block entire row
				for (int i = rowLeftIndex; i <= rowRightIndex; i++) {
					blockedSquares[i] = true;
				}
				
				//block entire column
				for (int i = queenLocations[row]; i < 64; i += 8) {
					blockedSquares[i] = true;
				}
				
				//diagonals
				for (int i = 0; i <= 7; i++) {
					int leftBoundIndex = i * 8;
					int rightBoundIndex = leftBoundIndex + 7;
					int differenceOfRows = row - i;
					
					for (int j = leftBoundIndex; j <= rightBoundIndex; j++) {
						if (j == queenIndex - (8 * differenceOfRows) - differenceOfRows ||
								j == queenIndex - (8 * differenceOfRows) + differenceOfRows ||
								j == queenIndex + (8 * differenceOfRows) - differenceOfRows ||
								j == queenIndex + (8 * differenceOfRows) + differenceOfRows) {
							blockedSquares[j] = true;
						}
					}
				}	
			}
			
			row++;
		}
	}
	
	private Boolean squareNotBlocked(int row, int column) {
		int index = (row * 8) + column;
		
		return !blockedSquares[index];
	}
	
	private Boolean boardCompletelyBlocked() {
		for (int i = 0; i < blockedSquares.length; i++) {
			if (!blockedSquares[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	private Boolean rowCompletelyBlocked(int row) {
		int startIndexOfRow = row * 8;
		int endIndexOfRow = startIndexOfRow + 7;
		
		for (int index = startIndexOfRow; index <= endIndexOfRow; index++) {
			if (!blockedSquares[index]) {
				return false;
			}
		}
		
		return true;
	}
	
	private void resetBlockedSquares() {
		for (int i = 0; i < blockedSquares.length; i++) {
			blockedSquares[i] = false;
		}
	}
	
	private void resetQueenLocations() {
		for (int i = 0; i < queenLocations.length; i++) {
			queenLocations[i] = -1;
		}
	}
}

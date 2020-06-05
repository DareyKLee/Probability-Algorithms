/*
 * Darey Lee
 * Assignment 3 Problem 1
 */

public class Main {
	
	public static void main(String[] args) {
		DartBoard dartboard_1000 = new DartBoard(1000);
		dartboard_1000.calculateProbabilisticPi();
		
		DartBoard dartboard_10000 = new DartBoard(10000);
		dartboard_10000.calculateProbabilisticPi();
		
		DartBoard dartboard_100000 = new DartBoard(100000);
		dartboard_100000.calculateProbabilisticPi();
		
		DartBoard dartboard_1000000 = new DartBoard(1000000);
		dartboard_1000000.calculateProbabilisticPi();
		
		System.out.println("********** THE FOLLOWING TRIALS FOR 100000000 DARTS WILL TAKE MORE TIME TO COMPLETE **********");
		
		DartBoard dartboard_100000000 = new DartBoard(100000000);
		dartboard_100000000.calculateProbabilisticPi();
	}
	
}

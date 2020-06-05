/*
 * Darey Lee
 * Assignment 3 Problem 3
 */

public class Main {

	public static void main(String[] args) {
		ProbabilisticSearchArray probabilisticSearchArray_100 = new ProbabilisticSearchArray(100);
		probabilisticSearchArray_100.determineAverageGuesses();
		
		ProbabilisticSearchArray probabilisticSearchArray_1000 = new ProbabilisticSearchArray(1000);
		probabilisticSearchArray_1000.determineAverageGuesses();

		ProbabilisticSearchArray probabilisticSearchArray_10000 = new ProbabilisticSearchArray(10000);
		probabilisticSearchArray_10000.determineAverageGuesses();
	}
}

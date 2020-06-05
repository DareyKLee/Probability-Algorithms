/*
 * Darey Lee
 * Assignment 3 Problem 4
 * 
 * Approximating the integral of the function y = 4 * cos(x) + 20 from
 * 0 to 10,000
 */

public class Main {
	
	static final int lowerBound = 0;
	static final int upperBound = 1000;
	
	public static void main(String[] args) {
		DartThrowingIntegration dartThrowingIntegration = new DartThrowingIntegration(lowerBound, upperBound);
		dartThrowingIntegration.calculateArea();
		
		MeanValueIntegration meanValueIntegration = new MeanValueIntegration(lowerBound, upperBound);
		meanValueIntegration.calculateArea();
		
		TrapezoidIntegration trapezoidIntegration = new TrapezoidIntegration(lowerBound, upperBound);
		trapezoidIntegration.calculateArea();
	}
	
}

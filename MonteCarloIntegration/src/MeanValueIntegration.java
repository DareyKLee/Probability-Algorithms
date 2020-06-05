import java.util.Random;

public class MeanValueIntegration {

	private final int numberOfRandomPoints = 1000000;
	private double lowerBound;
	private double upperBound;
	private double calculatedTrialArea;
	private double totalY;
	private double sumCalculatedTrialArea;
	private long sumRunTime;
	private long startTime;
	private long endTime;
	
	private Random random = new Random();
	
	public MeanValueIntegration(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	public void calculateArea() {
		System.out.println("========== Integrating with Mean Value Method ==========");
		for (int trial = 1; trial <= 10; trial++) {
			reset();
			startTime = System.nanoTime() / 1000;
			
			for (int i = 1; i <= numberOfRandomPoints; i++) {
				findRandomPoint();
			}
			
			endTime = System.nanoTime() / 1000;
			
			long runTime = endTime - startTime;
			
			calculateAreaOfTrial();
			sumCalculatedTrialArea += calculatedTrialArea;
			sumRunTime += runTime;
			
			System.out.println("TRIAL " + trial + "\n\tAREA : " + calculatedTrialArea + "\n\tRUNTIME : " + runTime);
		}
		
		System.out.println("AVERAGE OF TEN TRIALS" + "\n\tAREA : " + sumCalculatedTrialArea / 10 + "\n\tRUNTIME : " + sumRunTime / 10);
	}
	
	private void reset() {
		totalY = 0;
		calculatedTrialArea = 0;
	}
	
	private void findRandomPoint() {
		double xCoordinate = random.nextDouble() * upperBound;
		double yCoordinate = 4 * Math.cos(xCoordinate) + 20;
		
		totalY += yCoordinate;
	}
	
	private void calculateAreaOfTrial() {
		calculatedTrialArea = totalY / numberOfRandomPoints * (upperBound - lowerBound);
	}
}

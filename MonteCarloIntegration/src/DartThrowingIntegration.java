import java.util.Random;

public class DartThrowingIntegration {

	private final int numberOfDarts = 1000000;
	private double lowerBound;
	private double upperBound;
	private double heightOfRectangle;
	private double areaOfRectangle;
	private double calculatedTrialArea;
	private int belowFunctionCounter;
	private double sumCalculatedTrialArea;
	private long sumRunTime;
	private long startTime;
	private long endTime;
	
	private Random random = new Random();
	
	public DartThrowingIntegration(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		setHeightOfRectangle();
		setAreaOfRectangle();
	}
	
	public void calculateArea() {
		System.out.println("========== Integrating With Dart Throwing Method ==========");
		for (int trial = 1; trial <= 10; trial++) {
			reset();
			startTime = System.nanoTime() / 1000;

			for (int i = 1; i <= numberOfDarts; i++) {
				throwDart();
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
	
	private void setHeightOfRectangle() {
		heightOfRectangle = 4 * Math.cos(0) + 20;
	}
	
	private void setAreaOfRectangle() {
		areaOfRectangle = heightOfRectangle * (upperBound - lowerBound);
	}
	
	private void reset() {
		belowFunctionCounter = 0;
		calculatedTrialArea = 0;
	}
	
	private void throwDart() {
		double xCoordinate = random.nextDouble() * upperBound;
		double yCoordinate = random.nextDouble() * heightOfRectangle;
		
		if (yCoordinate <= 4 * Math.cos(xCoordinate) + 20) {
			belowFunctionCounter++;
		}
	}
	
	private void calculateAreaOfTrial() {
		calculatedTrialArea = areaOfRectangle * belowFunctionCounter / numberOfDarts;
	}
}

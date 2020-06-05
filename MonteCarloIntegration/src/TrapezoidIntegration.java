
public class TrapezoidIntegration {
	
	private final int numberOfTrapezoids = 1000000;
	private double lowerBound;
	private double upperBound;
	private double trapezoidWidth;
	private double totalArea;
	private long sumRunTime;
	private long startTime;
	private long endTime;

	public TrapezoidIntegration(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		findTrapezoidWidth();
	}
	
	public void calculateArea() {
		System.out.println("========== Integrating with Trapezoidal Method ==========");
		for (int trial = 1; trial <= 10; trial++) {
			reset();
			startTime = System.nanoTime() / 1000;
			
			for (double xPosition = lowerBound; xPosition < upperBound; xPosition += trapezoidWidth) {
				addAreaOfTrapezoid(xPosition, xPosition + trapezoidWidth);
			}
			
			endTime = System.nanoTime() / 1000;
			
			long runTime = endTime - startTime;
			sumRunTime += runTime;
			
			System.out.println("TRIAL " + trial + "\n\tRUNTIME : " + runTime);
		}
		
		System.out.println("AVERAGE OF TIME OF TEN TRIALS" + "\n\tRUNTIME : " + sumRunTime / 10);
		System.out.println("CALCULATED AREA : " + totalArea);
	}
	
	private void findTrapezoidWidth() {
		trapezoidWidth = (upperBound - lowerBound) / numberOfTrapezoids;
	}
	
	private void addAreaOfTrapezoid(double xLeft, double xRight) {
		double averageY = ((4 * Math.cos(xLeft) + 20) + (4 * Math.cos(xRight) + 20)) / 2 ;
		totalArea += trapezoidWidth * averageY;
	}
	
	private void reset() {
		totalArea = 0;
	}
}

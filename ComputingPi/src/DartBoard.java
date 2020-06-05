import java.util.Random;

public class DartBoard {
	private final int radius = 1;
	
	private double xCoordinate;
	private double yCoordinate;
	
	private int dartsInsideCircle;
	
	private int numberOfDarts;
	
	Random random = new Random();
	
	public DartBoard(int numberOfDarts) {
		this.numberOfDarts = numberOfDarts;
	}
	
	public void calculateProbabilisticPi() {
		System.out.println("========== Probabilistic Pi of Ten Trials for " + numberOfDarts + " Darts ==========");
		for (int i = 1; i <= 10; i++) {
			dartsInsideCircle = 0;
			throwDarts();
			System.out.println("Trial " + i + " : " + 4 * ((double) dartsInsideCircle / numberOfDarts));
		}
	}
	
	private void throwDarts() {
		for (int i = 1; i <= numberOfDarts; i++) {
			throwDart();
		}
	}
	
	private void throwDart() {
		xCoordinate = (random.nextDouble() * 2) - radius;
		yCoordinate = (random.nextDouble() * 2) - radius;
		
		hitOrMiss();
	}
	
	private void hitOrMiss() {
		if (Math.pow(yCoordinate, 2) <= 1 - Math.pow(xCoordinate, 2)) {
			dartsInsideCircle++;
		}
	}
}

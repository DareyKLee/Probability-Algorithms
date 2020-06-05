import java.util.Random;

public class ProbabilisticSearchArray {

	private final int numberOfSearches;
	private final int maximumGuesses = 5000;
	private double sumAverageOfGuesses = 0;
	private int currentGuessesOfTrial = 0;
	private int[] array = new int[1000];
		
	private Random random = new Random();
	
	public ProbabilisticSearchArray(int numberOfSearches) {
		this.numberOfSearches = numberOfSearches;
		initializeArray();
	}
	
	public void determineAverageGuesses() {
		System.out.println("========== TRIALS FOR " + numberOfSearches + " SEARCHES ==========");
		
		for (int trialSetNumber = 1; trialSetNumber <= 10; trialSetNumber++) {
			currentGuessesOfTrial = 0;
			
			for (int i = 1; i <= numberOfSearches; i++) {
				int targetNumber = array[random.nextInt(array.length)];
				
				for (int numberOfGuesses = 1; numberOfGuesses <= maximumGuesses; numberOfGuesses++) {
					currentGuessesOfTrial++;
					
					if (targetNumber == array[random.nextInt(array.length)]) {
						break;
					}
				}
			}
			
			double trialAverage = (double) currentGuessesOfTrial / numberOfSearches;
			sumAverageOfGuesses += trialAverage;
			System.out.println("Average number of guesses for Trial Set of " + trialSetNumber + " : " + trialAverage);
		}
		
		System.out.println("AVERAGE NUMBER OF GUESSES BETWEEN ALL TRIAL SETS : " + sumAverageOfGuesses / 10);
	}
	
	private void initializeArray() {
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		for (int i = 0; i < array.length; i++) {
			int randomIndex = random.nextInt(array.length);
			int temp = array[randomIndex];
			
			array[randomIndex] = array[i];
			array[i] = temp;
		}
	}
}

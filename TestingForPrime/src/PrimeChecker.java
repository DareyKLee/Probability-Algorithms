import java.util.Random;

public class PrimeChecker {

	private final int[] arrayOfGuesses = new int[] {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
	
	private int numberUnderObservation_P;
	private int rejectionCount;
	private int randomValue_N;
	private int baseNumber = 1000000;
	
	private Random random = new Random();
	
	public PrimeChecker() {	
	}
	
	public void largeEvenNumber() {
		numberUnderObservation_P = (random.nextInt(baseNumber + 1) + baseNumber) * 2;
		System.out.println("==================== EVEN NUMBER REJECTION COUNTS ====================");
		System.out.println("RANDOMIZED NUMBER UNDER OBSERVATION: " + numberUnderObservation_P);
		findModulo();
	}
	
	public void largeDivisibleByFiveNumber() {
		numberUnderObservation_P = (random.nextInt(baseNumber + 1) + baseNumber) * 5;
		System.out.println("==================== DIVISIBLE BY FIVE NUMBER REJECTION COUNTS ====================");
		System.out.println("RANDOMIZED NUMBER UNDER OBSERVATION: " + numberUnderObservation_P);
		findModulo();
	}
	
	public void largeSumOfDigitsIsThreeNumber() {
		do {
			numberUnderObservation_P = random.nextInt(baseNumber + 1) + baseNumber;
		} while (!sumOfDigitsDivisibleByThree());
		
		System.out.println("==================== SUM OF DIGITS IS THREE NUMBER REJECTION COUNTS ====================");
		System.out.println("RANDOMIZED NUMBER UNDER OBSERVATION: " + numberUnderObservation_P);
		findModulo();
	}
	
	public void largeProductOfTwoIntegersNumber() {	
		int firstRandomInteger = random.nextInt(1000 + 1) + 1000;
		int secondRandomInteger = random.nextInt(1000 + 1) + 1000;
			
		numberUnderObservation_P = firstRandomInteger * secondRandomInteger;
		
		System.out.println("==================== PRODUCT OF TWO POSITIVE INTEGERS NUMBER REJECTION COUNTS ====================");
		System.out.println("Multiplying " + firstRandomInteger + " and " + secondRandomInteger);
		System.out.println("RANDOMIZED NUMBER UNDER OBSERVATION: " + numberUnderObservation_P);
		findModulo();
	}
	
	public void largeAdjustedNumber() {
		int randomValueK = random.nextInt(baseNumber + 1);
		numberUnderObservation_P = random.nextInt(baseNumber + 1) + baseNumber;
		
		numberUnderObservation_P -= numberUnderObservation_P % randomValueK;

		System.out.println("==================== ADJUSTED BY SUBTRACTING N % K NUMBER REJECTION COUNTS ====================");
		System.out.println("Value of K: " + randomValueK);
		System.out.println("ADJUSTED RANDOMIZED NUMBER UNDER OBSERVATION: " + numberUnderObservation_P);
		findModulo();
	}
	
	private void findModulo() {		
		for (int guessesCount : arrayOfGuesses) {
			rejectionCount = 0;

			for (int i = 1; i <= guessesCount; i++) {
				randomValue_N = random.nextInt(numberUnderObservation_P - 1) + 1;
				
				if (numberUnderObservation_P % randomValue_N == 0) {
					rejectionCount++;
				}
			}
			
			System.out.println("Prime rejection count after testing against " + guessesCount + " random values: " + rejectionCount);
		}
	}
	
	private Boolean sumOfDigitsDivisibleByThree() {
		int copyOfNumber = numberUnderObservation_P;
		int sumOfDigits = 0;
		
		while (copyOfNumber > 0) {
			sumOfDigits += copyOfNumber % 10;
			copyOfNumber = copyOfNumber / 10;
		}
		
		if (sumOfDigits % 3 == 0) {
			return true;
		}
		
		return false;
	}
}

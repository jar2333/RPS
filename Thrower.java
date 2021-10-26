import java.util.Random;

/**
 * Generates the computer throws. Implements uniform random strategy,
 * 
 * @author Jose A. Ramos
 *
 */
public class Thrower {
	
	/**
	 * Instantiates the random number generator.
	 */
	public Thrower() {
		this.random = new Random();
	}

	/**
	 * Gets the computer's next throw
	 * @return the computer's throw
	 */
	public Throw getComputerThrow() {
		Throw computerThrow = generateComputerThrow();
		return computerThrow;
	}
	
	/**
	 * Only implemented by subclasses with history.
	 * 
	 * @param round summary of current round
	 */
	public void learn(RoundSummary round) {}
	
	private Throw generateComputerThrow() {
		int index = random.nextInt(3);
		Throw computerThrow = new Throw(index);
		return computerThrow;
	}
	
	private Random random;
	
}

/**
 * Provides method for constructing <code>Round</code> container objects.
 * Also provided methods for deciding if an <code>int</code> representing rounds results
 * is a tie, or a computer win. 
 * 
 * The int corresponding to a particular outcome are encoded as constants in the class:
 * <ul>
 * 		<li>COMPUTER_WIN = 1</li>
	    <li>PLAYER_WIN = -1</li>
		<li>TIE = 0</li>
	</ul>
	
	These interpretations correspond to the computer's payoff matrix. This payoff matrix
	is explicitly stored as a two-dimensional array in the <code>Payoff</code> 
	inner class.
 * 
 * @author Jose A. Ramos
 *
 */
public class Referee {
	
	/**
	 * Takes the computer and the player throws, decides who won, and returns a <code>Round</code>
	 * object that contains the round's throws and the outcome.
	 * 
	 * @param computerThrow the computer's throw
	 * @param playerThrow the player's throw
	 * @return container for round outcome and throws
	 */
	public static RoundSummary getRoundSummary(Throw computerThrow, Throw playerThrow) {
		int computerThrowIndex = computerThrow.getThrowIndex();
		int playerThrowIndex = playerThrow.getThrowIndex();
		int roundOutcome = evaluateRoundOutcome(computerThrowIndex, playerThrowIndex);
		return new RoundSummary(computerThrow, playerThrow, roundOutcome);
	}
	
	/**
	 * Determines if an int representing a round outcome is a tie.
	 * 
	 * @param roundOutcome an int representing the outcome of a round
	 * @return whether the round outcome is a tie
	 */
	public static boolean isTie(int roundOutcome) {
		return roundOutcome == TIE;
	}
	
	/**
	 * Determines if an int representing a round outcome is a computer win.
	 * 
	 * @param roundOutcome an int representing the outcome of a round
	 * @return whether the round outcome is a computer win
	 */
	public static boolean isComputerWin(int roundOutcome) {
		return roundOutcome == COMPUTER_WIN;
	}
	
	private static int evaluateRoundOutcome(int computerThrowIndex, int playerThrowIndex) {
		int roundOutcome = Payoff.getPayoff(computerThrowIndex, playerThrowIndex);
		return roundOutcome;
	}
	
	public static final int COMPUTER_WIN = 1;
	public static final int PLAYER_WIN = -1;
	public static final int TIE = 0;

}

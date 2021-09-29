/**
 * Holds all of the information that characterizes a round:
 * <ul>
 * 		<li>Computer throw</li>
 * 		<li>Player throw</li>
 * 		<li>outcome of round
 * 			<ul>
 * 				<li>Computer win</li>
 * 				<li>Player win</li>
 * 				<li>Tie</li>
 * 			</ul>
 * 		</li>
 *  </ul>
 *  
 *  Includes methods to evaluate if the round is a tie, or a computer win. 
 *  Includes getter for the round's computer throw, player throw, and outcome. 
 * 
 * @author Jose A. Ramos
 *
 */
public class RoundSummary {

	/**
	 * Encapsulates the information that characterizes a round
	 * 
	 * @param computerThrow the computer throw
	 * @param playerThrow the player throw
	 * @param roundOutcome the round's outcome
	 */
	public RoundSummary(Throw computerThrow, Throw playerThrow, int roundOutcome) {
		this.computerThrow = computerThrow;
		this.playerThrow = playerThrow;
		this.roundOutcome = roundOutcome;
	}
	
	/**
	 * Gets the computer throw for this round
	 * 
	 * @return this round's computer throw
	 */
	public Throw getComputerThrow() {
		return computerThrow;
	}
	
	/**
	 * Gets the player throw for this round
	 * 
	 * @return this round's player throw
	 */
	public Throw getPlayerThrow() {
		return playerThrow;
	}
	
	/**
	 * Gets the outcome of this round
	 * 
	 * @return this round's outcome
	 */
	public int getRoundOutcome() {
		return this.roundOutcome;
	}
	
	/**
	 * Determines if the outcome of this round is a tie
	 * 
	 * @return whether the outcome is a tie
	 */
	public boolean isTie() {
		return Referee.isTie(roundOutcome);
	}
	
	/**
	 * Determines if the outcome of this round is a computer win
	 * 
	 * @return whether the outcome is a computer win
	 */
	public boolean isComputerWin() {
		return Referee.isComputerWin(roundOutcome);
	}
	
	private Throw computerThrow;
	private Throw playerThrow;
	private int roundOutcome;
	
}

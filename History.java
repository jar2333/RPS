/**
 * Holds player throw history, categorized in a table by the outcome the round before. 
 * Also holds information on the last round, to be used to access the table.
 * On the first round, this information is not used (as it does not exist).
 * An example table:
 * 
 * <code>
 *    R__P__S_
 * RR| 7| 3| 5
 * RP| 3| 9| 1
 * RS| 9| 3| 4
 * PR| 5| 2| 1
 * PP|11| 4| 8
 * PS| 6| 3| 1
 * SR| 8| 7| 3
 * SP| 7| 8| 5
 * SS| 4| 1| 2
 * </code>
 * 
 * @author Jose A. Ramos
 *
 */

public class History {
		
	/**
	 * Instantiates the frequency table and the first state. First state does not exist yet,
	 * so it is instantiated as <code>null</code>. From the second round of the game onwards, 
	 * it is not <code>null</code>.
	 */
	public History() {
		this.dimension  = Throw.NUMBER_OF_THROWS;
		this.frequencyTable = new int[dimension][dimension][dimension];
		this.lastRound = null;
	}
		
	/**
	 * Gets the frequency of a predicted player throw given the last round.
	 * If called on the first round, returns 0.
	 * 
	 * @param predictedPlayerThrowIndex the index of the predicted player throw
	 * @return the frequency of the predicted player throw
	 */
	public int getFrequency(int predictedPlayerThrowIndex) {
		if (lastRound == null) {
			return 0;
		}
		int i = lastRound.computerThrowIndex;
		int j = lastRound.playerThrowIndex;
		int k = predictedPlayerThrowIndex;
		return frequencyTable[i][j][k];
	}
	
	/**
	 * Updates the frequency of a player throw given the last round. 
	 * If called on the first round, does nothing. 
	 * 
	 * @param actualPlayerThrowIndex the actual player throw's index
	 */
	public void updateFrequency(int actualPlayerThrowIndex) {
		if (lastRound != null) {
			int i = lastRound.computerThrowIndex;
			int j = lastRound.playerThrowIndex;
			int k = actualPlayerThrowIndex;
			frequencyTable[i][j][k] += 1;
		}
	}
		
	/**
	 * Updates the last round information to be the results of the current round
	 * 
	 * @param currentRound the current round's information
	 */
	public void updateState(State currentRound) {
		lastRound = currentRound;
	}
		
	private int[][][] frequencyTable;
	private State lastRound;
	private int dimension;
}
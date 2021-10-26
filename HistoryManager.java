/**
 * Manages the history for an AI thrower agent.
 * 
 * @author Jose A. Ramos
 *
 */
public class HistoryManager {
	
	/**
	 * Instantiates a new history to manage.
	 * 
	 * @param dimension
	 */
	public HistoryManager() {
		this.history= new History();
	}
	
	/**
	 * Gets the frequency of the predicted player move.
	 * 
	 * @param predictedPlayerThrowIndex the index for the predicted player move
	 * @return the frequency of the predicted player move
	 */
	public int getFrequency(int predictedPlayerThrowIndex) {
		return history.getFrequency(predictedPlayerThrowIndex);
	}

	/**
	 * Updates the history with new frequency information.
	 * 
	 * @param computerThrow the current round's computer throw
	 * @param playerThrow the current round's player throw
	 */
	public void updateHistory(Throw computerThrow, Throw playerThrow) {
		int computerThrowIndex = computerThrow.getThrowIndex();
		int playerThrowIndex = playerThrow.getThrowIndex();
		updateHistoryFrequency(playerThrowIndex);
		updateHistoryState(computerThrowIndex, playerThrowIndex);
	}
	
	private void updateHistoryFrequency(int playerThrowIndex) {
		history.updateFrequency(playerThrowIndex);;
	}
	
	private void updateHistoryState(int computerThrowIndex, int playerThrowIndex) {
		State currentRound = createState(computerThrowIndex, playerThrowIndex);
		history.updateState(currentRound);
	}
	
	private State createState(int computerThrowIndex, int playerThrowIndex) {
		return new State(computerThrowIndex, playerThrowIndex);
	}
	
	private History history;
}

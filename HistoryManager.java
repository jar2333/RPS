
public class HistoryManager {
	
	public HistoryManager(int dimension) {
		this.history= new History(dimension);
	}
	
	public int getFrequency(int predictedPlayerThrowIndex) {
		return history.getFrequency(predictedPlayerThrowIndex);
	}

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

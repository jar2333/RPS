public class History {
		
	public History(int dimension) {
		this.frequencyTable = new int[dimension][dimension][dimension];
		this.dimension  = dimension;
		this.lastRound = null;
	}
		
	public int getFrequency(int predictedPlayerThrowIndex) {
		if (lastRound == null) {
			return 0;
		}
		int i = lastRound.computerThrowIndex;
		int j = lastRound.playerThrowIndex;
		int k = predictedPlayerThrowIndex;
		return frequencyTable[i][j][k];
	}
	
	
	public void updateFrequency(int actualPlayerThrowIndex) {
		if (lastRound != null) {
			int i = lastRound.computerThrowIndex;
			int j = lastRound.playerThrowIndex;
			int k = actualPlayerThrowIndex;
			frequencyTable[i][j][k] += 1;
		}
	}
		
	public void updateState(State currentRound) {
		lastRound = currentRound;
	}
		
	public int getTotalFrequency() {
		int total = 0;
		for (int k = 0; k < dimension; k++) {
			total += getFrequency(k);
		}
		return total;
	}
		
	private int[][][] frequencyTable;
	private State lastRound;
	private int dimension;
}
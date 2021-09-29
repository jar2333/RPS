/**
 * Generates the computer throws. Implements exploitation of throw with highest expected reward, given the last round.
 * 
 * @author Jose A. Ramos
 *
 */
public class AIThrower extends Thrower {
	
	/**
	 * Instantiates the random number generator.
	 */
	public AIThrower() {
		super();
		this.historyManager = new HistoryManager(DIMENSION);
	}
	
	public void learn(RoundSummary round) {
		updateHistory(round);
	}
	
	/**
	 * Gets the computer's next throw
	 * @return the computer's throw
	 */
	public Throw getComputerThrow() {
		Throw computerThrow = generateComputerThrow();
		return computerThrow;
	}
	
	private Throw generateComputerThrow() {
		int maxRewardIndex = getMaxRewardThrowIndex();
		Throw computerThrow = new Throw(maxRewardIndex);
		return computerThrow;
	}
	
	private int getMaxRewardThrowIndex() {
		int maxExpectedReward = 0;
		int maxExpectedRewardIndex = 0;
		for (int computerThrowIndex = 0; computerThrowIndex < Throw.NUMBER_OF_THROWS; computerThrowIndex++) {
			int expectedReward = getExpectedReward(computerThrowIndex);
			if (expectedReward > maxExpectedReward) {
				maxExpectedReward = expectedReward;
				maxExpectedRewardIndex = computerThrowIndex;
			}
		}
		return maxExpectedRewardIndex;
	}
	
	private int getExpectedReward(int computerThrowIndex) {
		int expectedReward = 0;
		for (int playerThrowIndex = 0; playerThrowIndex < Throw.NUMBER_OF_THROWS; playerThrowIndex++) {
			int payoff = Payoff.getPayoff(computerThrowIndex, playerThrowIndex);
			int frequency = getFrequency(playerThrowIndex);
			expectedReward += payoff * frequency;
		}
		return expectedReward;
	}
	
	private void updateHistory(RoundSummary round) {
		Throw computerThrow = round.getComputerThrow();
		Throw playerThrow = round.getPlayerThrow();
		historyManager.updateHistory(computerThrow, playerThrow);
	}
	
	private int getFrequency(int predictedPlayerThrowIndex) {
		return historyManager.getFrequency(predictedPlayerThrowIndex);
	}
	
	private int DIMENSION = Throw.NUMBER_OF_THROWS;
	private HistoryManager historyManager;
	
}

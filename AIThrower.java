/**
 * Generates the computer throws. Implements exploitation of throw with highest expected reward, given the last round. <br><br>
 * 
 * The basic idea is that of a <i>Markov chain</i>. The states are the outcome of the last round, and the transition probabilities
 * are the player throw frequencies after a given round outcome. We use "frequency" to allude to this probabilisic formulation,
 * but for computational convinience we only store the <b>counts</b>, as our strategy does not require the normalized 
 * probabilities. <br><br>
 * 
 * The player throw frequencies constitute the history which the AI will use to decide its next move. <br><br>
 * 
 * This type of AI was decided upon to exploit player patterns. It is actually entirely deterministic, only assuming probabilistic
 * behavior on the part of the player. The probabilities for each player action at each state are used to computer the
 * expected reward for each potential computer move. The computer move with the highest expected reward gets chosen as the 
 * computer's throw. <br><br>
 * 
 * This approach works regardless of how many available moves exist, and the interactions between them. Thus it is scalable
 * to generalized RPS, such as RPSLK. In these settings, it actually provides a heuristic for choosing the best computer throw
 * to beat a given player throw prediction, when multiple options are available. Nevetheless, we forego predicting
 * the player move directly for convinience, and instead choose the best throw globally. Using a randomly sampled predicition
 * may provide protection from AI exploitation, which I'm sure this system is vulnerable to. <br><br>
 * 
 * Inspired by <b>Piotr Gabrys'</b> approach to RPS.
 * 
 * @author Jose A. Ramos
 * @see <a href="https://en.wikipedia.org/wiki/Markov_chain">markov chains</a>
 * @see <a href="https://towardsdatascience.com/how-to-win-over-70-matches-in-rock-paper-scissors-3e17e67e0dab">Piotr Gabrys' AI</a>
 *
 */
public class AIThrower extends Thrower {
	
	/**
	 * Instantiates the history.
	 */
	public AIThrower() {
		super();
		this.historyManager = new HistoryManager();
	}
	
	/**
	 * Updates the history based on summary of current round
	 */
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
	
	private HistoryManager historyManager;
	
}

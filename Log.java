/**
 * Keeps track of the player wins and losses, and under what circumstances 
 * (the combination of computer and player moves). Information stored on 
 * two-dimensional array. Uses throw indeces to cache round outcomes.
 * 
 * Results printed by the auxiliary
 * <code>LogPrinter</code> class. 
 * 
 * @author Jose A. Ramos
 *
 */
public class Log {
	
	/**
	 * Instantiates the array holding the wins and losses.
	 */
	public Log() {
		this.gameTable = new int[DIMENSION][DIMENSION];
	}
	
	/**
	 * Appends the round data to the log.
	 * 
	 * @param round container for round outcome and throws
	 */
	public void appendRound(RoundSummary round) {
		Throw computerThrow = round.getComputerThrow();
		Throw playerThrow = round.getPlayerThrow();
		int payoff = round.getRoundOutcome();
		updateGameTable(computerThrow, playerThrow, payoff);
		roundsPlayed++;
	}
	
	/**
	 * Prints the log. Uses <code>LogPrinter</code>.
	 */
	public void printLog() {
		logPrinter = new LogPrinter(gameTable, roundsPlayed); 
		logPrinter.printGameTable();
	}

	private void updateGameTable(Throw computerThrow, Throw playerThrow, int payoff) {
		int computerThrowIndex = computerThrow.getThrowIndex();
		int playerThrowIndex = playerThrow.getThrowIndex();
		updateEntry(computerThrowIndex, playerThrowIndex, payoff);
		updateRowTotal(computerThrowIndex, payoff);
		updateColumnTotal(playerThrowIndex, payoff);
		updateTableTotal(payoff);
	}
	
	private void updateEntry(int computerThrowIndex, int playerThrowIndex, int payoff) {
		gameTable[computerThrowIndex][playerThrowIndex] -= payoff; //roundOutcome is comp roundOutcome	
	}
	
	private void updateRowTotal(int computerThrowIndex, int payoff) {
		updateEntry(computerThrowIndex, DIMENSION - 1, payoff);
	}
	
	private void updateColumnTotal(int playerThrowIndex, int payoff) {
		updateEntry(DIMENSION - 1, playerThrowIndex, payoff);
	}
	
	private void updateTableTotal(int payoff) {
		updateEntry(DIMENSION - 1, DIMENSION - 1, payoff);
	}
	
	private final int DIMENSION = Throw.NUMBER_OF_THROWS + 1;
	private int[][] gameTable;
	private int roundsPlayed = 0;
	private LogPrinter logPrinter;

	
}

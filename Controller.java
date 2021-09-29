/**
 * Handles the core game logic. Called by the <code>main</code> method.
 * 
 * @author Jose A. Ramos
 *
 */
public class Controller {
	
	public Controller() {
		initialize();
	}
	
	/**
	 * Plays out a round. Waits for a round to finalize, checks if it is a tie. 
	 * Keeps playing out rounds until one results in a winner. Finally, appends the
	 * round information to the game log.
	 */
	public void playRound() {
		RoundSummary round;
		boolean roundFinished = false;
		do {
			round = evaluateRound(); //evaluate round
			updateThrower(round);
			roundFinished = !round.isTie();
		} while (!roundFinished);
		appendToLog(round);
	}
	
	/**
	 * Prints a summary of the entire game, in the form of a player win/loss table.
	 */
	public void printGameSummary() {
		//Print game summary
		log.printLog();
	}
	
	/**
	 * Welcomes the player and shows the game instructions.
	 */
	public void welcomePlayer() {
		//Print welcome text/rules
		talker.printWelcomeMessage();
		talker.printRulesMessage();
	}
	
	/**
	 * Prints information pertaining to the current round.
	 * @param roundNumber the number of the current round.
	 */
	public void printCurrentRound(int roundNumber) {
		talker.printCurrentRound(roundNumber);
	}
	
	private RoundSummary evaluateRound() {
		Throw playerThrow = getPlayerThrow(); //ask player action
		Throw computerThrow = getComputerThrow(); //Choose computer action
		RoundSummary round = getRoundSummary(computerThrow, playerThrow);
		printRoundSummary(round);
		return round;
	}
	
	private Throw getPlayerThrow() {
		return talker.getPlayerThrow();
	}
	
	private RoundSummary getRoundSummary(Throw computerThrow, Throw playerThrow) {
		return Referee.getRoundSummary(computerThrow, playerThrow);
	}
	
	private void initialize() {
		initializeLog();
		initializeThrower();
		initializeTalker();
	}
	
	private void initializeLog() {
		log = new Log();
	}
	
	private void initializeThrower() {
		thrower = new AIThrower();
	}
	
	private void initializeTalker() {
		talker = new Talker();
	}
	
	private Throw getComputerThrow() {
		return thrower.getComputerThrow();
	}
	
	private void appendToLog(RoundSummary round) {
		log.appendRound(round);
	}
	private void updateThrower(RoundSummary round) {
		thrower.learn(round);
	}
	
	private void printRoundSummary(RoundSummary round) {
		talker.printRoundSummary(round);
	}
	
	private static Log log;
	private static Talker talker;
	private static Thrower thrower;
}

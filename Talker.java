/**
 * Handles all requests to print to the console or read from user input.
 * Reading user input is facilitated through the auxiliary <code>Reader</code> class.
 * Calls the static <code>Summarizer</code> class to print round summary.
 * 
 * @author Jose A. Ramos
 *
 */

public class Talker {
	
	/**
	 * Instantiates the <code>Talker</code> object's <code>Reader</code> field.
	 */
	public Talker() {
		this.reader = new Reader();
	}
	
	/**
	 * Prints a request to the player, reads their input, and returns their throw.
	 * 
	 * @return the player's valid input throw
	 */
	public Throw getPlayerThrow() {
		printPlayerThrowRequest();
		Throw playerThrow = readPlayerThrow();
		return playerThrow;
	}
	
	/**
	 * Prints a summary of what ocurred in a given round. 
	 * Calls the static <code>Summarizer</code> class.
	 * 
	 * @param round container for round outcome and throws
	 */
	public void printRoundSummary(RoundSummary round) {
		SummaryPrinter.printRoundSummary(round);
	}
	
	
	/**
	 * Prints a message welcoming the player.
	 */
	public void printWelcomeMessage() {
		System.out.println(WELCOME_MESSAGE);
	}
	
	/**
	 * Prints the instructions of the game.
	 */
	public void printRulesMessage() {
		System.out.println(RULES_MESSAGE);
	}
	
	/**
	 * Prints information pertaining to the current round.
	 * @param roundNumber the number of the current round.
	 */
	public void printCurrentRound(int roundNumber) {
		System.out.println(String.format("Round: %d", roundNumber));
	}
	
	private void printPlayerThrowRequest() {
		System.out.println(PLAYER_THROW_REQUEST);
	}
	
	private Throw readPlayerThrow() {
		char playerThrowChar = reader.readPlayerThrowChar();
		return new Throw(playerThrowChar);
	}
	
	private static final String PLAYER_THROW_REQUEST = "Enter move (r, p, s):";
	private static final String WELCOME_MESSAGE = "Welcome to RPS!";
	private static final String RULES_MESSAGE = "Type a character representing a move when prompted. "
												+ "Press Enter to play it.\n"
												+ "Valid characters: r, p, s\n"
												+ "r beats s\ns beats p\np beats r\n";
	
	private Reader reader;
}

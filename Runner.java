	/**
 * This is the class that runs the RPS program. 
 * It contains the <code>main</code> method.
 * 
 * <br><br>
 * 
 * <b>Step 1:</b>
 * 
 * <br><br>
 * 
 * 1) The original text for the initial instructions read: <br>
 * <i>"Type a throw character when prompted. Press Enter to play it."</i> <br>
 * The user made two suggestions:
 * <ul>
 * 		<li> Replace "throw" by "move".</li>
 * 		<li> Replace the term "throw character" by "character that represents a move".</li>
 * </ul> 
 * These changes were implemented. Also added was a list of valid characters, and which move beats which.
 * 
 * <br><br>
 * 
 * 2) Mostly. There was a bit of confusion at first with the use of pronouns. "I win" was initially read
 * by the user as a win on their part. The user immediatedly caught their mistake, however. We replace the 
 * pronouns "I" and "You" with the more informative "Computer" and "Player", respectively.
 * 
 * <br><br>
 * 
 * 3) The user was (jokingly) very audibly excited or angry at the results of a round. Though joking, nevertheless,
 * the round result messages were substantial enough to elicit such a reaction. For example: <i>"HAHA GET F***ED"</i>
 * in response to <i>"You win! rock smashes scissors"</i>. 
 * 
 * <br><br>
 * 
 * 4) The user, having had experience with other RPS programs, suggested a wait time inbetween user input and
 * the calculation of the round outcome. This adds a feeling of suspense. Given the large number of rounds, 
 * however, I decided to forego this functionality.
 * 
 * <br><br>
 * 
 * 5) B
 * 
 * <b>Step 2:</b>
 * 
 * <br><br>
 * 
 * 1) Mostly, but didn't specify that adding space to input doesn't work
 * 
 * <br><br>
 * 
 * 2) Responsive, user had no comments.
 * 
 * <br><br>
 * 
 * 3) The user was surprised that capital letters didn't work as valid moves.
 * 
 * <br><br>
 * 
 * 4) The user asked for some way to keep track of player score per round.
 * 
 * <br><br>
 * 
 * 5) B
 * 
 * 
 * @author Jose A. Ramos
 *
 */

public class Runner {
	
	/**
	 * Runs the RPS program.
	 * 
	 * At first, initializes all fields.
	 * 
	 * Second, welcomes the player. Printed are a welcome message and the 
	 * game instructions.
	 * 
	 * Thirdly, enters a loop that runs <code>TOTAL_ROUNDS</code> number of times.
	 * This constant is set to 100. On each loop, it prints the current round 
	 * number, and plays out the round.
	 * 
	 * After the loop ends, the game is over, and a summary of the game is printed.
	 * This summary takes the form of a table. For example:
	 * 
	 * <pre>	r   p   s   Tot 
	 *            ----------------
	 *         r|   0  18 -20  -2
	 *Computer p| -17   0  12  -5
	 *         s|  15 -18   0  -3
	 *      Tot |  -2   0  -8 -10/100
	 * </pre>
	 * 
	 * @param args flags
	 */
	public static void main(String[] args) {
		welcomePlayer(); //welcome player
		for (int i = 1; i <= TOTAL_ROUNDS; i++) { //go through each round
			printCurrentRound(i);
			playRound(); 
		}
		printGameSummary();
	}
	
	private static void playRound() {
		controller.playRound();
	}
	
	private static void welcomePlayer() {
		controller.welcomePlayer();
	}
	
	
	private static void printGameSummary() {
		controller.printGameSummary();
	}
	
	private static void printCurrentRound(int round) {
		controller.printCurrentRound(round);
	}

	private static final int TOTAL_ROUNDS = 100;
	private static Controller controller = new Controller();
	
}

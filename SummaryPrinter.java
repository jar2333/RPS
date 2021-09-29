/**
 * Contains method for printing the summary of a round outcome.
 * 
 * @author Jose A. Ramos
 *
 */
public class SummaryPrinter {
	
	/**
	 *Prints a tie message if the round resulted in a tie. 
	 *Prints a win message if the round resulted in a winner. 
	 *The message is constructed based on player and computer throws.
	 * 
	 * @param round container for round outcome and throws
	 */
	public static void printRoundSummary(RoundSummary round) {
		if (round.isTie()) {
			printTieMessage();
		}
		else {
			printWinMessage(round);
		}
	}
	
	private static void printTieMessage() {
		System.out.println(TIE_MESSAGE);
	}
	
	private static void printWinMessage(RoundSummary round) {
		String winMessage = constructWinMessage(round);
		System.out.println(winMessage);
	}
	
	private static String constructWinMessage(RoundSummary round) {
		String winnerPronoun = getWinnerPronoun(round);
		String winnerAndLoserInteraction = getWinnerAndLoserInteraction(round);
		String winMessage = String.format("%s wins! %s.", winnerPronoun, winnerAndLoserInteraction);
		return winMessage;
	}
	
	private static String getWinnerPronoun(RoundSummary round) {
		if (round.isComputerWin()) {
			return COMPUTER_NOUN;
		}
		else {
			return PLAYER_NOUN;
		}
	}

	private static String getWinnerAndLoserInteraction(RoundSummary round) {
		//CLEANUP!!!
		Throw computerThrow = round.getComputerThrow();
		Throw playerThrow = round.getPlayerThrow();
		
		String interactionVerb = getInteractionVerb(computerThrow, playerThrow);
		
		String computerThrowName = computerThrow.getThrowName();
		String playerThrowName = playerThrow.getThrowName();
		
		String winnerThrowName;
		String loserThrowName;
		if (round.isComputerWin()) {
			winnerThrowName = computerThrowName;
			loserThrowName = playerThrowName;
		}
		else {
			winnerThrowName = playerThrowName;
			loserThrowName = computerThrowName;
		}
		String winnerAndLoserInteraction = String.format("%s %s %s", winnerThrowName, interactionVerb, loserThrowName);
		return winnerAndLoserInteraction;
	}
	
	private static String getInteractionVerb(Throw computerThrow, Throw playerThrow) {
		int computerThrowIndex = computerThrow.getThrowIndex(); //any better than static conversion methods?
		int playerThrowIndex = playerThrow.getThrowIndex();
		String interactionVerb = INTERACTION_VERBS[computerThrowIndex + playerThrowIndex - 1];
		return interactionVerb;
	}
	
	private static final String TIE_MESSAGE = "Tie!";
	private static final String[] INTERACTION_VERBS = {"covers", "smashes", "cuts"};
	private static final String COMPUTER_NOUN = "Computer";
	private static final String PLAYER_NOUN = "Player";
}

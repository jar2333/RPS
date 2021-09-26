
public class Runner {
	
	static final int TOTAL_ROUNDS = 100;
	static Log log;
	
	public static void main(String[] args) {
		welcomePlayer(); //welcome player
		initializeLog(); //initialize object to keep track of wins/losses
		for (int round = 1; round <= TOTAL_ROUNDS; round++) { //go through each round
			playRound(); 
		}
		printGameSummary();
	}
	
	private static void playRound() {
		boolean roundFinished = false;
		while (!roundFinished) {
			//Choose computer action
				//Throw computerThrow = Thrower.getComputerThrow();
			//ask player action
				//Throw playerThrow = Talker.getPlayerThrow();
			
			//evaluate round
				//RoundResult roundResult = Referee.getRoundResult(computerThrow, playerThrow);
				//Log.appendRoundResult(roundResult); abstract this somehow
			
				//Talker.printRoundMessage(roundResult);
				//roundFinished = !roundResult.isTie();
		}
	}
	
	private static void welcomePlayer() {
		//Print welcome text/rules
		Talker.printWelcomeMessage();
		Talker.printRulesMessage();
	}
	
	private static void initializeLog() {
		log = new Log();
	}
	
	private static void printGameSummary() {
		//Print game summary
		//Log.printGameTable();
	}

}

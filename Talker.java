import java.util.Scanner;

public class Talker {
	
	private static final String WELCOME_MESSAGE = "Welcome to RPS!";
	private static final String RULES_MESSAGE = "";
	private static final String PLAYER_THROW_REQUEST = "Enter throw (r, p, s):";
	private static final String TIE_MESSAGE = "Tie!";
	
	private static final String[] THROW_INTERACTIONS = {"covers", "cuts", "smashes"};
	private static final String[] WINNER_OPTIONS = {"I", "You"};
	
	public static Throw getPlayerThrow() {
		printPlayerThrowRequest();
		Throw playerThrow = readPlayerThrow();
		return playerThrow;
	}
	
	public static void printRoundMessage(RoundResult roundResult) {
		if (roundResult.isTie()) {
			printTieMessage();
		}
		else {
			printWinMessage(roundResult);
		}
	}
	
	public static void printWelcomeMessage() {
		System.out.println(WELCOME_MESSAGE);
	}
	
	public static void printRulesMessage() {
		System.out.println(RULES_MESSAGE);
	}
	
	private static void printPlayerThrowRequest() {
		System.out.println(PLAYER_THROW_REQUEST);
	}
	
	private static Throw readPlayerThrow() {
		char playerThrowChar = Reader.readPlayerThrowChar();
		return new Throw(playerThrowChar);
	}
	
	private static void printTieMessage() {
		System.out.println(TIE_MESSAGE);
	}
	
	private static void printWinMessage(RoundResult roundResult) {
		String winMessage = constructWinMessage(roundResult);
		System.out.println(winMessage);
	}
	
	private static String constructWinMessage(RoundResult roundResult) {
		//clean this up!!!!!!!!!!!!!!!!!!!!!!
		Throw computerThrow = roundResult.getComputerThrow();
		Throw playerThrow = roundResult.getPlayerThrow();
		int result = roundResult.getResult();
		
		String[] throwNames = {computerThrow.getThrowName(), playerThrow.getThrowName()};
		
		String winner;
		String winnerThrowName;
		String interaction;
		String loserThrowName;
		
		winner = WINNER_OPTIONS[result];
		winnerThrowName = throwNames[result];
		loserThrowName = throwNames[result ^ 1];
		
		int computerThrowIndex = computerThrow.getThrowIndex();
		int playerThrowIndex = playerThrow.getThrowIndex();
		interaction = THROW_INTERACTIONS[computerThrowIndex + playerThrowIndex];
		
		String winMessage = String.format("%s win! %s %s %s.", 
				winner, winnerThrowName, interaction, loserThrowName);
		
		return winMessage;
	}
}

class Reader {
	private static final String INVALID_INPUT_MESSAGE = "Invalid input! Try again:";
	
	private static Scanner scanner;
	
	public static char readPlayerThrowChar() {
		initializeScanner();
		String scannedThrow = scanPlayerThrow();
		while (!isValidScannedThrow(scannedThrow)) {
			printInvalidInputMessage();
			scannedThrow = scanPlayerThrow();
		}
		closeScanner();
		char playerThrow = getThrowChar(scannedThrow);
		return playerThrow;
	}
	
	
	private static boolean isValidScannedThrow(String scannedThrow) {
		return isChar(scannedThrow) && isValidThrow(scannedThrow);
	}
	
	private static boolean isValidThrow(String scannedThrow) {
		char throwChar = getThrowChar(scannedThrow);
		return Throw.isValidThrow(throwChar);
	}
	
	private static boolean isChar(String scannedThrow) {
		return scannedThrow.length() == 1;
	}
	
	private static void printInvalidInputMessage() {
		System.out.println(INVALID_INPUT_MESSAGE);
	}
	
	private static String scanPlayerThrow() {
		String scannedThrow = scanner.nextLine();
		return scannedThrow;
	}
	
	private static char getThrowChar(String scannedThrow) {
		return scannedThrow.charAt(0);
	}
	
	private static void initializeScanner() {
		scanner = new Scanner(System.in);
	}
	
	private static void closeScanner() {
		scanner.close();
	}
}

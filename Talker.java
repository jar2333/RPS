import java.util.Scanner;

public class Talker {
	
	private static final String WELCOME_MESSAGE = "Welcome to RPS!";
	private static final String RULES_MESSAGE = "";
	private static final String PLAYER_THROW_REQUEST = "Enter throw (r, p, s):";
	
	public static char getPlayerThrow() {
		printPlayerThrowRequest();
		char playerThrow = Reader.readPlayerThrow();
		return playerThrow;
	}
	
	public static void printRoundMessage(char computerThrow, char playerThrow) {
		
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
	
}

class Reader {
	private static final String INVALID_INPUT_MESSAGE = "Invalid input! Try again:";
	
	private static Scanner scanner;
	
	public static char readPlayerThrow() {
		scanner = new Scanner(System.in);
		String scannedThrow = scanner.nextLine();
		while (!isValidScannedThrow(scannedThrow)) {
			printInvalidInputMessage();
			scannedThrow = scanner.nextLine();
		}
		scanner.close();
		char playerThrow = scannedThrow.charAt(0);
		return playerThrow;
	}
	
	private static boolean isValidScannedThrow(String scannedThrow) {
		return isChar(scannedThrow) && isValidThrow(scannedThrow);
	}
	
	private static boolean isValidThrow(String scannedThrow) {
		char throwChar = scannedThrow.charAt(0);
		return Throw.isValidThrow(throwChar);
	}
	
	private static boolean isChar(String scannedThrow) {
		return scannedThrow.length() == 1;
	}
	
	private static void printInvalidInputMessage() {
		System.out.println(INVALID_INPUT_MESSAGE);
	}
}

import java.util.Scanner;

/**
 * Reads and checks validity of user inputs. 
 * 
 * @author Jose A. Ramos
 *
 */
public class Reader {
	
	/**
	 * Initializes <code>Scanner</code> field.
	 */
	public Reader() {
		initializeScanner();
	}
	
	/**
	 * Scans user input, checks validity of input, returns the valid input <code>char</code>.
	 * If input is invalid, prints message informing the player of the invalidity, and scans input again.
	 * 
	 * @return a valid input <code>char</code> representing player's throw
	 */
	public char readPlayerThrowChar() {
		String scannedThrow = scanPlayerThrow();
		while (!isValidScannedThrow(scannedThrow)) {
			printInvalidInputMessage();
			scannedThrow = scanPlayerThrow();
		}
		char playerThrowChar = getThrowChar(scannedThrow);
		return playerThrowChar;
	}
	
	
	private boolean isValidScannedThrow(String scannedThrow) {
		return isChar(scannedThrow) && isValidThrow(scannedThrow);
	}
	
	private boolean isValidThrow(String scannedThrow) {
		char throwChar = getThrowChar(scannedThrow);
		return Throw.isValidThrow(throwChar);
	}
	
	private boolean isChar(String scannedThrow) {
		return scannedThrow.length() == 1;
	}
	
	private void printInvalidInputMessage() {
		System.out.println(INVALID_INPUT_MESSAGE);
	}
	
	private String scanPlayerThrow() {
		String scannedThrow = scanner.nextLine();
		return scannedThrow;
	}
	
	private char getThrowChar(String scannedThrow) {
		return scannedThrow.charAt(0);
	}
	
	private void initializeScanner() {
		scanner = new Scanner(System.in);
	}
	
	private static final String INVALID_INPUT_MESSAGE = "Invalid input! Try again:";
	
	private static Scanner scanner;
}

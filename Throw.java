
class Throw {
	
	public static final char ROCK = 'r';
	public static final char PAPER = 'p';
	public static final char SCISSORS = 's';

	public static String parseCharToString(char t) {
		if (t == ROCK) {
			return "rock";
		}
		else if (t == PAPER) {
			return "paper";
		}
		else if (t == SCISSORS) {
			return "scissors";
		}
		else {
			return null;
		}
	}
	
	public static boolean isValidThrow(char t) {
		return t == ROCK || t == PAPER || t == SCISSORS;
	}
	
}


class Throw {
	
	public static final char ROCK = 'r';
	public static final char PAPER = 'p';
	public static final char SCISSORS = 's';
	
	public static final int NUMBER_OF_THROWS = 3;
	
	private static final char[] THROWS = {ROCK, PAPER, SCISSORS};
	
	private char throwType;
	private String throwName;
	private int throwIndex;
	
	public Throw(char type) {
		if (isValidThrow(type)) { //redundant check?
			this.throwType = type;
			this.throwName = parseCharToString(type);
			this.throwIndex = parseCharToInt(type);			
		}
		//else?
	}
	
	public char getThrowType() {
		return this.throwType;
	}
	
	public String getThrowName() {
		return this.throwName;
	}
	
	public int getThrowIndex() {
		return this.throwIndex;
	}

	public static String parseCharToString(char t) { //when cases >= 5, lookup table if switch
		switch (t) {
		case ROCK:
			return "rock";
		case PAPER:
			return "paper";
		case SCISSORS:
			return "scissors";
		default:
			return null;
		}
	}
	
	public static int parseCharToInt(char t) {
		switch (t) {
		case ROCK:
			return 0;
		case PAPER:
			return 1;
		case SCISSORS:
			return 2;
		default:
			return -1;
		}
	}
	
	public static char parseIntToChar(int t) {
		if (0 <= t && t <= NUMBER_OF_THROWS) {
			return THROWS[t];
		}
		return 0;
	}
	
	
	public static boolean isValidThrow(char t) {
		return t == ROCK || t == PAPER || t == SCISSORS;
	}
	
}

/**
 * Encapsulates the different representations for a throw:
 * <ul> 
 * 		<li><code>char</code> representation (throw type)</li> 
 * 		<li><code>String</code> representation (throw name)</li>
 * 		<li><code>int</code> representation (throw index)</li>
 * </ul>
 * Contains static methods to process the different representations for throws, and constants for each throw.
 * 
 * @author Jose A. Ramos
 *
 */
class Throw {
	
	/**
	 * Constructs a <code>Throw</code> object from a given throw type.
	 * Parses the <code>char</code> to store the <code>String</code> and <code>int</code> representations.
	 * 
	 * @param type The type of throw, given by a <code>char</code>
	 * @throws IllegalArgumentException When input <code>char</code> does not represent a throw
	 */
	public Throw(char type) throws IllegalArgumentException {
		if (isValidThrow(type)) {
			this.throwType = type;
			this.throwName = parseCharToString(type);
			this.throwIndex = parseCharToInt(type);			
		}
		else {
			throw new IllegalArgumentException();
		}
		
	}
	
	/**
	 * Parses an <code>int</code> that represents a throw, and constructs the corresponding <code>Throw</code> object.
	 * 
	 * @param index
	 */
	public Throw(int index) {
		this(parseIntToChar(index));
	}
	
	/**
	 * Gets the type of the throw.
	 * 
	 * @return the throw's type
	 */
	public char getThrowType() {
		return this.throwType;
	}
	
	/**
	 * Gets the name of the throw.
	 * 
	 * @return the throw's name
	 */
	public String getThrowName() {
		return this.throwName;
	}
	
	/**
	 * Gets the index of the throw.
	 * 
	 * @return the throw's index
	 */
	public int getThrowIndex() {
		return this.throwIndex;
	}

	/**
	 * Parses a throw type to return the corresponding throw's name.
	 * 
	 * @param t a throw type
	 * @return the corresponding throw name
	 * @throws IllegalArgumentException input is not a valid throw type
	 */
	public static String parseCharToString(char t) throws IllegalArgumentException { 
		switch (t) {
			case ROCK:
				return "rock";
			case PAPER:
				return "paper";
			case SCISSORS:
				return "scissors";
			default:
				throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Parses a throw type to return the corresponding throw's index.
	 * 
	 * @param t a throw type
	 * @return the corresponding throw index
	 * @throws IllegalArgumentException input is not a valid throw type
	 */
	public static int parseCharToInt(char t) throws IllegalArgumentException {
		switch (t) {
			case ROCK:
				return 0;
			case PAPER:
				return 1;
			case SCISSORS:
				return 2;
			default:
				throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Parses a throw index to return the corresponding throw's type.
	 * 
	 * @param t a throw index
	 * @return the corresponding throw type
	 * @throws IllegalArgumentException input is not a valid throw index
	 */
	public static char parseIntToChar(int i) throws IllegalArgumentException {
		if (0 <= i && i <= NUMBER_OF_THROWS) {
			return THROWS[i];
		}
		throw new IllegalArgumentException();
	}
	
	/**
	 * Determines if a given <code>char</code> is a valid throw type.
	 * 
	 * @param t
	 * @return
	 */
	public static boolean isValidThrow(char t) {
		return t == ROCK || t == PAPER || t == SCISSORS;
	}
	
	/**
	 * constant throw type for ROCK
	 */
	public static final char ROCK = 'r';
	/**
	 * constant throw type for PAPER
	 */
	public static final char PAPER = 'p';
	/**
	 * constant throw type for SCISSORS
	 */
	public static final char SCISSORS = 's';
	/**
	 * number of distinct throw types
	 */
	public static final int NUMBER_OF_THROWS = 3;
	
	private static final char[] THROWS = {ROCK, PAPER, SCISSORS};
	private char throwType;
	private String throwName;
	private int throwIndex;
	
}

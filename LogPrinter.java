/**
 * Used for printing the data in <code>Log</code>
 * 
 * @author Jose A. Ramos
 *
 */
public class LogPrinter {
	
	/**
	 * Instantiates <code>LogPrinter</code> with given win/loss table and number of rounds played
	 * @param table the player win/loss data
	 * @param roundsPlayed rounds played so far
	 */
	public LogPrinter(int[][] table, int roundsPlayed) {
		this.gameTable = table;
		this.DIMENSION = table.length;
		this.roundsPlayed = roundsPlayed;
	}
	
	/**
	 * Prints the win/loss table
	 */
	public void printGameTable() {
		System.out.println(generateGameTable());
	}
	
	private String generateGameTable() {
		String header = generateHeader();
		String separator = generateSeparator();
		String allRows = generateAllRows();
		String footer = generateFooter();
		String gameTable = header + separator + allRows + footer;
		return gameTable;
	}
	
	private String generateHeader() {
		String header = ROW_INDENTATION;
		for (int i = 0; i < DIMENSION / 2; i++) {
			header += TABLESPACE;
		}
		header += PLAYER + NEWLINE;
		header += ROW_INDENTATION + SINGLESPACE;
		for (int i = 0; i < Throw.NUMBER_OF_THROWS; i++) {
			char throwChar = Throw.parseIntToChar(i);
			header += TABLESPACE + throwChar;
		}
		header += TABLESPACE + TOTAL + NEWLINE;
		return header;
	}
	
	private String generateSeparator() {
		String separator = ROW_INDENTATION + TABLESPACE;
		for (int i = 0; i < DIMENSION; i++) {
			separator += HORIZONTAL_SEPARATOR;
		}
		separator += NEWLINE;
		return separator;
	}
	
	private String generateAllRows() {
		String allRows = "";
		for (int i = 0; i < Throw.NUMBER_OF_THROWS; i++) {
			String row = generateRow(i);
			allRows += row;
		}
		return allRows;
	}
	
	private String generateFooter() {
		String footer = FOOTER_INDENTATION + TOTAL + VERTICAL_SEPARATOR;
		footer += generateRowEntries(DIMENSION - 1);
		footer += "/" + roundsPlayed + NEWLINE;
		return footer;
	}
	
	private String generateRow(int rowIndex) {
		String row = generateRowIndent(rowIndex);
		char rowChar = Throw.parseIntToChar(rowIndex);
		row += rowChar + VERTICAL_SEPARATOR;
		row += generateRowEntries(rowIndex) + NEWLINE;
		return row;
	}
	
	private String generateRowEntries(int rowIndex) {
		String entries = "";
		for (int column = 0; column < DIMENSION; column++) {
			String tableEntry = String.valueOf(getEntry(rowIndex, column));
			String space = generateSpaceBetweenEntries(tableEntry);
			entries += space + tableEntry;
		}
		return entries;
	}
	
	private String generateSpaceBetweenEntries(String tableEntry) {
		String space = "";
		int tableEntryLength = tableEntry.length();
		for (int i = 0; i <= 3 - tableEntryLength; i++) { //remaining space
			space += SINGLESPACE;
		}
		return space;
	}
	
	private String generateRowIndent(int rowIndex) {
		String indent;
		if (rowIndex == (DIMENSION / 2) - 1) {
			indent = COMPUTER;
		}
		else {
			indent = ROW_INDENTATION;
		}
		return indent;
	}
	
	private int getEntry(int i, int j) {
		return gameTable[i][j];
	}
	
	private final String PLAYER = "Player";
	private final String COMPUTER = "Computer ";
	private final String ROW_INDENTATION = "         ";
	private final String FOOTER_INDENTATION = "      ";
	private final String TABLESPACE = "   ";
	private final String SINGLESPACE = " ";
	private final String HORIZONTAL_SEPARATOR = "----";
	private final String VERTICAL_SEPARATOR = "|";
	private final String TOTAL = "Tot ";
	private final String NEWLINE = "\n";
	
	int[][] gameTable;
	int DIMENSION;
	int roundsPlayed;
}
